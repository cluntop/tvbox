package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelInfoItem;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.infoItems.MediaCCCStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferencesListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCSearchExtractor extends SearchExtractor {
    private MediaCCCConferenceKiosk conferenceKiosk;
    private JsonObject doc;

    public MediaCCCSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        super(streamingService, searchQueryHandler);
        try {
            this.conferenceKiosk = new MediaCCCConferenceKiosk(streamingService, MediaCCCConferencesListLinkHandlerFactory.getInstance().fromId("conferences"), "conferences");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchConferences(String str, List<ChannelInfoItem> list, MultiInfoItemsCollector multiInfoItemsCollector) {
        for (final ChannelInfoItem channelInfoItem : list) {
            if (channelInfoItem.getName().toUpperCase().contains(str.toUpperCase())) {
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new ChannelInfoItemExtractor() { // from class: org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCSearchExtractor.1
                    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
                    public String getDescription() {
                        return channelInfoItem.getDescription();
                    }

                    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
                    public String getName() {
                        return channelInfoItem.getName();
                    }

                    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
                    public long getStreamCount() {
                        return channelInfoItem.getStreamCount();
                    }

                    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
                    public long getSubscriberCount() {
                        return channelInfoItem.getSubscriberCount();
                    }

                    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
                    public List<Image> getThumbnails() {
                        return channelInfoItem.getThumbnails();
                    }

                    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
                    public String getUrl() {
                        return channelInfoItem.getUrl();
                    }

                    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
                    public boolean isVerified() {
                        return false;
                    }
                });
            }
        }
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        if (getLinkHandler().getContentFilters().contains("conferences") || getLinkHandler().getContentFilters().contains("all") || getLinkHandler().getContentFilters().isEmpty()) {
            searchConferences(getSearchString(), this.conferenceKiosk.getInitialPage().getItems(), multiInfoItemsCollector);
        }
        if (getLinkHandler().getContentFilters().contains(MediaCCCSearchQueryHandlerFactory.EVENTS) || getLinkHandler().getContentFilters().contains("all") || getLinkHandler().getContentFilters().isEmpty()) {
            JsonArray array = this.doc.getArray(MediaCCCSearchQueryHandlerFactory.EVENTS);
            for (int i = 0; i < array.size(); i++) {
                if (array.getObject(i).getString("release_date") != null) {
                    multiInfoItemsCollector.commit((MultiInfoItemsCollector) new MediaCCCStreamInfoItemExtractor(array.getObject(i)));
                }
            }
        }
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public List<MetaInfo> getMetaInfo() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public String getSearchSuggestion() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public boolean isCorrectedSearch() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        if (getLinkHandler().getContentFilters().contains(MediaCCCSearchQueryHandlerFactory.EVENTS) || getLinkHandler().getContentFilters().contains("all") || getLinkHandler().getContentFilters().isEmpty()) {
            try {
                this.doc = JsonParser.object().from(downloader.get(getUrl(), getExtractorLocalization()).responseBody());
            } catch (JsonParserException e) {
                throw new ExtractionException("Could not parse JSON.", e);
            }
        }
        if (getLinkHandler().getContentFilters().contains("conferences") || getLinkHandler().getContentFilters().contains("all") || getLinkHandler().getContentFilters().isEmpty()) {
            this.conferenceKiosk.fetchPage();
        }
    }
}
