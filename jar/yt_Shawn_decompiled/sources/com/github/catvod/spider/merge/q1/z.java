package com.github.catvod.spider.merge.q1;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class z extends e0 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(p pVar, int i) {
        super(pVar);
        this.d = i;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        switch (this.d) {
        }
        return this.a.a() + 2;
    }

    @Override // com.github.catvod.spider.merge.q1.e0
    public final boolean g(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        switch (this.d) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (nVar != sVar) {
                    for (com.github.catvod.spider.merge.o1.n nVarX = sVar.x(); nVarX != null; nVarX = nVarX.a) {
                        if (h(nVar, nVarX)) {
                            return true;
                        }
                        if (nVarX != nVar) {
                        }
                    }
                }
                return false;
            case 1:
                return this.a.d(nVar, sVar);
            default:
                return !h(nVar, sVar);
        }
    }

    public final String toString() {
        int i = this.d;
        p pVar = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return String.format("%s ", pVar);
            case 1:
                return String.format(":is(%s)", pVar);
            default:
                return String.format(":not(%s)", pVar);
        }
    }
}
