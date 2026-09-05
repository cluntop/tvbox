package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.u.c2;
import com.github.catvod.spider.merge.y0.m0;
import java.io.EOFException;
import kotlin.text.Charsets;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class a {
    public static final byte[] a;
    public static final long[] b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        bytes.getClass();
        a = bytes;
        b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};
    }

    public static final long a(com.github.catvod.spider.merge.y0.j jVar, com.github.catvod.spider.merge.y0.m mVar, long j, long j2, int i) {
        m0 m0Var;
        long j3 = j;
        long j4 = j2;
        mVar.getClass();
        long j5 = i;
        c2.g(mVar.d(), 0L, j5);
        if (i <= 0) {
            com.github.catvod.spider.merge.s0.a.r("byteCount == 0");
            return 0L;
        }
        if (j3 < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("fromIndex < 0: ", j3));
            return 0L;
        }
        if (j3 > j4) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + j3 + " > " + j4).toString());
        }
        long j6 = jVar.b;
        if (j4 > j6) {
            j4 = j6;
        }
        if (j3 == j4 || (m0Var = jVar.a) == null) {
            return -1L;
        }
        long j7 = 0;
        if (j6 - j3 < j3) {
            while (j6 > j3) {
                m0Var = m0Var.g;
                m0Var.getClass();
                j6 -= m0Var.c - m0Var.b;
            }
            byte[] bArrH = mVar.h();
            byte b2 = bArrH[0];
            long jMin = Math.min(j4, (jVar.b - j5) + 1);
            while (j6 < jMin) {
                byte[] bArr = m0Var.a;
                int iMin = (int) Math.min(m0Var.c, (m0Var.b + jMin) - j6);
                for (int i2 = (int) ((m0Var.b + j3) - j6); i2 < iMin; i2++) {
                    if (bArr[i2] == b2 && b(m0Var, i2 + 1, bArrH, 1, i)) {
                        return (i2 - m0Var.b) + j6;
                    }
                }
                j6 += m0Var.c - m0Var.b;
                m0Var = m0Var.f;
                m0Var.getClass();
                j3 = j6;
            }
            return -1L;
        }
        while (true) {
            long j8 = j7 + (m0Var.c - m0Var.b);
            if (j8 > j3) {
                break;
            }
            m0Var = m0Var.f;
            m0Var.getClass();
            j7 = j8;
        }
        byte[] bArrH2 = mVar.h();
        byte b3 = bArrH2[0];
        long jMin2 = Math.min(j4, (jVar.b - j5) + 1);
        while (j7 < jMin2) {
            byte[] bArr2 = m0Var.a;
            int iMin2 = (int) Math.min(m0Var.c, (m0Var.b + jMin2) - j7);
            for (int i3 = (int) ((m0Var.b + j3) - j7); i3 < iMin2; i3++) {
                if (bArr2[i3] == b3 && b(m0Var, i3 + 1, bArrH2, 1, i)) {
                    return (i3 - m0Var.b) + j7;
                }
            }
            j7 += m0Var.c - m0Var.b;
            m0Var = m0Var.f;
            m0Var.getClass();
            j3 = j7;
        }
        return -1L;
    }

    public static final boolean b(m0 m0Var, int i, byte[] bArr, int i2, int i3) {
        int i4 = m0Var.c;
        byte[] bArr2 = m0Var.a;
        while (i2 < i3) {
            if (i == i4) {
                m0Var = m0Var.f;
                m0Var.getClass();
                byte[] bArr3 = m0Var.a;
                bArr2 = bArr3;
                i = m0Var.b;
                i4 = m0Var.c;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String c(com.github.catvod.spider.merge.y0.j jVar, long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (jVar.A(j2) == 13) {
                String strH = jVar.H(j2, Charsets.UTF_8);
                jVar.skip(2L);
                return strH;
            }
        }
        String strH2 = jVar.H(j, Charsets.UTF_8);
        jVar.skip(1L);
        return strH2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int d(com.github.catvod.spider.merge.y0.j r16, com.github.catvod.spider.merge.y0.f0 r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 171
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.z0.a.d(com.github.catvod.spider.merge.y0.j, com.github.catvod.spider.merge.y0.f0, boolean):int");
    }
}
