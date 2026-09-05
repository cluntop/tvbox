package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w {
    public final TemporalAccessor a;
    public final DateTimeFormatter b;
    public int c;

    public w(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        com.github.catvod.spider.jdollar.time.chrono.l lVar = dateTimeFormatter.e;
        if (lVar != null) {
            com.github.catvod.spider.jdollar.time.chrono.l lVar2 = (com.github.catvod.spider.jdollar.time.chrono.l) temporalAccessor.y(com.github.catvod.spider.jdollar.time.temporal.q.b);
            ZoneId zoneId = (ZoneId) temporalAccessor.y(com.github.catvod.spider.jdollar.time.temporal.q.a);
            com.github.catvod.spider.jdollar.time.chrono.b bVarC = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            Objects.equals(null, zoneId);
            if (lVar != null) {
                com.github.catvod.spider.jdollar.time.chrono.l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (temporalAccessor.d(com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY)) {
                        bVarC = lVar3.C(temporalAccessor);
                    } else if (lVar != com.github.catvod.spider.jdollar.time.chrono.t.c || lVar2 != null) {
                        for (com.github.catvod.spider.jdollar.time.temporal.a aVar : com.github.catvod.spider.jdollar.time.temporal.a.values()) {
                            if (aVar.isDateBased() && temporalAccessor.d(aVar)) {
                                throw new DateTimeException("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new com.github.catvod.spider.jdollar.nio.file.m(bVarC, temporalAccessor, lVar3, zoneId);
            }
        }
        this.a = temporalAccessor;
        this.b = dateTimeFormatter;
    }

    public final Long a(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        int i = this.c;
        TemporalAccessor temporalAccessor = this.a;
        if (i <= 0 || temporalAccessor.d(pVar)) {
            return Long.valueOf(temporalAccessor.E(pVar));
        }
        return null;
    }

    public final Object b(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        TemporalAccessor temporalAccessor = this.a;
        Object objY = temporalAccessor.y(mVar);
        if (objY != null || this.c != 0) {
            return objY;
        }
        throw new DateTimeException("Unable to extract " + mVar + " from temporal " + temporalAccessor);
    }

    public final String toString() {
        return this.a.toString();
    }
}
