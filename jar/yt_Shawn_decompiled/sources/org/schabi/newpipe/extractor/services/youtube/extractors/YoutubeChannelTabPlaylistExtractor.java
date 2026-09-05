package org.schabi.newpipe.extractor.services.youtube.extractors;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeChannelTabPlaylistExtractor extends ChannelTabExtractor {
    private boolean playlistExisting;
    private final PlaylistExtractor playlistExtractorInstance;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class SystemPlaylistUrlCreationException extends RuntimeException {
        public SystemPlaylistUrlCreationException(String str, Throwable th) {
            super(str, th);
        }
    }

    public YoutubeChannelTabPlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
        this.playlistExtractorInstance = new YoutubePlaylistExtractor(streamingService, getPlaylistLinkHandler(listLinkHandler));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.schabi.newpipe.extractor.linkhandler.ListLinkHandler getPlaylistLinkHandler(org.schabi.newpipe.extractor.linkhandler.ListLinkHandler r7) {
        /*
            r6 = this;
            java.util.List r0 = r7.getContentFilters()
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 != 0) goto L96
            java.lang.String r7 = r7.getId()
            boolean r1 = org.schabi.newpipe.extractor.utils.Utils.isNullOrEmpty(r7)
            if (r1 != 0) goto L90
            java.lang.String r1 = "UC"
            boolean r1 = r7.startsWith(r1)
            if (r1 == 0) goto L90
            r1 = 2
            java.lang.String r7 = r7.substring(r1)
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            r0.getClass()
            int r4 = r0.hashCode()
            r5 = -1
            switch(r4) {
                case -903148681: goto L4a;
                case -816678056: goto L3f;
                case -439267705: goto L36;
                default: goto L34;
            }
        L34:
            r1 = -1
            goto L54
        L36:
            java.lang.String r3 = "livestreams"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L54
            goto L34
        L3f:
            java.lang.String r1 = "videos"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L34
        L48:
            r1 = 1
            goto L54
        L4a:
            java.lang.String r1 = "shorts"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L53
            goto L34
        L53:
            r1 = 0
        L54:
            switch(r1) {
                case 0: goto L6c;
                case 1: goto L65;
                case 2: goto L5d;
                default: goto L57;
            }
        L57:
            java.lang.String r7 = "Only Videos, Shorts and Livestreams tabs can extracted as playlists"
            com.github.catvod.spider.merge.s0.a.r(r7)
            return r2
        L5d:
            java.lang.String r0 = "UULV"
            java.lang.String r7 = r0.concat(r7)
        L63:
            r3 = r7
            goto L73
        L65:
            java.lang.String r0 = "UULF"
            java.lang.String r7 = r0.concat(r7)
            goto L63
        L6c:
            java.lang.String r0 = "UUSH"
            java.lang.String r7 = r0.concat(r7)
            goto L63
        L73:
            org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubePlaylistLinkHandlerFactory r7 = org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubePlaylistLinkHandlerFactory.getInstance()     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L86
            java.lang.String r1 = r7.getUrl(r3)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L86
            org.schabi.newpipe.extractor.linkhandler.ListLinkHandler r0 = new org.schabi.newpipe.extractor.linkhandler.ListLinkHandler     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L86
            java.util.List r4 = java.util.Collections.EMPTY_LIST     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L86
            java.lang.String r5 = ""
            r2 = r1
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L86
            return r0
        L86:
            r0 = move-exception
            r7 = r0
            org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabPlaylistExtractor$SystemPlaylistUrlCreationException r0 = new org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabPlaylistExtractor$SystemPlaylistUrlCreationException
            java.lang.String r1 = "Could not create a YouTube playlist from a valid playlist ID"
            r0.<init>(r1, r7)
            throw r0
        L90:
            java.lang.String r7 = "Invalid channel ID"
            com.github.catvod.spider.merge.s0.a.r(r7)
            return r2
        L96:
            java.lang.String r7 = "A content filter is required"
            com.github.catvod.spider.merge.s0.a.r(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabPlaylistExtractor.getPlaylistLinkHandler(org.schabi.newpipe.extractor.linkhandler.ListLinkHandler):org.schabi.newpipe.extractor.linkhandler.ListLinkHandler");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage getInitialPage() {
        return !this.playlistExisting ? ListExtractor.InfoItemsPage.emptyPage() : this.playlistExtractorInstance.getInitialPage();
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage getPage(Page page) {
        return !this.playlistExisting ? ListExtractor.InfoItemsPage.emptyPage() : this.playlistExtractorInstance.getPage(page);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        try {
            this.playlistExtractorInstance.onFetchPage(downloader);
            if (this.playlistExisting) {
                return;
            }
            this.playlistExisting = true;
        } catch (ContentNotAvailableException unused) {
        }
    }
}
