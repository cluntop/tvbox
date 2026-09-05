package com.github.catvod.spider.merge.n;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import com.github.catvod.spider.SettingsUI;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ KeyEvent.Callback b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(KeyEvent.Callback callback, Object obj, int i) {
        this.a = i;
        this.b = callback;
        this.c = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        Object obj = this.c;
        KeyEvent.Callback callback = this.b;
        switch (i2) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                SettingsUI.Callback callback2 = (SettingsUI.Callback) obj;
                String strTrim = ((EditText) callback).getText().toString().trim();
                if (callback2 != null) {
                    callback2.onResult(strTrim);
                    break;
                }
                break;
            case 1:
                SettingsUI.Callback callback3 = (SettingsUI.Callback) obj;
                String strTrim2 = ((EditText) callback).getText().toString().trim();
                if (callback3 != null) {
                    callback3.onResult(strTrim2);
                    break;
                }
                break;
            default:
                ((ClipboardManager) ((Activity) callback).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("日志", (String) obj));
                com.github.catvod.spider.merge.g1.a.e("已复制到剪贴板");
                break;
        }
    }
}
