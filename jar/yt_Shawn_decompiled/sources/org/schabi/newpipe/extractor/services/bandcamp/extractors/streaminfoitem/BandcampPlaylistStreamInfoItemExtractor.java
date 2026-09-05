package org.schabi.newpipe.extractor.services.bandcamp.extractors.streaminfoitem;

import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonObject;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampPlaylistStreamInfoItemExtractor extends BandcampStreamInfoItemExtractor {
    private final StreamingService service;
    private List<Image> substituteCovers;
    private final JsonObject track;

    public BandcampPlaylistStreamInfoItemExtractor(JsonObject jsonObject, String str, StreamingService streamingService) {
        super(str);
        this.track = jsonObject;
        this.service = streamingService;
        this.substituteCovers = Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return this.track.getLong("duration");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.track.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        if (!this.substituteCovers.isEmpty() || getUrl() == null) {
            return this.substituteCovers;
        }
        try {
            StreamExtractor streamExtractor = this.service.getStreamExtractor(getUrl());
            streamExtractor.fetchPage();
            return streamExtractor.getThumbnails();
        } catch (IOException | ExtractionException e) {
            a.m("Could not download cover art location", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        String string = this.track.getString("title_link");
        if (string != null) {
            return b.z(getUploaderUrl(), string);
        }
        return null;
    }

    public BandcampPlaylistStreamInfoItemExtractor(JsonObject jsonObject, String str, List<Image> list) {
        this(jsonObject, str, (StreamingService) null);
        this.substituteCovers = list;
    }
}
