package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Comparator;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f implements java.util.Comparator, Comparator {
    public static final f INSTANCE;
    public static final /* synthetic */ f[] a;

    static {
        f fVar = new f("INSTANCE", 0);
        INSTANCE = fVar;
        a = new f[]{fVar};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) a.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final java.util.Comparator reversed() {
        return Collections.reverseOrder();
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
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
    public final /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.EL.a(this, Comparator.CC.comparing(function));
    }

    @Override // java.util.Comparator, com.github.catvod.spider.jdollar.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.EL.a(this, Comparator.CC.comparing(function, comparator));
    }
}
