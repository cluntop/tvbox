package com.github.catvod.spider.jdollar.util;

import java.util.Collection;
import java.util.RandomAccess;
import java.util.Set;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class DesugarCollections {
    public static <T> java.util.List<T> synchronizedList(java.util.List<T> list) {
        return list instanceof RandomAccess ? new l(list) : new j(list);
    }

    public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> map) {
        return new k(map);
    }

    public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> collection) {
        return new o(collection);
    }

    public static <T> java.util.List<T> unmodifiableList(java.util.List<? extends T> list) {
        return list instanceof RandomAccess ? new v(list) : new q(list);
    }

    public static <K, V> java.util.Map<K, V> unmodifiableMap(java.util.Map<? extends K, ? extends V> map) {
        return new u(map);
    }

    public static <T> Set<T> unmodifiableSet(Set<? extends T> set) {
        return new w(set);
    }
}
