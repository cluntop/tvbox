package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Instant implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<Instant>, Serializable {
    public static final Instant c = new Instant(0, 0);
    public static final Instant d = ofEpochSecond(-31557014167219200L, 0);
    public static final Instant e = ofEpochSecond(31556889864403199L, 999999999);
    private static final long serialVersionUID = -665713676816604388L;
    public final long a;
    public final int b;

    public Instant(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public static Instant S(long j, int i) {
        if ((i | j) == 0) {
            return c;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new Instant(j, i);
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("Instant exceeds minimum or maximum instant");
        return null;
    }

    public static Instant T(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            return ofEpochSecond(temporalAccessor.E(com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS), temporalAccessor.h(com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND));
        } catch (DateTimeException e2) {
            com.github.catvod.spider.jdollar.nio.file.b.h("Unable to obtain Instant from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e2);
            return null;
        }
    }

    public static Instant now() {
        a.b.getClass();
        return ofEpochMilli(System.currentTimeMillis());
    }

    public static Instant ofEpochMilli(long j) {
        return S(com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j, 1000L), ((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j, 1000L)) * 1000000);
    }

    public static Instant ofEpochSecond(long j, long j2) {
        return S(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(j, com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j2, 1000000000L)), (int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j2, 1000000000L));
    }

    public static Instant parse(CharSequence charSequence) {
        return (Instant) DateTimeFormatter.h.a(charSequence, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(1));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 2, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        int i;
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i2 = d.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i2 == 1) {
            i = this.b;
        } else if (i2 == 2) {
            i = this.b / 1000;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return this.a;
                }
                throw new r(b.a("Unsupported field: ", pVar));
            }
            i = this.b / 1000000;
        }
        return i;
    }

    public final Instant U(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(this.a, j), j2 / 1000000000), this.b + (j2 % 1000000000));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final Instant c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.h(this, j);
        }
        switch (d.b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return U(0L, j);
            case 2:
                return U(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return U(j / 1000, (j % 1000) * 1000000);
            case 4:
                return U(j, 0L);
            case 5:
                return U(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 60L), 0L);
            case 6:
                return U(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 3600L), 0L);
            case 7:
                return U(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 43200L), 0L);
            case 8:
                return U(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 86400L), 0L);
            default:
                com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
                return null;
        }
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.S(this, zoneOffset);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (Instant) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        aVar.E(j);
        int i = d.a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int i2 = ((int) j) * 1000;
                if (i2 != this.b) {
                    return S(this.a, i2);
                }
            } else if (i == 3) {
                int i3 = ((int) j) * 1000000;
                if (i3 != this.b) {
                    return S(this.a, i3);
                }
            } else {
                if (i != 4) {
                    throw new r(b.a("Unsupported field: ", pVar));
                }
                if (j != this.a) {
                    return S(j, this.b);
                }
            }
        } else if (j != this.b) {
            return S(this.a, (int) j);
        }
        return this;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.a, instant2.a);
        return iCompare != 0 ? iCompare : this.b - instant2.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS || pVar == com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND || pVar == com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_SECOND || pVar == com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_SECOND : pVar != null && pVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.a == instant.a && this.b == instant.b) {
                return true;
            }
        }
        return false;
    }

    public long getEpochSecond() {
        return this.a;
    }

    public int getNano() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return q.d(this, pVar).a(pVar.y(this), pVar);
        }
        int i = d.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.b / 1000;
        }
        if (i == 3) {
            return this.b / 1000000;
        }
        if (i == 4) {
            com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS;
            aVar.b.a(this.a, aVar);
        }
        throw new r(b.a("Unsupported field: ", pVar));
    }

    public final int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (Instant) com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(localDate, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(this.a, com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS).b(this.b, com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND);
    }

    public long toEpochMilli() {
        long j = this.a;
        return (j >= 0 || this.b <= 0) ? com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000L), this.b / 1000000) : com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j + 1, 1000L), (this.b / 1000000) - 1000);
    }

    public final String toString() {
        return DateTimeFormatter.h.format(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        if (mVar == q.c) {
            return ChronoUnit.NANOS;
        }
        if (mVar == q.b || mVar == q.a || mVar == q.e || mVar == q.d || mVar == q.f || mVar == q.g) {
            return null;
        }
        return mVar.f(this);
    }

    public static Instant ofEpochSecond(long j) {
        return S(j, 0);
    }
}
