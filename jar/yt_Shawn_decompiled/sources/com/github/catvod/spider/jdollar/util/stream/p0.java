package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p0 implements n8, o8 {
    public final boolean a;

    public p0(boolean z) {
        this.a = z;
    }

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
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final int f() {
        if (this.a) {
            return 0;
        }
        return b7.r;
    }

    public final void g(a aVar, Spliterator spliterator) {
        if (this.a) {
            new q0(aVar, spliterator, this).invoke();
        } else {
            new r0(aVar, spliterator, aVar.S(this)).invoke();
        }
    }

    public /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }
}
