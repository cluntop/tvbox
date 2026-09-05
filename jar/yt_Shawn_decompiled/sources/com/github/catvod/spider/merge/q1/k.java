package com.github.catvod.spider.merge.q1;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k extends p {
    public final int a;
    public final /* synthetic */ int b;

    public k(int i, int i2) {
        this.b = i2;
        this.a = i;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        int i = this.b;
        int i2 = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (nVar2.K() == i2) {
                }
                break;
            case 1:
                if (nVar2.K() > i2) {
                }
                break;
            default:
                if (nVar == nVar2 || nVar2.K() >= i2) {
                }
                break;
        }
        return false;
    }

    public final String toString() {
        int i = this.b;
        int i2 = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return String.format(":eq(%d)", Integer.valueOf(i2));
            case 1:
                return String.format(":gt(%d)", Integer.valueOf(i2));
            default:
                return String.format(":lt(%d)", Integer.valueOf(i2));
        }
    }
}
