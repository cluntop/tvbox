package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.Map;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, Map {
    public static final int g = Runtime.getRuntime().availableProcessors();
    public static final com.github.catvod.spider.jdollar.sun.misc.a h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final int n;
    public static final int o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    public volatile transient l[] a;
    public volatile transient l[] b;
    private volatile transient long baseCount;
    public volatile transient c[] c;
    private volatile transient int cellsBusy;
    public transient i d;
    public transient s e;
    public transient e f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        com.github.catvod.spider.jdollar.sun.misc.a aVar = com.github.catvod.spider.jdollar.sun.misc.a.b;
        h = aVar;
        i = aVar.h(ConcurrentHashMap.class, "sizeCtl");
        j = aVar.h(ConcurrentHashMap.class, "transferIndex");
        k = aVar.h(ConcurrentHashMap.class, "baseCount");
        l = aVar.h(ConcurrentHashMap.class, "cellsBusy");
        m = aVar.h(c.class, "value");
        n = aVar.a(l[].class);
        int iB = aVar.b(l[].class);
        if (((iB - 1) & iB) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        o = 31 - Integer.numberOfLeadingZeros(iB);
    }

    public ConcurrentHashMap(int i2, int i3) {
        if (i2 < 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        long j2 = (long) (((i2 < i3 ? i3 : i2) / 0.75f) + 1.0d);
        this.sizeCtl = j2 >= 1073741824 ? 1073741824 : l((int) j2);
    }

    public static final boolean b(l[] lVarArr, int i2, l lVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.E(h.a, lVarArr, (i2 << o) + n, lVar);
    }

    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() != Comparable.class || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null || actualTypeArguments.length != 1 || actualTypeArguments[0] != cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    public static final void h(l[] lVarArr, int i2, l lVar) {
        h.j(lVarArr, (i2 << o) + n, lVar);
    }

    public static final int i(int i2) {
        return (i2 ^ (i2 >>> 16)) & ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
    }

    public static final l k(l[] lVarArr, int i2) {
        return (l) h.f(lVarArr, (i2 << o) + n);
    }

    public static final int l(int i2) {
        int iNumberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i2 - 1);
        if (iNumberOfLeadingZeros < 0) {
            return 1;
        }
        if (iNumberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return iNumberOfLeadingZeros + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.github.catvod.spider.jdollar.util.concurrent.l] */
    public static l p(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (r rVar2 = rVar; rVar2 != null; rVar2 = rVar2.d) {
            l lVar3 = new l(rVar2.a, rVar2.b, rVar2.c);
            if (lVar2 == null) {
                lVar = lVar3;
            } else {
                lVar2.d = lVar3;
            }
            lVar2 = lVar3;
        }
        return lVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j2;
        long j3;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j4 = 0;
        long j5 = 0;
        l lVar = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j2 = 1;
            if (object == null || object2 == null) {
                break;
            }
            j5++;
            lVar = new l(i(object.hashCode()), object, object2, lVar);
        }
        if (j5 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j6 = (long) ((j5 / 0.75f) + 1.0d);
        int iL = j6 >= 1073741824 ? 1073741824 : l((int) j6);
        l[] lVarArr = new l[iL];
        int i2 = iL - 1;
        while (lVar != null) {
            l lVar2 = lVar.d;
            int i3 = lVar.a;
            int i4 = i3 & i2;
            l lVarK = k(lVarArr, i4);
            boolean z = true;
            if (lVarK == null) {
                j3 = j2;
            } else {
                Object obj2 = lVar.b;
                if (lVarK.a < 0) {
                    if (((q) lVarK).e(i3, obj2, lVar.c) == null) {
                        j4 += j2;
                    }
                    j3 = j2;
                } else {
                    j3 = j2;
                    int i5 = 0;
                    for (l lVar3 = lVarK; lVar3 != null; lVar3 = lVar3.d) {
                        if (lVar3.a == i3 && ((obj = lVar3.b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        }
                        i5++;
                    }
                    if (z && i5 >= 8) {
                        j4 += j3;
                        lVar.d = lVarK;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.a, lVar4.b, lVar4.c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.d = rVar3;
                            }
                            lVar4 = lVar4.d;
                            rVar2 = rVar3;
                        }
                        h(lVarArr, i4, new q(rVar));
                    }
                }
                z = false;
            }
            if (z) {
                j4 += j3;
                lVar.d = lVarK;
                h(lVarArr, i4, lVar);
            }
            lVar = lVar2;
            j2 = j3;
        }
        this.a = lVarArr;
        this.sizeCtl = iL - (iL >>> 2);
        this.baseCount = j4;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i2 = 1;
        int i3 = 0;
        while (i2 < 16) {
            i3++;
            i2 <<= 1;
        }
        int i4 = 32 - i3;
        int i5 = i2 - 1;
        n[] nVarArr = new n[16];
        for (int i6 = 0; i6 < 16; i6++) {
            nVarArr[i6] = new n();
        }
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("segments", nVarArr);
        putFieldPutFields.put("segmentShift", i4);
        putFieldPutFields.put("segmentMask", i5);
        objectOutputStream.writeFields();
        l[] lVarArr = this.a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                objectOutputStream.writeObject(lVarA.b);
                objectOutputStream.writeObject(lVarA.c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x013f, code lost:
    
        if (r1.c != r6) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0141, code lost:
    
        r1.c = (com.github.catvod.spider.jdollar.util.concurrent.c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r25, int r27) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        l lVarK;
        l[] lVarArrD = this.a;
        long j2 = 0;
        loop0: while (true) {
            int i2 = 0;
            while (lVarArrD != null && i2 < lVarArrD.length) {
                lVarK = k(lVarArrD, i2);
                if (lVarK == null) {
                    i2++;
                } else {
                    int i3 = lVarK.a;
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (lVarK) {
                        try {
                            if (k(lVarArrD, i2) == lVarK) {
                                for (l lVar = i3 >= 0 ? lVarK : lVarK instanceof q ? ((q) lVarK).f : null; lVar != null; lVar = lVar.d) {
                                    j2--;
                                }
                                h(lVarArrD, i2, null);
                                i2++;
                            }
                        } finally {
                        }
                    }
                }
            }
            lVarArrD = d(lVarArrD, lVarK);
        }
        if (j2 != 0) {
            a(j2, -1);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        l lVar;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i2 = i(obj.hashCode());
        l[] lVarArrE = this.a;
        int i3 = 0;
        Object objApply = null;
        int i4 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i5 = (length - 1) & i2;
                    l lVarK = k(lVarArrE, i5);
                    if (lVarK == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArrE, i5, mVar)) {
                                    try {
                                        objApply = biFunction.apply(obj, null);
                                        if (objApply != null) {
                                            lVar = new l(i2, obj, objApply);
                                            i4 = 1;
                                        } else {
                                            lVar = null;
                                        }
                                        h(lVarArrE, i5, lVar);
                                        i3 = 1;
                                    } catch (Throwable th) {
                                        h(lVarArrE, i5, null);
                                        throw th;
                                    }
                                }
                            } finally {
                            }
                        }
                        if (i3 != 0) {
                        }
                    } else {
                        int i6 = lVarK.a;
                        if (i6 == -1) {
                            lVarArrE = d(lVarArrE, lVarK);
                        } else {
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArrE, i5) == lVarK) {
                                        if (i6 >= 0) {
                                            l lVar2 = null;
                                            l lVar3 = lVarK;
                                            i3 = 1;
                                            while (true) {
                                                if (lVar3.a != i2 || ((obj2 = lVar3.b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                                                    l lVar4 = lVar3.d;
                                                    if (lVar4 == null) {
                                                        Object objApply2 = biFunction.apply(obj, null);
                                                        if (objApply2 == null) {
                                                            objApply = objApply2;
                                                        } else {
                                                            if (lVar3.d != null) {
                                                                throw new IllegalStateException("Recursive update");
                                                            }
                                                            lVar3.d = new l(i2, obj, objApply2);
                                                            objApply = objApply2;
                                                            i4 = 1;
                                                        }
                                                    } else {
                                                        i3++;
                                                        lVar2 = lVar3;
                                                        lVar3 = lVar4;
                                                    }
                                                }
                                            }
                                            Object objApply3 = biFunction.apply(obj, lVar3.c);
                                            if (objApply3 != null) {
                                                lVar3.c = objApply3;
                                                objApply = objApply3;
                                            } else {
                                                l lVar5 = lVar3.d;
                                                if (lVar2 != null) {
                                                    lVar2.d = lVar5;
                                                } else {
                                                    h(lVarArrE, i5, lVar5);
                                                }
                                                objApply = objApply3;
                                                i4 = -1;
                                            }
                                        } else if (lVarK instanceof q) {
                                            q qVar = (q) lVarK;
                                            r rVar = qVar.e;
                                            r rVarB = rVar != null ? rVar.b(i2, obj, null) : null;
                                            Object objApply4 = biFunction.apply(obj, rVarB == null ? null : rVarB.c);
                                            if (objApply4 != null) {
                                                if (rVarB != null) {
                                                    rVarB.c = objApply4;
                                                } else {
                                                    qVar.e(i2, obj, objApply4);
                                                    i4 = 1;
                                                }
                                            } else if (rVarB != null) {
                                                if (qVar.f(rVarB)) {
                                                    h(lVarArrE, i5, p(qVar.f));
                                                }
                                                i4 = -1;
                                            }
                                            objApply = objApply4;
                                            i3 = 1;
                                        } else if (lVarK instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    n(lVarArrE, i5);
                                }
                            }
                        }
                    }
                }
            }
            lVarArrE = e();
        }
        if (i4 != 0) {
            a(i4, i3);
        }
        return objApply;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r5 = r5.c;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object computeIfAbsent(java.lang.Object r12, java.util.function.Function r13) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00aa, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object computeIfPresent(java.lang.Object r14, java.util.function.BiFunction r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto Lbd
            if (r15 == 0) goto Lbd
            int r1 = r14.hashCode()
            int r1 = i(r1)
            com.github.catvod.spider.jdollar.util.concurrent.l[] r2 = r13.a
            r3 = 0
            r5 = r0
            r4 = 0
        L12:
            if (r2 == 0) goto Lb7
            int r6 = r2.length
            if (r6 != 0) goto L19
            goto Lb7
        L19:
            int r6 = r6 + (-1)
            r6 = r6 & r1
            com.github.catvod.spider.jdollar.util.concurrent.l r7 = k(r2, r6)
            if (r7 != 0) goto L24
            goto Lae
        L24:
            int r8 = r7.a
            r9 = -1
            if (r8 != r9) goto L2e
            com.github.catvod.spider.jdollar.util.concurrent.l[] r2 = r13.d(r2, r7)
            goto L12
        L2e:
            monitor-enter(r7)
            com.github.catvod.spider.jdollar.util.concurrent.l r10 = k(r2, r6)     // Catch: java.lang.Throwable -> L4b
            if (r10 != r7) goto Lab
            if (r8 < 0) goto L70
            r4 = 1
            r10 = r0
            r8 = r7
        L3a:
            int r11 = r8.a     // Catch: java.lang.Throwable -> L4b
            if (r11 != r1) goto L65
            java.lang.Object r11 = r8.b     // Catch: java.lang.Throwable -> L4b
            if (r11 == r14) goto L4e
            if (r11 == 0) goto L65
            boolean r11 = r14.equals(r11)     // Catch: java.lang.Throwable -> L4b
            if (r11 == 0) goto L65
            goto L4e
        L4b:
            r14 = move-exception
            goto Lb5
        L4e:
            java.lang.Object r5 = r8.c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L59
            r8.c = r5     // Catch: java.lang.Throwable -> L4b
            goto Lab
        L59:
            com.github.catvod.spider.jdollar.util.concurrent.l r3 = r8.d     // Catch: java.lang.Throwable -> L4b
            if (r10 == 0) goto L60
            r10.d = r3     // Catch: java.lang.Throwable -> L4b
            goto L63
        L60:
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L63:
            r3 = -1
            goto Lab
        L65:
            com.github.catvod.spider.jdollar.util.concurrent.l r10 = r8.d     // Catch: java.lang.Throwable -> L4b
            if (r10 != 0) goto L6a
            goto Lab
        L6a:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L3a
        L70:
            boolean r8 = r7 instanceof com.github.catvod.spider.jdollar.util.concurrent.q     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9e
            r4 = r7
            com.github.catvod.spider.jdollar.util.concurrent.q r4 = (com.github.catvod.spider.jdollar.util.concurrent.q) r4     // Catch: java.lang.Throwable -> L4b
            com.github.catvod.spider.jdollar.util.concurrent.r r8 = r4.e     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            com.github.catvod.spider.jdollar.util.concurrent.r r8 = r8.b(r1, r14, r0)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            java.lang.Object r5 = r8.c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L8c
            r8.c = r5     // Catch: java.lang.Throwable -> L4b
            goto L9c
        L8c:
            boolean r3 = r4.f(r8)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L9b
            com.github.catvod.spider.jdollar.util.concurrent.r r3 = r4.f     // Catch: java.lang.Throwable -> L4b
            com.github.catvod.spider.jdollar.util.concurrent.l r3 = p(r3)     // Catch: java.lang.Throwable -> L4b
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L9b:
            r3 = -1
        L9c:
            r4 = 2
            goto Lab
        L9e:
            boolean r6 = r7 instanceof com.github.catvod.spider.jdollar.util.concurrent.m     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto La3
            goto Lab
        La3:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L4b
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch: java.lang.Throwable -> L4b
            throw r14     // Catch: java.lang.Throwable -> L4b
        Lab:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L12
        Lae:
            if (r3 == 0) goto Lb4
            long r14 = (long) r3
            r13.a(r14, r4)
        Lb4:
            return r5
        Lb5:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            throw r14
        Lb7:
            com.github.catvod.spider.jdollar.util.concurrent.l[] r2 = r13.e()
            goto L12
        Lbd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                Object obj2 = lVarA.c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final l[] d(l[] lVarArr, l lVar) {
        int i2;
        if (!(lVar instanceof g)) {
            return this.a;
        }
        l[] lVarArr2 = ((g) lVar).e;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (true) {
            if (lVarArr2 != this.b || this.a != lVarArr || (i2 = this.sizeCtl) >= 0 || (i2 >>> 16) != iNumberOfLeadingZeros || i2 == iNumberOfLeadingZeros + 1 || i2 == 65535 + iNumberOfLeadingZeros || this.transferIndex <= 0) {
                break;
            }
            if (h.c(this, i, i2, i2 + 1)) {
                m(lVarArr, lVarArr2);
                break;
            }
        }
        return lVarArr2;
    }

    public final l[] e() {
        while (true) {
            l[] lVarArr = this.a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else if (h.c(this, i, i2, -1)) {
                try {
                    l[] lVarArr2 = this.a;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i3 = i2 > 0 ? i2 : 16;
                        l[] lVarArr3 = new l[i3];
                        this.a = lVarArr3;
                        i2 = i3 - (i3 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    this.sizeCtl = i2;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i2;
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                        return false;
                    }
                }
                return true;
            }
            Object obj2 = lVarA.c;
            Object obj3 = map.get(lVarA.b);
            if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                break;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006a, code lost:
    
        r7 = r6.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006c, code lost:
    
        if (r11 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006e, code lost:
    
        r6.c = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a5, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.f(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            } else {
                biConsumer.accept(lVarA.b, lVarA.c);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r9 = r5.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r15 == r9) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (r9 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
    
        if (r15.equals(r9) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        if (r14 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0055, code lost:
    
        r5.c = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
    
        r5 = r5.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005a, code lost:
    
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
    
        r8.d = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:
    
        h(r1, r3, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(java.lang.Object r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            r12 = this;
            int r0 = r13.hashCode()
            int r0 = i(r0)
            com.github.catvod.spider.jdollar.util.concurrent.l[] r1 = r12.a
        La:
            r2 = 0
            if (r1 == 0) goto Lbe
            int r3 = r1.length
            if (r3 == 0) goto Lbe
            int r3 = r3 + (-1)
            r3 = r3 & r0
            com.github.catvod.spider.jdollar.util.concurrent.l r4 = k(r1, r3)
            if (r4 != 0) goto L1b
            goto Lbe
        L1b:
            int r5 = r4.a
            r6 = -1
            if (r5 != r6) goto L25
            com.github.catvod.spider.jdollar.util.concurrent.l[] r1 = r12.d(r1, r4)
            goto La
        L25:
            monitor-enter(r4)
            com.github.catvod.spider.jdollar.util.concurrent.l r7 = k(r1, r3)     // Catch: java.lang.Throwable -> L42
            if (r7 != r4) goto Lad
            r7 = 1
            if (r5 < 0) goto L6c
            r8 = r2
            r5 = r4
        L31:
            int r9 = r5.a     // Catch: java.lang.Throwable -> L42
            if (r9 != r0) goto L63
            java.lang.Object r9 = r5.b     // Catch: java.lang.Throwable -> L42
            if (r9 == r13) goto L45
            if (r9 == 0) goto L63
            boolean r9 = r13.equals(r9)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto L63
            goto L45
        L42:
            r13 = move-exception
            goto Lbc
        L45:
            java.lang.Object r9 = r5.c     // Catch: java.lang.Throwable -> L42
            if (r15 == 0) goto L53
            if (r15 == r9) goto L53
            if (r9 == 0) goto Lae
            boolean r10 = r15.equals(r9)     // Catch: java.lang.Throwable -> L42
            if (r10 == 0) goto Lae
        L53:
            if (r14 == 0) goto L58
            r5.c = r14     // Catch: java.lang.Throwable -> L42
            goto Laf
        L58:
            com.github.catvod.spider.jdollar.util.concurrent.l r5 = r5.d
            if (r8 == 0) goto L5f
            r8.d = r5     // Catch: java.lang.Throwable -> L42
            goto Laf
        L5f:
            h(r1, r3, r5)     // Catch: java.lang.Throwable -> L42
            goto Laf
        L63:
            com.github.catvod.spider.jdollar.util.concurrent.l r8 = r5.d     // Catch: java.lang.Throwable -> L42
            if (r8 != 0) goto L68
            goto Lae
        L68:
            r11 = r8
            r8 = r5
            r5 = r11
            goto L31
        L6c:
            boolean r5 = r4 instanceof com.github.catvod.spider.jdollar.util.concurrent.q     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto La0
            r5 = r4
            com.github.catvod.spider.jdollar.util.concurrent.q r5 = (com.github.catvod.spider.jdollar.util.concurrent.q) r5     // Catch: java.lang.Throwable -> L42
            com.github.catvod.spider.jdollar.util.concurrent.r r8 = r5.e     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto Lae
            com.github.catvod.spider.jdollar.util.concurrent.r r8 = r8.b(r0, r13, r2)     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto Lae
            java.lang.Object r9 = r8.c     // Catch: java.lang.Throwable -> L42
            if (r15 == 0) goto L8b
            if (r15 == r9) goto L8b
            if (r9 == 0) goto Lae
            boolean r10 = r15.equals(r9)     // Catch: java.lang.Throwable -> L42
            if (r10 == 0) goto Lae
        L8b:
            if (r14 == 0) goto L90
            r8.c = r14     // Catch: java.lang.Throwable -> L42
            goto Laf
        L90:
            boolean r8 = r5.f(r8)     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto Laf
            com.github.catvod.spider.jdollar.util.concurrent.r r5 = r5.f     // Catch: java.lang.Throwable -> L42
            com.github.catvod.spider.jdollar.util.concurrent.l r5 = p(r5)     // Catch: java.lang.Throwable -> L42
            h(r1, r3, r5)     // Catch: java.lang.Throwable -> L42
            goto Laf
        La0:
            boolean r3 = r4 instanceof com.github.catvod.spider.jdollar.util.concurrent.m     // Catch: java.lang.Throwable -> L42
            if (r3 != 0) goto La5
            goto Lad
        La5:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L42
            java.lang.String r14 = "Recursive update"
            r13.<init>(r14)     // Catch: java.lang.Throwable -> L42
            throw r13     // Catch: java.lang.Throwable -> L42
        Lad:
            r7 = 0
        Lae:
            r9 = r2
        Laf:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            if (r7 == 0) goto La
            if (r9 == 0) goto Lbe
            if (r14 != 0) goto Lbb
            r13 = -1
            r12.a(r13, r6)
        Lbb:
            return r9
        Lbc:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            throw r13
        Lbe:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.g(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int length;
        l lVarK;
        Object obj2;
        int i2 = i(obj.hashCode());
        l[] lVarArr = this.a;
        if (lVarArr == null || (length = lVarArr.length) <= 0 || (lVarK = k(lVarArr, (length - 1) & i2)) == null) {
            return null;
        }
        int i3 = lVarK.a;
        if (i3 == i2) {
            Object obj3 = lVarK.b;
            if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                return (V) lVarK.c;
            }
        } else if (i3 < 0) {
            l lVarA = lVarK.a(i2, obj);
            if (lVarA != null) {
                return (V) lVarA.c;
            }
            return null;
        }
        while (true) {
            lVarK = lVarK.d;
            if (lVarK == null) {
                return null;
            }
            if (lVarK.a == i2 && ((obj2 = lVarK.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                break;
            }
        }
        return (V) lVarK.c;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        V v = get(obj);
        return v == null ? obj2 : v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        l[] lVarArr = this.a;
        int iHashCode = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                iHashCode += lVarA.c.hashCode() ^ lVarA.b.hashCode();
            }
        }
        return iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return j() <= 0;
    }

    public final long j() {
        c[] cVarArr = this.c;
        long j2 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.value;
                }
            }
        }
        return j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.d = iVar2;
        return iVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.github.catvod.spider.jdollar.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r10v9, types: [com.github.catvod.spider.jdollar.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.github.catvod.spider.jdollar.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v13, types: [com.github.catvod.spider.jdollar.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v8, types: [com.github.catvod.spider.jdollar.util.concurrent.l] */
    public final void m(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        r lVar;
        int i8;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int length = lVarArr.length;
        int i9 = g;
        int i10 = i9 > 1 ? (length >>> 3) / i9 : length;
        int i11 = i10 < 16 ? 16 : i10;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr4 = new l[length << 1];
                concurrentHashMap.b = lVarArr4;
                concurrentHashMap.transferIndex = length;
                lVarArr3 = lVarArr4;
            } catch (Throwable unused) {
                concurrentHashMap.sizeCtl = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar = new g(lVarArr3);
        int i12 = 0;
        int i13 = 0;
        boolean zB = true;
        boolean z = false;
        while (true) {
            if (zB) {
                int i14 = i12 - 1;
                if (i14 >= i13 || z) {
                    i13 = i13;
                    i12 = i14;
                    zB = false;
                } else {
                    int i15 = concurrentHashMap.transferIndex;
                    if (i15 <= 0) {
                        i12 = -1;
                    } else {
                        com.github.catvod.spider.jdollar.sun.misc.a aVar = h;
                        int i16 = i13;
                        long j2 = j;
                        if (i15 > i11) {
                            i3 = i16;
                            i4 = i15 - i11;
                            i2 = i14;
                        } else {
                            i2 = i14;
                            i3 = i16;
                            i4 = 0;
                        }
                        boolean zC = aVar.c(concurrentHashMap, j2, i15, i4);
                        i13 = i4;
                        if (zC) {
                            i12 = i15 - 1;
                        } else {
                            i13 = i3;
                            i12 = i2;
                        }
                    }
                    zB = false;
                }
            } else {
                int i17 = i13;
                r lVar2 = null;
                if (i12 < 0 || i12 >= length || (i7 = i12 + length) >= length2) {
                    i5 = length;
                    i6 = i11;
                    if (z) {
                        concurrentHashMap.b = null;
                        concurrentHashMap.a = lVarArr3;
                        concurrentHashMap.sizeCtl = (i5 << 1) - (i5 >>> 1);
                        return;
                    }
                    int i18 = i12;
                    com.github.catvod.spider.jdollar.sun.misc.a aVar2 = h;
                    long j3 = i;
                    int i19 = concurrentHashMap.sizeCtl;
                    if (!aVar2.c(concurrentHashMap, j3, i19, i19 - 1)) {
                        i12 = i18;
                    } else {
                        if (i19 - 2 != ((Integer.numberOfLeadingZeros(i5) | 32768) << 16)) {
                            return;
                        }
                        i12 = i5;
                        zB = true;
                        z = true;
                    }
                } else {
                    ?? K = k(lVarArr, i12);
                    if (K == 0) {
                        zB = b(lVarArr, i12, gVar);
                        i5 = length;
                        i6 = i11;
                    } else {
                        int i20 = K.a;
                        if (i20 == -1) {
                            i5 = length;
                            i6 = i11;
                            zB = true;
                        } else {
                            synchronized (K) {
                                try {
                                    if (k(lVarArr, i12) == K) {
                                        if (i20 >= 0) {
                                            int i21 = i20 & length;
                                            r rVar = K;
                                            for (r rVar2 = K.d; rVar2 != null; rVar2 = rVar2.d) {
                                                int i22 = rVar2.a & length;
                                                if (i22 != i21) {
                                                    rVar = rVar2;
                                                    i21 = i22;
                                                }
                                            }
                                            if (i21 == 0) {
                                                lVar = null;
                                                lVar2 = rVar;
                                            } else {
                                                lVar = rVar;
                                            }
                                            l lVar3 = K;
                                            while (lVar3 != rVar) {
                                                int i23 = lVar3.a;
                                                Object obj = lVar3.b;
                                                int i24 = length;
                                                Object obj2 = lVar3.c;
                                                if ((i23 & i24) == 0) {
                                                    i8 = i11;
                                                    lVar2 = new l(i23, obj, obj2, lVar2);
                                                } else {
                                                    i8 = i11;
                                                    lVar = new l(i23, obj, obj2, lVar);
                                                }
                                                lVar3 = lVar3.d;
                                                length = i24;
                                                i11 = i8;
                                            }
                                            i5 = length;
                                            i6 = i11;
                                            h(lVarArr3, i12, lVar2);
                                            h(lVarArr3, i7, lVar);
                                            h(lVarArr, i12, gVar);
                                        } else {
                                            i5 = length;
                                            i6 = i11;
                                            if (K instanceof q) {
                                                q qVar = (q) K;
                                                r rVar3 = null;
                                                r rVar4 = null;
                                                l lVar4 = qVar.f;
                                                int i25 = 0;
                                                int i26 = 0;
                                                r rVar5 = null;
                                                while (lVar4 != null) {
                                                    q qVar2 = qVar;
                                                    int i27 = lVar4.a;
                                                    r rVar6 = new r(i27, lVar4.b, lVar4.c, null, null);
                                                    if ((i27 & i5) == 0) {
                                                        rVar6.h = rVar4;
                                                        if (rVar4 == null) {
                                                            lVar2 = rVar6;
                                                        } else {
                                                            rVar4.d = rVar6;
                                                        }
                                                        i25++;
                                                        rVar4 = rVar6;
                                                    } else {
                                                        rVar6.h = rVar3;
                                                        if (rVar3 == null) {
                                                            rVar5 = rVar6;
                                                        } else {
                                                            rVar3.d = rVar6;
                                                        }
                                                        i26++;
                                                        rVar3 = rVar6;
                                                    }
                                                    lVar4 = lVar4.d;
                                                    qVar = qVar2;
                                                }
                                                q qVar3 = qVar;
                                                l lVarP = i25 <= 6 ? p(lVar2) : i26 != 0 ? new q(lVar2) : qVar3;
                                                l lVarP2 = i26 <= 6 ? p(rVar5) : i25 != 0 ? new q(rVar5) : qVar3;
                                                h(lVarArr3, i12, lVarP);
                                                h(lVarArr3, i7, lVarP2);
                                                h(lVarArr, i12, gVar);
                                            }
                                        }
                                        zB = true;
                                    } else {
                                        i5 = length;
                                        i6 = i11;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                concurrentHashMap = this;
                i13 = i17;
                length = i5;
                i11 = i6;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object merge(java.lang.Object r18, java.lang.Object r19, java.util.function.BiFunction r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public final void n(l[] lVarArr, int i2) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l lVarK = k(lVarArr, i2);
        if (lVarK == null || lVarK.a < 0) {
            return;
        }
        synchronized (lVarK) {
            try {
                if (k(lVarArr, i2) == lVarK) {
                    r rVar = null;
                    r rVar2 = null;
                    l lVar = lVarK;
                    while (lVar != null) {
                        r rVar3 = new r(lVar.a, lVar.b, lVar.c, null, null);
                        rVar3.h = rVar2;
                        if (rVar2 == null) {
                            rVar = rVar3;
                        } else {
                            rVar2.d = rVar3;
                        }
                        lVar = lVar.d;
                        rVar2 = rVar3;
                    }
                    h(lVarArr, i2, new q(rVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(int i2) {
        int length;
        int iL = i2 >= 536870912 ? 1073741824 : l(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.sizeCtl;
            if (i3 < 0) {
                return;
            }
            l[] lVarArr = this.a;
            if (lVarArr == null || (length = lVarArr.length) == 0) {
                int i4 = i3 > iL ? i3 : iL;
                if (h.c(this, i, i3, -1)) {
                    try {
                        if (this.a == lVarArr) {
                            this.a = new l[i4];
                            i3 = i4 - (i4 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i3;
                    }
                } else {
                    continue;
                }
            } else {
                if (iL <= i3 || length >= 1073741824) {
                    return;
                }
                if (lVarArr == this.a) {
                    if (h.c(this, i, i3, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                        m(lVarArr, null);
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        return (V) f(k2, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(java.util.Map map) {
        o(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public V putIfAbsent(K k2, V v) {
        return (V) f(k2, v, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return g(obj, obj3, obj2) != null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            }
            Object obj = lVarA.c;
            Object obj2 = lVarA.b;
            do {
                Object objApply = biFunction.apply(obj2, obj);
                objApply.getClass();
                if (g(obj2, objApply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = j();
        if (j2 < 0) {
            return 0;
        }
        return j2 > 2147483647L ? ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE : (int) j2;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l lVarA = pVar.a();
        if (lVarA != null) {
            while (true) {
                Object obj = lVarA.b;
                Object obj2 = lVarA.c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        s sVar = this.e;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.e = sVar2;
        return sVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        return g(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, com.github.catvod.spider.jdollar.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return g(obj, obj2, null);
        }
        throw null;
    }

    public ConcurrentHashMap() {
    }
}
