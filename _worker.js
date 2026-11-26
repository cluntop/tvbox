/**
 * EMOS 反代 Worker
 * 规范来源: https://wiki.emos.best/proxy.html
 *
 * 覆盖要点:
 *  - 视频服 video.emos.best  -> /emby
 *  - 音乐服 music.emos.best  -> /rest, /navidrome
 *  - 听书服 abs.emos.best    -> /audiobookshelf, /abs
 *  - 必须传 EMOS-PROXY-ID / EMOS-PROXY-NAME / X-Forwarded-For
 *  - 必须原样透传 206 与 Range (拖动进度)
 *  - 缓存 /emby/Items/*\/Images/* 与 /emby/System/Ping
 *  - 节流 /emby/Sessions/Playing/Progress
 *  - 分流域名 *.sharepoint.cn|com, *.emosstore.sbs|cfd, *.eeew.eu.org
 */

const CONFIG = {
  // 可用环境变量覆盖: EMOS_PROXY_ID / EMOS_PROXY_NAME
  proxyId: "eV9706YEZs",
  proxyName: "@cluntop",

  targetProtocol: "https:",

  // 对外前缀 -> 上游主机；upstreamPrefix 用于把别名前缀改写成上游真实前缀
  routes: [
    { prefix: "/emby", upstream: "video.emos.best" },
    { prefix: "/rest", upstream: "music.emos.best" },
    { prefix: "/navidrome", upstream: "music.emos.best" },
    { prefix: "/audiobookshelf", upstream: "abs.emos.best" },
    // 别名：/abs/* 实际对应上游 /audiobookshelf/*
    { prefix: "/abs", upstream: "abs.emos.best", upstreamPrefix: "/audiobookshelf" },
  ],

  // 媒体流特征：需 Range/206 与外部重定向跟随
  streamRegex:
    /(\/Videos\/|\/Items\/[^/]+\/(Download|Stream|File)|\/Audio\/|\/rest\/(stream|download)|\/api\/items\/[^/]+\/file)/i,
  fixedVideoRegex: /\/emby\/emya\/video/i,

  // 缓存策略
  imageRegex: /\/emby\/Items\/[^/]+\/Images(\/|$)/i,
  imageCacheTtl: 2592000, // 30 天
  pingRegex: /\/emby\/System\/Ping/i,
  pingCacheTtl: 86400,

  // 播放进度节流
  progressRegex: /\/Sessions\/Playing\/Progress/i,
  progressForwardRate: 0.3,

  // 外链重定向跟随（仅白名单域名 + 媒体流）
  followExternalRedirect: true,
  externalHosts: [
    /(^|\.)sharepoint\.cn$/i,
    /(^|\.)sharepoint\.com$/i,
    /(^|\.)emosstore\.sbs$/i,
    /(^|\.)emosstore\.cfd$/i,
    /(^|\.)eeew\.eu\.org$/i,
    /(^|\.)emos\.best$/i,
  ],

  maxSubrequests: 4,

  retry: {
    enabled: true,
    maxAttempts: 2,
    retryMethods: ["GET", "HEAD"],
    retryStatuses: [500, 502, 503, 504, 520, 521, 522, 523, 524, 525, 526, 527],
  },

  // 未命中反代路径时交给静态资源（Pages/Workers Assets）
  serveAssetsOnMiss: true,

  // 遗留路径 -> 自动补 /emby 前缀再反代
  // 例: /system -> /emby/system ; /System/Info/Public -> /emby/System/Info/Public
  // 只匹配这些前缀本身或其子路径，不做全局兜底
  legacyPrefixes: ["/system"],
};

const HOP_BY_HOP = [
  "connection",
  "keep-alive",
  "proxy-authenticate",
  "proxy-authorization",
  "te",
  "trailer",
  "transfer-encoding",
];

function createBudget() {
  return { remaining: CONFIG.maxSubrequests };
}

