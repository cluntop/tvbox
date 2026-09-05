package com.github.catvod.spider.merge.q1;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r extends t {
    public final /* synthetic */ int a = 1;
    public final Object b;

    public r(String str) {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        com.github.catvod.spider.merge.n1.i.a(sbB, str, false);
        this.b = com.github.catvod.spider.merge.n1.a.c(com.github.catvod.spider.merge.n1.i.l(sbB));
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return 6;
            default:
                return 8;
        }
    }

    @Override // com.github.catvod.spider.merge.q1.t
    public final boolean g(com.github.catvod.spider.merge.o1.s sVar) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return com.github.catvod.spider.merge.n1.a.c(sVar.s()).contains((String) obj);
            default:
                return ((com.github.catvod.spider.merge.m1.f) obj).b(sVar.s()).find();
        }
    }

    public final String toString() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return com.github.catvod.spider.merge.b.b.A(":contains(", (String) obj, ")");
            default:
                return String.format(":matches(%s)", (com.github.catvod.spider.merge.m1.f) obj);
        }
    }

    public r(com.github.catvod.spider.merge.m1.f fVar) {
        this.b = fVar;
    }
}
