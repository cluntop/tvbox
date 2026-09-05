package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.m0;
import com.github.catvod.spider.merge.y0.n0;
import com.github.catvod.spider.merge.y0.r0;
import com.github.catvod.spider.merge.y0.u0;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h implements r0 {
    public final InputStream a;
    public final l b;
    public final /* synthetic */ com.github.catvod.spider.merge.k.a c;

    public h(com.github.catvod.spider.merge.k.a aVar) {
        this.c = aVar;
        Socket socket = (Socket) aVar.b;
        this.a = socket.getInputStream();
        this.b = new l(socket);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i;
        com.github.catvod.spider.merge.k.a aVar = this.c;
        l lVar = this.b;
        lVar.enter();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) aVar.c;
            Socket socket = (Socket) aVar.b;
            atomicInteger.getClass();
            while (true) {
                int i2 = atomicInteger.get();
                if ((i2 & 2) != 0) {
                    i = 0;
                    break;
                }
                int i3 = i2 | 2;
                if (atomicInteger.compareAndSet(i2, i3)) {
                    i = i3;
                    break;
                }
            }
            if (i != 0) {
                if (i == 3) {
                    socket.close();
                } else {
                    if (socket.isClosed() || socket.isInputShutdown()) {
                        return;
                    }
                    try {
                        socket.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                        this.a.close();
                    }
                }
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

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(com.github.catvod.spider.merge.y0.j jVar, long j) throws IOException {
        jVar.getClass();
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return 0L;
        }
        l lVar = this.b;
        lVar.throwIfReached();
        m0 m0VarL = jVar.L(1);
        int iMin = (int) Math.min(j, 8192 - m0VarL.c);
        try {
            lVar.enter();
            try {
                int i = this.a.read(m0VarL.a, m0VarL.c, iMin);
                if (lVar.exit()) {
                    throw lVar.access$newTimeoutException(null);
                }
                if (i != -1) {
                    m0VarL.c += i;
                    long j2 = i;
                    jVar.b += j2;
                    return j2;
                }
                if (m0VarL.b != m0VarL.c) {
                    return -1L;
                }
                jVar.a = m0VarL.a();
                n0.a(m0VarL);
                return -1L;
            } catch (IOException e) {
                if (lVar.exit()) {
                    throw lVar.access$newTimeoutException(e);
                }
                throw e;
            } finally {
                lVar.exit();
            }
        } catch (AssertionError e2) {
            if (q.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return this.b;
    }

    public final String toString() {
        return "source(" + ((Socket) this.c.b) + ')';
    }
}
