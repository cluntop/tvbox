package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n implements p0 {
    public final j0 a;
    public final Deflater b;
    public boolean c;

    public n(j0 j0Var, Deflater deflater) {
        this.a = j0Var;
        this.b = deflater;
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.b;
        if (this.c) {
            return;
        }
        try {
            deflater.finish();
            j(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() throws IOException {
        j(true);
        this.a.flush();
    }

    public final void j(boolean z) throws IOException {
        m0 m0VarL;
        int iDeflate;
        j0 j0Var = this.a;
        j jVar = j0Var.b;
        while (true) {
            m0VarL = jVar.L(1);
            byte[] bArr = m0VarL.a;
            int i = m0VarL.c;
            Deflater deflater = this.b;
            if (z) {
                try {
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (IllegalStateException e) {
                    throw new IOException("Deflater already closed", e);
                } catch (NullPointerException e2) {
                    throw new IOException("Deflater already closed", e2);
                }
            } else {
                iDeflate = deflater.deflate(bArr, i, 8192 - i);
            }
            if (iDeflate > 0) {
                m0VarL.c += iDeflate;
                jVar.b += iDeflate;
                j0Var.q();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (m0VarL.b == m0VarL.c) {
            jVar.a = m0VarL.a();
            n0.a(m0VarL);
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final u0 timeout() {
        return this.a.a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.a + ')';
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) throws IOException {
        jVar.getClass();
        c2.g(jVar.b, 0L, j);
        while (true) {
            Deflater deflater = this.b;
            if (j <= 0) {
                deflater.setInput(com.github.catvod.spider.merge.z0.b.b, 0, 0);
                return;
            }
            m0 m0Var = jVar.a;
            m0Var.getClass();
            int iMin = (int) Math.min(j, m0Var.c - m0Var.b);
            deflater.setInput(m0Var.a, m0Var.b, iMin);
            j(false);
            long j2 = iMin;
            jVar.b -= j2;
            int i = m0Var.b + iMin;
            m0Var.b = i;
            if (i == m0Var.c) {
                jVar.a = m0Var.a();
                n0.a(m0Var);
            }
            j -= j2;
        }
    }
}
