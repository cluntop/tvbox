package com.github.catvod.spider.jdollar.util.function;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.IntUnaryOperator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* renamed from: com.github.catvod.spider.jdollar.util.function.IntUnaryOperator$-CC, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class IntUnaryOperator$CC {
    public static IntUnaryOperator $default$andThen(IntUnaryOperator intUnaryOperator, IntUnaryOperator intUnaryOperator2) {
        Objects.requireNonNull(intUnaryOperator2);
        return new e(intUnaryOperator, intUnaryOperator2, 0);
    }

    public static IntUnaryOperator $default$compose(IntUnaryOperator intUnaryOperator, IntUnaryOperator intUnaryOperator2) {
        Objects.requireNonNull(intUnaryOperator2);
        return new e(intUnaryOperator, intUnaryOperator2, 1);
    }
}
