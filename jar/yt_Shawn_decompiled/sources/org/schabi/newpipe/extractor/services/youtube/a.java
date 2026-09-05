package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;
import org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
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
                return YoutubeChannelHelper.lambda$getChannelHeader$5((JsonObject) obj);
            case 1:
                return YoutubeChannelHelper.lambda$getChannelAgeGateRenderer$10((JsonObject) obj);
            case 2:
                return YoutubeChannelHelper.lambda$getChannelAgeGateRenderer$12((JsonObject) obj);
            case 3:
                return YoutubeChannelHelper.lambda$getChannelName$7((YoutubeChannelHelper.ChannelHeader) obj);
            case 4:
                return YoutubeChannelHelper.lambda$getChannelHeader$0((JsonObject) obj);
            case 5:
                return YoutubeChannelHelper.lambda$getChannelHeader$2((JsonObject) obj);
            case 6:
                return YoutubeChannelHelper.lambda$getChannelHeader$3((JsonObject) obj);
            case 7:
                return YoutubeChannelHelper.lambda$getChannelHeader$4((JsonObject) obj);
            case 8:
                return YoutubeDescriptionHelper.lambda$getTransformContentFun$3((String) obj);
            case 9:
                return YoutubeMetaInfoHelper.lambda$getEmergencyOneboxRenderer$1(obj);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return ((Xtags.KeyValuePair) obj).getValue();
            case 11:
                return YoutubeParsingHelper.lambda$getImagesFromThumbnailsArray$7((JsonObject) obj);
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return YoutubeParsingHelper.lambda$getClientVersionFromServiceTrackingParam$2((JsonObject) obj);
            default:
                return YoutubeParsingHelper.lambda$getClientVersionFromServiceTrackingParam$4((JsonObject) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
