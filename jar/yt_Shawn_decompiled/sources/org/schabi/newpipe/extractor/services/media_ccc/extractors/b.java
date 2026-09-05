package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.grack.nanojson.JsonObject;
import java.io.Serializable;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ReadyChannelTabListLinkHandler.ChannelTabExtractorBuilder, Serializable {
    public final /* synthetic */ JsonObject a;

    public /* synthetic */ b(JsonObject jsonObject) {
        this.a = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler.ChannelTabExtractorBuilder
    public final ChannelTabExtractor build(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        return MediaCCCConferenceExtractor.lambda$getTabs$91397d47$1(this.a, streamingService, listLinkHandler);
    }
}
