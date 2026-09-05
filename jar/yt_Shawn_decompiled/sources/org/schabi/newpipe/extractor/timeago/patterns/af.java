package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class af extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekonde", "sekondes"};
    private static final String[] MINUTES = {"minute", "minuut"};
    private static final String[] HOURS = {"ure", "uur"};
    private static final String[] DAYS = {"dae", "dag"};
    private static final String[] WEEKS = {"week", "weke"};
    private static final String[] MONTHS = {"maand", "maande"};
    private static final String[] YEARS = {"jaar"};
    private static final af INSTANCE = new af();

    private af() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static af getInstance() {
        return INSTANCE;
    }
}
