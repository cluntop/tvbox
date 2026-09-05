package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ta extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"வினாடி", "வினாடிகளுக்கு"};
    private static final String[] MINUTES = {"நிமிடங்கள்", "நிமிடம்"};
    private static final String[] HOURS = {"மணிநேரத்திற்கு"};
    private static final String[] DAYS = {"நாட்களுக்கு", "நாளுக்கு"};
    private static final String[] WEEKS = {"வாரங்களுக்கு", "வாரம்"};
    private static final String[] MONTHS = {"மாதங்கள்", "மாதம்"};
    private static final String[] YEARS = {"ஆண்டு", "ஆண்டுகளுக்கு"};
    private static final ta INSTANCE = new ta();

    private ta() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ta getInstance() {
        return INSTANCE;
    }
}
