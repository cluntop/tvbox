package com.github.catvod.spider.merge.n1;

import java.util.WeakHashMap;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c extends ThreadLocal {
    public final /* synthetic */ int a;
    public final /* synthetic */ Supplier b;

    public /* synthetic */ c(Supplier supplier, int i) {
        this.a = i;
        this.b = supplier;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        int i = this.a;
        b bVar = (b) this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return bVar.get();
            case 1:
                bVar.getClass();
                return new char[2];
            default:
                bVar.getClass();
                return new WeakHashMap();
        }
    }
}
