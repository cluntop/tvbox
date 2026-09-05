package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.Duration;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.j(1)),
    MICROS("Micros", Duration.j(1000)),
    MILLIS("Millis", Duration.j(1000000)),
    SECONDS("Seconds", Duration.i(1, 0)),
    MINUTES("Minutes", Duration.i(60, 0)),
    HOURS("Hours", Duration.i(3600, 0)),
    HALF_DAYS("HalfDays", Duration.i(43200, 0)),
    DAYS("Days", Duration.i(86400, 0)),
    WEEKS("Weeks", Duration.i(604800, 0)),
    MONTHS("Months", Duration.i(2629746, 0)),
    YEARS("Years", Duration.i(31556952, 0)),
    DECADES("Decades", Duration.i(315569520, 0)),
    CENTURIES("Centuries", Duration.i(3155695200L, 0)),
    MILLENNIA("Millennia", Duration.i(31556952000L, 0)),
    ERAS("Eras", Duration.i(31556952000000000L, 0)),
    FOREVER("Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));

    public final String a;
    public final Duration b;

    ChronoUnit(String str, Duration duration) {
        this.a = str;
        this.b = duration;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalUnit
    public final Duration getDuration() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalUnit
    public final l h(l lVar, long j) {
        return lVar.c(j, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalUnit
    public boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
