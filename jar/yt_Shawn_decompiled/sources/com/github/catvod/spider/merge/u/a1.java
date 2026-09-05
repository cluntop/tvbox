package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a1 {
    public static final d0 b = new d0(1);
    public final Object a;

    public a1() {
        e1 e1Var;
        Class cls = e.a;
        try {
            e1Var = (e1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            e1Var = b;
        }
        e1[] e1VarArr = {d0.b, e1Var};
        z0 z0Var = new z0();
        z0Var.a = e1VarArr;
        byte[] bArr = s0.a;
        this.a = z0Var;
    }

    public void a(int i, Object obj, s1 s1Var) {
        u uVar = (u) this.a;
        uVar.r(i, 3);
        s1Var.h((c) obj, this);
        uVar.r(i, 4);
    }

    public void b(int i, Object obj, s1 s1Var) {
        c cVar = (c) obj;
        u uVar = (u) this.a;
        uVar.r(i, 2);
        uVar.t(cVar.getSerializedSize(s1Var));
        s1Var.h(cVar, this);
    }

    public a1(u uVar) {
        byte[] bArr = s0.a;
        if (uVar != null) {
            this.a = uVar;
            uVar.a = this;
            return;
        }
        throw new NullPointerException("output");
    }
}
