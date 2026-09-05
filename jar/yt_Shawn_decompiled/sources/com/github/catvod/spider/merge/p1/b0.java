package com.github.catvod.spider.merge.p1;

import java.util.Map;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b0 {
    public static final m a = new m();
    public static final s b = new s();
    public static final t c = new t();
    public static final u d = new u();
    public static final v e = new v();
    public static final w f = new w();
    public static final x g = new x();
    public static final y h = new y();
    public static final z i = new z();
    public static final c j = new c();
    public static final d k = new d();
    public static final e l = new e();
    public static final f m = new f();
    public static final g n = new g();
    public static final h o = new h();
    public static final i p = new i();
    public static final j q = new j();
    public static final k r = new k();
    public static final l s = new l();
    public static final n t = new n();
    public static final o u = new o();
    public static final p v = new p();
    public static final q w = new q();
    public static final r x = new r();

    static {
        String.valueOf((char) 0);
    }

    public static boolean a(r0 r0Var) {
        if (r0Var.a == 5) {
            return com.github.catvod.spider.merge.n1.i.f(((j0) r0Var).d.j());
        }
        return false;
    }

    public static void b(o0 o0Var, b bVar, l3 l3Var) {
        if (l3Var != null) {
            bVar.c.o(l3Var);
        }
        bVar.m = bVar.l;
        bVar.l = h;
        bVar.x(o0Var);
    }

    public static void c(o0 o0Var, com.github.catvod.spider.merge.o1.n nVar) {
        com.github.catvod.spider.merge.o1.c cVar = o0Var.g;
        if (cVar != null) {
            cVar.getClass();
            com.github.catvod.spider.merge.o1.b bVar = new com.github.catvod.spider.merge.o1.b(cVar);
            while (bVar.hasNext()) {
                com.github.catvod.spider.merge.o1.a aVar = (com.github.catvod.spider.merge.o1.a) bVar.next();
                String str = aVar.a;
                com.github.catvod.spider.merge.o1.c cVarD = nVar.d();
                if (!cVarD.g(str)) {
                    com.github.catvod.spider.merge.o1.c cVar2 = aVar.c;
                    if (cVar2 != null && cVar2.g(str)) {
                        Map map = (Map) (!cVar2.g("/jsoup.userdata") ? null : cVar2.o().get("jsoup.attrs"));
                        if (map == null || ((com.github.catvod.spider.merge.o1.w) map.get(str)) == null) {
                            int i2 = com.github.catvod.spider.merge.o1.w.c;
                        }
                    } else {
                        int i3 = com.github.catvod.spider.merge.o1.w.c;
                    }
                    cVarD.m(str, com.github.catvod.spider.merge.o1.c.c(aVar.b));
                    aVar.c = cVarD;
                }
            }
        }
    }

    public abstract boolean d(r0 r0Var, b bVar);
}
