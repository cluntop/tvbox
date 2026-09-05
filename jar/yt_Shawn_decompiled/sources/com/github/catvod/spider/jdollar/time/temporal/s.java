package com.github.catvod.spider.jdollar.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public s(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    public static s f(long j, long j2) {
        if (j <= j2) {
            return new s(j, j, j2, j2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("Minimum value must be less than maximum value");
        return null;
    }

    public static s g(long j, long j2, long j3) {
        if (j > 1) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Smallest minimum value must be less than largest minimum value");
            return null;
        }
        if (j2 > j3) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Smallest maximum value must be less than largest maximum value");
            return null;
        }
        if (1 <= j3) {
            return new s(j, 1L, j2, j3);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("Minimum value must be less than maximum value");
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j = this.a;
        long j2 = this.b;
        if (j > j2) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j3 = this.c;
        long j4 = this.d;
        if (j3 > j4) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j2 > j4) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final int a(long j, p pVar) {
        if (d() && e(j)) {
            return (int) j;
        }
        com.github.catvod.spider.jdollar.nio.file.b.k(c(j, pVar));
        return 0;
    }

    public final void b(long j, p pVar) {
        if (e(j)) {
            return;
        }
        com.github.catvod.spider.jdollar.nio.file.b.k(c(j, pVar));
    }

    public final String c(long j, p pVar) {
        if (pVar == null) {
            return "Invalid value (valid values " + this + "): " + j;
        }
        return "Invalid value for " + pVar + " (valid values " + this + "): " + j;
    }

    public final boolean d() {
        return this.a >= -2147483648L && this.d <= 2147483647L;
    }

    public final boolean e(long j) {
        return j >= this.a && j <= this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.a == sVar.a && this.b == sVar.b && this.c == sVar.c && this.d == sVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        long j2 = this.b;
        long j3 = j + (j2 << 16) + (j2 >> 48);
        long j4 = this.c;
        long j5 = j3 + (j4 << 32) + (j4 >> 32);
        long j6 = this.d;
        long j7 = j5 + (j6 << 48) + (j6 >> 16);
        return (int) (j7 ^ (j7 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        if (this.a != this.b) {
            sb.append('/');
            sb.append(this.b);
        }
        sb.append(" - ");
        sb.append(this.c);
        if (this.c != this.d) {
            sb.append('/');
            sb.append(this.d);
        }
        return sb.toString();
    }
}
