package com.github.catvod.spider.merge.a0;

import com.github.catvod.spider.merge.u.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class c {
    public static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    public static final Charset b = StandardCharsets.ISO_8859_1;

    public static boolean a(int i, com.github.catvod.spider.merge.z.d dVar, int i2) {
        int i3 = dVar.c;
        com.github.catvod.spider.merge.z.c cVar = dVar.b[o.d(i2)];
        int i4 = cVar.a;
        int i5 = 0;
        for (com.github.catvod.spider.merge.z.b bVar : cVar.b) {
            i5 += bVar.a;
        }
        return i3 - (i5 * i4) >= (i + 7) / 8;
    }
}
