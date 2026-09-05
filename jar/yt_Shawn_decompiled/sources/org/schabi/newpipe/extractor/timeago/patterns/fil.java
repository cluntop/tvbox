package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class fil extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"segundo"};
    private static final String[] MINUTES = {"minuto"};
    private static final String[] HOURS = {"oras"};
    private static final String[] DAYS = {"araw"};
    private static final String[] WEEKS = {"linggo"};
    private static final String[] MONTHS = {"buwan"};
    private static final String[] YEARS = {"taon"};
    private static final fil INSTANCE = new fil();

    private fil() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static fil getInstance() {
        return INSTANCE;
    }
}
