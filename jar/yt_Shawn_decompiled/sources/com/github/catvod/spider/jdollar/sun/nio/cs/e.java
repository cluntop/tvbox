package com.github.catvod.spider.jdollar.sun.nio.cs;

import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e {
    public CoderResult a;
    public boolean b;

    public final int a(char c, CharBuffer charBuffer) {
        if (!Character.isHighSurrogate(c)) {
            if (Character.isLowSurrogate(c)) {
                this.a = CoderResult.malformedForLength(1);
                return -1;
            }
            this.b = false;
            this.a = null;
            return c;
        }
        if (!charBuffer.hasRemaining()) {
            this.a = CoderResult.UNDERFLOW;
            return -1;
        }
        char c2 = charBuffer.get();
        if (!Character.isLowSurrogate(c2)) {
            this.a = CoderResult.malformedForLength(1);
            return -1;
        }
        int codePoint = Character.toCodePoint(c, c2);
        this.b = true;
        this.a = null;
        return codePoint;
    }

    public final int b(char c, char[] cArr, int i, int i2) {
        if (!Character.isHighSurrogate(c)) {
            if (Character.isLowSurrogate(c)) {
                this.a = CoderResult.malformedForLength(1);
                return -1;
            }
            this.b = false;
            this.a = null;
            return c;
        }
        if (i2 - i < 2) {
            this.a = CoderResult.UNDERFLOW;
            return -1;
        }
        char c2 = cArr[i + 1];
        if (!Character.isLowSurrogate(c2)) {
            this.a = CoderResult.malformedForLength(1);
            return -1;
        }
        int codePoint = Character.toCodePoint(c, c2);
        this.b = true;
        this.a = null;
        return codePoint;
    }
}
