package com.github.catvod.spider.merge.u;

import org.schabi.newpipe.extractor.stream.StreamExtractor;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y1 extends a2 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y1(Unsafe unsafe, int i) {
        super(unsafe);
        this.b = i;
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final boolean c(Object obj, long j) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (b2.g) {
                    if (b2.h(obj, j) != 0) {
                    }
                } else if (b2.i(obj, j) != 0) {
                }
                break;
            default:
                if (b2.g) {
                    if (b2.h(obj, j) != 0) {
                    }
                } else if (b2.i(obj, j) != 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final byte d(Object obj, long j) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!b2.g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!b2.g) {
                    break;
                } else {
                    break;
                }
        }
        return b2.i(obj, j);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final double e(Object obj, long j) {
        switch (this.b) {
        }
        return Double.longBitsToDouble(h(obj, j));
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final float f(Object obj, long j) {
        switch (this.b) {
        }
        return Float.intBitsToFloat(g(obj, j));
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void k(Object obj, long j, boolean z) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!b2.g) {
                    b2.m(obj, j, z ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    b2.l(obj, j, z ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!b2.g) {
                    b2.m(obj, j, z ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    b2.l(obj, j, z ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void l(Object obj, long j, byte b) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!b2.g) {
                    b2.m(obj, j, b);
                    break;
                } else {
                    b2.l(obj, j, b);
                    break;
                }
            default:
                if (!b2.g) {
                    b2.m(obj, j, b);
                    break;
                } else {
                    b2.l(obj, j, b);
                    break;
                }
        }
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void m(Object obj, long j, double d) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                p(obj, j, Double.doubleToLongBits(d));
                break;
            default:
                p(obj, j, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void n(Object obj, long j, float f) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                o(Float.floatToIntBits(f), j, obj);
                break;
            default:
                o(Float.floatToIntBits(f), j, obj);
                break;
        }
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final boolean s() {
        switch (this.b) {
        }
        return false;
    }
}
