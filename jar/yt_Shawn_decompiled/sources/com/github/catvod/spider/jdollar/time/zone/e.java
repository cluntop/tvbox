package com.github.catvod.spider.jdollar.time.zone;

import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.i;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    public final i a;
    public final byte b;
    public final com.github.catvod.spider.jdollar.time.c c;
    public final LocalTime d;
    public final boolean e;
    public final d f;
    public final ZoneOffset g;
    public final ZoneOffset h;
    public final ZoneOffset i;

    public e(i iVar, int i, com.github.catvod.spider.jdollar.time.c cVar, LocalTime localTime, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.a = iVar;
        this.b = (byte) i;
        this.c = cVar;
        this.d = localTime;
        this.e = z;
        this.f = dVar;
        this.g = zoneOffset;
        this.h = zoneOffset2;
        this.i = zoneOffset3;
    }

    public static e a(DataInput dataInput) {
        i iVar;
        e eVar;
        LocalTime localTimeT;
        int i = dataInput.readInt();
        i iVarV = i.V(i >>> 28);
        int i2 = ((264241152 & i) >>> 22) - 32;
        int i3 = (3670016 & i) >>> 19;
        com.github.catvod.spider.jdollar.time.c cVarS = i3 == 0 ? null : com.github.catvod.spider.jdollar.time.c.S(i3);
        int i4 = (507904 & i) >>> 14;
        d dVar = d.values()[(i & 12288) >>> 12];
        int i5 = (i & 4080) >>> 4;
        int i6 = (i & 12) >>> 2;
        int i7 = i & 3;
        if (i4 == 31) {
            long j = dataInput.readInt();
            LocalTime localTime = LocalTime.e;
            com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_DAY.E(j);
            int i8 = (int) (j / 3600);
            iVar = iVarV;
            eVar = null;
            long j2 = j - (i8 * 3600);
            localTimeT = LocalTime.T(i8, (int) (j2 / 60), (int) (j2 - (r3 * 60)), 0);
        } else {
            iVar = iVarV;
            eVar = null;
            int i9 = i4 % 24;
            LocalTime localTime2 = LocalTime.e;
            com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY.E(i9);
            localTimeT = LocalTime.h[i9];
        }
        ZoneOffset zoneOffsetOfTotalSeconds = i5 == 255 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds((i5 - 128) * 900);
        ZoneOffset zoneOffsetOfTotalSeconds2 = i6 == 3 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds((i6 * 1800) + zoneOffsetOfTotalSeconds.getTotalSeconds());
        ZoneOffset zoneOffsetOfTotalSeconds3 = ZoneOffset.ofTotalSeconds(i7 == 3 ? dataInput.readInt() : (i7 * 1800) + zoneOffsetOfTotalSeconds.getTotalSeconds());
        boolean z = i4 == 24;
        i iVar2 = iVar;
        Objects.requireNonNull(iVar2, "month");
        Objects.requireNonNull(localTimeT, "time");
        Objects.requireNonNull(dVar, "timeDefnition");
        Objects.requireNonNull(zoneOffsetOfTotalSeconds, "standardOffset");
        Objects.requireNonNull(zoneOffsetOfTotalSeconds2, "offsetBefore");
        Objects.requireNonNull(zoneOffsetOfTotalSeconds3, "offsetAfter");
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Day of month indicator must be between -28 and 31 inclusive excluding zero");
            return eVar;
        }
        if (z && !localTimeT.equals(LocalTime.g)) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Time must be midnight when end of day flag is true");
            return eVar;
        }
        if (localTimeT.getNano() == 0) {
            return new e(iVar2, i2, cVarS, localTimeT, z, dVar, zoneOffsetOfTotalSeconds, zoneOffsetOfTotalSeconds2, zoneOffsetOfTotalSeconds3);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("Time's nano-of-second must be zero");
        return eVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int iE0 = this.e ? 86400 : this.d.e0();
        int totalSeconds = this.g.getTotalSeconds();
        int totalSeconds2 = this.h.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.i.getTotalSeconds() - totalSeconds;
        int hour = iE0 % 3600 == 0 ? this.e ? 24 : this.d.getHour() : 31;
        int i = totalSeconds % 900 == 0 ? (totalSeconds / 900) + 128 : 255;
        int i2 = (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) ? totalSeconds2 / 1800 : 3;
        int i3 = (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) ? totalSeconds3 / 1800 : 3;
        com.github.catvod.spider.jdollar.time.c cVar = this.c;
        dataOutput.writeInt((this.a.getValue() << 28) + ((this.b + 32) << 22) + ((cVar == null ? 0 : cVar.getValue()) << 19) + (hour << 14) + (this.f.ordinal() << 12) + (i << 4) + (i2 << 2) + i3);
        if (hour == 31) {
            dataOutput.writeInt(iE0);
        }
        if (i == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (i2 == 3) {
            dataOutput.writeInt(this.h.getTotalSeconds());
        }
        if (i3 == 3) {
            dataOutput.writeInt(this.i.getTotalSeconds());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && this.c == eVar.c && this.f == eVar.f && this.d.equals(eVar.d) && this.e == eVar.e && this.g.equals(eVar.g) && this.h.equals(eVar.h) && this.i.equals(eVar.i);
    }

    public final int hashCode() {
        int iE0 = ((this.d.e0() + (this.e ? 1 : 0)) << 15) + (this.a.ordinal() << 11) + ((this.b + 32) << 5);
        com.github.catvod.spider.jdollar.time.c cVar = this.c;
        return ((this.g.b ^ (this.f.ordinal() + (iE0 + ((cVar == null ? 7 : cVar.ordinal()) << 2)))) ^ this.h.b) ^ this.i.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.h;
        ZoneOffset zoneOffset2 = this.i;
        zoneOffset.getClass();
        sb.append(zoneOffset2.b - zoneOffset.b > 0 ? "Gap " : "Overlap ");
        sb.append(this.h);
        sb.append(" to ");
        sb.append(this.i);
        sb.append(", ");
        com.github.catvod.spider.jdollar.time.c cVar = this.c;
        if (cVar != null) {
            byte b = this.b;
            if (b == -1) {
                sb.append(cVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.a.name());
            } else if (b < 0) {
                sb.append(cVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.b) - 1);
                sb.append(" of ");
                sb.append(this.a.name());
            } else {
                sb.append(cVar.name());
                sb.append(" on or after ");
                sb.append(this.a.name());
                sb.append(' ');
                sb.append((int) this.b);
            }
        } else {
            sb.append(this.a.name());
            sb.append(' ');
            sb.append((int) this.b);
        }
        sb.append(" at ");
        sb.append(this.e ? "24:00" : this.d.toString());
        sb.append(Stream.ID_UNKNOWN);
        sb.append(this.f);
        sb.append(", standard offset ");
        sb.append(this.g);
        sb.append(']');
        return sb.toString();
    }
}
