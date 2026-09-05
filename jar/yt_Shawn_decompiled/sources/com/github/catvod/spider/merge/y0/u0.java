package com.github.catvod.spider.merge.y0;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class u0 {
    public static final t0 Companion = new t0();
    public static final u0 NONE = new s0();
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public void awaitSignal(Condition condition) throws InterruptedException, InterruptedIOException {
        condition.getClass();
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            if (!zHasDeadline && jTimeoutNanos == 0) {
                condition.await();
                return;
            }
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - System.nanoTime());
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - System.nanoTime();
            }
            if (jTimeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            if (condition.awaitNanos(jTimeoutNanos) <= 0 && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public u0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public u0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final u0 deadline(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j > 0) {
            return deadlineNanoTime(timeUnit.toNanos(j) + System.nanoTime());
        }
        com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("duration <= 0: ", j));
        return null;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        com.github.catvod.spider.merge.s0.a.h("No deadline");
        return 0L;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(u0 u0Var, Function0<? extends T> function0) {
        u0Var.getClass();
        function0.getClass();
        long jTimeoutNanos = timeoutNanos();
        t0 t0Var = Companion;
        long jTimeoutNanos2 = u0Var.timeoutNanos();
        long jTimeoutNanos3 = timeoutNanos();
        t0Var.getClass();
        if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
            jTimeoutNanos2 = jTimeoutNanos3;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(jTimeoutNanos2, timeUnit);
        if (!hasDeadline()) {
            if (u0Var.hasDeadline()) {
                deadlineNanoTime(u0Var.deadlineNanoTime());
            }
            try {
                return (T) function0.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                timeout(jTimeoutNanos, timeUnit);
                if (u0Var.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (u0Var.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), u0Var.deadlineNanoTime()));
        }
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            timeout(jTimeoutNanos, timeUnit);
            if (u0Var.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public void throwIfReached() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public u0 timeout(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("timeout < 0: ", j));
        return null;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        obj.getClass();
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime;
            }
            if (jTimeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj2 = this.cancelMark;
            long j = jTimeoutNanos / 1000000;
            Long.signum(j);
            obj.wait(j, (int) (jTimeoutNanos - (1000000 * j)));
            if (System.nanoTime() - jNanoTime >= jTimeoutNanos && this.cancelMark == obj2) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public u0 deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
