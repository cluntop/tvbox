package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class cs extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundami", "sekundou"};
    private static final String[] MINUTES = {"minutami", "minutou"};
    private static final String[] HOURS = {"hodinami", "hodinou"};
    private static final String[] DAYS = {"dny", "včera"};
    private static final String[] WEEKS = {"týdnem", "týdny"};
    private static final String[] MONTHS = {"měsícem", "měsíci"};
    private static final String[] YEARS = {"rokem", "roky", "lety"};
    private static final cs INSTANCE = new cs();

    private cs() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static cs getInstance() {
        return INSTANCE;
    }
}
