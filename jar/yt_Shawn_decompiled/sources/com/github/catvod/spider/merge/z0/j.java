package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.r0;
import com.github.catvod.spider.merge.y0.v;
import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j extends v {
    public final long a;
    public final boolean b;
    public long c;

    public j(r0 r0Var, long j, boolean z) {
        super(r0Var);
        this.a = j;
        this.b = z;
    }

    @Override // com.github.catvod.spider.merge.y0.v, com.github.catvod.spider.merge.y0.r0
    public final long read(com.github.catvod.spider.merge.y0.j jVar, long j) throws IOException {
        jVar.getClass();
        long j2 = this.c;
        long j3 = this.a;
        if (j2 > j3) {
            j = 0;
        } else if (this.b) {
            long j4 = j3 - j2;
            if (j4 == 0) {
                return -1L;
            }
            j = Math.min(j, j4);
        }
        long j5 = super.read(jVar, j);
        if (j5 != -1) {
            this.c += j5;
        }
        long j6 = this.c;
        if ((j6 >= j3 || j5 != -1) && j6 <= j3) {
            return j5;
        }
        if (j5 > 0 && j6 > j3) {
            long j7 = jVar.b - (j6 - j3);
            com.github.catvod.spider.merge.y0.j jVar2 = new com.github.catvod.spider.merge.y0.j();
            jVar2.p(jVar);
            jVar.write(jVar2, j7);
            jVar2.j();
        }
        throw new IOException("expected " + j3 + " bytes but got " + this.c);
    }
}
