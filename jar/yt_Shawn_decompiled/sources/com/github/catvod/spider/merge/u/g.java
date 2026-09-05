package com.github.catvod.spider.merge.u;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g extends d implements l0, RandomAccess, o1 {
    public static final boolean[] d;
    public static final g e;
    public boolean[] b;
    public int c;

    static {
        boolean[] zArr = new boolean[0];
        d = zArr;
        e = new g(zArr, 0, false);
    }

    public g(boolean[] zArr, int i, boolean z) {
        super(z);
        this.b = zArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
            return;
        }
        boolean[] zArr = this.b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[o.b(zArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, zArr2, 0, i);
            System.arraycopy(this.b, i, zArr2, i + 1, this.c - i);
            this.b = zArr2;
        }
        this.b[i] = zBooleanValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = s0.a;
        collection.getClass();
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i = gVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.b;
        if (i3 > zArr.length) {
            this.b = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(gVar.b, 0, this.b, this.c, gVar.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(boolean z) {
        a();
        int i = this.c;
        boolean[] zArr = this.b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[o.b(zArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, zArr2, 0, this.c);
            this.b = zArr2;
        }
        boolean[] zArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        zArr3[i2] = z;
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
    public final g j(int i) {
        if (i >= this.c) {
            return new g(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.c != gVar.c) {
            return false;
        }
        boolean[] zArr = gVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return Boolean.valueOf(this.b[i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            int i3 = i * 31;
            boolean z = this.b[i2];
            byte[] bArr = s0.a;
            i = i3 + (z ? 1231 : 1237);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        c(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        if (i < this.c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.b;
        System.arraycopy(zArr, i2, zArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        a();
        c(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Boolean) obj).booleanValue());
        return true;
    }
}
