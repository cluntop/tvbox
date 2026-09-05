package com.github.catvod.spider.jdollar.util;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c0 {
    public static final c0 c = new c0();
    public final boolean a;
    public final int b;

    public c0() {
        this.a = false;
        this.b = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        boolean z = c0Var.a;
        boolean z2 = this.a;
        return (z2 && z) ? this.b == c0Var.b : z2 == z;
    }

    public final int hashCode() {
        if (this.a) {
            return this.b;
        }
        return 0;
    }

    public final String toString() {
        if (!this.a) {
            return "OptionalInt.empty";
        }
        return "OptionalInt[" + this.b + "]";
    }

    public c0(int i) {
        this.a = true;
        this.b = i;
    }
}
