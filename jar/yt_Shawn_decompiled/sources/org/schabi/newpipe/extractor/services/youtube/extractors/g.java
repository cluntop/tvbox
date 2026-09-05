package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return YoutubeChannelTabExtractor.lambda$collectItemsFrom$8((Optional) obj, (Optional) obj2);
    }
}
