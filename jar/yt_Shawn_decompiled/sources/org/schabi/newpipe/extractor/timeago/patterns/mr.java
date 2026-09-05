package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class mr extends PatternsHolder {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"सेकंदांपूर्वी", "सेकंदापूर्वी"};
    private static final String[] MINUTES = {"मिनिटांपूर्वी", "मिनिटापूर्वी"};
    private static final String[] HOURS = {"तासांपूर्वी", "तासापूर्वी"};
    private static final String[] DAYS = {"दिवसांपूर्वी", "दिवसापूर्वी"};
    private static final String[] WEEKS = {"आठवड्यांपूर्वी", "आठवड्यापूर्वी"};
    private static final String[] MONTHS = {"महिन्यांपूर्वी", "महिन्यापूर्वी"};
    private static final String[] YEARS = {"वर्षांपूर्वी", "वर्षापूर्वी"};
    private static final mr INSTANCE = new mr();

    private mr() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static mr getInstance() {
        return INSTANCE;
    }
}
