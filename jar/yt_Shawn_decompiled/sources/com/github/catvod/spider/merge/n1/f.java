package com.github.catvod.spider.merge.n1;

import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import com.github.catvod.spider.merge.u.c2;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampCommentsExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements BinaryOperator {
    public final /* synthetic */ int a;

    public /* synthetic */ f(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        int i = this.a;
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                h hVar = (h) obj;
                h hVar2 = (h) obj2;
                String strL = i.l(hVar2.a);
                hVar2.a = null;
                c2.R(hVar.a);
                hVar.a.append((Object) strL);
                return hVar;
            case 1:
                return BandcampCommentsExtractor.lambda$getNextPageToken$1((String) obj, (String) obj2);
            default:
                return Parser.lambda$compatParseMap$4((String) obj, (String) obj2);
        }
    }
}
