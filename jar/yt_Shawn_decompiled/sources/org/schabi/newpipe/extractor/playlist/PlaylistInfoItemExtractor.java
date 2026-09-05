package org.schabi.newpipe.extractor.playlist;

import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.stream.Description;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface PlaylistInfoItemExtractor extends InfoItemExtractor {
    Description getDescription();

    PlaylistInfo.PlaylistType getPlaylistType();

    long getStreamCount();

    String getUploaderName();

    String getUploaderUrl();

    boolean isUploaderVerified();
}
