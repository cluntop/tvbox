package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class i5 implements m5 {
    public final m5 a;

    public i5(m5 m5Var) {
        this.a = (m5) Objects.requireNonNull(m5Var);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        v3.c();
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

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }
}
