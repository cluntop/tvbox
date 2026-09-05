package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ StreamInfoItemsCollector b;
    public final /* synthetic */ TimeAgoParser c;

    public /* synthetic */ b(StreamInfoItemsCollector streamInfoItemsCollector, TimeAgoParser timeAgoParser, int i) {
        this.a = i;
        this.b = streamInfoItemsCollector;
        this.c = timeAgoParser;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        TimeAgoParser timeAgoParser = this.c;
        StreamInfoItemsCollector streamInfoItemsCollector = this.b;
        JsonObject jsonObject = (JsonObject) obj;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                YoutubeDesktopBaseKioskExtractor.lambda$collectStreamItems$2(streamInfoItemsCollector, timeAgoParser, jsonObject);
                break;
            case 1:
                YoutubeTrendingExtractor.lambda$getInitialPage$8(streamInfoItemsCollector, timeAgoParser, jsonObject);
                break;
            default:
                YoutubeTrendingExtractor.lambda$getInitialPage$2(streamInfoItemsCollector, timeAgoParser, jsonObject);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
