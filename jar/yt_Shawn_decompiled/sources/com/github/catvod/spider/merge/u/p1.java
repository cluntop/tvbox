package com.github.catvod.spider.merge.u;

import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class p1 {
    public static final p1 c = new p1();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final a1 a = new a1();

    public final s1 a(Class cls) {
        z zVar;
        s1 s1VarZ;
        ConcurrentHashMap concurrentHashMap = this.b;
        Object obj = concurrentHashMap.get(cls);
        if (obj != null) {
            return (s1) obj;
        }
        a1 a1Var = this.a;
        a1Var.getClass();
        Class cls2 = t1.a;
        if (!j0.class.isAssignableFrom(cls)) {
            Class cls3 = e.a;
            Class cls4 = t1.a;
            if (cls4 != null && !cls4.isAssignableFrom(cls)) {
                com.github.catvod.spider.merge.s0.a.r("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                return null;
            }
        }
        r1 r1VarA = ((z0) a1Var.a).a(cls);
        if ((r1VarA.d & 2) == 2) {
            Class cls5 = e.a;
            if (j0.class.isAssignableFrom(cls)) {
                s1VarZ = new k1(t1.c, a0.a, r1VarA.a);
            } else {
                w1 w1Var = t1.b;
                z zVar2 = a0.b;
                if (zVar2 == null) {
                    com.github.catvod.spider.merge.s0.a.h("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                s1VarZ = new k1(w1Var, zVar2, r1VarA.a);
            }
        } else {
            Class cls6 = e.a;
            if (j0.class.isAssignableFrom(cls)) {
                l1 l1Var = m1.b;
                w0 w0Var = x0.b;
                w1 w1Var2 = t1.c;
                z zVar3 = o.d(r1VarA.a()) != 1 ? a0.a : null;
                c1 c1Var = d1.b;
                if (!(r1VarA instanceof r1)) {
                    int[] iArr = j1.n;
                    throw new ClassCastException();
                }
                s1VarZ = j1.z(r1VarA, l1Var, w0Var, w1Var2, zVar3, c1Var);
            } else {
                l1 l1Var2 = m1.a;
                w0 w0Var2 = x0.a;
                w1 w1Var3 = t1.b;
                if (o.d(r1VarA.a()) != 1) {
                    z zVar4 = a0.b;
                    if (zVar4 == null) {
                        com.github.catvod.spider.merge.s0.a.h("Protobuf runtime is not correctly loaded.");
                        return null;
                    }
                    zVar = zVar4;
                } else {
                    zVar = null;
                }
                c1 c1Var2 = d1.a;
                if (!(r1VarA instanceof r1)) {
                    int[] iArr2 = j1.n;
                    throw new ClassCastException();
                }
                s1VarZ = j1.z(r1VarA, l1Var2, w0Var2, w1Var3, zVar, c1Var2);
            }
        }
        byte[] bArr = s0.a;
        s1 s1Var = (s1) concurrentHashMap.putIfAbsent(cls, s1VarZ);
        return s1Var != null ? s1Var : s1VarZ;
    }
}
