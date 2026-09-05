package com.github.catvod.spider.merge.p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e0 implements Cloneable {
    public final b a;
    public final c0 b;
    public final d0 c;
    public h0 d;
    public final int e;

    public e0(e0 e0Var) {
        new ReentrantLock();
        e0Var.a.getClass();
        this.a = new b();
        e0Var.b.getClass();
        this.b = new c0(0);
        d0 d0Var = e0Var.c;
        this.c = new d0(d0Var.a, d0Var.b);
        this.e = e0Var.e;
        h0 h0VarA = e0Var.a();
        h0 h0Var = h0VarA.b;
        HashMap map = h0VarA.a;
        ArrayList arrayList = h0VarA.c;
        h0 h0Var2 = new h0(h0Var, arrayList == null ? null : new ArrayList(arrayList));
        if (!map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                HashMap map2 = new HashMap(((Map) entry.getValue()).size());
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    map2.put((String) entry2.getKey(), ((f0) entry2.getValue()).clone());
                }
                h0Var2.a.put((String) entry.getKey(), map2);
            }
        }
        this.d = h0Var2;
    }

    public final h0 a() {
        if (this.d == null) {
            this.a.getClass();
            this.d = new h0(h0.d, null);
        }
        return this.d;
    }

    public final Object clone() {
        return new e0(this);
    }

    public e0(b bVar) {
        new ReentrantLock();
        this.a = bVar;
        this.c = d0.c;
        this.b = new c0(0);
        this.e = 512;
    }
}
