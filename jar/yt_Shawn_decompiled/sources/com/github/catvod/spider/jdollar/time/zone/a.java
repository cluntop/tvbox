package com.github.catvod.spider.jdollar.time.zone;

import com.github.catvod.spider.jdollar.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;
    public byte a;
    public Object b;

    public a(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    public static long a(DataInput dataInput) {
        if ((dataInput.readByte() & 255) == 255) {
            return dataInput.readLong();
        }
        return ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    public static ZoneOffset b(DataInput dataInput) throws IOException {
        byte b = dataInput.readByte();
        return b == Byte.MAX_VALUE ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds(b * 900);
    }

    public static void c(long j, DataOutput dataOutput) throws IOException {
        if (j < -4575744000L || j >= 10413792000L || j % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j);
        } else {
            int i = (int) ((j + 4575744000L) / 900);
            dataOutput.writeByte((i >>> 16) & 255);
            dataOutput.writeByte((i >>> 8) & 255);
            dataOutput.writeByte(i & 255);
        }
    }

    public static void d(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int i = totalSeconds % 900 == 0 ? totalSeconds / 900 : 127;
        dataOutput.writeByte(i);
        if (i == 127) {
            dataOutput.writeInt(totalSeconds);
        }
    }

    private Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object fVar;
        byte b = objectInput.readByte();
        this.a = b;
        if (b == 1) {
            long[] jArr = f.i;
            int i = objectInput.readInt();
            long[] jArr2 = i == 0 ? jArr : new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                jArr2[i2] = a(objectInput);
            }
            int i3 = i + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                zoneOffsetArr[i4] = b(objectInput);
            }
            int i5 = objectInput.readInt();
            if (i5 != 0) {
                jArr = new long[i5];
            }
            long[] jArr3 = jArr;
            for (int i6 = 0; i6 < i5; i6++) {
                jArr3[i6] = a(objectInput);
            }
            int i7 = i5 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                zoneOffsetArr2[i8] = b(objectInput);
            }
            int i9 = objectInput.readByte();
            e[] eVarArr = i9 == 0 ? f.j : new e[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                eVarArr[i10] = e.a(objectInput);
            }
            fVar = new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
        } else if (b == 2) {
            int i11 = b.e;
            long jA = a(objectInput);
            ZoneOffset zoneOffsetB = b(objectInput);
            ZoneOffset zoneOffsetB2 = b(objectInput);
            if (zoneOffsetB.equals(zoneOffsetB2)) {
                com.github.catvod.spider.jdollar.nio.file.b.c("Offsets must not be equal");
                return;
            }
            fVar = new b(jA, zoneOffsetB, zoneOffsetB2);
        } else if (b == 3) {
            fVar = e.a(objectInput);
        } else {
            if (b != 100) {
                throw new StreamCorruptedException("Unknown serialized type");
            }
            fVar = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.b = fVar;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        if (b != 1) {
            if (b == 2) {
                b bVar = (b) obj;
                c(bVar.a, objectOutput);
                d(bVar.c, objectOutput);
                d(bVar.d, objectOutput);
                return;
            }
            if (b == 3) {
                ((e) obj).b(objectOutput);
                return;
            } else {
                if (b != 100) {
                    throw new InvalidClassException("Unknown serialized type");
                }
                objectOutput.writeUTF(((f) obj).g.getID());
                return;
            }
        }
        f fVar = (f) obj;
        objectOutput.writeInt(fVar.a.length);
        for (long j : fVar.a) {
            c(j, objectOutput);
        }
        for (ZoneOffset zoneOffset : fVar.b) {
            d(zoneOffset, objectOutput);
        }
        objectOutput.writeInt(fVar.c.length);
        for (long j2 : fVar.c) {
            c(j2, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : fVar.e) {
            d(zoneOffset2, objectOutput);
        }
        objectOutput.writeByte(fVar.f.length);
        for (e eVar : fVar.f) {
            eVar.b(objectOutput);
        }
    }

    public a() {
    }
}
