package org.schabi.newpipe.extractor.downloader;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.localization.Localization;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Request {
    private final byte[] dataToSend;
    private final Map<String, List<String>> headers;
    private final String httpMethod;
    private final Localization localization;
    private final String url;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class Builder {
        private byte[] dataToSend;
        private String httpMethod;
        private Localization localization;
        private String url;
        private final Map<String, List<String>> headers = new LinkedHashMap();
        private boolean automaticLocalizationHeader = true;

        public Builder addHeader(String str, String str2) {
            return addHeaders(str, Collections.singletonList(str2));
        }

        public Builder addHeaders(String str, List<String> list) {
            List<String> arrayList = this.headers.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.addAll(list);
            this.headers.put(str, list);
            return this;
        }

        public Builder automaticLocalizationHeader(boolean z) {
            this.automaticLocalizationHeader = z;
            return this;
        }

        public Request build() {
            return new Request(this, 0);
        }

        public Builder dataToSend(byte[] bArr) {
            this.dataToSend = bArr;
            return this;
        }

        public Builder get(String str) {
            this.httpMethod = "GET";
            this.url = str;
            return this;
        }

        public Builder head(String str) {
            this.httpMethod = "HEAD";
            this.url = str;
            return this;
        }

        public Builder headers(Map<String, List<String>> map) {
            this.headers.clear();
            if (map != null) {
                this.headers.putAll(map);
            }
            return this;
        }

        public Builder httpMethod(String str) {
            this.httpMethod = str;
            return this;
        }

        public Builder localization(Localization localization) {
            this.localization = localization;
            return this;
        }

        public Builder post(String str, byte[] bArr) {
            this.httpMethod = "POST";
            this.url = str;
            this.dataToSend = bArr;
            return this;
        }

        public Builder setHeader(String str, String str2) {
            return setHeaders(str, Collections.singletonList(str2));
        }

        public Builder setHeaders(String str, List<String> list) {
            this.headers.remove(str);
            this.headers.put(str, list);
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    public Request(String str, String str2, Map<String, List<String>> map, byte[] bArr, Localization localization, boolean z) {
        Objects.requireNonNull(str, "Request's httpMethod is null");
        this.httpMethod = str;
        Objects.requireNonNull(str2, "Request's url is null");
        this.url = str2;
        this.dataToSend = bArr;
        this.localization = localization;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        if (z && localization != null) {
            linkedHashMap.putAll(getHeadersFromLocalization(localization));
        }
        this.headers = DesugarCollections.unmodifiableMap(linkedHashMap);
    }

    public static Map<String, List<String>> getHeadersFromLocalization(Localization localization) {
        if (localization == null) {
            return Collections.EMPTY_MAP;
        }
        String languageCode = localization.getLanguageCode();
        if (!localization.getCountryCode().isEmpty()) {
            languageCode = localization.getLocalizationCode() + ", " + languageCode + ";q=0.9";
        }
        return Collections.singletonMap("Accept-Language", Collections.singletonList(languageCode));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] dataToSend() {
        return this.dataToSend;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Request request = (Request) obj;
            if (this.httpMethod.equals(request.httpMethod) && this.url.equals(request.url) && this.headers.equals(request.headers) && Arrays.equals(this.dataToSend, request.dataToSend) && Objects.equals(this.localization, request.localization)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.dataToSend) + (Objects.hash(this.httpMethod, this.url, this.headers, this.localization) * 31);
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public String httpMethod() {
        return this.httpMethod;
    }

    public Localization localization() {
        return this.localization;
    }

    public String url() {
        return this.url;
    }

    public /* synthetic */ Request(Builder builder, int i) {
        this(builder);
    }

    private Request(Builder builder) {
        this(builder.httpMethod, builder.url, builder.headers, builder.dataToSend, builder.localization, builder.automaticLocalizationHeader);
    }
}
