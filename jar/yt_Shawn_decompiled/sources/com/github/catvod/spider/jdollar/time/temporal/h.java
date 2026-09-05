package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.Duration;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum h implements TemporalUnit {
    WEEK_BASED_YEARS("WeekBasedYears", Duration.i(31556952, 0)),
    QUARTER_YEARS("QuarterYears", Duration.i(7889238, 0));

    public final String a;
    public final Duration b;

    h(String str, Duration duration) {
        this.a = str;
        this.b = duration;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalUnit
    public final Duration getDuration() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalUnit
    public final l h(l lVar, long j) {
        int i = b.a[ordinal()];
        if (i == 1) {
            return lVar.b(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(lVar.h(r0), j), i.c);
        }
        if (i == 2) {
            return lVar.c(j / 4, ChronoUnit.YEARS).c((j % 4) * 3, ChronoUnit.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalUnit
    public final boolean isDateBased() {
        throw null;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
