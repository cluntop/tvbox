package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ka extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"წამის"};
    private static final String[] MINUTES = {"წუთის"};
    private static final String[] HOURS = {"საათის"};
    private static final String[] DAYS = {"დღის"};
    private static final String[] WEEKS = {"კვირის"};
    private static final String[] MONTHS = {"თვის"};
    private static final String[] YEARS = {"წლის"};
    private static final ka INSTANCE = new ka();

    private ka() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ka getInstance() {
        return INSTANCE;
    }
}
