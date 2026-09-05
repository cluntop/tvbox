package com.github.catvod.spider.merge.p1;

import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o0 extends p0 {
    @Override // com.github.catvod.spider.merge.p1.p0, com.github.catvod.spider.merge.p1.r0
    /* renamed from: m */
    public final p0 f() {
        super.f();
        this.g = null;
        return this;
    }

    public final String toString() {
        String str = this.f ? "/>" : ">";
        com.github.catvod.spider.merge.o1.c cVar = this.g;
        if (cVar == null || cVar.size() <= 0) {
            return "<" + n() + str;
        }
        return "<" + n() + Stream.ID_UNKNOWN + this.g.toString() + str;
    }
}
