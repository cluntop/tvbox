package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class f5 implements j5 {
    public final m5 a;

    public f5(m5 m5Var) {
        this.a = (m5) Objects.requireNonNull(m5Var);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public void c(long j) {
        this.a.c(j);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public boolean e() {
        return this.a.e();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public void end() {
        this.a.end();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5
    public final /* synthetic */ void r(Double d) {
        v3.d(this, d);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        r((Double) obj);
    }
}
