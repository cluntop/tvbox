package com.github.catvod.spider.jdollar.time.format;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h implements e {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ h(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public static void a(StringBuilder sb, int i) {
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
    }

    public static int b(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if (cCharAt < '0' || cCharAt > '9') {
            return -1;
        }
        return cCharAt - '0';
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                Long lA = wVar.a(com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS);
                if (lA != null) {
                    sb.append("GMT");
                    int iY = com.github.catvod.spider.jdollar.com.android.tools.r8.a.y(lA.longValue());
                    if (iY != 0) {
                        int iAbs = Math.abs((iY / 3600) % 100);
                        int iAbs2 = Math.abs((iY / 60) % 60);
                        int iAbs3 = Math.abs(iY % 60);
                        sb.append(iY < 0 ? "-" : "+");
                        if (((e0) obj) != e0.FULL) {
                            if (iAbs >= 10) {
                                sb.append((char) ((iAbs / 10) + 48));
                            }
                            sb.append((char) ((iAbs % 10) + 48));
                            if (iAbs2 != 0 || iAbs3 != 0) {
                                sb.append(':');
                                a(sb, iAbs2);
                                if (iAbs3 != 0) {
                                    sb.append(':');
                                    a(sb, iAbs3);
                                    break;
                                }
                            }
                        } else {
                            a(sb, iAbs);
                            sb.append(':');
                            a(sb, iAbs2);
                            if (iAbs3 != 0) {
                                sb.append(':');
                                a(sb, iAbs3);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                sb.append((String) obj);
                break;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0122 A[PHI: r5 r15
      0x0122: PHI (r5v1 int) = (r5v0 int), (r5v2 int), (r5v2 int), (r5v2 int), (r5v2 int), (r5v2 int), (r5v2 int) binds: [B:50:0x00cc, B:55:0x00dc, B:57:0x00e2, B:58:0x00e4, B:60:0x00ea, B:62:0x00f6, B:63:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      0x0122: PHI (r15v5 int) = (r15v4 int), (r15v7 int), (r15v7 int), (r15v7 int), (r15v7 int), (r15v7 int), (r15v7 int) binds: [B:50:0x00cc, B:55:0x00dc, B:57:0x00e2, B:58:0x00e4, B:60:0x00ea, B:62:0x00f6, B:63:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.github.catvod.spider.jdollar.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int i(com.github.catvod.spider.jdollar.time.format.v r13, java.lang.CharSequence r14, int r15) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.format.h.i(com.github.catvod.spider.jdollar.time.format.v, java.lang.CharSequence, int):int");
    }

    public final String toString() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return "LocalizedOffset(" + ((e0) obj) + ")";
            default:
                return "'" + ((String) obj).replace("'", "''") + "'";
        }
    }
}
