package com.github.catvod.spider.jdollar.time.format;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q implements e {
    public final com.github.catvod.spider.jdollar.time.temporal.p a;
    public final e0 b;
    public final z c;
    public volatile i d;

    public q(com.github.catvod.spider.jdollar.time.temporal.p pVar, e0 e0Var, z zVar) {
        this.a = pVar;
        this.b = e0Var;
        this.c = zVar;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        Long lA = wVar.a(this.a);
        DateTimeFormatter dateTimeFormatter = wVar.b;
        if (lA == null) {
            return false;
        }
        com.github.catvod.spider.jdollar.time.chrono.l lVar = (com.github.catvod.spider.jdollar.time.chrono.l) wVar.a.y(com.github.catvod.spider.jdollar.time.temporal.q.b);
        String strC = (lVar == null || lVar == com.github.catvod.spider.jdollar.time.chrono.t.c) ? this.c.c(this.a, lA.longValue(), this.b, dateTimeFormatter.b) : this.c.b(lVar, this.a, lA.longValue(), this.b, dateTimeFormatter.b);
        if (strC != null) {
            sb.append(strC);
            return true;
        }
        if (this.d == null) {
            this.d = new i(this.a, 1, 19, d0.NORMAL);
        }
        return this.d.h(wVar, sb);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        z zVar = this.c;
        com.github.catvod.spider.jdollar.time.temporal.p pVar = this.a;
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        boolean z = vVar.c;
        DateTimeFormatter dateTimeFormatter = vVar.a;
        e0 e0Var = z ? this.b : null;
        com.github.catvod.spider.jdollar.time.chrono.l lVar = vVar.c().c;
        if (lVar == null && (lVar = vVar.a.e) == null) {
            lVar = com.github.catvod.spider.jdollar.time.chrono.t.c;
        }
        com.github.catvod.spider.jdollar.time.chrono.l lVar2 = lVar;
        Iterator itE = (lVar2 == null || lVar2 == com.github.catvod.spider.jdollar.time.chrono.t.c) ? zVar.e(pVar, e0Var, dateTimeFormatter.b) : zVar.d(lVar2, pVar, e0Var, dateTimeFormatter.b);
        if (itE != null) {
            while (itE.hasNext()) {
                Map.Entry entry = (Map.Entry) itE.next();
                String str = (String) entry.getKey();
                if (vVar.g(str, 0, charSequence, i, str.length())) {
                    return vVar.f(this.a, ((Long) entry.getValue()).longValue(), i, str.length() + i);
                }
            }
            if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA && !vVar.c) {
                Iterator it = lVar2.u().iterator();
                while (it.hasNext()) {
                    String string = ((com.github.catvod.spider.jdollar.time.chrono.n) it.next()).toString();
                    if (vVar.g(string, 0, charSequence, i, string.length())) {
                        return vVar.f(this.a, r7.getValue(), i, string.length() + i);
                    }
                }
            }
            if (vVar.c) {
                return ~i;
            }
        }
        if (this.d == null) {
            this.d = new i(this.a, 1, 19, d0.NORMAL);
        }
        return this.d.i(vVar, charSequence, i);
    }

    public final String toString() {
        e0 e0Var = e0.FULL;
        e0 e0Var2 = this.b;
        com.github.catvod.spider.jdollar.time.temporal.p pVar = this.a;
        if (e0Var2 == e0Var) {
            return "Text(" + pVar + ")";
        }
        return "Text(" + pVar + "," + e0Var2 + ")";
    }
}
