package com.github.catvod.spider.merge.y0;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class n0 {
    public static final m0 a = new m0(new byte[0], 0, 0, false, false);
    public static final int b;
    public static final AtomicReference[] c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        c = atomicReferenceArr;
    }

    public static final void a(m0 m0Var) {
        m0Var.getClass();
        if (m0Var.f != null || m0Var.g != null) {
            com.github.catvod.spider.merge.s0.a.r("Failed requirement.");
            return;
        }
        if (m0Var.d) {
            return;
        }
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (b - 1))];
        m0 m0Var2 = a;
        m0 m0Var3 = (m0) atomicReference.getAndSet(m0Var2);
        if (m0Var3 == m0Var2) {
            return;
        }
        int i = m0Var3 != null ? m0Var3.c : 0;
        if (i >= 65536) {
            atomicReference.set(m0Var3);
            return;
        }
        m0Var.f = m0Var3;
        m0Var.b = 0;
        m0Var.c = i + 8192;
        atomicReference.set(m0Var);
    }

    public static final m0 b() {
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (b - 1))];
        m0 m0Var = a;
        m0 m0Var2 = (m0) atomicReference.getAndSet(m0Var);
        if (m0Var2 == m0Var) {
            return new m0();
        }
        if (m0Var2 == null) {
            atomicReference.set(null);
            return new m0();
        }
        atomicReference.set(m0Var2.f);
        m0Var2.f = null;
        m0Var2.c = 0;
        return m0Var2;
    }
}
