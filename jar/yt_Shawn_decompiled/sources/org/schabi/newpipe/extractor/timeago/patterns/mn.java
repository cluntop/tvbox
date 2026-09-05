package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class mn extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секундын"};
    private static final String[] MINUTES = {"минутын"};
    private static final String[] HOURS = {"цагийн"};
    private static final String[] DAYS = {"өдрийн"};
    private static final String[] WEEKS = {"долоо", "хоногийн"};
    private static final String[] MONTHS = {"сарын"};
    private static final String[] YEARS = {"жилийн"};
    private static final mn INSTANCE = new mn();

    private mn() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static mn getInstance() {
        return INSTANCE;
    }
}
