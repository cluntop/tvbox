package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class it extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"secondi", "secondo"};
    private static final String[] MINUTES = {"minuti", "minuto"};
    private static final String[] HOURS = {"ora", "ore"};
    private static final String[] DAYS = {"giorni", "giorno"};
    private static final String[] WEEKS = {"settimana", "settimane"};
    private static final String[] MONTHS = {"mese", "mesi"};
    private static final String[] YEARS = {"anni", "anno"};
    private static final it INSTANCE = new it();

    private it() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static it getInstance() {
        return INSTANCE;
    }
}
