package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class s1 implements m5 {
    public boolean a;
    public boolean b;

    public s1(t1 t1Var) {
        this.b = !t1Var.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void c(long j) {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }
}
