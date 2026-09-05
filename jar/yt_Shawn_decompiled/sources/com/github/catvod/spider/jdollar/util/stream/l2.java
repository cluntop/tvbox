package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l2 extends m2 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l2(a aVar, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator, int i) {
        super(aVar, spliterator, longFunction, binaryOperator);
        this.k = i;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m2, com.github.catvod.spider.jdollar.util.stream.d
    public final /* bridge */ /* synthetic */ Object a() {
        switch (this.k) {
        }
        return a();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m2, com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        switch (this.k) {
        }
        return new m2(this, spliterator);
    }
}
