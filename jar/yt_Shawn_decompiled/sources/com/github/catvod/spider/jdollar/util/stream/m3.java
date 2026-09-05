package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m3 extends u6 implements e2, x1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.f2, com.github.catvod.spider.jdollar.util.stream.g2
    public final f2 a(int i) {
        throw new IndexOutOfBoundsException();
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

    @Override // com.github.catvod.spider.jdollar.util.stream.w6, com.github.catvod.spider.jdollar.util.stream.f2
    public final Object b() {
        return (long[]) super.b();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.x1, com.github.catvod.spider.jdollar.util.stream.y1
    public final e2 build() {
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        clear();
        w(j);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6, com.github.catvod.spider.jdollar.util.stream.f2
    public final void f(int i, Object obj) {
        super.f(i, (long[]) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6, com.github.catvod.spider.jdollar.util.stream.f2
    public final void h(Object obj) {
        super.h((LongConsumer) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.v(this, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void m(Object[] objArr, int i) {
        v3.p(this, (Long[]) objArr, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5
    public final /* synthetic */ void o(Long l) {
        v3.i(this, l);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ Object[] q(IntFunction intFunction) {
        return v3.m(this, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ int s() {
        return 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.u6, com.github.catvod.spider.jdollar.util.stream.w6, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final com.github.catvod.spider.jdollar.util.a1 spliterator() {
        return super.spliterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y1
    public final g2 build() {
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.u6, com.github.catvod.spider.jdollar.util.stream.w6, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* bridge */ /* synthetic */ g2 a(int i) {
        a(i);
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Long) obj);
    }
}
