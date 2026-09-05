package com.github.catvod.spider.merge.n;

import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import com.github.catvod.spider.SettingsUI;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ SettingsUI.QRCallback b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ AlertDialog d;

    public /* synthetic */ g(SettingsUI.QRCallback qRCallback, EditText editText, AlertDialog alertDialog, int i) {
        this.a = i;
        this.b = qRCallback;
        this.c = editText;
        this.d = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        AlertDialog alertDialog = this.d;
        EditText editText = this.c;
        SettingsUI.QRCallback qRCallback = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                qRCallback.onQRClick(editText, alertDialog);
                break;
            default:
                qRCallback.onQRClick(editText, alertDialog);
                break;
        }
    }
}
