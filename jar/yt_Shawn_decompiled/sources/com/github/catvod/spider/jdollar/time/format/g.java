package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g implements e {
    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        Long lA = wVar.a(com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS);
        TemporalAccessor temporalAccessor = wVar.a;
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND;
        Long lValueOf = temporalAccessor.d(aVar) ? Long.valueOf(temporalAccessor.E(aVar)) : null;
        int i = 0;
        if (lA == null) {
            return false;
        }
        long jLongValue = lA.longValue();
        int iA = aVar.b.a(lValueOf != null ? lValueOf.longValue() : 0L, aVar);
        if (jLongValue >= -62167219200L) {
            long j = jLongValue - 253402300800L;
            long jZ = 1 + com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j, 315569520000L);
            LocalDateTime localDateTimeV = LocalDateTime.V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (jZ > 0) {
                sb.append('+');
                sb.append(jZ);
            }
            sb.append(localDateTimeV);
            if (localDateTimeV.b.getSecond() == 0) {
                sb.append(":00");
            }
        } else {
            long j2 = jLongValue + 62167219200L;
            long j3 = j2 / 315569520000L;
            long j4 = j2 % 315569520000L;
            LocalDateTime localDateTimeV2 = LocalDateTime.V(j4 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(localDateTimeV2);
            if (localDateTimeV2.b.getSecond() == 0) {
                sb.append(":00");
            }
            if (j3 < 0) {
                if (localDateTimeV2.a.getYear() == -10000) {
                    sb.replace(length, length + 2, Long.toString(j3 - 1));
                } else if (j4 == 0) {
                    sb.insert(length, j3);
                } else {
                    sb.insert(length + 1, Math.abs(j3));
                }
            }
        }
        if (iA > 0) {
            sb.append('.');
            int i2 = 100000000;
            while (true) {
                if (iA <= 0 && i % 3 == 0 && i >= -2) {
                    break;
                }
                int i3 = iA / i2;
                sb.append((char) (i3 + 48));
                iA -= i3 * i2;
                i2 /= 10;
                i++;
            }
        }
        sb.append('Z');
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        u uVar = new u();
        uVar.a(DateTimeFormatter.f);
        uVar.d('T');
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY;
        uVar.m(aVar, 2);
        uVar.d(':');
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR;
        uVar.m(aVar2, 2);
        uVar.d(':');
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE;
        uVar.m(aVar3, 2);
        com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND;
        int i2 = 1;
        uVar.b(aVar4, 0, 9, true);
        uVar.d('Z');
        d dVar = uVar.r(Locale.getDefault(), c0.SMART, null).a;
        if (dVar.b) {
            dVar = new d(dVar.a, false);
        }
        v vVar2 = new v(vVar.a);
        vVar2.b = vVar.b;
        vVar2.c = vVar.c;
        int i3 = dVar.i(vVar2, charSequence, i);
        if (i3 < 0) {
            return i3;
        }
        long jLongValue = vVar2.d(com.github.catvod.spider.jdollar.time.temporal.a.YEAR).longValue();
        int iIntValue = vVar2.d(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR).intValue();
        int iIntValue2 = vVar2.d(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH).intValue();
        int iIntValue3 = vVar2.d(aVar).intValue();
        int iIntValue4 = vVar2.d(aVar2).intValue();
        Long lD = vVar2.d(aVar3);
        Long lD2 = vVar2.d(aVar4);
        int iIntValue5 = lD != null ? lD.intValue() : 0;
        int iIntValue6 = lD2 != null ? lD2.intValue() : 0;
        if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
            iIntValue3 = 0;
        } else {
            if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
                vVar.c().d = true;
                iIntValue5 = 59;
            }
            i2 = 0;
        }
        int i4 = ((int) jLongValue) % 10000;
        try {
            LocalDateTime localDateTime = LocalDateTime.c;
            return vVar.f(aVar4, iIntValue6, i, vVar.f(com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS, com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(new LocalDateTime(LocalDate.of(i4, iIntValue, iIntValue2), LocalTime.of(iIntValue3, iIntValue4, iIntValue5, 0)).X(i2), ZoneOffset.UTC) + com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(jLongValue / 10000, 315569520000L), i, i3));
        } catch (RuntimeException unused) {
            return ~i;
        }
    }

    public final String toString() {
        return "Instant()";
    }
}
