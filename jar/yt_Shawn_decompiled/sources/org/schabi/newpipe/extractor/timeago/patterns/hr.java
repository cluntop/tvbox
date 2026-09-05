package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class hr extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekunde", "sekundi", "sekundu"};
    private static final String[] MINUTES = {"minuta", "minute", "minutu"};
    private static final String[] HOURS = {"sat", "sata", "sati"};
    private static final String[] DAYS = {"dan", "dana"};
    private static final String[] WEEKS = {"tjedan", "tjedna"};
    private static final String[] MONTHS = {"mjesec", "mjeseca", "mjeseci"};
    private static final String[] YEARS = {"godina", "godine", "godinu"};
    private static final hr INSTANCE = new hr();

    private hr() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static hr getInstance() {
        return INSTANCE;
    }
}
