package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.List;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e extends ArrayList implements List {
    public final String a(String str) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) it.next();
            if (nVar.m(str)) {
                return nVar.b(str);
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // java.util.ArrayList
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final e clone() {
        e eVar = new e(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            eVar.add(((com.github.catvod.spider.merge.o1.n) it.next()).h());
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.github.catvod.spider.merge.o1.s c() {
        if (isEmpty()) {
            return null;
        }
        return (com.github.catvod.spider.merge.o1.s) get(0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            ((com.github.catvod.spider.merge.o1.s) it.next()).z();
        }
        super.clear();
    }

    public final String d() {
        return (String) Collection$EL.stream(this).map(new com.github.catvod.spider.merge.n1.g(4)).collect(com.github.catvod.spider.merge.n1.i.k("\n"));
    }

    public final String e() {
        return (String) Collection$EL.stream(this).map(new com.github.catvod.spider.merge.n1.g(6)).collect(com.github.catvod.spider.merge.n1.i.k("\n"));
    }

    public final e f(String str) {
        c2.P(str);
        p pVarH = v.H(str);
        e eVar = new e();
        HashSet hashSet = new HashSet();
        Iterator it = iterator();
        while (it.hasNext()) {
            com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) it.next();
            c2.R(nVar);
            c2.X(pVarH, nVar).filter(new com.github.catvod.spider.merge.e0.a(1, hashSet)).forEach(new w(0, eVar));
        }
        return eVar;
    }

    @Override // java.util.ArrayList, java.lang.Iterable, com.github.catvod.spider.jdollar.util.List, com.github.catvod.spider.jdollar.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public final String g() {
        return (String) Collection$EL.stream(this).map(new com.github.catvod.spider.merge.n1.g(5)).collect(com.github.catvod.spider.merge.n1.i.k(Stream.ID_UNKNOWN));
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        com.github.catvod.spider.merge.o1.s sVar = (com.github.catvod.spider.merge.o1.s) super.remove(iIndexOf);
        sVar.z();
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.ArrayList, java.util.Collection, com.github.catvod.spider.jdollar.util.List, com.github.catvod.spider.jdollar.util.c
    public final boolean removeIf(Predicate predicate) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.test((com.github.catvod.spider.merge.o1.s) it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.List, com.github.catvod.spider.jdollar.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        for (int i = 0; i < size(); i++) {
            com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) ((com.github.catvod.spider.merge.o1.s) unaryOperator.apply((com.github.catvod.spider.merge.o1.s) get(i)));
            c2.R(nVar);
            com.github.catvod.spider.merge.o1.s sVar = (com.github.catvod.spider.merge.o1.s) super.set(i, nVar);
            sVar.B(nVar);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains((com.github.catvod.spider.merge.o1.s) it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) obj;
        c2.R(nVar);
        com.github.catvod.spider.merge.o1.s sVar = (com.github.catvod.spider.merge.o1.s) super.set(i, nVar);
        sVar.B(nVar);
        return (com.github.catvod.spider.merge.o1.n) sVar;
    }

    @Override // java.util.ArrayList, java.util.List, com.github.catvod.spider.jdollar.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.List
    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return e();
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.List, com.github.catvod.spider.jdollar.util.c
    public /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream parallelStream() {
        return StreamSupport.stream(Collection$EL.c(this), true);
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List, com.github.catvod.spider.jdollar.util.List, com.github.catvod.spider.jdollar.lang.Iterable
    public /* synthetic */ com.github.catvod.spider.jdollar.util.Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.List, com.github.catvod.spider.jdollar.util.c
    public /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream stream() {
        return StreamSupport.stream(Collection$EL.c(this), false);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        com.github.catvod.spider.merge.o1.s sVar = (com.github.catvod.spider.merge.o1.s) super.remove(i);
        sVar.z();
        return (com.github.catvod.spider.merge.o1.n) sVar;
    }
}
