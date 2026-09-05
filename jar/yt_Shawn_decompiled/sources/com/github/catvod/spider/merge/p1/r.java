package com.github.catvod.spider.merge.p1;

import java.util.ArrayList;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum r extends b0 {
    public r() {
        super("ForeignContent", 23);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        com.github.catvod.spider.merge.o1.c cVar;
        com.github.catvod.spider.merge.o1.c cVar2;
        com.github.catvod.spider.merge.o1.c cVar3;
        com.github.catvod.spider.merge.o1.n nVarH;
        int iD = com.github.catvod.spider.merge.u.o.d(r0Var.a);
        if (iD == 0) {
            bVar.k(this);
            return true;
        }
        if (iD == 1) {
            o0 o0Var = (o0) r0Var;
            if (com.github.catvod.spider.merge.n1.i.c(o0Var.e, a0.L)) {
                return bVar.l.d(r0Var, bVar);
            }
            if (o0Var.e.equals("font") && (((cVar = o0Var.g) != null && cVar.k("color") != -1) || (((cVar2 = o0Var.g) != null && cVar2.k("face") != -1) || ((cVar3 = o0Var.g) != null && cVar3.k("size") != -1)))) {
                return bVar.l.d(r0Var, bVar);
            }
            String str = bVar.h().d.a;
            bVar.z(o0Var, str);
            l3 l3VarF = bVar.i.d(o0Var.d.j(), o0Var.e, str, bVar.h.a).f();
            if (l3VarF != null) {
                boolean zEquals = o0Var.e.equals("script");
                t0 t0Var = bVar.c;
                if (zEquals) {
                    t0Var.o(l3.f);
                    return true;
                }
                t0Var.o(l3VarF);
            }
        } else {
            if (iD == 2) {
                n0 n0Var = (n0) r0Var;
                if (n0Var.e.equals("br") || n0Var.e.equals("p")) {
                    return bVar.l.d(r0Var, bVar);
                }
                if (n0Var.e.equals("script") && bVar.e.size() != 0 && (nVarH = bVar.h()) != null) {
                    f0 f0Var = nVarH.d;
                    if (f0Var.c.equals("script") && f0Var.a.equals("http://www.w3.org/2000/svg")) {
                        bVar.F();
                        return true;
                    }
                }
                ArrayList arrayList = bVar.e;
                if (arrayList.isEmpty()) {
                    com.github.catvod.spider.merge.s0.a.h("Stack unexpectedly empty");
                    return false;
                }
                int size = arrayList.size() - 1;
                com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) arrayList.get(size);
                if (!nVar.o(n0Var.e)) {
                    bVar.k(this);
                }
                do {
                    if (size != 0) {
                        if (nVar.o(n0Var.e)) {
                            String str2 = nVar.d.c;
                            for (int size2 = bVar.e.size() - 1; size2 >= 0 && !bVar.F().o(str2); size2--) {
                            }
                        } else {
                            size--;
                            nVar = (com.github.catvod.spider.merge.o1.n) arrayList.get(size);
                        }
                    }
                } while (!nVar.d.a.equals("http://www.w3.org/1999/xhtml"));
                return bVar.l.d(r0Var, bVar);
            }
            if (iD == 3) {
                bVar.w((k0) r0Var);
                return true;
            }
            if (iD == 4) {
                j0 j0Var = (j0) r0Var;
                if (b0.a(j0Var)) {
                    bVar.u(j0Var, false);
                    return true;
                }
                bVar.u(j0Var, true);
                bVar.u = false;
                return true;
            }
            if (iD != 6) {
                com.github.catvod.spider.merge.s0.a.h("Unexpected state: ".concat(com.github.catvod.spider.merge.b.b.C(r0Var.a)));
                return false;
            }
        }
        return true;
    }
}
