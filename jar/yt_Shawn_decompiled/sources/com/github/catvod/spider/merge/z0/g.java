package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.u.c2;
import com.github.catvod.spider.merge.y0.m0;
import com.github.catvod.spider.merge.y0.n0;
import com.github.catvod.spider.merge.y0.p0;
import com.github.catvod.spider.merge.y0.u0;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g implements p0 {
    public final OutputStream a;
    public final l b;
    public final /* synthetic */ com.github.catvod.spider.merge.k.a c;

    public g(com.github.catvod.spider.merge.k.a aVar) {
        this.c = aVar;
        Socket socket = (Socket) aVar.b;
        this.a = socket.getOutputStream();
        this.b = new l(socket);
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i;
        OutputStream outputStream = this.a;
        com.github.catvod.spider.merge.k.a aVar = this.c;
        l lVar = this.b;
        lVar.enter();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) aVar.c;
            Socket socket = (Socket) aVar.b;
            atomicInteger.getClass();
            while (true) {
                int i2 = atomicInteger.get();
                if ((i2 & 1) != 0) {
                    i = 0;
                    break;
                }
                int i3 = i2 | 1;
                if (atomicInteger.compareAndSet(i2, i3)) {
                    i = i3;
                    break;
                }
            }
            if (i != 0) {
                if (i != 3) {
                    if (!socket.isClosed() && !socket.isOutputShutdown()) {
                        outputStream.flush();
                        try {
                            socket.shutdownOutput();
                        } catch (UnsupportedOperationException unused) {
                            outputStream.close();
                        }
                    }
                    return;
                }
                socket.close();
                Unit unit = Unit.INSTANCE;
                if (lVar.exit()) {
                    throw lVar.access$newTimeoutException(null);
                }
            }
        } catch (IOException e) {
            if (!lVar.exit()) {
                throw e;
            }
            throw lVar.access$newTimeoutException(e);
        } finally {
            lVar.exit();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() throws IOException {
        l lVar = this.b;
        lVar.enter();
        try {
            this.a.flush();
            Unit unit = Unit.INSTANCE;
            if (lVar.exit()) {
                throw lVar.access$newTimeoutException(null);
            }
        } catch (IOException e) {
            if (!lVar.exit()) {
                throw e;
            }
            throw lVar.access$newTimeoutException(e);
        } finally {
            lVar.exit();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final u0 timeout() {
        return this.b;
    }

    public final String toString() {
        return "sink(" + ((Socket) this.c.b) + ')';
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(com.github.catvod.spider.merge.y0.j jVar, long j) throws IOException {
        jVar.getClass();
        c2.g(jVar.b, 0L, j);
        while (j > 0) {
            l lVar = this.b;
            lVar.throwIfReached();
            m0 m0Var = jVar.a;
            m0Var.getClass();
            int iMin = (int) Math.min(j, m0Var.c - m0Var.b);
            lVar.enter();
            try {
                try {
                    this.a.write(m0Var.a, m0Var.b, iMin);
                    Unit unit = Unit.INSTANCE;
                    if (lVar.exit()) {
                        throw lVar.access$newTimeoutException(null);
                    }
                    int i = m0Var.b + iMin;
                    m0Var.b = i;
                    long j2 = iMin;
                    j -= j2;
                    jVar.b -= j2;
                    if (i == m0Var.c) {
                        jVar.a = m0Var.a();
                        n0.a(m0Var);
                    }
                } catch (IOException e) {
                    if (!lVar.exit()) {
                        throw e;
                    }
                    throw lVar.access$newTimeoutException(e);
                }
            } catch (Throwable th) {
                lVar.exit();
                throw th;
            }
        }
    }
}
