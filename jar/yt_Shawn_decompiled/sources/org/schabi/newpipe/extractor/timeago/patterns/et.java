package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class et extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekundit"};
    private static final String[] MINUTES = {"minut", "minutit"};
    private static final String[] HOURS = {"tund", "tundi"};
    private static final String[] DAYS = {"päev", "päeva"};
    private static final String[] WEEKS = {"nädal", "nädalat"};
    private static final String[] MONTHS = {"kuu", "kuud"};
    private static final String[] YEARS = {"aasta", "aastat"};
    private static final et INSTANCE = new et();

    private et() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static et getInstance() {
        return INSTANCE;
    }
}
