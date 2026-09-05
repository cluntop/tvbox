package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class q2 extends i2 implements f2 {
    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final Object b() {
        long j = this.c;
        if (j >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object objNewArray = newArray((int) j);
        f(0, objNewArray);
        return objNewArray;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final void f(int i, Object obj) {
        g2 g2Var = this.a;
        ((f2) g2Var).f(i, obj);
        ((f2) this.b).f(i + ((int) ((f2) g2Var).count()), obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final void h(Object obj) {
        ((f2) this.a).h(obj);
        ((f2) this.b).h(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ Object[] q(IntFunction intFunction) {
        return v3.m(this, intFunction);
    }

    public final String toString() {
        long j = this.c;
        return j < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.a, this.b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(j));
    }
}
