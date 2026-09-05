package org.schabi.newpipe.extractor.services.media_ccc;

import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.kiosk.KioskList;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferencesListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCLiveListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCRecentListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.PeertubeService;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeTrendingLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudService;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudChartsLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements KioskList.KioskExtractorFactory {
    public final /* synthetic */ int a;
    public final /* synthetic */ StreamingService b;
    public final /* synthetic */ ListLinkHandlerFactory c;

    public /* synthetic */ a(StreamingService streamingService, ListLinkHandlerFactory listLinkHandlerFactory, int i) {
        this.a = i;
        this.b = streamingService;
        this.c = listLinkHandlerFactory;
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
    public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
        int i = this.a;
        ListLinkHandlerFactory listLinkHandlerFactory = this.c;
        StreamingService streamingService2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return ((MediaCCCService) streamingService2).lambda$getKioskList$0((MediaCCCConferencesListLinkHandlerFactory) listLinkHandlerFactory, streamingService, str, str2);
            case 1:
                return ((MediaCCCService) streamingService2).lambda$getKioskList$1((MediaCCCRecentListLinkHandlerFactory) listLinkHandlerFactory, streamingService, str, str2);
            case 2:
                return ((MediaCCCService) streamingService2).lambda$getKioskList$2((MediaCCCLiveListLinkHandlerFactory) listLinkHandlerFactory, streamingService, str, str2);
            case 3:
                return ((PeertubeService) streamingService2).lambda$getKioskList$0((PeertubeTrendingLinkHandlerFactory) listLinkHandlerFactory, streamingService, str, str2);
            default:
                return ((SoundcloudService) streamingService2).lambda$getKioskList$0((SoundcloudChartsLinkHandlerFactory) listLinkHandlerFactory, streamingService, str, str2);
        }
    }
}
