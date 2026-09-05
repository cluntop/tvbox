package com.github.catvod.spider.merge.u;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q1 extends d implements RandomAccess {
    public static final Object[] d;
    public static final q1 e;
    public Object[] b;
    public int c;

    static {
        Object[] objArr = new Object[0];
        d = objArr;
        e = new q1(objArr, 0, false);
    }

    public q1(Object[] objArr, int i, boolean z) {
        super(z);
        this.b = objArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
            return;
        }
        Object[] objArr = this.b;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[o.b(objArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, objArr2, 0, i);
            System.arraycopy(this.b, i, objArr2, i + 1, this.c - i);
            this.b = objArr2;
        }
        this.b[i] = obj;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.c) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
        }
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
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
        int i = this.c;
        if (i != list.size()) {
            return false;
        }
        if (!(obj instanceof q1)) {
            for (int i2 = 0; i2 < i; i2++) {
                if (!this.b[i2].equals(list.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        q1 q1Var = (q1) obj;
        for (int i3 = 0; i3 < i; i3++) {
            if (!this.b[i3].equals(q1Var.b[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = this.c;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode = (iHashCode * 31) + this.b[i2].hashCode();
        }
        return iHashCode;
    }

    @Override // com.github.catvod.spider.merge.u.r0
    public final r0 j(int i) {
        if (i >= this.c) {
            return new q1(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i < this.c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.c;
        Object[] objArr = this.b;
        if (i == objArr.length) {
            this.b = Arrays.copyOf(this.b, o.b(objArr.length, 3, 2, 1, 10));
        }
        Object[] objArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
