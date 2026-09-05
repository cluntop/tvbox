package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.util.Objects;
import java.io.Serializable;
import org.schabi.newpipe.extractor.Image;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ImageSuffix implements Serializable {
    private final int height;
    private final Image.ResolutionLevel resolutionLevel;
    private final String suffix;
    private final int width;

    public ImageSuffix(String str, int i, int i2, Image.ResolutionLevel resolutionLevel) {
        this.suffix = str;
        this.height = i;
        this.width = i2;
        Objects.requireNonNull(resolutionLevel, "estimatedResolutionLevel is null");
        this.resolutionLevel = resolutionLevel;
    }

    public int getHeight() {
        return this.height;
    }

    public Image.ResolutionLevel getResolutionLevel() {
        return this.resolutionLevel;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "ImageSuffix {suffix=" + this.suffix + ", height=" + this.height + ", width=" + this.width + ", resolutionLevel=" + this.resolutionLevel + "}";
    }
}
