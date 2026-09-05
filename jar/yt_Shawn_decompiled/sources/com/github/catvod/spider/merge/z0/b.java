package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.g0;
import com.github.catvod.spider.merge.y0.l0;
import com.github.catvod.spider.merge.y0.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final byte[] b = new byte[0];

    public static final int a(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final Map b(ArrayList arrayList) {
        String str = g0.b;
        g0 g0VarE = com.github.catvod.spider.merge.h0.f.e("/");
        Map mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(g0VarE, new m(g0VarE, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532))});
        for (m mVar : CollectionsKt.s(arrayList, new p())) {
            if (((m) mapMutableMapOf.put(mVar.a, mVar)) == null) {
                while (true) {
                    g0 g0Var = mVar.a;
                    g0 g0VarB = g0Var.b();
                    if (g0VarB != null) {
                        m mVar2 = (m) mapMutableMapOf.get(g0VarB);
                        if (mVar2 != null) {
                            mVar2.q.add(g0Var);
                            break;
                        }
                        m mVar3 = new m(g0VarB, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                        mapMutableMapOf.put(g0VarB, mVar3);
                        mVar3.q.add(g0Var);
                        mVar = mVar3;
                    }
                }
            }
        }
        return mapMutableMapOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
    
        if (r20.yield(r1, r4) == r5) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00db, code lost:
    
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
    
        if (r14 != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
    
        r6.addLast(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e6, code lost:
    
        r14 = r6;
        r13 = r9;
        r12 = r11;
        r6 = r1;
        r1 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x012c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012d, code lost:
    
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x014b, code lost:
    
        if (r11.yield(r1, r4) == r5) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014d, code lost:
    
        return r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(kotlin.sequences.SequenceScope r20, com.github.catvod.spider.merge.y0.s r21, kotlin.collections.ArrayDeque r22, com.github.catvod.spider.merge.y0.g0 r23, boolean r24, boolean r25, kotlin.coroutines.jvm.internal.BaseContinuationImpl r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.z0.b.c(kotlin.sequences.SequenceScope, com.github.catvod.spider.merge.y0.s, kotlin.collections.ArrayDeque, com.github.catvod.spider.merge.y0.g0, boolean, boolean, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long d(com.github.catvod.spider.merge.y0.l0 r17, com.github.catvod.spider.merge.y0.m r18, int r19, long r20) {
        /*
            r0 = r17
            r18.getClass()
            int r1 = r18.d()
            long r2 = (long) r1
            r10 = r19
            long r6 = (long) r10
            r4 = 0
            com.github.catvod.spider.merge.u.c2.g(r2, r4, r6)
            r1 = r6
            boolean r3 = r0.c
            com.github.catvod.spider.merge.y0.j r4 = r0.b
            r5 = 0
            if (r3 != 0) goto L81
            r6 = r5
            r5 = r18
        L1e:
            r8 = r20
            long r11 = com.github.catvod.spider.merge.z0.a.a(r4, r5, r6, r8, r10)
            r5 = r6
            r7 = -1
            int r3 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r3 == 0) goto L2c
            return r11
        L2c:
            long r9 = r4.b
            long r11 = r9 - r1
            r13 = 1
            long r11 = r11 + r13
            int r3 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r3 < 0) goto L39
        L37:
            r15 = r7
            goto L80
        L39:
            int r3 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r3 >= 0) goto L41
            r15 = r7
            r7 = r18
            goto L63
        L41:
            long r9 = r9 - r20
            long r9 = r9 + r13
            long r9 = java.lang.Math.max(r13, r9)
            int r3 = (int) r9
            long r9 = r4.b
            long r9 = r9 - r5
            long r9 = r9 + r13
            long r9 = java.lang.Math.min(r1, r9)
            int r10 = (int) r9
            int r10 = r10 + (-1)
            if (r3 > r10) goto L37
        L56:
            long r13 = r4.b
            r15 = r7
            long r7 = (long) r10
            long r13 = r13 - r7
            r7 = r18
            boolean r8 = r4.D(r10, r7, r13)
            if (r8 == 0) goto L7a
        L63:
            com.github.catvod.spider.merge.y0.r0 r3 = r0.a
            r8 = 8192(0x2000, double:4.0474E-320)
            long r8 = r3.read(r4, r8)
            int r3 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r3 != 0) goto L70
            goto L80
        L70:
            long r5 = java.lang.Math.max(r5, r11)
            r8 = r5
            r5 = r7
            r6 = r8
            r10 = r19
            goto L1e
        L7a:
            if (r10 == r3) goto L80
            int r10 = r10 + (-1)
            r7 = r15
            goto L56
        L80:
            return r15
        L81:
            java.lang.String r0 = "closed"
            com.github.catvod.spider.merge.s0.a.h(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.z0.b.d(com.github.catvod.spider.merge.y0.l0, com.github.catvod.spider.merge.y0.m, int, long):long");
    }

    public static final String e(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String string = Integer.toString(i, CharsKt.checkRadix(16));
        string.getClass();
        sb.append(string);
        return sb.toString();
    }

    public static final m f(final l0 l0Var) throws IOException {
        int iZ = l0Var.z();
        if (iZ != 33639248) {
            throw new IOException("bad zip: expected " + e(33639248) + " but was " + e(iZ));
        }
        l0Var.skip(4L);
        short sB = l0Var.B();
        int i = sB & 65535;
        if ((sB & 1) != 0) {
            com.github.catvod.spider.merge.s0.a.w("unsupported zip: general purpose bit flag=".concat(e(i)));
            return null;
        }
        int iB = l0Var.B() & 65535;
        int iB2 = l0Var.B() & 65535;
        int iB3 = l0Var.B() & 65535;
        long jZ = l0Var.z() & 4294967295L;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = l0Var.z() & 4294967295L;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = l0Var.z() & 4294967295L;
        int iB4 = l0Var.B() & 65535;
        int iB5 = l0Var.B() & 65535;
        int iB6 = l0Var.B() & 65535;
        l0Var.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = l0Var.z() & 4294967295L;
        String strC = l0Var.C(iB4);
        if (StringsKt.n(strC, (char) 0)) {
            com.github.catvod.spider.merge.s0.a.w("bad zip: filename contains 0x00");
            return null;
        }
        long j = longRef2.element == 4294967295L ? 8L : 0L;
        if (longRef.element == 4294967295L) {
            j += 8;
        }
        if (longRef3.element == 4294967295L) {
            j += 8;
        }
        final long j2 = j;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        g(l0Var, iB5, new Function2() { // from class: com.github.catvod.spider.merge.z0.o
            public final Object invoke(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                l0 l0Var2 = l0Var;
                if (iIntValue == 1) {
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    if (booleanRef2.element) {
                        com.github.catvod.spider.merge.s0.a.w("bad zip: zip64 extra repeated");
                        return null;
                    }
                    booleanRef2.element = true;
                    if (jLongValue < j2) {
                        com.github.catvod.spider.merge.s0.a.w("bad zip: zip64 extra too short");
                        return null;
                    }
                    Ref.LongRef longRef4 = longRef2;
                    long jA = longRef4.element;
                    if (jA == 4294967295L) {
                        jA = l0Var2.A();
                    }
                    longRef4.element = jA;
                    Ref.LongRef longRef5 = longRef;
                    longRef5.element = longRef5.element == 4294967295L ? l0Var2.A() : 0L;
                    Ref.LongRef longRef6 = longRef3;
                    longRef6.element = longRef6.element == 4294967295L ? l0Var2.A() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        com.github.catvod.spider.merge.s0.a.w("bad zip: NTFS extra too short");
                        return null;
                    }
                    l0Var2.skip(4L);
                    b.g(l0Var2, (int) (jLongValue - 4), new n(objectRef, l0Var2, objectRef2, objectRef3));
                }
                return Unit.INSTANCE;
            }
        });
        if (j2 > 0 && !booleanRef.element) {
            com.github.catvod.spider.merge.s0.a.w("bad zip: zip64 extra required but absent");
            return null;
        }
        String strC2 = l0Var.C(iB6);
        String str = g0.b;
        return new m(com.github.catvod.spider.merge.h0.f.e("/").d(strC), StringsKt.s(strC, "/"), strC2, jZ, longRef.element, longRef2.element, iB, longRef3.element, iB3, iB2, (Long) objectRef.element, (Long) objectRef2.element, (Long) objectRef3.element, 57344);
    }

    public static final void g(l0 l0Var, int i, Function2 function2) throws IOException {
        com.github.catvod.spider.merge.y0.j jVar = l0Var.b;
        long j = i;
        while (j != 0) {
            if (j < 4) {
                com.github.catvod.spider.merge.s0.a.w("bad zip: truncated header in extra field");
                return;
            }
            int iB = l0Var.B() & 65535;
            long jB = l0Var.B() & 65535;
            long j2 = j - 4;
            if (j2 < jB) {
                com.github.catvod.spider.merge.s0.a.w("bad zip: truncated value in extra field");
                return;
            }
            l0Var.t(jB);
            long j3 = jVar.b;
            function2.invoke(Integer.valueOf(iB), Long.valueOf(jB));
            long j4 = (jVar.b + jB) - j3;
            if (j4 < 0) {
                com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.b.b.j(iB, "unsupported zip: too many bytes processed for "));
                return;
            } else {
                if (j4 > 0) {
                    jVar.skip(j4);
                }
                j = j2 - jB;
            }
        }
    }

    public static final m h(l0 l0Var, m mVar) throws IOException {
        int iZ = l0Var.z();
        if (iZ != 67324752) {
            throw new IOException("bad zip: expected " + e(67324752) + " but was " + e(iZ));
        }
        l0Var.skip(2L);
        short sB = l0Var.B();
        int i = sB & 65535;
        if ((sB & 1) != 0) {
            com.github.catvod.spider.merge.s0.a.w("unsupported zip: general purpose bit flag=".concat(e(i)));
            return null;
        }
        l0Var.skip(18L);
        int iB = l0Var.B() & 65535;
        l0Var.skip(l0Var.B() & 65535);
        if (mVar == null) {
            l0Var.skip(iB);
            return null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        g(l0Var, iB, new n(l0Var, objectRef, objectRef2, objectRef3));
        return new m(mVar.a, mVar.b, mVar.c, mVar.d, mVar.e, mVar.f, mVar.g, mVar.h, mVar.i, mVar.j, mVar.k, mVar.l, mVar.m, (Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element);
    }

    public static final int i(o0 o0Var, int i) {
        int i2;
        int[] iArr = o0Var.f;
        int i3 = i + 1;
        int length = o0Var.e.length;
        iArr.getClass();
        int i4 = length - 1;
        int i5 = 0;
        while (true) {
            if (i5 <= i4) {
                i2 = (i5 + i4) >>> 1;
                int i6 = iArr[i2];
                if (i6 >= i3) {
                    if (i6 <= i3) {
                        break;
                    }
                    i4 = i2 - 1;
                } else {
                    i5 = i2 + 1;
                }
            } else {
                i2 = (-i5) - 1;
                break;
            }
        }
        return i2 >= 0 ? i2 : ~i2;
    }
}
