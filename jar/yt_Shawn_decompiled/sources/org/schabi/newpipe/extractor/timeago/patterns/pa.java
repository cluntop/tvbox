package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class pa extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"ਸਕਿੰਟ"};
    private static final String[] MINUTES = {"ਮਿੰਟ"};
    private static final String[] HOURS = {"ਘੰਟਾ", "ਘੰਟੇ"};
    private static final String[] DAYS = {"ਦਿਨ"};
    private static final String[] WEEKS = {"ਹਫ਼ਤਾ", "ਹਫ਼ਤੇ"};
    private static final String[] MONTHS = {"ਮਹੀਨਾ", "ਮਹੀਨੇ"};
    private static final String[] YEARS = {"ਸਾਲ"};
    private static final pa INSTANCE = new pa();

    private pa() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static pa getInstance() {
        return INSTANCE;
    }
}
