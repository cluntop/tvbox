package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.n1.f;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.p;
import com.github.catvod.spider.merge.q1.v;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonStringWriter;
import com.grack.nanojson.JsonWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItem;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemsCollector;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.utils.JsonUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampCommentsExtractor extends CommentsExtractor {
    private static final String REVIEWS_API_URL = "https://bandcamp.com/api/tralbumcollectors/2/reviews";
    private h document;

    public BandcampCommentsExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    private JsonObject fetchReviewsData(String str, String str2) throws ParsingException {
        try {
            return JsonUtils.toJsonObject(getDownloader().postWithContentTypeJson(REVIEWS_API_URL, Collections.EMPTY_MAP, ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).value("tralbum_type", "t")).value("tralbum_id", str)).value("token", str2)).value(PeertubeParsingHelper.COUNT_KEY, 7)).array("exclude_fan_ids")).end()).end()).done().getBytes(StandardCharsets.UTF_8)).responseBody());
        } catch (IOException | ReCaptchaException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not fetch reviews", e);
            return null;
        }
    }

    private String getNextPageToken(JsonArray jsonArray) {
        return (String) jsonArray.streamAsJsonObjects().map(new g(17)).reduce(new f(1)).orElseThrow(new com.github.catvod.spider.merge.n1.b(8));
    }

    private String getTrackId() {
        h hVar = this.document;
        hVar.getClass();
        c2.P("meta[name=bc-page-properties]");
        p pVarH = v.H("meta[name=bc-page-properties]");
        n nVar = (n) c2.X(pVarH, hVar).findFirst().orElse(null);
        pVarH.e();
        return Long.toString(JsonUtils.toJsonObject(nVar.b("content")).getLong("item_id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNextPageToken$0(JsonObject jsonObject) {
        return jsonObject.getString("token");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNextPageToken$1(String str, String str2) {
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getNextPageToken$2() {
        return new ParsingException("Could not get token");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getInitialPage() {
        CommentsInfoItemsCollector commentsInfoItemsCollector = new CommentsInfoItemsCollector(getServiceId());
        h hVar = this.document;
        hVar.getClass();
        c2.P("collectors-data");
        JsonObject jsonObject = JsonUtils.toJsonObject(((n) c2.X(new com.github.catvod.spider.merge.q1.h("collectors-data", 8, 0 == true ? 1 : 0), hVar).findFirst().orElse(null)).b("data-blob"));
        JsonArray array = jsonObject.getArray("reviews");
        Iterator<Object> it = array.iterator();
        while (it.hasNext()) {
            commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new BandcampCommentsInfoItemExtractor((JsonObject) it.next(), getUrl()));
        }
        if (!jsonObject.getBoolean("more_reviews_available")) {
            return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, null);
        }
        Object[] objArr = {getTrackId(), getNextPageToken(array)};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, new Page((List<String>) DesugarCollections.unmodifiableList(arrayList)));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getPage(Page page) throws ParsingException {
        CommentsInfoItemsCollector commentsInfoItemsCollector = new CommentsInfoItemsCollector(getServiceId());
        List<String> ids = page.getIds();
        String str = ids.get(0);
        JsonObject jsonObjectFetchReviewsData = fetchReviewsData(str, ids.get(1));
        JsonArray array = jsonObjectFetchReviewsData.getArray("results");
        Iterator<Object> it = array.iterator();
        while (it.hasNext()) {
            commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new BandcampCommentsInfoItemExtractor((JsonObject) it.next(), getUrl()));
        }
        if (!jsonObjectFetchReviewsData.getBoolean("more_available")) {
            return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, null);
        }
        Object[] objArr = {str, getNextPageToken(array)};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, new Page((List<String>) DesugarCollections.unmodifiableList(arrayList)));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsExtractor
    public boolean isCommentsDisabled() {
        return BandcampExtractorHelper.isRadioUrl(getUrl());
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.document = c2.T(downloader.get(getLinkHandler().getUrl()).responseBody());
    }
}
