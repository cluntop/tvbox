package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.u.c2;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c implements Iterable, Cloneable {
    public int a = 0;
    public String[] b = new String[3];
    public Object[] c = new Object[3];

    public static String c(Object obj) {
        return obj == null ? VideoStream.RESOLUTION_UNKNOWN : (String) obj;
    }

    public static boolean l(String str) {
        return str.length() > 1 && str.charAt(0) == '/';
    }

    public final void a(String str, Serializable serializable) {
        b(this.a + 1);
        String[] strArr = this.b;
        int i = this.a;
        strArr[i] = str;
        this.c[i] = serializable;
        this.a = i + 1;
    }

    public final void b(int i) {
        c2.I(i >= this.a);
        String[] strArr = this.b;
        int length = strArr.length;
        if (length >= i) {
            return;
        }
        int i2 = length >= 3 ? this.a * 2 : 3;
        if (i <= i2) {
            i = i2;
        }
        this.b = (String[]) Arrays.copyOf(strArr, i);
        this.c = Arrays.copyOf(this.c, i);
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final c clone() {
        try {
            c cVar = (c) super.clone();
            cVar.a = this.a;
            cVar.b = (String[]) Arrays.copyOf(this.b, this.a);
            cVar.c = Arrays.copyOf(this.c, this.a);
            int i = i("/jsoup.userdata");
            if (i != -1) {
                this.c[i] = new HashMap((Map) this.c[i]);
            }
            return cVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final String e(String str) {
        int i = i(str);
        return i == -1 ? VideoStream.RESOLUTION_UNKNOWN : c(this.c[i]);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.a == cVar.a) {
                for (int i = 0; i < this.a; i++) {
                    int i2 = cVar.i(this.b[i]);
                    if (i2 != -1 && Objects.equals(this.c[i], cVar.c[i2])) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String f(String str) {
        int iK = k(str);
        return iK == -1 ? VideoStream.RESOLUTION_UNKNOWN : c(this.c[iK]);
    }

    public final boolean g(String str) {
        return i(str) != -1;
    }

    public final void h(com.github.catvod.spider.merge.n1.a aVar, g gVar) {
        String strA;
        int i = gVar.f;
        int i2 = this.a;
        for (int i3 = 0; i3 < i2; i3++) {
            String str = this.b[i3];
            if (!l(str) && (strA = a.a(i, str)) != null) {
                String str2 = (String) this.c[i3];
                com.github.catvod.spider.merge.n1.a aVarA = aVar.a(' ');
                aVarA.b(strA);
                if (i != 1 || (str2 != null && ((!str2.isEmpty() && !str2.equalsIgnoreCase(strA)) || Arrays.binarySearch(a.d, com.github.catvod.spider.merge.n1.a.c(strA)) < 0))) {
                    aVarA.b("=\"");
                    String strC = c(str2);
                    char[] cArr = p.a;
                    p.c(strC, aVarA, gVar.a, gVar.b, 2);
                    aVarA.a('\"');
                }
            }
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.c) + (((this.a * 31) + Arrays.hashCode(this.b)) * 31);
    }

    public final int i(String str) {
        c2.R(str);
        for (int i = 0; i < this.a; i++) {
            if (str.equals(this.b[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this);
    }

    public final int k(String str) {
        c2.R(str);
        for (int i = 0; i < this.a; i++) {
            if (str.equalsIgnoreCase(this.b[i])) {
                return i;
            }
        }
        return -1;
    }

    public final void m(String str, String str2) {
        c2.R(str);
        int i = i(str);
        if (i != -1) {
            this.c[i] = str2;
        } else {
            a(str, str2);
        }
    }

    public final void n(int i) {
        int i2 = this.a;
        if (i >= i2) {
            throw new com.github.catvod.spider.merge.m1.g("Must be false");
        }
        int i3 = (i2 - i) - 1;
        if (i3 > 0) {
            String[] strArr = this.b;
            int i4 = i + 1;
            System.arraycopy(strArr, i4, strArr, i, i3);
            Object[] objArr = this.c;
            System.arraycopy(objArr, i4, objArr, i, i3);
        }
        int i5 = this.a - 1;
        this.a = i5;
        this.b[i5] = null;
        this.c[i5] = null;
    }

    public final Map o() {
        int i = i("/jsoup.userdata");
        if (i != -1) {
            return (Map) this.c[i];
        }
        HashMap map = new HashMap();
        a("/jsoup.userdata", map);
        return map;
    }

    public final int size() {
        if (this.a == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            if (!l(this.b[i2])) {
                i++;
            }
        }
        return i;
    }

    public final String toString() {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        h(com.github.catvod.spider.merge.n1.a.e(sbB), new g());
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }
}
