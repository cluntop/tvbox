package org.schabi.newpipe.extractor.stream;

import java.util.Comparator;
import org.schabi.newpipe.extractor.InfoItemsCollector;
import org.schabi.newpipe.extractor.exceptions.FoundAdException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class StreamInfoItemsCollector extends InfoItemsCollector<StreamInfoItem, StreamInfoItemExtractor> {
    public StreamInfoItemsCollector(int i) {
        super(i);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemsCollector
    public void commit(StreamInfoItemExtractor streamInfoItemExtractor) {
        try {
            addItem(extract(streamInfoItemExtractor));
        } catch (FoundAdException unused) {
        } catch (Exception e) {
            addError(e);
        }
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public StreamInfoItem extract(StreamInfoItemExtractor streamInfoItemExtractor) throws FoundAdException {
        if (streamInfoItemExtractor.isAd()) {
            throw new FoundAdException("Found ad");
        }
        StreamInfoItem streamInfoItem = new StreamInfoItem(getServiceId(), streamInfoItemExtractor.getUrl(), streamInfoItemExtractor.getName(), streamInfoItemExtractor.getStreamType());
        try {
            streamInfoItem.setDuration(streamInfoItemExtractor.getDuration());
        } catch (Exception e) {
            addError(e);
        }
        try {
            streamInfoItem.setUploaderName(streamInfoItemExtractor.getUploaderName());
        } catch (Exception e2) {
            addError(e2);
        }
        try {
            streamInfoItem.setTextualUploadDate(streamInfoItemExtractor.getTextualUploadDate());
        } catch (Exception e3) {
            addError(e3);
        }
        try {
            streamInfoItem.setUploadDate(streamInfoItemExtractor.getUploadDate());
        } catch (ParsingException e4) {
            addError(e4);
        }
        try {
            streamInfoItem.setViewCount(streamInfoItemExtractor.getViewCount());
        } catch (Exception e5) {
            addError(e5);
        }
        try {
            streamInfoItem.setThumbnails(streamInfoItemExtractor.getThumbnails());
        } catch (Exception e6) {
            addError(e6);
        }
        try {
            streamInfoItem.setUploaderUrl(streamInfoItemExtractor.getUploaderUrl());
        } catch (Exception e7) {
            addError(e7);
        }
        try {
            streamInfoItem.setUploaderAvatars(streamInfoItemExtractor.getUploaderAvatars());
        } catch (Exception e8) {
            addError(e8);
        }
        try {
            streamInfoItem.setUploaderVerified(streamInfoItemExtractor.isUploaderVerified());
        } catch (Exception e9) {
            addError(e9);
        }
        try {
            streamInfoItem.setShortDescription(streamInfoItemExtractor.getShortDescription());
        } catch (Exception e10) {
            addError(e10);
        }
        try {
            streamInfoItem.setShortFormContent(streamInfoItemExtractor.isShortFormContent());
        } catch (Exception e11) {
            addError(e11);
        }
        try {
            streamInfoItem.setContentAvailability(streamInfoItemExtractor.getContentAvailability());
        } catch (Exception e12) {
            addError(e12);
        }
        return streamInfoItem;
    }

    public StreamInfoItemsCollector(int i, Comparator<StreamInfoItem> comparator) {
        super(i, comparator);
    }
}
