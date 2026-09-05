package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeSearchQueryHandlerFactory extends SearchQueryHandlerFactory {
    public static final String ALL = "all";
    public static final String CHANNELS = "channels";
    private static final YoutubeSearchQueryHandlerFactory INSTANCE = new YoutubeSearchQueryHandlerFactory();
    public static final String MUSIC_ALBUMS = "music_albums";
    public static final String MUSIC_ARTISTS = "music_artists";
    public static final String MUSIC_PLAYLISTS = "music_playlists";
    private static final String MUSIC_SEARCH_URL = "https://music.youtube.com/search?q=";
    public static final String MUSIC_SONGS = "music_songs";
    public static final String MUSIC_VIDEOS = "music_videos";
    public static final String PLAYLISTS = "playlists";
    private static final String SEARCH_URL = "https://www.youtube.com/results?search_query=";
    public static final String VIDEOS = "videos";

    public static YoutubeSearchQueryHandlerFactory getInstance() {
        return INSTANCE;
    }

    public static String getSearchParameter(String str) {
        if (Utils.isNullOrEmpty(str)) {
            return "8AEB";
        }
        str.getClass();
        switch (str) {
        }
        return "8AEB";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"all", "videos", "channels", "playlists", MUSIC_SONGS, MUSIC_VIDEOS, MUSIC_ALBUMS, MUSIC_PLAYLISTS};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    @Override // org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory, org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getUrl(java.lang.String r3, java.util.List<java.lang.String> r4, java.lang.String r5) {
        /*
            r2 = this;
            boolean r5 = r4.isEmpty()
            r0 = 0
            if (r5 != 0) goto Le
            java.lang.Object r4 = r4.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            goto L10
        Le:
            java.lang.String r4 = ""
        L10:
            r4.getClass()
            int r5 = r4.hashCode()
            r1 = -1
            switch(r5) {
                case -1865828127: goto L6a;
                case -1778518201: goto L5f;
                case -816678056: goto L54;
                case -566908430: goto L49;
                case 1432626128: goto L3e;
                case 1499667262: goto L33;
                case 1589120868: goto L28;
                case 2098153138: goto L1d;
                default: goto L1b;
            }
        L1b:
            r0 = -1
            goto L73
        L1d:
            java.lang.String r5 = "music_videos"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L26
            goto L1b
        L26:
            r0 = 7
            goto L73
        L28:
            java.lang.String r5 = "music_songs"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L31
            goto L1b
        L31:
            r0 = 6
            goto L73
        L33:
            java.lang.String r5 = "music_albums"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L3c
            goto L1b
        L3c:
            r0 = 5
            goto L73
        L3e:
            java.lang.String r5 = "channels"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L47
            goto L1b
        L47:
            r0 = 4
            goto L73
        L49:
            java.lang.String r5 = "music_artists"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L52
            goto L1b
        L52:
            r0 = 3
            goto L73
        L54:
            java.lang.String r5 = "videos"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L5d
            goto L1b
        L5d:
            r0 = 2
            goto L73
        L5f:
            java.lang.String r5 = "music_playlists"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L68
            goto L1b
        L68:
            r0 = 1
            goto L73
        L6a:
            java.lang.String r5 = "playlists"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L73
            goto L1b
        L73:
            java.lang.String r4 = "https://www.youtube.com/results?search_query="
            switch(r0) {
                case 0: goto La4;
                case 1: goto L99;
                case 2: goto L8e;
                case 3: goto L99;
                case 4: goto L83;
                case 5: goto L99;
                case 6: goto L99;
                case 7: goto L99;
                default: goto L78;
            }
        L78:
            java.lang.String r3 = org.schabi.newpipe.extractor.utils.Utils.encodeUrlUtf8(r3)
            java.lang.String r5 = "&sp=8AEB"
            java.lang.String r3 = com.github.catvod.spider.merge.b.b.A(r4, r3, r5)
            return r3
        L83:
            java.lang.String r3 = org.schabi.newpipe.extractor.utils.Utils.encodeUrlUtf8(r3)
            java.lang.String r5 = "&sp=EgIQAvABAQ%253D%253D"
            java.lang.String r3 = com.github.catvod.spider.merge.b.b.A(r4, r3, r5)
            return r3
        L8e:
            java.lang.String r3 = org.schabi.newpipe.extractor.utils.Utils.encodeUrlUtf8(r3)
            java.lang.String r5 = "&sp=EgIQAfABAQ%253D%253D"
            java.lang.String r3 = com.github.catvod.spider.merge.b.b.A(r4, r3, r5)
            return r3
        L99:
            java.lang.String r3 = org.schabi.newpipe.extractor.utils.Utils.encodeUrlUtf8(r3)
            java.lang.String r4 = "https://music.youtube.com/search?q="
            java.lang.String r3 = com.github.catvod.spider.merge.b.b.n(r4, r3)
            return r3
        La4:
            java.lang.String r3 = org.schabi.newpipe.extractor.utils.Utils.encodeUrlUtf8(r3)
            java.lang.String r5 = "&sp=EgIQA_ABAQ%253D%253D"
            java.lang.String r3 = com.github.catvod.spider.merge.b.b.A(r4, r3, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeSearchQueryHandlerFactory.getUrl(java.lang.String, java.util.List, java.lang.String):java.lang.String");
    }
}
