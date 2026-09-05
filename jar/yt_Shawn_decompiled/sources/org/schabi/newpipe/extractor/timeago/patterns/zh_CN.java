package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class zh_CN extends PatternsHolder {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"秒前"};
    private static final String[] MINUTES = {"分钟前"};
    private static final String[] HOURS = {"小时前"};
    private static final String[] DAYS = {"天前"};
    private static final String[] WEEKS = {"周前"};
    private static final String[] MONTHS = {"个月前"};
    private static final String[] YEARS = {"年前"};
    private static final zh_CN INSTANCE = new zh_CN();

    private zh_CN() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static zh_CN getInstance() {
        return INSTANCE;
    }
}
