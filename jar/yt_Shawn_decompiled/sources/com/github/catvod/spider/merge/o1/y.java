package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y {
    public static final y c;
    public final x a;
    public final x b;

    static {
        x xVar = new x(-1, -1, -1);
        c = new y(xVar, xVar);
    }

    public y(x xVar, x xVar2) {
        this.a = xVar;
        this.b = xVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        if (this.a.equals(yVar.a)) {
            return this.b.equals(yVar.b);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }

    public final String toString() {
        return this.a + "-" + this.b;
    }
}
