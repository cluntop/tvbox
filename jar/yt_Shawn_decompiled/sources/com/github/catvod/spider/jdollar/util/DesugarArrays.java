package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;

/* loaded from: classes.dex */
public final /* synthetic */ class DesugarArrays {
    public static g1 a(Object[] objArr, int i, int i2) {
        Spliterators.a(((Object[]) Objects.requireNonNull(objArr)).length, i, i2);
        return new g1(objArr, i, i2, 1040);
    }

    public static <T> Stream<T> stream(T[] tArr) {
        return StreamSupport.stream(a(tArr, 0, tArr.length), false);
    }
}
