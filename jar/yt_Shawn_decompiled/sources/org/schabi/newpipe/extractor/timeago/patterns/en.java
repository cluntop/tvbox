package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class en extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"second", "seconds", "sec"};
    private static final String[] MINUTES = {"minute", "minutes", "min"};
    private static final String[] HOURS = {"hour", "hours", "h"};
    private static final String[] DAYS = {"day", "days", "d"};
    private static final String[] WEEKS = {"week", "weeks", "w"};
    private static final String[] MONTHS = {"month", "months", "mo"};
    private static final String[] YEARS = {"year", "years", "y"};
    private static final en INSTANCE = new en();

    private en() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static en getInstance() {
        return INSTANCE;
    }
}
