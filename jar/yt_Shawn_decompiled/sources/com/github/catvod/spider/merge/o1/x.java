package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x {
    public final int a;
    public final int b;
    public final int c;

    public x(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && x.class == obj.getClass()) {
            x xVar = (x) obj;
            if (this.a == xVar.a && this.b == xVar.b && this.c == xVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public final String toString() {
        return this.b + "," + this.c + ":" + this.a;
    }
}
