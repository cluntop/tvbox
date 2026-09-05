package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class lv extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundes", "sekundēm"};
    private static final String[] MINUTES = {"minūtes", "minūtēm", "minūtes"};
    private static final String[] HOURS = {"stundas", "stundām"};
    private static final String[] DAYS = {"dienas", "dienām"};
    private static final String[] WEEKS = {"nedēļas", "nedēļām"};
    private static final String[] MONTHS = {"mēneša", "mēnešiem"};
    private static final String[] YEARS = {"gada", "gadiem"};
    private static final lv INSTANCE = new lv();

    private lv() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static lv getInstance() {
        return INSTANCE;
    }
}
