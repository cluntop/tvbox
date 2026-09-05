package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class j extends i implements java.util.List, List {
    private static final long serialVersionUID = -7754090372962971524L;
    public final java.util.List c;

    public j(java.util.List list) {
        super(list);
        this.c = list;
    }

    private Object readResolve() {
        java.util.List list = this.c;
        return list instanceof RandomAccess ? new l(list) : this;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        synchronized (this.b) {
            this.c.add(i, obj);
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        boolean zAddAll;
        synchronized (this.b) {
            zAddAll = this.c.addAll(i, collection);
        }
        return zAddAll;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        synchronized (this.b) {
            zEquals = this.c.equals(obj);
        }
        return zEquals;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object obj;
        synchronized (this.b) {
            obj = this.c.get(i);
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int iHashCode;
        synchronized (this.b) {
            iHashCode = this.c.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        int iIndexOf;
        synchronized (this.b) {
            iIndexOf = this.c.indexOf(obj);
        }
        return iIndexOf;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int iLastIndexOf;
        synchronized (this.b) {
            iLastIndexOf = this.c.lastIndexOf(obj);
        }
        return iLastIndexOf;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.c.listIterator();
    }

    @Override // java.util.List
    public final Object remove(int i) {
        Object objRemove;
        synchronized (this.b) {
            objRemove = this.c.remove(i);
        }
        return objRemove;
    }

    @Override // java.util.List, com.github.catvod.spider.jdollar.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        synchronized (this.b) {
            java.util.List list = this.c;
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else {
                Objects.requireNonNull(unaryOperator);
                ListIterator listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.set(unaryOperator.apply(listIterator.next()));
                }
            }
        }
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        Object obj2;
        synchronized (this.b) {
            obj2 = this.c.set(i, obj);
        }
        return obj2;
    }

    @Override // java.util.List, com.github.catvod.spider.jdollar.util.List
    public final void sort(java.util.Comparator comparator) {
        synchronized (this.b) {
            List.EL.sort(this.c, comparator);
        }
    }

    @Override // java.util.List
    public java.util.List subList(int i, int i2) {
        j jVar;
        synchronized (this.b) {
            jVar = new j(this.c.subList(i, i2), this.b);
        }
        return jVar;
    }

    public j(java.util.List list, Object obj) {
        super(list, obj);
        this.c = list;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return this.c.listIterator(i);
    }
}
