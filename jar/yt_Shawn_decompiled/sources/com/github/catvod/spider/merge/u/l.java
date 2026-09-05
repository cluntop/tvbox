package com.github.catvod.spider.merge.u;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class l implements Iterable, Serializable {
    public static final k b = new k(s0.a);
    public static final h c;
    public int a;

    static {
        c = e.a() ? new h(1) : new h(0);
    }

    public static boolean a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i + i3;
        b(i, i4, bArr.length);
        b(i2, i3 + i2, bArr2.length);
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.github.catvod.spider.merge.b.b.k(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            com.github.catvod.spider.merge.b0.a.g("Beginning index larger than ending index: ", i, i2, ", ");
            return 0;
        }
        com.github.catvod.spider.merge.b0.a.g("End index: ", i2, i3, " >= ");
        return 0;
    }

    public static k c(byte[] bArr, int i, int i2) {
        try {
            return d(bArr, i, i2);
        } catch (u0 e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    public static k d(byte[] bArr, int i, int i2) {
        byte[] bArrCopyOfRange;
        if (i2 == 0) {
            return b;
        }
        b(i, i + i2, bArr.length);
        switch (c.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i2];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i2);
                break;
        }
        return new k(bArrCopyOfRange);
    }

    public static k e(String str) {
        return str.isEmpty() ? b : new k(str.getBytes(StandardCharsets.UTF_8));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        int size = size();
        if (size != lVar.size()) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        int i = this.a;
        int i2 = lVar.a;
        if (i == 0 || i2 == 0 || i == i2) {
            return g(lVar);
        }
        return false;
    }

    public abstract void f(byte[] bArr, int i);

    public abstract boolean g(l lVar);

    public abstract byte h(int i);

    public final int hashCode() {
        int iL = this.a;
        if (iL == 0) {
            int size = size();
            iL = l(size, size);
            if (iL == 0) {
                iL = 1;
            }
            this.a = iL;
        }
        return iL;
    }

    public abstract boolean i();

    public abstract m k();

    public abstract int l(int i, int i2);

    public abstract j m(int i, int i2);

    public abstract String n();

    public final String o() {
        Charset charset = StandardCharsets.UTF_8;
        return size() == 0 ? VideoStream.RESOLUTION_UNKNOWN : n();
    }

    public abstract void p(u uVar);

    public abstract int size();

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        String strA = size() <= 50 ? c2.A(this) : c2.A(m(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return com.github.catvod.spider.merge.b.b.q(sb, strA, "\">");
    }
}
