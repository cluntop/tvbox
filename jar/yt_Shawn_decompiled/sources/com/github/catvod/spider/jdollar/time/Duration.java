package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Duration implements com.github.catvod.spider.jdollar.time.temporal.o, Comparable<Duration>, Serializable {
    public static final Duration c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;
    public final long a;
    public final int b;

    static {
        BigInteger.valueOf(1000000000L);
    }

    public Duration(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public static Duration i(long j, int i) {
        return (((long) i) | j) == 0 ? c : new Duration(j, i);
    }

    public static Duration j(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (i + 1000000000);
            j2--;
        }
        return i(j2, i);
    }

    public static Duration ofSeconds(long j, long j2) {
        return i(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(j, com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j2, 1000000000L)), (int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j2, 1000000000L));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 1, this);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int iCompare = Long.compare(this.a, duration2.a);
        return iCompare != 0 ? iCompare : this.b - duration2.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.a == duration.a && this.b == duration.b) {
                return true;
            }
        }
        return false;
    }

    public int getNano() {
        return this.b;
    }

    public long getSeconds() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.o
    public final com.github.catvod.spider.jdollar.time.temporal.l h(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        long j = this.a;
        if (j != 0) {
            lVar = lVar.c(j, ChronoUnit.SECONDS);
        }
        int i = this.b;
        return i != 0 ? lVar.c(i, ChronoUnit.NANOS) : lVar;
    }

    public final int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public long toMillis() {
        long j = this.a;
        long j2 = this.b;
        if (j < 0) {
            j++;
            j2 -= 1000000000;
        }
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000L), j2 / 1000000);
    }

    public final String toString() {
        if (this == c) {
            return "PT0S";
        }
        long j = this.a;
        if (j < 0 && this.b > 0) {
            j++;
        }
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.a >= 0 || this.b <= 0 || i2 != 0) {
            sb.append(i2);
        } else {
            sb.append("-0");
        }
        if (this.b > 0) {
            int length = sb.length();
            long j3 = this.a;
            int i3 = this.b;
            if (j3 < 0) {
                sb.append(2000000000 - i3);
            } else {
                sb.append(i3 + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
