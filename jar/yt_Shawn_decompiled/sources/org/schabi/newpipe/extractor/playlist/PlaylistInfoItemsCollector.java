package org.schabi.newpipe.extractor.playlist;

import org.schabi.newpipe.extractor.InfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PlaylistInfoItemsCollector extends InfoItemsCollector<PlaylistInfoItem, PlaylistInfoItemExtractor> {
    public PlaylistInfoItemsCollector(int i) {
        super(i);
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public PlaylistInfoItem extract(PlaylistInfoItemExtractor playlistInfoItemExtractor) {
        PlaylistInfoItem playlistInfoItem = new PlaylistInfoItem(getServiceId(), playlistInfoItemExtractor.getUrl(), playlistInfoItemExtractor.getName());
        try {
            playlistInfoItem.setUploaderName(playlistInfoItemExtractor.getUploaderName());
        } catch (Exception e) {
            addError(e);
        }
        try {
            playlistInfoItem.setUploaderUrl(playlistInfoItemExtractor.getUploaderUrl());
        } catch (Exception e2) {
            addError(e2);
        }
        try {
            playlistInfoItem.setUploaderVerified(playlistInfoItemExtractor.isUploaderVerified());
        } catch (Exception e3) {
            addError(e3);
        }
        try {
            playlistInfoItem.setThumbnails(playlistInfoItemExtractor.getThumbnails());
        } catch (Exception e4) {
            addError(e4);
        }
        try {
            playlistInfoItem.setStreamCount(playlistInfoItemExtractor.getStreamCount());
        } catch (Exception e5) {
            addError(e5);
        }
        try {
            playlistInfoItem.setDescription(playlistInfoItemExtractor.getDescription());
        } catch (Exception e6) {
            addError(e6);
        }
        try {
            playlistInfoItem.setPlaylistType(playlistInfoItemExtractor.getPlaylistType());
        } catch (Exception e7) {
            addError(e7);
        }
        return playlistInfoItem;
    }
}
