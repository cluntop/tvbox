package org.schabi.newpipe.extractor.timeago.patterns;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class lo extends PatternsHolder {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"ວິນາທີກ່ອນນີ້"};
    private static final String[] MINUTES = {"ນາທີກ່ອນນີ້", "ນາ\u200bທີ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] HOURS = {"ຊົ່ວ\u200bໂມງ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] DAYS = {"ມື້ກ່ອນນີ້"};
    private static final String[] WEEKS = {"ອາ\u200bທິດ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] MONTHS = {"ເດືອນ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] YEARS = {"ປີ\u200bກ່ອນ\u200bນີ້"};
    private static final lo INSTANCE = new lo();

    private lo() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static lo getInstance() {
        return INSTANCE;
    }
}
