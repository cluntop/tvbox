package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n extends c5 {
    public static k2 U(a aVar, Spliterator spliterator) {
        j jVar = new j(1);
        j jVar2 = new j(2);
        j jVar3 = new j(3);
        Objects.requireNonNull(jVar);
        Objects.requireNonNull(jVar2);
        Objects.requireNonNull(jVar3);
        return new k2((Collection) new a4(c7.REFERENCE, jVar3, jVar2, jVar, 3).b(aVar, spliterator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 K(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (b7.DISTINCT.o(aVar.f)) {
            return aVar.p(spliterator, false, intFunction);
        }
        if (b7.ORDERED.o(aVar.f)) {
            return U(aVar, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        com.github.catvod.spider.jdollar.nio.file.d0 d0Var = new com.github.catvod.spider.jdollar.nio.file.d0(5, atomicBoolean, concurrentHashMap);
        Objects.requireNonNull(d0Var);
        new o0(d0Var, false).g(aVar, spliterator);
        Set setKeySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(setKeySet);
            hashSet.add(null);
            setKeySet = hashSet;
        }
        return new k2(setKeySet);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator L(a aVar, Spliterator spliterator) {
        return b7.DISTINCT.o(aVar.f) ? aVar.T(spliterator) : b7.ORDERED.o(aVar.f) ? U(aVar, spliterator).spliterator() : new p7(aVar.T(spliterator), new ConcurrentHashMap());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        return b7.DISTINCT.o(i) ? m5Var : b7.SORTED.o(i) ? new l(m5Var) : new m(m5Var);
    }
}
