package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ml extends PatternsHolder {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"സെക്കന്റ്", "സെക്കൻഡ്"};
    private static final String[] MINUTES = {"മിനിറ്റ്"};
    private static final String[] HOURS = {"മണിക്കൂർ"};
    private static final String[] DAYS = {"ദിവസം"};
    private static final String[] WEEKS = {"ആഴ്ച", "ആഴ്\u200cച"};
    private static final String[] MONTHS = {"മാസം"};
    private static final String[] YEARS = {"വർഷം"};
    private static final ml INSTANCE = new ml();

    private ml() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ml getInstance() {
        return INSTANCE;
    }
}
