package org.schabi.newpipe.extractor.services.peertube.linkHandler;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.b0.a;
import com.github.catvod.spider.merge.n1.b;
import com.github.catvod.spider.merge.n1.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeTrendingLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final PeertubeTrendingLinkHandlerFactory INSTANCE = new PeertubeTrendingLinkHandlerFactory();
    public static final String KIOSK_LOCAL = "Local";
    public static final Map<String, String> KIOSK_MAP;
    public static final String KIOSK_MOST_LIKED = "Most liked";
    public static final String KIOSK_RECENT = "Recently added";
    public static final String KIOSK_TRENDING = "Trending";

    static {
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("Trending", "%s/api/v1/videos?sort=-trending"), new AbstractMap.SimpleEntry(KIOSK_MOST_LIKED, "%s/api/v1/videos?sort=-likes"), new AbstractMap.SimpleEntry(KIOSK_RECENT, "%s/api/v1/videos?sort=-publishedAt"), new AbstractMap.SimpleEntry(KIOSK_LOCAL, "%s/api/v1/videos?sort=-publishedAt&isLocal=true")};
        HashMap map = new HashMap(4);
        for (int i = 0; i < 4; i++) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                a.j("duplicate key: ", key);
                return;
            }
        }
        KIOSK_MAP = DesugarCollections.unmodifiableMap(map);
    }

    private PeertubeTrendingLinkHandlerFactory() {
    }

    public static PeertubeTrendingLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getId$0(String str, Map.Entry entry) {
        return str.equals(entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getId$1() {
        return new ParsingException("no id found for this url");
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        String strReplace = str.replace(ServiceList.PeerTube.getBaseUrl(), "%s");
        return strReplace.contains("/videos/trending") ? "Trending" : strReplace.contains("/videos/most-liked") ? KIOSK_MOST_LIKED : strReplace.contains("/videos/recently-added") ? KIOSK_RECENT : strReplace.contains("/videos/local") ? KIOSK_LOCAL : (String) Collection$EL.stream(KIOSK_MAP.entrySet()).filter(new org.schabi.newpipe.extractor.a(strReplace, 6)).findFirst().map(new g(28)).orElseThrow(new b(10));
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2, String str3) {
        return String.format(KIOSK_MAP.get(str), str3);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        try {
            new URL(str);
            if (str.contains("/videos?") || str.contains("/videos/trending") || str.contains("/videos/most-liked") || str.contains("/videos/recently-added")) {
                return true;
            }
            return str.contains("/videos/local");
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return getUrl(str, list, str2, ServiceList.PeerTube.getBaseUrl());
    }
}
