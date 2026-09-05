package org.schabi.newpipe.extractor.localization;

import com.github.catvod.spider.jdollar.time.LocalDateTime;
import org.schabi.newpipe.extractor.timeago.PatternsHolder;
import org.schabi.newpipe.extractor.timeago.PatternsManager;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class TimeAgoPatternsManager {
    private TimeAgoPatternsManager() {
    }

    private static PatternsHolder getPatternsFor(Localization localization) {
        return PatternsManager.getPatterns(localization.getLanguageCode(), localization.getCountryCode());
    }

    public static TimeAgoParser getTimeAgoParserFor(Localization localization, LocalDateTime localDateTime) {
        PatternsHolder patternsFor = getPatternsFor(localization);
        if (patternsFor == null) {
            return null;
        }
        return new TimeAgoParser(patternsFor, localDateTime);
    }

    public static TimeAgoParser getTimeAgoParserFor(Localization localization) {
        return getTimeAgoParserFor(localization, LocalDateTime.now());
    }
}
