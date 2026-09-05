package com.github.catvod.spider.merge.n;

import android.content.DialogInterface;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ d(Runnable runnable, int i) {
        this.a = i;
        this.b = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        Runnable runnable = this.b;
        switch (i2) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                dialogInterface.dismiss();
                runnable.run();
                break;
            case 1:
                if (runnable != null) {
                    runnable.run();
                    break;
                }
                break;
            default:
                if (runnable != null) {
                    runnable.run();
                    break;
                }
                break;
        }
    }
}
