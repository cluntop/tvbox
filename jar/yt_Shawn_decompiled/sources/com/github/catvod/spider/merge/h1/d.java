package com.github.catvod.spider.merge.h1;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class d implements com.github.catvod.spider.merge.a1.c {
    public final BigInteger a;
    public final BigInteger b;
    public final BigInteger c;
    public final e d;

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, e eVar) {
        this.a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
        this.d = eVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.c.equals(this.c) && dVar.b.equals(this.b) && dVar.a.equals(this.a);
    }

    public final int hashCode() {
        return (this.c.hashCode() ^ this.b.hashCode()) ^ this.a.hashCode();
    }
}
