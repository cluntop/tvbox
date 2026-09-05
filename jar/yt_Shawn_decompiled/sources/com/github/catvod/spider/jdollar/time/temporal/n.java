package com.github.catvod.spider.jdollar.time.temporal;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements m {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ n(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final l o(l lVar) {
        int i = this.a;
        int i2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                int iH = lVar.h(a.DAY_OF_WEEK);
                if (iH == i2) {
                    return lVar;
                }
                return lVar.c(iH - i2 >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
            default:
                int iH2 = lVar.h(a.DAY_OF_WEEK);
                if (iH2 == i2) {
                    return lVar;
                }
                return lVar.t(i2 - iH2 >= 0 ? 7 - r1 : -r1, ChronoUnit.DAYS);
        }
    }
}
