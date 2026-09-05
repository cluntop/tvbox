package com.github.catvod.spider.merge.h1;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class c implements com.github.catvod.spider.merge.a1.c {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        BigInteger bigInteger = this.c;
        BigInteger bigInteger2 = cVar.c;
        if (bigInteger != null) {
            if (!bigInteger.equals(bigInteger2)) {
                return false;
            }
        } else if (bigInteger2 != null) {
            return false;
        }
        return cVar.b.equals(this.b) && cVar.a.equals(this.a);
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() ^ this.a.hashCode();
        BigInteger bigInteger = this.c;
        return iHashCode ^ (bigInteger != null ? bigInteger.hashCode() : 0);
    }
}
