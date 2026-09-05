package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class en_GB extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"second", "seconds", "sec"};
    private static final String[] MINUTES = {"minute", "minutes", "min"};
    private static final String[] HOURS = {"hour", "hours", "hr"};
    private static final String[] DAYS = {"day", "days"};
    private static final String[] WEEKS = {"week", "weeks", "wk"};
    private static final String[] MONTHS = {"month", "months", "mo"};
    private static final String[] YEARS = {"year", "years", "yr"};
    private static final en_GB INSTANCE = new en_GB();

    private en_GB() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static en_GB getInstance() {
        return INSTANCE;
    }
}
