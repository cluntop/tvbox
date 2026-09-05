package com.github.catvod.spider.merge.u;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i extends j {
    public final byte[] d;
    public final int e;
    public final int f;

    public i(byte[] bArr, int i, int i2) {
        l.b(i, i + i2, bArr.length);
        this.d = bArr;
        this.e = i;
        this.f = i2;
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final void f(byte[] bArr, int i) {
        System.arraycopy(this.d, this.e, bArr, 0, i);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final boolean g(l lVar) {
        if (!(lVar instanceof k) && !(lVar instanceof i)) {
            return lVar.g(this);
        }
        int size = lVar.size();
        int i = this.f;
        if (i > size) {
            throw new IllegalArgumentException("Length too large: " + i + i);
        }
        if (i > lVar.size()) {
            StringBuilder sbR = com.github.catvod.spider.merge.b.b.r(i, "Ran off end of other: 0, ", ", ");
            sbR.append(lVar.size());
            throw new IllegalArgumentException(sbR.toString());
        }
        boolean z = lVar instanceof k;
        byte[] bArr = this.d;
        int i2 = this.e;
        if (z) {
            return l.a(bArr, i2, 0, ((k) lVar).d, i);
        }
        if (!(lVar instanceof i)) {
            return lVar.m(0, i).equals(m(i2, i + i2));
        }
        i iVar = (i) lVar;
        return l.a(bArr, i2, iVar.e, iVar.d, i);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final byte h(int i) {
        return this.d[this.e + i];
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final boolean i() {
        int i = this.f;
        int i2 = this.e;
        return e2.a.J(this.d, i2, i + i2);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final m k() {
        return p.f(this.d, this.e, this.f, true);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final int l(int i, int i2) {
        return s0.b(this.d, i, this.e, i2);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final j m(int i, int i2) {
        int iB = l.b(i, i2, this.f);
        if (iB == 0) {
            return l.b;
        }
        return new i(this.d, this.e + i, iB);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final String n() {
        Charset charset = StandardCharsets.UTF_8;
        return new String(this.d, this.e, this.f, charset);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final void p(u uVar) {
        uVar.p(this.d, this.e, this.f);
    }

    @Override // com.github.catvod.spider.merge.u.l
    public final int size() {
        return this.f;
    }
}
