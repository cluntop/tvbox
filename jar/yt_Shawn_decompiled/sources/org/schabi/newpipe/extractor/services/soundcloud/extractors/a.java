package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.grack.nanojson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicSearchExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                SoundcloudPlaylistExtractor.lambda$getInitialPage$0((StreamInfoItemsCollector) obj3, (ArrayList) obj2, (JsonObject) obj);
                break;
            case 1:
                ((SoundcloudStreamExtractor) obj3).lambda$extractAudioStreams$0((List) obj2, (JsonObject) obj);
                break;
            case 2:
                ((YoutubeChannelExtractor) obj3).lambda$getTabsForNonAgeRestrictedChannels$4((ArrayList) obj2, (String) obj);
                break;
            default:
                YoutubeMusicSearchExtractor.lambda$collectMusicStreamsFrom$5((String) obj3, (MultiInfoItemsCollector) obj2, (JsonObject) obj);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
