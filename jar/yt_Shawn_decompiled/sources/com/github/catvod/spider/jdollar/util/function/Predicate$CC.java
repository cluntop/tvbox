package com.github.catvod.spider.jdollar.util.function;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.Predicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* renamed from: com.github.catvod.spider.jdollar.util.function.Predicate$-CC, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class Predicate$CC {
    public static Predicate $default$and(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new g(predicate, predicate2, 0);
    }

    public static Predicate $default$negate(Predicate predicate) {
        return new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(5, predicate);
    }

    public static Predicate $default$or(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new g(predicate, predicate2, 1);
    }
}
