package org.schabi.newpipe.extractor.localization;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.n1.d;
import com.github.catvod.spider.merge.n1.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.LocaleCompat;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Localization implements Serializable {
    public static final Localization DEFAULT = new Localization("en", "GB");
    private final String countryCode;
    private final String languageCode;

    public Localization(String str, String str2) {
        this.languageCode = str;
        this.countryCode = str2;
    }

    public static Localization fromLocale(Locale locale) {
        return new Localization(locale.getLanguage(), locale.getCountry());
    }

    public static Optional<Localization> fromLocalizationCode(String str) {
        return LocaleCompat.forLanguageTag(str).map(new g(12));
    }

    public static Locale getLocaleFromThreeLetterCode(String str) throws ParsingException {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length);
        for (String str2 : iSOLanguages) {
            Locale locale = new Locale(str2);
            map.put(locale.getISO3Language(), locale);
        }
        if (map.containsKey(str)) {
            return (Locale) map.get(str);
        }
        throw new ParsingException(b.n("Could not get Locale from this three letter language code", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalArgumentException lambda$listFrom$0(String str) {
        return new IllegalArgumentException(b.n("Not a localization code: ", str));
    }

    public static List<Localization> listFrom(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(fromLocalizationCode(str).orElseThrow(new d(str, 2)));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Localization)) {
            return false;
        }
        Localization localization = (Localization) obj;
        return this.languageCode.equals(localization.languageCode) && Objects.equals(this.countryCode, localization.countryCode);
    }

    public String getCountryCode() {
        String str = this.countryCode;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public String getLocalizationCode() {
        String str = this.languageCode;
        String str2 = this.countryCode;
        return b.z(str, str2 == null ? VideoStream.RESOLUTION_UNKNOWN : b.n("-", str2));
    }

    public int hashCode() {
        return Objects.hashCode(this.countryCode) + (this.languageCode.hashCode() * 31);
    }

    public String toString() {
        return b.A("Localization[", getLocalizationCode(), "]");
    }

    public Localization(String str) {
        this(str, null);
    }
}
