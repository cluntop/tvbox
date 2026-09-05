package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCLiveStreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int i) {
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
                return MediaCCCLiveStreamExtractor.lambda$getAudioStreams$3((MediaCCCLiveStreamExtractor.MediaCCCLiveStreamMapperDTO) obj);
            case 1:
                return MediaCCCLiveStreamExtractor.lambda$getVideoStreams$4((MediaCCCLiveStreamExtractor.MediaCCCLiveStreamMapperDTO) obj);
            case 2:
                return MediaCCCLiveStreamExtractor.lambda$getManifestOfDeliveryMethodWanted$0((JsonObject) obj);
            case 3:
                return (JsonObject) JsonObject.class.cast(obj);
            case 4:
                return MediaCCCLiveStreamExtractor.lambda$getStreams$8((JsonObject) obj);
            case 5:
                return ((StreamInfoItem) obj).getUploadDate();
            case 6:
                return ((DateWrapper) obj).getInstant();
            default:
                return new MediaCCCRecentKioskExtractor((JsonObject) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
