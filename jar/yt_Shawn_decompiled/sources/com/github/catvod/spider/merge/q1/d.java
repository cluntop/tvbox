package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.jdollar.util.Comparator;
import com.github.catvod.spider.jdollar.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d extends p {
    public boolean e;
    public int c = 0;
    public int d = 0;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return this.d;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final void e() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((p) it.next()).e();
        }
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean f() {
        return this.e;
    }

    public final void g() {
        ArrayList arrayList = this.a;
        this.c = arrayList.size();
        this.d = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            this.d = pVar.a() + this.d;
        }
        ArrayList arrayList2 = this.b;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        List.EL.sort(arrayList2, Comparator.CC.comparingInt(new a()));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((p) it2.next()).f()) {
                this.e = true;
                return;
            }
        }
    }
}
