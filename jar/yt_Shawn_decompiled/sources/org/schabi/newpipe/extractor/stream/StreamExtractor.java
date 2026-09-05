package org.schabi.newpipe.extractor.stream;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.Extractor;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.InfoItemsCollector;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.localization.DateWrapper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class StreamExtractor extends Extractor {
    public static final int NO_AGE_LIMIT = 0;
    public static final long UNKNOWN_SUBSCRIBER_COUNT = -1;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum Privacy {
        PUBLIC,
        UNLISTED,
        PRIVATE,
        INTERNAL,
        OTHER
    }

    public StreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
    }

    public int getAgeLimit() {
        return 0;
    }

    public abstract List<AudioStream> getAudioStreams();

    public String getCategory() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public ContentAvailability getContentAvailability() {
        return ContentAvailability.UNKNOWN;
    }

    public String getDashMpdUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    public long getDislikeCount() {
        return -1L;
    }

    public String getErrorMessage() {
        return null;
    }

    public List<Frameset> getFrames() {
        return Collections.EMPTY_LIST;
    }

    public String getHlsUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public String getHost() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public Locale getLanguageInfo() {
        return null;
    }

    public long getLength() {
        return 0L;
    }

    public String getLicence() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public long getLikeCount() {
        return -1L;
    }

    public List<MetaInfo> getMetaInfo() {
        return Collections.EMPTY_LIST;
    }

    public Privacy getPrivacy() {
        return Privacy.PUBLIC;
    }

    public InfoItemsCollector<? extends InfoItem, ? extends InfoItemExtractor> getRelatedItems() {
        return null;
    }

    @Deprecated
    public StreamInfoItemsCollector getRelatedStreams() {
        InfoItemsCollector<? extends InfoItem, ? extends InfoItemExtractor> relatedItems = getRelatedItems();
        if (relatedItems instanceof StreamInfoItemsCollector) {
            return (StreamInfoItemsCollector) relatedItems;
        }
        return null;
    }

    public List<StreamSegment> getStreamSegments() {
        return Collections.EMPTY_LIST;
    }

    public abstract StreamType getStreamType();

    public List<Image> getSubChannelAvatars() {
        return Collections.EMPTY_LIST;
    }

    public String getSubChannelName() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public String getSubChannelUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public List<SubtitlesStream> getSubtitles(MediaFormat mediaFormat) {
        return Collections.EMPTY_LIST;
    }

    public List<SubtitlesStream> getSubtitlesDefault() {
        return Collections.EMPTY_LIST;
    }

    public String getSupportInfo() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public List<String> getTags() {
        return Collections.EMPTY_LIST;
    }

    public String getTextualUploadDate() {
        return null;
    }

    public abstract List<Image> getThumbnails();

    public long getTimeStamp() {
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[Catch: ParsingException -> 0x003c, TryCatch #0 {ParsingException -> 0x003c, blocks: (B:19:0x003e, B:23:0x004b, B:27:0x0057, B:30:0x005e, B:26:0x0053, B:22:0x0047, B:12:0x0029, B:14:0x002f, B:16:0x0035), top: B:38:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053 A[Catch: ParsingException -> 0x003c, TryCatch #0 {ParsingException -> 0x003c, blocks: (B:19:0x003e, B:23:0x004b, B:27:0x0057, B:30:0x005e, B:26:0x0053, B:22:0x0047, B:12:0x0029, B:14:0x002f, B:16:0x0035), top: B:38:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e A[Catch: ParsingException -> 0x003c, TRY_LEAVE, TryCatch #0 {ParsingException -> 0x003c, blocks: (B:19:0x003e, B:23:0x004b, B:27:0x0057, B:30:0x005e, B:26:0x0053, B:22:0x0047, B:12:0x0029, B:14:0x002f, B:16:0x0035), top: B:38:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getTimestampSeconds(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r8.getOriginalUrl()     // Catch: org.schabi.newpipe.extractor.utils.Parser.RegexException -> L76
            java.lang.String r9 = org.schabi.newpipe.extractor.utils.Parser.matchGroup1(r9, r1)     // Catch: org.schabi.newpipe.extractor.utils.Parser.RegexException -> L76
            boolean r1 = r9.isEmpty()
            r2 = 0
            if (r1 != 0) goto L75
            java.lang.String r1 = "(\\d+)s"
            java.lang.String r1 = org.schabi.newpipe.extractor.utils.Parser.matchGroup1(r1, r9)     // Catch: java.lang.Exception -> L27
            java.lang.String r4 = "(\\d+)m"
            java.lang.String r4 = org.schabi.newpipe.extractor.utils.Parser.matchGroup1(r4, r9)     // Catch: java.lang.Exception -> L25
            java.lang.String r5 = "(\\d+)h"
            java.lang.String r0 = org.schabi.newpipe.extractor.utils.Parser.matchGroup1(r5, r9)     // Catch: java.lang.Exception -> L29
            goto L3e
        L25:
            r4 = r0
            goto L29
        L27:
            r1 = r0
            r4 = r1
        L29:
            boolean r5 = r1.isEmpty()     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
            if (r5 == 0) goto L3e
            boolean r5 = r4.isEmpty()     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
            if (r5 == 0) goto L3e
            java.lang.String r1 = "t=(\\d+)"
            java.lang.String r1 = org.schabi.newpipe.extractor.utils.Parser.matchGroup1(r1, r9)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
            goto L3e
        L3c:
            r9 = move-exception
            goto L70
        L3e:
            boolean r9 = r1.isEmpty()     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
            r5 = 0
            if (r9 == 0) goto L47
            r9 = 0
            goto L4b
        L47:
            int r9 = java.lang.Integer.parseInt(r1)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
        L4b:
            boolean r1 = r4.isEmpty()     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
            if (r1 == 0) goto L53
            r1 = 0
            goto L57
        L53:
            int r1 = java.lang.Integer.parseInt(r4)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
        L57:
            boolean r4 = r0.isEmpty()     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
            if (r4 == 0) goto L5e
            goto L62
        L5e:
            int r5 = java.lang.Integer.parseInt(r0)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L3c
        L62:
            long r2 = (long) r9
            r6 = 60
            long r0 = (long) r1
            long r0 = r0 * r6
            long r0 = r0 + r2
            r2 = 3600(0xe10, double:1.7786E-320)
            long r4 = (long) r5
            long r4 = r4 * r2
            long r4 = r4 + r0
            return r4
        L70:
            java.lang.String r0 = "Could not get timestamp."
            com.github.catvod.spider.merge.s0.a.m(r0, r9)
        L75:
            return r2
        L76:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.stream.StreamExtractor.getTimestampSeconds(java.lang.String):long");
    }

    public DateWrapper getUploadDate() {
        return null;
    }

    public List<Image> getUploaderAvatars() {
        return Collections.EMPTY_LIST;
    }

    public abstract String getUploaderName();

    public long getUploaderSubscriberCount() {
        return -1L;
    }

    public abstract String getUploaderUrl();

    public abstract List<VideoStream> getVideoOnlyStreams();

    public abstract List<VideoStream> getVideoStreams();

    public long getViewCount() {
        return -1L;
    }

    public boolean isShortFormContent() {
        return false;
    }

    public boolean isUploaderVerified() {
        return false;
    }
}
