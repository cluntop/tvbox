package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g4 implements q4 {
    public boolean a;
    public Object b;
    public final /* synthetic */ BinaryOperator c;

    public g4(BinaryOperator binaryOperator) {
        this.c = binaryOperator;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (!this.a) {
            this.b = this.c.apply(this.b, obj);
        } else {
            this.a = false;
            this.b = obj;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a = true;
        this.b = null;
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
        return this.a ? Optional.empty() : Optional.of(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.q4
    public final void j(q4 q4Var) {
        g4 g4Var = (g4) q4Var;
        if (g4Var.a) {
            return;
        }
        accept(g4Var.b);
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

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }
}
