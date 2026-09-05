package com.github.catvod.spider.jdollar.util;

import java.io.Serializable;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements java.util.Comparator, Serializable {
    public final /* synthetic */ int a;
    public final /* synthetic */ java.util.Comparator b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(java.util.Comparator comparator, Object obj, int i) {
        this.a = i;
        this.b = comparator;
        this.c = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                java.util.Comparator comparator = this.b;
                java.util.Comparator comparator2 = (java.util.Comparator) this.c;
                int iCompare = comparator.compare(obj, obj2);
                return iCompare != 0 ? iCompare : comparator2.compare(obj, obj2);
            default:
                java.util.Comparator comparator3 = this.b;
                Function function = (Function) this.c;
                return comparator3.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
