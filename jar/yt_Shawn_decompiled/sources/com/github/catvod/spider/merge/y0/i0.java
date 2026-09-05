package com.github.catvod.spider.merge.y0;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i0 {
    public int a;
    public f[] b;

    public final void a(f fVar, int i) {
        while (true) {
            int i2 = i >> 1;
            if (i2 == 0) {
                break;
            }
            f fVar2 = this.b[i2];
            fVar2.getClass();
            if (Intrinsics.compare(0L, fVar.getTimeoutAt$okio() - fVar2.getTimeoutAt$okio()) <= 0) {
                break;
            }
            fVar2.index = i;
            this.b[i] = fVar2;
            i = i2;
        }
        this.b[i] = fVar;
        fVar.index = i;
    }

    public final void b(f fVar) {
        f fVar2;
        int i = fVar.index;
        if (i == -1) {
            com.github.catvod.spider.merge.s0.a.r("Failed requirement.");
            return;
        }
        int i2 = this.a;
        f fVar3 = this.b[i2];
        fVar3.getClass();
        fVar.index = -1;
        this.b[i2] = null;
        this.a = i2 - 1;
        if (fVar == fVar3) {
            return;
        }
        int iCompare = Intrinsics.compare(0L, fVar3.getTimeoutAt$okio() - fVar.getTimeoutAt$okio());
        if (iCompare == 0) {
            this.b[i] = fVar3;
            fVar3.index = i;
            return;
        }
        if (iCompare >= 0) {
            a(fVar3, i);
            return;
        }
        while (true) {
            int i3 = i << 1;
            int i4 = i3 + 1;
            int i5 = this.a;
            if (i4 > i5) {
                if (i3 > i5) {
                    break;
                }
                fVar2 = this.b[i3];
                fVar2.getClass();
            } else {
                fVar2 = this.b[i3];
                fVar2.getClass();
                f fVar4 = this.b[i4];
                fVar4.getClass();
                if (Intrinsics.compare(0L, fVar4.getTimeoutAt$okio() - fVar2.getTimeoutAt$okio()) >= 0) {
                    fVar2 = fVar4;
                }
            }
            if (Intrinsics.compare(0L, fVar2.getTimeoutAt$okio() - fVar3.getTimeoutAt$okio()) <= 0) {
                break;
            }
            int i6 = fVar2.index;
            fVar2.index = i;
            this.b[i] = fVar2;
            i = i6;
        }
        this.b[i] = fVar3;
        fVar3.index = i;
    }
}
