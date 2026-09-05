package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Youtube b;
    public final /* synthetic */ String c;

    public /* synthetic */ a0(Youtube youtube, String str, int i) {
        this.a = i;
        this.b = youtube;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws NumberFormatException {
        int i = this.a;
        String str = this.c;
        Youtube youtube = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                youtube.h(str);
                SettingsUI.refreshCategory();
                break;
            case 1:
                boolean z2 = Youtube.e;
                youtube.h(str);
                SettingsUI.refreshCategory();
                break;
            default:
                boolean z3 = Youtube.e;
                SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", str, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube, 1), new p(9));
                break;
        }
    }
}
