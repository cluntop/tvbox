package org.schabi.newpipe.extractor.localization;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ContentCountry implements Serializable {
    public static final ContentCountry DEFAULT = new ContentCountry(Localization.DEFAULT.getCountryCode());
    private final String countryCode;

    public ContentCountry(String str) {
        this.countryCode = str;
    }

    public static List<ContentCountry> listFrom(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(new ContentCountry(str));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentCountry) {
            return this.countryCode.equals(((ContentCountry) obj).countryCode);
        }
        return false;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public int hashCode() {
        return this.countryCode.hashCode();
    }

    public String toString() {
        return getCountryCode();
    }
}
