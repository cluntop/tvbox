package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum m extends b0 {
    public m() {
        super("Initial", 0);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (b0.a(r0Var)) {
            return true;
        }
        if (r0Var.a()) {
            bVar.w((k0) r0Var);
            return true;
        }
        boolean zB = r0Var.b();
        s sVar = b0.b;
        if (!zB) {
            bVar.d.l = 2;
            bVar.l = sVar;
            return bVar.I(r0Var);
        }
        l0 l0Var = (l0) r0Var;
        d0 d0Var = bVar.h;
        String strJ = l0Var.d.j();
        d0Var.getClass();
        String strTrim = strJ.trim();
        if (!d0Var.a) {
            strTrim = com.github.catvod.spider.merge.n1.a.c(strTrim);
        }
        String strJ2 = l0Var.f.j();
        String strJ3 = l0Var.g.j();
        com.github.catvod.spider.merge.o1.i iVar = new com.github.catvod.spider.merge.o1.i(strTrim);
        com.github.catvod.spider.merge.u.c2.R(strJ2);
        com.github.catvod.spider.merge.u.c2.R(strJ3);
        com.github.catvod.spider.merge.o1.c cVarD = iVar.d();
        cVarD.a("name", strTrim);
        cVarD.a("publicId", strJ2);
        cVarD.a("systemId", strJ3);
        if (iVar.F("publicId")) {
            iVar.d().a("pubSysKey", "PUBLIC");
        } else if (iVar.F("systemId")) {
            iVar.d().a("pubSysKey", "SYSTEM");
        }
        String str = l0Var.e;
        if (str != null) {
            iVar.c("pubSysKey", str);
        }
        bVar.d.D(iVar);
        if (l0Var.i || !iVar.b("name").equals("html") || iVar.b("publicId").equalsIgnoreCase("HTML")) {
            bVar.d.l = 2;
        }
        bVar.l = sVar;
        return true;
    }
}
