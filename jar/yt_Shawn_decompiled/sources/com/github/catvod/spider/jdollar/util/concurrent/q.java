package com.github.catvod.spider.jdollar.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q extends l {
    public static final com.github.catvod.spider.jdollar.sun.misc.a h;
    public static final long i;
    public r e;
    public volatile r f;
    public volatile Thread g;
    volatile int lockState;

    static {
        com.github.catvod.spider.jdollar.sun.misc.a aVar = com.github.catvod.spider.jdollar.sun.misc.a.b;
        h = aVar;
        i = aVar.h(q.class, "lockState");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[PHI: r7
      0x004b: PHI (r7v3 java.lang.Class<?>) = (r7v2 java.lang.Class<?>), (r7v4 java.lang.Class<?>) binds: [B:24:0x0049, B:16:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public q(com.github.catvod.spider.jdollar.util.concurrent.r r11) {
        /*
            r10 = this;
            r0 = -2
            r1 = 0
            r10.<init>(r0, r1, r1)
            r10.f = r11
            r0 = r1
        L8:
            if (r11 == 0) goto L6c
            com.github.catvod.spider.jdollar.util.concurrent.l r2 = r11.d
            com.github.catvod.spider.jdollar.util.concurrent.r r2 = (com.github.catvod.spider.jdollar.util.concurrent.r) r2
            r11.g = r1
            r11.f = r1
            r3 = 0
            if (r0 != 0) goto L1b
            r11.e = r1
            r11.i = r3
        L19:
            r0 = r11
            goto L68
        L1b:
            java.lang.Object r4 = r11.b
            int r5 = r11.a
            r6 = r0
            r7 = r1
        L21:
            java.lang.Object r8 = r6.b
            int r9 = r6.a
            if (r9 <= r5) goto L29
            r8 = -1
            goto L51
        L29:
            if (r9 >= r5) goto L2d
            r8 = 1
            goto L51
        L2d:
            if (r7 != 0) goto L35
            java.lang.Class r7 = com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.c(r4)
            if (r7 == 0) goto L4b
        L35:
            int r9 = com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.g
            if (r8 == 0) goto L48
            java.lang.Class r9 = r8.getClass()
            if (r9 == r7) goto L40
            goto L48
        L40:
            r9 = r4
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            int r9 = r9.compareTo(r8)
            goto L49
        L48:
            r9 = 0
        L49:
            if (r9 != 0) goto L50
        L4b:
            int r8 = i(r4, r8)
            goto L51
        L50:
            r8 = r9
        L51:
            if (r8 > 0) goto L56
            com.github.catvod.spider.jdollar.util.concurrent.r r9 = r6.f
            goto L58
        L56:
            com.github.catvod.spider.jdollar.util.concurrent.r r9 = r6.g
        L58:
            if (r9 != 0) goto L6a
            r11.e = r6
            if (r8 > 0) goto L61
            r6.f = r11
            goto L63
        L61:
            r6.g = r11
        L63:
            com.github.catvod.spider.jdollar.util.concurrent.r r11 = c(r0, r11)
            goto L19
        L68:
            r11 = r2
            goto L8
        L6a:
            r6 = r9
            goto L21
        L6c:
            r10.e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.q.<init>(com.github.catvod.spider.jdollar.util.concurrent.r):void");
    }

    public static r b(r rVar, r rVar2) {
        while (rVar2 != null && rVar2 != rVar) {
            r rVar3 = rVar2.e;
            if (rVar3 == null) {
                rVar2.i = false;
                return rVar2;
            }
            if (rVar2.i) {
                rVar2.i = false;
                return rVar;
            }
            r rVar4 = rVar3.f;
            if (rVar4 == rVar2) {
                r rVar5 = rVar3.g;
                if (rVar5 != null && rVar5.i) {
                    rVar5.i = false;
                    rVar3.i = true;
                    rVar = g(rVar, rVar3);
                    rVar3 = rVar2.e;
                    rVar5 = rVar3 == null ? null : rVar3.g;
                }
                if (rVar5 != null) {
                    r rVar6 = rVar5.f;
                    r rVar7 = rVar5.g;
                    if ((rVar7 == null || !rVar7.i) && (rVar6 == null || !rVar6.i)) {
                        rVar5.i = true;
                    } else {
                        if (rVar7 == null || !rVar7.i) {
                            if (rVar6 != null) {
                                rVar6.i = false;
                            }
                            rVar5.i = true;
                            rVar = h(rVar, rVar5);
                            rVar3 = rVar2.e;
                            rVar5 = rVar3 != null ? rVar3.g : null;
                        }
                        if (rVar5 != null) {
                            rVar5.i = rVar3 == null ? false : rVar3.i;
                            r rVar8 = rVar5.g;
                            if (rVar8 != null) {
                                rVar8.i = false;
                            }
                        }
                        if (rVar3 != null) {
                            rVar3.i = false;
                            rVar = g(rVar, rVar3);
                        }
                        rVar2 = rVar;
                    }
                }
                rVar2 = rVar3;
            } else {
                if (rVar4 != null && rVar4.i) {
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar = h(rVar, rVar3);
                    rVar3 = rVar2.e;
                    rVar4 = rVar3 == null ? null : rVar3.f;
                }
                if (rVar4 != null) {
                    r rVar9 = rVar4.f;
                    r rVar10 = rVar4.g;
                    if ((rVar9 == null || !rVar9.i) && (rVar10 == null || !rVar10.i)) {
                        rVar4.i = true;
                    } else {
                        if (rVar9 == null || !rVar9.i) {
                            if (rVar10 != null) {
                                rVar10.i = false;
                            }
                            rVar4.i = true;
                            rVar = g(rVar, rVar4);
                            rVar3 = rVar2.e;
                            rVar4 = rVar3 != null ? rVar3.f : null;
                        }
                        if (rVar4 != null) {
                            rVar4.i = rVar3 == null ? false : rVar3.i;
                            r rVar11 = rVar4.f;
                            if (rVar11 != null) {
                                rVar11.i = false;
                            }
                        }
                        if (rVar3 != null) {
                            rVar3.i = false;
                            rVar = h(rVar, rVar3);
                        }
                        rVar2 = rVar;
                    }
                }
                rVar2 = rVar3;
            }
        }
        return rVar;
    }

    public static r c(r rVar, r rVar2) {
        r rVar3;
        rVar2.i = true;
        while (true) {
            r rVar4 = rVar2.e;
            if (rVar4 == null) {
                rVar2.i = false;
                return rVar2;
            }
            if (!rVar4.i || (rVar3 = rVar4.e) == null) {
                break;
            }
            r rVar5 = rVar3.f;
            if (rVar4 == rVar5) {
                r rVar6 = rVar3.g;
                if (rVar6 == null || !rVar6.i) {
                    if (rVar2 == rVar4.g) {
                        rVar = g(rVar, rVar4);
                        r rVar7 = rVar4.e;
                        rVar3 = rVar7 == null ? null : rVar7.e;
                        rVar4 = rVar7;
                        rVar2 = rVar4;
                    }
                    if (rVar4 != null) {
                        rVar4.i = false;
                        if (rVar3 != null) {
                            rVar3.i = true;
                            rVar = h(rVar, rVar3);
                        }
                    }
                } else {
                    rVar6.i = false;
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar2 = rVar3;
                }
            } else if (rVar5 == null || !rVar5.i) {
                if (rVar2 == rVar4.f) {
                    rVar = h(rVar, rVar4);
                    r rVar8 = rVar4.e;
                    rVar3 = rVar8 == null ? null : rVar8.e;
                    rVar4 = rVar8;
                    rVar2 = rVar4;
                }
                if (rVar4 != null) {
                    rVar4.i = false;
                    if (rVar3 != null) {
                        rVar3.i = true;
                        rVar = g(rVar, rVar3);
                    }
                }
            } else {
                rVar5.i = false;
                rVar4.i = false;
                rVar3.i = true;
                rVar2 = rVar3;
            }
        }
        return rVar;
    }

    public static r g(r rVar, r rVar2) {
        r rVar3;
        if (rVar2 != null && (rVar3 = rVar2.g) != null) {
            r rVar4 = rVar3.f;
            rVar2.g = rVar4;
            if (rVar4 != null) {
                rVar4.e = rVar2;
            }
            r rVar5 = rVar2.e;
            rVar3.e = rVar5;
            if (rVar5 == null) {
                rVar3.i = false;
                rVar = rVar3;
            } else if (rVar5.f == rVar2) {
                rVar5.f = rVar3;
            } else {
                rVar5.g = rVar3;
            }
            rVar3.f = rVar2;
            rVar2.e = rVar3;
        }
        return rVar;
    }

    public static r h(r rVar, r rVar2) {
        r rVar3;
        if (rVar2 != null && (rVar3 = rVar2.f) != null) {
            r rVar4 = rVar3.g;
            rVar2.f = rVar4;
            if (rVar4 != null) {
                rVar4.e = rVar2;
            }
            r rVar5 = rVar2.e;
            rVar3.e = rVar5;
            if (rVar5 == null) {
                rVar3.i = false;
                rVar = rVar3;
            } else if (rVar5.g == rVar2) {
                rVar5.g = rVar3;
            } else {
                rVar5.f = rVar3;
            }
            rVar3.g = rVar2;
            rVar2.e = rVar3;
        }
        return rVar;
    }

    public static int i(Object obj, Object obj2) {
        int iCompareTo;
        return (obj == null || obj2 == null || (iCompareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : iCompareTo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        return r0;
     */
    @Override // com.github.catvod.spider.jdollar.util.concurrent.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.util.concurrent.l a(int r9, java.lang.Object r10) {
        /*
            r8 = this;
            com.github.catvod.spider.jdollar.util.concurrent.r r0 = r8.f
        L2:
            r1 = 0
            if (r0 == 0) goto L58
            int r6 = r8.lockState
            r2 = r6 & 3
            if (r2 == 0) goto L1f
            int r1 = r0.a
            if (r1 != r9) goto L1c
            java.lang.Object r1 = r0.b
            if (r1 == r10) goto L1b
            if (r1 == 0) goto L1c
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L1c
        L1b:
            return r0
        L1c:
            com.github.catvod.spider.jdollar.util.concurrent.l r0 = r0.d
            goto L2
        L1f:
            com.github.catvod.spider.jdollar.sun.misc.a r2 = com.github.catvod.spider.jdollar.util.concurrent.q.h
            long r4 = com.github.catvod.spider.jdollar.util.concurrent.q.i
            int r7 = r6 + 4
            r3 = r8
            boolean r6 = r2.c(r3, r4, r6, r7)
            if (r6 == 0) goto L2
            r3 = 6
            com.github.catvod.spider.jdollar.util.concurrent.r r0 = r8.e     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L32
            goto L36
        L32:
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = r0.b(r9, r10, r1)     // Catch: java.lang.Throwable -> L44
        L36:
            int r9 = r2.e(r8, r4)
            if (r9 != r3) goto L43
            java.lang.Thread r9 = r8.g
            if (r9 == 0) goto L43
            java.util.concurrent.locks.LockSupport.unpark(r9)
        L43:
            return r1
        L44:
            r0 = move-exception
            r9 = r0
            com.github.catvod.spider.jdollar.sun.misc.a r10 = com.github.catvod.spider.jdollar.util.concurrent.q.h
            long r0 = com.github.catvod.spider.jdollar.util.concurrent.q.i
            int r10 = r10.e(r8, r0)
            if (r10 != r3) goto L57
            java.lang.Thread r10 = r8.g
            if (r10 == 0) goto L57
            java.util.concurrent.locks.LockSupport.unpark(r10)
        L57:
            throw r9
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.q.a(int, java.lang.Object):com.github.catvod.spider.jdollar.util.concurrent.l");
    }

    public final void d() {
        if (h.c(this, i, 0, 1)) {
            return;
        }
        boolean z = false;
        while (true) {
            int i2 = this.lockState;
            if ((i2 & (-3)) == 0) {
                if (h.c(this, i, i2, 1)) {
                    break;
                }
            } else if ((i2 & 2) == 0) {
                if (h.c(this, i, i2, i2 | 2)) {
                    this.g = Thread.currentThread();
                    z = true;
                }
            } else if (z) {
                LockSupport.park(this);
            }
        }
        if (z) {
            this.g = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0050 A[PHI: r0
      0x0050: PHI (r0v4 java.lang.Class<?>) = (r0v3 java.lang.Class<?>), (r0v5 java.lang.Class<?>) binds: [B:27:0x004e, B:19:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.util.concurrent.r e(int r12, java.lang.Object r13, java.lang.Object r14) {
        /*
            r11 = this;
            com.github.catvod.spider.jdollar.util.concurrent.r r0 = r11.e
            r7 = 0
            r8 = 0
            r6 = r0
            r0 = r7
            r1 = 0
        L7:
            if (r6 != 0) goto L18
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = new com.github.catvod.spider.jdollar.util.concurrent.r
            r5 = 0
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            r11.e = r1
            r11.f = r1
            return r7
        L18:
            int r4 = r6.a
            r9 = 1
            if (r4 <= r12) goto L20
            r4 = -1
            r10 = -1
            goto L71
        L20:
            if (r4 >= r12) goto L24
            r10 = 1
            goto L71
        L24:
            java.lang.Object r4 = r6.b
            if (r4 == r13) goto Lad
            if (r4 == 0) goto L32
            boolean r5 = r13.equals(r4)
            if (r5 == 0) goto L32
            goto Lad
        L32:
            if (r0 != 0) goto L3a
            java.lang.Class r0 = com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.c(r13)
            if (r0 == 0) goto L50
        L3a:
            int r5 = com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.g
            if (r4 == 0) goto L4d
            java.lang.Class r5 = r4.getClass()
            if (r5 == r0) goto L45
            goto L4d
        L45:
            r5 = r13
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            int r5 = r5.compareTo(r4)
            goto L4e
        L4d:
            r5 = 0
        L4e:
            if (r5 != 0) goto L70
        L50:
            if (r1 != 0) goto L6a
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = r6.f
            if (r1 == 0) goto L5e
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = r1.b(r12, r13, r0)
            if (r1 != 0) goto L5d
            goto L5e
        L5d:
            return r1
        L5e:
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = r6.g
            if (r1 == 0) goto L69
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = r1.b(r12, r13, r0)
            if (r1 == 0) goto L69
            return r1
        L69:
            r1 = 1
        L6a:
            int r4 = i(r13, r4)
            r10 = r4
            goto L71
        L70:
            r10 = r5
        L71:
            if (r10 > 0) goto L76
            com.github.catvod.spider.jdollar.util.concurrent.r r4 = r6.f
            goto L78
        L76:
            com.github.catvod.spider.jdollar.util.concurrent.r r4 = r6.g
        L78:
            if (r4 != 0) goto Laa
            com.github.catvod.spider.jdollar.util.concurrent.r r5 = r11.f
            com.github.catvod.spider.jdollar.util.concurrent.r r1 = new com.github.catvod.spider.jdollar.util.concurrent.r
            r2 = r12
            r3 = r13
            r4 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            r11.f = r1
            if (r5 == 0) goto L8a
            r5.h = r1
        L8a:
            if (r10 > 0) goto L8f
            r6.f = r1
            goto L91
        L8f:
            r6.g = r1
        L91:
            boolean r0 = r6.i
            if (r0 != 0) goto L98
            r1.i = r9
            return r7
        L98:
            r11.d()
            com.github.catvod.spider.jdollar.util.concurrent.r r0 = r11.e     // Catch: java.lang.Throwable -> La6
            com.github.catvod.spider.jdollar.util.concurrent.r r0 = c(r0, r1)     // Catch: java.lang.Throwable -> La6
            r11.e = r0     // Catch: java.lang.Throwable -> La6
            r11.lockState = r8
            return r7
        La6:
            r0 = move-exception
            r11.lockState = r8
            throw r0
        Laa:
            r6 = r4
            goto L7
        Lad:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.q.e(int, java.lang.Object, java.lang.Object):com.github.catvod.spider.jdollar.util.concurrent.r");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x008e A[PHI: r0
      0x008e: PHI (r0v4 com.github.catvod.spider.jdollar.util.concurrent.r) = (r0v3 com.github.catvod.spider.jdollar.util.concurrent.r), (r0v12 com.github.catvod.spider.jdollar.util.concurrent.r) binds: [B:55:0x008a, B:51:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(com.github.catvod.spider.jdollar.util.concurrent.r r11) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.q.f(com.github.catvod.spider.jdollar.util.concurrent.r):boolean");
    }
}
