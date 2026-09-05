package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class de extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"Sekunde", "Sekunden"};
    private static final String[] MINUTES = {"Minute", "Minuten"};
    private static final String[] HOURS = {"Stunde", "Stunden"};
    private static final String[] DAYS = {"Tag", "Tagen"};
    private static final String[] WEEKS = {"Woche", "Wochen"};
    private static final String[] MONTHS = {"Monat", "Monaten"};
    private static final String[] YEARS = {"Jahr", "Jahren"};
    private static final de INSTANCE = new de();

    private de() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static de getInstance() {
        return INSTANCE;
    }
}
