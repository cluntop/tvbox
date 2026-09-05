package com.github.catvod.spider.merge.n;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.github.catvod.spider.SettingsUI;
import java.io.File;
import java.util.ArrayList;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ KeyEvent.Callback c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(Object obj, KeyEvent.Callback callback, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = callback;
        this.d = obj2;
        this.e = obj3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        Object obj = this.e;
        Object obj2 = this.d;
        KeyEvent.Callback callback = this.c;
        Object obj3 = this.b;
        switch (i2) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                Activity activity = (Activity) callback;
                SettingsUI.Callback callback2 = (SettingsUI.Callback) obj2;
                Runnable runnable = (Runnable) obj;
                File file = (File) ((ArrayList) obj3).get(i);
                dialogInterface.dismiss();
                if (!file.isDirectory()) {
                    if (callback2 != null) {
                        callback2.onResult(file.getAbsolutePath());
                        break;
                    }
                } else {
                    SettingsUI.b(activity, file.getAbsolutePath(), callback2, runnable);
                    break;
                }
                break;
            default:
                RadioButton[] radioButtonArr = (RadioButton[]) obj2;
                SettingsUI.SearchCallback searchCallback = (SettingsUI.SearchCallback) obj;
                String strTrim = ((EditText) obj3).getText().toString().trim();
                int checkedRadioButtonId = ((RadioGroup) callback).getCheckedRadioButtonId();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 < radioButtonArr.length) {
                        if (radioButtonArr[i4].getId() == checkedRadioButtonId) {
                            i3 = i4;
                        } else {
                            i4++;
                        }
                    }
                }
                if (searchCallback != null) {
                    searchCallback.onSearch(strTrim, i3);
                    break;
                }
                break;
        }
    }
}
