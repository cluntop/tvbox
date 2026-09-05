package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l0 implements l {
    public final r0 a;
    public final j b;
    public boolean c;

    public l0(r0 r0Var) {
        r0Var.getClass();
        this.a = r0Var;
        this.b = new j();
    }

    public final long A() throws EOFException {
        t(8L);
        long j = this.b.readLong();
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public final short B() {
        t(2L);
        return this.b.G();
    }

    public final String C(long j) {
        t(j);
        return this.b.H(j, Charsets.UTF_8);
    }

    @Override // com.github.catvod.spider.merge.y0.l, com.github.catvod.spider.merge.y0.k
    public final j a() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.close();
        this.b.j();
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final m d() {
        r0 r0Var = this.a;
        j jVar = this.b;
        jVar.p(r0Var);
        return jVar.e(jVar.b);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final m e(long j) {
        t(j);
        return this.b.e(j);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final boolean f(long j, m mVar) {
        mVar.getClass();
        int iD = mVar.d();
        if (!this.c) {
            return iD >= 0 && iD <= mVar.d() && (iD == 0 || com.github.catvod.spider.merge.z0.b.d(this, mVar, iD, 1L) != -1);
        }
        com.github.catvod.spider.merge.s0.a.h("closed");
        return false;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void g(j jVar, long j) throws EOFException {
        j jVar2 = this.b;
        jVar.getClass();
        try {
            t(j);
            jVar2.g(jVar, j);
        } catch (EOFException e) {
            jVar.p(jVar2);
            throw e;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final int i(f0 f0Var) throws EOFException {
        f0Var.getClass();
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return 0;
        }
        while (true) {
            j jVar = this.b;
            int iD = com.github.catvod.spider.merge.z0.a.d(jVar, f0Var, true);
            if (iD != -2) {
                if (iD != -1) {
                    jVar.skip(f0Var.a[iD].d());
                    return iD;
                }
            } else if (this.a.read(jVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    public final long j(byte b, long j, long j2) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return 0L;
        }
        if (0 > j2) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("fromIndex=0 toIndex=", j2));
            return 0L;
        }
        long jMax = 0;
        while (jMax < j2) {
            j jVar = this.b;
            byte b2 = b;
            long j3 = j2;
            long jB = jVar.B(b2, jMax, j3);
            if (jB != -1) {
                return jB;
            }
            long j4 = jVar.b;
            if (j4 >= j3 || this.a.read(jVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j4);
            b = b2;
            j2 = j3;
        }
        return -1L;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final long k(long j, m mVar) {
        mVar.getClass();
        return com.github.catvod.spider.merge.z0.b.d(this, mVar, mVar.d(), j);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final String l() {
        return s(Long.MAX_VALUE);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final byte[] m() {
        r0 r0Var = this.a;
        j jVar = this.b;
        jVar.p(r0Var);
        return jVar.F(jVar.b);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final boolean n() {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return false;
        }
        j jVar = this.b;
        return jVar.n() && this.a.read(jVar, 8192L) == -1;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final l0 peek() {
        return new l0(new h0(this));
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final long r() {
        j jVar;
        byte bA;
        t(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            boolean zRequest = request(j2);
            jVar = this.b;
            if (!zRequest) {
                break;
            }
            bA = jVar.A(j);
            if ((bA < 48 || bA > 57) && !(j == 0 && bA == 45)) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            String string = Integer.toString(bA, CharsKt.checkRadix(16));
            string.getClass();
            throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
        }
        return jVar.r();
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(j jVar, long j) {
        jVar.getClass();
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return 0L;
        }
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return 0L;
        }
        j jVar2 = this.b;
        if (jVar2.b == 0) {
            if (j == 0) {
                return 0L;
            }
            if (this.a.read(jVar2, 8192L) == -1) {
                return -1L;
            }
        }
        return jVar2.read(jVar, Math.min(j, jVar2.b));
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final byte readByte() {
        t(1L);
        return this.b.readByte();
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void readFully(byte[] bArr) throws EOFException {
        j jVar = this.b;
        bArr.getClass();
        try {
            t(bArr.length);
            jVar.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                long j = jVar.b;
                if (j <= 0) {
                    throw e;
                }
                int i2 = jVar.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final int readInt() {
        t(4L);
        return this.b.readInt();
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final long readLong() {
        t(8L);
        return this.b.readLong();
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final short readShort() {
        t(2L);
        return this.b.readShort();
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final boolean request(long j) {
        j jVar;
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return false;
        }
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return false;
        }
        do {
            jVar = this.b;
            if (jVar.b >= j) {
                return true;
            }
        } while (this.a.read(jVar, 8192L) != -1);
        return false;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final String s(long j) throws EOFException {
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("limit < 0: ", j));
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long j3 = j((byte) 10, 0L, j2);
        j jVar = this.b;
        if (j3 != -1) {
            return com.github.catvod.spider.merge.z0.a.c(jVar, j3);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && jVar.A(j2 - 1) == 13 && request(j2 + 1) && jVar.A(j2) == 10) {
            return com.github.catvod.spider.merge.z0.a.c(jVar, j2);
        }
        j jVar2 = new j();
        jVar.z(jVar2, 0L, Math.min(32L, jVar.b));
        throw new EOFException("\\n not found: limit=" + Math.min(jVar.b, j) + " content=" + jVar2.e(jVar2.b).e() + (char) 8230);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void skip(long j) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return;
        }
        while (j > 0) {
            j jVar = this.b;
            if (jVar.b == 0 && this.a.read(jVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, jVar.b);
            jVar.skip(jMin);
            j -= jMin;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void t(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return this.a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final long w() {
        j jVar;
        byte bA;
        t(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            boolean zRequest = request(i2);
            jVar = this.b;
            if (!zRequest) {
                break;
            }
            bA = jVar.A(i);
            if ((bA < 48 || bA > 57) && ((bA < 97 || bA > 102) && (bA < 65 || bA > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            String string = Integer.toString(bA, CharsKt.checkRadix(16));
            string.getClass();
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return jVar.w();
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final String x(Charset charset) {
        charset.getClass();
        r0 r0Var = this.a;
        j jVar = this.b;
        jVar.p(r0Var);
        return jVar.H(jVar.b, charset);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final InputStream y() {
        return new k0(this);
    }

    public final int z() {
        t(4L);
        return c2.U(this.b.readInt());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        j jVar = this.b;
        if (jVar.b == 0 && this.a.read(jVar, 8192L) == -1) {
            return -1;
        }
        return jVar.read(byteBuffer);
    }
}
