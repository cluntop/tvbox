package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;
    public final int b;
    public final transient String c;
    public static final ConcurrentHashMap d = new ConcurrentHashMap(16, 4);
    public static final ConcurrentHashMap e = new ConcurrentHashMap(16, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset f = ofTotalSeconds(-64800);
    public static final ZoneOffset g = ofTotalSeconds(64800);

    public ZoneOffset(int i) {
        String string;
        this.b = i;
        if (i == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = iAbs / 3600;
            int i3 = (iAbs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : VideoStream.RESOLUTION_UNKNOWN);
            sb.append(i2);
            sb.append(i3 < 10 ? ":0" : ":");
            sb.append(i3);
            int i4 = iAbs % 60;
            if (i4 != 0) {
                sb.append(i4 < 10 ? ":0" : ":");
                sb.append(i4);
            }
            string = sb.toString();
        }
        this.c = string;
    }

    public static ZoneOffset Y(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.y(q.d);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        com.github.catvod.spider.jdollar.nio.file.b.g("Unable to obtain ZoneOffset from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.github.catvod.spider.jdollar.time.ZoneOffset Z(java.lang.String r8) {
        /*
            java.lang.String r0 = "offsetId"
            com.github.catvod.spider.jdollar.util.Objects.requireNonNull(r8, r0)
            com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap r0 = com.github.catvod.spider.jdollar.time.ZoneOffset.e
            java.lang.Object r0 = r0.get(r8)
            com.github.catvod.spider.jdollar.time.ZoneOffset r0 = (com.github.catvod.spider.jdollar.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r8.length()
            r1 = 2
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L62
            r1 = 3
            if (r0 == r1) goto L7e
            r5 = 5
            if (r0 == r5) goto L59
            r6 = 6
            r7 = 4
            if (r0 == r6) goto L4f
            r6 = 7
            if (r0 == r6) goto L42
            r1 = 9
            if (r0 != r1) goto L38
            int r0 = b0(r8, r3, r4)
            int r1 = b0(r8, r7, r3)
            int r3 = b0(r8, r6, r3)
            goto L84
        L38:
            java.lang.String r0 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r8 = r0.concat(r8)
            com.github.catvod.spider.jdollar.nio.file.b.k(r8)
            return r2
        L42:
            int r0 = b0(r8, r3, r4)
            int r1 = b0(r8, r1, r4)
            int r3 = b0(r8, r5, r4)
            goto L84
        L4f:
            int r0 = b0(r8, r3, r4)
            int r1 = b0(r8, r7, r3)
        L57:
            r3 = 0
            goto L84
        L59:
            int r0 = b0(r8, r3, r4)
            int r1 = b0(r8, r1, r4)
            goto L57
        L62:
            char r0 = r8.charAt(r4)
            char r8 = r8.charAt(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
        L7e:
            int r0 = b0(r8, r3, r4)
            r1 = 0
            goto L57
        L84:
            char r4 = r8.charAt(r4)
            r5 = 43
            r6 = 45
            if (r4 == r5) goto L9b
            if (r4 != r6) goto L91
            goto L9b
        L91:
            java.lang.String r0 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r8 = r0.concat(r8)
            com.github.catvod.spider.jdollar.nio.file.b.k(r8)
            return r2
        L9b:
            if (r4 != r6) goto La5
            int r8 = -r0
            int r0 = -r1
            int r1 = -r3
            com.github.catvod.spider.jdollar.time.ZoneOffset r8 = a0(r8, r0, r1)
            return r8
        La5:
            com.github.catvod.spider.jdollar.time.ZoneOffset r8 = a0(r0, r1, r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.ZoneOffset.Z(java.lang.String):com.github.catvod.spider.jdollar.time.ZoneOffset");
    }

    public static ZoneOffset a0(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            com.github.catvod.spider.jdollar.nio.file.b.e("Zone offset hours not in valid range: value ", i, " is not in the range -18 to 18");
            return null;
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                com.github.catvod.spider.jdollar.nio.file.b.k("Zone offset minutes and seconds must be positive because hours is positive");
                return null;
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                com.github.catvod.spider.jdollar.nio.file.b.k("Zone offset minutes and seconds must be negative because hours is negative");
                return null;
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            com.github.catvod.spider.jdollar.nio.file.b.k("Zone offset minutes and seconds must have the same sign");
            return null;
        }
        if (i2 < -59 || i2 > 59) {
            com.github.catvod.spider.jdollar.nio.file.b.e("Zone offset minutes not in valid range: value ", i2, " is not in the range -59 to 59");
            return null;
        }
        if (i3 < -59 || i3 > 59) {
            com.github.catvod.spider.jdollar.nio.file.b.e("Zone offset seconds not in valid range: value ", i3, " is not in the range -59 to 59");
            return null;
        }
        if (Math.abs(i) != 18 || (i2 | i3) == 0) {
            return ofTotalSeconds((i2 * 60) + (i * 3600) + i3);
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("Zone offset not in valid range: -18:00 to +18:00");
        return null;
    }

    public static int b0(CharSequence charSequence, int i, boolean z) {
        if (z) {
            String str = (String) charSequence;
            if (str.charAt(i - 1) != ':') {
                com.github.catvod.spider.jdollar.nio.file.b.j(str, "Invalid ID for ZoneOffset, colon not found when expected: ");
                return 0;
            }
        }
        String str2 = (String) charSequence;
        char cCharAt = str2.charAt(i);
        char cCharAt2 = str2.charAt(i + 1);
        if (cCharAt < '0' || cCharAt > '9' || cCharAt2 < '0' || cCharAt2 > '9') {
            com.github.catvod.spider.jdollar.nio.file.b.j(str2, "Invalid ID for ZoneOffset, non numeric characters found: ");
            return 0;
        }
        return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
    }

    public static ZoneOffset c0(DataInput dataInput) throws IOException {
        byte b = dataInput.readByte();
        return b == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(b * 900);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ZoneOffset ofTotalSeconds(int i) {
        if (i < -64800 || i > 64800) {
            com.github.catvod.spider.jdollar.nio.file.b.k("Zone offset not in valid range: -18:00 to +18:00");
            return null;
        }
        if (i % 900 != 0) {
            return new ZoneOffset(i);
        }
        Integer numValueOf = Integer.valueOf(i);
        ConcurrentHashMap concurrentHashMap = d;
        ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(numValueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentHashMap.putIfAbsent(numValueOf, new ZoneOffset(i));
        ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(numValueOf);
        e.putIfAbsent(zoneOffset2.c, zoneOffset2);
        return zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 8, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS) {
            return this.b;
        }
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            throw new r(b.a("Unsupported field: ", pVar));
        }
        return pVar.y(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final com.github.catvod.spider.jdollar.time.zone.f T() {
        Objects.requireNonNull(this, "offset");
        return new com.github.catvod.spider.jdollar.time.zone.f(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final void X(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        d0(dataOutput);
    }

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.b - this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS : pVar != null && pVar.h(this);
    }

    public final void d0(DataOutput dataOutput) throws IOException {
        int i = this.b;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.b == ((ZoneOffset) obj).b;
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final String getId() {
        return this.c;
    }

    public int getTotalSeconds() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS) {
            return this.b;
        }
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            throw new r(b.a("Unsupported field: ", pVar));
        }
        return q.d(this, pVar).a(E(pVar), pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final int hashCode() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(this.b, com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final String toString() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return (mVar == q.d || mVar == q.e) ? this : q.c(this, mVar);
    }
}
