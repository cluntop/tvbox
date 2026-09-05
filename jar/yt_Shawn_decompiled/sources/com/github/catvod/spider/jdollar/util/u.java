package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Map;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u implements java.util.Map, Serializable, Map {
    private static final long serialVersionUID = -1034234728574286014L;
    public final java.util.Map a;
    public transient Set b;
    public transient t c;
    public transient Collection d;

    public u(java.util.Map map) {
        map.getClass();
        this.a = map;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.c == null) {
            this.c = new t(this.a.entrySet());
        }
        return this.c;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || this.a.equals(obj);
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final void forEach(BiConsumer biConsumer) {
        Map.EL.a(this.a, biConsumer);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.a.get(obj);
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        return Map.EL.getOrDefault(this.a, obj, obj2);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.b == null) {
            this.b = DesugarCollections.unmodifiableSet(this.a.keySet());
        }
        return this.b;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.d == null) {
            this.d = DesugarCollections.unmodifiableCollection(this.a.values());
        }
        return this.d;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
