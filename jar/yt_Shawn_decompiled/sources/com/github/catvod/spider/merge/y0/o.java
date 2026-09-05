package com.github.catvod.spider.merge.y0;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o implements r0 {
    public final p a;
    public long b;
    public boolean c;

    public o(p pVar, long j) {
        this.a = pVar;
        this.b = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        p pVar = this.a;
        ReentrantLock reentrantLock = pVar.c;
        reentrantLock.lock();
        try {
            int i = pVar.b - 1;
            pVar.b = i;
            if (i == 0 && pVar.a) {
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                pVar.j();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(j jVar, long j) {
        long j2;
        long j3;
        jVar.getClass();
        if (this.c) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return 0L;
        }
        long j4 = this.b;
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return 0L;
        }
        long j5 = j + j4;
        long j6 = j4;
        while (true) {
            if (j6 >= j5) {
                j2 = -1;
                break;
            }
            m0 m0VarL = jVar.L(1);
            j2 = -1;
            long j7 = j5;
            int iZ = this.a.z(m0VarL.a, m0VarL.c, (int) Math.min(j5 - j6, 8192 - r11), j6);
            if (iZ == -1) {
                if (m0VarL.b == m0VarL.c) {
                    jVar.a = m0VarL.a();
                    n0.a(m0VarL);
                }
                if (j4 == j6) {
                    j3 = -1;
                }
            } else {
                m0VarL.c += iZ;
                long j8 = iZ;
                j6 += j8;
                jVar.b += j8;
                j5 = j7;
            }
        }
        j3 = j6 - j4;
        if (j3 != j2) {
            this.b += j3;
        }
        return j3;
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return u0.NONE;
    }
}
