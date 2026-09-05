package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class az extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"saniyə"};
    private static final String[] MINUTES = {"dəqiqə"};
    private static final String[] HOURS = {"saat"};
    private static final String[] DAYS = {"gün"};
    private static final String[] WEEKS = {"həftə"};
    private static final String[] MONTHS = {"ay"};
    private static final String[] YEARS = {"il"};
    private static final az INSTANCE = new az();

    private az() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static az getInstance() {
        return INSTANCE;
    }
}
