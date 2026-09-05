package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.util.Map;
import java.util.function.Function;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCLiveStreamExtractor;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.utils.ImageSuffix;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.a;
        String str = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return BandcampExtractorHelper.lambda$getImagesFromImageBaseUrl$3(str, (ImageSuffix) obj);
            case 1:
                return MediaCCCLiveStreamExtractor.lambda$getManifestOfDeliveryMethodWanted$2(str, (JsonObject) obj);
            case 2:
                return PeertubeParsingHelper.lambda$getImagesFromAvatarOrBannerArray$1(str, (JsonObject) obj);
            case 3:
                return SoundcloudParsingHelper.lambda$getAllImagesFromImageUrlReturned$1(str, (ImageSuffix) obj);
            case 4:
                return YoutubeDescriptionHelper.lambda$getTransformContentFun$4(str, (String) obj);
            default:
                return Utils.lambda$join$0(str, (Map.Entry) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
