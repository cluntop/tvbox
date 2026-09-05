package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.format.b0;
import com.github.catvod.spider.jdollar.time.format.c0;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface p {
    l A(l lVar, long j);

    boolean h(TemporalAccessor temporalAccessor);

    s i(TemporalAccessor temporalAccessor);

    boolean isDateBased();

    TemporalAccessor j(Map map, b0 b0Var, c0 c0Var);

    s o();

    long y(TemporalAccessor temporalAccessor);
}
