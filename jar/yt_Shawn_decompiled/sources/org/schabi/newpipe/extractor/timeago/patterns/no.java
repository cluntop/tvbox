package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class no extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekunder"};
    private static final String[] MINUTES = {"minutt", "minutter"};
    private static final String[] HOURS = {"time", "timer"};
    private static final String[] DAYS = {"dag", "dager"};
    private static final String[] WEEKS = {"uke", "uker"};
    private static final String[] MONTHS = {"md."};
    private static final String[] YEARS = {"år"};
    private static final no INSTANCE = new no();

    private no() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static no getInstance() {
        return INSTANCE;
    }
}
