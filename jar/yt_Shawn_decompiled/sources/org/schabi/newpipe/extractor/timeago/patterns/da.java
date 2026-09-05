package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class da extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekunder"};
    private static final String[] MINUTES = {"minut", "minutter"};
    private static final String[] HOURS = {"time", "timer"};
    private static final String[] DAYS = {"dag", "dage"};
    private static final String[] WEEKS = {"uge", "uger"};
    private static final String[] MONTHS = {"måned", "måneder"};
    private static final String[] YEARS = {"år"};
    private static final da INSTANCE = new da();

    private da() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static da getInstance() {
        return INSTANCE;
    }
}
