package org.schabi.newpipe.extractor.subscription;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.merge.b.b;
import java.io.InputStream;
import java.util.List;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class SubscriptionExtractor {
    protected final StreamingService service;
    private final List<ContentSource> supportedSources;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum ContentSource {
        CHANNEL_URL,
        INPUT_STREAM
    }

    public SubscriptionExtractor(StreamingService streamingService, List<ContentSource> list) {
        this.service = streamingService;
        this.supportedSources = DesugarCollections.unmodifiableList(list);
    }

    public List<SubscriptionItem> fromChannelUrl(String str) {
        throw new UnsupportedOperationException(b.A("Service ", this.service.getServiceInfo().getName(), " doesn't support extracting from a channel url"));
    }

    public List<SubscriptionItem> fromInputStream(InputStream inputStream) {
        throw new UnsupportedOperationException(b.A("Service ", this.service.getServiceInfo().getName(), " doesn't support extracting from an InputStream"));
    }

    public abstract String getRelatedUrl();

    public List<ContentSource> getSupportedSources() {
        return this.supportedSources;
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class InvalidSourceException extends ParsingException {
        public InvalidSourceException(String str, Throwable th) {
            super("Not a valid source".concat(str == null ? VideoStream.RESOLUTION_UNKNOWN : b.A(" (", str, ")")), th);
        }

        public InvalidSourceException(String str) {
            this(str, null);
        }

        public InvalidSourceException(Throwable th) {
            this(null, th);
        }

        public InvalidSourceException() {
            this(null, null);
        }
    }

    public List<SubscriptionItem> fromInputStream(InputStream inputStream, String str) {
        throw new UnsupportedOperationException(b.A("Service ", this.service.getServiceInfo().getName(), " doesn't support extracting from an InputStream"));
    }
}
