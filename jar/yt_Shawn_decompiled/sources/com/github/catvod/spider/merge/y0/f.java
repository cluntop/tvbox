package com.github.catvod.spider.merge.y0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class f extends u0 {
    private static final b Companion = new b();
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static f idleSentinel;
    private static final ReentrantLock lock;
    private static final i0 queue;
    public int index = -1;
    private int state;
    private long timeoutAt;

    static {
        i0 i0Var = new i0();
        i0Var.b = new f[8];
        queue = i0Var;
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        condition = conditionNewCondition;
        IDLE_TIMEOUT_MILLIS = 60000L;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(60000L);
    }

    public static /* synthetic */ void setTimeoutAt$okio$default(f fVar, long j, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: setTimeoutAt");
            return;
        }
        if ((i & 1) != 0) {
            j = System.nanoTime();
        }
        fVar.setTimeoutAt$okio(j);
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    @Override // com.github.catvod.spider.merge.y0.u0
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                queue.b(this);
                this.state = 3;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                b.a(Companion, this);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i = this.state;
            this.state = 0;
            if (i != 1) {
                return i == 2;
            }
            queue.b(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long getTimeoutAt$okio() {
        return this.timeoutAt;
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long remainingNanos$okio(long j) {
        return this.timeoutAt - j;
    }

    public final void setTimeoutAt$okio(long j) {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (timeoutNanos() != 0 && hasDeadline()) {
            this.timeoutAt = Math.min(jTimeoutNanos, deadlineNanoTime() - j) + j;
        } else if (jTimeoutNanos != 0) {
            this.timeoutAt = j + jTimeoutNanos;
        } else {
            if (!zHasDeadline) {
                throw new AssertionError();
            }
            this.timeoutAt = deadlineNanoTime();
        }
    }

    public final p0 sink(p0 p0Var) {
        p0Var.getClass();
        return new d(this, p0Var);
    }

    public final r0 source(r0 r0Var) {
        r0Var.getClass();
        return new e(this, r0Var);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> function0) throws IOException {
        function0.getClass();
        enter();
        try {
            try {
                T t = (T) function0.invoke();
                InlineMarker.finallyStart(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                InlineMarker.finallyEnd(1);
                return t;
            } catch (IOException e) {
                if (exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            exit();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
