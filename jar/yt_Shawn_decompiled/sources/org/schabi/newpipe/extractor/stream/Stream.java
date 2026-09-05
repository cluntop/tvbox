package org.schabi.newpipe.extractor.stream;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class Stream implements Serializable {
    public static final int FORMAT_ID_UNKNOWN = -1;
    public static final String ID_UNKNOWN = " ";
    public static final int ITAG_NOT_AVAILABLE_OR_NOT_APPLICABLE = -1;
    private final String content;
    private final DeliveryMethod deliveryMethod;
    private final String id;
    private final boolean isUrl;
    private final String manifestUrl;
    private final MediaFormat mediaFormat;

    public Stream(String str, String str2, boolean z, MediaFormat mediaFormat, DeliveryMethod deliveryMethod, String str3) {
        this.id = str;
        this.content = str2;
        this.isUrl = z;
        this.mediaFormat = mediaFormat;
        this.deliveryMethod = deliveryMethod;
        this.manifestUrl = str3;
    }

    public static boolean containSimilarStream(Stream stream, List<? extends Stream> list) {
        if (Utils.isNullOrEmpty(list)) {
            return false;
        }
        Iterator<? extends Stream> it = list.iterator();
        while (it.hasNext()) {
            if (stream.equalStats(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean equalStats(Stream stream) {
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        return stream != null && (mediaFormat = this.mediaFormat) != null && (mediaFormat2 = stream.mediaFormat) != null && mediaFormat.id == mediaFormat2.id && this.deliveryMethod == stream.deliveryMethod && this.isUrl == stream.isUrl;
    }

    public String getContent() {
        return this.content;
    }

    public DeliveryMethod getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public MediaFormat getFormat() {
        return this.mediaFormat;
    }

    public int getFormatId() {
        MediaFormat mediaFormat = this.mediaFormat;
        if (mediaFormat != null) {
            return mediaFormat.id;
        }
        return -1;
    }

    public String getId() {
        return this.id;
    }

    public abstract ItagItem getItagItem();

    public String getManifestUrl() {
        return this.manifestUrl;
    }

    @Deprecated
    public String getUrl() {
        if (this.isUrl) {
            return this.content;
        }
        return null;
    }

    public boolean isUrl() {
        return this.isUrl;
    }
}
