package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Exception b;

    public /* synthetic */ e0(Exception exc, int i) {
        this.a = i;
        this.b = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Exception exc = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("OAuth 请求失败：" + exc.getMessage());
                break;
            case 1:
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("启动失败：" + exc.getMessage());
                break;
            case 2:
                boolean z3 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("启动失败：" + exc.getMessage());
                break;
            default:
                boolean z4 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("启动失败：" + exc.getMessage());
                break;
        }
    }
}
