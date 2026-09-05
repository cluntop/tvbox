package com.github.catvod.spider.merge.o1;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p {
    public static final char[] a = {',', ';'};
    public static final HashMap b = new HashMap();
    public static final ArrayList c = new ArrayList(106);
    public static final com.github.catvod.spider.merge.n1.c d = new com.github.catvod.spider.merge.n1.c(new com.github.catvod.spider.merge.n1.b(2), 1);
    public static final ThreadLocal e = new ThreadLocal();

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.github.catvod.spider.merge.n1.a r4, com.github.catvod.spider.merge.o1.o r5, int r6) throws androidx.startup.b, java.io.IOException {
        /*
            int[] r0 = r5.c
            int r0 = java.util.Arrays.binarySearch(r0, r6)
            java.lang.String r1 = ""
            if (r0 < 0) goto L1f
            java.lang.String[] r2 = r5.d
            int r3 = r2.length
            int r3 = r3 + (-1)
            if (r0 >= r3) goto L1c
            int[] r5 = r5.c
            int r3 = r0 + 1
            r5 = r5[r3]
            if (r5 != r6) goto L1c
            r5 = r2[r3]
            goto L20
        L1c:
            r5 = r2[r0]
            goto L20
        L1f:
            r5 = r1
        L20:
            boolean r0 = r1.equals(r5)
            r1 = 59
            if (r0 != 0) goto L36
            r6 = 38
            com.github.catvod.spider.merge.n1.a r4 = r4.a(r6)
            com.github.catvod.spider.merge.n1.a r4 = r4.b(r5)
            r4.a(r1)
            return
        L36:
            java.lang.String r5 = "&#x"
            com.github.catvod.spider.merge.n1.a r4 = r4.b(r5)
            java.lang.String r5 = java.lang.Integer.toHexString(r6)
            com.github.catvod.spider.merge.n1.a r4 = r4.b(r5)
            r4.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.o1.p.a(com.github.catvod.spider.merge.n1.a, com.github.catvod.spider.merge.o1.o, int):void");
    }

    public static boolean b(int i, char c2, CharsetEncoder charsetEncoder) {
        int iD = com.github.catvod.spider.merge.u.o.d(i);
        if (iD != 0) {
            if (iD != 1) {
                return charsetEncoder.canEncode(c2);
            }
            if (c2 >= 55296 && c2 < 57344) {
                return false;
            }
        } else if (c2 >= 128) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[PHI: r8 r9 r10
      0x0062: PHI (r8v4 boolean) = 
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v2 boolean)
      (r8v1 boolean)
      (r8v1 boolean)
     binds: [B:94:0x0130, B:93:0x012b, B:92:0x0124, B:89:0x0119, B:88:0x0112, B:87:0x010b, B:86:0x0104, B:84:0x00fb, B:83:0x00f6, B:82:0x00ef, B:81:0x00e8, B:75:0x00da, B:74:0x00d6, B:48:0x009f, B:50:0x00a4, B:26:0x0060, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0062: PHI (r9v4 boolean) = 
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v2 boolean)
      (r9v1 boolean)
      (r9v1 boolean)
     binds: [B:94:0x0130, B:93:0x012b, B:92:0x0124, B:89:0x0119, B:88:0x0112, B:87:0x010b, B:86:0x0104, B:84:0x00fb, B:83:0x00f6, B:82:0x00ef, B:81:0x00e8, B:75:0x00da, B:74:0x00d6, B:48:0x009f, B:50:0x00a4, B:26:0x0060, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0062: PHI (r10v4 boolean) = 
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v2 boolean)
      (r10v1 boolean)
      (r10v1 boolean)
     binds: [B:94:0x0130, B:93:0x012b, B:92:0x0124, B:89:0x0119, B:88:0x0112, B:87:0x010b, B:86:0x0104, B:84:0x00fb, B:83:0x00f6, B:82:0x00ef, B:81:0x00e8, B:75:0x00da, B:74:0x00d6, B:48:0x009f, B:50:0x00a4, B:26:0x0060, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r16, com.github.catvod.spider.merge.n1.a r17, com.github.catvod.spider.merge.o1.o r18, java.nio.charset.Charset r19, int r20) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.o1.p.c(java.lang.String, com.github.catvod.spider.merge.n1.a, com.github.catvod.spider.merge.o1.o, java.nio.charset.Charset, int):void");
    }

    public static String d(String str) {
        o oVar = o.base;
        Charset charset = com.github.catvod.spider.merge.m1.a.a;
        if (str == null) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        c(str, com.github.catvod.spider.merge.n1.a.e(sbB), oVar, charset, 3);
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }
}
