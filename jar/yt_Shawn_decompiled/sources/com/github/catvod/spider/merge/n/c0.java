package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import java.util.List;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ c0(Runnable runnable, int i) {
        this.a = i;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Runnable runnable = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                try {
                    List<String> listFetchNodes = ClashCore.fetchNodes();
                    if (ClashCore.isRunning()) {
                        Init.post(new g0(0, listFetchNodes));
                        if (ClashCore.start()) {
                            Init.post(new p(19));
                            ClashCore.testAllNodes(new c0(runnable, 1));
                        } else {
                            Init.post(new p(18));
                        }
                    } else {
                        Init.post(new a(2, listFetchNodes, runnable));
                    }
                    break;
                } catch (Exception e) {
                    Init.post(new a(3, e, runnable));
                    return;
                }
            default:
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("测速完成");
                if (runnable != null) {
                    runnable.run();
                }
                SettingsUI.refreshCategory();
                break;
        }
    }
}
