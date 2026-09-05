package com.github.catvod.spider.jdollar.util;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface a1 extends Spliterator {
    void forEachRemaining(Object obj);

    boolean tryAdvance(Object obj);

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    a1 trySplit();
}
