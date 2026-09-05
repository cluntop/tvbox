package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class z extends u {
    public final MessageDigest a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(g gVar) throws NoSuchAlgorithmException {
        super(gVar);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.getClass();
        this.a = messageDigest;
    }

    @Override // com.github.catvod.spider.merge.y0.u, com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) {
        jVar.getClass();
        c2.g(jVar.b, 0L, j);
        m0 m0Var = jVar.a;
        m0Var.getClass();
        long j2 = 0;
        while (j2 < j) {
            int iMin = (int) Math.min(j - j2, m0Var.c - m0Var.b);
            MessageDigest messageDigest = this.a;
            messageDigest.getClass();
            messageDigest.update(m0Var.a, m0Var.b, iMin);
            j2 += iMin;
            m0Var = m0Var.f;
            m0Var.getClass();
        }
        super.write(jVar, j);
    }
}
