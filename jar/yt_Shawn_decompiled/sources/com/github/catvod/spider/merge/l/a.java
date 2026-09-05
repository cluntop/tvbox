package com.github.catvod.spider.merge.l;

import android.text.TextUtils;
import com.github.catvod.spider.merge.o.d;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.q1.e;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public final Pattern a = Pattern.compile("url\\((.*?)\\)", 40);
    public final Pattern b = Pattern.compile(":eq|:lt|:gt|:first|:last|:not|:even|:odd|:has|:contains|:matches|:empty|^body$|^#");
    public final Pattern c = Pattern.compile("(url|src|href|-original|-src|-play|-url|style)$|^(data-|url-|src-)", 10);
    public final Pattern d = Pattern.compile("^(ftp|magnet|thunder|ws):", 10);
    public final com.github.catvod.spider.merge.k.a e = new com.github.catvod.spider.merge.k.a();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.github.catvod.spider.merge.q1.e c(com.github.catvod.spider.merge.o1.h r9, java.lang.String r10, com.github.catvod.spider.merge.q1.e r11) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.l.a.c(com.github.catvod.spider.merge.o1.h, java.lang.String, com.github.catvod.spider.merge.q1.e):com.github.catvod.spider.merge.q1.e");
    }

    public final String a(String str, String str2, String str3) {
        String str4;
        String strG;
        String strJoin = str2;
        com.github.catvod.spider.merge.k.a aVar = this.e;
        if (!str.equals((String) aVar.b)) {
            aVar.b = str;
            aVar.d = c2.T(str);
        }
        h hVar = (h) aVar.d;
        if ("body&&Text".equals(strJoin) || "Text".equals(strJoin)) {
            return hVar.U();
        }
        if ("body&&Html".equals(strJoin) || "Html".equals(strJoin)) {
            return hVar.P();
        }
        boolean zContains = strJoin.contains("&&");
        String strSubstring = VideoStream.RESOLUTION_UNKNOWN;
        int i = 1;
        if (zContains) {
            String[] strArrSplit = strJoin.split("&&");
            str4 = strArrSplit[strArrSplit.length - 1];
            ArrayList arrayList = new ArrayList(Arrays.asList(strArrSplit));
            arrayList.remove(strArrSplit.length - 1);
            strJoin = TextUtils.join("&&", arrayList);
        } else {
            str4 = VideoStream.RESOLUTION_UNKNOWN;
        }
        String[] strArrSplit2 = b(strJoin, true).split(Stream.ID_UNKNOWN);
        e eVar = new e();
        for (String str5 : strArrSplit2) {
            eVar = c(hVar, str5, eVar);
            if (eVar.isEmpty()) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
        }
        if (TextUtils.isEmpty(str4)) {
            return eVar.e();
        }
        if ("Text".equals(str4)) {
            return eVar.g();
        }
        if ("Html".equals(str4)) {
            return eVar.d();
        }
        String[] strArrSplit3 = str4.split("[||]");
        int length = strArrSplit3.length;
        int i2 = 0;
        while (i2 < length) {
            String str6 = strArrSplit3[i2];
            String strA = eVar.a(str6);
            if (str6.toLowerCase().contains("style") && strA.contains("url(")) {
                Matcher matcher = this.a.matcher(strA);
                if (matcher.find()) {
                    strA = matcher.group(i);
                }
                strA = strA.replaceAll("^['|\"](.*)['|\"]$", "$1");
            }
            if (strA.isEmpty() || str3.isEmpty() || !this.c.matcher(str6).find() || this.d.matcher(strA).find()) {
                strSubstring = strA;
            } else if (strA.contains("http")) {
                strSubstring = strA.substring(strA.indexOf("http"));
            } else {
                StringBuilder sb = new StringBuilder();
                int[] iArrB = d.b(strA);
                if (iArrB[0] != -1) {
                    sb.append(strA);
                    d.g(sb, iArrB[i], iArrB[2]);
                    strG = sb.toString();
                } else {
                    int[] iArrB2 = d.b(str3);
                    if (iArrB[3] == 0) {
                        sb.append((CharSequence) str3, 0, iArrB2[3]);
                        sb.append(strA);
                        strG = sb.toString();
                    } else if (iArrB[2] == 0) {
                        sb.append((CharSequence) str3, 0, iArrB2[2]);
                        sb.append(strA);
                        strG = sb.toString();
                    } else {
                        int i3 = iArrB[i];
                        if (i3 != 0) {
                            int i4 = iArrB2[0] + i;
                            sb.append((CharSequence) str3, 0, i4);
                            sb.append(strA);
                            strG = d.g(sb, iArrB[i] + i4, i4 + iArrB[2]);
                        } else if (strA.charAt(i3) == '/') {
                            sb.append((CharSequence) str3, 0, iArrB2[i]);
                            sb.append(strA);
                            int i5 = iArrB2[i];
                            strG = d.g(sb, i5, iArrB[2] + i5);
                        } else {
                            int i6 = iArrB2[0] + 2;
                            int i7 = iArrB2[1];
                            if (i6 >= i7 || i7 != iArrB2[2]) {
                                int iLastIndexOf = str3.lastIndexOf(47, iArrB2[2] - 1);
                                int i8 = iLastIndexOf == -1 ? iArrB2[1] : iLastIndexOf + 1;
                                sb.append((CharSequence) str3, 0, i8);
                                sb.append(strA);
                                strG = d.g(sb, iArrB2[1], i8 + iArrB[2]);
                            } else {
                                sb.append((CharSequence) str3, 0, i7);
                                sb.append('/');
                                sb.append(strA);
                                int i9 = iArrB2[1];
                                strG = d.g(sb, i9, iArrB[2] + i9 + 1);
                            }
                            strSubstring = strG;
                        }
                    }
                }
                strSubstring = strG;
            }
            if (!strSubstring.isEmpty()) {
                return strSubstring;
            }
            i2++;
            i = 1;
        }
        return strSubstring;
    }

    public final String b(String str, boolean z) {
        boolean zContains = str.contains("&&");
        Pattern pattern = this.b;
        if (!zContains) {
            String[] strArrSplit = str.split(Stream.ID_UNKNOWN);
            return (pattern.matcher(strArrSplit[strArrSplit.length + (-1)]).find() || !z) ? str : str.concat(":eq(0)");
        }
        String[] strArrSplit2 = str.split("&&");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArrSplit2.length; i++) {
            if (pattern.matcher(strArrSplit2[i].split(Stream.ID_UNKNOWN)[r5.length - 1]).find()) {
                arrayList.add(strArrSplit2[i]);
            } else if (z || i < strArrSplit2.length - 1) {
                arrayList.add(strArrSplit2[i] + ":eq(0)");
            } else {
                arrayList.add(strArrSplit2[i]);
            }
        }
        return TextUtils.join(Stream.ID_UNKNOWN, arrayList);
    }
}
