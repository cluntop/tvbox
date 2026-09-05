package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Period implements com.github.catvod.spider.jdollar.time.temporal.o, Serializable {
    public static final Period d = new Period(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;
    public final int a;
    public final int b;
    public final int c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    public Period(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static Period a(int i, int i2, int i3) {
        return ((i | i2) | i3) == 0 ? d : new Period(i, i2, i3);
    }

    public static Period of(int i, int i2, int i3) {
        return a(i, i2, i3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 14, this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            if (this.a == period.a && this.b == period.b && this.c == period.c) {
                return true;
            }
        }
        return false;
    }

    public int getDays() {
        return this.c;
    }

    public int getMonths() {
        return this.b;
    }

    public int getYears() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.o
    public final com.github.catvod.spider.jdollar.time.temporal.l h(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        Objects.requireNonNull(lVar, "temporal");
        com.github.catvod.spider.jdollar.time.chrono.l lVar2 = (com.github.catvod.spider.jdollar.time.chrono.l) lVar.y(q.b);
        if (lVar2 != null && !t.c.equals(lVar2)) {
            throw new DateTimeException("Chronology mismatch, expected: ISO, actual: " + lVar2.getId());
        }
        int i = this.b;
        int i2 = this.a;
        if (i != 0) {
            long j = (i2 * 12) + i;
            if (j != 0) {
                lVar = lVar.c(j, ChronoUnit.MONTHS);
            }
        } else if (i2 != 0) {
            lVar = lVar.c(i2, ChronoUnit.YEARS);
        }
        int i3 = this.c;
        return i3 != 0 ? lVar.c(i3, ChronoUnit.DAYS) : lVar;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.c, 16) + Integer.rotateLeft(this.b, 8) + this.a;
    }

    public final String toString() {
        if (this == d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i = this.a;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.b;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.c;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }
}
