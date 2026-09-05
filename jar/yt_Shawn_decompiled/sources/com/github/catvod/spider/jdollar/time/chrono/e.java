package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneId;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface e extends com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable {
    ChronoZonedDateTime B(ZoneId zoneId);

    /* renamed from: J */
    int compareTo(e eVar);

    l a();

    b e();

    LocalTime toLocalTime();
}
