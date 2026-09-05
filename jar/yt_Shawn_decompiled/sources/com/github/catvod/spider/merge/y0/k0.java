package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface;
import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k0 extends InputStream implements InputStreamRetargetInterface {
    public final /* synthetic */ l0 a;

    public k0(l0 l0Var) {
        this.a = l0Var;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        l0 l0Var = this.a;
        if (!l0Var.c) {
            return (int) Math.min(l0Var.b.b, 2147483647L);
        }
        com.github.catvod.spider.merge.s0.a.w("closed");
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        l0 l0Var = this.a;
        j jVar = l0Var.b;
        if (l0Var.c) {
            com.github.catvod.spider.merge.s0.a.w("closed");
            return 0;
        }
        c2.g(bArr.length, i, i2);
        if (jVar.b == 0 && l0Var.a.read(jVar, 8192L) == -1) {
            return -1;
        }
        return jVar.read(bArr, i, i2);
    }

    public final String toString() {
        return this.a + ".inputStream()";
    }

    @Override // java.io.InputStream, com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface
    public final long transferTo(OutputStream outputStream) throws IOException {
        outputStream.getClass();
        l0 l0Var = this.a;
        j jVar = l0Var.b;
        if (l0Var.c) {
            com.github.catvod.spider.merge.s0.a.w("closed");
            return 0L;
        }
        long j = 0;
        while (true) {
            if (jVar.b == 0 && l0Var.a.read(jVar, 8192L) == -1) {
                return j;
            }
            long j2 = jVar.b;
            j += j2;
            c2.g(j2, 0L, j2);
            m0 m0Var = jVar.a;
            while (j2 > 0) {
                m0Var.getClass();
                int iMin = (int) Math.min(j2, m0Var.c - m0Var.b);
                outputStream.write(m0Var.a, m0Var.b, iMin);
                int i = m0Var.b + iMin;
                m0Var.b = i;
                long j3 = iMin;
                jVar.b -= j3;
                j2 -= j3;
                if (i == m0Var.c) {
                    m0 m0VarA = m0Var.a();
                    jVar.a = m0VarA;
                    n0.a(m0Var);
                    m0Var = m0VarA;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        l0 l0Var = this.a;
        j jVar = l0Var.b;
        if (l0Var.c) {
            com.github.catvod.spider.merge.s0.a.w("closed");
            return 0;
        }
        if (jVar.b == 0 && l0Var.a.read(jVar, 8192L) == -1) {
            return -1;
        }
        return jVar.readByte() & 255;
    }
}
