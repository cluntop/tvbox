package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class kk extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунд"};
    private static final String[] MINUTES = {"минут"};
    private static final String[] HOURS = {"сағат"};
    private static final String[] DAYS = {"күн"};
    private static final String[] WEEKS = {"апта"};
    private static final String[] MONTHS = {"ай"};
    private static final String[] YEARS = {"жыл"};
    private static final kk INSTANCE = new kk();

    private kk() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static kk getInstance() {
        return INSTANCE;
    }
}
