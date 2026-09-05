package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class te extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"సెకను", "సెకన్ల"};
    private static final String[] MINUTES = {"నిమిషం", "నిమిషాల"};
    private static final String[] HOURS = {"గంట", "గంటల"};
    private static final String[] DAYS = {"రోజు", "రోజుల"};
    private static final String[] WEEKS = {"వారం", "వారాల"};
    private static final String[] MONTHS = {"నెల", "నెలల"};
    private static final String[] YEARS = {"సంవత్సరం", "సంవత్సరాల"};
    private static final te INSTANCE = new te();

    private te() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static te getInstance() {
        return INSTANCE;
    }
}
