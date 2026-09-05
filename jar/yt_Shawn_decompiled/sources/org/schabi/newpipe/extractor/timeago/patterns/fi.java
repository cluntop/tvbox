package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class fi extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekunti", "sekuntia"};
    private static final String[] MINUTES = {"minuutti", "minuuttia"};
    private static final String[] HOURS = {"tunti", "tuntia"};
    private static final String[] DAYS = {"päivä", "päivää"};
    private static final String[] WEEKS = {"viikko", "viikkoa"};
    private static final String[] MONTHS = {"kuukausi", "kuukautta"};
    private static final String[] YEARS = {"vuosi", "vuotta"};
    private static final fi INSTANCE = new fi();

    private fi() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static fi getInstance() {
        return INSTANCE;
    }
}
