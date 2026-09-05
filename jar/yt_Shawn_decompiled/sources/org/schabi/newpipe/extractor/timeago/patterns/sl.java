package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class sl extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundama", "sekundami", "sekundo"};
    private static final String[] MINUTES = {"minutama", "minutami", "minuto"};
    private static final String[] HOURS = {"urama", "urami", "uro"};
    private static final String[] DAYS = {"dnem", "dnevi", "dnevoma"};
    private static final String[] WEEKS = {"tedni", "tednom", "tednoma"};
    private static final String[] MONTHS = {"mesecem", "mesecema", "meseci"};
    private static final String[] YEARS = {"leti", "letom", "letoma"};
    private static final sl INSTANCE = new sl();

    private sl() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static sl getInstance() {
        return INSTANCE;
    }
}
