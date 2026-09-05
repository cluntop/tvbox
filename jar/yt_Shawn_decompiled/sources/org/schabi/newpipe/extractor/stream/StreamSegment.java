package org.schabi.newpipe.extractor.stream;

import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class StreamSegment implements Serializable {
    private String channelName;
    private String previewUrl = null;
    private int startTimeSeconds;
    private String title;
    public String url;

    public StreamSegment(String str, int i) {
        this.title = str;
        this.startTimeSeconds = i;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public int getStartTimeSeconds() {
        return this.startTimeSeconds;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setPreviewUrl(String str) {
        this.previewUrl = str;
    }

    public void setStartTimeSeconds(int i) {
        this.startTimeSeconds = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
