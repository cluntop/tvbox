package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class be extends PatternsHolder {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунд", "секунду", "секунды"};
    private static final String[] MINUTES = {"хвілін", "хвіліну", "хвіліны"};
    private static final String[] HOURS = {"гадзін", "гадзіну", "гадзіны"};
    private static final String[] DAYS = {"дзень", "дзён", "дня", "дні"};
    private static final String[] WEEKS = {"тыдзень", "тыдня", "тыдні"};
    private static final String[] MONTHS = {"месяц", "месяца", "месяцы", "месяцаў"};
    private static final String[] YEARS = {"год", "года", "гады", "гадоў"};
    private static final be INSTANCE = new be();

    private be() {
        super(" ", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static be getInstance() {
        return INSTANCE;
    }
}
