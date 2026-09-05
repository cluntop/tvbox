package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k4 implements q4, k5 {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IntBinaryOperator c;

    public k4(int i, IntBinaryOperator intBinaryOperator) {
        this.b = i;
        this.c = intBinaryOperator;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        this.a = this.c.applyAsInt(this.a, i);
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a = this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        v3.g(this, num);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.a);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.q4
    public final void j(q4 q4Var) {
        accept(((k4) q4Var).a);
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }
}
