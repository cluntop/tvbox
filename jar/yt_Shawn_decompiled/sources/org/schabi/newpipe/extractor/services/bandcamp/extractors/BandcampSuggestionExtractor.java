package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.n1.g;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import com.grack.nanojson.JsonStringWriter;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampSuggestionExtractor extends SuggestionExtractor {
    private static final String AUTOCOMPLETE_URL = "https://bandcamp.com/api/bcsearch_public_api/1/autocomplete_elastic";

    public BandcampSuggestionExtractor(StreamingService streamingService) {
        super(streamingService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$suggestionList$0(JsonObject jsonObject) {
        return jsonObject.getString("name");
    }

    @Override // org.schabi.newpipe.extractor.suggestion.SuggestionExtractor
    public List<String> suggestionList(String str) {
        try {
            return (List) JsonParser.object().from(NewPipe.getDownloader().postWithContentTypeJson(AUTOCOMPLETE_URL, Collections.EMPTY_MAP, ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).value("fan_id", (String) null)).value("full_page", false)).value("search_filter", VideoStream.RESOLUTION_UNKNOWN)).value("search_text", str)).end()).done().getBytes(StandardCharsets.UTF_8)).responseBody()).getObject("auto").getArray("results").streamAsJsonObjects().map(new g(26)).distinct().collect(Collectors.toList());
        } catch (JsonParserException unused) {
            return Collections.EMPTY_LIST;
        }
    }
}
