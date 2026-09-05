package com.github.catvod.spider.merge.t0;

import java.io.IOException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt___SequencesKt;
import okhttp3.internal.cache.DiskLruCache;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public final Object invoke(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return Boolean.valueOf(SequencesKt___SequencesKt.minus.1.a((Ref.BooleanRef) obj3, obj2, obj));
            default:
                return DiskLruCache.Editor.a((DiskLruCache) obj3, (DiskLruCache.Editor) obj2, (IOException) obj);
        }
    }
}
