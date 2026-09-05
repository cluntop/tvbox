package com.github.catvod.spider.merge.y0;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        f fVarB;
        while (true) {
            try {
                f.Companion.getClass();
                reentrantLock = f.lock;
                reentrantLock.lock();
                try {
                    f.Companion.getClass();
                    fVarB = b.b();
                    f.Companion.getClass();
                } finally {
                    reentrantLock.unlock();
                }
            } catch (InterruptedException unused) {
                continue;
            }
            if (fVarB == f.idleSentinel) {
                f.Companion.getClass();
                f.idleSentinel = null;
                return;
            } else {
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                if (fVarB != null) {
                    fVarB.timedOut();
                }
            }
        }
    }
}
