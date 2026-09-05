package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b0(Youtube youtube, boolean z, StringBuilder sb) {
        this.b = z;
        this.c = sb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Object obj = this.c;
        boolean z = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                String str = (String) obj;
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e((z ? "已切换节点：" : "切换失败：").concat(str));
                SettingsUI.refreshCategory();
                break;
            default:
                StringBuilder sb = (StringBuilder) obj;
                boolean z3 = Youtube.e;
                if (z) {
                    Youtube.E = "socks5://127.0.0.1:31600";
                    Youtube.Y0();
                    Youtube.i();
                    com.github.catvod.spider.merge.g1.a.e("代理已启动");
                } else {
                    SettingsUI.show("内核启动失败", sb.length() > 0 ? sb.toString() : "内核启动失败（未知原因）");
                }
                SettingsUI.refreshCategory();
                break;
        }
    }

    public /* synthetic */ b0(boolean z, String str) {
        this.b = z;
        this.c = str;
    }
}
