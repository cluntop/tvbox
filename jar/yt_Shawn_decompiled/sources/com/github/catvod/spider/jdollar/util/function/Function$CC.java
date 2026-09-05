package com.github.catvod.spider.jdollar.util.function;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.Function;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* renamed from: com.github.catvod.spider.jdollar.util.function.Function$-CC, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class Function$CC {
    public static Function $default$andThen(Function function, Function function2) {
        Objects.requireNonNull(function2);
        return new c(function, function2, 0);
    }

    public static Function $default$compose(Function function, Function function2) {
        Objects.requireNonNull(function2);
        return new c(function, function2, 1);
    }
}
