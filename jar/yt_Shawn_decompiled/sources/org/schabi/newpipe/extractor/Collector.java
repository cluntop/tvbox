package org.schabi.newpipe.extractor;

import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface Collector<I, E> {
    void commit(E e);

    I extract(E e);

    List<Throwable> getErrors();

    List<I> getItems();

    void reset();
}
