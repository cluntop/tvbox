package com.github.catvod.spider.merge.o1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f extends r {
    @Override // com.github.catvod.spider.merge.o1.s
    /* renamed from: clone */
    public final Object h() {
        return (f) super.h();
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final s h() {
        return (f) super.h();
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String r() {
        return "#data";
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final void v(com.github.catvod.spider.merge.n1.a aVar, g gVar) throws androidx.startup.b, IOException {
        String strD = D();
        if (gVar.f != 2 || strD.contains("<![CDATA[")) {
            aVar.b(strD);
            return;
        }
        n nVar = this.a;
        if (nVar != null && nVar.d.c.equals("script")) {
            aVar.b("//<![CDATA[\n").b(strD).b("\n//]]>");
            return;
        }
        n nVar2 = this.a;
        if (nVar2 == null || !nVar2.d.c.equals("style")) {
            aVar.b("<![CDATA[").b(strD).b("]]>");
        } else {
            aVar.b("/*<![CDATA[*/\n").b(strD).b("\n/*]]>*/");
        }
    }
}
