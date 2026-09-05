package com.github.catvod.spider.merge.w0;

import kotlin.jvm.functions.Function1;
import kotlin.time.InstantKt;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ int a;

    public final Object invoke(Object obj) {
        boolean zB;
        int i = this.a;
        char cCharValue = ((Character) obj).charValue();
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                zB = InstantKt.b(cCharValue);
                break;
            case 1:
                zB = InstantKt.e(cCharValue);
                break;
            case 2:
                zB = InstantKt.c(cCharValue);
                break;
            case 3:
                zB = InstantKt.a(cCharValue);
                break;
            case 4:
                zB = InstantKt.f(cCharValue);
                break;
            default:
                zB = InstantKt.d(cCharValue);
                break;
        }
        return Boolean.valueOf(zB);
    }
}
