package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.Objects;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Image implements Serializable {
    public static final int HEIGHT_UNKNOWN = -1;
    public static final int WIDTH_UNKNOWN = -1;
    private final ResolutionLevel estimatedResolutionLevel;
    private final int height;
    private final String url;
    private final int width;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum ResolutionLevel {
        HIGH,
        MEDIUM,
        LOW,
        UNKNOWN;

        public static ResolutionLevel fromHeight(int i) {
            return i <= 0 ? UNKNOWN : i < 175 ? LOW : i < 720 ? MEDIUM : HIGH;
        }
    }

    public Image(String str, int i, int i2, ResolutionLevel resolutionLevel) {
        this.url = str;
        this.height = i;
        this.width = i2;
        Objects.requireNonNull(resolutionLevel, "estimatedResolutionLevel is null");
        this.estimatedResolutionLevel = resolutionLevel;
    }

    public ResolutionLevel getEstimatedResolutionLevel() {
        return this.estimatedResolutionLevel;
    }

    public int getHeight() {
        return this.height;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "Image {url=" + this.url + ", height=" + this.height + ", width=" + this.width + ", estimatedResolutionLevel=" + this.estimatedResolutionLevel + "}";
    }
}
