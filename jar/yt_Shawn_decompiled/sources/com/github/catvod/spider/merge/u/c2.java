package com.github.catvod.spider.merge.u;

import com.github.catvod.spider.jdollar.util.Spliterators;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import com.whl.quickjs.wrapper.JSArray;
import com.whl.quickjs.wrapper.QuickJSContext;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.StringsKt;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c2 {
    public final /* synthetic */ int a;

    public /* synthetic */ c2(int i) {
        this.a = i;
    }

    public static String A(l lVar) {
        byte[] bArr;
        int size = lVar.size();
        if (size == 0) {
            bArr = s0.a;
        } else {
            byte[] bArr2 = new byte[size];
            lVar.f(bArr2, size);
            bArr = bArr2;
        }
        return B(bArr);
    }

    public static String B(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            if (b == 34) {
                sb.append("\\\"");
            } else if (b == 39) {
                sb.append("\\'");
            } else if (b != 92) {
                switch (b) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b < 32 || b > 126) {
                            sb.append('\\');
                            sb.append((char) (((b >>> 6) & 3) + 48));
                            sb.append((char) (((b >>> 3) & 7) + 48));
                            sb.append((char) ((b & 7) + 48));
                            break;
                        } else {
                            sb.append((char) b);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static void C(long[] jArr, int i, long j) {
        long jC = c(c(c(c(c(j, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i] = jC & (-6148914691236517206L);
        jArr[i + 1] = (jC << 1) & (-6148914691236517206L);
    }

    public static long D(long j, long j2) {
        long j3 = j & 1229782938247303441L;
        long j4 = j & 2459565876494606882L;
        long j5 = j & 4919131752989213764L;
        long j6 = j & (-8608480567731124088L);
        long j7 = j2 & 1229782938247303441L;
        long j8 = j2 & 2459565876494606882L;
        long j9 = j2 & 4919131752989213764L;
        long j10 = j2 & (-8608480567731124088L);
        long j11 = (((j3 * j7) ^ (j4 * j10)) ^ (j5 * j9)) ^ (j6 * j8);
        long j12 = (((j3 * j8) ^ (j4 * j7)) ^ (j5 * j10)) ^ (j6 * j9);
        long j13 = (((j3 * j9) ^ (j4 * j8)) ^ (j5 * j7)) ^ (j6 * j10);
        return (j11 & 1229782938247303441L) | (j12 & 2459565876494606882L) | (j13 & 4919131752989213764L) | (((((j3 * j10) ^ (j4 * j9)) ^ (j5 * j8)) ^ (j6 * j7)) & (-8608480567731124088L));
    }

    public static void E(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static void F(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public static boolean G(byte b) {
        return b > -65;
    }

    public static void H(String str, boolean z) {
        if (!z) {
            throw new com.github.catvod.spider.merge.m1.g(str);
        }
    }

    public static void I(boolean z) {
        if (!z) {
            throw new com.github.catvod.spider.merge.m1.g("Must be true");
        }
    }

    public static int K(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static void L(byte[] bArr, int i, long j) {
        E(bArr, (int) (j >>> 32), i);
        E(bArr, (int) (j & 4294967295L), i + 4);
    }

    public static int M(Object obj, s1 s1Var, byte[] bArr, int i, int i2, int i3, f fVar) throws u0 {
        j1 j1Var = (j1) s1Var;
        int i4 = fVar.d + 1;
        fVar.d = i4;
        if (i4 >= 100) {
            throw new u0("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iE = j1Var.E(obj, bArr, i, i2, i3, fVar);
        fVar.d--;
        fVar.c = obj;
        return iE;
    }

    public static int N(Object obj, s1 s1Var, byte[] bArr, int i, int i2, f fVar) throws u0 {
        int iT = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iT = t(i3, bArr, iT, fVar);
            i3 = fVar.a;
        }
        int i4 = iT;
        if (i3 < 0 || i3 > i2 - i4) {
            throw u0.g();
        }
        int i5 = fVar.d + 1;
        fVar.d = i5;
        if (i5 >= 100) {
            throw new u0("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i6 = i4 + i3;
        s1Var.f(obj, bArr, i4, i6, fVar);
        fVar.d--;
        fVar.c = obj;
        return i6;
    }

    public static void O(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr2[0];
        long j4 = jArr2[1];
        long jReverse = Long.reverse(j);
        long jReverse2 = Long.reverse(j2);
        long jReverse3 = Long.reverse(j3);
        long jReverse4 = Long.reverse(j4);
        long jReverse5 = Long.reverse(D(jReverse, jReverse3));
        long jD = D(j, j3) << 1;
        long jReverse6 = Long.reverse(D(jReverse2, jReverse4));
        long jD2 = D(j2, j4);
        long j5 = jD2 << 1;
        long jReverse7 = Long.reverse(D(jReverse ^ jReverse2, jReverse4 ^ jReverse3));
        long jD3 = ((D(j ^ j2, j3 ^ j4) << 1) ^ ((jReverse6 ^ jD) ^ j5)) ^ ((jD2 << 63) ^ (jD2 << 58));
        jArr[0] = jReverse5 ^ ((jD3 >>> 7) ^ (((jD3 >>> 1) ^ jD3) ^ (jD3 >>> 2)));
        jArr[1] = ((jD3 << 57) ^ ((jD3 << 63) ^ (jD3 << 62))) ^ ((jReverse7 ^ ((jD ^ jReverse5) ^ jReverse6)) ^ (((j5 ^ (j5 >>> 1)) ^ (j5 >>> 2)) ^ (j5 >>> 7)));
    }

    public static void P(String str) {
        if (str == null || str.length() == 0) {
            throw new com.github.catvod.spider.merge.m1.g("String must not be empty");
        }
    }

    public static void Q(String str, String str2) {
        if (str.length() == 0) {
            throw new com.github.catvod.spider.merge.m1.g(str2);
        }
    }

    public static void R(Object obj) {
        if (obj == null) {
            throw new com.github.catvod.spider.merge.m1.g("Object must not be null");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.github.catvod.spider.merge.y0.f0 S(com.github.catvod.spider.merge.y0.m... r11) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.c2.S(com.github.catvod.spider.merge.y0.m[]):com.github.catvod.spider.merge.y0.f0");
    }

    public static com.github.catvod.spider.merge.o1.h T(String str) {
        com.github.catvod.spider.merge.p1.b bVar = new com.github.catvod.spider.merge.p1.b();
        StringReader stringReader = new StringReader(str);
        com.github.catvod.spider.merge.p1.e0 e0Var = new com.github.catvod.spider.merge.p1.e0(bVar);
        e0Var.a.getClass();
        com.github.catvod.spider.merge.o1.h hVar = new com.github.catvod.spider.merge.o1.h();
        bVar.d = hVar;
        hVar.k = e0Var;
        bVar.a = e0Var;
        bVar.h = e0Var.c;
        com.github.catvod.spider.merge.p1.a aVar = new com.github.catvod.spider.merge.p1.a(stringReader);
        bVar.b = aVar;
        com.github.catvod.spider.merge.p1.c0 c0Var = e0Var.b;
        c0Var.getClass();
        aVar.j = null;
        c0Var.getClass();
        bVar.c = new com.github.catvod.spider.merge.p1.t0(bVar);
        bVar.e = new ArrayList(32);
        bVar.i = e0Var.a();
        com.github.catvod.spider.merge.p1.o0 o0Var = new com.github.catvod.spider.merge.p1.o0(2, bVar);
        bVar.j = o0Var;
        bVar.g = o0Var;
        bVar.f = VideoStream.RESOLUTION_UNKNOWN;
        bVar.l = com.github.catvod.spider.merge.p1.b0.a;
        bVar.m = null;
        bVar.n = false;
        bVar.o = null;
        bVar.p = null;
        bVar.q = new ArrayList();
        bVar.r = new ArrayList();
        bVar.s = new ArrayList();
        bVar.t = new com.github.catvod.spider.merge.p1.n0(3, bVar);
        bVar.u = true;
        bVar.v = false;
        while (true) {
            if (bVar.g.a == 7) {
                ArrayList arrayList = bVar.e;
                if (arrayList == null) {
                    break;
                }
                if (arrayList.isEmpty()) {
                    bVar.e = null;
                } else {
                    bVar.F();
                }
            } else {
                com.github.catvod.spider.merge.p1.t0 t0Var = bVar.c;
                com.github.catvod.spider.merge.p1.j0 j0Var = t0Var.k;
                while (!t0Var.e) {
                    t0Var.c.d(t0Var, t0Var.a);
                }
                boolean zF = j0Var.d.f();
                com.github.catvod.spider.merge.p1.r0 r0Var = j0Var;
                if (!zF) {
                    t0Var.e = false;
                    r0Var = t0Var.d;
                }
                bVar.g = r0Var;
                bVar.I(r0Var);
                r0Var.f();
            }
        }
        com.github.catvod.spider.merge.p1.a aVar2 = bVar.b;
        if (aVar2 != null) {
            aVar2.close();
            bVar.b = null;
            bVar.c = null;
            bVar.e = null;
        }
        return bVar.d;
    }

    public static final int U(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final com.github.catvod.spider.merge.y0.e V(InputStream inputStream) {
        inputStream.getClass();
        return new com.github.catvod.spider.merge.y0.e(inputStream, new com.github.catvod.spider.merge.y0.u0());
    }

    public static Stream W(com.github.catvod.spider.merge.o1.n nVar, Class cls) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new com.github.catvod.spider.merge.o1.t(nVar, cls), 273), false);
    }

    public static Stream X(com.github.catvod.spider.merge.q1.p pVar, com.github.catvod.spider.merge.o1.n nVar) {
        pVar.e();
        nVar.getClass();
        return W(nVar, com.github.catvod.spider.merge.o1.n.class).filter(new com.github.catvod.spider.merge.q1.f(pVar, nVar, 0));
    }

    public static JSArray Y(QuickJSContext quickJSContext, List list) {
        JSArray jSArrayCreateNewJSArray = quickJSContext.createNewJSArray();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                jSArrayCreateNewJSArray.set(list.get(i), i);
            }
        }
        return jSArrayCreateNewJSArray;
    }

    public static final String Z(byte b) {
        char[] cArr = com.github.catvod.spider.merge.z0.b.a;
        return StringsKt.concatToString(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]});
    }

    public static final boolean a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        bArr.getClass();
        bArr2.getClass();
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final String a0(int i) {
        if (i == 0) {
            return "0";
        }
        char[] cArr = com.github.catvod.spider.merge.z0.b.a;
        int i2 = 0;
        char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
        while (i2 < 8 && cArr2[i2] == '0') {
            i2++;
        }
        return StringsKt.m(cArr2, i2);
    }

    public static int b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int b0(int i, int i2) {
        int i3;
        if (i <= 57) {
            i3 = i - 48;
            if (i3 < 0) {
                return -1;
            }
        } else if (i <= 70) {
            if (65 > i) {
                return -1;
            }
            i3 = i - 55;
        } else {
            if (i > 102 || 97 > i) {
                return -1;
            }
            i3 = i - 87;
        }
        return i3 | (i2 << 4);
    }

    public static long c(long j, long j2, int i) {
        long j3 = j2 & ((j >>> i) ^ j);
        return j ^ (j3 ^ (j3 << i));
    }

    public static void c0(byte[] bArr, byte[] bArr2) {
        int i = 0;
        do {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            int i2 = i + 1;
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            int i3 = i + 2;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            int i4 = i + 3;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
            i += 4;
        } while (i < 16);
    }

    public static final com.github.catvod.spider.merge.y0.j0 d(com.github.catvod.spider.merge.y0.p0 p0Var) {
        p0Var.getClass();
        return new com.github.catvod.spider.merge.y0.j0(p0Var);
    }

    public static void d0(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        do {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
            int i3 = i2 + 1;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i + i3]);
            int i4 = i2 + 2;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i + i4]);
            int i5 = i2 + 3;
            bArr[i5] = (byte) (bArr[i5] ^ bArr2[i + i5]);
            i2 += 4;
        } while (i2 < 16);
    }

    public static final com.github.catvod.spider.merge.y0.l0 e(com.github.catvod.spider.merge.y0.r0 r0Var) {
        r0Var.getClass();
        return new com.github.catvod.spider.merge.y0.l0(r0Var);
    }

    public static void f(long j, com.github.catvod.spider.merge.y0.j jVar, int i, List list, int i2, int i3, ArrayList arrayList) {
        int i4;
        int i5;
        ArrayList arrayList2;
        long j2;
        int i6;
        int i7 = i;
        List list2 = list;
        ArrayList arrayList3 = arrayList;
        if (i2 >= i3) {
            com.github.catvod.spider.merge.s0.a.r("Failed requirement.");
            return;
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (((com.github.catvod.spider.merge.y0.m) list2.get(i8)).d() < i7) {
                com.github.catvod.spider.merge.s0.a.r("Failed requirement.");
                return;
            }
        }
        com.github.catvod.spider.merge.y0.m mVar = (com.github.catvod.spider.merge.y0.m) list.get(i2);
        com.github.catvod.spider.merge.y0.m mVar2 = (com.github.catvod.spider.merge.y0.m) list2.get(i3 - 1);
        if (i7 == mVar.d()) {
            int iIntValue = ((Number) arrayList3.get(i2)).intValue();
            int i9 = i2 + 1;
            com.github.catvod.spider.merge.y0.m mVar3 = (com.github.catvod.spider.merge.y0.m) list2.get(i9);
            i4 = i9;
            i5 = iIntValue;
            mVar = mVar3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (mVar.i(i7) == mVar2.i(i7)) {
            int iMin = Math.min(mVar.d(), mVar2.d());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && mVar.i(i11) == mVar2.i(i11); i11++) {
                i10++;
            }
            long j3 = (jVar.b / 4) + j + 2 + i10 + 1;
            jVar.Q(-i10);
            jVar.Q(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                jVar.Q(mVar.i(i7) & 255);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i12 == ((com.github.catvod.spider.merge.y0.m) list2.get(i4)).d()) {
                    jVar.Q(((Number) arrayList3.get(i4)).intValue());
                    return;
                } else {
                    com.github.catvod.spider.merge.s0.a.h("Check failed.");
                    return;
                }
            }
            com.github.catvod.spider.merge.y0.j jVar2 = new com.github.catvod.spider.merge.y0.j();
            jVar.Q(((int) ((jVar2.b / 4) + j3)) * (-1));
            f(j3, jVar2, i12, list2, i4, i3, arrayList3);
            jVar.p(jVar2);
            return;
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (((com.github.catvod.spider.merge.y0.m) list2.get(i14 - 1)).i(i7) != ((com.github.catvod.spider.merge.y0.m) list2.get(i14)).i(i7)) {
                i13++;
            }
        }
        long j4 = (jVar.b / 4) + j + 2 + (i13 * 2);
        jVar.Q(i13);
        jVar.Q(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            int i16 = ((com.github.catvod.spider.merge.y0.m) list2.get(i15)).i(i7);
            if (i15 == i4 || i16 != ((com.github.catvod.spider.merge.y0.m) list2.get(i15 - 1)).i(i7)) {
                jVar.Q(i16 & 255);
            }
        }
        com.github.catvod.spider.merge.y0.j jVar3 = new com.github.catvod.spider.merge.y0.j();
        int i17 = i4;
        while (i17 < i3) {
            byte bI = ((com.github.catvod.spider.merge.y0.m) list2.get(i17)).i(i7);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i3) {
                    i19 = i3;
                    break;
                } else if (bI != ((com.github.catvod.spider.merge.y0.m) list2.get(i19)).i(i7)) {
                    break;
                } else {
                    i19++;
                }
            }
            if (i18 == i19 && i7 + 1 == ((com.github.catvod.spider.merge.y0.m) list2.get(i17)).d()) {
                jVar.Q(((Number) arrayList3.get(i17)).intValue());
                arrayList2 = arrayList3;
                j2 = j4;
                i6 = i19;
            } else {
                jVar.Q(((int) ((jVar3.b / 4) + j4)) * (-1));
                arrayList2 = arrayList3;
                j2 = j4;
                i6 = i19;
                f(j2, jVar3, i7 + 1, list, i17, i6, arrayList2);
                list2 = list;
            }
            j4 = j2;
            i17 = i6;
            arrayList3 = arrayList2;
        }
        jVar.p(jVar3);
    }

    public static final void g(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static Class h(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | IllegalArgumentException | LinkageError | SecurityException unused) {
            return null;
        }
    }

    public static byte[] i(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static void j() {
        IllegalStateException illegalStateException = new IllegalStateException("FAILED ASSERTION");
        illegalStateException.printStackTrace(System.err);
        throw illegalStateException;
    }

    public static com.github.catvod.spider.merge.q1.e k(com.github.catvod.spider.merge.q1.p pVar, com.github.catvod.spider.merge.o1.n nVar) {
        Stream streamX;
        if (pVar.f()) {
            pVar.e();
            nVar.getClass();
            streamX = W(nVar, com.github.catvod.spider.merge.o1.n.class).filter(new com.github.catvod.spider.merge.q1.f(pVar, nVar, 1));
        } else {
            streamX = X(pVar, nVar);
        }
        com.github.catvod.spider.merge.q1.e eVar = (com.github.catvod.spider.merge.q1.e) streamX.collect(Collectors.toCollection(new com.github.catvod.spider.merge.n1.b(5)));
        pVar.e();
        return eVar;
    }

    public static boolean l(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr == bArr2) {
                return true;
            }
            int length = bArr.length < bArr2.length ? bArr.length : bArr2.length;
            int length2 = bArr.length ^ bArr2.length;
            for (int i = 0; i != length; i++) {
                length2 |= bArr[i] ^ bArr2[i];
            }
            while (length < bArr2.length) {
                byte b = bArr2[length];
                length2 |= b ^ (~b);
                length++;
            }
            if (length2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static int m(byte[] bArr, int i, f fVar) throws u0 {
        int iU = u(bArr, i, fVar);
        int i2 = fVar.a;
        if (i2 < 0) {
            throw u0.e();
        }
        if (i2 > bArr.length - iU) {
            throw u0.g();
        }
        if (i2 == 0) {
            fVar.c = l.b;
            return iU;
        }
        fVar.c = l.c(bArr, iU, i2);
        return iU + i2;
    }

    public static int n(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long o(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int p(s1 s1Var, byte[] bArr, int i, int i2, int i3, f fVar) throws u0 {
        Object objJ = s1Var.j();
        int iM = M(objJ, s1Var, bArr, i, i2, i3, fVar);
        s1Var.d(objJ);
        fVar.c = objJ;
        return iM;
    }

    public static int q(s1 s1Var, int i, byte[] bArr, int i2, int i3, r0 r0Var, f fVar) throws u0 {
        Object objJ = s1Var.j();
        s1 s1Var2 = s1Var;
        byte[] bArr2 = bArr;
        int i4 = i3;
        f fVar2 = fVar;
        int iN = N(objJ, s1Var2, bArr2, i2, i4, fVar2);
        s1Var2.d(objJ);
        fVar2.c = objJ;
        r0Var.add(objJ);
        while (iN < i4) {
            f fVar3 = fVar2;
            int i5 = i4;
            int iU = u(bArr2, iN, fVar3);
            if (i != fVar3.a) {
                break;
            }
            byte[] bArr3 = bArr2;
            s1 s1Var3 = s1Var2;
            Object objJ2 = s1Var3.j();
            iN = N(objJ2, s1Var3, bArr3, iU, i5, fVar3);
            s1Var2 = s1Var3;
            bArr2 = bArr3;
            i4 = i5;
            fVar2 = fVar3;
            s1Var2.d(objJ2);
            fVar2.c = objJ2;
            r0Var.add(objJ2);
        }
        return iN;
    }

    public static int r(int i, byte[] bArr, int i2, int i3, v1 v1Var, f fVar) throws u0 {
        if ((i >>> 3) == 0) {
            throw u0.a();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iW = w(bArr, i2, fVar);
            v1Var.f(i, Long.valueOf(fVar.b));
            return iW;
        }
        if (i4 == 1) {
            v1Var.f(i, Long.valueOf(o(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iU = u(bArr, i2, fVar);
            int i5 = fVar.a;
            if (i5 < 0) {
                throw u0.e();
            }
            if (i5 > bArr.length - iU) {
                throw u0.g();
            }
            if (i5 == 0) {
                v1Var.f(i, l.b);
            } else {
                v1Var.f(i, l.c(bArr, iU, i5));
            }
            return iU + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw u0.a();
            }
            v1Var.f(i, Integer.valueOf(n(bArr, i2)));
            return i2 + 4;
        }
        v1 v1Var2 = new v1();
        int i6 = (i & (-8)) | 4;
        int i7 = fVar.d + 1;
        fVar.d = i7;
        if (i7 >= 100) {
            throw new u0("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iU2 = u(bArr, i2, fVar);
            i8 = fVar.a;
            if (i8 == i6) {
                i2 = iU2;
                break;
            }
            i2 = r(i8, bArr, iU2, i3, v1Var2, fVar);
        }
        fVar.d--;
        if (i2 > i3 || i8 != i6) {
            throw u0.f();
        }
        v1Var.f(i, v1Var2);
        return i2;
    }

    public static int t(int i, byte[] bArr, int i2, f fVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            fVar.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            fVar.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            fVar.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            fVar.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                fVar.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int u(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return t(b, bArr, i2, fVar);
        }
        fVar.a = b;
        return i2;
    }

    public static int v(int i, byte[] bArr, int i2, int i3, r0 r0Var, f fVar) {
        k0 k0Var = (k0) r0Var;
        int iU = u(bArr, i2, fVar);
        k0Var.b(fVar.a);
        while (iU < i3) {
            int iU2 = u(bArr, iU, fVar);
            if (i != fVar.a) {
                break;
            }
            iU = u(bArr, iU2, fVar);
            k0Var.b(fVar.a);
        }
        return iU;
    }

    public static int w(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            fVar.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        fVar.b = j2;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0751  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.github.catvod.spider.merge.w.b x(java.lang.String r41) throws com.github.catvod.spider.merge.v.a {
        /*
            Method dump skipped, instructions count: 2296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.c2.x(java.lang.String):com.github.catvod.spider.merge.w.b");
    }

    public static int z(String str, byte[] bArr, int i, int i2) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length - i > i2) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
        return i + bytes.length;
    }

    public final boolean J(byte[] bArr, int i, int i2) {
        long j;
        long j2;
        long j3;
        int i3 = i;
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                while (i3 < i2 && bArr[i3] >= 0) {
                    i3++;
                }
                if (i3 < i2) {
                    while (i3 < i2) {
                        int i4 = i3 + 1;
                        byte b = bArr[i3];
                        if (b < 0) {
                            if (b < -32) {
                                if (i4 < i2 && b >= -62) {
                                    i3 += 2;
                                    if (bArr[i4] > -65) {
                                    }
                                }
                                return false;
                            }
                            if (b >= -16) {
                                if (i4 < i2 - 2) {
                                    int i5 = i3 + 2;
                                    byte b2 = bArr[i4];
                                    if (b2 <= -65 && (((b2 + 112) + (b << 28)) >> 30) == 0) {
                                        int i6 = i3 + 3;
                                        if (bArr[i5] <= -65) {
                                            i3 += 4;
                                            if (bArr[i6] > -65) {
                                            }
                                        }
                                    }
                                }
                                return false;
                            }
                            if (i4 < i2 - 1) {
                                int i7 = i3 + 2;
                                byte b3 = bArr[i4];
                                if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                                    i3 += 3;
                                    if (bArr[i7] > -65) {
                                    }
                                }
                            }
                            return false;
                        }
                        i3 = i4;
                    }
                }
                return true;
            default:
                if ((i3 | i2 | (bArr.length - i2)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i2)));
                }
                int i8 = 0;
                long j4 = i3;
                int i9 = i2 - i3;
                if (i9 < 16) {
                    j = j4;
                } else {
                    int i10 = 8 - (((int) j4) & 7);
                    j = j4;
                    long j5 = j;
                    while (true) {
                        if (i8 < i10) {
                            long j6 = j5 + 1;
                            if (b2.g(bArr, j5) >= 0) {
                                i8++;
                                j5 = j6;
                            }
                        } else {
                            while (true) {
                                int i11 = i8 + 8;
                                if (i11 <= i9 && (b2.c.h(bArr, b2.f + j5) & (-9187201950435737472L)) == 0) {
                                    j5 += 8;
                                    i8 = i11;
                                }
                            }
                            while (true) {
                                if (i8 < i9) {
                                    long j7 = j5 + 1;
                                    if (b2.g(bArr, j5) >= 0) {
                                        i8++;
                                        j5 = j7;
                                    }
                                } else {
                                    i8 = i9;
                                }
                            }
                        }
                    }
                }
                int i12 = i9 - i8;
                long j8 = j + i8;
                while (true) {
                    byte b4 = 0;
                    while (true) {
                        if (i12 > 0) {
                            long j9 = j8 + 1;
                            byte bG = b2.g(bArr, j8);
                            if (bG >= 0) {
                                i12--;
                                j8 = j9;
                                b4 = bG;
                            } else {
                                b4 = bG;
                                j2 = j9;
                            }
                        } else {
                            j2 = j8;
                        }
                    }
                    if (i12 == 0) {
                        return true;
                    }
                    int i13 = i12 - 1;
                    if (b4 < -32) {
                        if (i13 != 0) {
                            i12 -= 2;
                            if (b4 >= -62) {
                                long j10 = j2 + 1;
                                if (b2.g(bArr, j2) <= -65) {
                                    j3 = j10;
                                    j8 = j3;
                                }
                            }
                        }
                    } else if (b4 < -16) {
                        if (i13 >= 2) {
                            i12 -= 3;
                            long j11 = j2 + 1;
                            byte bG2 = b2.g(bArr, j2);
                            if (bG2 <= -65 && ((b4 != -32 || bG2 >= -96) && (b4 != -19 || bG2 < -96))) {
                                j3 = j2 + 2;
                                if (b2.g(bArr, j11) <= -65) {
                                    j8 = j3;
                                }
                            }
                        }
                    } else if (i13 >= 3) {
                        i12 -= 4;
                        long j12 = j2 + 1;
                        byte bG3 = b2.g(bArr, j2);
                        if (bG3 <= -65 && (((bG3 + 112) + (b4 << 28)) >> 30) == 0) {
                            long j13 = j2 + 2;
                            if (b2.g(bArr, j12) <= -65) {
                                j3 = j2 + 3;
                                if (b2.g(bArr, j13) <= -65) {
                                    j8 = j3;
                                }
                            }
                        }
                    }
                }
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String s(byte[] r11, int r12, int r13) throws com.github.catvod.spider.merge.u.u0 {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.c2.s(byte[], int, int):java.lang.String");
    }

    public final int y(String str, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char cCharAt;
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                int length = str.length();
                int i5 = i + i2;
                int i6 = 0;
                while (i6 < length && (i4 = i6 + i) < i5 && (cCharAt = str.charAt(i6)) < 128) {
                    bArr[i4] = (byte) cCharAt;
                    i6++;
                }
                if (i6 == length) {
                    return i + length;
                }
                int i7 = i + i6;
                while (i6 < length) {
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 < 128 && i7 < i5) {
                        bArr[i7] = (byte) cCharAt2;
                        i7++;
                    } else if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                        int i8 = i7 + 1;
                        bArr[i7] = (byte) ((cCharAt2 >>> 6) | 960);
                        i7 += 2;
                        bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                            if (i7 > i5 - 4) {
                                if (55296 > cCharAt2 || cCharAt2 > 57343 || ((i3 = i6 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i3)))) {
                                    throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                                }
                                return z(str, bArr, i, i2);
                            }
                            i6++;
                            if (i6 != str.length()) {
                                char cCharAt3 = str.charAt(i6);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i9 = i7 + 3;
                                    bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i7 += 4;
                                    bArr[i9] = (byte) ((codePoint & 63) | 128);
                                }
                            }
                            return z(str, bArr, i, i2);
                        }
                        bArr[i7] = (byte) ((cCharAt2 >>> '\f') | 480);
                        int i10 = i7 + 2;
                        bArr[i7 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i7 += 3;
                        bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i6++;
                }
                return i7;
            default:
                return z(str, bArr, i, i2);
        }
    }
}
