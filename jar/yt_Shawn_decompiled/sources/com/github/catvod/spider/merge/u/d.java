package com.github.catvod.spider.merge.u;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d extends AbstractList implements r0 {
    public boolean a;

    public d(boolean z) {
        this.a = z;
    }

    public final void a() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract Object remove(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        a();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        a();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        a();
        return super.addAll(i, collection);
    }
}
