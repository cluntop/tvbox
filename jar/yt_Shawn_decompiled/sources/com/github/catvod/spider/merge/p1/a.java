package com.github.catvod.spider.merge.p1;

import java.io.IOException;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements AutoCloseable {
    public static final com.github.catvod.spider.merge.g1.b n = new com.github.catvod.spider.merge.g1.b(new com.github.catvod.spider.merge.n1.b(3));
    public static final com.github.catvod.spider.merge.g1.b o = new com.github.catvod.spider.merge.g1.b(new com.github.catvod.spider.merge.n1.b(4));
    public String[] a;
    public StringReader b;
    public char[] c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public ArrayList j;
    public int k;
    public String l;
    public int m;

    public a(StringReader stringReader) throws IOException {
        this.f = 0;
        this.h = -1;
        this.j = null;
        this.k = 1;
        this.b = stringReader;
        this.c = (char[]) o.c();
        this.a = (String[]) n.c();
        z();
    }

    public static String A(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 < 1) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        int i3 = i2 + i;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i; i6 < i3; i6++) {
            i5 = (i5 * 31) + cArr[i6];
        }
        int i7 = i5 & 511;
        String str = strArr[i7];
        if (str != null && i2 == str.length()) {
            int i8 = i;
            int i9 = i2;
            while (true) {
                int i10 = i9 - 1;
                if (i9 == 0) {
                    return str;
                }
                int i11 = i8 + 1;
                int i12 = i4 + 1;
                if (cArr[i8] != str.charAt(i4)) {
                    break;
                }
                i8 = i11;
                i9 = i10;
                i4 = i12;
            }
        }
        String str2 = new String(cArr, i, i2);
        strArr[i7] = str2;
        return str2;
    }

    public final char B() {
        z();
        int i = this.d;
        char c = i >= this.e ? (char) 65535 : this.c[i];
        this.d = i + 1;
        return c;
    }

    public final String C() throws IOException {
        z();
        int i = this.d;
        int i2 = this.e;
        char[] cArr = this.c;
        int i3 = i;
        while (i3 < i2) {
            char c = cArr[i3];
            if (!((c == '&' || c == '<' || c == 0) ? false : true)) {
                break;
            }
            i3++;
        }
        this.d = i3;
        return i3 > i ? A(this.c, this.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public final String D() throws IOException {
        z();
        int i = this.d;
        int i2 = this.e;
        char[] cArr = this.c;
        int i3 = i;
        while (i3 < i2 && Character.isLetter(cArr[i3])) {
            i3++;
        }
        this.d = i3;
        return i3 > i ? A(this.c, this.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public final String E(com.github.catvod.spider.merge.b0.a aVar) throws IOException {
        z();
        int i = this.d;
        int i2 = this.e;
        char[] cArr = this.c;
        int i3 = i;
        while (i3 < i2) {
            char c = cArr[i3];
            if (!((c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ' || c == '/' || c == '>') ? false : true)) {
                break;
            }
            i3++;
        }
        this.d = i3;
        return i3 > i ? A(this.c, this.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public final String F(char c) throws IOException {
        int i;
        z();
        int i2 = this.d;
        while (true) {
            if (i2 >= this.e) {
                i = -1;
                break;
            }
            if (c == this.c[i2]) {
                i = i2 - this.d;
                break;
            }
            i2++;
        }
        if (i == -1) {
            return I();
        }
        String strA = A(this.c, this.a, this.d, i);
        this.d += i;
        return strA;
    }

    public final String G(char... cArr) throws IOException {
        z();
        int i = this.d;
        int i2 = this.e;
        char[] cArr2 = this.c;
        int i3 = i;
        loop0: while (i3 < i2) {
            char c = cArr2[i3];
            for (char c2 : cArr) {
                if (c == c2) {
                    break loop0;
                }
            }
            i3++;
        }
        this.d = i3;
        return i3 > i ? A(this.c, this.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public final String H(char... cArr) throws IOException {
        z();
        int i = this.d;
        int i2 = this.e;
        char[] cArr2 = this.c;
        int i3 = i;
        while (i3 < i2 && Arrays.binarySearch(cArr, cArr2[i3]) < 0) {
            i3++;
        }
        this.d = i3;
        return i3 > i ? A(this.c, this.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public final String I() throws IOException {
        z();
        char[] cArr = this.c;
        String[] strArr = this.a;
        int i = this.d;
        String strA = A(cArr, strArr, i, this.e - i);
        this.d = this.e;
        return strA;
    }

    public final char J() {
        z();
        int i = this.d;
        if (i >= this.e) {
            return (char) 65535;
        }
        return this.c[i];
    }

    public final boolean K() throws IOException {
        z();
        return this.d >= this.e;
    }

    public final int L(int i) {
        ArrayList arrayList = this.j;
        if (arrayList == null) {
            return 0;
        }
        int iBinarySearch = Collections.binarySearch(arrayList, Integer.valueOf(i));
        return iBinarySearch < -1 ? Math.abs(iBinarySearch) - 2 : iBinarySearch;
    }

    public final boolean M(String str) throws IOException {
        z();
        z();
        int length = str.length();
        if (length <= this.e - this.d) {
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == this.c[this.d + i]) {
                }
            }
            this.d = str.length() + this.d;
            return true;
        }
        return false;
    }

    public final boolean N(String str) {
        if (!R(str)) {
            return false;
        }
        this.d = str.length() + this.d;
        return true;
    }

    public final boolean O(char c) {
        return !K() && this.c[this.d] == c;
    }

    public final boolean P(char... cArr) throws IOException {
        if (!K()) {
            z();
            char c = this.c[this.d];
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean Q() {
        if (K()) {
            return false;
        }
        return com.github.catvod.spider.merge.n1.i.e(this.c[this.d]);
    }

    public final boolean R(String str) throws IOException {
        z();
        int length = str.length();
        if (length > this.e - this.d) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            char c = this.c[this.d + i];
            if (cCharAt != c && Character.toUpperCase(cCharAt) != Character.toUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    public final int S(String str) throws IOException {
        z();
        char cCharAt = str.charAt(0);
        int i = this.d;
        while (i < this.e) {
            if (cCharAt != this.c[i]) {
                do {
                    i++;
                    if (i >= this.e) {
                        break;
                    }
                } while (cCharAt != this.c[i]);
            }
            int i2 = i + 1;
            int length = (str.length() + i2) - 1;
            int i3 = this.e;
            if (i < i3 && length <= i3) {
                int i4 = i2;
                for (int i5 = 1; i4 < length && str.charAt(i5) == this.c[i4]; i5++) {
                    i4++;
                }
                if (i4 == length) {
                    return i - this.d;
                }
            }
            i = i2;
        }
        return -1;
    }

    public final int T() {
        return this.g + this.d;
    }

    public final String U() {
        int i;
        int iL;
        StringBuilder sb = new StringBuilder();
        int iT = T();
        if (this.j != null) {
            int iL2 = L(iT);
            i = this.k;
            if (iL2 != -1) {
                i = iL2 + i + 1;
            }
        } else {
            i = 1;
        }
        sb.append(i);
        sb.append(":");
        int iT2 = T();
        if (this.j != null && (iL = L(iT2)) != -1) {
            iT2 -= ((Integer) this.j.get(iL)).intValue();
        }
        sb.append(iT2 + 1);
        return sb.toString();
    }

    public final void V() {
        int i = this.h;
        if (i == -1) {
            throw new UncheckedIOException(new IOException("Mark invalid"));
        }
        this.d = i;
        this.h = -1;
    }

    public final void W() {
        int i = this.d;
        if (i < 1) {
            throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume."));
        }
        this.d = i - 1;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        com.github.catvod.spider.merge.g1.b bVar = n;
        com.github.catvod.spider.merge.g1.b bVar2 = o;
        StringReader stringReader = this.b;
        if (stringReader == null) {
            return;
        }
        try {
            stringReader.close();
            this.b = null;
            Arrays.fill(this.c, (char) 0);
            bVar2.h(this.c);
            this.c = null;
            bVar.h(this.a);
        } catch (IOException unused) {
            this.b = null;
            Arrays.fill(this.c, (char) 0);
            bVar2.h(this.c);
            this.c = null;
            bVar.h(this.a);
        } catch (Throwable th) {
            this.b = null;
            Arrays.fill(this.c, (char) 0);
            bVar2.h(this.c);
            this.c = null;
            bVar.h(this.a);
            this.a = null;
            throw th;
        }
        this.a = null;
    }

    public final void j() {
        this.d++;
    }

    public final String toString() {
        int i = this.e;
        int i2 = this.d;
        return i - i2 < 0 ? VideoStream.RESOLUTION_UNKNOWN : new String(this.c, i2, i - i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        r7.i = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.i
            if (r0 != 0) goto La5
            int r0 = r7.d
            int r1 = r7.f
            if (r0 < r1) goto La5
            int r1 = r7.h
            r2 = -1
            if (r1 == r2) goto L11
            goto La5
        L11:
            int r1 = r7.g
            int r1 = r1 + r0
            r7.g = r1
            int r1 = r7.e
            int r1 = r1 - r0
            r7.e = r1
            r3 = 0
            if (r1 <= 0) goto L23
            char[] r4 = r7.c
            java.lang.System.arraycopy(r4, r0, r4, r3, r1)
        L23:
            r7.d = r3
        L25:
            int r0 = r7.e
            r1 = 2048(0x800, float:2.87E-42)
            r4 = 1
            if (r0 >= r1) goto L4c
            java.io.StringReader r1 = r7.b     // Catch: java.io.IOException -> L3b
            char[] r5 = r7.c     // Catch: java.io.IOException -> L3b
            int r6 = r5.length     // Catch: java.io.IOException -> L3b
            int r6 = r6 - r0
            int r0 = r1.read(r5, r0, r6)     // Catch: java.io.IOException -> L3b
            if (r0 != r2) goto L3d
            r7.i = r4     // Catch: java.io.IOException -> L3b
            goto L4c
        L3b:
            r0 = move-exception
            goto L46
        L3d:
            if (r0 != 0) goto L40
            goto L4c
        L40:
            int r1 = r7.e     // Catch: java.io.IOException -> L3b
            int r1 = r1 + r0
            r7.e = r1     // Catch: java.io.IOException -> L3b
            goto L25
        L46:
            java.io.UncheckedIOException r1 = new java.io.UncheckedIOException
            r1.<init>(r0)
            throw r1
        L4c:
            int r0 = r7.e
            r1 = 1024(0x400, float:1.435E-42)
            int r0 = java.lang.Math.min(r0, r1)
            r7.f = r0
            java.util.ArrayList r0 = r7.j
            if (r0 == 0) goto La2
            int r0 = r0.size()
            if (r0 <= 0) goto L84
            int r0 = r7.g
            int r0 = r7.L(r0)
            if (r0 != r2) goto L69
            goto L6a
        L69:
            r3 = r0
        L6a:
            java.util.ArrayList r0 = r7.j
            java.lang.Object r0 = r0.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r0.getClass()
            int r1 = r7.k
            int r1 = r1 + r3
            r7.k = r1
            java.util.ArrayList r1 = r7.j
            r1.clear()
            java.util.ArrayList r1 = r7.j
            r1.add(r0)
        L84:
            int r0 = r7.d
        L86:
            int r1 = r7.e
            if (r0 >= r1) goto La2
            char[] r1 = r7.c
            char r1 = r1[r0]
            r2 = 10
            if (r1 != r2) goto L9f
            java.util.ArrayList r1 = r7.j
            int r2 = r7.g
            int r2 = r2 + r4
            int r2 = r2 + r0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.add(r2)
        L9f:
            int r0 = r0 + 1
            goto L86
        La2:
            r0 = 0
            r7.l = r0
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.a.z():void");
    }

    public a(String str) {
        this(new StringReader(str));
    }
}
