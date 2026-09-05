package com.github.catvod.spider.jdollar.util.function;

import java.util.function.IntUnaryOperator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements IntUnaryOperator {
    public final /* synthetic */ int a;
    public final /* synthetic */ IntUnaryOperator b;
    public final /* synthetic */ IntUnaryOperator c;

    public /* synthetic */ e(IntUnaryOperator intUnaryOperator, IntUnaryOperator intUnaryOperator2, int i) {
        this.a = i;
        this.b = intUnaryOperator;
        this.c = intUnaryOperator2;
    }

    @Override // java.util.function.IntUnaryOperator
    public final /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        switch (this.a) {
        }
        return IntUnaryOperator$CC.$default$andThen(this, intUnaryOperator);
    }

    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return this.c.applyAsInt(this.b.applyAsInt(i));
            default:
                return this.b.applyAsInt(this.c.applyAsInt(i));
        }
    }

    @Override // java.util.function.IntUnaryOperator
    public final /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        switch (this.a) {
        }
        return IntUnaryOperator$CC.$default$compose(this, intUnaryOperator);
    }
}
