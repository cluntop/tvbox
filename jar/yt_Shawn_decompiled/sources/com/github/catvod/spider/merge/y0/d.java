package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Unit;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d implements p0 {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final Object c;

    public d(OutputStream outputStream, u0 u0Var) {
        outputStream.getClass();
        this.b = outputStream;
        this.c = u0Var;
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                f fVar = (f) obj;
                p0 p0Var = (p0) this.c;
                fVar.enter();
                try {
                    p0Var.close();
                    Unit unit = Unit.INSTANCE;
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!fVar.exit()) {
                        throw e;
                    }
                    throw fVar.access$newTimeoutException(e);
                } finally {
                    fVar.exit();
                }
            default:
                ((OutputStream) obj).close();
                return;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                f fVar = (f) obj;
                p0 p0Var = (p0) this.c;
                fVar.enter();
                try {
                    p0Var.flush();
                    Unit unit = Unit.INSTANCE;
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!fVar.exit()) {
                        throw e;
                    }
                    throw fVar.access$newTimeoutException(e);
                } finally {
                    fVar.exit();
                }
            default:
                ((OutputStream) obj).flush();
                return;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final u0 timeout() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return (f) this.b;
            default:
                return (u0) this.c;
        }
    }

    public final String toString() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return "AsyncTimeout.sink(" + ((p0) this.c) + ')';
            default:
                return "sink(" + ((OutputStream) this.b) + ')';
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) throws IOException {
        long j2;
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        jVar.getClass();
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                c2.g(jVar.b, 0L, j);
                for (long j3 = j; j3 > 0; j3 -= j2) {
                    m0 m0Var = jVar.a;
                    m0Var.getClass();
                    j2 = 0;
                    while (true) {
                        if (j2 < 65536) {
                            j2 += m0Var.c - m0Var.b;
                            if (j2 >= j3) {
                                j2 = j3;
                            } else {
                                m0Var = m0Var.f;
                                m0Var.getClass();
                            }
                        }
                    }
                    f fVar = (f) obj;
                    p0 p0Var = (p0) obj2;
                    fVar.enter();
                    try {
                        p0Var.write(jVar, j2);
                        Unit unit = Unit.INSTANCE;
                        if (fVar.exit()) {
                            throw fVar.access$newTimeoutException(null);
                        }
                    } catch (IOException e) {
                        if (!fVar.exit()) {
                            throw e;
                        }
                        throw fVar.access$newTimeoutException(e);
                    } finally {
                        fVar.exit();
                    }
                }
                return;
            default:
                c2.g(jVar.b, 0L, j);
                long j4 = j;
                while (j4 > 0) {
                    ((u0) obj2).throwIfReached();
                    m0 m0Var2 = jVar.a;
                    m0Var2.getClass();
                    int iMin = (int) Math.min(j4, m0Var2.c - m0Var2.b);
                    ((OutputStream) obj).write(m0Var2.a, m0Var2.b, iMin);
                    int i2 = m0Var2.b + iMin;
                    m0Var2.b = i2;
                    long j5 = iMin;
                    j4 -= j5;
                    jVar.b -= j5;
                    if (i2 == m0Var2.c) {
                        jVar.a = m0Var2.a();
                        n0.a(m0Var2);
                    }
                }
                return;
        }
    }

    public d(f fVar, p0 p0Var) {
        this.b = fVar;
        this.c = p0Var;
    }
}
