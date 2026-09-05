package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class nl extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"seconde", "seconden"};
    private static final String[] MINUTES = {"minuten", "minuut"};
    private static final String[] HOURS = {"uur"};
    private static final String[] DAYS = {"dag", "dagen"};
    private static final String[] WEEKS = {"week", "weken"};
    private static final String[] MONTHS = {"maand", "maanden"};
    private static final String[] YEARS = {"jaar"};
    private static final nl INSTANCE = new nl();

    private nl() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static nl getInstance() {
        return INSTANCE;
    }
}
