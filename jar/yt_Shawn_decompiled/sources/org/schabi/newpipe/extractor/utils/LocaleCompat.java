package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.util.Optional;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class LocaleCompat {
    private LocaleCompat() {
    }

    public static Optional<Locale> forLanguageTag(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return Optional.of(new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]));
            }
            if (strArrSplit.length > 1) {
                return Optional.of(new Locale(strArrSplit[0], strArrSplit[1]));
            }
            if (strArrSplit.length == 1) {
                return Optional.of(new Locale(strArrSplit[0]));
            }
        } else {
            if (!str.contains("_")) {
                return Optional.of(new Locale(str));
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return Optional.of(new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]));
            }
            if (strArrSplit2.length > 1) {
                return Optional.of(new Locale(strArrSplit2[0], strArrSplit2[1]));
            }
            if (strArrSplit2.length == 1) {
                return Optional.of(new Locale(strArrSplit2[0]));
            }
        }
        return Optional.empty();
    }
}
