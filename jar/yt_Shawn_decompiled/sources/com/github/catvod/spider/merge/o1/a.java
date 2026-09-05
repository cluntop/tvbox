package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements Map.Entry, Cloneable {
    public static final String[] d = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    public static final Pattern e = Pattern.compile("[^-a-zA-Z0-9_:.]+");
    public static final Pattern f = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
    public final String a;
    public String b;
    public c c;

    public a(String str, String str2, c cVar) {
        c2.R(str);
        String strTrim = str.trim();
        c2.P(strTrim);
        this.a = strTrim;
        this.b = str2;
        this.c = cVar;
    }

    public static String a(int i, String str) {
        if (i == 2 && !c(str)) {
            String strReplaceAll = e.matcher(str).replaceAll("_");
            if (c(strReplaceAll)) {
                return strReplaceAll;
            }
            return null;
        }
        if (i != 1 || b(str)) {
            return str;
        }
        String strReplaceAll2 = f.matcher(str).replaceAll("_");
        if (b(strReplaceAll2)) {
            return strReplaceAll2;
        }
        return null;
    }

    public static boolean b(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || ((cCharAt >= 127 && cCharAt <= 159) || cCharAt == ' ' || cCharAt == '\"' || cCharAt == '\'' || cCharAt == '/' || cCharAt == '=')) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt < 'a' || cCharAt > 'z') && !((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_' || cCharAt == ':')) {
            return false;
        }
        for (int i = 1; i < length; i++) {
            char cCharAt2 = str.charAt(i);
            if ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && !((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '-' || cCharAt2 == '_' || cCharAt2 == ':' || cCharAt2 == '.'))) {
                return false;
            }
        }
        return true;
    }

    public final Object clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (Objects.equals(this.a, aVar.a) && Objects.equals(this.b, aVar.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return c.c(this.b);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        String str;
        int i;
        String str2 = (String) obj;
        String strE = this.b;
        c cVar = this.c;
        if (cVar != null && (i = cVar.i((str = this.a))) != -1) {
            strE = this.c.e(str);
            this.c.c[i] = str2;
        }
        this.b = str2;
        return c.c(strE);
    }

    public final String toString() throws androidx.startup.b, IOException {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        com.github.catvod.spider.merge.n1.a aVarE = com.github.catvod.spider.merge.n1.a.e(sbB);
        o oVar = o.base;
        Charset charset = com.github.catvod.spider.merge.m1.a.a;
        String str = this.b;
        String strA = a(1, this.a);
        if (strA != null) {
            aVarE.b(strA);
            if (str != null && ((!str.isEmpty() && !str.equalsIgnoreCase(strA)) || Arrays.binarySearch(d, com.github.catvod.spider.merge.n1.a.c(strA)) < 0)) {
                aVarE.b("=\"");
                p.c(str, aVarE, oVar, charset, 2);
                aVarE.a('\"');
            }
        }
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }
}
