package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.DateTimeException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class i implements e {
    public static final long[] f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
    public final com.github.catvod.spider.jdollar.time.temporal.p a;
    public final int b;
    public final int c;
    public final d0 d;
    public final int e;

    public i(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i, int i2, d0 d0Var) {
        this.a = pVar;
        this.b = i;
        this.c = i2;
        this.d = d0Var;
        this.e = 0;
    }

    public long a(w wVar, long j) {
        return j;
    }

    public boolean b(v vVar) {
        int i = this.e;
        if (i != -1) {
            return i > 0 && this.b == this.c && this.d == d0.NOT_NEGATIVE;
        }
        return true;
    }

    public int c(v vVar, long j, int i, int i2) {
        return vVar.f(this.a, j, i, i2);
    }

    public i d() {
        if (this.e == -1) {
            return this;
        }
        return new i(this.a, this.b, this.c, this.d, -1);
    }

    public i e(int i) {
        return new i(this.a, this.b, this.c, this.d, this.e + i);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public boolean h(w wVar, StringBuilder sb) {
        com.github.catvod.spider.jdollar.time.temporal.p pVar = this.a;
        Long lA = wVar.a(pVar);
        if (lA == null) {
            return false;
        }
        long jA = a(wVar, lA.longValue());
        a0 a0Var = wVar.b.c;
        String string = jA == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jA));
        int length = string.length();
        int i = this.c;
        if (length > i) {
            throw new DateTimeException("Field " + pVar + " cannot be printed as the value " + jA + " exceeds the maximum print width of " + i);
        }
        a0Var.getClass();
        int i2 = this.b;
        d0 d0Var = this.d;
        if (jA >= 0) {
            int i3 = b.a[d0Var.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    sb.append('+');
                }
            } else if (i2 < 19 && jA >= f[i2]) {
                sb.append('+');
            }
        } else {
            int i4 = b.a[d0Var.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                sb.append('-');
            } else if (i4 == 4) {
                throw new DateTimeException("Field " + pVar + " cannot be printed as the value " + jA + " cannot be negative according to the SignStyle");
            }
        }
        for (int i5 = 0; i5 < i2 - string.length(); i5++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0173, code lost:
    
        if (r6 <= r10) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0197  */
    @Override // com.github.catvod.spider.jdollar.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int i(com.github.catvod.spider.jdollar.time.format.v r27, java.lang.CharSequence r28, int r29) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.format.i.i(com.github.catvod.spider.jdollar.time.format.v, java.lang.CharSequence, int):int");
    }

    public String toString() {
        int i = this.c;
        com.github.catvod.spider.jdollar.time.temporal.p pVar = this.a;
        d0 d0Var = this.d;
        int i2 = this.b;
        if (i2 == 1 && i == 19 && d0Var == d0.NORMAL) {
            return "Value(" + pVar + ")";
        }
        if (i2 == i && d0Var == d0.NOT_NEGATIVE) {
            return "Value(" + pVar + "," + i2 + ")";
        }
        return "Value(" + pVar + "," + i2 + "," + i + "," + d0Var + ")";
    }

    public i(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i, int i2, d0 d0Var, int i3) {
        this.a = pVar;
        this.b = i;
        this.c = i2;
        this.d = d0Var;
        this.e = i3;
    }
}
