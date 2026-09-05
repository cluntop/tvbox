package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v4 extends w4 {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.b++;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.q4
    public final void j(q4 q4Var) {
        this.b += ((w4) q4Var).b;
    }
}
