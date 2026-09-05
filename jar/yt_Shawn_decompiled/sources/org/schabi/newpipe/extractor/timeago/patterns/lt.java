package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class lt extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundes", "sekundę", "sekundžių"};
    private static final String[] MINUTES = {"minutes", "minutę", "minučių"};
    private static final String[] HOURS = {"valandas", "valandą", "valandų"};
    private static final String[] DAYS = {"dienas", "dieną"};
    private static final String[] WEEKS = {"savaites", "savaitę"};
    private static final String[] MONTHS = {"mėnesius", "mėnesių", "mėnesį"};
    private static final String[] YEARS = {"metus", "metų"};
    private static final lt INSTANCE = new lt();

    private lt() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static lt getInstance() {
        return INSTANCE;
    }
}
