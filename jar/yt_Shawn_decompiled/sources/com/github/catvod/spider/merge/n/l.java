package com.github.catvod.spider.merge.n;

import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ KeyEvent.Callback b;

    public /* synthetic */ l(KeyEvent.Callback callback, int i) {
        this.a = i;
        this.b = callback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        KeyEvent.Callback callback = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                ImageView imageView = (ImageView) callback;
                imageView.setVisibility(imageView.getVisibility() == 0 ? 8 : 0);
                break;
            case 1:
                ImageView imageView2 = (ImageView) callback;
                boolean z = Youtube.e;
                imageView2.setVisibility(imageView2.getVisibility() == 0 ? 8 : 0);
                break;
            case 2:
                ImageView imageView3 = (ImageView) callback;
                boolean z2 = Youtube.e;
                imageView3.setVisibility(imageView3.getVisibility() == 0 ? 8 : 0);
                break;
            case 3:
                ImageView imageView4 = (ImageView) callback;
                boolean z3 = Youtube.e;
                imageView4.setVisibility(imageView4.getVisibility() == 0 ? 8 : 0);
                break;
            default:
                ((AlertDialog) callback).dismiss();
                break;
        }
    }
}
