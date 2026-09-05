package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.io.Serializable;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ReadyChannelTabListLinkHandler.ChannelTabExtractorBuilder, Serializable {
    public final /* synthetic */ JsonObject a;
    public final /* synthetic */ YoutubeChannelHelper.ChannelHeader b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ a(JsonObject jsonObject, YoutubeChannelHelper.ChannelHeader channelHeader, String str, String str2, String str3) {
        this.a = jsonObject;
        this.b = channelHeader;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler.ChannelTabExtractorBuilder
    public final ChannelTabExtractor build(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        return YoutubeChannelExtractor.lambda$getTabsForNonAgeRestrictedChannels$3bf8a84$1(this.a, this.b, this.c, this.d, this.e, streamingService, listLinkHandler);
    }
}
