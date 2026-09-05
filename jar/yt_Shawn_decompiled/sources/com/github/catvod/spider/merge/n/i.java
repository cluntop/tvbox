package com.github.catvod.spider.merge.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.TempServer;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ i(AlertDialog alertDialog, SettingsUI.QRCallback qRCallback, EditText editText) {
        this.b = alertDialog;
        this.c = qRCallback;
        this.d = editText;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException, NumberFormatException {
        int i = this.a;
        TempServer tempServer = null;
        Object obj = this.d;
        Object obj2 = this.c;
        Object obj3 = this.b;
        int i2 = 1;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                AlertDialog alertDialog = (AlertDialog) obj3;
                SettingsUI.QRCallback qRCallback = (SettingsUI.QRCallback) obj2;
                EditText editText = (EditText) obj;
                try {
                    final Button button = alertDialog.getButton(-1);
                    final Button button2 = alertDialog.getButton(-2);
                    final Button button3 = qRCallback != null ? alertDialog.getButton(-3) : null;
                    button.setFocusable(true);
                    button.setFocusableInTouchMode(false);
                    button2.setFocusable(true);
                    button2.setFocusableInTouchMode(false);
                    if (button3 != null) {
                        button3.setFocusable(true);
                        button3.setFocusableInTouchMode(false);
                    }
                    if (editText.getId() == -1) {
                        editText.setId(View.generateViewId());
                    }
                    if (button.getId() == -1) {
                        button.setId(View.generateViewId());
                    }
                    if (button2.getId() == -1) {
                        button2.setId(View.generateViewId());
                    }
                    if (button3 != null && button3.getId() == -1) {
                        button3.setId(View.generateViewId());
                    }
                    if (qRCallback != null && button3 != null) {
                        button3.setOnClickListener(new g(qRCallback, editText, alertDialog, 1));
                    }
                    editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.github.catvod.spider.merge.n.j
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                            if (keyEvent.getAction() != 0) {
                                return false;
                            }
                            if (i3 != 20 && i3 != 22) {
                                return i3 == 21 && button.requestFocus();
                            }
                            Button button4 = button3;
                            return (button4 != null && button4.requestFocus()) || button2.requestFocus();
                        }
                    });
                    if (button3 != null) {
                        editText.setNextFocusDownId(button3.getId());
                        editText.setNextFocusRightId(button3.getId());
                        button3.setNextFocusLeftId(button2.getId());
                        button3.setNextFocusRightId(button.getId());
                        button3.setNextFocusUpId(editText.getId());
                        button2.setNextFocusLeftId(button3.getId());
                        button2.setNextFocusRightId(button.getId());
                        button2.setNextFocusUpId(editText.getId());
                        button.setNextFocusLeftId(button2.getId());
                        button.setNextFocusUpId(editText.getId());
                        break;
                    } else {
                        editText.setNextFocusDownId(button2.getId());
                        editText.setNextFocusRightId(button2.getId());
                        button2.setNextFocusLeftId(button.getId());
                        button2.setNextFocusUpId(editText.getId());
                        button.setNextFocusRightId(button2.getId());
                        button.setNextFocusUpId(editText.getId());
                        break;
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 1:
                Youtube youtube = (Youtube) obj2;
                String str = (String) obj;
                final AlertDialog alertDialog2 = (AlertDialog) obj3;
                boolean z = Youtube.e;
                int i3 = 6800;
                while (true) {
                    if (i3 <= 6810) {
                        try {
                            TempServer tempServer2 = new TempServer(i3, "search_input.html");
                            try {
                                tempServer2.start();
                                tempServer = tempServer2;
                            } catch (Exception unused2) {
                                tempServer = tempServer2;
                            }
                        } catch (Exception unused3) {
                        }
                    } else {
                        i3 = -1;
                    }
                    i3++;
                }
                try {
                    if (i3 == -1) {
                        Init.post(new p(26));
                        break;
                    } else {
                        String str2 = Utils.HTTP + str + ":" + i3;
                        SpiderDebug.log("[YouTube] QR scan server started for search: " + str2);
                        final AlertDialog[] alertDialogArr = new AlertDialog[1];
                        Init.post(new i(youtube, tempServer, str2, alertDialogArr));
                        String strWaitForUrl = tempServer.waitForUrl(60000L);
                        tempServer.stop();
                        if (strWaitForUrl == null || !strWaitForUrl.startsWith("SEARCH:")) {
                            Init.post(new g0(i2, alertDialogArr));
                            break;
                        } else {
                            String[] strArrSplit = strWaitForUrl.split("\\|");
                            final String strSubstring = VideoStream.RESOLUTION_UNKNOWN;
                            final int i4 = 0;
                            for (String str3 : strArrSplit) {
                                if (str3.startsWith("SEARCH:")) {
                                    strSubstring = str3.substring(7);
                                } else if (str3.startsWith("TYPE:")) {
                                    try {
                                        i4 = Integer.parseInt(str3.substring(5));
                                    } catch (Exception unused4) {
                                    }
                                }
                            }
                            Init.post(new Runnable() { // from class: com.github.catvod.spider.merge.n.h0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    boolean z2 = Youtube.e;
                                    AlertDialog alertDialog3 = alertDialogArr[0];
                                    if (alertDialog3 != null) {
                                        alertDialog3.dismiss();
                                    }
                                    AlertDialog alertDialog4 = alertDialog2;
                                    if (alertDialog4 != null) {
                                        alertDialog4.dismiss();
                                    }
                                    String str4 = strSubstring;
                                    if (str4.isEmpty()) {
                                        com.github.catvod.spider.merge.g1.a.e("未收到搜索关键词");
                                        return;
                                    }
                                    Youtube.I = str4;
                                    Youtube.N = i4;
                                    SettingsUI.refreshCategory();
                                    com.github.catvod.spider.merge.g1.a.e("搜索已提交：".concat(str4));
                                }
                            });
                            break;
                        }
                    }
                } catch (Exception e) {
                    SpiderDebug.log("[YouTube] QR scan search error: " + e.getMessage());
                    e.printStackTrace();
                    if (tempServer != null) {
                        tempServer.stop();
                    }
                    Init.post(new p(27));
                    return;
                }
                break;
            default:
                TempServer tempServer3 = (TempServer) obj3;
                String str4 = (String) obj2;
                AlertDialog[] alertDialogArr2 = (AlertDialog[]) obj;
                boolean z2 = Youtube.e;
                Activity activity = Init.activity();
                if (activity == null || activity.isFinishing()) {
                    com.github.catvod.spider.merge.g1.a.e("无前台界面");
                    tempServer3.stop();
                    break;
                } else {
                    try {
                        LinearLayout linearLayout = new LinearLayout(activity);
                        linearLayout.setOrientation(1);
                        linearLayout.setGravity(1);
                        linearLayout.setPadding(48, 32, 48, 24);
                        TextView textView = new TextView(activity);
                        textView.setText("请用手机扫码或访问：\n\n" + str4 + "\n\n输入搜索关键词后将自动跳转");
                        textView.setTextSize(16.0f);
                        textView.setGravity(17);
                        linearLayout.addView(textView);
                        ImageView imageView = new ImageView(activity);
                        Bitmap bitmapR0 = Youtube.R0(str4);
                        if (bitmapR0 != null) {
                            imageView.setImageBitmap(bitmapR0);
                            imageView.setVisibility(8);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(420, 420);
                            layoutParams.topMargin = 24;
                            layoutParams.gravity = 1;
                            linearLayout.addView(imageView, layoutParams);
                        }
                        LinearLayout linearLayout2 = new LinearLayout(activity);
                        linearLayout2.setOrientation(0);
                        linearLayout2.setGravity(17);
                        linearLayout2.setPadding(0, 24, 0, 0);
                        Button button4 = new Button(activity);
                        button4.setText("显示二维码");
                        Button button5 = new Button(activity);
                        button5.setText("关闭");
                        linearLayout2.addView(button4);
                        linearLayout2.addView(button5);
                        linearLayout.addView(linearLayout2);
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).setTitle("扫码搜索").setView(linearLayout).setCancelable(false).create();
                        alertDialogArr2[0] = alertDialogCreate;
                        int i5 = 2;
                        button4.setOnClickListener(new k(imageView, button4, i5));
                        button5.setOnClickListener(new m(alertDialogCreate, tempServer3, i5));
                        alertDialogCreate.show();
                        break;
                    } catch (Exception e2) {
                        com.github.catvod.spider.merge.g1.a.e("显示二维码失败：" + e2.getMessage());
                        tempServer3.stop();
                        return;
                    }
                }
                break;
        }
    }

    public /* synthetic */ i(Youtube youtube, TempServer tempServer, String str, AlertDialog[] alertDialogArr) {
        this.b = tempServer;
        this.c = str;
        this.d = alertDialogArr;
    }

    public /* synthetic */ i(Youtube youtube, String str, AlertDialog alertDialog) {
        this.c = youtube;
        this.d = str;
        this.b = alertDialog;
    }
}
