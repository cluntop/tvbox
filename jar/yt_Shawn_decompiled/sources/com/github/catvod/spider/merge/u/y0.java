package com.github.catvod.spider.merge.u;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y0 extends d implements q0, RandomAccess, o1 {
    public static final long[] d;
    public static final y0 e;
    public long[] b;
    public int c;

    static {
        long[] jArr = new long[0];
        d = jArr;
        e = new y0(jArr, 0, false);
    }

    public y0(long[] jArr, int i, boolean z) {
        super(z);
        this.b = jArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
            return;
        }
        long[] jArr = this.b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[o.b(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, jArr2, 0, i);
            System.arraycopy(this.b, i, jArr2, i + 1, this.c - i);
            this.b = jArr2;
        }
        this.b[i] = jLongValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = s0.a;
        collection.getClass();
        if (!(collection instanceof y0)) {
            return super.addAll(collection);
        }
        y0 y0Var = (y0) collection;
        int i = y0Var.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.b;
        if (i3 > jArr.length) {
            this.b = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(y0Var.b, 0, this.b, this.c, y0Var.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(long j) {
        a();
        int i = this.c;
        long[] jArr = this.b;
        if (i == jArr.length) {
            long[] jArr2 = new long[o.b(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, jArr2, 0, this.c);
            this.b = jArr2;
        }
        long[] jArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        jArr3[i2] = j;
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

    public final long d(int i) {
        c(i);
        return this.b[i];
    }

    @Override // com.github.catvod.spider.merge.u.r0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final y0 j(int i) {
        if (i >= this.c) {
            return new y0(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return super.equals(obj);
        }
        y0 y0Var = (y0) obj;
        if (this.c != y0Var.c) {
            return false;
        }
        long[] jArr = y0Var.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Long.valueOf(d(i));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.c; i++) {
            iA = (iA * 31) + s0.a(this.b[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        c(i);
        long[] jArr = this.b;
        long j = jArr[i];
        if (i < this.c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.b;
        System.arraycopy(jArr, i2, jArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        a();
        c(i);
        long[] jArr = this.b;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Long) obj).longValue());
        return true;
    }
}
