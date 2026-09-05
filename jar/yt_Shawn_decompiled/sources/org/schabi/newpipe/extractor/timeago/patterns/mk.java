package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class mk extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунда", "секунди"};
    private static final String[] MINUTES = {"минута", "минути"};
    private static final String[] HOURS = {"час", "часа"};
    private static final String[] DAYS = {"ден", "дена"};
    private static final String[] WEEKS = {"недела", "недели"};
    private static final String[] MONTHS = {"месец", "месеци"};
    private static final String[] YEARS = {"година", "години"};
    private static final mk INSTANCE = new mk();

    private mk() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static mk getInstance() {
        return INSTANCE;
    }
}
