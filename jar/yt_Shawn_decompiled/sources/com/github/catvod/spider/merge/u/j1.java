package com.github.catvod.spider.merge.u;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j1 implements s1 {
    public static final int[] n = new int[0];
    public static final Unsafe o = b2.j();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final g1 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final l1 j;
    public final w0 k;
    public final w1 l;
    public final c1 m;

    public j1(int[] iArr, Object[] objArr, int i, int i2, g1 g1Var, int[] iArr2, int i3, int i4, l1 l1Var, w0 w0Var, w1 w1Var, z zVar, c1 c1Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = g1Var instanceof j0;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = l1Var;
        this.k = w0Var;
        this.l = w1Var;
        this.e = g1Var;
        this.m = c1Var;
    }

    public static long A(int i) {
        return i & 1048575;
    }

    public static int B(Object obj, long j) {
        return ((Integer) b2.c.i(obj, j)).intValue();
    }

    public static long C(Object obj, long j) {
        return ((Long) b2.c.i(obj, j)).longValue();
    }

    public static Field L(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("Field ", str, " for ");
            sbS.append(cls.getName());
            sbS.append(" not found. Known fields are ");
            sbS.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbS.toString(), e);
        }
    }

    public static int R(int i) {
        return (i & 267386880) >>> 20;
    }

    public static void l(Object obj) {
        if (s(obj)) {
            return;
        }
        com.github.catvod.spider.merge.b0.a.j("Mutating immutable message: ", obj);
    }

    public static boolean s(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof j0) {
            return ((j0) obj).isMutable();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0383  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.github.catvod.spider.merge.u.j1 z(com.github.catvod.spider.merge.u.r1 r34, com.github.catvod.spider.merge.u.l1 r35, com.github.catvod.spider.merge.u.w0 r36, com.github.catvod.spider.merge.u.w1 r37, com.github.catvod.spider.merge.u.z r38, com.github.catvod.spider.merge.u.c1 r39) {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.j1.z(com.github.catvod.spider.merge.u.r1, com.github.catvod.spider.merge.u.l1, com.github.catvod.spider.merge.u.w0, com.github.catvod.spider.merge.u.w1, com.github.catvod.spider.merge.u.z, com.github.catvod.spider.merge.u.c1):com.github.catvod.spider.merge.u.j1");
    }

    public final void D(int i, long j, Object obj) {
        Unsafe unsafe = o;
        Object objO = o(i);
        Object object = unsafe.getObject(obj, j);
        this.m.getClass();
        if (!((b1) object).a) {
            b1 b1VarB = b1.b.b();
            c1.a(b1VarB, object);
            unsafe.putObject(obj, j, b1VarB);
        }
        o.c(objO);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x029a, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r4;
        r4 = r13;
        r13 = r7;
        r7 = r4;
        r4 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014b, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r7;
        r7 = r13;
        r13 = r4;
        r4 = r33;
        r5 = r2;
        r2 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int E(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.github.catvod.spider.merge.u.f r35) {
        /*
            Method dump skipped, instructions count: 1280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.j1.E(java.lang.Object, byte[], int, int, int, com.github.catvod.spider.merge.u.f):int");
    }

    public final int F(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, f fVar) throws u0 {
        int i9;
        Unsafe unsafe = o;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(c2.o(bArr, i))));
                int i10 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(c2.n(bArr, i))));
                int i11 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iW = c2.w(bArr, i, fVar);
                unsafe.putObject(obj, j, Long.valueOf(fVar.b));
                unsafe.putInt(obj, j2, i4);
                return iW;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iU = c2.u(bArr, i, fVar);
                unsafe.putObject(obj, j, Integer.valueOf(fVar.a));
                unsafe.putInt(obj, j2, i4);
                return iU;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(c2.o(bArr, i)));
                int i12 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(c2.n(bArr, i)));
                int i13 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i13;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iW2 = c2.w(bArr, i, fVar);
                unsafe.putObject(obj, j, Boolean.valueOf(fVar.b != 0));
                unsafe.putInt(obj, j2, i4);
                return iW2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iU2 = c2.u(bArr, i, fVar);
                int i14 = fVar.a;
                if (i14 == 0) {
                    unsafe.putObject(obj, j, VideoStream.RESOLUTION_UNKNOWN);
                } else {
                    if ((i6 & 536870912) != 0) {
                        if (!e2.a.J(bArr, iU2, iU2 + i14)) {
                            throw u0.b();
                        }
                    }
                    unsafe.putObject(obj, j, new String(bArr, iU2, i14, StandardCharsets.UTF_8));
                    iU2 += i14;
                }
                unsafe.putInt(obj, j2, i4);
                return iU2;
            case 60:
                i9 = i;
                if (i5 == 2) {
                    Object objY = y(obj, i4, i8);
                    int iN = c2.N(objY, p(i8), bArr, i9, i2, fVar);
                    Q(obj, i4, i8, objY);
                    return iN;
                }
                break;
            case 61:
                i9 = i;
                if (i5 == 2) {
                    int iM = c2.m(bArr, i9, fVar);
                    unsafe.putObject(obj, j, fVar.c);
                    unsafe.putInt(obj, j2, i4);
                    return iM;
                }
                break;
            case 63:
                i9 = i;
                if (i5 == 0) {
                    int iU3 = c2.u(bArr, i9, fVar);
                    int i15 = fVar.a;
                    n(i8);
                    unsafe.putObject(obj, j, Integer.valueOf(i15));
                    unsafe.putInt(obj, j2, i4);
                    return iU3;
                }
                break;
            case 66:
                i9 = i;
                if (i5 == 0) {
                    int iU4 = c2.u(bArr, i9, fVar);
                    unsafe.putObject(obj, j, Integer.valueOf(p.b(fVar.a)));
                    unsafe.putInt(obj, j2, i4);
                    return iU4;
                }
                break;
            case 67:
                i9 = i;
                if (i5 == 0) {
                    int iW3 = c2.w(bArr, i9, fVar);
                    unsafe.putObject(obj, j, Long.valueOf(p.c(fVar.b)));
                    unsafe.putInt(obj, j2, i4);
                    return iW3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    Object objY2 = y(obj, i4, i8);
                    int iM2 = c2.M(objY2, p(i8), bArr, i, i2, (i3 & (-8)) | 4, fVar);
                    Q(obj, i4, i8, objY2);
                    return iM2;
                }
            default:
                return i;
        }
        return i9;
    }

    public final int G(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6, long j2, f fVar) throws u0 {
        int i7;
        int iV;
        Unsafe unsafe = o;
        r0 r0VarJ = (r0) unsafe.getObject(obj, j2);
        if (!((d) r0VarJ).a) {
            r0VarJ = r0VarJ.j(r0VarJ.size() * 2);
            unsafe.putObject(obj, j2, r0VarJ);
        }
        r0 r0Var = r0VarJ;
        switch (i6) {
            case 18:
            case PlaylistProtobufContinuation.ContinuationParams.PLAYLISTID_FIELD_NUMBER /* 35 */:
                if (i4 != 2) {
                    if (i4 != 1) {
                        return i;
                    }
                    v vVar = (v) r0Var;
                    vVar.b(Double.longBitsToDouble(c2.o(bArr, i)));
                    int i8 = i + 8;
                    while (i8 < i2) {
                        int iU = c2.u(bArr, i8, fVar);
                        if (i3 != fVar.a) {
                            return i8;
                        }
                        vVar.b(Double.longBitsToDouble(c2.o(bArr, iU)));
                        i8 = iU + 8;
                    }
                    return i8;
                }
                v vVar2 = (v) r0Var;
                int iU2 = c2.u(bArr, i, fVar);
                int i9 = fVar.a;
                int i10 = iU2 + i9;
                if (i10 > bArr.length) {
                    throw u0.g();
                }
                int i11 = (i9 / 8) + vVar2.c;
                double[] dArr = vVar2.b;
                if (i11 > dArr.length) {
                    if (dArr.length == 0) {
                        vVar2.b = new double[Math.max(i11, 10)];
                    } else {
                        int length = dArr.length;
                        while (length < i11) {
                            length = o.b(length, 3, 2, 1, 10);
                        }
                        vVar2.b = Arrays.copyOf(vVar2.b, length);
                    }
                }
                while (iU2 < i10) {
                    vVar2.b(Double.longBitsToDouble(c2.o(bArr, iU2)));
                    iU2 += 8;
                }
                if (iU2 == i10) {
                    return iU2;
                }
                throw u0.g();
            case 19:
            case 36:
                if (i4 != 2) {
                    if (i4 != 5) {
                        return i;
                    }
                    c0 c0Var = (c0) r0Var;
                    c0Var.b(Float.intBitsToFloat(c2.n(bArr, i)));
                    int i12 = i + 4;
                    while (i12 < i2) {
                        int iU3 = c2.u(bArr, i12, fVar);
                        if (i3 != fVar.a) {
                            return i12;
                        }
                        c0Var.b(Float.intBitsToFloat(c2.n(bArr, iU3)));
                        i12 = iU3 + 4;
                    }
                    return i12;
                }
                c0 c0Var2 = (c0) r0Var;
                int iU4 = c2.u(bArr, i, fVar);
                int i13 = fVar.a;
                int i14 = iU4 + i13;
                if (i14 > bArr.length) {
                    throw u0.g();
                }
                int i15 = (i13 / 4) + c0Var2.c;
                float[] fArr = c0Var2.b;
                if (i15 > fArr.length) {
                    if (fArr.length == 0) {
                        c0Var2.b = new float[Math.max(i15, 10)];
                    } else {
                        int length2 = fArr.length;
                        while (length2 < i15) {
                            length2 = o.b(length2, 3, 2, 1, 10);
                        }
                        c0Var2.b = Arrays.copyOf(c0Var2.b, length2);
                    }
                }
                while (iU4 < i14) {
                    c0Var2.b(Float.intBitsToFloat(c2.n(bArr, iU4)));
                    iU4 += 4;
                }
                if (iU4 == i14) {
                    return iU4;
                }
                throw u0.g();
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
            case 21:
            case 37:
            case 38:
                if (i4 == 2) {
                    y0 y0Var = (y0) r0Var;
                    int iU5 = c2.u(bArr, i, fVar);
                    int i16 = fVar.a + iU5;
                    while (iU5 < i16) {
                        iU5 = c2.w(bArr, iU5, fVar);
                        y0Var.b(fVar.b);
                    }
                    if (iU5 == i16) {
                        return iU5;
                    }
                    throw u0.g();
                }
                if (i4 != 0) {
                    return i;
                }
                y0 y0Var2 = (y0) r0Var;
                int iW = c2.w(bArr, i, fVar);
                y0Var2.b(fVar.b);
                while (iW < i2) {
                    int iU6 = c2.u(bArr, iW, fVar);
                    if (i3 != fVar.a) {
                        return iW;
                    }
                    iW = c2.w(bArr, iU6, fVar);
                    y0Var2.b(fVar.b);
                }
                return iW;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i4 != 2) {
                    return i4 == 0 ? c2.v(i3, bArr, i, i2, r0Var, fVar) : i;
                }
                k0 k0Var = (k0) r0Var;
                int iU7 = c2.u(bArr, i, fVar);
                int i17 = fVar.a + iU7;
                while (iU7 < i17) {
                    iU7 = c2.u(bArr, iU7, fVar);
                    k0Var.b(fVar.a);
                }
                if (iU7 == i17) {
                    return iU7;
                }
                throw u0.g();
            case 23:
            case 32:
            case 40:
            case 46:
                if (i4 != 2) {
                    if (i4 != 1) {
                        return i;
                    }
                    y0 y0Var3 = (y0) r0Var;
                    y0Var3.b(c2.o(bArr, i));
                    int i18 = i + 8;
                    while (i18 < i2) {
                        int iU8 = c2.u(bArr, i18, fVar);
                        if (i3 != fVar.a) {
                            return i18;
                        }
                        y0Var3.b(c2.o(bArr, iU8));
                        i18 = iU8 + 8;
                    }
                    return i18;
                }
                y0 y0Var4 = (y0) r0Var;
                int iU9 = c2.u(bArr, i, fVar);
                int i19 = fVar.a;
                int i20 = iU9 + i19;
                if (i20 > bArr.length) {
                    throw u0.g();
                }
                int i21 = (i19 / 8) + y0Var4.c;
                long[] jArr = y0Var4.b;
                if (i21 > jArr.length) {
                    if (jArr.length == 0) {
                        y0Var4.b = new long[Math.max(i21, 10)];
                    } else {
                        int length3 = jArr.length;
                        while (length3 < i21) {
                            length3 = o.b(length3, 3, 2, 1, 10);
                        }
                        y0Var4.b = Arrays.copyOf(y0Var4.b, length3);
                    }
                }
                while (iU9 < i20) {
                    y0Var4.b(c2.o(bArr, iU9));
                    iU9 += 8;
                }
                if (iU9 == i20) {
                    return iU9;
                }
                throw u0.g();
            case 24:
            case 31:
            case 41:
            case 45:
                if (i4 != 2) {
                    if (i4 != 5) {
                        return i;
                    }
                    k0 k0Var2 = (k0) r0Var;
                    k0Var2.b(c2.n(bArr, i));
                    int i22 = i + 4;
                    while (i22 < i2) {
                        int iU10 = c2.u(bArr, i22, fVar);
                        if (i3 != fVar.a) {
                            return i22;
                        }
                        k0Var2.b(c2.n(bArr, iU10));
                        i22 = iU10 + 4;
                    }
                    return i22;
                }
                k0 k0Var3 = (k0) r0Var;
                int iU11 = c2.u(bArr, i, fVar);
                int i23 = fVar.a;
                int i24 = iU11 + i23;
                if (i24 > bArr.length) {
                    throw u0.g();
                }
                int i25 = (i23 / 4) + k0Var3.c;
                int[] iArr = k0Var3.b;
                if (i25 > iArr.length) {
                    if (iArr.length == 0) {
                        k0Var3.b = new int[Math.max(i25, 10)];
                    } else {
                        int length4 = iArr.length;
                        while (length4 < i25) {
                            length4 = o.b(length4, 3, 2, 1, 10);
                        }
                        k0Var3.b = Arrays.copyOf(k0Var3.b, length4);
                    }
                }
                while (iU11 < i24) {
                    k0Var3.b(c2.n(bArr, iU11));
                    iU11 += 4;
                }
                if (iU11 == i24) {
                    return iU11;
                }
                throw u0.g();
            case 25:
            case 42:
                if (i4 == 2) {
                    g gVar = (g) r0Var;
                    int iU12 = c2.u(bArr, i, fVar);
                    int i26 = fVar.a + iU12;
                    while (iU12 < i26) {
                        iU12 = c2.w(bArr, iU12, fVar);
                        gVar.b(fVar.b != 0);
                    }
                    if (iU12 == i26) {
                        return iU12;
                    }
                    throw u0.g();
                }
                if (i4 != 0) {
                    return i;
                }
                g gVar2 = (g) r0Var;
                int iW2 = c2.w(bArr, i, fVar);
                gVar2.b(fVar.b != 0);
                while (iW2 < i2) {
                    int iU13 = c2.u(bArr, iW2, fVar);
                    if (i3 != fVar.a) {
                        return iW2;
                    }
                    iW2 = c2.w(bArr, iU13, fVar);
                    gVar2.b(fVar.b != 0);
                }
                return iW2;
            case 26:
                if (i4 != 2) {
                    return i;
                }
                if ((j & 536870912) == 0) {
                    int iU14 = c2.u(bArr, i, fVar);
                    int i27 = fVar.a;
                    if (i27 < 0) {
                        throw u0.e();
                    }
                    if (i27 == 0) {
                        r0Var.add(VideoStream.RESOLUTION_UNKNOWN);
                    } else {
                        r0Var.add(new String(bArr, iU14, i27, StandardCharsets.UTF_8));
                        iU14 += i27;
                    }
                    while (iU14 < i2) {
                        int iU15 = c2.u(bArr, iU14, fVar);
                        if (i3 != fVar.a) {
                            return iU14;
                        }
                        iU14 = c2.u(bArr, iU15, fVar);
                        int i28 = fVar.a;
                        if (i28 < 0) {
                            throw u0.e();
                        }
                        if (i28 == 0) {
                            r0Var.add(VideoStream.RESOLUTION_UNKNOWN);
                        } else {
                            r0Var.add(new String(bArr, iU14, i28, StandardCharsets.UTF_8));
                            iU14 += i28;
                        }
                    }
                    return iU14;
                }
                int iU16 = c2.u(bArr, i, fVar);
                int i29 = fVar.a;
                if (i29 < 0) {
                    throw u0.e();
                }
                if (i29 == 0) {
                    r0Var.add(VideoStream.RESOLUTION_UNKNOWN);
                } else {
                    int i30 = iU16 + i29;
                    if (!e2.a.J(bArr, iU16, i30)) {
                        throw u0.b();
                    }
                    r0Var.add(new String(bArr, iU16, i29, StandardCharsets.UTF_8));
                    iU16 = i30;
                }
                while (iU16 < i2) {
                    int iU17 = c2.u(bArr, iU16, fVar);
                    if (i3 != fVar.a) {
                        return iU16;
                    }
                    iU16 = c2.u(bArr, iU17, fVar);
                    int i31 = fVar.a;
                    if (i31 < 0) {
                        throw u0.e();
                    }
                    if (i31 == 0) {
                        r0Var.add(VideoStream.RESOLUTION_UNKNOWN);
                    } else {
                        int i32 = iU16 + i31;
                        if (!e2.a.J(bArr, iU16, i32)) {
                            throw u0.b();
                        }
                        r0Var.add(new String(bArr, iU16, i31, StandardCharsets.UTF_8));
                        iU16 = i32;
                    }
                }
                return iU16;
            case 27:
                i7 = i;
                if (i4 == 2) {
                    return c2.q(p(i5), i3, bArr, i7, i2, r0Var, fVar);
                }
                break;
            case 28:
                i7 = i;
                if (i4 == 2) {
                    int iU18 = c2.u(bArr, i7, fVar);
                    int i33 = fVar.a;
                    if (i33 < 0) {
                        throw u0.e();
                    }
                    if (i33 > bArr.length - iU18) {
                        throw u0.g();
                    }
                    if (i33 == 0) {
                        r0Var.add(l.b);
                    } else {
                        r0Var.add(l.c(bArr, iU18, i33));
                        iU18 += i33;
                    }
                    while (iU18 < i2) {
                        int iU19 = c2.u(bArr, iU18, fVar);
                        if (i3 != fVar.a) {
                            return iU18;
                        }
                        iU18 = c2.u(bArr, iU19, fVar);
                        int i34 = fVar.a;
                        if (i34 < 0) {
                            throw u0.e();
                        }
                        if (i34 > bArr.length - iU18) {
                            throw u0.g();
                        }
                        if (i34 == 0) {
                            r0Var.add(l.b);
                        } else {
                            r0Var.add(l.c(bArr, iU18, i34));
                            iU18 += i34;
                        }
                    }
                    return iU18;
                }
                break;
            case 30:
            case 44:
                i7 = i;
                if (i4 == 2) {
                    k0 k0Var4 = (k0) r0Var;
                    iV = c2.u(bArr, i7, fVar);
                    int i35 = fVar.a + iV;
                    while (iV < i35) {
                        iV = c2.u(bArr, iV, fVar);
                        k0Var4.b(fVar.a);
                    }
                    if (iV != i35) {
                        throw u0.g();
                    }
                } else if (i4 == 0) {
                    iV = c2.v(i3, bArr, i7, i2, r0Var, fVar);
                }
                n(i5);
                Class cls = t1.a;
                return iV;
            case 33:
            case 47:
                i7 = i;
                if (i4 == 2) {
                    k0 k0Var5 = (k0) r0Var;
                    int iU20 = c2.u(bArr, i7, fVar);
                    int i36 = fVar.a + iU20;
                    while (iU20 < i36) {
                        iU20 = c2.u(bArr, iU20, fVar);
                        k0Var5.b(p.b(fVar.a));
                    }
                    if (iU20 == i36) {
                        return iU20;
                    }
                    throw u0.g();
                }
                if (i4 == 0) {
                    k0 k0Var6 = (k0) r0Var;
                    int iU21 = c2.u(bArr, i7, fVar);
                    k0Var6.b(p.b(fVar.a));
                    while (iU21 < i2) {
                        int iU22 = c2.u(bArr, iU21, fVar);
                        if (i3 != fVar.a) {
                            return iU21;
                        }
                        iU21 = c2.u(bArr, iU22, fVar);
                        k0Var6.b(p.b(fVar.a));
                    }
                    return iU21;
                }
                break;
            case 34:
            case 48:
                i7 = i;
                if (i4 == 2) {
                    y0 y0Var5 = (y0) r0Var;
                    int iU23 = c2.u(bArr, i7, fVar);
                    int i37 = fVar.a + iU23;
                    while (iU23 < i37) {
                        iU23 = c2.w(bArr, iU23, fVar);
                        y0Var5.b(p.c(fVar.b));
                    }
                    if (iU23 == i37) {
                        return iU23;
                    }
                    throw u0.g();
                }
                if (i4 == 0) {
                    y0 y0Var6 = (y0) r0Var;
                    int iW3 = c2.w(bArr, i7, fVar);
                    y0Var6.b(p.c(fVar.b));
                    while (iW3 < i2) {
                        int iU24 = c2.u(bArr, iW3, fVar);
                        if (i3 != fVar.a) {
                            return iW3;
                        }
                        iW3 = c2.w(bArr, iU24, fVar);
                        y0Var6.b(p.c(fVar.b));
                    }
                    return iW3;
                }
                break;
            case 49:
                if (i4 == 3) {
                    s1 s1VarP = p(i5);
                    int i38 = (i3 & (-8)) | 4;
                    int iP = c2.p(s1VarP, bArr, i, i2, i38, fVar);
                    byte[] bArr2 = bArr;
                    int i39 = i2;
                    int i40 = i38;
                    f fVar2 = fVar;
                    r0Var.add(fVar2.c);
                    while (iP < i39) {
                        int iU25 = c2.u(bArr2, iP, fVar2);
                        if (i3 != fVar2.a) {
                            return iP;
                        }
                        byte[] bArr3 = bArr2;
                        int i41 = i39;
                        f fVar3 = fVar2;
                        int i42 = i40;
                        iP = c2.p(s1VarP, bArr3, iU25, i41, i42, fVar3);
                        r0Var.add(fVar3.c);
                        i40 = i42;
                        bArr2 = bArr3;
                        i39 = i41;
                        fVar2 = fVar3;
                    }
                    return iP;
                }
            default:
                return i;
        }
        return i7;
    }

    public final void H(Object obj, long j, q qVar, s1 s1Var, y yVar) throws t0 {
        int iZ;
        this.k.getClass();
        r0 r0VarA = w0.a(obj, j);
        p pVar = qVar.a;
        int i = qVar.b;
        if ((i & 7) != 3) {
            throw u0.c();
        }
        do {
            Object objJ = s1Var.j();
            qVar.b(objJ, s1Var, yVar);
            s1Var.d(objJ);
            r0VarA.add(objJ);
            if (pVar.e() || qVar.d != 0) {
                return;
            } else {
                iZ = pVar.z();
            }
        } while (iZ == i);
        qVar.d = iZ;
    }

    public final void I(Object obj, int i, q qVar, s1 s1Var, y yVar) throws u0 {
        int iZ;
        this.k.getClass();
        r0 r0VarA = w0.a(obj, i & 1048575);
        p pVar = qVar.a;
        int i2 = qVar.b;
        if ((i2 & 7) != 2) {
            throw u0.c();
        }
        do {
            Object objJ = s1Var.j();
            qVar.c(objJ, s1Var, yVar);
            s1Var.d(objJ);
            r0VarA.add(objJ);
            if (pVar.e() || qVar.d != 0) {
                return;
            } else {
                iZ = pVar.z();
            }
        } while (iZ == i2);
        qVar.d = iZ;
    }

    public final void J(int i, q qVar, Object obj) throws t0 {
        if ((536870912 & i) != 0) {
            qVar.v(2);
            b2.p(obj, i & 1048575, qVar.a.y());
        } else if (!this.f) {
            b2.p(obj, i & 1048575, qVar.e());
        } else {
            qVar.v(2);
            b2.p(obj, i & 1048575, qVar.a.x());
        }
    }

    public final void K(int i, q qVar, Object obj) throws t0 {
        boolean z = (536870912 & i) != 0;
        w0 w0Var = this.k;
        if (z) {
            w0Var.getClass();
            qVar.r(w0.a(obj, i & 1048575), true);
        } else {
            w0Var.getClass();
            qVar.r(w0.a(obj, i & 1048575), false);
        }
    }

    public final void M(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        b2.n((1 << (i2 >>> 20)) | b2.c.g(obj, j), j, obj);
    }

    public final void N(Object obj, int i, int i2) {
        b2.n(i, this.a[i2 + 2] & 1048575, obj);
    }

    public final int O(int i, int i2) {
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void P(int i, Object obj, Object obj2) {
        o.putObject(obj, S(i) & 1048575, obj2);
        M(i, obj);
    }

    public final void Q(Object obj, int i, int i2, Object obj2) {
        o.putObject(obj, S(i2) & 1048575, obj2);
        N(obj, i, i2);
    }

    public final int S(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void T(Object obj, a1 a1Var) {
        char c;
        int i;
        int i2;
        j1 j1Var = this;
        u uVar = (u) a1Var.a;
        int[] iArr = j1Var.a;
        int length = iArr.length;
        Unsafe unsafe = o;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 1048575;
        int i6 = 0;
        while (i4 < length) {
            int iS = j1Var.S(i4);
            int i7 = iArr[i4];
            int iR = R(iS);
            if (iR <= 17) {
                int i8 = iArr[i4 + 2];
                c = 1;
                int i9 = i8 & i3;
                if (i9 != i5) {
                    i6 = i9 == i3 ? 0 : unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = iS;
                i2 = 1 << (i8 >>> 20);
            } else {
                c = 1;
                i = iS;
                i2 = 0;
            }
            long j = i & i3;
            switch (iR) {
                case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        double dE = b2.c.e(obj, j);
                        uVar.getClass();
                        uVar.l(i7, Double.doubleToRawLongBits(dE));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 1:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        float f = b2.c.f(obj, j);
                        uVar.getClass();
                        uVar.j(i7, Float.floatToRawIntBits(f));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 2:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.u(i7, unsafe.getLong(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 3:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.u(i7, unsafe.getLong(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 4:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.n(i7, unsafe.getInt(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 5:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.l(i7, unsafe.getLong(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 6:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.j(i7, unsafe.getInt(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 7:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.h(i7, b2.c.c(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 8:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            uVar.q(i7, (String) object);
                        } else {
                            uVar.i(i7, (l) object);
                        }
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 9:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        a1Var.b(i7, unsafe.getObject(obj, j), j1Var.p(i4));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.i(i7, (l) unsafe.getObject(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 11:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.s(i7, unsafe.getInt(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.n(i7, unsafe.getInt(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 13:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.j(i7, unsafe.getInt(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 14:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        uVar.l(i7, unsafe.getLong(obj, j));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 15:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        int i10 = unsafe.getInt(obj, j);
                        uVar.s(i7, (i10 >> 31) ^ (i10 << 1));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 16:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        long j2 = unsafe.getLong(obj, j);
                        uVar.u(i7, (j2 << 1) ^ (j2 >> 63));
                    }
                    j1Var = this;
                    i4 += 3;
                    i3 = 1048575;
                case 17:
                    if (j1Var.r(obj, i4, i5, i6, i2)) {
                        a1Var.a(i7, unsafe.getObject(obj, j), j1Var.p(i4));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 18:
                    t1.n(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 19:
                    t1.r(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                    t1.t(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 21:
                    t1.z(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 22:
                    t1.s(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 23:
                    t1.q(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 24:
                    t1.p(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 25:
                    t1.m(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 26:
                    int i11 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = t1.a;
                    if (list != null && !list.isEmpty()) {
                        for (int i12 = 0; i12 < list.size(); i12++) {
                            uVar.q(i11, (String) list.get(i12));
                        }
                    }
                    i4 += 3;
                    i3 = 1048575;
                    break;
                case 27:
                    int i13 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    s1 s1VarP = j1Var.p(i4);
                    Class cls2 = t1.a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i14 = 0; i14 < list2.size(); i14++) {
                            a1Var.b(i13, list2.get(i14), s1VarP);
                        }
                    }
                    i4 += 3;
                    i3 = 1048575;
                    break;
                case 28:
                    int i15 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = t1.a;
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i16 = 0; i16 < list3.size(); i16++) {
                            uVar.i(i15, (l) list3.get(i16));
                        }
                    }
                    i4 += 3;
                    i3 = 1048575;
                    break;
                case 29:
                    t1.y(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 30:
                    t1.o(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 31:
                    t1.u(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 32:
                    t1.v(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 33:
                    t1.w(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case 34:
                    t1.x(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, false);
                    i4 += 3;
                    i3 = 1048575;
                case PlaylistProtobufContinuation.ContinuationParams.PLAYLISTID_FIELD_NUMBER /* 35 */:
                    t1.n(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 36:
                    t1.r(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 37:
                    t1.t(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 38:
                    t1.z(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 39:
                    t1.s(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 40:
                    t1.q(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 41:
                    t1.p(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 42:
                    t1.m(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 43:
                    t1.y(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 44:
                    t1.o(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 45:
                    t1.u(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 46:
                    t1.v(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 47:
                    t1.w(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 48:
                    t1.x(iArr[i4], (List) unsafe.getObject(obj, j), a1Var, true);
                    i4 += 3;
                    i3 = 1048575;
                case 49:
                    int i17 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    s1 s1VarP2 = j1Var.p(i4);
                    Class cls4 = t1.a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            a1Var.a(i17, list4.get(i18), s1VarP2);
                        }
                    }
                    i4 += 3;
                    i3 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        Object objO = j1Var.o(i4);
                        j1Var.m.getClass();
                        o.c(objO);
                        throw null;
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 51:
                    if (j1Var.t(obj, i7, i4)) {
                        double dDoubleValue = ((Double) b2.c.i(obj, j)).doubleValue();
                        uVar.getClass();
                        uVar.l(i7, Double.doubleToRawLongBits(dDoubleValue));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 52:
                    if (j1Var.t(obj, i7, i4)) {
                        float fFloatValue = ((Float) b2.c.i(obj, j)).floatValue();
                        uVar.getClass();
                        uVar.j(i7, Float.floatToRawIntBits(fFloatValue));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 53:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.u(i7, C(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 54:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.u(i7, C(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 55:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.n(i7, B(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 56:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.l(i7, C(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 57:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.j(i7, B(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 58:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.h(i7, ((Boolean) b2.c.i(obj, j)).booleanValue());
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 59:
                    if (j1Var.t(obj, i7, i4)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof String) {
                            uVar.q(i7, (String) object2);
                        } else {
                            uVar.i(i7, (l) object2);
                        }
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 60:
                    if (j1Var.t(obj, i7, i4)) {
                        a1Var.b(i7, unsafe.getObject(obj, j), j1Var.p(i4));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 61:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.i(i7, (l) unsafe.getObject(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 62:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.s(i7, B(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 63:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.n(i7, B(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 64:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.j(i7, B(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 65:
                    if (j1Var.t(obj, i7, i4)) {
                        uVar.l(i7, C(obj, j));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 66:
                    if (j1Var.t(obj, i7, i4)) {
                        int iB = B(obj, j);
                        uVar.s(i7, (iB >> 31) ^ (iB << 1));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 67:
                    if (j1Var.t(obj, i7, i4)) {
                        long jC = C(obj, j);
                        uVar.u(i7, (jC << c) ^ (jC >> 63));
                    }
                    i4 += 3;
                    i3 = 1048575;
                case 68:
                    if (j1Var.t(obj, i7, i4)) {
                        a1Var.a(i7, unsafe.getObject(obj, j), j1Var.p(i4));
                    }
                    i4 += 3;
                    i3 = 1048575;
                default:
                    i4 += 3;
                    i3 = 1048575;
            }
        }
        j1Var.l.getClass();
        ((j0) obj).unknownFields.g(a1Var);
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final int a(j0 j0Var) {
        int i;
        int iA;
        int length = this.a.length;
        int iHashCode = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int iS = S(i2);
            int iR = R(iS);
            if (iR <= 50 || iR >= 69) {
                long j = 1048575 & iS;
                int iHashCode2 = 37;
                switch (iR) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        i = iHashCode * 53;
                        iA = s0.a(Double.doubleToLongBits(b2.c.e(j0Var, j)));
                        iHashCode = i + iA;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iA = Float.floatToIntBits(b2.c.f(j0Var, j));
                        iHashCode = i + iA;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        iA = s0.a(b2.c.h(j0Var, j));
                        iHashCode = i + iA;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        iA = s0.a(b2.c.h(j0Var, j));
                        iHashCode = i + iA;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iA = b2.c.g(j0Var, j);
                        iHashCode = i + iA;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        iA = s0.a(b2.c.h(j0Var, j));
                        iHashCode = i + iA;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iA = b2.c.g(j0Var, j);
                        iHashCode = i + iA;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        boolean zC = b2.c.c(j0Var, j);
                        byte[] bArr = s0.a;
                        iA = zC ? 1231 : 1237;
                        iHashCode = i + iA;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iA = ((String) b2.c.i(j0Var, j)).hashCode();
                        iHashCode = i + iA;
                        break;
                    case 9:
                        Object objI = b2.c.i(j0Var, j);
                        if (objI != null) {
                            iHashCode2 = objI.hashCode();
                        }
                        iHashCode = (iHashCode * 53) + iHashCode2;
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        i = iHashCode * 53;
                        iA = b2.c.i(j0Var, j).hashCode();
                        iHashCode = i + iA;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iA = b2.c.g(j0Var, j);
                        iHashCode = i + iA;
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        i = iHashCode * 53;
                        iA = b2.c.g(j0Var, j);
                        iHashCode = i + iA;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iA = b2.c.g(j0Var, j);
                        iHashCode = i + iA;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        iA = s0.a(b2.c.h(j0Var, j));
                        iHashCode = i + iA;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iA = b2.c.g(j0Var, j);
                        iHashCode = i + iA;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        iA = s0.a(b2.c.h(j0Var, j));
                        iHashCode = i + iA;
                        break;
                    case 17:
                        Object objI2 = b2.c.i(j0Var, j);
                        if (objI2 != null) {
                            iHashCode2 = objI2.hashCode();
                        }
                        iHashCode = (iHashCode * 53) + iHashCode2;
                        break;
                    case 18:
                    case 19:
                    case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case PlaylistProtobufContinuation.ContinuationParams.PLAYLISTID_FIELD_NUMBER /* 35 */:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        i = iHashCode * 53;
                        iA = b2.c.i(j0Var, j).hashCode();
                        iHashCode = i + iA;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iA = b2.c.i(j0Var, j).hashCode();
                        iHashCode = i + iA;
                        break;
                }
            }
        }
        int i3 = this.i;
        while (true) {
            int[] iArr = this.g;
            if (i3 >= iArr.length) {
                this.l.getClass();
                return j0Var.unknownFields.hashCode() + (iHashCode * 53);
            }
            if (!t(j0Var, 0, iArr[i3])) {
                iHashCode = b2.c.i(j0Var, S(r2) & 1048575).hashCode() + (iHashCode * 53);
            }
            i3++;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.github.catvod.spider.merge.u.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.j1.b(java.lang.Object, java.lang.Object):void");
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final boolean c(j0 j0Var, j0 j0Var2) {
        int[] iArr = this.a;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean zL = true;
            if (i < length) {
                int iS = S(i);
                int iR = R(iS);
                if (iR <= 50 || iR >= 69) {
                    long j = iS & 1048575;
                    switch (iR) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var = b2.c;
                                if (Double.doubleToLongBits(a2Var.e(j0Var, j)) != Double.doubleToLongBits(a2Var.e(j0Var2, j))) {
                                }
                            }
                            zL = false;
                            break;
                        case 1:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var2 = b2.c;
                                if (Float.floatToIntBits(a2Var2.f(j0Var, j)) != Float.floatToIntBits(a2Var2.f(j0Var2, j))) {
                                }
                            }
                            zL = false;
                            break;
                        case 2:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var3 = b2.c;
                                if (a2Var3.h(j0Var, j) != a2Var3.h(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 3:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var4 = b2.c;
                                if (a2Var4.h(j0Var, j) != a2Var4.h(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 4:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var5 = b2.c;
                                if (a2Var5.g(j0Var, j) != a2Var5.g(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 5:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var6 = b2.c;
                                if (a2Var6.h(j0Var, j) != a2Var6.h(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 6:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var7 = b2.c;
                                if (a2Var7.g(j0Var, j) != a2Var7.g(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 7:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var8 = b2.c;
                                if (a2Var8.c(j0Var, j) != a2Var8.c(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 8:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var9 = b2.c;
                                if (!t1.l(a2Var9.i(j0Var, j), a2Var9.i(j0Var2, j))) {
                                }
                            }
                            zL = false;
                            break;
                        case 9:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var10 = b2.c;
                                if (!t1.l(a2Var10.i(j0Var, j), a2Var10.i(j0Var2, j))) {
                                }
                            }
                            zL = false;
                            break;
                        case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var11 = b2.c;
                                if (!t1.l(a2Var11.i(j0Var, j), a2Var11.i(j0Var2, j))) {
                                }
                            }
                            zL = false;
                            break;
                        case 11:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var12 = b2.c;
                                if (a2Var12.g(j0Var, j) != a2Var12.g(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var13 = b2.c;
                                if (a2Var13.g(j0Var, j) != a2Var13.g(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 13:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var14 = b2.c;
                                if (a2Var14.g(j0Var, j) != a2Var14.g(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 14:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var15 = b2.c;
                                if (a2Var15.h(j0Var, j) != a2Var15.h(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 15:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var16 = b2.c;
                                if (a2Var16.g(j0Var, j) != a2Var16.g(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 16:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var17 = b2.c;
                                if (a2Var17.h(j0Var, j) != a2Var17.h(j0Var2, j)) {
                                }
                            }
                            zL = false;
                            break;
                        case 17:
                            if (k(j0Var, j0Var2, i)) {
                                a2 a2Var18 = b2.c;
                                if (!t1.l(a2Var18.i(j0Var, j), a2Var18.i(j0Var2, j))) {
                                }
                            }
                            zL = false;
                            break;
                        case 18:
                        case 19:
                        case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case PlaylistProtobufContinuation.ContinuationParams.PLAYLISTID_FIELD_NUMBER /* 35 */:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            a2 a2Var19 = b2.c;
                            zL = t1.l(a2Var19.i(j0Var, j), a2Var19.i(j0Var2, j));
                            break;
                        case 50:
                            a2 a2Var20 = b2.c;
                            zL = t1.l(a2Var20.i(j0Var, j), a2Var20.i(j0Var2, j));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                            long j2 = 1048575 & iArr[i + 2];
                            a2 a2Var21 = b2.c;
                            if (a2Var21.g(j0Var, j2) != a2Var21.g(j0Var2, j2) || !t1.l(a2Var21.i(j0Var, j), a2Var21.i(j0Var2, j))) {
                                zL = false;
                                break;
                            }
                            break;
                    }
                    if (!zL) {
                    }
                }
                i += 3;
            } else {
                int i2 = this.i;
                while (true) {
                    int[] iArr2 = this.g;
                    if (i2 < iArr2.length) {
                        int i3 = iArr2[i2];
                        long j3 = iArr[i3 + 2] & 1048575;
                        a2 a2Var22 = b2.c;
                        if (a2Var22.g(j0Var, j3) != a2Var22.g(j0Var2, j3)) {
                            return false;
                        }
                        if (!t(j0Var, 0, i3)) {
                            long jS = S(i3) & 1048575;
                            if (!t1.l(a2Var22.i(j0Var, jS), a2Var22.i(j0Var2, jS))) {
                            }
                        }
                        i2++;
                    } else {
                        this.l.getClass();
                        if (j0Var.unknownFields.equals(j0Var2.unknownFields)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    @Override // com.github.catvod.spider.merge.u.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = s(r10)
            if (r0 != 0) goto L8
            goto La3
        L8:
            boolean r0 = r10 instanceof com.github.catvod.spider.merge.u.j0
            if (r0 == 0) goto L18
            r0 = r10
            com.github.catvod.spider.merge.u.j0 r0 = (com.github.catvod.spider.merge.u.j0) r0
            r0.clearMemoizedSerializedSize()
            r0.clearMemoizedHashCode()
            r0.markImmutable()
        L18:
            int[] r0 = r9.a
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L1d:
            if (r3 >= r1) goto L94
            int r4 = r9.S(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            long r5 = (long) r5
            int r4 = R(r4)
            r7 = 9
            if (r4 == r7) goto L7e
            r7 = 60
            if (r4 == r7) goto L68
            r7 = 68
            if (r4 == r7) goto L68
            switch(r4) {
                case 17: goto L7e;
                case 18: goto L52;
                case 19: goto L52;
                case 20: goto L52;
                case 21: goto L52;
                case 22: goto L52;
                case 23: goto L52;
                case 24: goto L52;
                case 25: goto L52;
                case 26: goto L52;
                case 27: goto L52;
                case 28: goto L52;
                case 29: goto L52;
                case 30: goto L52;
                case 31: goto L52;
                case 32: goto L52;
                case 33: goto L52;
                case 34: goto L52;
                case 35: goto L52;
                case 36: goto L52;
                case 37: goto L52;
                case 38: goto L52;
                case 39: goto L52;
                case 40: goto L52;
                case 41: goto L52;
                case 42: goto L52;
                case 43: goto L52;
                case 44: goto L52;
                case 45: goto L52;
                case 46: goto L52;
                case 47: goto L52;
                case 48: goto L52;
                case 49: goto L52;
                case 50: goto L3c;
                default: goto L3b;
            }
        L3b:
            goto L91
        L3c:
            sun.misc.Unsafe r4 = com.github.catvod.spider.merge.u.j1.o
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L91
            com.github.catvod.spider.merge.u.c1 r8 = r9.m
            r8.getClass()
            r8 = r7
            com.github.catvod.spider.merge.u.b1 r8 = (com.github.catvod.spider.merge.u.b1) r8
            r8.a = r2
            r4.putObject(r10, r5, r7)
            goto L91
        L52:
            com.github.catvod.spider.merge.u.w0 r4 = r9.k
            r4.getClass()
            com.github.catvod.spider.merge.u.a2 r4 = com.github.catvod.spider.merge.u.b2.c
            java.lang.Object r4 = r4.i(r10, r5)
            com.github.catvod.spider.merge.u.r0 r4 = (com.github.catvod.spider.merge.u.r0) r4
            com.github.catvod.spider.merge.u.d r4 = (com.github.catvod.spider.merge.u.d) r4
            boolean r5 = r4.a
            if (r5 == 0) goto L91
            r4.a = r2
            goto L91
        L68:
            r4 = r0[r3]
            boolean r4 = r9.t(r10, r4, r3)
            if (r4 == 0) goto L91
            com.github.catvod.spider.merge.u.s1 r4 = r9.p(r3)
            sun.misc.Unsafe r7 = com.github.catvod.spider.merge.u.j1.o
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.d(r5)
            goto L91
        L7e:
            boolean r4 = r9.q(r3, r10)
            if (r4 == 0) goto L91
            com.github.catvod.spider.merge.u.s1 r4 = r9.p(r3)
            sun.misc.Unsafe r7 = com.github.catvod.spider.merge.u.j1.o
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.d(r5)
        L91:
            int r3 = r3 + 3
            goto L1d
        L94:
            com.github.catvod.spider.merge.u.w1 r0 = r9.l
            r0.getClass()
            com.github.catvod.spider.merge.u.j0 r10 = (com.github.catvod.spider.merge.u.j0) r10
            com.github.catvod.spider.merge.u.v1 r10 = r10.unknownFields
            boolean r0 = r10.e
            if (r0 == 0) goto La3
            r10.e = r2
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.j1.d(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x033f  */
    @Override // com.github.catvod.spider.merge.u.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int e(com.github.catvod.spider.merge.u.j0 r18) throws com.github.catvod.spider.merge.u.d2 {
        /*
            Method dump skipped, instructions count: 1774
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.j1.e(com.github.catvod.spider.merge.u.j0):int");
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void f(Object obj, byte[] bArr, int i, int i2, f fVar) {
        E(obj, bArr, i, i2, 0, fVar);
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final boolean g(Object obj) {
        int i;
        int i2;
        Object obj2;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < this.h) {
            int i6 = this.g[i3];
            int iS = S(i6);
            int[] iArr = this.a;
            int i7 = iArr[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i4) {
                if (i8 != 1048575) {
                    i5 = o.getInt(obj, i8);
                }
                i2 = i5;
                i = i8;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iS) != 0) {
                obj2 = obj;
                if (!r(obj2, i6, i, i2, i9)) {
                }
                return false;
            }
            obj2 = obj;
            int iR = R(iS);
            if (iR == 9 || iR == 17) {
                if (r(obj2, i6, i, i2, i9)) {
                    if (!p(i6).g(b2.c.i(obj2, iS & 1048575))) {
                        return false;
                    }
                } else {
                    continue;
                }
                i3++;
                obj = obj2;
                i4 = i;
                i5 = i2;
            } else {
                if (iR != 27) {
                    if (iR == 60 || iR == 68) {
                        if (t(obj2, iArr[i6], i6)) {
                            if (!p(i6).g(b2.c.i(obj2, iS & 1048575))) {
                                return false;
                            }
                        } else {
                            continue;
                        }
                    } else if (iR != 49) {
                        if (iR != 50) {
                            continue;
                        } else {
                            Object objI = b2.c.i(obj2, iS & 1048575);
                            this.m.getClass();
                            if (!((b1) objI).isEmpty()) {
                                o.c(o(i6));
                                throw null;
                            }
                        }
                    }
                    i3++;
                    obj = obj2;
                    i4 = i;
                    i5 = i2;
                }
                List list = (List) b2.c.i(obj2, iS & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    s1 s1VarP = p(i6);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!s1VarP.g(list.get(i10))) {
                            return false;
                        }
                    }
                }
                i3++;
                obj = obj2;
                i4 = i;
                i5 = i2;
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void h(Object obj, a1 a1Var) {
        T(obj, a1Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        ((com.github.catvod.spider.merge.u.j0) r2).unknownFields = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:151:0x06de A[Catch: all -> 0x0447, TryCatch #3 {all -> 0x0447, blocks: (B:149:0x06d9, B:151:0x06de, B:152:0x06e3, B:111:0x0442, B:114:0x044a, B:115:0x045f, B:116:0x0474, B:117:0x0489, B:118:0x049e, B:119:0x04b3, B:120:0x04c8, B:121:0x04dd, B:122:0x04f2, B:123:0x050c, B:124:0x0526, B:125:0x0541, B:126:0x055c, B:127:0x0577, B:128:0x0595, B:129:0x05b0, B:130:0x05c5, B:131:0x05e0, B:132:0x05ed, B:133:0x060a, B:134:0x0625, B:135:0x0640, B:136:0x065b, B:137:0x0676, B:138:0x0691, B:139:0x06ad, B:143:0x06c9), top: B:175:0x06d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x070a A[LOOP:3: B:162:0x0708->B:163:0x070a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x06ea A[SYNTHETIC] */
    @Override // com.github.catvod.spider.merge.u.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(java.lang.Object r21, com.github.catvod.spider.merge.u.q r22, com.github.catvod.spider.merge.u.y r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1964
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.j1.i(java.lang.Object, com.github.catvod.spider.merge.u.q, com.github.catvod.spider.merge.u.y):void");
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final Object j() {
        this.j.getClass();
        return ((j0) this.e).newMutableInstance();
    }

    public final boolean k(j0 j0Var, j0 j0Var2, int i) {
        return q(i, j0Var) == q(i, j0Var2);
    }

    public final void m(int i, Object obj, Object obj2) {
        int i2 = this.a[i];
        if (b2.c.i(obj, S(i) & 1048575) == null) {
            return;
        }
        n(i);
    }

    public final void n(int i) {
        if (this.b[((i / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    public final Object o(int i) {
        return this.b[(i / 3) * 2];
    }

    public final s1 p(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        s1 s1Var = (s1) objArr[i2];
        if (s1Var != null) {
            return s1Var;
        }
        s1 s1VarA = p1.c.a((Class) objArr[i2 + 1]);
        objArr[i2] = s1VarA;
        return s1VarA;
    }

    public final boolean q(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j == 1048575) {
            int iS = S(i);
            long j2 = iS & 1048575;
            switch (R(iS)) {
                case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                    if (Double.doubleToRawLongBits(b2.c.e(obj, j2)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(b2.c.f(obj, j2)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (b2.c.h(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (b2.c.h(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (b2.c.g(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (b2.c.h(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (b2.c.g(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return b2.c.c(obj, j2);
                case 8:
                    Object objI = b2.c.i(obj, j2);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof l) {
                        return !l.b.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (b2.c.i(obj, j2) == null) {
                        return false;
                    }
                    break;
                case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                    return !l.b.equals(b2.c.i(obj, j2));
                case 11:
                    if (b2.c.g(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                    if (b2.c.g(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (b2.c.g(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (b2.c.h(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (b2.c.g(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (b2.c.h(obj, j2) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (b2.c.i(obj, j2) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i2 >>> 20)) & b2.c.g(obj, j)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean r(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? q(i, obj) : (i3 & i4) != 0;
    }

    public final boolean t(Object obj, int i, int i2) {
        return b2.c.g(obj, (long) (this.a[i2 + 2] & 1048575)) == i;
    }

    public final void u(int i, Object obj, Object obj2) {
        long jS = S(i) & 1048575;
        Object objI = b2.c.i(obj, jS);
        c1 c1Var = this.m;
        if (objI != null) {
            c1Var.getClass();
            if (!((b1) objI).a) {
                b1 b1VarB = b1.b.b();
                c1.a(b1VarB, objI);
                b2.p(obj, jS, b1VarB);
                objI = b1VarB;
            }
        } else {
            c1Var.getClass();
            objI = b1.b.b();
            b2.p(obj, jS, objI);
        }
        c1Var.getClass();
        o.c(obj2);
        throw null;
    }

    public final void v(int i, Object obj, Object obj2) {
        if (q(i, obj2)) {
            long jS = S(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, jS);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2);
            }
            s1 s1VarP = p(i);
            if (!q(i, obj)) {
                if (s(object)) {
                    Object objJ = s1VarP.j();
                    s1VarP.b(objJ, object);
                    unsafe.putObject(obj, jS, objJ);
                } else {
                    unsafe.putObject(obj, jS, object);
                }
                M(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jS);
            if (!s(object2)) {
                Object objJ2 = s1VarP.j();
                s1VarP.b(objJ2, object2);
                unsafe.putObject(obj, jS, objJ2);
                object2 = objJ2;
            }
            s1VarP.b(object2, object);
        }
    }

    public final void w(int i, Object obj, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (t(obj2, i2, i)) {
            long jS = S(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, jS);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
            }
            s1 s1VarP = p(i);
            if (!t(obj, i2, i)) {
                if (s(object)) {
                    Object objJ = s1VarP.j();
                    s1VarP.b(objJ, object);
                    unsafe.putObject(obj, jS, objJ);
                } else {
                    unsafe.putObject(obj, jS, object);
                }
                N(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jS);
            if (!s(object2)) {
                Object objJ2 = s1VarP.j();
                s1VarP.b(objJ2, object2);
                unsafe.putObject(obj, jS, objJ2);
                object2 = objJ2;
            }
            s1VarP.b(object2, object);
        }
    }

    public final Object x(int i, Object obj) {
        s1 s1VarP = p(i);
        long jS = S(i) & 1048575;
        if (!q(i, obj)) {
            return s1VarP.j();
        }
        Object object = o.getObject(obj, jS);
        if (s(object)) {
            return object;
        }
        Object objJ = s1VarP.j();
        if (object != null) {
            s1VarP.b(objJ, object);
        }
        return objJ;
    }

    public final Object y(Object obj, int i, int i2) {
        s1 s1VarP = p(i2);
        if (!t(obj, i, i2)) {
            return s1VarP.j();
        }
        Object object = o.getObject(obj, S(i2) & 1048575);
        if (s(object)) {
            return object;
        }
        Object objJ = s1VarP.j();
        if (object != null) {
            s1VarP.b(objJ, object);
        }
        return objJ;
    }
}
