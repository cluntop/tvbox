package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v {
    public final DateTimeFormatter a;
    public boolean b = true;
    public boolean c = true;
    public final ArrayList d;
    public ArrayList e;

    public v(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.e = null;
        this.a = dateTimeFormatter;
        arrayList.add(new b0());
    }

    public static boolean b(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    public final boolean a(char c, char c2) {
        return this.b ? c == c2 : b(c, c2);
    }

    public final b0 c() {
        return (b0) this.d.get(r0.size() - 1);
    }

    public final Long d(com.github.catvod.spider.jdollar.time.temporal.a aVar) {
        return (Long) ((HashMap) c().a).get(aVar);
    }

    public final void e(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        c().b = zoneId;
    }

    public final int f(com.github.catvod.spider.jdollar.time.temporal.p pVar, long j, int i, int i2) {
        Objects.requireNonNull(pVar, "field");
        Long l = (Long) ((HashMap) c().a).put(pVar, Long.valueOf(j));
        return (l == null || l.longValue() == j) ? i2 : ~i;
    }

    public final boolean g(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 <= charSequence.length() && i2 + i3 <= charSequence2.length()) {
            if (this.b) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (charSequence.charAt(i + i4) == charSequence2.charAt(i2 + i4)) {
                    }
                }
                return true;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                char cCharAt = charSequence.charAt(i + i5);
                char cCharAt2 = charSequence2.charAt(i2 + i5);
                if (cCharAt == cCharAt2 || Character.toUpperCase(cCharAt) == Character.toUpperCase(cCharAt2) || Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        return c().toString();
    }
}
