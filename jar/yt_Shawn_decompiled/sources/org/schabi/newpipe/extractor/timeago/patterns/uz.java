package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class uz extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"soniya"};
    private static final String[] MINUTES = {"daqiqa"};
    private static final String[] HOURS = {"soat"};
    private static final String[] DAYS = {"kun"};
    private static final String[] WEEKS = {"hafta"};
    private static final String[] MONTHS = {"oy"};
    private static final String[] YEARS = {"yil"};
    private static final uz INSTANCE = new uz();

    private uz() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static uz getInstance() {
        return INSTANCE;
    }
}
