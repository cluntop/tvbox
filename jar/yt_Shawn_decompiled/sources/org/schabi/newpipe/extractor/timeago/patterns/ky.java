package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ky extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунд"};
    private static final String[] MINUTES = {"мүнөт"};
    private static final String[] HOURS = {"саат"};
    private static final String[] DAYS = {"күн"};
    private static final String[] WEEKS = {"апта"};
    private static final String[] MONTHS = {"ай"};
    private static final String[] YEARS = {"жыл"};
    private static final ky INSTANCE = new ky();

    private ky() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ky getInstance() {
        return INSTANCE;
    }
}
