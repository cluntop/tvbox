package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class hy extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"վայրկյան"};
    private static final String[] MINUTES = {"րոպե"};
    private static final String[] HOURS = {"ժամ"};
    private static final String[] DAYS = {"օր"};
    private static final String[] WEEKS = {"շաբաթ"};
    private static final String[] MONTHS = {"ամիս"};
    private static final String[] YEARS = {"տարի"};
    private static final hy INSTANCE = new hy();

    private hy() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static hy getInstance() {
        return INSTANCE;
    }
}
