package com.github.catvod.spider.jdollar.sun.nio.cs;

import com.github.catvod.spider.jdollar.util.Objects;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b extends CharsetEncoder {
    public final e a;

    public b(c cVar) {
        super(cVar, 1.0f, 1.0f);
        e eVar = new e();
        eVar.a = CoderResult.UNDERFLOW;
        this.a = eVar;
    }

    public static int a(char[] cArr, int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        if (i3 <= 0) {
            return 0;
        }
        Objects.requireNonNull(cArr);
        Objects.requireNonNull(bArr);
        if (i < 0 || i >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i5 = (i + i3) - 1;
        if (i5 < 0 || i5 >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i5);
        }
        int i6 = (i2 + i3) - 1;
        if (i6 < 0 || i6 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i6);
        }
        while (i4 < i3) {
            int i7 = i + 1;
            char c = cArr[i];
            if (c > 255) {
                break;
            }
            bArr[i2] = (byte) c;
            i4++;
            i = i7;
            i2++;
        }
        return i4;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final boolean canEncode(char c) {
        return c <= 255;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        CoderResult coderResultUnmappableForLength;
        CoderResult coderResultUnmappableForLength2;
        int i = 2;
        if (!charBuffer.hasArray() || !byteBuffer.hasArray()) {
            int iPosition = charBuffer.position();
            while (true) {
                try {
                    if (!charBuffer.hasRemaining()) {
                        coderResultUnmappableForLength = CoderResult.UNDERFLOW;
                        break;
                    }
                    char c = charBuffer.get();
                    if (c > 255) {
                        int iA = this.a.a(c, charBuffer);
                        e eVar = this.a;
                        if (iA < 0) {
                            coderResultUnmappableForLength = eVar.a;
                        } else {
                            if (!eVar.b) {
                                i = 1;
                            }
                            coderResultUnmappableForLength = CoderResult.unmappableForLength(i);
                        }
                    } else {
                        if (!byteBuffer.hasRemaining()) {
                            coderResultUnmappableForLength = CoderResult.OVERFLOW;
                            break;
                        }
                        byteBuffer.put((byte) c);
                        iPosition++;
                    }
                } finally {
                }
            }
            return coderResultUnmappableForLength;
        }
        char[] cArrArray = charBuffer.array();
        int iArrayOffset = charBuffer.arrayOffset();
        int iPosition2 = charBuffer.position() + iArrayOffset;
        int iLimit = charBuffer.limit() + iArrayOffset;
        if (iPosition2 > iLimit) {
            iPosition2 = iLimit;
        }
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset2 = byteBuffer.arrayOffset();
        int iPosition3 = byteBuffer.position() + iArrayOffset2;
        int iLimit2 = byteBuffer.limit() + iArrayOffset2;
        if (iPosition3 > iLimit2) {
            iPosition3 = iLimit2;
        }
        int i2 = iLimit2 - iPosition3;
        int i3 = iLimit - iPosition2;
        if (i2 >= i3) {
            i2 = i3;
        }
        try {
            int iA2 = a(cArrArray, iPosition2, bArrArray, iPosition3, i2);
            int i4 = iPosition2 + iA2;
            int i5 = iPosition3 + iA2;
            if (iA2 != i2) {
                int iB = this.a.b(cArrArray[i4], cArrArray, i4, iLimit);
                e eVar2 = this.a;
                if (iB < 0) {
                    coderResultUnmappableForLength2 = eVar2.a;
                } else {
                    if (!eVar2.b) {
                        i = 1;
                    }
                    coderResultUnmappableForLength2 = CoderResult.unmappableForLength(i);
                }
            } else {
                coderResultUnmappableForLength2 = i2 < i3 ? CoderResult.OVERFLOW : CoderResult.UNDERFLOW;
            }
            return coderResultUnmappableForLength2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.nio.charset.CharsetEncoder
    public final boolean isLegalReplacement(byte[] bArr) {
        return true;
    }
}
