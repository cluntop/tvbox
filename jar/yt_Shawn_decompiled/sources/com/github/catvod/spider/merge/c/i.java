package com.github.catvod.spider.merge.c;

import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.spider.jdollar.net.URLEncoder;
import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class i {
    public final int[] a = {46, 47, 18, 2, 53, 8, 23, 32, 15, 50, 10, 31, 58, 3, 45, 35, 27, 43, 5, 49, 33, 9, 42, 19, 29, 28, 14, 39, 12, 38, 41, 13, 37, 48, 7, 16, 24, 55, 40, 61, 26, 17, 0, 1, 60, 51, 30, 4, 22, 25, 54, 21, 56, 59, 6, 63, 57, 62, 11, 36, 20, 34, 44, 52};

    @SerializedName("img_url")
    private String b;

    @SerializedName("sub_url")
    private String c;

    public final String a(LinkedHashMap linkedHashMap) {
        boolean zIsEmpty = TextUtils.isEmpty(this.b);
        String lowerCase = VideoStream.RESOLUTION_UNKNOWN;
        String strZ = com.github.catvod.spider.merge.b.b.z(Uri.parse(zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.b).getLastPathSegment().split("\\.")[0], Uri.parse(TextUtils.isEmpty(this.c) ? VideoStream.RESOLUTION_UNKNOWN : this.c).getLastPathSegment().split("\\.")[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(strZ.charAt(this.a[i]));
        }
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        linkedHashMap.put("wts", Long.valueOf(System.currentTimeMillis() / 1000));
        for (String str : linkedHashMap.keySet()) {
            sb2.append(str);
            sb2.append("=");
            sb2.append(URLEncoder.encode(linkedHashMap.get(str).toString()));
            sb2.append("&");
        }
        String string2 = sb2.toString();
        Pattern pattern = com.github.catvod.spider.merge.o.e.a;
        if (string2.length() > 1) {
            string2 = string2.substring(0, string2.length() - 1);
        }
        try {
            StringBuilder sb3 = new StringBuilder(new BigInteger(1, MessageDigest.getInstance("MD5").digest(string2.concat(string).getBytes("UTF-8"))).toString(16));
            while (sb3.length() < 32) {
                sb3.insert(0, "0");
            }
            lowerCase = sb3.toString().toLowerCase();
        } catch (Exception unused) {
        }
        return com.github.catvod.spider.merge.b.b.o(string2, "&w_rid=", lowerCase);
    }
}
