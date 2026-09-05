package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ur extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"سیکنڈ", "سیکنڈز"};
    private static final String[] MINUTES = {"منٹ", "منٹس"};
    private static final String[] HOURS = {"گھنٹہ", "گھنٹے"};
    private static final String[] DAYS = {"دن"};
    private static final String[] WEEKS = {"ہفتہ", "ہفتے"};
    private static final String[] MONTHS = {"ماہ"};
    private static final String[] YEARS = {"سال"};
    private static final ur INSTANCE = new ur();

    private ur() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ur getInstance() {
        return INSTANCE;
    }
}
