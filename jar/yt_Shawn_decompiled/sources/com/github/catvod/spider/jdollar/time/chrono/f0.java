package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f0 implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;
    public byte a;
    public Object b;

    public f0(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    private Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objR;
        byte b = objectInput.readByte();
        this.a = b;
        switch (b) {
            case 1:
                ConcurrentHashMap concurrentHashMap = a.a;
                objR = com.github.catvod.spider.jdollar.com.android.tools.r8.a.R(objectInput.readUTF());
                break;
            case 2:
                objR = ((b) objectInput.readObject()).G((LocalTime) objectInput.readObject());
                break;
            case 3:
                objR = ((e) objectInput.readObject()).B((ZoneOffset) objectInput.readObject()).x((ZoneId) objectInput.readObject());
                break;
            case 4:
                LocalDate localDate = y.d;
                int i = objectInput.readInt();
                byte b2 = objectInput.readByte();
                byte b3 = objectInput.readByte();
                w.c.getClass();
                objR = new y(LocalDate.of(i, b2, b3));
                break;
            case 5:
                z zVar = z.d;
                objR = z.k(objectInput.readByte());
                break;
            case 6:
                p pVar = (p) objectInput.readObject();
                int i2 = objectInput.readInt();
                byte b4 = objectInput.readByte();
                byte b5 = objectInput.readByte();
                pVar.getClass();
                objR = new r(pVar, i2, b4, b5);
                break;
            case 7:
                int i3 = objectInput.readInt();
                byte b6 = objectInput.readByte();
                byte b7 = objectInput.readByte();
                b0.c.getClass();
                objR = new d0(LocalDate.of(i3 + 1911, b6, b7));
                break;
            case 8:
                int i4 = objectInput.readInt();
                byte b8 = objectInput.readByte();
                byte b9 = objectInput.readByte();
                h0.c.getClass();
                objR = new j0(LocalDate.of(i4 - 543, b8, b9));
                break;
            case 9:
                int i5 = h.e;
                objR = new h(com.github.catvod.spider.jdollar.com.android.tools.r8.a.R(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.b = objR;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                objectOutput.writeUTF(((a) obj).getId());
                return;
            case 2:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.a);
                objectOutput.writeObject(gVar.b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.a);
                objectOutput.writeObject(kVar.b);
                objectOutput.writeObject(kVar.c);
                return;
            case 4:
                y yVar = (y) obj;
                yVar.getClass();
                objectOutput.writeInt(com.github.catvod.spider.jdollar.time.temporal.q.a(yVar, com.github.catvod.spider.jdollar.time.temporal.a.YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(yVar, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(yVar, com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((z) obj).a);
                return;
            case 6:
                r rVar = (r) obj;
                objectOutput.writeObject(rVar.a);
                objectOutput.writeInt(com.github.catvod.spider.jdollar.time.temporal.q.a(rVar, com.github.catvod.spider.jdollar.time.temporal.a.YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(rVar, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(rVar, com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                d0 d0Var = (d0) obj;
                d0Var.getClass();
                objectOutput.writeInt(com.github.catvod.spider.jdollar.time.temporal.q.a(d0Var, com.github.catvod.spider.jdollar.time.temporal.a.YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(d0Var, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(d0Var, com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                j0 j0Var = (j0) obj;
                j0Var.getClass();
                objectOutput.writeInt(com.github.catvod.spider.jdollar.time.temporal.q.a(j0Var, com.github.catvod.spider.jdollar.time.temporal.a.YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(j0Var, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(com.github.catvod.spider.jdollar.time.temporal.q.a(j0Var, com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                h hVar = (h) obj;
                objectOutput.writeUTF(hVar.a.getId());
                objectOutput.writeInt(hVar.b);
                objectOutput.writeInt(hVar.c);
                objectOutput.writeInt(hVar.d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public f0() {
    }
}
