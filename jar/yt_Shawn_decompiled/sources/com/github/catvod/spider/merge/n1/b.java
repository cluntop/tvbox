package com.github.catvod.spider.merge.n1;

import com.github.catvod.spider.merge.o1.s;
import com.github.catvod.spider.merge.o1.t;
import com.github.catvod.spider.merge.o1.z;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.WeakHashMap;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampCommentsExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampRadioStreamExtractor;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeTrendingLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Supplier {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int i) {
        this.a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new SoftReference(new ArrayDeque());
            case 1:
                return new StringBuilder(1024);
            case 2:
                return new char[2];
            case 3:
                return new String[512];
            case 4:
                return new char[2048];
            case 5:
                return new com.github.catvod.spider.merge.q1.e();
            case 6:
                return new WeakHashMap();
            case 7:
                return new t(new z(VideoStream.RESOLUTION_UNKNOWN), s.class);
            case 8:
                return BandcampCommentsExtractor.lambda$getNextPageToken$2();
            case 9:
                return BandcampRadioStreamExtractor.lambda$getUploaderName$0();
            default:
                return PeertubeTrendingLinkHandlerFactory.lambda$getId$1();
        }
    }
}
