package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface g2 {
    g2 a(int i);

    long count();

    void forEach(Consumer consumer);

    g2 l(long j, long j2, IntFunction intFunction);

    void m(Object[] objArr, int i);

    Object[] q(IntFunction intFunction);

    int s();

    Spliterator spliterator();
}
