package com.github.catvod.spider.merge.u;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class c implements g1 {
    protected int memoizedHashCode;

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        b.addAll((Iterable) iterable, (List) list);
    }

    public static void checkByteStringIsUtf8(l lVar) {
        if (lVar.i()) {
            return;
        }
        com.github.catvod.spider.merge.s0.a.r("Byte string is not UTF-8.");
    }

    public final String a(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract int getSerializedSize(s1 s1Var);

    public u1 newUninitializedMessageException() {
        return new u1();
    }

    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            boolean z = u.b;
            r rVar = new r(bArr, serializedSize);
            writeTo(rVar);
            if (rVar.w() > 0) {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            if (rVar.w() >= 0) {
                return bArr;
            }
            throw new IllegalStateException("Wrote more data than expected.");
        } catch (IOException e) {
            throw new RuntimeException(a("byte array"), e);
        }
    }

    public l toByteString() {
        try {
            int serializedSize = getSerializedSize();
            k kVar = l.b;
            byte[] bArr = new byte[serializedSize];
            boolean z = u.b;
            r rVar = new r(bArr, serializedSize);
            writeTo(rVar);
            if (rVar.w() > 0) {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            if (rVar.w() >= 0) {
                return new k(bArr);
            }
            throw new IllegalStateException("Wrote more data than expected.");
        } catch (IOException e) {
            throw new RuntimeException(a("ByteString"), e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        int iE = u.e(serializedSize) + serializedSize;
        if (iE > 4096) {
            iE = 4096;
        }
        t tVar = new t(outputStream, iE);
        tVar.t(serializedSize);
        writeTo(tVar);
        if (tVar.e > 0) {
            tVar.B();
        }
    }

    public void writeTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        boolean z = u.b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        t tVar = new t(outputStream, serializedSize);
        writeTo(tVar);
        if (tVar.e > 0) {
            tVar.B();
        }
    }
}
