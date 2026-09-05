package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeSuggestionExtractor extends SuggestionExtractor {
    public YoutubeSuggestionExtractor(StreamingService streamingService) {
        super(streamingService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$suggestionList$0(JsonArray jsonArray) {
        return jsonArray.getString(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$suggestionList$1(String str) {
        return !Utils.isBlank(str);
    }

    @Override // org.schabi.newpipe.extractor.suggestion.SuggestionExtractor
    public List<String> suggestionList(String str) throws ExtractionException {
        String str2 = "https://suggestqueries-clients6.youtube.com/complete/search?client=youtube&ds=yt&gl=" + Utils.encodeUrlUtf8(getExtractorContentCountry().getCountryCode()) + "&q=" + Utils.encodeUrlUtf8(str) + "&xhr=t";
        HashMap map = new HashMap();
        map.put("Origin", Collections.singletonList("https://www.youtube.com"));
        map.put("Referer", Collections.singletonList("https://www.youtube.com"));
        Response response = NewPipe.getDownloader().get(str2, map, getExtractorLocalization());
        String header = response.getHeader("Content-Type");
        if (Utils.isNullOrEmpty(header) || !header.contains("application/json")) {
            throw new ExtractionException("Invalid response type (got \"" + header + "\", excepted a JSON response) (response code " + response.responseCode() + ")");
        }
        String strResponseBody = response.responseBody();
        if (strResponseBody.isEmpty()) {
            throw new ExtractionException("Empty response received");
        }
        try {
            return (List) Collection$EL.stream(JsonParser.array().from(strResponseBody).getArray(1)).filter(new t(3)).map(new s(7)).map(new s(8)).filter(new t(4)).collect(Collectors.toUnmodifiableList());
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse JSON response", e);
            return null;
        }
    }
}
