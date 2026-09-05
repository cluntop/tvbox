package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d5 extends e5 {
    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean M() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream unordered() {
        return !b7.ORDERED.o(this.f) ? this : new z4(this, b7.r);
    }
}
