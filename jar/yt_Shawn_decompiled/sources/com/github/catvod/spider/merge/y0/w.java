package com.github.catvod.spider.merge.y0;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w extends u0 {
    public u0 a;

    public w(u0 u0Var) {
        u0Var.getClass();
        this.a = u0Var;
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final void awaitSignal(Condition condition) throws InterruptedException, InterruptedIOException {
        condition.getClass();
        this.a.awaitSignal(condition);
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final u0 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final u0 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final void throwIfReached() throws InterruptedIOException {
        this.a.throwIfReached();
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final u0 timeout(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.a.timeout(j, timeUnit);
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        obj.getClass();
        this.a.waitUntilNotified(obj);
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public final u0 deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}
