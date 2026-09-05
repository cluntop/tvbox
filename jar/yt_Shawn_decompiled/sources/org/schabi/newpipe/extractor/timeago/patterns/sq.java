package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class sq extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekonda", "sekondë"};
    private static final String[] MINUTES = {"minuta", "minutë"};
    private static final String[] HOURS = {"orë"};
    private static final String[] DAYS = {"ditë"};
    private static final String[] WEEKS = {"javë"};
    private static final String[] MONTHS = {"muaj"};
    private static final String[] YEARS = {"vit", "vjet"};
    private static final sq INSTANCE = new sq();

    private sq() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static sq getInstance() {
        return INSTANCE;
    }
}
