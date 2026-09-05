package com.github.catvod.spider.merge.y0;

import java.util.RandomAccess;
import kotlin.collections.AbstractList;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f0 extends AbstractList implements RandomAccess {
    public static final /* synthetic */ int c = 0;
    public final m[] a;
    public final int[] b;

    public f0(m[] mVarArr, int[] iArr) {
        this.a = mVarArr;
        this.b = iArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof m) {
            return super/*kotlin.collections.AbstractCollection*/.contains((m) obj);
        }
        return false;
    }

    public final Object get(int i) {
        return this.a[i];
    }

    public final int getSize() {
        return this.a.length;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof m) {
            return super.indexOf((m) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof m) {
            return super.lastIndexOf((m) obj);
        }
        return -1;
    }
}
