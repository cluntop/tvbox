package com.github.catvod.spider.jdollar.util.function;

import com.github.catvod.spider.jdollar.nio.file.d0;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* renamed from: com.github.catvod.spider.jdollar.util.function.BiFunction$-CC, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class BiFunction$CC {
    public static BiFunction $default$andThen(BiFunction biFunction, Function function) {
        Objects.requireNonNull(function);
        return new d0(3, biFunction, function);
    }
}
