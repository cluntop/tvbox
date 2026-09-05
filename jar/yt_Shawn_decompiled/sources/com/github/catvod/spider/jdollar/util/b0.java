package com.github.catvod.spider.jdollar.util;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b0 {
    public static final b0 c = new b0();
    public final boolean a;
    public final double b;

    public b0() {
        this.a = false;
        this.b = Double.NaN;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        boolean z = b0Var.a;
        boolean z2 = this.a;
        return (z2 && z) ? Double.compare(this.b, b0Var.b) == 0 : z2 == z;
    }

    public final int hashCode() {
        if (!this.a) {
            return 0;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(this.b);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final String toString() {
        if (!this.a) {
            return "OptionalDouble.empty";
        }
        return "OptionalDouble[" + this.b + "]";
    }

    public b0(double d) {
        this.a = true;
        this.b = d;
    }
}
