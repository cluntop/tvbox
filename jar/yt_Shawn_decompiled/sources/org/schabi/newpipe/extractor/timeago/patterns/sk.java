package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class sk extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundami", "sekundou"};
    private static final String[] MINUTES = {"minútami", "minútou"};
    private static final String[] HOURS = {"hodinami", "hodinou"};
    private static final String[] DAYS = {"dňami", "dňom"};
    private static final String[] WEEKS = {"týždňami", "týždňom"};
    private static final String[] MONTHS = {"mesiacmi", "mesiacom"};
    private static final String[] YEARS = {"rokmi", "rokom"};
    private static final sk INSTANCE = new sk();

    private sk() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static sk getInstance() {
        return INSTANCE;
    }
}
