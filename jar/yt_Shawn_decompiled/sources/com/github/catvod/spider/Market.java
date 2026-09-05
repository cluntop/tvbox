package com.github.catvod.spider;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.o.d;
import com.github.catvod.spider.merge.o.e;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.Request;
import okhttp3.Response;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Market extends Spider {
    public List a;

    public static void b(File file, InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void a(String str) {
        for (com.github.catvod.spider.merge.e.a aVar : this.a) {
            int iIndexOf = aVar.a().indexOf(new com.github.catvod.spider.merge.e.b(str));
            if (iIndexOf != -1) {
                String strA = ((com.github.catvod.spider.merge.e.b) aVar.a().get(iIndexOf)).a();
                if (strA.isEmpty()) {
                    return;
                }
                Pattern pattern = e.a;
                ((ClipboardManager) Init.context().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("fongmi", strA));
                com.github.catvod.spider.merge.g1.a.e("已複製 ".concat(strA));
                return;
            }
        }
    }

    public String action(String str) {
        try {
            com.github.catvod.spider.merge.g1.a.c();
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            com.github.catvod.spider.merge.g1.a.e("正在下載..." + lastPathSegment);
            Response responseExecute = com.github.catvod.spider.merge.g1.a.d().newCall(new Request.Builder().url(str).tag("Market").build()).execute();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), lastPathSegment);
            d.a(file);
            b(file, responseExecute.body().byteStream());
            if (file.getName().endsWith(".zip")) {
                d.i(file, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
            }
            if (file.getName().endsWith(".apk")) {
                d.d(file);
            }
            a(str);
            responseExecute.close();
            return com.github.catvod.spider.merge.a.e.f("下載完成");
        } catch (Exception e) {
            return com.github.catvod.spider.merge.a.e.f(e.getMessage());
        }
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        for (com.github.catvod.spider.merge.e.a aVar : this.a) {
            if (aVar.b().equals(str)) {
                com.github.catvod.spider.merge.a.e eVar = new com.github.catvod.spider.merge.a.e();
                eVar.g(1, 1, 0, 1);
                eVar.s(aVar.c());
                return eVar.toString();
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public void destroy() {
        com.github.catvod.spider.merge.g1.a.c();
    }

    public String homeContent(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.a.size() > 1) {
            for (int i = 1; i < this.a.size(); i++) {
                com.github.catvod.spider.merge.e.a aVar = (com.github.catvod.spider.merge.e.a) this.a.get(i);
                arrayList.add(new com.github.catvod.spider.merge.a.a(aVar.b(), aVar.b(), null));
            }
        }
        return com.github.catvod.spider.merge.a.e.l(arrayList, ((com.github.catvod.spider.merge.e.a) this.a.get(0)).c());
    }

    public void init(Context context, String str) {
        if (str.startsWith("http")) {
            str = com.github.catvod.spider.merge.g1.a.f(str, null);
        }
        this.a = (List) new Gson().fromJson(str, TypeToken.getParameterized(ArrayList.class, new Type[]{com.github.catvod.spider.merge.e.a.class}).getType());
    }
}
