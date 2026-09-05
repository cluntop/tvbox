package org.schabi.newpipe.extractor.downloader;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.localization.Localization;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class Downloader {
    public abstract Response execute(Request request);

    public Response get(String str, Map<String, List<String>> map, Localization localization) {
        return execute(Request.newBuilder().get(str).headers(map).localization(localization).build());
    }

    public Response head(String str, Map<String, List<String>> map) {
        return execute(Request.newBuilder().head(str).headers(map).build());
    }

    public Response post(String str, Map<String, List<String>> map, byte[] bArr, Localization localization) {
        return execute(Request.newBuilder().post(str, bArr).headers(map).localization(localization).build());
    }

    public Response postWithContentType(String str, Map<String, List<String>> map, byte[] bArr, Localization localization, String str2) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("Content-Type", Collections.singletonList(str2));
        return post(str, map2, bArr, localization);
    }

    public Response postWithContentTypeJson(String str, Map<String, List<String>> map, byte[] bArr, Localization localization) {
        return postWithContentType(str, map, bArr, localization, "application/json");
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public Response postWithContentTypeJson(String str, Map<String, List<String>> map, byte[] bArr) {
        return postWithContentTypeJson(str, map, bArr, NewPipe.getPreferredLocalization());
    }

    public Response head(String str) {
        return head(str, null);
    }

    public Response postWithContentType(String str, Map<String, List<String>> map, byte[] bArr, String str2) {
        return postWithContentType(str, map, bArr, NewPipe.getPreferredLocalization(), str2);
    }

    public Response get(String str, Localization localization) {
        return get(str, null, localization);
    }

    public Response post(String str, Map<String, List<String>> map, byte[] bArr) {
        return post(str, map, bArr, NewPipe.getPreferredLocalization());
    }

    public Response get(String str, Map<String, List<String>> map) {
        return get(str, map, NewPipe.getPreferredLocalization());
    }

    public Response get(String str) {
        return get(str, null, NewPipe.getPreferredLocalization());
    }
}
