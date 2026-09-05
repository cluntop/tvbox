package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements BinaryOperator {
    public final /* synthetic */ int a;
    public final /* synthetic */ BiConsumer b;

    public /* synthetic */ p(BiConsumer biConsumer, int i) {
        this.a = i;
        this.b = biConsumer;
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
                this.b.accept(obj, obj2);
                break;
            case 1:
                this.b.accept(obj, obj2);
                break;
            default:
                this.b.accept(obj, obj2);
                break;
        }
        return obj;
    }
}
