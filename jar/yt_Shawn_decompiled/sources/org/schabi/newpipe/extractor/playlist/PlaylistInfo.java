package org.schabi.newpipe.extractor.playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.ListInfo;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ExtractorHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PlaylistInfo extends ListInfo<StreamInfoItem> {
    private List<Image> banners;
    private Description description;
    private PlaylistType playlistType;
    private long streamCount;
    private List<Image> subChannelAvatars;
    private String subChannelName;
    private String subChannelUrl;
    private List<Image> thumbnails;
    private List<Image> uploaderAvatars;
    private String uploaderName;
    private String uploaderUrl;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum PlaylistType {
        NORMAL,
        MIX_STREAM,
        MIX_MUSIC,
        MIX_CHANNEL,
        MIX_GENRE
    }

    private PlaylistInfo(int i, ListLinkHandler listLinkHandler, String str) {
        super(i, listLinkHandler, str);
        this.uploaderUrl = VideoStream.RESOLUTION_UNKNOWN;
        this.uploaderName = VideoStream.RESOLUTION_UNKNOWN;
        List<Image> list = Collections.EMPTY_LIST;
        this.banners = list;
        this.subChannelAvatars = list;
        this.thumbnails = list;
        this.uploaderAvatars = list;
    }

    public static PlaylistInfo getInfo(PlaylistExtractor playlistExtractor) {
        PlaylistInfo playlistInfo = new PlaylistInfo(playlistExtractor.getServiceId(), playlistExtractor.getLinkHandler(), playlistExtractor.getName());
        ArrayList arrayList = new ArrayList();
        try {
            playlistInfo.setOriginalUrl(playlistExtractor.getOriginalUrl());
        } catch (Exception e) {
            playlistInfo.addError(e);
        }
        try {
            playlistInfo.setStreamCount(playlistExtractor.getStreamCount());
        } catch (Exception e2) {
            playlistInfo.addError(e2);
        }
        try {
            playlistInfo.setDescription(playlistExtractor.getDescription());
        } catch (Exception e3) {
            playlistInfo.addError(e3);
        }
        try {
            playlistInfo.setThumbnails(playlistExtractor.getThumbnails());
        } catch (Exception e4) {
            playlistInfo.addError(e4);
        }
        try {
            playlistInfo.setUploaderUrl(playlistExtractor.getUploaderUrl());
        } catch (Exception e5) {
            arrayList.add(e5);
        }
        try {
            playlistInfo.setUploaderName(playlistExtractor.getUploaderName());
        } catch (Exception e6) {
            arrayList.add(e6);
        }
        try {
            playlistInfo.setUploaderAvatars(playlistExtractor.getUploaderAvatars());
        } catch (Exception e7) {
            arrayList.add(e7);
        }
        try {
            playlistInfo.setSubChannelUrl(playlistExtractor.getSubChannelUrl());
        } catch (Exception e8) {
            arrayList.add(e8);
        }
        try {
            playlistInfo.setSubChannelName(playlistExtractor.getSubChannelName());
        } catch (Exception e9) {
            arrayList.add(e9);
        }
        try {
            playlistInfo.setSubChannelAvatars(playlistExtractor.getSubChannelAvatars());
        } catch (Exception e10) {
            arrayList.add(e10);
        }
        try {
            playlistInfo.setBanners(playlistExtractor.getBanners());
        } catch (Exception e11) {
            playlistInfo.addError(e11);
        }
        try {
            playlistInfo.setPlaylistType(playlistExtractor.getPlaylistType());
        } catch (Exception e12) {
            playlistInfo.addError(e12);
        }
        if (!arrayList.isEmpty() && (!playlistInfo.getErrors().isEmpty() || arrayList.size() < 3)) {
            playlistInfo.addAllErrors(arrayList);
        }
        ListExtractor.InfoItemsPage itemsPageOrLogError = ExtractorHelper.getItemsPageOrLogError(playlistInfo, playlistExtractor);
        playlistInfo.setRelatedItems(itemsPageOrLogError.getItems());
        playlistInfo.setNextPage(itemsPageOrLogError.getNextPage());
        return playlistInfo;
    }

    public static ListExtractor.InfoItemsPage<StreamInfoItem> getMoreItems(StreamingService streamingService, String str, Page page) {
        return streamingService.getPlaylistExtractor(str).getPage(page);
    }

    public List<Image> getBanners() {
        return this.banners;
    }

    public Description getDescription() {
        return this.description;
    }

    public PlaylistType getPlaylistType() {
        return this.playlistType;
    }

    public long getStreamCount() {
        return this.streamCount;
    }

    public List<Image> getSubChannelAvatars() {
        return this.subChannelAvatars;
    }

    public String getSubChannelName() {
        return this.subChannelName;
    }

    public String getSubChannelUrl() {
        return this.subChannelUrl;
    }

    public List<Image> getThumbnails() {
        return this.thumbnails;
    }

    public List<Image> getUploaderAvatars() {
        return this.uploaderAvatars;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public String getUploaderUrl() {
        return this.uploaderUrl;
    }

    public void setBanners(List<Image> list) {
        this.banners = list;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setPlaylistType(PlaylistType playlistType) {
        this.playlistType = playlistType;
    }

    public void setStreamCount(long j) {
        this.streamCount = j;
    }

    public void setSubChannelAvatars(List<Image> list) {
        this.subChannelAvatars = list;
    }

    public void setSubChannelName(String str) {
        this.subChannelName = str;
    }

    public void setSubChannelUrl(String str) {
        this.subChannelUrl = str;
    }

    public void setThumbnails(List<Image> list) {
        this.thumbnails = list;
    }

    public void setUploaderAvatars(List<Image> list) {
        this.uploaderAvatars = list;
    }

    public void setUploaderName(String str) {
        this.uploaderName = str;
    }

    public void setUploaderUrl(String str) {
        this.uploaderUrl = str;
    }

    public static PlaylistInfo getInfo(StreamingService streamingService, String str) {
        PlaylistExtractor playlistExtractor = streamingService.getPlaylistExtractor(str);
        playlistExtractor.fetchPage();
        return getInfo(playlistExtractor);
    }

    public static PlaylistInfo getInfo(String str) {
        return getInfo(NewPipe.getServiceByUrl(str), str);
    }
}
