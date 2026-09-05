package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements Runnable {
    public final /* synthetic */ int a;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("内核安装完成，正在启动...");
                break;
            default:
                boolean z2 = Youtube.e;
                ClashCore.deleteKernel();
                Init.post(new p(11));
                break;
        }
    }
}
