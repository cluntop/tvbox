package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntFunction;
import java.util.function.LongFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k0 implements IntFunction, LongFunction {
    public IntFunction a;

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        Object objApply = this.a.apply(i);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof IntStream) {
            return c1.g((IntStream) objApply);
        }
        if (objApply instanceof java.util.stream.IntStream) {
            return b1.g((java.util.stream.IntStream) objApply);
        }
        com.github.catvod.spider.jdollar.util.h.a(objApply.getClass(), "java.util.stream.IntStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        return v3.z(j, this.a);
    }
}
