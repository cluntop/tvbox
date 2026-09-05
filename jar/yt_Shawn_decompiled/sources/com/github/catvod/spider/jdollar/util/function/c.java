package com.github.catvod.spider.jdollar.util.function;

import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ Function c;

    public /* synthetic */ c(Function function, Function function2, int i) {
        this.a = i;
        this.b = function;
        this.c = function2;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        switch (this.a) {
        }
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return this.c.apply(this.b.apply(obj));
            default:
                return this.b.apply(this.c.apply(obj));
        }
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        switch (this.a) {
        }
        return Function$CC.$default$compose(this, function);
    }
}
