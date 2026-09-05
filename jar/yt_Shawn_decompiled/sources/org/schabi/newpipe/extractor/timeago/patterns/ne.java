package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ne extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"सेकेन्ड"};
    private static final String[] MINUTES = {"मिनेट"};
    private static final String[] HOURS = {"घन्टा"};
    private static final String[] DAYS = {"दिन"};
    private static final String[] WEEKS = {"हप्ता"};
    private static final String[] MONTHS = {"महिना"};
    private static final String[] YEARS = {"वर्ष"};
    private static final ne INSTANCE = new ne();

    private ne() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ne getInstance() {
        return INSTANCE;
    }
}
