package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class fr extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"seconde", "secondes"};
    private static final String[] MINUTES = {"minute", "minutes"};
    private static final String[] HOURS = {"heure", "heures"};
    private static final String[] DAYS = {"jour", "jours"};
    private static final String[] WEEKS = {"semaine", "semaines"};
    private static final String[] MONTHS = {"mois"};
    private static final String[] YEARS = {"an", "ans"};
    private static final fr INSTANCE = new fr();

    private fr() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static fr getInstance() {
        return INSTANCE;
    }
}
