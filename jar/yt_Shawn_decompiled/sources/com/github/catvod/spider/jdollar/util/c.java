package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.util.function.Predicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface c extends Iterable {
    Stream parallelStream();

    boolean removeIf(Predicate predicate);

    Stream stream();
}
