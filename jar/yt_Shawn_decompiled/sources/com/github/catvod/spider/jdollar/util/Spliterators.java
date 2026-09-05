package com.github.catvod.spider.jdollar.util;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Spliterators {
    public static final l1 a = new l1();
    public static final j1 b = new j1();
    public static final k1 c = new k1();
    public static final i1 d = new i1();

    public static void a(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i2 + ") > fence(" + i3 + ")");
    }

    public static n1 b(int i, Collection collection) {
        return new n1(i, (Collection) Objects.requireNonNull(collection));
    }

    public static <T> Spliterator<T> spliteratorUnknownSize(Iterator<? extends T> it, int i) {
        return new n1((Iterator) Objects.requireNonNull(it), i);
    }
}
