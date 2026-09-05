package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ w(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                ((e) obj2).add((com.github.catvod.spider.merge.o1.n) obj);
                break;
            case 1:
                ((PlaylistInfoItemsCollector) obj2).commit((PlaylistInfoItemsCollector) obj);
                break;
            case 2:
                ((StreamInfoItemsCollector) obj2).commit((StreamInfoItemExtractor) obj);
                break;
            case 3:
                ((List) obj2).add((VideoStream) obj);
                break;
            case 4:
                ((ArrayList) obj2).add((MetaInfo) obj);
                break;
            default:
                ((ManifestCreatorCache) obj2).lambda$keepNewestEntries$1((Map.Entry) obj);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
