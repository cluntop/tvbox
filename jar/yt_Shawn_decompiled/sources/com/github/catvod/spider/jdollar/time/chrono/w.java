package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w extends a implements Serializable {
    public static final w c = new w();
    private static final long serialVersionUID = 459996390165777884L;

    private w() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b C(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof y ? (y) temporalAccessor : new y(LocalDate.U(temporalAccessor));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b E(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        y yVarY;
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
        Long l = (Long) map.get(aVar);
        z zVarK = l != null ? z.k(s(aVar).a(l.longValue(), aVar)) : null;
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.get(aVar2);
        int iA = l2 != null ? s(aVar2).a(l2.longValue(), aVar2) : 0;
        if (zVarK == null && l2 != null && !map.containsKey(com.github.catvod.spider.jdollar.time.temporal.a.YEAR) && c0Var != com.github.catvod.spider.jdollar.time.format.c0.STRICT) {
            z[] zVarArr = z.e;
            zVarK = ((z[]) Arrays.copyOf(zVarArr, zVarArr.length))[((z[]) Arrays.copyOf(zVarArr, zVarArr.length)).length - 1];
        }
        if (l2 != null && zVarK != null) {
            com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                        return new y(LocalDate.of((zVarK.b.getYear() + iA) - 1, 1, 1)).W(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar3)).longValue(), 1L), ChronoUnit.MONTHS).W(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar4)).longValue(), 1L), ChronoUnit.DAYS);
                    }
                    int iA2 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = s(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.SMART) {
                        LocalDate localDate = y.d;
                        Objects.requireNonNull(zVarK, "era");
                        LocalDate localDateOf = LocalDate.of((zVarK.b.getYear() + iA) - 1, iA2, iA3);
                        if (!localDateOf.Y(zVarK.b) && zVarK == z.f(localDateOf)) {
                            return new y(zVarK, iA, localDateOf);
                        }
                        com.github.catvod.spider.jdollar.nio.file.b.k("year, month, and day not valid for Era");
                        return null;
                    }
                    if (iA < 1) {
                        com.github.catvod.spider.jdollar.nio.file.b.d("Invalid YearOfEra: ", iA);
                        return null;
                    }
                    int year = (zVarK.b.getYear() + iA) - 1;
                    try {
                        yVarY = new y(LocalDate.of(year, iA2, iA3));
                    } catch (DateTimeException unused) {
                        yVarY = new y(LocalDate.of(year, iA2, 1)).Y(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(7));
                    }
                    if (yVarY.b == zVarK || com.github.catvod.spider.jdollar.time.temporal.q.a(yVarY, com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA) <= 1 || iA <= 1) {
                        return yVarY;
                    }
                    throw new DateTimeException("Invalid YearOfEra for Era: " + zVarK + Stream.ID_UNKNOWN + iA);
                }
            }
            com.github.catvod.spider.jdollar.time.temporal.a aVar5 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                    return new y(LocalDate.d0((zVarK.b.getYear() + iA) - 1, 1)).W(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar5)).longValue(), 1L), ChronoUnit.DAYS);
                }
                int iA4 = s(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                LocalDate localDate2 = y.d;
                Objects.requireNonNull(zVarK, "era");
                LocalDate localDate3 = zVarK.b;
                LocalDate localDateD0 = iA == 1 ? LocalDate.d0(localDate3.getYear(), (zVarK.b.X() + iA4) - 1) : LocalDate.d0((localDate3.getYear() + iA) - 1, iA4);
                if (!localDateD0.Y(zVarK.b) && zVarK == z.f(localDateD0)) {
                    return new y(zVarK, iA, localDateD0);
                }
                com.github.catvod.spider.jdollar.nio.file.b.k("Invalid parameters");
            }
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b K(int i, int i2, int i3) {
        return new y(LocalDate.of(i, i2, i3));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a, com.github.catvod.spider.jdollar.time.chrono.l
    public final b M(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        return (y) super.M(map, c0Var);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final ChronoZonedDateTime N(Instant instant, ZoneId zoneId) {
        return k.T(this, instant, zoneId);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final boolean Q(long j) {
        return t.c.Q(j);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b f(long j) {
        return new y(LocalDate.c0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String getId() {
        return "Japanese";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b i() {
        return new y(LocalDate.U(LocalDate.b0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.T())));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String l() {
        return "japanese";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b m(int i, int i2) {
        return new y(LocalDate.d0(i, i2));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final com.github.catvod.spider.jdollar.time.temporal.s s(com.github.catvod.spider.jdollar.time.temporal.a aVar) {
        switch (v.a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                com.github.catvod.spider.jdollar.nio.file.b.b(aVar, "Unsupported field: ");
                return null;
            case 5:
                z[] zVarArr = z.e;
                int year = zVarArr[zVarArr.length - 1].b.getYear();
                int year2 = 1000000000 - zVarArr[zVarArr.length - 1].b.getYear();
                int year3 = zVarArr[0].b.getYear();
                int i = 1;
                while (true) {
                    z[] zVarArr2 = z.e;
                    if (i >= zVarArr2.length) {
                        return com.github.catvod.spider.jdollar.time.temporal.s.g(1L, year2, 999999999 - year);
                    }
                    z zVar = zVarArr2[i];
                    year2 = Math.min(year2, (zVar.b.getYear() - year3) + 1);
                    year3 = zVar.b.getYear();
                    i++;
                }
            case 6:
                z zVar2 = z.d;
                long j = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR.b.c;
                long jMin = j;
                for (z zVar3 : z.e) {
                    long jMin2 = Math.min(jMin, (zVar3.b.O() - zVar3.b.X()) + 1);
                    jMin = zVar3.g() != null ? Math.min(jMin2, zVar3.g().b.X() - 1) : jMin2;
                }
                return com.github.catvod.spider.jdollar.time.temporal.s.g(1L, jMin, com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR.b.d);
            case 7:
                return com.github.catvod.spider.jdollar.time.temporal.s.f(y.d.getYear(), 999999999L);
            case 8:
                long j2 = z.d.a;
                z[] zVarArr3 = z.e;
                return com.github.catvod.spider.jdollar.time.temporal.s.f(j2, zVarArr3[zVarArr3.length - 1].a);
            default:
                return aVar.b;
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final List u() {
        z[] zVarArr = z.e;
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.B((z[]) Arrays.copyOf(zVarArr, zVarArr.length));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final n v(int i) {
        return z.k(i);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final int w(n nVar, int i) {
        if (!(nVar instanceof z)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        z zVar = (z) nVar;
        int year = (zVar.b.getYear() + i) - 1;
        if (i == 1 || (year >= -999999999 && year <= 999999999 && year >= zVar.b.getYear() && nVar == z.f(LocalDate.of(year, 1, 1)))) {
            return year;
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("Invalid yearOfEra value");
        return 0;
    }

    public Object writeReplace() {
        return new f0((byte) 1, this);
    }
}
