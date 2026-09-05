package com.github.catvod.spider.merge.o;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.github.catvod.spider.Init;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d {
    public static volatile com.github.catvod.spider.merge.g1.a a = new com.github.catvod.spider.merge.g1.a();

    public static File a(File file) throws InterruptedException, IOException {
        int iWaitFor;
        try {
            if (file.getParentFile() != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            try {
                iWaitFor = Runtime.getRuntime().exec("chmod 777 " + file).waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (iWaitFor == 0) {
                return file;
            }
            throw new RuntimeException("Shell command failed with exit code " + iWaitFor);
        } catch (IOException e2) {
            e2.printStackTrace();
            return file;
        }
    }

    public static int[] b(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i = iIndexOf5 + 2;
        if (i < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    public static List c(File file) {
        if (file == null) {
            return new ArrayList();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new com.github.catvod.spider.merge.n.b(2));
        }
        return fileArrListFiles == null ? new ArrayList() : Arrays.asList(fileArrListFiles);
    }

    public static void d(File file) throws IOException {
        a aVarA;
        Uri uriBuild;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(1);
        if (Build.VERSION.SDK_INT < 24) {
            uriBuild = Uri.fromFile(file);
        } else {
            Application applicationContext = Init.context();
            String str = Init.context().getPackageName() + ".provider";
            HashMap map = b.a;
            synchronized (map) {
                try {
                    aVarA = (a) map.get(str);
                    if (aVarA == null) {
                        try {
                            aVarA = b.a(applicationContext, str);
                            map.put(str, aVarA);
                        } catch (IOException e) {
                            e = e;
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                        } catch (XmlPullParserException e2) {
                            e = e2;
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                        }
                    }
                } finally {
                }
            }
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : aVarA.b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    com.github.catvod.spider.merge.s0.a.r(com.github.catvod.spider.merge.b.b.n("Failed to find configured root that contains ", canonicalPath));
                    return;
                }
                String path2 = ((File) entry.getValue()).getPath();
                uriBuild = new Uri.Builder().scheme("content").authority(aVarA.a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                com.github.catvod.spider.merge.b0.a.j("Failed to resolve canonical path for ", file);
                return;
            }
        }
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(file.getName());
        if (TextUtils.isEmpty(strGuessContentTypeFromName)) {
            strGuessContentTypeFromName = "*/*";
        }
        intent.setDataAndType(uriBuild, strGuessContentTypeFromName);
        Init.context().startActivity(intent);
    }

    public static JsonElement e(String str) {
        try {
            return JsonParser.parseString(str);
        } catch (Throwable unused) {
            return new JsonParser().parse(str);
        }
    }

    public static byte[] f(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        fileInputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String g(StringBuilder sb, int i, int i2) {
        int i3;
        int iLastIndexOf;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i4 = i;
        int i5 = i4;
        while (i4 <= i2) {
            if (i4 == i2) {
                i3 = i4;
            } else if (sb.charAt(i4) == '/') {
                i3 = i4 + 1;
            } else {
                i4++;
            }
            int i6 = i5 + 1;
            if (i4 == i6 && sb.charAt(i5) == '.') {
                sb.delete(i5, i3);
                i2 -= i3 - i5;
            } else {
                if (i4 == i5 + 2 && sb.charAt(i5) == '.' && sb.charAt(i6) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", i5 - 2) + 1;
                    int iMax = Math.max(iLastIndexOf, i);
                    sb.delete(iMax, i3);
                    i2 -= i3 - iMax;
                } else {
                    iLastIndexOf = i4 + 1;
                }
                i5 = iLastIndexOf;
            }
            i4 = i5;
        }
        return sb.toString();
    }

    public static JsonObject h(String str) {
        try {
            JsonObject asJsonObject = e(str).getAsJsonObject();
            return asJsonObject == null ? new JsonObject() : asJsonObject;
        } catch (Throwable unused) {
            return new JsonObject();
        }
    }

    public static void i(File file, File file2) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(file.getAbsolutePath());
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    File file3 = new File(file2, zipEntryNextElement.getName());
                    if (zipEntryNextElement.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        try {
                            byte[] bArr = new byte[16384];
                            a(file3);
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            }
                            fileOutputStream.close();
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                }
                zipFile.close();
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
