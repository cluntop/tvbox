package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.services.bandcamp.BandcampService;
import org.schabi.newpipe.extractor.services.media_ccc.MediaCCCService;
import org.schabi.newpipe.extractor.services.peertube.PeertubeService;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudService;
import org.schabi.newpipe.extractor.services.youtube.YoutubeService;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ServiceList {
    public static final BandcampService Bandcamp;
    public static final MediaCCCService MediaCCC;
    public static final PeertubeService PeerTube;
    private static final List<StreamingService> SERVICES;
    public static final SoundcloudService SoundCloud;
    public static final YoutubeService YouTube;

    static {
        YoutubeService youtubeService = new YoutubeService(0);
        YouTube = youtubeService;
        SoundcloudService soundcloudService = new SoundcloudService(1);
        SoundCloud = soundcloudService;
        MediaCCCService mediaCCCService = new MediaCCCService(2);
        MediaCCC = mediaCCCService;
        PeertubeService peertubeService = new PeertubeService(3);
        PeerTube = peertubeService;
        BandcampService bandcampService = new BandcampService(4);
        Bandcamp = bandcampService;
        Object[] objArr = {youtubeService, soundcloudService, mediaCCCService, peertubeService, bandcampService};
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        SERVICES = DesugarCollections.unmodifiableList(arrayList);
    }

    private ServiceList() {
    }

    public static List<StreamingService> all() {
        return SERVICES;
    }
}
