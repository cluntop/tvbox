package com.github.catvod.spider.merge.o;

import android.text.TextUtils;
import android.widget.Toast;
import com.github.catvod.spider.Init;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;

    public c(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.github.catvod.spider.merge.g1.a aVar = d.a;
        String str = this.a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = (Toast) aVar.a;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(Init.context(), str, 1);
        aVar.a = toastMakeText;
        toastMakeText.show();
    }
}
