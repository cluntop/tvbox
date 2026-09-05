package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class gu extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"સેકંડ"};
    private static final String[] MINUTES = {"મિનિટ"};
    private static final String[] HOURS = {"કલાક"};
    private static final String[] DAYS = {"દિવસ"};
    private static final String[] WEEKS = {"અઠવાડિયા"};
    private static final String[] MONTHS = {"મહિના"};
    private static final String[] YEARS = {"વર્ષ"};
    private static final gu INSTANCE = new gu();

    private gu() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static gu getInstance() {
        return INSTANCE;
    }
}
