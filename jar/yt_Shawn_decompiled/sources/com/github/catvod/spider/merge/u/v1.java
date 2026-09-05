package com.github.catvod.spider.merge.u;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v1 {
    public static final v1 f = new v1(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public v1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static v1 e(v1 v1Var, v1 v1Var2) {
        int i = v1Var.a + v1Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(v1Var.b, i);
        System.arraycopy(v1Var2.b, 0, iArrCopyOf, v1Var.a, v1Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(v1Var.c, i);
        System.arraycopy(v1Var2.c, 0, objArrCopyOf, v1Var.a, v1Var2.a);
        return new v1(i, iArrCopyOf, objArrCopyOf, true);
    }

    public final void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final int c() {
        int iD;
        int iF;
        int iD2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.c[i3]).getClass();
                    iD2 = u.d(i5) + 8;
                } else if (i6 == 2) {
                    iD2 = u.a(i5, (l) this.c[i3]);
                } else if (i6 == 3) {
                    iD = u.d(i5) * 2;
                    iF = ((v1) this.c[i3]).c();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(u0.c());
                    }
                    ((Integer) this.c[i3]).getClass();
                    iD2 = u.d(i5) + 4;
                }
                i2 = iD2 + i2;
            } else {
                long jLongValue = ((Long) this.c[i3]).longValue();
                iD = u.d(i5);
                iF = u.f(jLongValue);
            }
            i2 = iF + iD + i2;
        }
        this.d = i2;
        return i2;
    }

    public final boolean d(int i, p pVar) throws t0 {
        int iZ;
        a();
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            f(i, Long.valueOf(pVar.r()));
            return true;
        }
        if (i3 == 1) {
            f(i, Long.valueOf(pVar.o()));
            return true;
        }
        if (i3 == 2) {
            f(i, pVar.k());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                pVar.getClass();
                pVar.a(0);
                return false;
            }
            if (i3 != 5) {
                throw u0.c();
            }
            f(i, Integer.valueOf(pVar.n()));
            return true;
        }
        v1 v1Var = new v1();
        do {
            iZ = pVar.z();
            if (iZ == 0) {
                break;
            }
        } while (v1Var.d(iZ, pVar));
        pVar.a((i2 << 3) | 4);
        f(i, v1Var);
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        int i = this.a;
        if (i == v1Var.a) {
            int[] iArr = this.b;
            int[] iArr2 = v1Var.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = v1Var.c;
                    int i3 = this.a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final void f(int i, Object obj) {
        a();
        b(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void g(a1 a1Var) {
        if (this.a == 0) {
            return;
        }
        for (int i = 0; i < this.a; i++) {
            int i2 = this.b[i];
            Object obj = this.c[i];
            u uVar = (u) a1Var.a;
            int i3 = i2 >>> 3;
            int i4 = i2 & 7;
            if (i4 == 0) {
                uVar.u(i3, ((Long) obj).longValue());
            } else if (i4 == 1) {
                uVar.l(i3, ((Long) obj).longValue());
            } else if (i4 == 2) {
                uVar.i(i3, (l) obj);
            } else if (i4 == 3) {
                uVar.r(i3, 3);
                ((v1) obj).g(a1Var);
                uVar.r(i3, 4);
            } else {
                if (i4 != 5) {
                    throw new RuntimeException(u0.c());
                }
                uVar.j(i3, ((Integer) obj).intValue());
            }
        }
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public v1() {
        this(0, new int[8], new Object[8], true);
    }
}
