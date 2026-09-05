package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.g0;
import com.github.catvod.spider.merge.y0.s;
import java.util.Iterator;
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
public final class e extends RestrictedSuspendLambda implements Function2 {
    public ArrayDeque a;
    public Iterator b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ g0 e;
    public final /* synthetic */ s f;
    public final /* synthetic */ boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g0 g0Var, s sVar, boolean z, Continuation continuation) {
        super(2, continuation);
        this.e = g0Var;
        this.f = sVar;
        this.g = z;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        e eVar = new e(this.e, this.f, this.g, continuation);
        eVar.d = obj;
        return eVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return create((SequenceScope) obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ArrayDeque arrayDeque;
        Iterator it;
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        s sVar = this.f;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.d;
            ArrayDeque arrayDeque2 = new ArrayDeque();
            g0 g0Var = this.e;
            arrayDeque2.addLast(g0Var);
            arrayDeque = arrayDeque2;
            it = sVar.list(g0Var).iterator();
            sequenceScope = sequenceScope2;
        } else {
            if (i != 1) {
                com.github.catvod.spider.merge.s0.a.h("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            it = this.b;
            ArrayDeque arrayDeque3 = this.a;
            SequenceScope sequenceScope3 = (SequenceScope) this.d;
            ResultKt.throwOnFailure(obj);
            arrayDeque = arrayDeque3;
            sequenceScope = sequenceScope3;
        }
        while (it.hasNext()) {
            g0 g0Var2 = (g0) it.next();
            this.d = sequenceScope;
            this.a = arrayDeque;
            this.b = it;
            this.c = 1;
            if (b.c(sequenceScope, sVar, arrayDeque, g0Var2, this.g, false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
