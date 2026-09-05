package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class tr extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"saniye"};
    private static final String[] MINUTES = {"dakika"};
    private static final String[] HOURS = {"saat"};
    private static final String[] DAYS = {"gün"};
    private static final String[] WEEKS = {"hafta"};
    private static final String[] MONTHS = {"ay"};
    private static final String[] YEARS = {"yıl"};
    private static final tr INSTANCE = new tr();

    private tr() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static tr getInstance() {
        return INSTANCE;
    }
}
