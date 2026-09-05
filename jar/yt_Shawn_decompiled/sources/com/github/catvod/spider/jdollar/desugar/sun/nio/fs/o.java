package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class o {
    public static final long a;
    public static final long b;
    public static final char[] c;

    static {
        long j = 0;
        for (int iMax = Math.max(Math.min(48, 63), 0); iMax <= Math.max(Math.min(57, 63), 0); iMax++) {
            j |= 1 << iMax;
        }
        long jB = b('A', 'Z') | b('a', 'z');
        long jD = d("-_.!~*'()");
        long jC = jB | c("-_.!~*'()");
        long jD2 = j | jD | d(":@&=+$,");
        long jC2 = jC | c(":@&=+$,");
        a = jD2 | d(";/");
        b = jC2 | c(";/");
        c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            throw new AssertionError();
        }
        return c2 - '7';
    }

    public static long b(char c2, char c3) {
        long j = 0;
        for (int iMax = Math.max(Math.min((int) c2, 127), 64) - 64; iMax <= Math.max(Math.min((int) c3, 127), 64) - 64; iMax++) {
            j |= 1 << iMax;
        }
        return j;
    }

    public static long c(String str) {
        int length = str.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '@' && cCharAt < 128) {
                j |= 1 << (cCharAt - '@');
            }
        }
        return j;
    }

    public static long d(String str) {
        int length = str.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '@') {
                j |= 1 << cCharAt;
            }
        }
        return j;
    }
}
