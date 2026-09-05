package com.github.catvod.spider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.n.c;
import com.github.catvod.spider.merge.n.d;
import com.github.catvod.spider.merge.n.e;
import com.github.catvod.spider.merge.n.g;
import com.github.catvod.spider.merge.n.i;
import com.github.catvod.spider.merge.n.k;
import com.github.catvod.spider.merge.n.l;
import com.github.catvod.spider.merge.u.c2;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SettingsUI {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: com.github.catvod.spider.SettingsUI$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            int port = Proxy.getPort();
            if (port <= 0) {
                SpiderDebug.log("[SettingsUI] refresh http abort: no local port");
                return;
            }
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(com.github.catvod.spider.merge.b.b.k(port, "http://127.0.0.1:", "/action?do=refresh&type=category")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(2000);
                    httpURLConnection2.setReadTimeout(2000);
                    httpURLConnection2.setRequestMethod("GET");
                    SpiderDebug.log("[SettingsUI] refresh http code=" + httpURLConnection2.getResponseCode());
                    httpURLConnection2.disconnect();
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    try {
                        SpiderDebug.log("[SettingsUI] refresh http failed: " + th.getClass().getSimpleName() + "/" + th.getMessage());
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface Callback {
        void onResult(String str);
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface QRCallback {
        void onQRClick(EditText editText, AlertDialog alertDialog);
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface SearchCallback {
        void onSearch(String str, int i);
    }

    public static Bitmap a(String str) {
        try {
            com.github.catvod.spider.merge.w.b bVarX = c2.x(str);
            int i = bVarX.a;
            int i2 = bVarX.b;
            int[] iArr = new int[i * i2];
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    iArr[(i3 * i) + i4] = bVarX.a(i4, i3) ? -16777216 : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            SpiderDebug.log("[SettingsUI] qr error: " + th.getMessage());
            return null;
        }
    }

    public static void b(Activity activity, String str, Callback callback, Runnable runnable) {
        File file = new File(str);
        if (!file.isDirectory()) {
            file = new File("/storage/emulated/0");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            arrayList.add("⬆️ 上级目录");
            arrayList2.add(parentFile);
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    arrayList3.add(file2);
                } else {
                    String lowerCase = file2.getName().toLowerCase();
                    if (lowerCase.endsWith(".json") || lowerCase.endsWith(".yaml") || lowerCase.endsWith(".yml") || lowerCase.endsWith(".txt")) {
                        arrayList4.add(file2);
                    }
                }
            }
            com.github.catvod.spider.merge.n.b bVar = new com.github.catvod.spider.merge.n.b(1);
            Collections.sort(arrayList3, bVar);
            Collections.sort(arrayList4, bVar);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                File file3 = (File) it.next();
                arrayList.add("📁 " + file3.getName());
                arrayList2.add(file3);
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                File file4 = (File) it2.next();
                arrayList.add("📄 " + file4.getName());
                arrayList2.add(file4);
            }
        }
        AlertDialog.Builder items = new AlertDialog.Builder(activity).setTitle("选择档案：" + file.getPath()).setItems((String[]) arrayList.toArray(new String[0]), new c(arrayList2, activity, callback, runnable, 0));
        if (runnable != null) {
            items.setNegativeButton("清除路径", new d(runnable, 0));
            items.setPositiveButton("取消", (DialogInterface.OnClickListener) null);
        } else {
            items.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        }
        items.create().show();
    }

    public static void confirm(final String str, final String str2, final Runnable runnable, final Runnable runnable2) {
        final Activity activity = Init.activity();
        if (activity == null || activity.isFinishing()) {
            com.github.catvod.spider.merge.g1.a.e(str2);
        } else {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.5
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    try {
                        TextView textView = new TextView(activity2);
                        textView.setText(str2);
                        textView.setTextSize(14.0f);
                        textView.setPadding(32, 24, 32, 24);
                        textView.setTextIsSelectable(true);
                        ScrollView scrollView = new ScrollView(activity2);
                        scrollView.addView(textView);
                        AlertDialog alertDialogShow = new AlertDialog.Builder(activity2).setTitle(str).setView(scrollView).setPositiveButton("继续", new d(runnable, 1)).setNegativeButton("取消", new d(runnable2, 2)).setCancelable(false).show();
                        alertDialogShow.getButton(-1).setFocusable(true);
                        alertDialogShow.getButton(-1).setFocusableInTouchMode(false);
                        alertDialogShow.getButton(-2).setFocusable(true);
                        alertDialogShow.getButton(-2).setFocusableInTouchMode(false);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void input(final String str, final String str2, final String str3, final Callback callback) {
        final Activity activity = Init.activity();
        if (activity == null || activity.isFinishing()) {
            com.github.catvod.spider.merge.g1.a.e("无前台界面，无法弹窗");
        } else {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.1
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    try {
                        EditText editText = new EditText(activity2);
                        editText.setHint(str2);
                        int i = 1;
                        editText.setSingleLine(true);
                        String str4 = str3;
                        if (str4 != null && !str4.isEmpty()) {
                            editText.setText(str4);
                            editText.setSelection(editText.length());
                        }
                        editText.postDelayed(new com.github.catvod.spider.merge.n.a(i, new AlertDialog.Builder(activity2).setTitle(str).setView(editText).setPositiveButton("保存", new e(editText, callback, 0)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show(), editText), 100L);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void inputWithQR(final String str, final String str2, final String str3, final Callback callback, final QRCallback qRCallback) {
        final Activity activity = Init.activity();
        if (activity == null || activity.isFinishing()) {
            com.github.catvod.spider.merge.g1.a.e("无前台界面，无法弹窗");
        } else {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.3
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    try {
                        LinearLayout linearLayout = new LinearLayout(activity2);
                        linearLayout.setOrientation(1);
                        linearLayout.setPadding(48, 16, 48, 16);
                        EditText editText = new EditText(activity2);
                        editText.setHint(str2);
                        editText.setSingleLine(true);
                        String str4 = str3;
                        if (str4 != null && !str4.isEmpty()) {
                            editText.setText(str4);
                            editText.setSelection(editText.length());
                        }
                        linearLayout.addView(editText);
                        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity2).setTitle(str).setView(linearLayout).setPositiveButton("保存", new e(editText, callback, 1)).setNegativeButton("取消", (DialogInterface.OnClickListener) null);
                        QRCallback qRCallback2 = qRCallback;
                        if (qRCallback2 != null) {
                            negativeButton.setNeutralButton("二维码", (DialogInterface.OnClickListener) null);
                        }
                        AlertDialog alertDialogCreate = negativeButton.create();
                        alertDialogCreate.show();
                        editText.postDelayed(new i(alertDialogCreate, qRCallback2, editText), 100L);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void oauth(final String str, final String str2) {
        final Activity activity = Init.activity();
        if (activity != null && !activity.isFinishing()) {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.6
                @Override // java.lang.Runnable
                public void run() {
                    String str3 = str2;
                    String str4 = str;
                    Activity activity2 = activity;
                    try {
                        LinearLayout linearLayout = new LinearLayout(activity2);
                        int i = 1;
                        linearLayout.setOrientation(1);
                        linearLayout.setGravity(1);
                        linearLayout.setPadding(48, 32, 48, 24);
                        TextView textView = new TextView(activity2);
                        textView.setText("请在手机/电脑浏览器打开：\n\n" + str4 + "\n\n输入验证码：\n\n" + str3);
                        textView.setTextSize(18.0f);
                        textView.setGravity(17);
                        linearLayout.addView(textView);
                        ImageView imageView = new ImageView(activity2);
                        Bitmap bitmapA = SettingsUI.a(str4);
                        if (bitmapA != null) {
                            imageView.setImageBitmap(bitmapA);
                            imageView.setVisibility(8);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(420, 420);
                            layoutParams.topMargin = 24;
                            layoutParams.gravity = 1;
                            linearLayout.addView(imageView, layoutParams);
                        }
                        LinearLayout linearLayout2 = new LinearLayout(activity2);
                        int i2 = 0;
                        linearLayout2.setOrientation(0);
                        linearLayout2.setGravity(17);
                        linearLayout2.setPadding(0, 24, 0, 0);
                        Button button = new Button(activity2);
                        button.setText("复制验证码");
                        Button button2 = new Button(activity2);
                        button2.setText("打开网站");
                        linearLayout2.addView(button);
                        linearLayout2.addView(button2);
                        LinearLayout linearLayout3 = new LinearLayout(activity2);
                        linearLayout3.setOrientation(0);
                        linearLayout3.setGravity(17);
                        linearLayout3.setPadding(0, 12, 0, 0);
                        Button button3 = new Button(activity2);
                        button3.setText("显示二维码");
                        Button button4 = new Button(activity2);
                        button4.setText("关闭");
                        linearLayout3.addView(button3);
                        linearLayout3.addView(button4);
                        linearLayout.addView(linearLayout2);
                        linearLayout.addView(linearLayout3);
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(activity2).setTitle("OAuth 登录验证").setView(linearLayout).create();
                        alertDialogCreate.setCancelable(true);
                        button.setOnClickListener(new k(activity2, str3, i2));
                        button2.setOnClickListener(new k(activity2, str4, i));
                        button3.setOnClickListener(new l(imageView, i2));
                        button4.setOnClickListener(new l(alertDialogCreate, 4));
                        alertDialogCreate.show();
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        com.github.catvod.spider.merge.g1.a.e("请打开 " + str + " 输入代码 " + str2);
    }

    public static void pickFile(final String str, final Callback callback, final Runnable runnable) {
        final Activity activity = Init.activity();
        if (activity == null || activity.isFinishing()) {
            com.github.catvod.spider.merge.g1.a.e("无前台界面，无法弹窗");
        } else {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SettingsUI.b(activity, str, callback, runnable);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void refreshCategory() {
        final Activity activity = Init.activity();
        SpiderDebug.log("[SettingsUI] refreshCategory activity=".concat(activity == null ? "null" : activity.getClass().getName()));
        Init.execute(new AnonymousClass9());
        if (activity != null) {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    try {
                        Class<?> superclass = activity.getClass();
                        Class<?> cls = null;
                        while (true) {
                            if (superclass == null || superclass == Object.class) {
                                break;
                            }
                            Method[] declaredMethods = superclass.getDeclaredMethods();
                            int length = declaredMethods.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                Method method = declaredMethods[i2];
                                if (method.getParameterTypes().length == 1 && "onRefreshEvent".equals(method.getName())) {
                                    cls = method.getParameterTypes()[0];
                                    break;
                                }
                                i2++;
                            }
                            if (cls != null) {
                                break;
                            } else {
                                superclass = superclass.getSuperclass();
                            }
                        }
                        if (cls == null) {
                            SpiderDebug.log("[SettingsUI] refresh reflect abort: onRefreshEvent not found");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Method method2 : cls.getDeclaredMethods()) {
                            if (Modifier.isStatic(method2.getModifiers()) && method2.getReturnType() == Void.TYPE && method2.getParameterTypes().length == 0) {
                                arrayList.add(method2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            SpiderDebug.log("[SettingsUI] refresh reflect abort: no static factory");
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Method method3 = (Method) it.next();
                            try {
                                method3.setAccessible(true);
                                method3.invoke(null, null);
                                SpiderDebug.log("[SettingsUI] refresh reflect invoke factory " + method3.getName() + " OK");
                            } catch (Throwable th) {
                                SpiderDebug.log("[SettingsUI] refresh reflect factory " + method3.getName() + " failed: " + th.getClass().getSimpleName());
                            }
                        }
                        SpiderDebug.log("[SettingsUI] refresh reflect OK (home+category+history)");
                    } catch (Throwable th2) {
                        SpiderDebug.log("[SettingsUI] refresh reflect failed: " + th2.getClass().getSimpleName() + "/" + th2.getMessage());
                    }
                }
            });
        }
    }

    public static void searchDialog(final String str, final String str2, final String[] strArr, final int i, final SearchCallback searchCallback, final QRCallback qRCallback) {
        final Activity activity = Init.activity();
        if (activity == null || activity.isFinishing()) {
            com.github.catvod.spider.merge.g1.a.e("无前台界面，无法弹窗");
        } else {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.2
                @Override // java.lang.Runnable
                public void run() {
                    String[] strArr2 = strArr;
                    Activity activity2 = activity;
                    try {
                        LinearLayout linearLayout = new LinearLayout(activity2);
                        linearLayout.setOrientation(1);
                        linearLayout.setPadding(48, 16, 48, 16);
                        EditText editText = new EditText(activity2);
                        editText.setHint(str2);
                        editText.setSingleLine(true);
                        linearLayout.addView(editText);
                        RadioGroup radioGroup = new RadioGroup(activity2);
                        radioGroup.setOrientation(0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.topMargin = 24;
                        radioGroup.setLayoutParams(layoutParams);
                        int length = strArr2.length;
                        final RadioButton[] radioButtonArr = new RadioButton[length];
                        int i2 = 0;
                        while (i2 < strArr2.length) {
                            RadioButton radioButton = new RadioButton(activity2);
                            radioButton.setText(strArr2[i2]);
                            int i3 = i2 + 1;
                            radioButton.setId(i3);
                            radioButton.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                            radioGroup.addView(radioButton);
                            radioButtonArr[i2] = radioButton;
                            i2 = i3;
                        }
                        int i4 = i;
                        if (i4 < 0 || i4 >= strArr2.length) {
                            i4 = 0;
                        }
                        radioGroup.check(radioButtonArr[i4].getId());
                        linearLayout.addView(radioGroup);
                        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity2).setTitle(str).setView(linearLayout).setPositiveButton("搜索", new c(editText, radioGroup, radioButtonArr, searchCallback, 1)).setNegativeButton("关闭", (DialogInterface.OnClickListener) null);
                        QRCallback qRCallback2 = qRCallback;
                        if (qRCallback2 != null) {
                            negativeButton.setNeutralButton("二维码", (DialogInterface.OnClickListener) null);
                        }
                        AlertDialog alertDialogCreate = negativeButton.create();
                        alertDialogCreate.show();
                        Button button = alertDialogCreate.getButton(-1);
                        Button button2 = alertDialogCreate.getButton(-2);
                        Button button3 = qRCallback2 != null ? alertDialogCreate.getButton(-3) : null;
                        button.setFocusable(true);
                        button.setFocusableInTouchMode(false);
                        button2.setFocusable(true);
                        button2.setFocusableInTouchMode(false);
                        if (button3 != null) {
                            button3.setFocusable(true);
                            button3.setFocusableInTouchMode(false);
                        }
                        if (qRCallback2 != null && button3 != null) {
                            button3.setOnClickListener(new g(qRCallback2, editText, alertDialogCreate, 0));
                        }
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.github.catvod.spider.merge.n.h
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
                                if (keyEvent.getAction() == 0 && i5 == 20) {
                                    RadioButton[] radioButtonArr2 = radioButtonArr;
                                    if (radioButtonArr2.length > 0 && radioButtonArr2[0].requestFocus()) {
                                        return true;
                                    }
                                }
                                return false;
                            }
                        });
                        if (length > 0) {
                            editText.setNextFocusDownId(radioButtonArr[0].getId());
                        }
                    } catch (Throwable th) {
                        SpiderDebug.log("[SettingsUI] searchDialog error: " + th.getClass().getName() + "/" + th.getMessage());
                    }
                }
            });
        }
    }

    public static void show(final String str, final String str2) {
        final Activity activity = Init.activity();
        if (activity == null || activity.isFinishing()) {
            com.github.catvod.spider.merge.g1.a.e(str2);
        } else {
            Init.post(new Runnable() { // from class: com.github.catvod.spider.SettingsUI.4
                @Override // java.lang.Runnable
                public void run() {
                    String str3 = str2;
                    Activity activity2 = activity;
                    try {
                        TextView textView = new TextView(activity2);
                        textView.setText(str3);
                        textView.setTextSize(14.0f);
                        textView.setPadding(32, 24, 32, 24);
                        textView.setTextIsSelectable(true);
                        ScrollView scrollView = new ScrollView(activity2);
                        scrollView.addView(textView);
                        AlertDialog alertDialogShow = new AlertDialog.Builder(activity2).setTitle(str).setView(scrollView).setPositiveButton("关闭", (DialogInterface.OnClickListener) null).setNeutralButton("复制", new e(activity2, str3, 2)).show();
                        alertDialogShow.getButton(-1).setFocusable(true);
                        alertDialogShow.getButton(-1).setFocusableInTouchMode(false);
                        alertDialogShow.getButton(-3).setFocusable(true);
                        alertDialogShow.getButton(-3).setFocusableInTouchMode(false);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void pickFile(String str, Callback callback) {
        pickFile(str, callback, null);
    }

    public static void pickFile(Callback callback) {
        pickFile("/storage/emulated/0", callback);
    }

    public static void searchDialog(String str, String str2, String[] strArr, int i, SearchCallback searchCallback) {
        searchDialog(str, str2, strArr, i, searchCallback, null);
    }
}
