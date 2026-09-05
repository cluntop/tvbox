package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudSuggestionExtractor extends SuggestionExtractor {
    public SoundcloudSuggestionExtractor(StreamingService streamingService) {
        super(streamingService);
    }

    @Override // org.schabi.newpipe.extractor.suggestion.SuggestionExtractor
    public List<String> suggestionList(String str) throws ParsingException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<Object> it = JsonParser.object().from(NewPipe.getDownloader().get("https://api-v2.soundcloud.com/search/queries?q=" + Utils.encodeUrlUtf8(str) + "&client_id=" + SoundcloudParsingHelper.clientId() + "&limit=10", getExtractorLocalization()).responseBody()).getArray("collection").iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    arrayList.add(((JsonObject) next).getString("query"));
                }
            }
            return arrayList;
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
            return null;
        }
    }
}
