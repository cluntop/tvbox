package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class zu extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"amasekhondi", "isekhondi"};
    private static final String[] MINUTES = {"amaminithi", "iminithi"};
    private static final String[] HOURS = {"amahora", "ihora"};
    private static final String[] DAYS = {"izinsuku", "usuku"};
    private static final String[] WEEKS = {"amaviki", "iviki"};
    private static final String[] MONTHS = {"inyanga", "izinyanga"};
    private static final String[] YEARS = {"iminyaka", "unyaka"};
    private static final zu INSTANCE = new zu();

    private zu() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static zu getInstance() {
        return INSTANCE;
    }
}
