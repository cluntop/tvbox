package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r extends i {
    public final char g;
    public final int h;

    public r(char c, int i, int i2, int i3, int i4) {
        super(null, i2, i3, d0.NOT_NEGATIVE, i4);
        this.g = c;
        this.h = i;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final i d() {
        if (this.e == -1) {
            return this;
        }
        return new r(this.g, this.h, this.b, this.c, -1);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final i e(int i) {
        return new r(this.g, this.h, this.b, this.c, this.e + i);
    }

    public final i f(Locale locale) {
        com.github.catvod.spider.jdollar.time.temporal.t tVar;
        ConcurrentHashMap concurrentHashMap = com.github.catvod.spider.jdollar.time.temporal.u.g;
        Objects.requireNonNull(locale, "locale");
        com.github.catvod.spider.jdollar.time.temporal.u uVarA = com.github.catvod.spider.jdollar.time.temporal.u.a(com.github.catvod.spider.jdollar.time.c.a[((((int) ((r7.getFirstDayOfWeek() - 1) % 7)) + 7) + com.github.catvod.spider.jdollar.time.c.SUNDAY.ordinal()) % 7], Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
        char c = this.g;
        if (c == 'W') {
            tVar = uVarA.d;
        } else {
            if (c == 'Y') {
                com.github.catvod.spider.jdollar.time.temporal.t tVar2 = uVarA.f;
                int i = this.h;
                if (i == 2) {
                    return new o(tVar2, 2, 2, o.h, this.e);
                }
                return new i(tVar2, i, 19, i < 4 ? d0.NORMAL : d0.EXCEEDS_PAD, this.e);
            }
            if (c == 'c' || c == 'e') {
                tVar = uVarA.c;
            } else {
                if (c != 'w') {
                    throw new IllegalStateException("unreachable");
                }
                tVar = uVarA.e;
            }
        }
        return new i(tVar, this.b, this.c, d0.NOT_NEGATIVE, this.e);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i, com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        return f(wVar.b.b).h(wVar, sb);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i, com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        return f(vVar.a.b).i(vVar, charSequence, i);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Localized(");
        int i = this.h;
        char c = this.g;
        if (c != 'Y') {
            if (c == 'W') {
                sb.append("WeekOfMonth");
            } else if (c == 'c' || c == 'e') {
                sb.append("DayOfWeek");
            } else if (c == 'w') {
                sb.append("WeekOfWeekBasedYear");
            }
            sb.append(",");
            sb.append(i);
        } else if (i == 1) {
            sb.append("WeekBasedYear");
        } else if (i == 2) {
            sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
        } else {
            sb.append("WeekBasedYear,");
            sb.append(i);
            sb.append(",19,");
            sb.append(i < 4 ? d0.NORMAL : d0.EXCEEDS_PAD);
        }
        sb.append(")");
        return sb.toString();
    }
}
