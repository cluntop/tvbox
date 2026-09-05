package com.github.catvod.spider.merge.o1;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g implements Cloneable {
    public o a = o.base;
    public Charset b = com.github.catvod.spider.merge.m1.a.a;
    public final boolean c = true;
    public final int d = 1;
    public final int e = 30;
    public final int f = 1;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final g clone() {
        try {
            g gVar = (g) super.clone();
            String strName = this.b.name();
            gVar.getClass();
            gVar.b = Charset.forName(strName);
            gVar.a = (o) Enum.valueOf(o.class, this.a.name());
            return gVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
