package com.github.catvod.spider.jdollar.util.stream;

import java.util.Comparator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b6 extends i5 {
    public final Comparator b;
    public boolean c;

    public b6(m5 m5Var, Comparator comparator) {
        super(m5Var);
        this.b = comparator;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        this.c = true;
        return false;
    }
}
