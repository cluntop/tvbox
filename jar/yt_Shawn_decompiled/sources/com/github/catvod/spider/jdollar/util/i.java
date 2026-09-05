package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class i implements Collection, Serializable, c {
    private static final long serialVersionUID = 3053995032091335093L;
    public final Collection a;
    public final Object b;

    public i(Collection collection, Object obj) {
        this.a = (Collection) Objects.requireNonNull(collection);
        this.b = Objects.requireNonNull(obj);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.b) {
            objectOutputStream.defaultWriteObject();
        }
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        boolean zAdd;
        synchronized (this.b) {
            zAdd = this.a.add(obj);
        }
        return zAdd;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean zAddAll;
        synchronized (this.b) {
            zAddAll = this.a.addAll(collection);
        }
        return zAddAll;
    }

    @Override // java.util.Collection
    public final void clear() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        boolean zContains;
        synchronized (this.b) {
            zContains = this.a.contains(obj);
        }
        return zContains;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        boolean zContainsAll;
        synchronized (this.b) {
            zContainsAll = this.a.containsAll(collection);
        }
        return zContainsAll;
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        synchronized (this.b) {
            Collection$EL.a(this.a, consumer);
        }
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.b) {
            zIsEmpty = this.a.isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.a.iterator();
    }

    @Override // java.util.Collection
    public final Stream parallelStream() {
        return Stream.Wrapper.convert(Collection$EL.b(this.a));
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this.b) {
            zRemove = this.a.remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        boolean zRemoveAll;
        synchronized (this.b) {
            zRemoveAll = this.a.removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final boolean removeIf(Predicate predicate) {
        boolean zRemoveIf;
        synchronized (this.b) {
            zRemoveIf = Collection$EL.removeIf(this.a, predicate);
        }
        return zRemoveIf;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        boolean zRetainAll;
        synchronized (this.b) {
            zRetainAll = this.a.retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Collection
    public final int size() {
        int size;
        synchronized (this.b) {
            size = this.a.size();
        }
        return size;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(Collection$EL.c(this.a));
    }

    @Override // java.util.Collection
    public final java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(Collection$EL.stream(this.a));
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] array;
        synchronized (this.b) {
            array = this.a.toArray();
        }
        return array;
    }

    public final String toString() {
        String string;
        synchronized (this.b) {
            string = this.a.toString();
        }
        return string;
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final com.github.catvod.spider.jdollar.util.stream.Stream parallelStream() {
        return Collection$EL.b(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final Spliterator spliterator() {
        return Collection$EL.c(this.a);
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final com.github.catvod.spider.jdollar.util.stream.Stream stream() {
        return Collection$EL.stream(this.a);
    }

    @Override // java.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.b) {
            array = this.a.toArray(objArr);
        }
        return array;
    }

    public i(Collection collection) {
        this.a = (Collection) Objects.requireNonNull(collection);
        this.b = this;
    }
}
