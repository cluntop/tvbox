package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampChannelExtractor extends ChannelExtractor {
    private JsonObject channelInfo;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    final class TabExtractorBuilder implements ReadyChannelTabListLinkHandler.ChannelTabExtractorBuilder {
        private final JsonArray discography;

        public TabExtractorBuilder(JsonArray jsonArray) {
            this.discography = jsonArray;
        }

        @Override // org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler.ChannelTabExtractorBuilder
        public ChannelTabExtractor build(StreamingService streamingService, ListLinkHandler listLinkHandler) {
            return BandcampChannelTabExtractor.fromDiscography(streamingService, listLinkHandler, this.discography);
        }
    }

    public BandcampChannelExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getBanners$0(n nVar) {
        return Collection$EL.stream(nVar.O("img"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getBanners$1(n nVar) {
        return nVar.b("src");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBanners$2(String str) {
        return !str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Image lambda$getBanners$3(String str) {
        return new Image(Utils.replaceHttpWithHttps(str), -1, -1, Image.ResolutionLevel.UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getAvatars() {
        return BandcampExtractorHelper.getImagesFromImageId(this.channelInfo.getLong("bio_image_id"), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getBanners() throws ParsingException {
        try {
            h hVarT = c2.T(getDownloader().get(Utils.replaceHttpWithHttps(this.channelInfo.getString("bandcamp_url"))).responseBody());
            hVarT.getClass();
            c2.P("customHeader");
            return (List) Stream.CC.of((n) c2.X(new com.github.catvod.spider.merge.q1.h("customHeader", 8, false), hVarT).findFirst().orElse(null)).filter(new a(0 == true ? 1 : 0)).flatMap(new g(14)).map(new g(15)).filter(new a(1)).map(new g(16)).collect(Collectors.toUnmodifiableList());
        } catch (IOException | ReCaptchaException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not download artist web site", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getDescription() {
        return this.channelInfo.getString("bio");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getFeedUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.channelInfo.getString("name");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getParentChannelAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelName() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public long getSubscriberCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<ListLinkHandler> getTabs() {
        JsonArray array = this.channelInfo.getArray("discography");
        TabExtractorBuilder tabExtractorBuilder = new TabExtractorBuilder(array);
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = array.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (z && z2) {
                break;
            }
            if (next instanceof JsonObject) {
                String string = ((JsonObject) next).getString("item_type");
                if (!z && "track".equals(string)) {
                    arrayList.add(new ReadyChannelTabListLinkHandler(com.github.catvod.spider.merge.b.b.z(getUrl(), BandcampChannelTabLinkHandlerFactory.getUrlSuffix("tracks")), getId(), "tracks", tabExtractorBuilder));
                    z = true;
                }
                if (!z2 && "album".equals(string)) {
                    arrayList.add(new ReadyChannelTabListLinkHandler(com.github.catvod.spider.merge.b.b.z(getUrl(), BandcampChannelTabLinkHandlerFactory.getUrlSuffix(ChannelTabs.ALBUMS)), getId(), ChannelTabs.ALBUMS, tabExtractorBuilder));
                    z2 = true;
                }
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public boolean isVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.channelInfo = BandcampExtractorHelper.getArtistDetails(getId());
    }
}
