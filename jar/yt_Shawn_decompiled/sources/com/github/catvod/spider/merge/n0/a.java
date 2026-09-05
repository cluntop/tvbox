package com.github.catvod.spider.merge.n0;

import kotlin.Unit;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ CoroutineContext[] a;
    public final /* synthetic */ Ref.IntRef b;

    public /* synthetic */ a(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        this.a = coroutineContextArr;
        this.b = intRef;
    }

    public final Object invoke(Object obj, Object obj2) {
        return CombinedContext.a(this.a, this.b, (Unit) obj, (CoroutineContext.Element) obj2);
    }
}
