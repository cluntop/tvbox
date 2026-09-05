package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class pl extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekundy", "sekundę"};
    private static final String[] MINUTES = {"minut", "minuty", "minutę"};
    private static final String[] HOURS = {"godzin", "godziny", "godzinę"};
    private static final String[] DAYS = {"dni", "dzień"};
    private static final String[] WEEKS = {"tydzień", "tygodnie"};
    private static final String[] MONTHS = {"miesiąc", "miesiące", "miesięcy"};
    private static final String[] YEARS = {"lat", "lata", "rok"};
    private static final pl INSTANCE = new pl();

    private pl() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static pl getInstance() {
        return INSTANCE;
    }
}
