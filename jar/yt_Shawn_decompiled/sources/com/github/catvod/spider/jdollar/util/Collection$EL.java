package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.List;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* renamed from: com.github.catvod.spider.jdollar.util.Collection$-EL, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class Collection$EL {
    public static void a(Collection collection, Consumer consumer) {
        if (collection instanceof c) {
            ((c) collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static /* synthetic */ Stream b(Collection collection) {
        return collection instanceof c ? ((c) collection).parallelStream() : StreamSupport.stream(c(collection), true);
    }

    public static Spliterator c(Collection collection) {
        if (collection instanceof c) {
            return ((c) collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            return Spliterators.b(17, (LinkedHashSet) collection);
        }
        if (!(collection instanceof SortedSet)) {
            return collection instanceof Set ? Spliterators.b(1, (Set) collection) : collection instanceof java.util.List ? List.CC.$default$spliterator((java.util.List) collection) : Spliterators.b(0, collection);
        }
        SortedSet sortedSet = (SortedSet) collection;
        return new o0(sortedSet, sortedSet);
    }

    public static boolean removeIf(Collection collection, Predicate predicate) {
        if (collection instanceof c) {
            return ((c) collection).removeIf(predicate);
        }
        Objects.requireNonNull(predicate);
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static /* synthetic */ Stream stream(Collection collection) {
        return collection instanceof c ? ((c) collection).stream() : StreamSupport.stream(c(collection), false);
    }
}
