package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class hu extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"másodperce"};
    private static final String[] MINUTES = {"perce"};
    private static final String[] HOURS = {"órája"};
    private static final String[] DAYS = {"napja"};
    private static final String[] WEEKS = {"hete"};
    private static final String[] MONTHS = {"hónapja"};
    private static final String[] YEARS = {"éve"};
    private static final hu INSTANCE = new hu();

    private hu() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static hu getInstance() {
        return INSTANCE;
    }
}
