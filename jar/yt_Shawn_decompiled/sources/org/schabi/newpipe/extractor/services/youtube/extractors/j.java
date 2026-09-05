package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.utils.ImageSuffix;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ j(String str, int i) {
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
                return YoutubeMixPlaylistExtractor.lambda$getThumbnailsFromVideoId$1(str, (ImageSuffix) obj);
            default:
                return YoutubeStreamExtractor.lambda$getVideoInfoRenderer$13(str, (JsonObject) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
