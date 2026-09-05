package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class z0 extends a1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator I(Supplier supplier) {
        return new l7(supplier);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean M() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final IntStream parallel() {
        this.a.l = true;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final IntStream sequential() {
        this.a.l = false;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream unordered() {
        return !b7.ORDERED.o(this.f) ? this : new t(this, b7.r, 1);
    }
}
