package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.Period;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b0 implements TemporalAccessor {
    public ZoneId b;
    public com.github.catvod.spider.jdollar.time.chrono.l c;
    public boolean d;
    public c0 e;
    public com.github.catvod.spider.jdollar.time.chrono.b f;
    public LocalTime g;
    public final Map a = new HashMap();
    public Period h = Period.d;

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        Objects.requireNonNull(pVar, "field");
        Long l = (Long) ((HashMap) this.a).get(pVar);
        if (l != null) {
            return l.longValue();
        }
        com.github.catvod.spider.jdollar.time.chrono.b bVar = this.f;
        if (bVar != null && bVar.d(pVar)) {
            return this.f.E(pVar);
        }
        LocalTime localTime = this.g;
        if (localTime != null && localTime.d(pVar)) {
            return this.g.E(pVar);
        }
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
        return pVar.y(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (((HashMap) this.a).containsKey(pVar)) {
            return true;
        }
        com.github.catvod.spider.jdollar.time.chrono.b bVar = this.f;
        if (bVar != null && bVar.d(pVar)) {
            return true;
        }
        LocalTime localTime = this.g;
        if (localTime == null || !localTime.d(pVar)) {
            return (pVar == null || (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) || !pVar.h(this)) ? false : true;
        }
        return true;
    }

    public final void f(TemporalAccessor temporalAccessor) {
        Iterator it = ((HashMap) this.a).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            com.github.catvod.spider.jdollar.time.temporal.p pVar = (com.github.catvod.spider.jdollar.time.temporal.p) entry.getKey();
            if (temporalAccessor.d(pVar)) {
                try {
                    long jE = temporalAccessor.E(pVar);
                    long jLongValue = ((Long) entry.getValue()).longValue();
                    if (jE != jLongValue) {
                        throw new DateTimeException("Conflict found: Field " + pVar + Stream.ID_UNKNOWN + jE + " differs from " + pVar + Stream.ID_UNKNOWN + jLongValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    public final void g() {
        if (((HashMap) this.a).containsKey(com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.b;
            if (zoneId != null) {
                k(zoneId);
                return;
            }
            Long l = (Long) ((HashMap) this.a).get(com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS);
            if (l != null) {
                k(ZoneOffset.ofTotalSeconds(l.intValue()));
            }
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.time.temporal.q.a(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.time.temporal.q.d(this, pVar);
    }

    public final void k(ZoneId zoneId) {
        Map map = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS;
        o(this.c.N(Instant.ofEpochSecond(((Long) ((HashMap) map).remove(aVar)).longValue()), zoneId).e());
        p(aVar, com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_DAY, Long.valueOf(r5.toLocalTime().e0()));
    }

    public final void l(long j, long j2, long j3, long j4) {
        if (this.e == c0.LENIENT) {
            long jN = com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 3600000000000L), com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j2, 60000000000L)), com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j3, 1000000000L)), j4);
            n(LocalTime.W(com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(jN, 86400000000000L)), Period.a(0, 0, (int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(jN, 86400000000000L)));
            return;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR;
        int iA = aVar.b.a(j2, aVar);
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND;
        int iA2 = aVar2.b.a(j4, aVar2);
        if (this.e == c0.SMART && j == 24 && iA == 0 && j3 == 0 && iA2 == 0) {
            n(LocalTime.g, Period.a(0, 0, 1));
            return;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY;
        int iA3 = aVar3.b.a(j, aVar3);
        com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE;
        n(LocalTime.of(iA3, iA, aVar4.b.a(j3, aVar4), iA2), Period.d);
    }

    public final void m() {
        Map map = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (((HashMap) map).containsKey(aVar)) {
            long jLongValue = ((Long) ((HashMap) this.a).remove(aVar)).longValue();
            c0 c0Var = this.e;
            if (c0Var == c0.STRICT || (c0Var == c0.SMART && jLongValue != 0)) {
                aVar.E(jLongValue);
            }
            com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            p(aVar, aVar2, Long.valueOf(jLongValue));
        }
        Map map2 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (((HashMap) map2).containsKey(aVar3)) {
            long jLongValue2 = ((Long) ((HashMap) this.a).remove(aVar3)).longValue();
            c0 c0Var2 = this.e;
            if (c0Var2 == c0.STRICT || (c0Var2 == c0.SMART && jLongValue2 != 0)) {
                aVar3.E(jLongValue2);
            }
            p(aVar3, com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(jLongValue2 != 12 ? jLongValue2 : 0L));
        }
        Map map3 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.AMPM_OF_DAY;
        if (((HashMap) map3).containsKey(aVar4)) {
            Map map4 = this.a;
            com.github.catvod.spider.jdollar.time.temporal.a aVar5 = com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_AMPM;
            if (((HashMap) map4).containsKey(aVar5)) {
                long jLongValue3 = ((Long) ((HashMap) this.a).remove(aVar4)).longValue();
                long jLongValue4 = ((Long) ((HashMap) this.a).remove(aVar5)).longValue();
                if (this.e == c0.LENIENT) {
                    p(aVar4, com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY, Long.valueOf(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(jLongValue3, 12L), jLongValue4)));
                } else {
                    aVar4.E(jLongValue3);
                    aVar5.E(jLongValue3);
                    p(aVar4, com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY, Long.valueOf((jLongValue3 * 12) + jLongValue4));
                }
            }
        }
        Map map5 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar6 = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY;
        if (((HashMap) map5).containsKey(aVar6)) {
            long jLongValue5 = ((Long) ((HashMap) this.a).remove(aVar6)).longValue();
            if (this.e != c0.LENIENT) {
                aVar6.E(jLongValue5);
            }
            p(aVar6, com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue5 / 3600000000000L));
            p(aVar6, com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue5 / 60000000000L) % 60));
            p(aVar6, com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((jLongValue5 / 1000000000) % 60));
            p(aVar6, com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue5 % 1000000000));
        }
        Map map6 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar7 = com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_DAY;
        if (((HashMap) map6).containsKey(aVar7)) {
            long jLongValue6 = ((Long) ((HashMap) this.a).remove(aVar7)).longValue();
            if (this.e != c0.LENIENT) {
                aVar7.E(jLongValue6);
            }
            p(aVar7, com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue6 / 1000000));
            p(aVar7, com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue6 % 1000000));
        }
        Map map7 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar8 = com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_DAY;
        if (((HashMap) map7).containsKey(aVar8)) {
            long jLongValue7 = ((Long) ((HashMap) this.a).remove(aVar8)).longValue();
            if (this.e != c0.LENIENT) {
                aVar8.E(jLongValue7);
            }
            p(aVar8, com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue7 / 1000));
            p(aVar8, com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue7 % 1000));
        }
        Map map8 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar9 = com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_DAY;
        if (((HashMap) map8).containsKey(aVar9)) {
            long jLongValue8 = ((Long) ((HashMap) this.a).remove(aVar9)).longValue();
            if (this.e != c0.LENIENT) {
                aVar9.E(jLongValue8);
            }
            p(aVar9, com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue8 / 3600));
            p(aVar9, com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue8 / 60) % 60));
            p(aVar9, com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(jLongValue8 % 60));
        }
        Map map9 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar10 = com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_DAY;
        if (((HashMap) map9).containsKey(aVar10)) {
            long jLongValue9 = ((Long) ((HashMap) this.a).remove(aVar10)).longValue();
            if (this.e != c0.LENIENT) {
                aVar10.E(jLongValue9);
            }
            p(aVar10, com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue9 / 60));
            p(aVar10, com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(jLongValue9 % 60));
        }
        Map map10 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar11 = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND;
        if (((HashMap) map10).containsKey(aVar11)) {
            long jLongValue10 = ((Long) ((HashMap) this.a).get(aVar11)).longValue();
            c0 c0Var3 = this.e;
            c0 c0Var4 = c0.LENIENT;
            if (c0Var3 != c0Var4) {
                aVar11.E(jLongValue10);
            }
            Map map11 = this.a;
            com.github.catvod.spider.jdollar.time.temporal.a aVar12 = com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_SECOND;
            if (((HashMap) map11).containsKey(aVar12)) {
                long jLongValue11 = ((Long) ((HashMap) this.a).remove(aVar12)).longValue();
                if (this.e != c0Var4) {
                    aVar12.E(jLongValue11);
                }
                jLongValue10 = (jLongValue10 % 1000) + (jLongValue11 * 1000);
                p(aVar12, aVar11, Long.valueOf(jLongValue10));
            }
            Map map12 = this.a;
            com.github.catvod.spider.jdollar.time.temporal.a aVar13 = com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_SECOND;
            if (((HashMap) map12).containsKey(aVar13)) {
                long jLongValue12 = ((Long) ((HashMap) this.a).remove(aVar13)).longValue();
                if (this.e != c0Var4) {
                    aVar13.E(jLongValue12);
                }
                p(aVar13, aVar11, Long.valueOf((jLongValue10 % 1000000) + (jLongValue12 * 1000000)));
            }
        }
        Map map13 = this.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar14 = com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY;
        if (((HashMap) map13).containsKey(aVar14)) {
            Map map14 = this.a;
            com.github.catvod.spider.jdollar.time.temporal.a aVar15 = com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR;
            if (((HashMap) map14).containsKey(aVar15)) {
                Map map15 = this.a;
                com.github.catvod.spider.jdollar.time.temporal.a aVar16 = com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE;
                if (((HashMap) map15).containsKey(aVar16) && ((HashMap) this.a).containsKey(aVar11)) {
                    l(((Long) ((HashMap) this.a).remove(aVar14)).longValue(), ((Long) ((HashMap) this.a).remove(aVar15)).longValue(), ((Long) ((HashMap) this.a).remove(aVar16)).longValue(), ((Long) ((HashMap) this.a).remove(aVar11)).longValue());
                }
            }
        }
    }

    public final void n(LocalTime localTime, Period period) {
        LocalTime localTime2 = this.g;
        if (localTime2 == null) {
            this.g = localTime;
            this.h = period;
            return;
        }
        if (!localTime2.equals(localTime)) {
            com.github.catvod.spider.jdollar.nio.file.b.g("Conflict found: Fields resolved to different times: ", this.g, Stream.ID_UNKNOWN, localTime);
            return;
        }
        Period period2 = this.h;
        period2.getClass();
        Period period3 = Period.d;
        if (period2 == period3 || period == period3 || this.h.equals(period)) {
            this.h = period;
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.g("Conflict found: Fields resolved to different excess periods: ", this.h, Stream.ID_UNKNOWN, period);
        }
    }

    public final void o(com.github.catvod.spider.jdollar.time.chrono.b bVar) {
        com.github.catvod.spider.jdollar.time.chrono.b bVar2 = this.f;
        if (bVar2 != null) {
            if (bVar == null || bVar2.equals(bVar)) {
                return;
            }
            com.github.catvod.spider.jdollar.nio.file.b.g("Conflict found: Fields resolved to two different dates: ", this.f, Stream.ID_UNKNOWN, bVar);
            return;
        }
        if (bVar != null) {
            if (this.c.equals(bVar.a())) {
                this.f = bVar;
                return;
            }
            throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.c);
        }
    }

    public final void p(com.github.catvod.spider.jdollar.time.temporal.p pVar, com.github.catvod.spider.jdollar.time.temporal.a aVar, Long l) {
        Long l2 = (Long) ((HashMap) this.a).put(aVar, l);
        if (l2 == null || l2.longValue() == l.longValue()) {
            return;
        }
        throw new DateTimeException("Conflict found: " + aVar + Stream.ID_UNKNOWN + l2 + " differs from " + aVar + Stream.ID_UNKNOWN + l + " while resolving  " + pVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.a);
        sb.append(',');
        sb.append(this.c);
        if (this.b != null) {
            sb.append(',');
            sb.append(this.b);
        }
        if (this.f != null || this.g != null) {
            sb.append(" resolved to ");
            com.github.catvod.spider.jdollar.time.chrono.b bVar = this.f;
            if (bVar != null) {
                sb.append(bVar);
                if (this.g != null) {
                    sb.append('T');
                    sb.append(this.g);
                }
            } else {
                sb.append(this.g);
            }
        }
        return sb.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.a) {
            return this.b;
        }
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.b) {
            return this.c;
        }
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.f) {
            com.github.catvod.spider.jdollar.time.chrono.b bVar = this.f;
            if (bVar != null) {
                return LocalDate.U(bVar);
            }
            return null;
        }
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.g) {
            return this.g;
        }
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.d) {
            Long l = (Long) ((HashMap) this.a).get(com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS);
            if (l != null) {
                return ZoneOffset.ofTotalSeconds(l.intValue());
            }
            ZoneId zoneId = this.b;
            return zoneId instanceof ZoneOffset ? zoneId : mVar.f(this);
        }
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.e) {
            return mVar.f(this);
        }
        if (mVar == com.github.catvod.spider.jdollar.time.temporal.q.c) {
            return null;
        }
        return mVar.f(this);
    }
}
