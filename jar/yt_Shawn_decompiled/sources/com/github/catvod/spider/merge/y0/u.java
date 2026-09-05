package com.github.catvod.spider.merge.y0;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class u implements p0 {
    private final p0 delegate;

    public u(p0 p0Var) {
        p0Var.getClass();
        this.delegate = p0Var;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final p0 m29deprecated_delegate() {
        return this.delegate;
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final p0 delegate() {
        return this.delegate;
    }

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public u0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public void write(j jVar, long j) {
        jVar.getClass();
        this.delegate.write(jVar, j);
    }
}
