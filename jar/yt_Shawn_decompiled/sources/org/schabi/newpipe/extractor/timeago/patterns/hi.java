package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class hi extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"सेकंड"};
    private static final String[] MINUTES = {"मिनट"};
    private static final String[] HOURS = {"घंटा", "घंटे"};
    private static final String[] DAYS = {"दिन"};
    private static final String[] WEEKS = {"सप्ताह", "हफ़्ते"};
    private static final String[] MONTHS = {"महीना", "महीने"};
    private static final String[] YEARS = {"वर्ष"};
    private static final hi INSTANCE = new hi();

    private hi() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static hi getInstance() {
        return INSTANCE;
    }
}
