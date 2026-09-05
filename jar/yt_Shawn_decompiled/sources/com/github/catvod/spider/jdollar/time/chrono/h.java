package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h implements com.github.catvod.spider.jdollar.time.temporal.o, Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;
    public final l a;
    public final int b;
    public final int c;
    public final int d;

    static {
        com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    public h(l lVar, int i, int i2, int i3) {
        Objects.requireNonNull(lVar, "chrono");
        this.a = lVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.b == hVar.b && this.c == hVar.c && this.d == hVar.d && this.a.equals(hVar.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.o
    public final com.github.catvod.spider.jdollar.time.temporal.l h(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        Objects.requireNonNull(lVar, "temporal");
        l lVar2 = (l) lVar.y(com.github.catvod.spider.jdollar.time.temporal.q.b);
        if (lVar2 != null && !this.a.equals(lVar2)) {
            com.github.catvod.spider.jdollar.nio.file.b.g("Chronology mismatch, expected: ", this.a.getId(), ", actual: ", lVar2.getId());
            return null;
        }
        if (this.c == 0) {
            int i = this.b;
            if (i != 0) {
                lVar = lVar.c(i, ChronoUnit.YEARS);
            }
        } else {
            com.github.catvod.spider.jdollar.time.temporal.s sVarS = this.a.s(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR);
            long j = (sVarS.a == sVarS.b && sVarS.c == sVarS.d && sVarS.d()) ? (sVarS.d - sVarS.a) + 1 : -1L;
            int i2 = this.b;
            if (j > 0) {
                lVar = lVar.c((i2 * j) + this.c, ChronoUnit.MONTHS);
            } else {
                if (i2 != 0) {
                    lVar = lVar.c(i2, ChronoUnit.YEARS);
                }
                lVar = lVar.c(this.c, ChronoUnit.MONTHS);
            }
        }
        int i3 = this.d;
        return i3 != 0 ? lVar.c(i3, ChronoUnit.DAYS) : lVar;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.d, 16) + (Integer.rotateLeft(this.c, 8) + this.b)) ^ this.a.hashCode();
    }

    public final String toString() {
        if (this.b == 0 && this.c == 0 && this.d == 0) {
            return this.a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString());
        sb.append(" P");
        int i = this.b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.c;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.d;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public Object writeReplace() {
        return new f0((byte) 9, this);
    }
}
