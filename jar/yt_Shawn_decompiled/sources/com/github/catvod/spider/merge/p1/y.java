package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum y extends b0 {
    public y() {
        super("Text", 7);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (r0Var.a == 5) {
            bVar.u((j0) r0Var, false);
            return true;
        }
        if (!r0Var.c()) {
            if (!r0Var.d()) {
                return true;
            }
            bVar.F();
            bVar.l = bVar.m;
            return true;
        }
        bVar.k(this);
        bVar.F();
        b0 b0Var = bVar.m;
        bVar.l = b0Var;
        if (b0Var == b0.h) {
            bVar.l = b0.g;
        }
        return bVar.I(r0Var);
    }
}
