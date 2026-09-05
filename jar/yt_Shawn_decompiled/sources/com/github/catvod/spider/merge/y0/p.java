package com.github.catvod.spider.merge.y0;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p implements Closeable {
    public boolean a;
    public int b;
    public final ReentrantLock c = new ReentrantLock();

    public abstract long A();

    public final o B(long j) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.a) {
                throw new IllegalStateException("closed");
            }
            this.b++;
            reentrantLock.unlock();
            return new o(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.a) {
                return;
            }
            this.a = true;
            if (this.b != 0) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            j();
        } finally {
            reentrantLock.unlock();
        }
    }

    public abstract void j();

    public final long size() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.a) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return A();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract int z(byte[] bArr, int i, int i2, long j);
}
