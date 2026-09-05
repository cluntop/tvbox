package com.github.catvod.spider.merge.u;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c0 extends d implements o0, RandomAccess, o1 {
    public static final float[] d;
    public static final c0 e;
    public float[] b;
    public int c;

    static {
        float[] fArr = new float[0];
        d = fArr;
        e = new c0(fArr, 0, false);
    }

    public c0(float[] fArr, int i, boolean z) {
        super(z);
        this.b = fArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            com.github.catvod.spider.merge.s0.a.n(com.github.catvod.spider.merge.b.b.r(i, "Index:", ", Size:"), this.c);
            return;
        }
        float[] fArr = this.b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[o.b(fArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, fArr2, 0, i);
            System.arraycopy(this.b, i, fArr2, i + 1, this.c - i);
            this.b = fArr2;
        }
        this.b[i] = fFloatValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = s0.a;
        collection.getClass();
        if (!(collection instanceof c0)) {
            return super.addAll(collection);
        }
        c0 c0Var = (c0) collection;
        int i = c0Var.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.b;
        if (i3 > fArr.length) {
            this.b = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(c0Var.b, 0, this.b, this.c, c0Var.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(float f) {
        a();
        int i = this.c;
        float[] fArr = this.b;
        if (i == fArr.length) {
            float[] fArr2 = new float[o.b(fArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, fArr2, 0, this.c);
            this.b = fArr2;
        }
        float[] fArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        fArr3[i2] = f;
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
    public final c0 j(int i) {
        if (i >= this.c) {
            return new c0(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return super.equals(obj);
        }
        c0 c0Var = (c0) obj;
        if (this.c != c0Var.c) {
            return false;
        }
        float[] fArr = c0Var.b;
        for (int i = 0; i < this.c; i++) {
            if (Float.floatToIntBits(this.b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return Float.valueOf(this.b[i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.c; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.b[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.github.catvod.spider.merge.u.d, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        c(i);
        float[] fArr = this.b;
        float f = fArr[i];
        if (i < this.c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.b;
        System.arraycopy(fArr, i2, fArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        a();
        c(i);
        float[] fArr = this.b;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Float) obj).floatValue());
        return true;
    }
}
