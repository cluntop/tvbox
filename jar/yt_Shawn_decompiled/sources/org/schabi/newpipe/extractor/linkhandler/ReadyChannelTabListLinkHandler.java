package org.schabi.newpipe.extractor.linkhandler;

import com.github.catvod.spider.merge.t0.a;
import java.io.Serializable;
import java.util.ArrayList;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ReadyChannelTabListLinkHandler extends ListLinkHandler {
    private final ChannelTabExtractorBuilder extractorBuilder;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface ChannelTabExtractorBuilder extends Serializable {
        ChannelTabExtractor build(StreamingService streamingService, ListLinkHandler listLinkHandler);
    }

    public ReadyChannelTabListLinkHandler(String str, String str2, String str3, ChannelTabExtractorBuilder channelTabExtractorBuilder) {
        Object[] objArr = {str3};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        super(str, str, str2, a.g(obj, arrayList, obj, arrayList), VideoStream.RESOLUTION_UNKNOWN);
        this.extractorBuilder = channelTabExtractorBuilder;
    }

    public ChannelTabExtractor getChannelTabExtractor(StreamingService streamingService) {
        return this.extractorBuilder.build(streamingService, new ListLinkHandler((ListLinkHandler) this));
    }
}