async function fetchWithRetry(budget, buildRequest, method, reserve = 0) {
  const canRetry = CONFIG.retry.enabled && CONFIG.retry.retryMethods.includes(method);
  const maxAttempts = canRetry ? CONFIG.retry.maxAttempts : 1;

  let lastResponse = null;
  let lastError = null;

  for (let attempt = 1; attempt <= maxAttempts; attempt++) {
    const isRetry = attempt > 1;
    if (budget.remaining <= (isRetry ? reserve : 0)) break;
    budget.remaining--;

    try {
      const response = await fetch(buildRequest());
      if (!CONFIG.retry.retryStatuses.includes(response.status)) return response;
      lastResponse = response;
      lastError = null;
    } catch (e) {
      lastError = e;
      lastResponse = null;
    }
  }

  if (lastResponse) return lastResponse;
  throw lastError || new Error("Subrequest budget exhausted");
}

function matchRoute(pathname) {
  const lower = pathname.toLowerCase();

  // 1) 正常前缀路由
  const route = CONFIG.routes.find(
    r => lower === r.prefix || lower.startsWith(r.prefix + "/")
  );
  if (route) return { route, path: pathname, legacy: false };

  // 2) 遗留路径: /system -> /emby/system（仅限 legacyPrefixes）
  if (
    CONFIG.legacyPrefixes.some(p => lower === p || lower.startsWith(p + "/")) &&
    pathname !== "/"
  ) {
    const embyRoute = CONFIG.routes.find(r => r.prefix === "/emby");
    if (embyRoute) {
      return { route: embyRoute, path: "/emby" + pathname, legacy: true };
    }
  }

  return null;
}

function emosHeaders(proxyId, proxyName) {
  return {
    "EMOS-PROXY-ID": proxyId,
    "EMOS-PROXY-NAME": proxyName,
  };
}

function isAllowedExternal(hostname) {
  return CONFIG.externalHosts.some(re => re.test(hostname));
}

async function cacheMatch(request) {
  if (request.method !== "GET") return null;
  if (typeof caches === "undefined" || !caches.default) return null;
  try {
    return await caches.default.match(request);
  } catch {
    return null;
  }
}

function cachePut(ctx, request, response) {
  if (typeof caches === "undefined" || !caches.default) return;
  try {
    const p = caches.default.put(request, response);
    if (ctx && typeof ctx.waitUntil === "function") ctx.waitUntil(p);
    else p.catch(() => {});
  } catch {
    /* 缓存失败不影响主链路 */
  }
}

function stripCookieDomain(resHeaders, response) {
  let cookies = [];
  try {
    if (typeof response.headers.getSetCookie === "function") {
      cookies = response.headers.getSetCookie();
    }
  } catch {
    cookies = [];
  }
  if (!cookies.length) return;
  // 去掉 Domain，让 Cookie 落到反代域名上
  resHeaders.delete("Set-Cookie");
  cookies.forEach(c => resHeaders.append("Set-Cookie", c.replace(/;\s*Domain=[^;]*/gi, "")));
}

function appendVary(headers, value) {
  const cur = headers.get("Vary");
  if (!cur) {
    headers.set("Vary", value);
    return;
  }
  const parts = cur.split(",").map(s => s.trim().toLowerCase());
  if (!parts.includes(value.toLowerCase())) headers.set("Vary", `${cur}, ${value}`);
}

function withCors(request, headers) {
  const origin = request.headers.get("Origin");
  headers.set("Access-Control-Allow-Origin", origin || "*");
  if (origin) {
    appendVary(headers, "Origin");
    headers.set("Access-Control-Allow-Credentials", "true");
  }
  headers.set(
    "Access-Control-Expose-Headers",
    "Content-Range, Accept-Ranges, Content-Length, Content-Encoding, ETag, " +
      "EMOS-PROXY-ID, EMOS-PROXY-NAME, X-Emby-Token"
  );
}

