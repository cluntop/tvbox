package com.github.catvod.spider.merge.y0;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e implements r0 {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final Object c;

    public e(InputStream inputStream, u0 u0Var) {
        inputStream.getClass();
        u0Var.getClass();
        this.b = inputStream;
        this.c = u0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                f fVar = (f) obj;
                r0 r0Var = (r0) this.c;
                fVar.enter();
                try {
                    r0Var.close();
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
                ((InputStream) obj).close();
                return;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(j jVar, long j) throws IOException {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        jVar.getClass();
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                f fVar = (f) obj;
                r0 r0Var = (r0) obj2;
                fVar.enter();
                try {
                    long j2 = r0Var.read(jVar, j);
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(null);
                    }
                    return j2;
                } catch (IOException e) {
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    fVar.exit();
                }
            default:
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
                    return 0L;
                }
                try {
                    ((u0) obj2).throwIfReached();
                    m0 m0VarL = jVar.L(1);
                    int i2 = ((InputStream) obj).read(m0VarL.a, m0VarL.c, (int) Math.min(j, 8192 - m0VarL.c));
                    if (i2 == -1) {
                        if (m0VarL.b == m0VarL.c) {
                            jVar.a = m0VarL.a();
                            n0.a(m0VarL);
                        }
                        return -1L;
                    }
                    m0VarL.c += i2;
                    long j3 = i2;
                    jVar.b += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (com.github.catvod.spider.merge.z0.q.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
        }
    }

    @Override // com.github.catvod.spider.merge.y0.r0
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
                return "AsyncTimeout.source(" + ((r0) this.c) + ')';
            default:
                return "source(" + ((InputStream) this.b) + ')';
        }
    }

    public e(f fVar, r0 r0Var) {
        this.b = fVar;
        this.c = r0Var;
    }
}
