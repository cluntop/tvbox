package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x implements p0 {
    public final j0 a;
    public final Deflater b;
    public final n c;
    public boolean d;
    public final CRC32 e;

    public x(k kVar) {
        kVar.getClass();
        j0 j0Var = new j0(kVar);
        this.a = j0Var;
        Deflater deflater = new Deflater(-1, true);
        this.b = deflater;
        this.c = new n(j0Var, deflater);
        this.e = new CRC32();
        j jVar = j0Var.b;
        jVar.R(8075);
        jVar.N(8);
        jVar.N(0);
        jVar.Q(0);
        jVar.N(0);
        jVar.N(0);
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        int value;
        boolean z;
        j jVar;
        Deflater deflater = this.b;
        j0 j0Var = this.a;
        if (this.d) {
            return;
        }
        try {
            n nVar = this.c;
            nVar.b.finish();
            nVar.j(false);
            value = (int) this.e.getValue();
            z = j0Var.c;
            jVar = j0Var.b;
        } catch (Throwable th) {
            th = th;
        }
        if (z) {
            throw new IllegalStateException("closed");
        }
        jVar.Q(c2.U(value));
        j0Var.q();
        int bytesRead = (int) deflater.getBytesRead();
        if (j0Var.c) {
            throw new IllegalStateException("closed");
        }
        jVar.Q(c2.U(bytesRead));
        j0Var.q();
        th = null;
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            j0Var.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() throws IOException {
        this.c.flush();
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final u0 timeout() {
        return this.a.a.timeout();
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) throws IOException {
        jVar.getClass();
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return;
        }
        if (j == 0) {
            return;
        }
        m0 m0Var = jVar.a;
        m0Var.getClass();
        long j2 = j;
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, m0Var.c - m0Var.b);
            this.e.update(m0Var.a, m0Var.b, iMin);
            j2 -= iMin;
            m0Var = m0Var.f;
            m0Var.getClass();
        }
        this.c.write(jVar, j);
    }
}
