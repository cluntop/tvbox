package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ MultiInfoItemsCollector b;

    public /* synthetic */ a(MultiInfoItemsCollector multiInfoItemsCollector, int i) {
        this.a = i;
        this.b = multiInfoItemsCollector;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        MultiInfoItemsCollector multiInfoItemsCollector = this.b;
        JsonObject jsonObject = (JsonObject) obj;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                MediaCCCChannelTabExtractor.lambda$getInitialPage$0(multiInfoItemsCollector, jsonObject);
                break;
            default:
                SoundcloudParsingHelper.lambda$getInfoItemsFromApi$0(multiInfoItemsCollector, jsonObject);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
