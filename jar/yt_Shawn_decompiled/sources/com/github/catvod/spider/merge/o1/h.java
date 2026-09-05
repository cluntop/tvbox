package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.merge.p1.e0;
import com.github.catvod.spider.merge.p1.f0;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h extends n {
    public g j;
    public e0 k;
    public int l;

    public h(String str, String str2, e0 e0Var) {
        super(new f0("#root", com.github.catvod.spider.merge.n1.a.d("#root"), str), str2, null);
        this.j = new g();
        this.l = 1;
        this.k = e0Var;
    }

    public final n W() {
        n nVarM = M();
        while (true) {
            if (nVarM == null) {
                nVarM = E("html");
                break;
            }
            if (nVarM.o("html")) {
                break;
            }
            nVarM = nVarM.p();
        }
        for (n nVarM2 = nVarM.M(); nVarM2 != null; nVarM2 = nVarM2.p()) {
            if (nVarM2.o("body") || nVarM2.o("frameset")) {
                return nVarM2;
            }
        }
        return nVarM.E("body");
    }

    @Override // com.github.catvod.spider.merge.o1.n, com.github.catvod.spider.merge.o1.s
    /* renamed from: X, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h h() {
        h hVar = (h) super.h();
        c cVar = this.f;
        if (cVar != null) {
            hVar.f = cVar.clone();
        }
        hVar.j = this.j.clone();
        return hVar;
    }

    @Override // com.github.catvod.spider.merge.o1.n, com.github.catvod.spider.merge.o1.s
    public final String r() {
        return "#document";
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String u() {
        return P();
    }

    public h() {
        this("http://www.w3.org/1999/xhtml", VideoStream.RESOLUTION_UNKNOWN, new e0(new com.github.catvod.spider.merge.p1.b()));
    }
}
