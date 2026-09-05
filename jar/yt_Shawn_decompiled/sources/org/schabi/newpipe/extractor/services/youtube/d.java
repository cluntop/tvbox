package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.grack.nanojson.JsonObject;
import java.util.List;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;

    public /* synthetic */ d(List list, List list2, int i) {
        this.a = i;
        this.b = list;
        this.c = list2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                YoutubeDescriptionHelper.lambda$addAllStyleRuns$5(this.b, this.c, (JsonObject) obj);
                break;
            default:
                YoutubeDescriptionHelper.lambda$addAllCommandRuns$2(this.b, this.c, (JsonObject) obj);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
