package com.github.catvod.spider.merge.h0;

import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.merge.u.c2;
import com.github.catvod.spider.merge.y0.g0;
import java.io.File;
import java.net.ServerSocket;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f implements r, s {
    public static final boolean a(g0 g0Var) {
        g0 g0Var2 = com.github.catvod.spider.merge.z0.k.d;
        com.github.catvod.spider.merge.y0.m mVarP = g0Var.a;
        int iK = com.github.catvod.spider.merge.y0.m.k(mVarP, com.github.catvod.spider.merge.z0.f.a);
        if (iK == -1) {
            iK = com.github.catvod.spider.merge.y0.m.k(g0Var.a, com.github.catvod.spider.merge.z0.f.b);
        }
        if (iK != -1) {
            mVarP = com.github.catvod.spider.merge.y0.m.p(mVarP, iK + 1, 0, 2);
        } else if (g0Var.f() != null && mVarP.d() == 2) {
            mVarP = com.github.catvod.spider.merge.y0.m.d;
        }
        return !StringsKt.q(mVarP.r());
    }

    public static com.github.catvod.spider.merge.y0.m b(String str) {
        int i;
        char cCharAt;
        str.getClass();
        byte[] bArr = com.github.catvod.spider.merge.y0.a.a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArrCopyOf = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i3 < length) {
                char cCharAt2 = str.charAt(i3);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i3++;
                    } else {
                        i = 63;
                    }
                } else {
                    i = 62;
                }
                i5 = (i5 << 6) | i;
                i4++;
                if (i4 % 4 == 0) {
                    bArrCopyOf[i6] = (byte) (i5 >> 16);
                    int i7 = i6 + 2;
                    bArrCopyOf[i6 + 1] = (byte) (i5 >> 8);
                    i6 += 3;
                    bArrCopyOf[i7] = (byte) i5;
                }
                i3++;
            } else {
                int i8 = i4 % 4;
                if (i8 != 1) {
                    if (i8 == 2) {
                        bArrCopyOf[i6] = (byte) ((i5 << 12) >> 16);
                        i6++;
                    } else if (i8 == 3) {
                        int i9 = i5 << 6;
                        int i10 = i6 + 1;
                        bArrCopyOf[i6] = (byte) (i9 >> 16);
                        i6 += 2;
                        bArrCopyOf[i10] = (byte) (i9 >> 8);
                    }
                    if (i6 != i2) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6);
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new com.github.catvod.spider.merge.y0.m(bArrCopyOf);
        }
        return null;
    }

    public static com.github.catvod.spider.merge.y0.m c(String str) {
        if (str.length() % 2 != 0) {
            com.github.catvod.spider.merge.s0.a.e("Unexpected hex string: ".concat(str));
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (com.github.catvod.spider.merge.z0.b.a(str.charAt(i2 + 1)) + (com.github.catvod.spider.merge.z0.b.a(str.charAt(i2)) << 4));
        }
        return new com.github.catvod.spider.merge.y0.m(bArr);
    }

    public static com.github.catvod.spider.merge.y0.m d(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        bytes.getClass();
        com.github.catvod.spider.merge.y0.m mVar = new com.github.catvod.spider.merge.y0.m(bytes);
        mVar.c = str;
        return mVar;
    }

    public static g0 e(String str) {
        str.getClass();
        com.github.catvod.spider.merge.y0.m mVar = com.github.catvod.spider.merge.z0.f.a;
        com.github.catvod.spider.merge.y0.j jVar = new com.github.catvod.spider.merge.y0.j();
        jVar.T(str);
        return com.github.catvod.spider.merge.z0.f.d(jVar, false);
    }

    public static g0 f(File file) {
        String str = g0.b;
        file.getClass();
        String string = file.toString();
        string.getClass();
        return e(string);
    }

    public static g0 g(Path path) {
        String str = g0.b;
        path.getClass();
        return e(path.toString());
    }

    public static com.github.catvod.spider.merge.y0.m h(byte[] bArr) {
        com.github.catvod.spider.merge.y0.m mVar = com.github.catvod.spider.merge.y0.m.d;
        int length = bArr.length;
        bArr.getClass();
        c2.g(bArr.length, 0L, length);
        return new com.github.catvod.spider.merge.y0.m(ArraysKt.copyOfRange(bArr, 0, length));
    }

    public static g0 i(g0 g0Var, g0 g0Var2) {
        g0Var.getClass();
        return com.github.catvod.spider.merge.z0.k.d.d(StringsKt.G(StringsKt.C(g0Var.a.r(), g0Var2.a.r()), '\\', '/'));
    }

    @Override // com.github.catvod.spider.merge.h0.r
    public ServerSocket create() {
        return new ServerSocket();
    }
}
