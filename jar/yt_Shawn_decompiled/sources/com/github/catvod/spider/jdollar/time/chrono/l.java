package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface l extends Comparable {
    b C(TemporalAccessor temporalAccessor);

    e D(LocalDateTime localDateTime);

    b K(int i, int i2, int i3);

    b M(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var);

    ChronoZonedDateTime N(Instant instant, ZoneId zoneId);

    boolean Q(long j);

    boolean equals(Object obj);

    b f(long j);

    String getId();

    int hashCode();

    String l();

    b m(int i, int i2);

    com.github.catvod.spider.jdollar.time.temporal.s s(com.github.catvod.spider.jdollar.time.temporal.a aVar);

    String toString();

    List u();

    n v(int i);

    int w(n nVar, int i);
}
