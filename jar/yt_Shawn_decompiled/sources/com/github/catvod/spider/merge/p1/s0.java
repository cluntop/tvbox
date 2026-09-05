package com.github.catvod.spider.merge.p1;

import java.io.IOException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s0 implements AutoCloseable {
    public static final char[] b = {'*', '|', '_', '-'};
    public final a a;

    public s0(String str) {
        this.a = new a(str);
    }

    public static boolean C(char c) {
        return c == '-' || com.github.catvod.spider.merge.n1.i.g(c) || c == '_' || com.github.catvod.spider.merge.n1.i.e(c) || c >= 128;
    }

    public static String E(String str) {
        if (str.indexOf(92) == -1) {
            return str;
        }
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        char c = 0;
        for (char c2 : str.toCharArray()) {
            if (c2 == '\\') {
                if (c == '\\') {
                    sbB.append(c2);
                    c = 0;
                }
            } else {
                sbB.append(c2);
            }
            c = c2;
        }
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }

    public final String A() {
        char cJ;
        a aVar = this.a;
        if (aVar.K()) {
            com.github.catvod.spider.merge.s0.a.r("CSS identifier expected, but end of input found");
            return null;
        }
        aVar.z();
        int i = aVar.d;
        int i2 = aVar.e;
        char[] cArr = aVar.c;
        int i3 = i;
        while (i3 < i2 && C(cArr[i3])) {
            i3++;
        }
        aVar.d = i3;
        String strA = i3 > i ? a.A(aVar.c, aVar.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
        char cJ2 = aVar.J();
        if (cJ2 != '\\' && cJ2 != 0) {
            return strA;
        }
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        if (!strA.isEmpty()) {
            sbB.append(strA);
        }
        while (!aVar.K()) {
            char cJ3 = aVar.J();
            if (!C(cJ3)) {
                if (cJ3 != 0) {
                    if (cJ3 != '\\') {
                        break;
                    }
                    j();
                    if (!aVar.K() && ((cJ = aVar.J()) == '\n' || cJ == '\r' || cJ == '\f')) {
                        aVar.W();
                        break;
                    }
                    if (aVar.K()) {
                        sbB.append((char) 65533);
                    } else {
                        char cB = aVar.B();
                        if (com.github.catvod.spider.merge.n1.i.h(cB)) {
                            aVar.W();
                            aVar.z();
                            int i4 = aVar.d;
                            int i5 = aVar.e;
                            char[] cArr2 = aVar.c;
                            int i6 = i4;
                            while (i6 < i5 && i6 - i4 < 6 && com.github.catvod.spider.merge.n1.i.h(cArr2[i6])) {
                                i6++;
                            }
                            aVar.d = i6;
                            String strA2 = i6 > i4 ? a.A(aVar.c, aVar.a, i4, i6 - i4) : VideoStream.RESOLUTION_UNKNOWN;
                            try {
                                int i7 = Integer.parseInt(strA2, 16);
                                if (i7 == 0 || !Character.isValidCodePoint(i7) || Character.isSurrogate((char) i7)) {
                                    sbB.append((char) 65533);
                                } else {
                                    sbB.appendCodePoint(i7);
                                }
                                if (!aVar.K()) {
                                    char cJ4 = aVar.J();
                                    if (cJ4 == '\r') {
                                        j();
                                        if (!aVar.K() && aVar.J() == '\n') {
                                            j();
                                        }
                                    } else if (cJ4 == ' ' || cJ4 == '\t' || cJ4 == '\n' || cJ4 == '\r' || cJ4 == '\f') {
                                        j();
                                    }
                                }
                            } catch (NumberFormatException e) {
                                throw new IllegalArgumentException("Invalid escape sequence: ".concat(strA2), e);
                            }
                        } else {
                            sbB.append(cB);
                        }
                    }
                } else {
                    j();
                    sbB.append((char) 65533);
                }
            } else {
                sbB.append(aVar.B());
            }
        }
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }

    public final boolean B() {
        boolean z = false;
        while (com.github.catvod.spider.merge.n1.i.i(this.a.J())) {
            j();
            z = true;
        }
        return z;
    }

    public final boolean D(char c) {
        a aVar = this.a;
        if (!aVar.O(c)) {
            return false;
        }
        aVar.B();
        return true;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    public final void j() {
        a aVar = this.a;
        if (aVar.K()) {
            return;
        }
        aVar.j();
    }

    public final String toString() {
        return this.a.toString();
    }

    public final String z(char c, char c2) throws IOException {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        a aVar = this.a;
        if (aVar.e - aVar.d < 1024) {
            aVar.f = 0;
        }
        aVar.z();
        aVar.h = aVar.d;
        char c3 = 0;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        boolean z3 = false;
        while (!aVar.K()) {
            char cB = aVar.B();
            if (c3 == '\\') {
                if (cB == 'Q') {
                    z3 = true;
                } else if (cB == 'E') {
                    z3 = false;
                }
                sbB.append(cB);
            } else {
                if (cB == '\'' && cB != c && !z) {
                    z2 = !z2;
                } else if (cB == '\"' && cB != c && !z2) {
                    z = !z;
                }
                if (z2 || z || z3) {
                    sbB.append(cB);
                } else if (cB == c) {
                    i++;
                    if (i > 1) {
                        sbB.append(cB);
                    }
                } else if (cB != c2 || i - 1 > 0) {
                    sbB.append(cB);
                }
            }
            if (i <= 0) {
                break;
            }
            c3 = cB;
        }
        String strL = com.github.catvod.spider.merge.n1.i.l(sbB);
        if (i <= 0) {
            return strL;
        }
        aVar.V();
        throw new com.github.catvod.spider.merge.m1.g("Did not find balanced marker at '" + strL + "'");
    }
}