export default {
  async fetch(request, env, ctx) {
    const url = new URL(request.url);

    const matched = matchRoute(url.pathname);

    // 非反代路径：静态资源 / 404
    if (!matched) {
      if (CONFIG.serveAssetsOnMiss) {
        if (env && env.ASSETS && typeof env.ASSETS.fetch === "function") {
          return env.ASSETS.fetch(request);
        }
        return fetch(request);
      }
      return new Response("Not Found", { status: 404 });
    }

    const route = matched.route;

    // 遗留路径命中: /system -> /emby/system
    // GET/HEAD 用 302 跳转；其它方法(如登录 POST)内部改写，避免 302 把 POST 变 GET
    if (matched.legacy) {
      const target = new URL(matched.path + url.search, url.origin).toString();
      if (request.method === "GET" || request.method === "HEAD") {
        return Response.redirect(target, 302);
      }
      url.pathname = matched.path;
    }

    const proxyId = (env && env.EMOS_PROXY_ID) || CONFIG.proxyId;
    const proxyName = (env && env.EMOS_PROXY_NAME) || CONFIG.proxyName;
    const emos = emosHeaders(proxyId, proxyName);

    // CORS 预检
    if (request.method === "OPTIONS") {
      const h = new Headers(emos);
      withCors(request, h);
      h.set("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
      h.set(
        "Access-Control-Allow-Headers",
        request.headers.get("Access-Control-Request-Headers") || "*"
      );
      h.set("Access-Control-Max-Age", "86400");
      return new Response(null, { status: 204, headers: h });
    }

    // 进度上报节流：多数直接 204，少量真实转发
    if (request.method === "POST" && CONFIG.progressRegex.test(url.pathname)) {
      if (Math.random() >= CONFIG.progressForwardRate) {
        return new Response(null, {
          status: 204,
          headers: { ...emos, "Cache-Control": "no-store" },
        });
      }
    }

    const upstreamHost = route.upstream;
    const isFixedVideo = CONFIG.fixedVideoRegex.test(url.pathname);
    const isStream = isFixedVideo || CONFIG.streamRegex.test(url.pathname);
    const isImage = CONFIG.imageRegex.test(url.pathname);
    const isPing = CONFIG.pingRegex.test(url.pathname);

    const useCache = (isImage || isPing) && !request.headers.has("Range");
    if (useCache) {
      const hit = await cacheMatch(request);
      if (hit) return hit;
    }

    try {
      const upstreamUrl = new URL(url.toString());
      upstreamUrl.hostname = upstreamHost;
      upstreamUrl.protocol = CONFIG.targetProtocol;

      if (route.upstreamPrefix && upstreamUrl.pathname.startsWith(route.prefix)) {
        let rest = upstreamUrl.pathname.slice(route.prefix.length);
        if (rest && !rest.startsWith("/")) rest = "/" + rest;
        upstreamUrl.pathname = route.upstreamPrefix + rest;
      }

      const upstreamHeaders = new Headers(request.headers);
      HOP_BY_HOP.forEach(h => upstreamHeaders.delete(h));
      ["host", "cf-connecting-ip", "cf-ipcountry", "cf-ray", "cf-visitor"].forEach(h =>
        upstreamHeaders.delete(h)
      );

      upstreamHeaders.set("Referer", `${CONFIG.targetProtocol}//${upstreamHost}/`);
      upstreamHeaders.set("Origin", `${CONFIG.targetProtocol}//${upstreamHost}`);
      upstreamHeaders.set("EMOS-PROXY-ID", proxyId);
      upstreamHeaders.set("EMOS-PROXY-NAME", proxyName);

      // wiki：必须传递 X-Forwarded-For
      const clientIp =
        request.headers.get("cf-connecting-ip") ||
        request.headers.get("x-real-ip") ||
        (request.headers.get("x-forwarded-for") || "").split(",")[0].trim();
      if (clientIp) {
        const xff = request.headers.get("x-forwarded-for");
        upstreamHeaders.set(
          "X-Forwarded-For",
          xff && !xff.startsWith(clientIp) ? `${xff}, ${clientIp}` : clientIp
        );
        upstreamHeaders.set("X-Real-IP", clientIp);
      }
      upstreamHeaders.set("X-Forwarded-Proto", "https");
      upstreamHeaders.set("X-Forwarded-Host", url.host);

      let reqBody = request.body;
      const isUpload = /\/Upload/i.test(url.pathname);
      if (!["GET", "HEAD"].includes(request.method) && !isUpload) {
        try {
          reqBody = await request.arrayBuffer();
          upstreamHeaders.delete("content-length");
        } catch {
          reqBody = request.body;
        }
      }

      const buildUpstreamRequest = () =>
        new Request(upstreamUrl.toString(), {
          method: request.method,
          headers: upstreamHeaders,
          body: reqBody,
          redirect: "manual",
        });

      const budget = createBudget();
      let response = await fetchWithRetry(
        budget,
        buildUpstreamRequest,
        request.method,
        isFixedVideo ? 1 : 0
      );

      // ---- 重定向 ----
      if ([301, 302, 303, 307, 308].includes(response.status)) {
        const location = response.headers.get("Location");
        if (location) {
          const locUrl = new URL(location, upstreamUrl.href);
          const sameUpstream = locUrl.hostname === upstreamHost;
          const external = isAllowedExternal(locUrl.hostname);
          const followIt =
            isFixedVideo || (CONFIG.followExternalRedirect && external && isStream);

          if (followIt) {
            const driveHeaders = new Headers();
            ["Range", "Accept", "Accept-Encoding"].forEach(h => {
              const v = request.headers.get(h);
              if (v) driveHeaders.set(h, v);
            });
            driveHeaders.set(
              "User-Agent",
              request.headers.get("User-Agent") ||
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                  "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            );
            if (clientIp) driveHeaders.set("X-Forwarded-For", clientIp);
            response = await fetchWithRetry(
              budget,
              () =>
                new Request(locUrl.toString(), {
                  method: request.method,
                  headers: driveHeaders,
                  redirect: "follow",
                }),
              request.method,
              0
            );
          } else if (sameUpstream) {
            // 同源重定向：Location 改写回反代域名
            const h = new Headers(response.headers);
            HOP_BY_HOP.forEach(x => h.delete(x));
            let locPath = locUrl.pathname;
            // 反向还原 upstreamPrefix 别名（如 /audiobookshelf/* -> /abs/*）
            if (route.upstreamPrefix && locPath.startsWith(route.upstreamPrefix)) {
              locPath = route.prefix + locPath.slice(route.upstreamPrefix.length);
            }
            h.set("Location", `${url.origin}${locPath}${locUrl.search}`);
            Object.entries(emos).forEach(([k, v]) => h.set(k, v));
            return new Response(response.body, {
              status: response.status,
              statusText: response.statusText,
              headers: h,
            });
          } else {
            // 外链但不跟随：原样返回 3xx，保留 Location
            const h = new Headers(response.headers);
            Object.entries(emos).forEach(([k, v]) => h.set(k, v));
            return new Response(null, { status: response.status, headers: h });
          }
        }
      }

      // ---- 响应头 ----
      const resHeaders = new Headers(response.headers);
      HOP_BY_HOP.forEach(h => resHeaders.delete(h));
      stripCookieDomain(resHeaders, response);
      [
        "Content-Security-Policy",
        "X-Frame-Options",
        "Strict-Transport-Security",
        "X-Content-Type-Options",
      ].forEach(h => resHeaders.delete(h));

      Object.entries(emos).forEach(([k, v]) => resHeaders.set(k, v));
      withCors(request, resHeaders);

      // 206 必须保留 Content-Range / Accept-Ranges
      if (response.status === 206 && !resHeaders.has("Accept-Ranges")) {
        resHeaders.set("Accept-Ranges", "bytes");
      }
      if (isStream) {
        resHeaders.set("Cache-Control", resHeaders.get("Cache-Control") || "private, no-transform");
      }
      if (isImage) resHeaders.set("Cache-Control", `public, max-age=${CONFIG.imageCacheTtl}`);
      if (isPing && response.status === 200) {
        resHeaders.set("Cache-Control", `public, max-age=${CONFIG.pingCacheTtl}`);
      }

      if (response.status === 101) {
        return new Response(null, {
          status: 101,
          webSocket: response.webSocket,
          headers: resHeaders,
        });
      }

      // 缓存写入：仅 200 的图片 / Ping
      if (useCache && response.status === 200 && request.method === "GET") {
        const cacheable = new Response(response.clone().body, {
          status: response.status,
          headers: resHeaders,
        });
        cachePut(ctx, request, cacheable);
      }

      return new Response(response.body, {
        status: response.status,
        statusText: response.statusText,
        headers: resHeaders,
      });
    } catch (e) {
      const msg = e instanceof Error ? e.message : String(e);
      return new Response(JSON.stringify({ error: `Proxy Error: ${msg}` }), {
        status: 502,
        headers: { "Content-Type": "application/json; charset=utf-8", ...emos },
      });
    }
  },
};