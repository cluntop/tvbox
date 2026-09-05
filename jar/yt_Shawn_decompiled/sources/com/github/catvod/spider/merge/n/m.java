package com.github.catvod.spider.merge.n;

import android.app.AlertDialog;
import android.view.View;
import com.github.catvod.spider.TempServer;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ AlertDialog b;
    public final /* synthetic */ TempServer c;

    public /* synthetic */ m(AlertDialog alertDialog, TempServer tempServer, int i) {
        this.a = i;
        this.b = alertDialog;
        this.c = tempServer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws InterruptedException {
        int i = this.a;
        TempServer tempServer = this.c;
        AlertDialog alertDialog = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                alertDialog.dismiss();
                tempServer.stop();
                break;
            case 1:
                boolean z2 = Youtube.e;
                alertDialog.dismiss();
                tempServer.stop();
                break;
            case 2:
                boolean z3 = Youtube.e;
                alertDialog.dismiss();
                tempServer.stop();
                break;
            default:
                boolean z4 = Youtube.e;
                alertDialog.dismiss();
                tempServer.stop();
                break;
        }
    }
}
