package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ d0(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        boolean z = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e(z ? "内核已重新下载完成，请重新「启动代理」" : "重新下载失败，请更换镜像或检查网络");
                SettingsUI.refreshCategory();
                break;
            default:
                boolean z3 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e(z ? "已登录 YouTube（Cookie 有效）" : "未登录（Cookie 无效或网络不可达）");
                SettingsUI.refreshCategory();
                break;
        }
    }
}
