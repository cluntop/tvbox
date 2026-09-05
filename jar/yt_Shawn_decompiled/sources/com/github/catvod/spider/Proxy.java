package com.github.catvod.spider;

import com.github.catvod.crawler.SpiderDebug;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Proxy {
    public static Method a;
    public static int b;

    public static int getPort() {
        if (b <= 0) {
            init();
        }
        return b;
    }

    public static String getUrl(boolean z) {
        try {
            return (String) a.invoke(null, Boolean.valueOf(z));
        } catch (Throwable unused) {
            return "http://127.0.0.1:" + b + "/proxy";
        }
    }

    public static void init() {
        try {
            Class<?> cls = Class.forName("com.github.catvod.Proxy");
            b = ((Integer) cls.getMethod("getPort", null).invoke(null, null)).intValue();
            a = cls.getMethod("getUrl", Boolean.TYPE);
            SpiderDebug.log("本地代理端口:" + b);
        } catch (Throwable unused) {
            if (b > 0) {
                return;
            }
            for (int i = 8964; i < 9999; i++) {
                if ("ok".equals(com.github.catvod.spider.merge.g1.a.f("http://127.0.0.1:" + i + "/proxy?do=ck", null))) {
                    SpiderDebug.log("本地代理端口:" + i);
                    b = i;
                    return;
                }
            }
        }
    }

    public static Object[] proxy(Map<String, String> map) {
        if ("ck".equals(map.get("do"))) {
            return new Object[]{200, "text/plain; charset=utf-8", new ByteArrayInputStream("ok".getBytes(StandardCharsets.UTF_8))};
        }
        return null;
    }

    public static String getUrl() {
        return getUrl(true);
    }

    public static String getUrl(String str, String str2) {
        return com.github.catvod.spider.merge.b.b.A("proxy://do=csp&siteKey=", str, str2);
    }
}
