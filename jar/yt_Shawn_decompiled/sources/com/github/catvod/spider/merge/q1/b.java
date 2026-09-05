package com.github.catvod.spider.merge.q1;

import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b extends d {
    public b(List list) {
        this.a.addAll(list);
        g();
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        for (int i = 0; i < this.c; i++) {
            if (!((p) this.b.get(i)).b(nVar, nVar2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean c(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.r rVar) {
        for (int i = 0; i < this.c; i++) {
            if (!((p) this.b.get(i)).c(nVar, rVar)) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return com.github.catvod.spider.merge.n1.i.j(this.a, VideoStream.RESOLUTION_UNKNOWN);
    }
}
