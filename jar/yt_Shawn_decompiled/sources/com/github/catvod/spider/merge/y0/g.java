package com.github.catvod.spider.merge.y0;

import java.io.EOFException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g implements p0 {
    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() {
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final u0 timeout() {
        return u0.NONE;
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) throws EOFException {
        jVar.getClass();
        jVar.skip(j);
    }
}
