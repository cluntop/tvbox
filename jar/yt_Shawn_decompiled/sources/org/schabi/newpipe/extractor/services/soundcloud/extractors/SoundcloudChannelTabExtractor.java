package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import java.io.IOException;
import java.util.HashSet;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudChannelTabExtractor extends ChannelTabExtractor {
    private static final int MAX_EMPTY_PAGES = 3;
    private static final String USERS_ENDPOINT = "https://api-v2.soundcloud.com/users/";
    private final String userId;

    public SoundcloudChannelTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
        this.userId = getLinkHandler().getId();
    }

    private String getEndpoint() throws ParsingException {
        String name = getName();
        name.getClass();
        switch (name) {
            case "playlists":
                return "/playlists_without_albums";
            case "albums":
                return "/albums";
            case "tracks":
                return "/tracks";
            case "likes":
                return "/likes";
            default:
                throw new ParsingException(com.github.catvod.spider.merge.b.b.n("Unsupported tab: ", getName()));
        }
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        return this.userId;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() throws ParsingException {
        return getPage(new Page(USERS_ENDPOINT + this.userId + getEndpoint() + "?client_id=" + SoundcloudParsingHelper.clientId() + "&limit=20&linked_partitioning=1"));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) throws IOException, ParsingException {
        String str;
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        HashSet hashSet = new HashSet();
        String url = page.getUrl();
        int i = 0;
        while (true) {
            boolean zIsNullOrEmpty = Utils.isNullOrEmpty(url);
            str = VideoStream.RESOLUTION_UNKNOWN;
            if (zIsNullOrEmpty || !hashSet.add(url)) {
                break;
            }
            int size = multiInfoItemsCollector.getItems().size();
            url = SoundcloudParsingHelper.getInfoItemsFromApi(multiInfoItemsCollector, url);
            if (multiInfoItemsCollector.getItems().size() > size) {
                str = url;
                break;
            }
            i++;
            if (i >= 3 || Utils.isNullOrEmpty(url)) {
                break;
            }
        }
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, Utils.isNullOrEmpty(str) ? null : new Page(str));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
    }
}
