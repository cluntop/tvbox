package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
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
public final class OffsetDateTime implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<OffsetDateTime>, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 2287754244819255394L;
    public final LocalDateTime a;
    public final ZoneOffset b;

    static {
        LocalDateTime localDateTime = LocalDateTime.c;
        ZoneOffset zoneOffset = ZoneOffset.g;
        localDateTime.getClass();
        of(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.d;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        localDateTime2.getClass();
        of(localDateTime2, zoneOffset2);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.a = (LocalDateTime) Objects.requireNonNull(localDateTime, "dateTime");
        this.b = (ZoneOffset) Objects.requireNonNull(zoneOffset, "offset");
    }

    public static OffsetDateTime S(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset zoneOffsetD = zoneId.T().d(instant);
        return new OffsetDateTime(LocalDateTime.V(instant.getEpochSecond(), instant.getNano(), zoneOffsetD), zoneOffsetD);
    }

    public static OffsetDateTime of(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.a(charSequence, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(4));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 10, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i = k.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.E(pVar) : getOffset().getTotalSeconds();
        }
        LocalDateTime localDateTime = this.a;
        ZoneOffset zoneOffset = this.b;
        localDateTime.getClass();
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(localDateTime, zoneOffset);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime c(long j, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? U(this.a.c(j, temporalUnit), this.b) : (OffsetDateTime) temporalUnit.h(this, j);
    }

    public final OffsetDateTime U(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.a == localDateTime && this.b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (OffsetDateTime) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        int i = k.a[aVar.ordinal()];
        LocalDateTime localDateTime = this.a;
        return i != 1 ? i != 2 ? U(localDateTime.b(j, pVar), this.b) : U(localDateTime, ZoneOffset.ofTotalSeconds(aVar.b.a(j, aVar))) : S(Instant.ofEpochSecond(j, localDateTime.b.getNano()), this.b);
    }

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int iCompare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (getOffset().equals(offsetDateTime2.getOffset())) {
            iCompare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.a;
            ZoneOffset zoneOffset = this.b;
            localDateTime.getClass();
            long j = com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(localDateTime, zoneOffset);
            LocalDateTime localDateTime2 = offsetDateTime2.a;
            ZoneOffset zoneOffset2 = offsetDateTime2.b;
            localDateTime2.getClass();
            iCompare = Long.compare(j, com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(localDateTime2, zoneOffset2));
            if (iCompare == 0) {
                iCompare = this.a.toLocalTime().getNano() - offsetDateTime2.a.toLocalTime().getNano();
            }
        }
        return iCompare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : iCompare;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            return true;
        }
        return pVar != null && pVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.a.equals(offsetDateTime.a) && this.b.equals(offsetDateTime.b)) {
                return true;
            }
        }
        return false;
    }

    public ZoneOffset getOffset() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return q.a(this, pVar);
        }
        int i = k.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.h(pVar) : getOffset().getTotalSeconds();
        }
        throw new r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        LocalDateTime localDateTime = this.a;
        return U(localDateTime.b0(localDate, localDateTime.b), this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? (pVar == com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS || pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS) ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).b : this.a.j(pVar) : pVar.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(this.a.e().F(), com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY).b(this.a.toLocalTime().d0(), com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY).b(getOffset().getTotalSeconds(), com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS);
    }

    public Instant toInstant() {
        LocalDateTime localDateTime = this.a;
        ZoneOffset zoneOffset = this.b;
        localDateTime.getClass();
        return Instant.ofEpochSecond(com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(localDateTime, zoneOffset), localDateTime.toLocalTime().getNano());
    }

    public LocalDateTime toLocalDateTime() {
        return this.a;
    }

    public final String toString() {
        return this.a.toString() + this.b.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        if (mVar == q.d || mVar == q.e) {
            return getOffset();
        }
        if (mVar == q.a) {
            return null;
        }
        return mVar == q.f ? this.a.e() : mVar == q.g ? this.a.toLocalTime() : mVar == q.b ? t.c : mVar == q.c ? ChronoUnit.NANOS : mVar.f(this);
    }

    public static OffsetDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.g);
    }
}
