package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class sr_Latn extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekunde", "sekundi"};
    private static final String[] MINUTES = {"minuta"};
    private static final String[] HOURS = {"sat", "sati", "sata"};
    private static final String[] DAYS = {"Pre 1 dan", "Pre 2 dana", "Pre 3 dana", "Pre 4 dana", "Pre 5 dana", "Pre 6 dana"};
    private static final String[] WEEKS = {"nedelja", "nedelje", "nedelju"};
    private static final String[] MONTHS = {"mesec", "meseci", "meseca"};
    private static final String[] YEARS = {"godine", "godina", "godinu"};
    private static final sr_Latn INSTANCE = new sr_Latn();

    private sr_Latn() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static sr_Latn getInstance() {
        return INSTANCE;
    }
}
