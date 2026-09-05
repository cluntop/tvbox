package com.github.catvod.spider.jdollar.util.stream;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s extends z {
    public final /* synthetic */ int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(a aVar, int i, int i2) {
        super(aVar, i);
        this.m = i2;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new r(this, m5Var, 0);
            case 1:
                return m5Var;
            case 2:
                return new r(this, m5Var, 3);
            case 3:
                return new v0(1, m5Var);
            case 4:
                return new v0(this, m5Var, 3);
            case 5:
                return new e1(m5Var);
            default:
                return new e1(this, m5Var, 3);
        }
    }
}
