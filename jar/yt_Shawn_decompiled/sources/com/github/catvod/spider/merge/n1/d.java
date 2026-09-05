package com.github.catvod.spider.merge.n1;

import java.util.function.Supplier;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCStreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.SubtitlesStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Supplier {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.a;
        String str = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new h(str);
            case 1:
                return NewPipe.lambda$getService$3(str);
            case 2:
                return Localization.lambda$listFrom$0(str);
            case 3:
                return TimeAgoParser.lambda$parseChronoUnit$2(str);
            case 4:
                return MediaCCCStreamExtractor.lambda$getAudioStreams$0(str);
            default:
                return SubtitlesStream.lambda$new$0(str);
        }
    }
}
