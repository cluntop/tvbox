package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y7 extends z7 implements com.github.catvod.spider.jdollar.util.x0 {
    @Override // com.github.catvod.spider.jdollar.util.stream.b8
    public final Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
        return new y7((com.github.catvod.spider.jdollar.util.x0) spliterator, j, j2, j3, j4);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.z7
    public final Object b() {
        return new d2(1);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.g(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.p(this, consumer);
    }
}
