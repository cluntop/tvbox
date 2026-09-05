package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter f;
    public static final DateTimeFormatter g;
    public static final DateTimeFormatter h;
    public final d a;
    public final Locale b;
    public final a0 c;
    public final c0 d;
    public final com.github.catvod.spider.jdollar.time.chrono.l e;

    static {
        u uVar = new u();
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        d0 d0Var = d0.EXCEEDS_PAD;
        uVar.n(aVar, 4, 10, d0Var);
        uVar.d('-');
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR;
        uVar.m(aVar2, 2);
        uVar.d('-');
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH;
        uVar.m(aVar3, 2);
        c0 c0Var = c0.STRICT;
        com.github.catvod.spider.jdollar.time.chrono.t tVar = com.github.catvod.spider.jdollar.time.chrono.t.c;
        DateTimeFormatter dateTimeFormatterQ = uVar.q(c0Var, tVar);
        f = dateTimeFormatterQ;
        u uVar2 = new u();
        p pVar = p.INSENSITIVE;
        uVar2.c(pVar);
        uVar2.a(dateTimeFormatterQ);
        j jVar = j.e;
        uVar2.c(jVar);
        uVar2.q(c0Var, tVar);
        u uVar3 = new u();
        uVar3.c(pVar);
        uVar3.a(dateTimeFormatterQ);
        uVar3.p();
        uVar3.c(jVar);
        uVar3.q(c0Var, tVar);
        u uVar4 = new u();
        com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY;
        uVar4.m(aVar4, 2);
        uVar4.d(':');
        com.github.catvod.spider.jdollar.time.temporal.a aVar5 = com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR;
        uVar4.m(aVar5, 2);
        uVar4.p();
        uVar4.d(':');
        com.github.catvod.spider.jdollar.time.temporal.a aVar6 = com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE;
        uVar4.m(aVar6, 2);
        uVar4.p();
        uVar4.b(com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatterQ2 = uVar4.q(c0Var, null);
        u uVar5 = new u();
        uVar5.c(pVar);
        uVar5.a(dateTimeFormatterQ2);
        uVar5.c(jVar);
        uVar5.q(c0Var, null);
        u uVar6 = new u();
        uVar6.c(pVar);
        uVar6.a(dateTimeFormatterQ2);
        uVar6.p();
        uVar6.c(jVar);
        uVar6.q(c0Var, null);
        u uVar7 = new u();
        uVar7.c(pVar);
        uVar7.a(dateTimeFormatterQ);
        uVar7.d('T');
        uVar7.a(dateTimeFormatterQ2);
        DateTimeFormatter dateTimeFormatterQ3 = uVar7.q(c0Var, tVar);
        u uVar8 = new u();
        uVar8.c(pVar);
        uVar8.a(dateTimeFormatterQ3);
        p pVar2 = p.LENIENT;
        uVar8.c(pVar2);
        uVar8.c(jVar);
        p pVar3 = p.STRICT;
        uVar8.c(pVar3);
        DateTimeFormatter dateTimeFormatterQ4 = uVar8.q(c0Var, tVar);
        g = dateTimeFormatterQ4;
        u uVar9 = new u();
        uVar9.a(dateTimeFormatterQ4);
        uVar9.p();
        uVar9.d('[');
        p pVar4 = p.SENSITIVE;
        uVar9.c(pVar4);
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar = u.h;
        uVar9.c(new s(mVar, "ZoneRegionId()"));
        uVar9.d(']');
        uVar9.q(c0Var, tVar);
        u uVar10 = new u();
        uVar10.a(dateTimeFormatterQ3);
        uVar10.p();
        uVar10.c(jVar);
        uVar10.p();
        uVar10.d('[');
        uVar10.c(pVar4);
        uVar10.c(new s(mVar, "ZoneRegionId()"));
        uVar10.d(']');
        uVar10.q(c0Var, tVar);
        u uVar11 = new u();
        uVar11.c(pVar);
        uVar11.n(aVar, 4, 10, d0Var);
        uVar11.d('-');
        uVar11.m(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR, 3);
        uVar11.p();
        uVar11.c(jVar);
        uVar11.q(c0Var, tVar);
        u uVar12 = new u();
        uVar12.c(pVar);
        uVar12.n(com.github.catvod.spider.jdollar.time.temporal.i.c, 4, 10, d0Var);
        uVar12.e("-W");
        uVar12.m(com.github.catvod.spider.jdollar.time.temporal.i.b, 2);
        uVar12.d('-');
        com.github.catvod.spider.jdollar.time.temporal.a aVar7 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_WEEK;
        uVar12.m(aVar7, 1);
        uVar12.p();
        uVar12.c(jVar);
        uVar12.q(c0Var, tVar);
        u uVar13 = new u();
        uVar13.c(pVar);
        uVar13.c(new g());
        h = uVar13.q(c0Var, null);
        u uVar14 = new u();
        uVar14.c(pVar);
        uVar14.m(aVar, 4);
        uVar14.m(aVar2, 2);
        uVar14.m(aVar3, 2);
        uVar14.p();
        uVar14.c(pVar2);
        uVar14.g("+HHMMss", "Z");
        uVar14.c(pVar3);
        uVar14.q(c0Var, tVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        u uVar15 = new u();
        uVar15.c(pVar);
        uVar15.c(pVar2);
        uVar15.p();
        uVar15.i(aVar7, map);
        uVar15.e(", ");
        uVar15.o();
        uVar15.n(aVar3, 1, 2, d0.NOT_NEGATIVE);
        uVar15.d(' ');
        uVar15.i(aVar2, map2);
        uVar15.d(' ');
        uVar15.m(aVar, 4);
        uVar15.d(' ');
        uVar15.m(aVar4, 2);
        uVar15.d(':');
        uVar15.m(aVar5, 2);
        uVar15.p();
        uVar15.d(':');
        uVar15.m(aVar6, 2);
        uVar15.o();
        uVar15.d(' ');
        uVar15.g("+HHMM", "GMT");
        uVar15.q(c0.SMART, tVar);
    }

    public DateTimeFormatter(d dVar, Locale locale, c0 c0Var, com.github.catvod.spider.jdollar.time.chrono.l lVar) {
        a0 a0Var = a0.a;
        this.a = (d) Objects.requireNonNull(dVar, "printerParser");
        this.b = (Locale) Objects.requireNonNull(locale, "locale");
        this.c = (a0) Objects.requireNonNull(a0Var, "decimalStyle");
        this.d = (c0) Objects.requireNonNull(c0Var, "resolverStyle");
        this.e = lVar;
    }

    public static DateTimeFormatter ofPattern(String str) {
        u uVar = new u();
        uVar.h(str);
        return uVar.r(Locale.getDefault(), c0.SMART, null);
    }

    public final Object a(CharSequence charSequence, com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        String string;
        Objects.requireNonNull(charSequence, "text");
        Objects.requireNonNull(mVar, "query");
        try {
            return b(charSequence).y(mVar);
        } catch (DateTimeParseException e) {
            throw e;
        } catch (RuntimeException e2) {
            if (charSequence.length() > 64) {
                string = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                string = charSequence.toString();
            }
            DateTimeParseException dateTimeParseException = new DateTimeParseException("Text '" + string + "' could not be parsed: " + e2.getMessage(), e2);
            charSequence.toString();
            throw dateTimeParseException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.time.format.b0 b(java.lang.CharSequence r27) {
        /*
            Method dump skipped, instructions count: 1096
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.format.DateTimeFormatter.b(java.lang.CharSequence):com.github.catvod.spider.jdollar.time.format.b0");
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        d dVar = this.a;
        Objects.requireNonNull(temporalAccessor, "temporal");
        Objects.requireNonNull(sb, "appendable");
        try {
            dVar.h(new w(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new DateTimeException(e.getMessage(), e);
        }
    }

    public final String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }

    public static DateTimeFormatter ofPattern(String str, Locale locale) {
        u uVar = new u();
        uVar.h(str);
        return uVar.r(locale, c0.SMART, null);
    }
}
