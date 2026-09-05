package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

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
        JsonObject jsonObject = (JsonObject) obj;
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return YoutubeDesktopBaseKioskExtractor.lambda$getPage$1(jsonObject);
            case 1:
                return YoutubeTrendingExtractor.lambda$getTrendingTab$9(jsonObject);
            case 2:
                return YoutubeTrendingExtractor.lambda$getInitialPage$6(jsonObject);
            case 3:
                return YoutubeTrendingExtractor.lambda$getInitialPage$7(jsonObject);
            case 4:
                return YoutubeTrendingExtractor.lambda$getInitialPage$1(jsonObject);
            case 5:
                return YoutubeTrendingExtractor.lambda$getInitialPage$3(jsonObject);
            default:
                return YoutubeTrendingExtractor.lambda$getInitialPage$4(jsonObject);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
