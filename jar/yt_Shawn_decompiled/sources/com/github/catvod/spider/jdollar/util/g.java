package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Comparator;
import java.io.Serializable;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g implements java.util.Comparator, Serializable, Comparator {
    private static final long serialVersionUID = -7569533591570686392L;
    public final boolean a;
    public final java.util.Comparator b;

    public g(boolean z, java.util.Comparator comparator) {
        this.a = z;
        this.b = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return 0;
            }
            return this.a ? -1 : 1;
        }
        if (obj2 == null) {
            return this.a ? 1 : -1;
        }
        java.util.Comparator comparator = this.b;
        if (comparator == null) {
            return 0;
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final java.util.Comparator reversed() {
        boolean z = !this.a;
        java.util.Comparator comparator = this.b;
        return new g(z, comparator == null ? null : Comparator.EL.reversed(comparator));
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final java.util.Comparator thenComparing(java.util.Comparator comparator) {
        Objects.requireNonNull(comparator);
        boolean z = this.a;
        java.util.Comparator comparator2 = this.b;
        if (comparator2 != null) {
            comparator = Comparator.EL.a(comparator2, comparator);
        }
        return new g(z, comparator);
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.EL.a(this, Comparator.CC.comparingInt(toIntFunction));
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.EL.a(this, Comparator.CC.comparing(function, comparator));
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.EL.a(this, Comparator.CC.comparing(function));
    }
}
