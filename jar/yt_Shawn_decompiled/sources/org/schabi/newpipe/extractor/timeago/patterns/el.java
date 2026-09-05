package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class el extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"δευτερόλεπτα", "δευτερόλεπτο"};
    private static final String[] MINUTES = {"λεπτά", "λεπτό"};
    private static final String[] HOURS = {"ώρα", "ώρες"};
    private static final String[] DAYS = {"ημέρα", "ημέρες"};
    private static final String[] WEEKS = {"εβδομάδα", "εβδομάδες"};
    private static final String[] MONTHS = {"μήνα", "μήνες"};
    private static final String[] YEARS = {"χρόνια", "χρόνο"};
    private static final el INSTANCE = new el();

    private el() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static el getInstance() {
        return INSTANCE;
    }
}
