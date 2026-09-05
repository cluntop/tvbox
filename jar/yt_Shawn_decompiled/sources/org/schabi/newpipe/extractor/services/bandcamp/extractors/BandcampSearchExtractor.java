package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.e;
import com.github.catvod.spider.merge.u.c2;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.streaminfoitem.BandcampSearchStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampSearchExtractor extends SearchExtractor {
    public BandcampSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        super(streamingService, searchQueryHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getPage$0(n nVar) {
        return Collection$EL.stream(nVar.N("itemtype"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e lambda$getPage$1(n nVar) {
        return nVar.O("li");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        return getPage(new Page(getUrl()));
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public List<MetaInfo> getMetaInfo() {
        return Collections.EMPTY_LIST;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) {
        n nVar;
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"identity"}[0];
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("Cookie", com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList))};
        HashMap map = new HashMap(1);
        Map.Entry entry = entryArr[0];
        Object key = entry.getKey();
        Objects.requireNonNull(key);
        Object value = entry.getValue();
        Objects.requireNonNull(value);
        String str = null;
        if (map.put(key, value) != null) {
            com.github.catvod.spider.merge.b0.a.j("duplicate key: ", key);
            return null;
        }
        h hVarT = c2.T(getDownloader().get(page.getUrl(), DesugarCollections.unmodifiableMap(map)).responseBody());
        Iterator<E> it = hVarT.N("searchresult").iterator();
        while (true) {
            int i = 5;
            if (!it.hasNext()) {
                e eVarN = hVarT.N("pagelist");
                if (eVarN.isEmpty()) {
                    return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, null);
                }
                e eVar = (e) Collection$EL.stream(eVarN).map(new g(22)).findFirst().orElseGet(new com.github.catvod.spider.merge.n1.b(i));
                int i2 = 0;
                while (true) {
                    if (i2 < eVar.size()) {
                        if (((n) eVar.get(i2)).O("span").isEmpty()) {
                            i2++;
                        }
                    }
                }
                if (r7 < eVar.size()) {
                    str = page.getUrl().substring(0, page.getUrl().length() - 1) + (r7 + 1);
                }
                return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, new Page(str));
            }
            nVar = (n) it.next();
            String str2 = (String) Collection$EL.stream(nVar.N("result-info")).flatMap(new g(21)).map(new g(i)).findFirst().orElse(VideoStream.RESOLUTION_UNKNOWN);
            str2.getClass();
            switch (str2) {
                case "ALBUM":
                    multiInfoItemsCollector.commit((MultiInfoItemsCollector) new BandcampPlaylistInfoItemExtractor(nVar));
                    break;
                case "TRACK":
                    multiInfoItemsCollector.commit((MultiInfoItemsCollector) new BandcampSearchStreamInfoItemExtractor(nVar, null));
                    break;
                case "ARTIST":
                    multiInfoItemsCollector.commit((MultiInfoItemsCollector) new BandcampChannelInfoItemExtractor(nVar));
                    break;
            }
        }
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
    public void onFetchPage(Downloader downloader) {
    }
}
