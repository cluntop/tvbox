package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.merge.u.c2;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t implements Iterator {
    public s a;
    public s b;
    public s c;
    public s d;
    public s e;
    public final Class f;

    public t(s sVar, Class cls) {
        c2.R(sVar);
        this.f = cls;
        if (cls.isInstance(sVar)) {
            this.b = sVar;
        }
        this.c = sVar;
        this.d = sVar;
        this.a = sVar;
        this.e = sVar.x();
    }

    public final void a() {
        s sVar;
        if (this.b != null) {
            return;
        }
        if (this.e != null && this.c.a == null) {
            this.c = this.d;
        }
        s sVarX = this.c;
        loop0: while (true) {
            sVar = null;
            if (sVarX.g() > 0) {
                sVarX = sVarX.f(0);
            } else {
                s sVar2 = this.a;
                sVar2.getClass();
                if (sVar2 == sVarX) {
                    sVarX = null;
                } else if (sVarX.q() != null) {
                    sVarX = sVarX.q();
                } else {
                    do {
                        sVarX = sVarX.x();
                        if (sVarX == null) {
                            break loop0;
                        }
                        s sVar3 = this.a;
                        sVar3.getClass();
                        if (sVar3 == sVarX) {
                            break loop0;
                        }
                    } while (sVarX.q() == null);
                    sVarX = sVarX.q();
                }
            }
            if (sVarX == null) {
                break;
            } else if (this.f.isInstance(sVarX)) {
                sVar = sVarX;
                break;
            }
        }
        this.b = sVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        s sVar = this.b;
        if (sVar == null) {
            com.github.catvod.spider.merge.s0.a.a();
            return null;
        }
        this.d = this.c;
        this.c = sVar;
        this.e = sVar.x();
        this.b = null;
        return sVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.c.z();
    }
}
