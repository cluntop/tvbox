package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ms extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"saat"};
    private static final String[] MINUTES = {"minit"};
    private static final String[] HOURS = {"jam"};
    private static final String[] DAYS = {"hari"};
    private static final String[] WEEKS = {"minggu"};
    private static final String[] MONTHS = {"bulan"};
    private static final String[] YEARS = {"tahun"};
    private static final ms INSTANCE = new ms();

    private ms() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ms getInstance() {
        return INSTANCE;
    }
}
