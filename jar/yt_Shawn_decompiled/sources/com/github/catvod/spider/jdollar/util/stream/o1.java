package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.Predicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o1 extends s1 {
    public final /* synthetic */ t1 c;
    public final /* synthetic */ Predicate d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(t1 t1Var, Predicate predicate) {
        super(t1Var);
        this.c = t1Var;
        this.d = predicate;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (this.a) {
            return;
        }
        boolean zTest = this.d.test(obj);
        t1 t1Var = this.c;
        if (zTest == t1Var.a) {
            this.a = true;
            this.b = t1Var.b;
        }
    }
}
