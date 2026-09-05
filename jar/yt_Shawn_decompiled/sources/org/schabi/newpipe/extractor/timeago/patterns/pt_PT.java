package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class pt_PT extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"segundo", "segundos"};
    private static final String[] MINUTES = {"minuto", "minutos"};
    private static final String[] HOURS = {"hora", "horas"};
    private static final String[] DAYS = {"dia", "dias"};
    private static final String[] WEEKS = {"semana", "semanas"};
    private static final String[] MONTHS = {"meses", "mês"};
    private static final String[] YEARS = {"ano", "anos"};
    private static final pt_PT INSTANCE = new pt_PT();

    private pt_PT() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static pt_PT getInstance() {
        return INSTANCE;
    }
}
