package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class my extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"စက္ကန့်"};
    private static final String[] MINUTES = {"မိနစ်"};
    private static final String[] HOURS = {"နာရီ"};
    private static final String[] DAYS = {"ရက်"};
    private static final String[] WEEKS = {"ပတ်"};
    private static final String[] MONTHS = {"လ"};
    private static final String[] YEARS = {"နှစ်"};
    private static final my INSTANCE = new my();

    private my() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static my getInstance() {
        return INSTANCE;
    }
}
