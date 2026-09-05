package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class q {
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m a = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(8);
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m b = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(9);
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m c = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(10);
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m d = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(11);
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m e = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(12);
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m f = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(13);
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m g = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(14);

    public static int a(TemporalAccessor temporalAccessor, p pVar) {
        s sVarJ = temporalAccessor.j(pVar);
        if (!sVarJ.d()) {
            throw new r("Invalid field " + pVar + " for get() method, use getLong() instead");
        }
        long jE = temporalAccessor.E(pVar);
        if (sVarJ.e(jE)) {
            return (int) jE;
        }
        throw new DateTimeException("Invalid value for " + pVar + " (valid values " + sVarJ + "): " + jE);
    }

    public static l b(l lVar, long j, TemporalUnit temporalUnit) {
        long j2;
        if (j == Long.MIN_VALUE) {
            lVar = lVar.c(Long.MAX_VALUE, temporalUnit);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return lVar.c(j2, temporalUnit);
    }

    public static Object c(TemporalAccessor temporalAccessor, com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        if (mVar == a || mVar == b || mVar == c) {
            return null;
        }
        return mVar.f(temporalAccessor);
    }

    public static s d(TemporalAccessor temporalAccessor, p pVar) {
        if (!(pVar instanceof a)) {
            Objects.requireNonNull(pVar, "field");
            return pVar.i(temporalAccessor);
        }
        if (temporalAccessor.d(pVar)) {
            return ((a) pVar).b;
        }
        throw new r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
    }

    public static /* synthetic */ int e(int i) {
        int i2 = i % 7;
        if (i2 == 0) {
            return 0;
        }
        return (((i ^ 7) >> 31) | 1) > 0 ? i2 : i2 + 7;
    }
}
