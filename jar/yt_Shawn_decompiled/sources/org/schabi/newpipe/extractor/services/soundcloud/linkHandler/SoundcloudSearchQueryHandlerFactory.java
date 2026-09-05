package org.schabi.newpipe.extractor.services.soundcloud.linkHandler;

import com.github.catvod.spider.merge.s0.a;
import java.io.IOException;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SoundcloudSearchQueryHandlerFactory extends SearchQueryHandlerFactory {
    public static final String ALL = "all";
    private static final SoundcloudSearchQueryHandlerFactory INSTANCE = new SoundcloudSearchQueryHandlerFactory();
    public static final int ITEMS_PER_PAGE = 10;
    public static final String PLAYLISTS = "playlists";
    public static final String TRACKS = "tracks";
    public static final String USERS = "users";

    private SoundcloudSearchQueryHandlerFactory() {
    }

    public static SoundcloudSearchQueryHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"all", "tracks", USERS, "playlists"};
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Attempt to invoke interface method 'java.util.Iterator java.util.List.iterator()' on a null object reference
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory, org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) throws ParsingException {
        try {
            String str3 = "https://api-v2.soundcloud.com/search";
            if (!list.isEmpty()) {
                String str4 = list.get(0);
                switch (str4.hashCode()) {
                    case -1865828127:
                        if (str4.equals("playlists")) {
                            str3 = "https://api-v2.soundcloud.com/search/playlists";
                            break;
                        }
                        break;
                    case -865716088:
                        if (str4.equals("tracks")) {
                            str3 = "https://api-v2.soundcloud.com/search/tracks";
                            break;
                        }
                        break;
                    case 96673:
                        str4.equals("all");
                        break;
                    case 111578632:
                        if (str4.equals(USERS)) {
                            str3 = "https://api-v2.soundcloud.com/search/users";
                            break;
                        }
                        break;
                }
            }
            return str3 + "?q=" + Utils.encodeUrlUtf8(str) + "&client_id=" + SoundcloudParsingHelper.clientId() + "&limit=10&offset=0";
        } catch (IOException e) {
            e = e;
            a.m("Could not get client id", e);
            return null;
        } catch (ReCaptchaException e2) {
            a.m("ReCaptcha required", e2);
            return null;
        } catch (ExtractionException e3) {
            e = e3;
            a.m("Could not get client id", e);
            return null;
        }
    }
}
