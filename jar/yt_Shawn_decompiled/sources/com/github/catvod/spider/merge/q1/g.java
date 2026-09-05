package com.github.catvod.spider.merge.q1;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g extends p {
    public static boolean b;
    public final /* synthetic */ int a;

    public /* synthetic */ g(int i) {
        this.a = i;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public int a() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return 10;
            case 6:
                return 1;
            case 7:
                return -1;
            case 8:
                return 1;
            default:
                return super.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[ORIG_RETURN, RETURN] */
    @Override // com.github.catvod.spider.merge.q1.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(com.github.catvod.spider.merge.o1.n r10, com.github.catvod.spider.merge.o1.n r11) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.q1.g.b(com.github.catvod.spider.merge.o1.n, com.github.catvod.spider.merge.o1.n):boolean");
    }

    public final String toString() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return "*";
            case 1:
                return ":empty";
            case 2:
                return ":first-child";
            case 3:
                return ":last-child";
            case 4:
                return ":only-child";
            case 5:
                return ":only-of-type";
            case 6:
                return ":root";
            case 7:
                return ":matchText";
            default:
                return ">";
        }
    }
}
