package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class LocalTime implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<LocalTime>, Serializable {
    public static final LocalTime e;
    public static final LocalTime f;
    public static final LocalTime g;
    public static final LocalTime[] h = new LocalTime[24];
    private static final long serialVersionUID = 6414437269572265201L;
    public final byte a;
    public final byte b;
    public final byte c;
    public final int d;

    static {
        int i = 0;
        while (true) {
            LocalTime[] localTimeArr = h;
            if (i >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                g = localTime;
                LocalTime localTime2 = localTimeArr[12];
                e = localTime;
                f = new LocalTime(23, 59, 59, 999999999);
                return;
            }
            localTimeArr[i] = new LocalTime(i, 0, 0, 0);
            i++;
        }
    }

    public LocalTime(int i, int i2, int i3, int i4) {
        this.a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    public static LocalTime T(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? h[i] : new LocalTime(i, i2, i3, i4);
    }

    public static LocalTime U(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalTime localTime = (LocalTime) temporalAccessor.y(q.g);
        if (localTime != null) {
            return localTime;
        }
        com.github.catvod.spider.jdollar.nio.file.b.g("Unable to obtain LocalTime from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static LocalTime W(long j) {
        com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY.E(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (i * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (i2 * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return T(i, i2, i3, (int) (j3 - (i3 * 1000000000)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    public static LocalTime c0(DataInput dataInput) throws IOException {
        int i;
        int i2;
        int i3 = dataInput.readByte();
        byte b = 0;
        if (i3 >= 0) {
            byte b2 = dataInput.readByte();
            if (b2 < 0) {
                ?? r4 = ~b2;
                i = 0;
                b = r4;
                i2 = 0;
            } else {
                byte b3 = dataInput.readByte();
                if (b3 < 0) {
                    i2 = ~b3;
                    b = b2;
                } else {
                    i = dataInput.readInt();
                    b = b2;
                    i2 = b3;
                }
            }
            return of(i3, b, i2, i);
        }
        i3 = ~i3;
        i2 = 0;
        i = 0;
        return of(i3, b, i2, i);
    }

    public static LocalTime of(int i, int i2, int i3, int i4) {
        com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY.E(i);
        com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR.E(i2);
        com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE.E(i3);
        com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND.E(i4);
        return T(i, i2, i3, i4);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 4, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY ? d0() : pVar == com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_DAY ? d0() / 1000 : V(pVar) : pVar.y(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final int compareTo(LocalTime localTime) {
        int iCompare = Integer.compare(this.a, localTime.a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.b, localTime.b)) == 0 && (iCompare = Integer.compare(this.c, localTime.c)) == 0) ? Integer.compare(this.d, localTime.d) : iCompare;
    }

    public final int V(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        switch (g.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()]) {
            case 1:
                return this.d;
            case 2:
                throw new r("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.d / 1000;
            case 4:
                throw new r("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.d / 1000000;
            case 6:
                return (int) (d0() / 1000000);
            case 7:
                return this.c;
            case 8:
                return e0();
            case 9:
                return this.b;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return (this.a * 60) + this.b;
            case 11:
                return this.a % 12;
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                int i = this.a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.a;
            case 14:
                byte b = this.a;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.a / 12;
            default:
                throw new r(b.a("Unsupported field: ", pVar));
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final LocalTime c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.h(this, j);
        }
        switch (g.b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return a0(j);
            case 2:
                return a0((j % 86400000000L) * 1000);
            case 3:
                return a0((j % 86400000) * 1000000);
            case 4:
                return b0(j);
            case 5:
                return Z(j);
            case 6:
                return Y(j);
            case 7:
                return Y((j % 2) * 12);
            default:
                com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
                return null;
        }
    }

    public final LocalTime Y(long j) {
        return j == 0 ? this : T(((((int) (j % 24)) + this.a) + 24) % 24, this.b, this.c, this.d);
    }

    public final LocalTime Z(long j) {
        if (j != 0) {
            int i = (this.a * 60) + this.b;
            int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i2) {
                return T(i2 / 60, i2 % 60, this.c, this.d);
            }
        }
        return this;
    }

    public final LocalTime a0(long j) {
        if (j != 0) {
            long jD0 = d0();
            long j2 = (((j % 86400000000000L) + jD0) + 86400000000000L) % 86400000000000L;
            if (jD0 != j2) {
                return T((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
            }
        }
        return this;
    }

    public final LocalTime b0(long j) {
        if (j != 0) {
            int i = (this.b * 60) + (this.a * 3600) + this.c;
            int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
            if (i != i2) {
                return T(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.d);
            }
        }
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S() : pVar != null && pVar.h(this);
    }

    public final long d0() {
        return (this.c * 1000000000) + (this.b * 60000000000L) + (this.a * 3600000000000L) + this.d;
    }

    public final int e0() {
        return (this.b * 60) + (this.a * 3600) + this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.a == localTime.a && this.b == localTime.b && this.c == localTime.c && this.d == localTime.d) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final LocalTime b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (LocalTime) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        aVar.E(j);
        switch (g.a[aVar.ordinal()]) {
            case 1:
                return g0((int) j);
            case 2:
                return W(j);
            case 3:
                return g0(((int) j) * 1000);
            case 4:
                return W(j * 1000);
            case 5:
                return g0(((int) j) * 1000000);
            case 6:
                return W(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.c != i) {
                    com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE.E(i);
                    return T(this.a, this.b, i, this.d);
                }
                return this;
            case 8:
                return b0(j - e0());
            case 9:
                int i2 = (int) j;
                if (this.b != i2) {
                    com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR.E(i2);
                    return T(this.a, i2, this.c, this.d);
                }
                return this;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return Z(j - ((this.a * 60) + this.b));
            case 11:
                return Y(j - (this.a % 12));
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                if (j == 12) {
                    j = 0;
                }
                return Y(j - (this.a % 12));
            case 13:
                int i3 = (int) j;
                if (this.a != i3) {
                    com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY.E(i3);
                    return T(i3, this.b, this.c, this.d);
                }
                return this;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i4 = (int) j;
                if (this.a != i4) {
                    com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY.E(i4);
                    return T(i4, this.b, this.c, this.d);
                }
                return this;
            case 15:
                return Y((j - (this.a / 12)) * 12);
            default:
                throw new r(b.a("Unsupported field: ", pVar));
        }
    }

    public final LocalTime g0(int i) {
        if (this.d == i) {
            return this;
        }
        com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND.E(i);
        return T(this.a, this.b, this.c, i);
    }

    public int getHour() {
        return this.a;
    }

    public int getMinute() {
        return this.b;
    }

    public int getNano() {
        return this.d;
    }

    public int getSecond() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? V(pVar) : q.a(this, pVar);
    }

    public final void h0(DataOutput dataOutput) throws IOException {
        if (this.d != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(this.c);
            dataOutput.writeInt(this.d);
            return;
        }
        if (this.c != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(~this.c);
            return;
        }
        byte b = this.b;
        byte b2 = this.a;
        if (b == 0) {
            dataOutput.writeByte(~b2);
        } else {
            dataOutput.writeByte(b2);
            dataOutput.writeByte(~this.b);
        }
    }

    public final int hashCode() {
        long jD0 = d0();
        return (int) (jD0 ^ (jD0 >>> 32));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (LocalTime) com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(localDate, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(d0(), com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        int i = this.d;
        sb.append(b < 10 ? "0" : VideoStream.RESOLUTION_UNKNOWN);
        sb.append((int) b);
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            sb.append(b3 < 10 ? ":0" : ":");
            sb.append((int) b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        if (mVar == q.b || mVar == q.a || mVar == q.e || mVar == q.d) {
            return null;
        }
        if (mVar == q.g) {
            return this;
        }
        if (mVar == q.f) {
            return null;
        }
        return mVar == q.c ? ChronoUnit.NANOS : mVar.f(this);
    }
}
