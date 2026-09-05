package com.github.catvod.spider.merge.n0;

import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ int a;

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return CombinedContext.b((String) obj, (CoroutineContext.Element) obj2);
            default:
                return CoroutineContext.DefaultImpls.a((CoroutineContext) obj, (CoroutineContext.Element) obj2);
        }
    }
}
