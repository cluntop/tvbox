package com.github.catvod.spider.jdollar.util;

import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface u0 extends a1 {
    void forEachRemaining(IntConsumer intConsumer);

    boolean tryAdvance(IntConsumer intConsumer);

    @Override // com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    u0 trySplit();
}
