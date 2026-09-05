package com.github.catvod.spider.merge.n;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.Youtube;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Random;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ r(Youtube youtube, String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String asString;
        int i = this.a;
        final int iTestDelay = -1;
        final int i2 = 0;
        final int i3 = 1;
        final String str = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                if ("DIRECT".equals(str)) {
                    if (ClashCore.isRunning()) {
                        iTestDelay = ClashCore.testDelay("DIRECT");
                    }
                } else if (ClashCore.isRunning()) {
                    iTestDelay = ClashCore.testDelay(str);
                }
                final boolean zX0 = Youtube.x0();
                Init.post(new Runnable() { // from class: com.github.catvod.spider.merge.n.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i4 = i2;
                        String strK = "测速失败";
                        boolean z2 = zX0;
                        String str2 = str;
                        int i5 = iTestDelay;
                        switch (i4) {
                            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                                boolean z3 = Youtube.e;
                                if (i5 >= 0) {
                                    strK = com.github.catvod.spider.merge.b.b.k(i5, "延迟 ", " ms");
                                } else if ("DIRECT".equals(str2) && !ClashCore.isRunning()) {
                                    strK = "直连（无代理）";
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(Stream.ID_UNKNOWN);
                                sb.append(strK);
                                sb.append("，Google: ");
                                sb.append(z2 ? "可达" : "不可达");
                                com.github.catvod.spider.merge.g1.a.e(sb.toString());
                                break;
                            default:
                                boolean z4 = Youtube.e;
                                if (i5 >= 0) {
                                    strK = com.github.catvod.spider.merge.b.b.k(i5, "延迟 ", " ms");
                                } else if ("DIRECT".equals(str2) && !ClashCore.isRunning()) {
                                    strK = "直连（无代理）";
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append(Stream.ID_UNKNOWN);
                                sb2.append(strK);
                                sb2.append("，Google: ");
                                sb2.append(z2 ? "可达" : "不可达");
                                com.github.catvod.spider.merge.g1.a.e(sb2.toString());
                                break;
                        }
                    }
                });
                break;
            case 1:
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("OAuth 失败：" + str);
                break;
            case 2:
                boolean z3 = Youtube.e;
                Init.post(new b0(ClashCore.switchNode(str), str));
                break;
            case 3:
                boolean z4 = Youtube.e;
                String strG1 = Youtube.g1(str.trim());
                Init.post(new u(strG1, Youtube.V(strG1), i3));
                break;
            case 4:
                boolean z5 = Youtube.e;
                if ("DIRECT".equals(str)) {
                    if (ClashCore.isRunning()) {
                        iTestDelay = ClashCore.testDelay("DIRECT");
                    }
                } else if (ClashCore.isRunning()) {
                    iTestDelay = ClashCore.testDelay(str);
                }
                final boolean zX02 = Youtube.x0();
                Init.post(new Runnable() { // from class: com.github.catvod.spider.merge.n.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i4 = i3;
                        String strK = "测速失败";
                        boolean z22 = zX02;
                        String str2 = str;
                        int i5 = iTestDelay;
                        switch (i4) {
                            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                                boolean z32 = Youtube.e;
                                if (i5 >= 0) {
                                    strK = com.github.catvod.spider.merge.b.b.k(i5, "延迟 ", " ms");
                                } else if ("DIRECT".equals(str2) && !ClashCore.isRunning()) {
                                    strK = "直连（无代理）";
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(Stream.ID_UNKNOWN);
                                sb.append(strK);
                                sb.append("，Google: ");
                                sb.append(z22 ? "可达" : "不可达");
                                com.github.catvod.spider.merge.g1.a.e(sb.toString());
                                break;
                            default:
                                boolean z42 = Youtube.e;
                                if (i5 >= 0) {
                                    strK = com.github.catvod.spider.merge.b.b.k(i5, "延迟 ", " ms");
                                } else if ("DIRECT".equals(str2) && !ClashCore.isRunning()) {
                                    strK = "直连（无代理）";
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append(Stream.ID_UNKNOWN);
                                sb2.append(strK);
                                sb2.append("，Google: ");
                                sb2.append(z22 ? "可达" : "不可达");
                                com.github.catvod.spider.merge.g1.a.e(sb2.toString());
                                break;
                        }
                    }
                });
                break;
            case 5:
                boolean z6 = Youtube.e;
                String str2 = "videostatsPlaybackUrl";
                try {
                    String strConcat = "https://www.youtube.com/watch?v=".concat(str);
                    HashMap map = new HashMap();
                    map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                    JsonObject jsonObjectA0 = Youtube.a0(Youtube.y0(strConcat, map));
                    if (jsonObjectA0.has("playbackTracking")) {
                        JsonObject asJsonObject = jsonObjectA0.getAsJsonObject("playbackTracking");
                        if (!asJsonObject.has("videostatsPlaybackUrl")) {
                            str2 = "videostatsWatchtimeUrl";
                        }
                        JsonElement jsonElement = asJsonObject.get(str2);
                        if (jsonElement != null && !jsonElement.isJsonNull()) {
                            if (jsonElement.isJsonObject()) {
                                JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
                                asString = (!asJsonObject2.has("baseUrl") || asJsonObject2.get("baseUrl").isJsonNull()) ? VideoStream.RESOLUTION_UNKNOWN : asJsonObject2.get("baseUrl").getAsString();
                            } else {
                                asString = jsonElement.getAsString();
                            }
                            if (asString.isEmpty()) {
                                SpiderDebug.log("[YouTube] reportWatch: empty baseUrl");
                                break;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                Random random = new Random();
                                for (int i4 = 0; i4 < 16; i4++) {
                                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(random.nextInt(64)));
                                }
                                String string = sb.toString();
                                String str3 = asString + (asString.contains("?") ? "&" : "?") + "ver=2&cpn=" + string + "&cmt=0&el=detailpage";
                                HashMap map2 = new HashMap();
                                map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                                map2.put("Referer", "https://www.youtube.com/watch?v=" + str);
                                String strC1 = Youtube.c1();
                                if (!strC1.isEmpty()) {
                                    map2.put("Authorization", strC1);
                                }
                                SpiderDebug.log("[YouTube] reportWatch url=" + str3.substring(0, Math.min(100, str3.length())) + " respLen=" + Youtube.y0(str3, map2).length());
                                break;
                            }
                        }
                        SpiderDebug.log("[YouTube] reportWatch: no playbackUrl");
                        break;
                    } else {
                        SpiderDebug.log("[YouTube] reportWatch: no playbackTracking");
                        break;
                    }
                } catch (Exception e) {
                    com.github.catvod.spider.merge.b.b.x(e, new StringBuilder("[YouTube] reportWatch error: "));
                    return;
                }
                break;
            case 6:
                boolean z7 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e(str);
                break;
            case 7:
                boolean z8 = Youtube.e;
                String strG12 = Youtube.g1(str.trim());
                Init.post(new u(strG12, Youtube.V(strG12), 3));
                break;
            case 8:
                boolean z9 = Youtube.e;
                ClashCore.setLocalFile(str);
                Youtube.Y0();
                break;
            case 9:
                boolean z10 = Youtube.e;
                ClashCore.setLocalFile(str);
                com.github.catvod.spider.merge.g1.a.e("已取消启动");
                break;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                com.github.catvod.spider.merge.g1.a.e(str);
                break;
            default:
                com.github.catvod.spider.merge.g1.a.e(str);
                break;
        }
    }

    public /* synthetic */ r(String str, int i) {
        this.a = i;
        this.b = str;
    }
}
