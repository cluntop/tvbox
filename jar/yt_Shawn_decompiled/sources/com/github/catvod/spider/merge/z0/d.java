package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.g0;
import com.github.catvod.spider.merge.y0.s;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d extends RestrictedSuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ s c;
    public final /* synthetic */ g0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(s sVar, g0 g0Var, Continuation continuation) {
        super(2, continuation);
        this.c = sVar;
        this.d = g0Var;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        d dVar = new d(this.c, this.d, continuation);
        dVar.b = obj;
        return dVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return create((SequenceScope) obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope = (SequenceScope) this.b;
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = 1;
            if (b.c(sequenceScope, this.c, arrayDeque, this.d, false, true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                com.github.catvod.spider.merge.s0.a.h("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
