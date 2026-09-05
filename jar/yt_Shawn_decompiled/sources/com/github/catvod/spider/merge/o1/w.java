package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w {
    public static final /* synthetic */ int c = 0;
    public final y a;
    public final y b;

    public w(y yVar, y yVar2) {
        this.a = yVar;
        this.b = yVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        if (this.a.equals(wVar.a)) {
            return this.b.equals(wVar.b);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }

    public final String toString() {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        sbB.append(this.a);
        sbB.append('=');
        sbB.append(this.b);
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }
}
