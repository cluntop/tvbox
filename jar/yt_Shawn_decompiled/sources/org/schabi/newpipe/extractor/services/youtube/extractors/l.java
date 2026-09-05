package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                ((StreamInfoItemsCollector) obj2).commit((StreamInfoItemExtractor) obj);
                break;
            case 1:
                ((ItagItem) obj2).setAudioLocale((Locale) obj);
                break;
            case 2:
                ((MultiInfoItemsCollector) obj2).commit((MultiInfoItemsCollector) obj);
                break;
            default:
                YoutubeStreamExtractor.lambda$getItags$15((ArrayList) obj2, (Stream) obj);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
