package com.github.catvod.spider.merge.n;

import android.app.AlertDialog;
import com.github.catvod.spider.Youtube;
import java.util.List;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("已获取 " + ((List) obj).size() + " 个节点，正在重启内核 ...");
                break;
            default:
                boolean z2 = Youtube.e;
                AlertDialog alertDialog = ((AlertDialog[]) obj)[0];
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                com.github.catvod.spider.merge.g1.a.e("未收到搜索数据或超时");
                break;
        }
    }
}
