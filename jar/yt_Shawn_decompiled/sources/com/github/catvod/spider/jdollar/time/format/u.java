package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u {
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m h = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(6);
    public static final Map i;
    public u a;
    public final u b;
    public final List c;
    public final boolean d;
    public int e;
    public char f;
    public int g;

    static {
        HashMap map = new HashMap();
        i = map;
        map.put('G', com.github.catvod.spider.jdollar.time.temporal.a.ERA);
        map.put('y', com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA);
        map.put('u', com.github.catvod.spider.jdollar.time.temporal.a.YEAR);
        com.github.catvod.spider.jdollar.time.temporal.g gVar = com.github.catvod.spider.jdollar.time.temporal.i.a;
        map.put('Q', gVar);
        map.put('q', gVar);
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR);
        map.put('d', com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH);
        map.put('F', com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', com.github.catvod.spider.jdollar.time.temporal.a.AMPM_OF_DAY);
        map.put('H', com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY);
        map.put('k', com.github.catvod.spider.jdollar.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', com.github.catvod.spider.jdollar.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE);
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY);
        map.put('g', com.github.catvod.spider.jdollar.time.temporal.k.a);
    }

    public u() {
        this.a = this;
        this.c = new ArrayList();
        this.g = -1;
        this.b = null;
        this.d = false;
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d dVar = dateTimeFormatter.a;
        if (dVar.b) {
            dVar = new d(dVar.a, false);
        }
        c(dVar);
    }

    public final void b(com.github.catvod.spider.jdollar.time.temporal.a aVar, int i2, int i3, boolean z) {
        if (i2 != i3 || z) {
            c(new f(aVar, i2, i3, z));
        } else {
            k(new f(aVar, i2, i3, z));
        }
    }

    public final int c(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        u uVar = this.a;
        int i2 = uVar.e;
        if (i2 > 0) {
            if (eVar != null) {
                eVar = new k(eVar, i2, uVar.f);
            }
            uVar.e = 0;
            uVar.f = (char) 0;
        }
        ((ArrayList) uVar.c).add(eVar);
        this.a.g = -1;
        return ((ArrayList) r5.c).size() - 1;
    }

    public final void d(char c) {
        c(new c(c));
    }

    public final void e(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        int i2 = 1;
        if (str.length() == 1) {
            c(new c(str.charAt(0)));
        } else {
            c(new h(i2, str));
        }
    }

    public final void f(e0 e0Var) {
        Objects.requireNonNull(e0Var, "style");
        if (e0Var == e0.FULL || e0Var == e0.SHORT) {
            c(new h(0, e0Var));
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Style must be either full or short");
        }
    }

    public final void g(String str, String str2) {
        c(new j(str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x03a9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.format.u.h(java.lang.String):void");
    }

    public final void i(com.github.catvod.spider.jdollar.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        e0 e0Var = e0.FULL;
        c(new q(aVar, e0Var, new a(new y(Collections.singletonMap(e0Var, linkedHashMap)))));
    }

    public final void j(com.github.catvod.spider.jdollar.time.temporal.p pVar, e0 e0Var) {
        Objects.requireNonNull(pVar, "field");
        Objects.requireNonNull(e0Var, "textStyle");
        c(new q(pVar, e0Var, z.c));
    }

    public final void k(i iVar) {
        i iVarD;
        u uVar = this.a;
        int i2 = uVar.g;
        if (i2 < 0) {
            uVar.g = c(iVar);
            return;
        }
        i iVar2 = (i) ((ArrayList) uVar.c).get(i2);
        int i3 = iVar.b;
        int i4 = iVar.c;
        if (i3 == i4 && iVar.d == d0.NOT_NEGATIVE) {
            iVarD = iVar2.e(i4);
            c(iVar.d());
            this.a.g = i2;
        } else {
            iVarD = iVar2.d();
            this.a.g = c(iVar);
        }
        ((ArrayList) this.a.c).set(i2, iVarD);
    }

    public final void l(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        Objects.requireNonNull(pVar, "field");
        k(new i(pVar, 1, 19, d0.NORMAL));
    }

    public final void m(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i2) {
        Objects.requireNonNull(pVar, "field");
        if (i2 < 1 || i2 > 19) {
            com.github.catvod.spider.jdollar.nio.file.b.n("The width must be from 1 to 19 inclusive but was ", i2);
        } else {
            k(new i(pVar, i2, i2, d0.NOT_NEGATIVE));
        }
    }

    public final void n(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i2, int i3, d0 d0Var) {
        if (i2 == i3 && d0Var == d0.NOT_NEGATIVE) {
            m(pVar, i3);
            return;
        }
        Objects.requireNonNull(pVar, "field");
        Objects.requireNonNull(d0Var, "signStyle");
        if (i2 < 1 || i2 > 19) {
            com.github.catvod.spider.jdollar.nio.file.b.n("The minimum width must be from 1 to 19 inclusive but was ", i2);
            return;
        }
        if (i3 < 1 || i3 > 19) {
            com.github.catvod.spider.jdollar.nio.file.b.n("The maximum width must be from 1 to 19 inclusive but was ", i3);
            return;
        }
        if (i3 >= i2) {
            k(new i(pVar, i2, i3, d0Var));
            return;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
    }

    public final void o() {
        u uVar = this.a;
        if (uVar.b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        int size = ((ArrayList) uVar.c).size();
        u uVar2 = this.a;
        if (size <= 0) {
            this.a = uVar2.b;
            return;
        }
        d dVar = new d(uVar2.c, uVar2.d);
        this.a = this.a.b;
        c(dVar);
    }

    public final void p() {
        u uVar = this.a;
        uVar.g = -1;
        this.a = new u(uVar);
    }

    public final DateTimeFormatter q(c0 c0Var, com.github.catvod.spider.jdollar.time.chrono.l lVar) {
        return r(Locale.getDefault(), c0Var, lVar);
    }

    public final DateTimeFormatter r(Locale locale, c0 c0Var, com.github.catvod.spider.jdollar.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.a.b != null) {
            o();
        }
        d dVar = new d(this.c, false);
        a0 a0Var = a0.a;
        return new DateTimeFormatter(dVar, locale, c0Var, lVar);
    }

    public u(u uVar) {
        this.a = this;
        this.c = new ArrayList();
        this.g = -1;
        this.b = uVar;
        this.d = true;
    }
}
