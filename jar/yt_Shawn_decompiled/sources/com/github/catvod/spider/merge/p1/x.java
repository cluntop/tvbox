package com.github.catvod.spider.merge.p1;

import java.util.ArrayList;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum x extends b0 {
    public x() {
        super("InBody", 6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02af, code lost:
    
        r16 = r3;
        r17 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x035a, code lost:
    
        r32.k(r30);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:772:0x0c74  */
    /* JADX WARN: Removed duplicated region for block: B:838:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:841:0x025d A[SYNTHETIC] */
    @Override // com.github.catvod.spider.merge.p1.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(com.github.catvod.spider.merge.p1.r0 r31, com.github.catvod.spider.merge.p1.b r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.x.d(com.github.catvod.spider.merge.p1.r0, com.github.catvod.spider.merge.p1.b):boolean");
    }

    public final boolean e(r0 r0Var, b bVar) {
        r0Var.getClass();
        String str = ((n0) r0Var).e;
        ArrayList arrayList = bVar.e;
        if (bVar.o(str) == null) {
            bVar.k(this);
            return false;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) arrayList.get(size);
            if (nVar.o(str)) {
                bVar.m(str);
                if (!bVar.i(str)) {
                    bVar.k(this);
                }
                bVar.G(str);
                return true;
            }
            if (b.B(nVar)) {
                bVar.k(this);
                return false;
            }
        }
        return true;
    }
}
