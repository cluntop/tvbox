package org.schabi.newpipe.extractor.playlist;

import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.stream.Description;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PlaylistInfoItem extends InfoItem {
    private Description description;
    private PlaylistInfo.PlaylistType playlistType;
    private long streamCount;
    private String uploaderName;
    private String uploaderUrl;
    private boolean uploaderVerified;

    public PlaylistInfoItem(int i, String str, String str2) {
        super(InfoItem.InfoType.PLAYLIST, i, str, str2);
        this.streamCount = 0L;
    }

    public Description getDescription() {
        return this.description;
    }

    public PlaylistInfo.PlaylistType getPlaylistType() {
        return this.playlistType;
    }

    public long getStreamCount() {
        return this.streamCount;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public String getUploaderUrl() {
        return this.uploaderUrl;
    }

    public boolean isUploaderVerified() {
        return this.uploaderVerified;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setPlaylistType(PlaylistInfo.PlaylistType playlistType) {
        this.playlistType = playlistType;
    }

    public void setStreamCount(long j) {
        this.streamCount = j;
    }

    public void setUploaderName(String str) {
        this.uploaderName = str;
    }

    public void setUploaderUrl(String str) {
        this.uploaderUrl = str;
    }

    public void setUploaderVerified(boolean z) {
        this.uploaderVerified = z;
    }
}
