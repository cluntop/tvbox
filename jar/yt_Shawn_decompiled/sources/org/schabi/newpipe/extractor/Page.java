package org.schabi.newpipe.extractor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Page implements Serializable {
    private final byte[] body;
    private final Map<String, String> cookies;
    private final String id;
    private final List<String> ids;
    private final String url;

    public Page(String str, String str2, List<String> list, Map<String, String> map, byte[] bArr) {
        this.url = str;
        this.id = str2;
        this.ids = list;
        this.cookies = map;
        this.body = bArr;
    }

    public static boolean isValid(Page page) {
        if (page != null) {
            return (Utils.isNullOrEmpty(page.getUrl()) && Utils.isNullOrEmpty(page.getIds())) ? false : true;
        }
        return false;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Map<String, String> getCookies() {
        return this.cookies;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getIds() {
        return this.ids;
    }

    public String getUrl() {
        return this.url;
    }

    public Page(String str) {
        this(str, null, null, null, null);
    }

    public Page(String str, String str2) {
        this(str, str2, null, null, null);
    }

    public Page(String str, String str2, byte[] bArr) {
        this(str, str2, null, null, bArr);
    }

    public Page(String str, byte[] bArr) {
        this(str, null, null, null, bArr);
    }

    public Page(String str, Map<String, String> map) {
        this(str, null, null, map, null);
    }

    public Page(List<String> list) {
        this(null, null, list, null, null);
    }

    public Page(List<String> list, Map<String, String> map) {
        this(null, null, list, map, null);
    }
}
