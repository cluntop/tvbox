package org.schabi.newpipe.extractor.services.youtube.extractors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeFeedInfoItemExtractor implements StreamInfoItemExtractor {
    private final com.github.catvod.spider.merge.o1.n entryElement;

    public YoutubeFeedInfoItemExtractor(com.github.catvod.spider.merge.o1.n nVar) {
        this.entryElement = nVar;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final ContentAvailability getContentAvailability() {
        return ContentAvailability.UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return ((com.github.catvod.spider.merge.o1.n) this.entryElement.O("title").c()).U();
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ String getShortDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        return StreamType.VIDEO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        return ((com.github.catvod.spider.merge.o1.n) this.entryElement.O("published").c()).U();
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws NumberFormatException {
        int i;
        int i2;
        com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) this.entryElement.O("media:thumbnail").c();
        if (nVar == null) {
            return Collections.EMPTY_LIST;
        }
        String strB = nVar.b("url");
        if (strB.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        String strReplace = strB.replace("hqdefault", "mqdefault");
        if (strReplace.equals(strB)) {
            i2 = -1;
            try {
                i = Integer.parseInt(nVar.b("height"));
            } catch (NumberFormatException unused) {
                i = -1;
            }
            try {
                i2 = Integer.parseInt(nVar.b("width"));
            } catch (NumberFormatException unused2) {
            }
        } else {
            i = 320;
            i2 = 180;
        }
        Object[] objArr = {new Image(strReplace, i, i2, Image.ResolutionLevel.fromHeight(i))};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        return com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() {
        return DateWrapper.fromOffsetDateTime(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final List getUploaderAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        return ((com.github.catvod.spider.merge.o1.n) this.entryElement.T("author > name").c()).U();
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() {
        return ((com.github.catvod.spider.merge.o1.n) this.entryElement.T("author > uri").c()).U();
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return ((com.github.catvod.spider.merge.o1.n) this.entryElement.O("link").c()).b("href");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() {
        return Long.parseLong(((com.github.catvod.spider.merge.o1.n) this.entryElement.O("media:statistics").c()).b("views"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isAd() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ boolean isShortFormContent() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
