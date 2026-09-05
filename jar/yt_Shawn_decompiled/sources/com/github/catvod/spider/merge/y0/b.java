package com.github.catvod.spider.merge.y0;

import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b {
    public static final void a(b bVar, f fVar) {
        bVar.getClass();
        if (f.idleSentinel == null) {
            f.idleSentinel = new f();
            c cVar = new c("Okio Watchdog");
            cVar.setDaemon(true);
            cVar.start();
        }
        f.setTimeoutAt$okio$default(fVar, 0L, 1, null);
        i0 i0Var = f.queue;
        i0Var.getClass();
        int i = i0Var.a + 1;
        i0Var.a = i;
        f[] fVarArr = i0Var.b;
        if (i == fVarArr.length) {
            f[] fVarArr2 = new f[i * 2];
            ArraysKt.o(fVarArr, fVarArr2);
            i0Var.b = fVarArr2;
        }
        i0Var.a(fVar, i);
        if (fVar.index == 1) {
            f.condition.signal();
        }
    }

    public static f b() throws InterruptedException {
        f fVar = f.queue.b[1];
        if (fVar == null) {
            long jNanoTime = System.nanoTime();
            f.condition.await(f.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            if (f.queue.b[1] != null || System.nanoTime() - jNanoTime < f.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return f.idleSentinel;
        }
        long jRemainingNanos$okio = fVar.remainingNanos$okio(System.nanoTime());
        if (jRemainingNanos$okio > 0) {
            f.condition.await(jRemainingNanos$okio, TimeUnit.NANOSECONDS);
            return null;
        }
        f.queue.b(fVar);
        fVar.state = 2;
        return fVar;
    }
}
