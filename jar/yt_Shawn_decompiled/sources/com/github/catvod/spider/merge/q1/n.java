package com.github.catvod.spider.merge.q1;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class n extends p {
    public final int a;
    public final int b;
    public final /* synthetic */ int c;

    public n(int i, int i2, int i3) {
        this.c = i3;
        this.a = i;
        this.b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[RETURN] */
    @Override // com.github.catvod.spider.merge.q1.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(com.github.catvod.spider.merge.o1.n r9, com.github.catvod.spider.merge.o1.n r10) {
        /*
            r8 = this;
            com.github.catvod.spider.merge.o1.n r9 = r10.a
            r0 = 0
            if (r9 == 0) goto L92
            boolean r9 = r9 instanceof com.github.catvod.spider.merge.o1.h
            if (r9 == 0) goto Lb
            goto L92
        Lb:
            int r9 = r8.c
            r1 = 1
            switch(r9) {
                case 0: goto L7a;
                case 1: goto L5c;
                case 2: goto L3c;
                default: goto L11;
            }
        L11:
            com.github.catvod.spider.merge.o1.n r9 = r10.a
            if (r9 != 0) goto L18
        L15:
            r4 = 0
            goto L80
        L18:
            com.github.catvod.spider.merge.o1.m r2 = r9.e
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L20:
            if (r3 >= r2) goto L80
            com.github.catvod.spider.merge.o1.s r5 = r9.f(r3)
            java.lang.String r6 = r5.t()
            com.github.catvod.spider.merge.p1.f0 r7 = r10.d
            java.lang.String r7 = r7.c
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L36
            int r4 = r4 + 1
        L36:
            if (r5 != r10) goto L39
            goto L80
        L39:
            int r3 = r3 + 1
            goto L20
        L3c:
            com.github.catvod.spider.merge.o1.n r9 = r10.a
            if (r9 != 0) goto L41
            goto L15
        L41:
            r9 = r10
            r2 = 0
        L43:
            if (r9 == 0) goto L5a
            com.github.catvod.spider.merge.p1.f0 r3 = r9.d
            java.lang.String r3 = r3.c
            com.github.catvod.spider.merge.p1.f0 r4 = r10.d
            java.lang.String r4 = r4.c
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L55
            int r2 = r2 + 1
        L55:
            com.github.catvod.spider.merge.o1.n r9 = r9.p()
            goto L43
        L5a:
            r4 = r2
            goto L80
        L5c:
            com.github.catvod.spider.merge.o1.n r9 = r10.a
            if (r9 != 0) goto L61
            goto L15
        L61:
            com.github.catvod.spider.merge.o1.m r2 = r9.e
            int r2 = r2.size()
            if (r2 != 0) goto L6b
            r9 = 0
            goto L73
        L6b:
            java.util.List r9 = r9.H()
            int r9 = r9.size()
        L73:
            int r10 = r10.K()
            int r9 = r9 - r10
            r4 = r9
            goto L80
        L7a:
            int r9 = r10.K()
            int r4 = r9 + 1
        L80:
            int r9 = r8.a
            int r10 = r8.b
            if (r9 != 0) goto L89
            if (r4 != r10) goto L92
            goto L91
        L89:
            int r4 = r4 - r10
            int r10 = r4 * r9
            if (r10 < 0) goto L92
            int r4 = r4 % r9
            if (r4 != 0) goto L92
        L91:
            return r1
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.q1.n.b(com.github.catvod.spider.merge.o1.n, com.github.catvod.spider.merge.o1.n):boolean");
    }

    public String toString() {
        String str;
        int i = this.b;
        int i2 = this.a;
        String str2 = i2 == 0 ? ":%s(%3$d)" : i == 0 ? ":%s(%2$dn)" : ":%s(%2$dn%3$+d)";
        switch (this.c) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                str = "nth-child";
                break;
            case 1:
                str = "nth-last-child";
                break;
            case 2:
                str = "nth-last-of-type";
                break;
            default:
                str = "nth-of-type";
                break;
        }
        return String.format(str2, str, Integer.valueOf(i2), Integer.valueOf(i));
    }
}
