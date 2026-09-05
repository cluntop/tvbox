package com.github.catvod.spider.jdollar.time.zone;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.i;
import com.github.catvod.spider.jdollar.time.temporal.n;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f implements Serializable {
    public static final long[] i = new long[0];
    public static final e[] j = new e[0];
    public static final LocalDateTime[] k = new LocalDateTime[0];
    public static final b[] l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;
    public final long[] a;
    public final ZoneOffset[] b;
    public final long[] c;
    public final LocalDateTime[] d;
    public final ZoneOffset[] e;
    public final e[] f;
    public final TimeZone g;
    public final transient ConcurrentHashMap h = new ConcurrentHashMap();

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.a = jArr;
        this.b = zoneOffsetArr;
        this.c = jArr2;
        this.e = zoneOffsetArr2;
        this.f = eVarArr;
        if (jArr2.length == 0) {
            this.d = k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jArr2.length) {
                int i3 = i2 + 1;
                b bVar = new b(jArr2[i2], zoneOffsetArr2[i2], zoneOffsetArr2[i3]);
                boolean zH = bVar.h();
                LocalDateTime localDateTime = bVar.b;
                if (zH) {
                    arrayList.add(localDateTime);
                    arrayList.add(bVar.b.Y(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds()));
                } else {
                    arrayList.add(localDateTime.Y(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds()));
                    arrayList.add(bVar.b);
                }
                i2 = i3;
            }
            this.d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.g = null;
    }

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.b;
        if (bVar.h()) {
            if (localDateTime.U(localDateTime2)) {
                return bVar.c;
            }
            if (!localDateTime.U(bVar.b.Y(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds()))) {
                return bVar.d;
            }
        } else {
            if (!localDateTime.U(localDateTime2)) {
                return bVar.d;
            }
            if (localDateTime.U(bVar.b.Y(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds()))) {
                return bVar.c;
            }
        }
        return bVar;
    }

    public static int c(long j2, ZoneOffset zoneOffset) {
        return LocalDate.c0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j2 + zoneOffset.getTotalSeconds(), 86400L)).getYear();
    }

    public static ZoneOffset h(int i2) {
        return ZoneOffset.ofTotalSeconds(i2 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.g != null ? (byte) 100 : (byte) 1, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b[] b(int i2) {
        LocalDate localDateT;
        b[] bVarArr = l;
        Integer numValueOf = Integer.valueOf(i2);
        b[] bVarArr2 = (b[]) this.h.get(numValueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j2 = 1;
        int i3 = 0;
        if (this.g != null) {
            if (i2 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.c;
            LocalDate localDateOf = LocalDate.of(i2 - 1, 12, 31);
            com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY.E(0L);
            long j3 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(new LocalDateTime(localDateOf, LocalTime.h[0]), this.b[0]);
            long j4 = 1000;
            int offset = this.g.getOffset(j3 * 1000);
            long j5 = 31968000 + j3;
            while (j3 < j5) {
                long j6 = j3 + 7776000;
                long j7 = j4;
                if (offset != this.g.getOffset(j6 * j7)) {
                    while (j6 - j3 > j2) {
                        long jZ = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j6 + j3, 2L);
                        if (this.g.getOffset(jZ * j7) == offset) {
                            j3 = jZ;
                        } else {
                            j6 = jZ;
                        }
                        j2 = 1;
                    }
                    if (this.g.getOffset(j3 * j7) == offset) {
                        j3 = j6;
                    }
                    ZoneOffset zoneOffsetH = h(offset);
                    int offset2 = this.g.getOffset(j3 * j7);
                    ZoneOffset zoneOffsetH2 = h(offset2);
                    if (c(j3, zoneOffsetH2) == i2) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(j3, zoneOffsetH, zoneOffsetH2);
                    }
                    offset = offset2;
                } else {
                    j3 = j6;
                }
                j4 = j7;
                j2 = 1;
            }
            if (1916 <= i2 && i2 < 2100) {
                this.h.putIfAbsent(numValueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i4 = 0;
        while (i4 < eVarArr.length) {
            e eVar = eVarArr[i4];
            byte b = eVar.b;
            i iVar = eVar.a;
            if (b < 0) {
                long j8 = i2;
                int iT = iVar.T(t.c.Q(j8)) + 1 + eVar.b;
                LocalDate localDate = LocalDate.d;
                com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(j8);
                Objects.requireNonNull(iVar, "month");
                com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH.E(iT);
                localDateT = LocalDate.T(i2, iVar.getValue(), iT);
                com.github.catvod.spider.jdollar.time.c cVar = eVar.c;
                if (cVar != null) {
                    localDateT = localDateT.i(new n(cVar.getValue(), 1));
                }
            } else {
                LocalDate localDate2 = LocalDate.d;
                com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i2);
                Objects.requireNonNull(iVar, "month");
                com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH.E(b);
                localDateT = LocalDate.T(i2, iVar.getValue(), b);
                com.github.catvod.spider.jdollar.time.c cVar2 = eVar.c;
                if (cVar2 != null) {
                    localDateT = localDateT.i(new n(cVar2.getValue(), i3));
                }
            }
            if (eVar.e) {
                localDateT = localDateT.f0(1L);
            }
            LocalDateTime localDateTimeOf = LocalDateTime.of(localDateT, eVar.d);
            d dVar = eVar.f;
            ZoneOffset zoneOffset = eVar.g;
            ZoneOffset zoneOffset2 = eVar.h;
            dVar.getClass();
            int i5 = c.a[dVar.ordinal()];
            if (i5 == 1) {
                localDateTimeOf = localDateTimeOf.Y(zoneOffset2.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
            } else if (i5 == 2) {
                localDateTimeOf = localDateTimeOf.Y(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds());
            }
            bVarArr3[i4] = new b(localDateTimeOf, eVar.h, eVar.i);
            i4++;
            i3 = 0;
        }
        if (i2 < 2100) {
            this.h.putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return h(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.c.length == 0) {
            return this.b[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.f.length > 0) {
            if (epochSecond > this.c[r8.length - 1]) {
                b[] bVarArrB = b(c(epochSecond, this.e[r8.length - 1]));
                b bVar = null;
                for (int i2 = 0; i2 < bVarArrB.length; i2++) {
                    bVar = bVarArrB[i2];
                    if (epochSecond < bVar.a) {
                        return bVar.c;
                    }
                }
                return bVar.d;
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.c, epochSecond);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.e[iBinarySearch + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(com.github.catvod.spider.jdollar.time.LocalDateTime r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.zone.f.e(com.github.catvod.spider.jdollar.time.LocalDateTime):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.g, fVar.g) && Arrays.equals(this.a, fVar.a) && Arrays.equals(this.b, fVar.b) && Arrays.equals(this.c, fVar.c) && Arrays.equals(this.e, fVar.e) && Arrays.equals(this.f, fVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final List f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (!(objE instanceof b)) {
            return Collections.singletonList((ZoneOffset) objE);
        }
        b bVar = (b) objE;
        return bVar.h() ? Collections.EMPTY_LIST : com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(new Object[]{bVar.c, bVar.d});
    }

    public final boolean g(Instant instant) {
        ZoneOffset zoneOffsetH;
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            zoneOffsetH = h(timeZone.getRawOffset());
        } else if (this.c.length == 0) {
            zoneOffsetH = this.b[0];
        } else {
            int iBinarySearch = Arrays.binarySearch(this.a, instant.getEpochSecond());
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            zoneOffsetH = this.b[iBinarySearch + 1];
        }
        return !zoneOffsetH.equals(d(instant));
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.g) ^ Arrays.hashCode(this.a)) ^ Arrays.hashCode(this.b)) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.e)) ^ Arrays.hashCode(this.f);
    }

    public final String toString() {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.b[r0.length - 1] + "]";
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {h(timeZone.getRawOffset())};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = timeZone;
    }
}
