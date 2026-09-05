package org.schabi.newpipe.extractor.playlist;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class PlaylistExtractor extends ListExtractor<StreamInfoItem> {
    public PlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    public List<Image> getBanners() {
        return Collections.EMPTY_LIST;
    }

    public abstract Description getDescription();

    public PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    public abstract long getStreamCount();

    public List<Image> getSubChannelAvatars() {
        return Collections.EMPTY_LIST;
    }

    public String getSubChannelName() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public String getSubChannelUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public List<Image> getThumbnails() {
        return Collections.EMPTY_LIST;
    }

    public abstract List<Image> getUploaderAvatars();

    public abstract String getUploaderName();

    public abstract String getUploaderUrl();

    public abstract boolean isUploaderVerified();
}
