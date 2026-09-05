package com.github.catvod.spider.merge.n1;

import com.github.catvod.spider.jdollar.util.stream.Collector;
import com.github.catvod.spider.merge.u.c2;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class i {
    public static final String[] a = {VideoStream.RESOLUTION_UNKNOWN, Stream.ID_UNKNOWN, "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
    public static final Pattern b = Pattern.compile("^/(?>(?>\\.\\.?/)+)");
    public static final Pattern c = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+-.]*:");
    public static final Pattern d = Pattern.compile("[\\x00-\\x1f]*");
    public static final com.github.catvod.spider.merge.g1.b e = new com.github.catvod.spider.merge.g1.b(new b(1));

    public static void a(StringBuilder sb, String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt == 32 || iCodePointAt == 9 || iCodePointAt == 10 || iCodePointAt == 12 || iCodePointAt == 13 || iCodePointAt == 160) {
                if ((!z || z2) && !z3) {
                    sb.append(' ');
                    z3 = true;
                }
            } else if (iCodePointAt != 8203 && iCodePointAt != 173) {
                sb.appendCodePoint(iCodePointAt);
                z2 = true;
                z3 = false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    public static StringBuilder b() {
        return (StringBuilder) e.c();
    }

    public static boolean c(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean e(char c2) {
        if (c2 < 'a' || c2 > 'z') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public static boolean f(String str) {
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!i(str.codePointAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean h(char c2) {
        if (g(c2)) {
            return true;
        }
        if (c2 < 'a' || c2 > 'f') {
            return c2 >= 'A' && c2 <= 'F';
        }
        return true;
    }

    public static boolean i(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static String j(List list, String str) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        String string = it.next().toString();
        if (!it.hasNext()) {
            return string;
        }
        StringBuilder sbB = b();
        c2.R(sbB);
        sbB.append((Object) string);
        while (it.hasNext()) {
            Object next = it.next();
            sbB.append(str);
            sbB.append(next);
        }
        return l(sbB);
    }

    public static Collector k(String str) {
        int i = 0;
        return Collector.CC.of(new d(str, i), new e(), new f(i), new g(i), new Collector.Characteristics[0]);
    }

    public static String l(StringBuilder sb) {
        c2.R(sb);
        String string = sb.toString();
        if (sb.length() <= 8192) {
            sb.delete(0, sb.length());
            e.h(sb);
        }
        return string;
    }

    public static URL m(URL url, String str) {
        String strReplaceAll = d.matcher(str).replaceAll(VideoStream.RESOLUTION_UNKNOWN);
        if (strReplaceAll.startsWith("?")) {
            strReplaceAll = url.getPath() + strReplaceAll;
        }
        URL url2 = new URL(url, strReplaceAll);
        String strReplaceFirst = b.matcher(url2.getFile()).replaceFirst("/");
        if (url2.getRef() != null) {
            strReplaceFirst = strReplaceFirst + "#" + url2.getRef();
        }
        return new URL(url2.getProtocol(), url2.getHost(), url2.getPort(), strReplaceFirst);
    }
}
