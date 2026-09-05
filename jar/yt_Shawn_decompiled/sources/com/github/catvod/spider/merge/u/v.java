package com.github.catvod.spider.merge.u;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v extends d implements m0, RandomAccess, o1 {
    public static final double[] d;
    public static final v e;
    public double[] b;
    public int c;

    static {
        double[] dArr = new double[0];
        d = dArr;
        e = new v(dArr, 0, false);
    }

    public v(double[] dArr, int i, boolean z) {
        super(z);
        this.b = dArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
            return;
        }
        double[] dArr = this.b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[o.b(dArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, dArr2, 0, i);
            System.arraycopy(this.b, i, dArr2, i + 1, this.c - i);
            this.b = dArr2;
        }
        this.b[i] = dDoubleValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = s0.a;
        collection.getClass();
        if (!(collection instanceof v)) {
            return super.addAll(collection);
        }
        v vVar = (v) collection;
        int i = vVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.b;
        if (i3 > dArr.length) {
            this.b = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(vVar.b, 0, this.b, this.c, vVar.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(double d2) {
        a();
        int i = this.c;
        double[] dArr = this.b;
        if (i == dArr.length) {
            double[] dArr2 = new double[o.b(dArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, dArr2, 0, this.c);
            this.b = dArr2;
        }
        double[] dArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        dArr3[i2] = d2;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.c) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.github.catvod.spider.merge.u.r0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final v j(int i) {
        if (i >= this.c) {
            return new v(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return super.equals(obj);
        }
        v vVar = (v) obj;
        if (this.c != vVar.c) {
            return false;
        }
        double[] dArr = vVar.b;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return Double.valueOf(this.b[i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.c; i++) {
            iA = (iA * 31) + s0.a(Double.doubleToLongBits(this.b[i]));
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        c(i);
        double[] dArr = this.b;
        double d2 = dArr[i];
        if (i < this.c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.b;
        System.arraycopy(dArr, i2, dArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        a();
        c(i);
        double[] dArr = this.b;
        double d2 = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Double) obj).doubleValue());
        return true;
    }
}
