package com.github.catvod.spider.merge.u;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k extends j {
    public final byte[] d;

    public k(byte[] bArr) {
        bArr.getClass();
        this.d = bArr;
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final void f(byte[] bArr, int i) {
        System.arraycopy(this.d, 0, bArr, 0, i);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final boolean g(l lVar) {
        boolean z = lVar instanceof k;
        byte[] bArr = this.d;
        if (z) {
            return Arrays.equals(bArr, ((k) lVar).d);
        }
        if (!(lVar instanceof i)) {
            return lVar.g(this);
        }
        int length = bArr.length;
        i iVar = (i) lVar;
        int i = iVar.f;
        if (length > i) {
            throw new IllegalArgumentException("Length too large: " + length + bArr.length);
        }
        if (length > i) {
            com.github.catvod.spider.merge.b0.a.b("Ran off end of other: 0, ", length, i, ", ");
            return false;
        }
        if (lVar instanceof k) {
            return l.a(bArr, 0, 0, ((k) lVar).d, length);
        }
        return l.a(bArr, 0, iVar.e, iVar.d, length);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final byte h(int i) {
        return this.d[i];
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final boolean i() {
        c2 c2Var = e2.a;
        byte[] bArr = this.d;
        return c2Var.J(bArr, 0, bArr.length);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final m k() {
        byte[] bArr = this.d;
        return p.f(bArr, 0, bArr.length, true);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final int l(int i, int i2) {
        return s0.b(this.d, i, 0, i2);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final j m(int i, int i2) {
        byte[] bArr = this.d;
        int iB = l.b(0, i2, bArr.length);
        return iB == 0 ? l.b : new i(bArr, 0, iB);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final String n() {
        return new String(this.d, StandardCharsets.UTF_8);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final void p(u uVar) {
        byte[] bArr = this.d;
        uVar.p(bArr, 0, bArr.length);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final int size() {
        return this.d.length;
    }
}
