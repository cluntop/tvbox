package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.github.catvod.spider.jdollar.util.function.IntUnaryOperator$CC;
import java.util.function.IntUnaryOperator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements IntUnaryOperator {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int i) {
        this.a = i;
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        int i = this.a;
        return IntUnaryOperator$CC.$default$andThen(this, intUnaryOperator);
    }

    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return SoundcloudSearchExtractor.lambda$getPage$1(i);
            default:
                return SoundcloudSearchExtractor.lambda$getInitialPage$0(i);
        }
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        int i = this.a;
        return IntUnaryOperator$CC.$default$compose(this, intUnaryOperator);
    }
}
