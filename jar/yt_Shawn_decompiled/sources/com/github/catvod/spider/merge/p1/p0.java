package com.github.catvod.spider.merge.p1;

import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p0 extends r0 {
    public final com.github.catvod.spider.merge.g1.b d;
    public String e;
    public boolean f;
    public com.github.catvod.spider.merge.o1.c g;
    public final com.github.catvod.spider.merge.g1.b h;
    public final com.github.catvod.spider.merge.g1.b i;
    public boolean j;

    public p0(int i, b bVar) {
        super(i);
        this.d = new com.github.catvod.spider.merge.g1.b(7, false);
        this.f = false;
        int i2 = 7;
        boolean z = false;
        this.h = new com.github.catvod.spider.merge.g1.b(i2, z);
        this.i = new com.github.catvod.spider.merge.g1.b(i2, z);
        this.j = false;
        bVar.getClass();
    }

    public final void g(int i, int i2, char c) {
        this.i.a(c);
    }

    public final void h(int[] iArr, int i, int i2) {
        for (int i3 : iArr) {
            com.github.catvod.spider.merge.g1.b bVar = this.i;
            StringBuilder sb = (StringBuilder) bVar.c;
            if (sb != null) {
                sb.appendCodePoint(i3);
            } else if (((String) bVar.b) != null) {
                StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
                bVar.c = sbB;
                sbB.append((String) bVar.b);
                bVar.b = null;
                ((StringBuilder) bVar.c).appendCodePoint(i3);
            } else {
                bVar.b = String.valueOf(Character.toChars(i3));
            }
        }
    }

    public final void i(String str) {
        String strReplace = str.replace((char) 0, (char) 65533);
        com.github.catvod.spider.merge.g1.b bVar = this.d;
        bVar.b(strReplace);
        this.e = com.github.catvod.spider.merge.n1.a.d(bVar.j());
    }

    public final void j(String str) {
        com.github.catvod.spider.merge.g1.b bVar = this.d;
        bVar.i();
        bVar.b = str;
        this.e = com.github.catvod.spider.merge.n1.a.d(bVar.j());
    }

    public final void k() {
        if (this.g == null) {
            this.g = new com.github.catvod.spider.merge.o1.c();
        }
        com.github.catvod.spider.merge.g1.b bVar = this.h;
        boolean zF = bVar.f();
        com.github.catvod.spider.merge.g1.b bVar2 = this.i;
        if (zF && this.g.size() < 512) {
            String strTrim = bVar.j().trim();
            if (!strTrim.isEmpty()) {
                this.g.a(strTrim, bVar2.f() ? bVar2.j() : this.j ? VideoStream.RESOLUTION_UNKNOWN : null);
            }
        }
        bVar.i();
        bVar2.i();
        this.j = false;
    }

    public final String l() {
        String str = this.e;
        if (str == null || str.isEmpty()) {
            throw new com.github.catvod.spider.merge.m1.g("Must be false");
        }
        return this.e;
    }

    @Override // com.github.catvod.spider.merge.p1.r0
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public p0 f() {
        this.b = -1;
        this.c = -1;
        this.d.i();
        this.e = null;
        this.f = false;
        this.g = null;
        this.h.i();
        this.i.i();
        this.j = false;
        return this;
    }

    public final String n() {
        String strJ = this.d.j();
        return strJ.isEmpty() ? "[unset]" : strJ;
    }
}
