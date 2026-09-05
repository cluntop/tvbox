package com.github.catvod.spider.jdollar.util;

import java.util.Collection;
import java.util.SortedSet;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o0 extends n1 {
    public final /* synthetic */ SortedSet f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(SortedSet sortedSet, Collection collection) {
        super(21, collection);
        this.f = sortedSet;
    }

    @Override // com.github.catvod.spider.jdollar.util.n1, com.github.catvod.spider.jdollar.util.Spliterator
    public final java.util.Comparator getComparator() {
        return this.f.comparator();
    }
}
