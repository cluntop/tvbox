package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.BaseStream;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable {
    boolean isParallel();

    Iterator<T> iterator();

    BaseStream onClose(Runnable runnable);

    BaseStream parallel();

    BaseStream sequential();

    Spliterator spliterator();

    BaseStream unordered();
}
