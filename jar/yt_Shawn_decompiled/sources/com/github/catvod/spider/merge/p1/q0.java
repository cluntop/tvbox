package com.github.catvod.spider.merge.p1;

import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q0 extends p0 {
    public boolean k;

    @Override // com.github.catvod.spider.merge.p1.p0
    /* renamed from: m */
    public final /* bridge */ /* synthetic */ p0 f() {
        f();
        return this;
    }

    @Override // com.github.catvod.spider.merge.p1.p0, com.github.catvod.spider.merge.p1.r0
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void f() {
        super.f();
        this.k = true;
    }

    public final String toString() {
        boolean z = this.k;
        String str = z ? "<!" : "<?";
        String str2 = z ? ">" : "?>";
        com.github.catvod.spider.merge.o1.c cVar = this.g;
        if (cVar == null || cVar.size() <= 0) {
            return str + n() + str2;
        }
        return str + n() + Stream.ID_UNKNOWN + this.g.toString() + str2;
    }
}
