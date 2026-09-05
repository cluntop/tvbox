package com.github.catvod.spider.merge.p1;

import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f0 implements Cloneable {
    public final String a;
    public String b;
    public final String c;
    public int d = 0;

    public f0(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.a = str3;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final f0 clone() {
        try {
            return (f0) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean b(int i) {
        return (i & this.d) != 0;
    }

    public final boolean c() {
        return (this.d & 2) != 0;
    }

    public final boolean d() {
        int i = this.d;
        return ((i & 16) == 0 && (i & 2) == 0) ? false : true;
    }

    public final void e(int i) {
        this.d = i | this.d | 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Objects.equals(this.b, f0Var.b) && Objects.equals(this.a, f0Var.a) && Objects.equals(this.c, f0Var.c) && this.d == f0Var.d;
    }

    public final l3 f() {
        if (b(128)) {
            return l3.c;
        }
        if (b(256)) {
            return l3.e;
        }
        return null;
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.a);
    }

    public final String toString() {
        return this.b;
    }
}
