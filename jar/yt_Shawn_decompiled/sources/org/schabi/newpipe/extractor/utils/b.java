package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import java.util.function.Function;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return Parser.lambda$compatParseMap$0((String) obj);
            case 1:
                return Parser.lambda$compatParseMap$2((String[]) obj);
            case 2:
                return Parser.lambda$compatParseMap$3((String[]) obj);
            default:
                return Pattern.compile((String) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
