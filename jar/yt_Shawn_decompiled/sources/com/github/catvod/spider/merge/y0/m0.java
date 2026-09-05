package com.github.catvod.spider.merge.y0;

import kotlin.collections.ArraysKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m0 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public m0 f;
    public m0 g;

    public m0(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        bArr.getClass();
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final m0 a() {
        m0 m0Var = this.f;
        if (m0Var == this) {
            m0Var = null;
        }
        m0 m0Var2 = this.g;
        m0Var2.getClass();
        m0Var2.f = this.f;
        m0 m0Var3 = this.f;
        m0Var3.getClass();
        m0Var3.g = this.g;
        this.f = null;
        this.g = null;
        return m0Var;
    }

    public final void b(m0 m0Var) {
        m0Var.getClass();
        m0Var.g = this;
        m0Var.f = this.f;
        m0 m0Var2 = this.f;
        m0Var2.getClass();
        m0Var2.g = m0Var;
        this.f = m0Var;
    }

    public final m0 c() {
        this.d = true;
        return new m0(this.a, this.b, this.c, true, false);
    }

    public final void d(m0 m0Var, int i) {
        m0Var.getClass();
        byte[] bArr = m0Var.a;
        if (!m0Var.e) {
            com.github.catvod.spider.merge.s0.a.h("only owner can write");
            return;
        }
        int i2 = m0Var.c;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (m0Var.d) {
                throw new IllegalArgumentException();
            }
            int i4 = m0Var.b;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt.n(i4, i2, bArr, bArr);
            m0Var.c -= m0Var.b;
            m0Var.b = 0;
        }
        int i5 = m0Var.c;
        int i6 = this.b;
        ArraysKt.copyInto(this.a, bArr, i5, i6, i6 + i);
        m0Var.c += i;
        this.b += i;
    }

    public m0() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }
}
