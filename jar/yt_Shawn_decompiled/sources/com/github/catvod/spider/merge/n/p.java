package com.github.catvod.spider.merge.n;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import com.google.gson.JsonObject;
import java.util.HashMap;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ p(int i) {
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        int i = 2;
        int i2 = 1;
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                while (System.currentTimeMillis() < Youtube.x) {
                    try {
                        Thread.sleep(Youtube.y * 1000);
                        String str = "client_id=" + Youtube.T(Youtube.o) + "&client_secret=" + Youtube.T(Youtube.p) + "&code=" + Youtube.T(Youtube.u) + "&grant_type=" + Youtube.T("http://oauth.net/grant_type/device/1.0");
                        HashMap map = new HashMap();
                        map.put("Content-Type", "application/x-www-form-urlencoded");
                        String strA0 = Youtube.A0("https://www.youtube.com/o/oauth2/token", str, map);
                        JsonObject jsonObjectH = com.github.catvod.spider.merge.o.d.h(strA0);
                        if (jsonObjectH.has("access_token")) {
                            Youtube.r = jsonObjectH.get("access_token").getAsString();
                            Youtube.s = jsonObjectH.has("refresh_token") ? jsonObjectH.get("refresh_token").getAsString() : Youtube.s;
                            long asLong = jsonObjectH.has("expires_in") ? jsonObjectH.get("expires_in").getAsLong() : 3600L;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            Long.signum(asLong);
                            Youtube.t = (1000 * asLong) + jCurrentTimeMillis;
                            Youtube.H = true;
                            Youtube.Y0();
                            SpiderDebug.log("[YouTube] oauth login ok, expiresIn=" + asLong);
                            Init.post(new p(i));
                            break;
                        } else if (jsonObjectH.has("error")) {
                            String asString = jsonObjectH.get("error").getAsString();
                            if (!"authorization_pending".equals(asString) && !"slow_down".equals(asString)) {
                                SpiderDebug.log("[YouTube] oauth poll error=" + asString + " resp=" + strA0);
                                Init.post(new r(asString, i2));
                                break;
                            }
                        }
                    } catch (Exception e) {
                        com.github.catvod.spider.merge.b.b.x(e, new StringBuilder("[YouTube] pollOauthToken error: "));
                        return;
                    }
                }
                Init.post(new p(3));
                break;
            case 1:
                String strX0 = Youtube.X0();
                Init.post(new u(strX0, Youtube.V(strX0), 0));
                break;
            case 2:
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("OAuth 登录成功");
                SettingsUI.refreshCategory();
                break;
            case 3:
                boolean z3 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("OAuth 验证超时，请重试");
                break;
            case 4:
                boolean z4 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("测速完成");
                SettingsUI.refreshCategory();
                break;
            case 5:
                Init.post(new r(Youtube.F(), 6));
                break;
            case 6:
                boolean zI1 = Youtube.i1();
                Youtube.H = zI1;
                Youtube.Y0();
                Init.post(new d0(i2, zI1));
                break;
            case 7:
                String strX02 = Youtube.X0();
                Init.post(new u(strX02, Youtube.V(strX02), i));
                break;
            case 8:
                Youtube.H = Youtube.i1();
                Youtube.Y0();
                SpiderDebug.log("[YouTube] set:cookie verified=" + Youtube.H);
                Init.post(new p(25));
                break;
            case 9:
                boolean z5 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("已取消启动");
                break;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                boolean z6 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("YouTube IP 风控，无法播放，请换个节点再尝试播放");
                break;
            case 11:
                boolean z7 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("内核已删除（约释放 20MB 空间）");
                SettingsUI.refreshCategory();
                break;
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                boolean z8 = Youtube.e;
                Youtube.E = ClashCore.start() ? "socks5://127.0.0.1:31600" : VideoStream.RESOLUTION_UNKNOWN;
                Youtube.i();
                Youtube.Y0();
                break;
            case 13:
                boolean z9 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("OAuth 初始化失败：无法获取 client_id");
                break;
            case 14:
                SettingsUI.oauth(Youtube.w, Youtube.v);
                break;
            case 15:
                boolean z10 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("OAuth 请求失败，请重试");
                break;
            case 16:
                boolean z11 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法获取本机IP，请检查WiFi连接");
                break;
            case 17:
                boolean z12 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法启动服务器，所有端口都被占用");
                break;
            case 18:
                boolean z13 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("内核重启失败，查看日志");
                break;
            case 19:
                boolean z14 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("内核已重启，正在测速 ...");
                break;
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                boolean z15 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("已取消启动");
                break;
            case 21:
                boolean z16 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法获取本机IP，请检查WiFi连接");
                break;
            case 22:
                boolean z17 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法启动服务器，所有端口都被占用");
                break;
            case 23:
                boolean z18 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法获取本机IP，请检查WiFi连接");
                break;
            case 24:
                boolean z19 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法启动服务器，所有端口都被占用");
                break;
            case 25:
                com.github.catvod.spider.merge.g1.a.e(Youtube.H ? "登录成功" : "Cookie 无效，未登录");
                SettingsUI.refreshCategory();
                break;
            case 26:
                boolean z20 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("无法启动服务器，所有端口都被占用");
                break;
            case 27:
                boolean z21 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("二维码扫码搜索失败");
                break;
            case 28:
                boolean z22 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("未检测到内核，开始下载（约20MB）...");
                break;
            default:
                boolean z23 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("下载失败，请选择其他镜像");
                break;
        }
    }
}
