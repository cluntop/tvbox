package com.github.catvod.spider.merge.n;

import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr;
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                InputStream inputStream = (InputStream) this.b;
                FileOutputStream fileOutputStream = (FileOutputStream) this.c;
                String str = ClashCore.a;
                try {
                    bArr = new byte[8192];
                } catch (Throwable unused) {
                }
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i > 0) {
                        fileOutputStream.write(bArr, 0, i);
                        fileOutputStream.flush();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    try {
                        inputStream.close();
                        break;
                    } catch (Throwable unused3) {
                        return;
                    }
                }
            case 1:
                AlertDialog alertDialog = (AlertDialog) this.b;
                EditText editText = (EditText) this.c;
                try {
                    final Button button = alertDialog.getButton(-1);
                    final Button button2 = alertDialog.getButton(-2);
                    button.setFocusable(true);
                    button.setFocusableInTouchMode(false);
                    button2.setFocusable(true);
                    button2.setFocusableInTouchMode(false);
                    if (editText.getId() == -1) {
                        editText.setId(View.generateViewId());
                    }
                    if (button.getId() == -1) {
                        button.setId(View.generateViewId());
                    }
                    if (button2.getId() == -1) {
                        button2.setId(View.generateViewId());
                    }
                    editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.github.catvod.spider.merge.n.f
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                            if (keyEvent.getAction() == 0) {
                                return (i2 == 20 || i2 == 22) ? button2.requestFocus() : i2 == 21 && button.requestFocus();
                            }
                            return false;
                        }
                    });
                    editText.setNextFocusDownId(button2.getId());
                    editText.setNextFocusRightId(button2.getId());
                    button2.setNextFocusLeftId(button.getId());
                    button2.setNextFocusUpId(editText.getId());
                    button.setNextFocusRightId(button2.getId());
                    button.setNextFocusUpId(editText.getId());
                    break;
                } catch (Throwable unused4) {
                    return;
                }
            case 2:
                List list = (List) this.b;
                Runnable runnable = (Runnable) this.c;
                boolean z = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("已获取 " + list.size() + " 个节点，启动代理后可测速");
                if (runnable != null) {
                    runnable.run();
                }
                SettingsUI.refreshCategory();
                break;
            default:
                Exception exc = (Exception) this.b;
                Runnable runnable2 = (Runnable) this.c;
                boolean z2 = Youtube.e;
                com.github.catvod.spider.merge.g1.a.e("拉取失败：" + exc.getMessage());
                if (runnable2 != null) {
                    runnable2.run();
                    break;
                }
                break;
        }
    }
}
