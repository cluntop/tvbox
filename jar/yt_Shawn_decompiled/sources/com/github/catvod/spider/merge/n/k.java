package com.github.catvod.spider.merge.n;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ KeyEvent.Callback b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(KeyEvent.Callback callback, Object obj, int i) {
        this.a = i;
        this.b = callback;
        this.c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        Object obj = this.c;
        KeyEvent.Callback callback = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                try {
                    ((ClipboardManager) ((Activity) callback).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("验证码", (String) obj));
                    com.github.catvod.spider.merge.g1.a.e("已复制验证码");
                    break;
                } catch (Throwable unused) {
                    com.github.catvod.spider.merge.g1.a.e("复制失败");
                    return;
                }
            case 1:
                Activity activity = (Activity) callback;
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) obj));
                    intent.addFlags(268435456);
                    activity.startActivity(intent);
                    break;
                } catch (Throwable unused2) {
                    com.github.catvod.spider.merge.g1.a.e("无法打开浏览器，请复制网址到手机");
                    return;
                }
            default:
                ImageView imageView = (ImageView) callback;
                Button button = (Button) obj;
                boolean z = Youtube.e;
                if (imageView.getVisibility() != 0) {
                    imageView.setVisibility(0);
                    button.setText("隐藏二维码");
                    break;
                } else {
                    imageView.setVisibility(8);
                    button.setText("显示二维码");
                    break;
                }
        }
    }
}
