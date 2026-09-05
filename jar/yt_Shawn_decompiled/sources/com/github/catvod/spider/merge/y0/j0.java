package com.github.catvod.spider.merge.y0;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j0 implements k {
    public final p0 a;
    public final j b;
    public boolean c;

    public j0(p0 p0Var) {
        p0Var.getClass();
        this.a = p0Var;
        this.b = new j();
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final j a() {
        return this.b;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k b(String str, int i, int i2) {
        str.getClass();
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.U(str, i, i2);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k c(long j) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.P(j);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        p0 p0Var = this.a;
        if (this.c) {
            return;
        }
        try {
            j jVar = this.b;
            long j = jVar.b;
            if (j > 0) {
                p0Var.write(jVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            p0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.k, com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return;
        }
        j jVar = this.b;
        long j = jVar.b;
        p0 p0Var = this.a;
        if (j > 0) {
            p0Var.write(jVar, j);
        }
        p0Var.flush();
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k h(int i) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.V(i);
        q();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k o(m mVar) {
        mVar.getClass();
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.M(mVar);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final long p(r0 r0Var) {
        r0Var.getClass();
        long j = 0;
        while (true) {
            long j2 = r0Var.read(this.b, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            q();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k q() {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        j jVar = this.b;
        long j = jVar.b;
        if (j == 0) {
            j = 0;
        } else {
            m0 m0Var = jVar.a;
            m0Var.getClass();
            m0 m0Var2 = m0Var.g;
            m0Var2.getClass();
            if (m0Var2.c < 8192 && m0Var2.e) {
                j -= r6 - m0Var2.b;
            }
        }
        if (j > 0) {
            this.a.write(jVar, j);
        }
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final u0 timeout() {
        return this.a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k u(String str) {
        str.getClass();
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.T(str);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k v(long j) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.O(j);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k write(byte[] bArr) {
        bArr.getClass();
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.m25write(bArr, 0, bArr.length);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k writeByte(int i) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.N(i);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k writeInt(int i) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.Q(i);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k writeShort(int i) {
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return null;
        }
        this.b.R(i);
        q();
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) {
        jVar.getClass();
        if (!this.c) {
            this.b.write(jVar, j);
            q();
        } else {
            com.github.catvod.spider.merge.s0.a.h("closed");
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (!this.c) {
            int iWrite = this.b.write(byteBuffer);
            q();
            return iWrite;
        }
        com.github.catvod.spider.merge.s0.a.h("closed");
        return 0;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        if (!this.c) {
            this.b.m25write(bArr, i, i2);
            q();
            return this;
        }
        com.github.catvod.spider.merge.s0.a.h("closed");
        return null;
    }
}
