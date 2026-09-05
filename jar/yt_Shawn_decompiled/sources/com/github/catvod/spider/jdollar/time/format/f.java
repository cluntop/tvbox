package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.util.Objects;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f extends i {
    public final boolean g;

    public f(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i, int i2, boolean z) {
        this(pVar, i, i2, z, 0);
        Objects.requireNonNull(pVar, "field");
        com.github.catvod.spider.jdollar.time.temporal.s sVarO = pVar.o();
        if (sVarO.a != sVarO.b || sVarO.c != sVarO.d) {
            com.github.catvod.spider.jdollar.nio.file.b.c(com.github.catvod.spider.jdollar.time.b.a("Field must have a fixed set of values: ", pVar));
            throw null;
        }
        if (i < 0 || i > 9) {
            com.github.catvod.spider.jdollar.nio.file.b.n("Minimum width must be from 0 to 9 inclusive but was ", i);
            throw null;
        }
        if (i2 < 1 || i2 > 9) {
            com.github.catvod.spider.jdollar.nio.file.b.n("Maximum width must be from 1 to 9 inclusive but was ", i2);
            throw null;
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final boolean b(v vVar) {
        return vVar.c && this.b == this.c && !this.g;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final i d() {
        if (this.e == -1) {
            return this;
        }
        return new f(this.a, this.b, this.c, this.g, -1);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final i e(int i) {
        return new f(this.a, this.b, this.c, this.g, this.e + i);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i, com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        com.github.catvod.spider.jdollar.time.temporal.p pVar = this.a;
        Long lA = wVar.a(pVar);
        if (lA == null) {
            return false;
        }
        a0 a0Var = wVar.b.c;
        long jLongValue = lA.longValue();
        com.github.catvod.spider.jdollar.time.temporal.s sVarO = pVar.o();
        sVarO.b(jLongValue, pVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(sVarO.a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(sVarO.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z = this.g;
        int i = this.b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.c), roundingMode).toPlainString().substring(2);
            a0Var.getClass();
            if (z) {
                sb.append('.');
            }
            sb.append(strSubstring);
            return true;
        }
        if (i > 0) {
            if (z) {
                a0Var.getClass();
                sb.append('.');
            }
            for (int i2 = 0; i2 < i; i2++) {
                a0Var.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i, com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        boolean z = vVar.c;
        DateTimeFormatter dateTimeFormatter = vVar.a;
        int i2 = (z || b(vVar)) ? this.b : 0;
        int i3 = (vVar.c || b(vVar)) ? this.c : 9;
        int length = charSequence.length();
        if (i != length) {
            if (this.g) {
                char cCharAt = charSequence.charAt(i);
                dateTimeFormatter.c.getClass();
                if (cCharAt == '.') {
                    i++;
                } else if (i2 > 0) {
                    return ~i;
                }
            }
            int i4 = i;
            int i5 = i2 + i4;
            if (i5 > length) {
                return ~i4;
            }
            int iMin = Math.min(i3 + i4, length);
            int i6 = i4;
            int i7 = 0;
            while (true) {
                if (i6 >= iMin) {
                    break;
                }
                int i8 = i6 + 1;
                char cCharAt2 = charSequence.charAt(i6);
                dateTimeFormatter.c.getClass();
                int i9 = cCharAt2 - '0';
                if (i9 < 0 || i9 > 9) {
                    i9 = -1;
                }
                if (i9 >= 0) {
                    i7 = (i7 * 10) + i9;
                    i6 = i8;
                } else if (i8 < i5) {
                    return ~i4;
                }
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i7).movePointLeft(i6 - i4);
            com.github.catvod.spider.jdollar.time.temporal.s sVarO = this.a.o();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(sVarO.a);
            return vVar.f(this.a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(sVarO.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i4, i6);
        }
        if (i2 > 0) {
            return ~i;
        }
        return i;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final String toString() {
        return "Fraction(" + this.a + "," + this.b + "," + this.c + (this.g ? ",DecimalPoint" : VideoStream.RESOLUTION_UNKNOWN) + ")";
    }

    public f(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i, int i2, boolean z, int i3) {
        super(pVar, i, i2, d0.NOT_NEGATIVE, i3);
        this.g = z;
    }
}
