package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class fa extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"ثانیه"};
    private static final String[] MINUTES = {"دقیقه"};
    private static final String[] HOURS = {"ساعت"};
    private static final String[] DAYS = {"روز"};
    private static final String[] WEEKS = {"هفته"};
    private static final String[] MONTHS = {"ماه"};
    private static final String[] YEARS = {"سال"};
    private static final fa INSTANCE = new fa();

    private fa() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static fa getInstance() {
        return INSTANCE;
    }
}
