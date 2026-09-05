package org.schabi.newpipe.extractor.stream;

import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Frameset implements Serializable {
    private final int durationPerFrame;
    private final int frameHeight;
    private final int frameWidth;
    private final int framesPerPageX;
    private final int framesPerPageY;
    private final int totalCount;
    private final List<String> urls;

    public Frameset(List<String> list, int i, int i2, int i3, int i4, int i5, int i6) {
        this.urls = list;
        this.totalCount = i3;
        this.durationPerFrame = i4;
        this.frameWidth = i;
        this.frameHeight = i2;
        this.framesPerPageX = i5;
        this.framesPerPageY = i6;
    }

    public int getDurationPerFrame() {
        return this.durationPerFrame;
    }

    public int[] getFrameBoundsAt(long j) {
        if (j >= 0) {
            int i = this.totalCount;
            int i2 = this.durationPerFrame;
            if (j <= (i + 1) * i2) {
                int i3 = this.framesPerPageX * this.framesPerPageY;
                int iMin = Math.min((int) (j / i2), i);
                int i4 = iMin % i3;
                int i5 = this.framesPerPageX;
                int i6 = i4 / i5;
                if (i4 - (i5 * i6) != 0 && (((i5 ^ i4) >> 31) | 1) < 0) {
                    i6--;
                }
                int i7 = i4 % this.framesPerPageY;
                int i8 = iMin / i3;
                if (iMin - (i3 * i8) != 0 && (((iMin ^ i3) >> 31) | 1) < 0) {
                    i8--;
                }
                int i9 = this.frameWidth;
                int i10 = this.frameHeight;
                return new int[]{i8, i7 * i9, i6 * i10, (i7 * i9) + i9, (i6 * i10) + i10};
            }
        }
        return new int[]{0, 0, 0, this.frameWidth, this.frameHeight};
    }

    public int getFrameHeight() {
        return this.frameHeight;
    }

    public int getFrameWidth() {
        return this.frameWidth;
    }

    public int getFramesPerPageX() {
        return this.framesPerPageX;
    }

    public int getFramesPerPageY() {
        return this.framesPerPageY;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<String> getUrls() {
        return this.urls;
    }
}
