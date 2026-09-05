package com.github.catvod.spider.jdollar.sun.nio.cs;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a extends CharsetDecoder {
    public a(c cVar) {
        super(cVar, 1.0f, 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.nio.CharBuffer] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r9v5 */
    @Override // java.nio.charset.CharsetDecoder
    public final CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) throws Throwable {
        CoderResult coderResult;
        CoderResult coderResult2;
        if (!byteBuffer.hasArray() || !charBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            while (true) {
                try {
                    if (!byteBuffer.hasRemaining()) {
                        coderResult = CoderResult.UNDERFLOW;
                        break;
                    }
                    byte b = byteBuffer.get();
                    if (!charBuffer.hasRemaining()) {
                        coderResult = CoderResult.OVERFLOW;
                        break;
                    }
                    charBuffer.put((char) (b & 255));
                    iPosition++;
                } finally {
                }
            }
            return coderResult;
        }
        byte[] bArrArray = byteBuffer.array();
        int iPosition2 = byteBuffer.position() + byteBuffer.arrayOffset();
        int iLimit = byteBuffer.limit() + byteBuffer.arrayOffset();
        if (iPosition2 > iLimit) {
            iPosition2 = iLimit;
        }
        char[] cArrArray = charBuffer.array();
        int iPosition3 = charBuffer.position() + charBuffer.arrayOffset();
        int iLimit2 = charBuffer.limit() + charBuffer.arrayOffset();
        if (iPosition3 > iLimit2) {
            iPosition3 = iLimit2;
        }
        while (true) {
            if (iPosition2 >= iLimit) {
                coderResult2 = CoderResult.UNDERFLOW;
                break;
            }
            try {
                byte b2 = bArrArray[iPosition2];
                if (iPosition3 >= iLimit2) {
                    coderResult2 = CoderResult.OVERFLOW;
                    break;
                }
                int i = iPosition3 + 1;
                try {
                    cArrArray[iPosition3] = (char) (b2 & 255);
                    iPosition2++;
                    iPosition3 = i;
                } catch (Throwable th) {
                    th = th;
                    iPosition3 = i;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        iPosition2 -= byteBuffer.arrayOffset();
        iPosition3 -= charBuffer.arrayOffset();
        byteBuffer = (CharBuffer) charBuffer.position(iPosition3);
        return coderResult2;
    }
}
