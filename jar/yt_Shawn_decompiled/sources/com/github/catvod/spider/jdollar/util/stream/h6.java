package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h6 extends i1 implements y8 {
    public final /* synthetic */ int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h6(a aVar, int i, int i2) {
        super(aVar, i);
        this.m = i2;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 K(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (b7.SORTED.o(aVar.f)) {
                    return aVar.p(spliterator, false, intFunction);
                }
                long[] jArr = (long[]) ((e2) aVar.p(spliterator, true, intFunction)).b();
                Arrays.sort(jArr);
                return new k3(jArr);
            case 1:
                return (g2) new b9(this, aVar, spliterator, intFunction).invoke();
            default:
                return (g2) new a9(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public Spliterator L(a aVar, Spliterator spliterator) {
        switch (this.m) {
            case 1:
                return b7.ORDERED.o(aVar.f) ? K(aVar, spliterator, new t5(5)).spliterator() : new e9((com.github.catvod.spider.jdollar.util.x0) aVar.T(spliterator), 1);
            case 2:
                return b7.ORDERED.o(aVar.f) ? K(aVar, spliterator, new t5(6)).spliterator() : new e9((com.github.catvod.spider.jdollar.util.x0) aVar.T(spliterator), 0);
            default:
                return super.L(aVar, spliterator);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                Objects.requireNonNull(m5Var);
                if (b7.SORTED.o(i)) {
                    return m5Var;
                }
                return b7.SIZED.o(i) ? new m6(m5Var) : new e6(m5Var);
            case 1:
                return new u8(this, m5Var);
            default:
                return new v8(this, m5Var, false);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y8
    public z8 g(y1 y1Var, boolean z) {
        return new v8(this, y1Var, z);
    }
}
