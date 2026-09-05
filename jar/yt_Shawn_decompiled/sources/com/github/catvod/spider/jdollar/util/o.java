package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class o implements Collection, Serializable, c {
    private static final long serialVersionUID = 1820017752578914078L;
    public final Collection a;

    public o(Collection collection) {
        collection.getClass();
        this.a = collection;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public void forEach(Consumer consumer) {
        Collection$EL.a(this.a, consumer);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new n(this);
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection
    public final /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.a.toArray();
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // java.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.a.toArray(objArr);
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public com.github.catvod.spider.jdollar.util.stream.Stream parallelStream() {
        return Collection$EL.b(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public Spliterator spliterator() {
        return Collection$EL.c(this.a);
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public com.github.catvod.spider.jdollar.util.stream.Stream stream() {
        return Collection$EL.stream(this.a);
    }
}
