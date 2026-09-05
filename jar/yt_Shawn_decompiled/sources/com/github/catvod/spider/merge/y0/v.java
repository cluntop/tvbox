package com.github.catvod.spider.merge.y0;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class v implements r0 {
    private final r0 delegate;

    public v(r0 r0Var) {
        r0Var.getClass();
        this.delegate = r0Var;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final r0 m30deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final r0 delegate() {
        return this.delegate;
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public long read(j jVar, long j) {
        jVar.getClass();
        return this.delegate.read(jVar, j);
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public u0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
