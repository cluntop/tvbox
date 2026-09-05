package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class sv extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekunder"};
    private static final String[] MINUTES = {"minut", "minuter"};
    private static final String[] HOURS = {"timmar", "timme"};
    private static final String[] DAYS = {"dag", "dagar"};
    private static final String[] WEEKS = {"vecka", "veckor"};
    private static final String[] MONTHS = {"månad", "månader"};
    private static final String[] YEARS = {"år"};
    private static final sv INSTANCE = new sv();

    private sv() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static sv getInstance() {
        return INSTANCE;
    }
}
