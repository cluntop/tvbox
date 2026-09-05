package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.merge.u.c2;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o extends p {
    public final /* synthetic */ int a;
    public final com.github.catvod.spider.merge.m1.f b;

    public /* synthetic */ o(com.github.catvod.spider.merge.m1.f fVar, int i) {
        this.a = i;
        this.b = fVar;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return 8;
            case 1:
                return 7;
            case 2:
                return 7;
            default:
                return 8;
        }
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        int i = this.a;
        com.github.catvod.spider.merge.m1.f fVar = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return fVar.b(nVar2.U()).find();
            case 1:
                return fVar.b(nVar2.S()).find();
            case 2:
                return fVar.b(nVar2.V()).find();
            default:
                nVar2.getClass();
                return fVar.b((String) c2.W(nVar2, com.github.catvod.spider.merge.o1.s.class).map(new com.github.catvod.spider.merge.n1.g(1)).collect(com.github.catvod.spider.merge.n1.i.k(VideoStream.RESOLUTION_UNKNOWN))).find();
        }
    }

    public final String toString() {
        int i = this.a;
        com.github.catvod.spider.merge.m1.f fVar = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return String.format(":matches(%s)", fVar);
            case 1:
                return String.format(":matchesOwn(%s)", fVar);
            case 2:
                return String.format(":matchesWholeOwnText(%s)", fVar);
            default:
                return String.format(":matchesWholeText(%s)", fVar);
        }
    }
}
