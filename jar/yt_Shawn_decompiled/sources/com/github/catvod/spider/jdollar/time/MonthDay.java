package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.format.c0;
import com.github.catvod.spider.jdollar.time.format.u;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MonthDay implements TemporalAccessor, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<MonthDay>, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = -939150713474957432L;
    public final int a;
    public final int b;

    static {
        u uVar = new u();
        uVar.e("--");
        uVar.m(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR, 2);
        uVar.d('-');
        uVar.m(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH, 2);
        uVar.r(Locale.getDefault(), c0.SMART, null);
    }

    public MonthDay(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static MonthDay of(int i, int i2) {
        i iVarV = i.V(i);
        Objects.requireNonNull(iVarV, "month");
        com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH.E(i2);
        if (i2 <= iVarV.U()) {
            return new MonthDay(iVarV.getValue(), i2);
        }
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + i2 + " is not valid for month " + iVarV.name());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 13, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        int i;
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i2 = j.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i2 == 1) {
            i = this.b;
        } else {
            if (i2 != 2) {
                throw new r(b.a("Unsupported field: ", pVar));
            }
            i = this.a;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(MonthDay monthDay) {
        MonthDay monthDay2 = monthDay;
        int i = this.a - monthDay2.a;
        return i == 0 ? this.b - monthDay2.b : i;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR || pVar == com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH : pVar != null && pVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MonthDay) {
            MonthDay monthDay = (MonthDay) obj;
            if (this.a == monthDay.a && this.b == monthDay.b) {
                return true;
            }
        }
        return false;
    }

    public int getDayOfMonth() {
        return this.b;
    }

    public int getMonthValue() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return j(pVar).a(E(pVar), pVar);
    }

    public final int hashCode() {
        return (this.a << 6) + this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR) {
            return pVar.o();
        }
        if (pVar != com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH) {
            return q.d(this, pVar);
        }
        i iVarV = i.V(this.a);
        iVarV.getClass();
        int i = h.a[iVarV.ordinal()];
        return s.g(1L, i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : 28, i.V(this.a).U());
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        if (!com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(lVar).equals(t.c)) {
            com.github.catvod.spider.jdollar.nio.file.b.k("Adjustment only supported on ISO date-time");
            return null;
        }
        com.github.catvod.spider.jdollar.time.temporal.l lVarB = lVar.b(this.a, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR);
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH;
        return lVarB.b(Math.min(lVarB.j(aVar).d, this.b), aVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.a < 10 ? "0" : VideoStream.RESOLUTION_UNKNOWN);
        sb.append(this.a);
        sb.append(this.b < 10 ? "-0" : "-");
        sb.append(this.b);
        return sb.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.b ? t.c : q.c(this, mVar);
    }
}
