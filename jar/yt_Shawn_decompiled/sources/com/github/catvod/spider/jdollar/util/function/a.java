package com.github.catvod.spider.jdollar.util.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements BinaryOperator {
    public final /* synthetic */ int a;
    public final /* synthetic */ Comparator b;

    public /* synthetic */ a(Comparator comparator, int i) {
        this.a = i;
        this.b = comparator;
    }

    @Override // java.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
        }
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (this.b.compare(obj, obj2) < 0) {
                    break;
                }
                break;
            default:
                if (this.b.compare(obj, obj2) > 0) {
                    break;
                }
                break;
        }
        return obj2;
    }
}
