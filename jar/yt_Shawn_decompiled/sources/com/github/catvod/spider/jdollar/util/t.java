package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t extends w {
    private static final long serialVersionUID = 7854390611657943733L;

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return this.a.contains(new r((Map.Entry) obj));
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.w, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != this.a.size()) {
            return false;
        }
        return containsAll(set);
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        Collection$EL.a(this.a, new com.github.catvod.spider.jdollar.nio.file.w(consumer, 2));
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new n(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final Stream parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final Spliterator spliterator() {
        return new s(Collection$EL.c(this.a));
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final Stream stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array = this.a.toArray(objArr.length == 0 ? objArr : Arrays.copyOf(objArr, 0));
        for (int i = 0; i < array.length; i++) {
            array[i] = new r((Map.Entry) array[i]);
        }
        if (array.length > objArr.length) {
            return array;
        }
        System.arraycopy(array, 0, objArr, 0, array.length);
        if (objArr.length > array.length) {
            objArr[array.length] = null;
        }
        return objArr;
    }

    @Override // com.github.catvod.spider.jdollar.util.o, java.util.Collection
    public final Object[] toArray() {
        Object[] array = this.a.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = new r((Map.Entry) array[i]);
        }
        return array;
    }
}
