package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Optional;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Supplier {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return YoutubeChannelTabExtractor.lambda$collectItemsFrom$7((Optional) this.b);
            default:
                return YoutubeStreamExtractor.lambda$getUploadDate$2((String) this.b);
        }
    }
}
