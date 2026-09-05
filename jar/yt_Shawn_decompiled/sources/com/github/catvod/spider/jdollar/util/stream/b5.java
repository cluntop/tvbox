package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b5 extends e5 {
    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean M() {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.e5, com.github.catvod.spider.jdollar.util.stream.Stream
    public final void forEach(Consumer consumer) {
        if (this.a.l) {
            super.forEach(consumer);
        } else {
            P().forEachRemaining(consumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.e5, com.github.catvod.spider.jdollar.util.stream.Stream
    public final void forEachOrdered(Consumer consumer) {
        if (this.a.l) {
            super.forEachOrdered(consumer);
        } else {
            P().forEachRemaining(consumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream unordered() {
        return !b7.ORDERED.o(this.f) ? this : new z4(this, b7.r);
    }
}
