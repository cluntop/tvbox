package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.text.StringsKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y implements r0 {
    public byte a;
    public final l0 b;
    public final Inflater c;
    public final a0 d;
    public final CRC32 e;

    public y(l lVar) {
        lVar.getClass();
        l0 l0Var = new l0(lVar);
        this.b = l0Var;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new a0(l0Var, inflater);
        this.e = new CRC32();
    }

    public static void j(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        throw new IOException(str + ": actual 0x" + StringsKt.z(8, c2.a0(i2)) + " != expected 0x" + StringsKt.z(8, c2.a0(i)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.d.close();
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(j jVar, long j) throws DataFormatException, IOException {
        y yVar = this;
        jVar.getClass();
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        byte b = yVar.a;
        CRC32 crc32 = yVar.e;
        l0 l0Var = yVar.b;
        if (b == 0) {
            l0Var.t(10L);
            j jVar2 = l0Var.b;
            byte bA = jVar2.A(3L);
            boolean z = ((bA >> 1) & 1) == 1;
            if (z) {
                yVar.z(jVar2, 0L, 10L);
            }
            j("ID1ID2", 8075, l0Var.readShort());
            l0Var.skip(8L);
            if (((bA >> 2) & 1) == 1) {
                l0Var.t(2L);
                if (z) {
                    z(jVar2, 0L, 2L);
                }
                long jG = jVar2.G() & 65535;
                l0Var.t(jG);
                if (z) {
                    z(jVar2, 0L, jG);
                }
                l0Var.skip(jG);
            }
            if (((bA >> 3) & 1) == 1) {
                long j2 = l0Var.j((byte) 0, 0L, Long.MAX_VALUE);
                if (j2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    z(jVar2, 0L, j2 + 1);
                }
                l0Var.skip(j2 + 1);
            }
            if (((bA >> 4) & 1) == 1) {
                long j3 = l0Var.j((byte) 0, 0L, Long.MAX_VALUE);
                if (j3 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    yVar = this;
                    yVar.z(jVar2, 0L, j3 + 1);
                } else {
                    yVar = this;
                }
                l0Var.skip(j3 + 1);
            } else {
                yVar = this;
            }
            if (z) {
                j("FHCRC", l0Var.B(), (short) crc32.getValue());
                crc32.reset();
            }
            yVar.a = (byte) 1;
        }
        if (yVar.a == 1) {
            long j4 = jVar.b;
            long j5 = yVar.d.read(jVar, j);
            if (j5 != -1) {
                yVar.z(jVar, j4, j5);
                return j5;
            }
            yVar.a = (byte) 2;
        }
        if (yVar.a == 2) {
            j("CRC", l0Var.z(), (int) crc32.getValue());
            j("ISIZE", l0Var.z(), (int) yVar.c.getBytesWritten());
            yVar.a = (byte) 3;
            if (!l0Var.n()) {
                com.github.catvod.spider.merge.s0.a.w("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return this.b.a.timeout();
    }

    public final void z(j jVar, long j, long j2) {
        m0 m0Var = jVar.a;
        m0Var.getClass();
        while (true) {
            int i = m0Var.c;
            int i2 = m0Var.b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            m0Var = m0Var.f;
            m0Var.getClass();
        }
        while (j2 > 0) {
            int iMin = (int) Math.min(m0Var.c - r7, j2);
            this.e.update(m0Var.a, (int) (m0Var.b + j), iMin);
            j2 -= iMin;
            m0Var = m0Var.f;
            m0Var.getClass();
            j = 0;
        }
    }
}
