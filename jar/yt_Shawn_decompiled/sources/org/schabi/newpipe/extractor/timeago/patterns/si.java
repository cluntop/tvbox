package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class si extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"තත්පර"};
    private static final String[] MINUTES = {"මිනිත්තු"};
    private static final String[] HOURS = {"පැය"};
    private static final String[] DAYS = {"දින"};
    private static final String[] WEEKS = {"සති"};
    private static final String[] MONTHS = {"මාස"};
    private static final String[] YEARS = {"වසර"};
    private static final si INSTANCE = new si();

    private si() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static si getInstance() {
        return INSTANCE;
    }
}
