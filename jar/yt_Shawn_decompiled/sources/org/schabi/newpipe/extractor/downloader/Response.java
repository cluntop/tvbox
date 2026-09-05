package org.schabi.newpipe.extractor.downloader;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Response {
    private final String latestUrl;
    private final String responseBody;
    private final int responseCode;
    private final Map<String, List<String>> responseHeaders;
    private final String responseMessage;

    public Response(int i, String str, Map<String, List<String>> map, String str2, String str3) {
        this.responseCode = i;
        this.responseMessage = str;
        this.responseHeaders = map == null ? Collections.EMPTY_MAP : map;
        this.responseBody = str2 == null ? VideoStream.RESOLUTION_UNKNOWN : str2;
        this.latestUrl = str3;
    }

    public String getHeader(String str) {
        for (Map.Entry<String, List<String>> entry : this.responseHeaders.entrySet()) {
            String key = entry.getKey();
            if (key != null && key.equalsIgnoreCase(str) && !entry.getValue().isEmpty()) {
                return entry.getValue().get(0);
            }
        }
        return null;
    }

    public String latestUrl() {
        return this.latestUrl;
    }

    public String responseBody() {
        return this.responseBody;
    }

    public int responseCode() {
        return this.responseCode;
    }

    public Map<String, List<String>> responseHeaders() {
        return this.responseHeaders;
    }

    public String responseMessage() {
        return this.responseMessage;
    }
}
