package com.github.catvod.spider.merge.u;

import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class t1 {
    public static final Class a;
    public static final w1 b;
    public static final w1 c;

    static {
        Class<?> cls;
        Class<?> cls2;
        Class cls3 = e.a;
        w1 w1Var = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            Class cls4 = e.a;
            try {
                cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                w1Var = (w1) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        b = w1Var;
        c = new w1();
    }

    public static int a(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof k0)) {
            int iF = 0;
            while (i < size) {
                iF += u.f(((Integer) list.get(i)).intValue());
                i++;
            }
            return iF;
        }
        k0 k0Var = (k0) list;
        int iF2 = 0;
        while (i < size) {
            iF2 += u.f(k0Var.d(i));
            i++;
        }
        return iF2;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (u.d(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (u.d(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof k0)) {
            int iF = 0;
            while (i < size) {
                iF += u.f(((Integer) list.get(i)).intValue());
                i++;
            }
            return iF;
        }
        k0 k0Var = (k0) list;
        int iF2 = 0;
        while (i < size) {
            iF2 += u.f(k0Var.d(i));
            i++;
        }
        return iF2;
    }

    public static int e(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof y0)) {
            int iF = 0;
            while (i < size) {
                iF += u.f(((Long) list.get(i)).longValue());
                i++;
            }
            return iF;
        }
        y0 y0Var = (y0) list;
        int iF2 = 0;
        while (i < size) {
            iF2 += u.f(y0Var.d(i));
            i++;
        }
        return iF2;
    }

    public static int f(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof k0)) {
            int iB = 0;
            while (i < size) {
                iB += u.b(((Integer) list.get(i)).intValue());
                i++;
            }
            return iB;
        }
        k0 k0Var = (k0) list;
        int iB2 = 0;
        while (i < size) {
            iB2 += u.b(k0Var.d(i));
            i++;
        }
        return iB2;
    }

    public static int g(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof y0)) {
            int iC = 0;
            while (i < size) {
                iC += u.c(((Long) list.get(i)).longValue());
                i++;
            }
            return iC;
        }
        y0 y0Var = (y0) list;
        int iC2 = 0;
        while (i < size) {
            iC2 += u.c(y0Var.d(i));
            i++;
        }
        return iC2;
    }

    public static int h(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof k0)) {
            int iE = 0;
            while (i < size) {
                iE += u.e(((Integer) list.get(i)).intValue());
                i++;
            }
            return iE;
        }
        k0 k0Var = (k0) list;
        int iE2 = 0;
        while (i < size) {
            iE2 += u.e(k0Var.d(i));
            i++;
        }
        return iE2;
    }

    public static int i(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof y0)) {
            int iF = 0;
            while (i < size) {
                iF += u.f(((Long) list.get(i)).longValue());
                i++;
            }
            return iF;
        }
        y0 y0Var = (y0) list;
        int iF2 = 0;
        while (i < size) {
            iF2 += u.f(y0Var.d(i));
            i++;
        }
        return iF2;
    }

    public static Object j(Object obj, int i, r0 r0Var, Object obj2, w1 w1Var) {
        return obj2;
    }

    public static void k(w1 w1Var, Object obj, Object obj2) {
        w1Var.getClass();
        j0 j0Var = (j0) obj;
        v1 v1VarE = j0Var.unknownFields;
        v1 v1Var = ((j0) obj2).unknownFields;
        v1 v1Var2 = v1.f;
        if (!v1Var2.equals(v1Var)) {
            if (v1Var2.equals(v1VarE)) {
                v1VarE = v1.e(v1VarE, v1Var);
            } else {
                v1VarE.getClass();
                if (!v1Var.equals(v1Var2)) {
                    v1VarE.a();
                    int i = v1VarE.a + v1Var.a;
                    v1VarE.b(i);
                    System.arraycopy(v1Var.b, 0, v1VarE.b, v1VarE.a, v1Var.a);
                    System.arraycopy(v1Var.c, 0, v1VarE.c, v1VarE.a, v1Var.a);
                    v1VarE.a = i;
                }
            }
        }
        j0Var.unknownFields = v1VarE;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof g;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.h(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3++;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.g(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        g gVar = (g) list;
        if (!z) {
            while (i2 < gVar.c) {
                gVar.c(i2);
                uVar.h(i, gVar.b[i2]);
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < gVar.c; i6++) {
            gVar.c(i6);
            boolean z4 = gVar.b[i6];
            boolean z5 = u.b;
            i5++;
        }
        uVar.t(i5);
        while (i2 < gVar.c) {
            gVar.c(i2);
            uVar.g(gVar.b[i2] ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void n(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof v;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    double dDoubleValue = ((Double) list.get(i2)).doubleValue();
                    uVar.getClass();
                    uVar.l(i, Double.doubleToRawLongBits(dDoubleValue));
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3 += 8;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.m(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        v vVar = (v) list;
        if (!z) {
            while (i2 < vVar.c) {
                vVar.c(i2);
                double d = vVar.b[i2];
                uVar.getClass();
                uVar.l(i, Double.doubleToRawLongBits(d));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < vVar.c; i6++) {
            vVar.c(i6);
            double d2 = vVar.b[i6];
            boolean z4 = u.b;
            i5 += 8;
        }
        uVar.t(i5);
        while (i2 < vVar.c) {
            vVar.c(i2);
            uVar.m(Double.doubleToRawLongBits(vVar.b[i2]));
            i2++;
        }
    }

    public static void o(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof k0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.n(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iF += u.f(((Integer) list.get(i3)).intValue());
            }
            uVar.t(iF);
            while (i2 < list.size()) {
                uVar.o(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        k0 k0Var = (k0) list;
        if (!z) {
            while (i2 < k0Var.c) {
                uVar.n(i, k0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iF2 = 0;
        for (int i4 = 0; i4 < k0Var.c; i4++) {
            iF2 += u.f(k0Var.d(i4));
        }
        uVar.t(iF2);
        while (i2 < k0Var.c) {
            uVar.o(k0Var.d(i2));
            i2++;
        }
    }

    public static void p(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof k0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.j(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3 += 4;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.k(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        k0 k0Var = (k0) list;
        if (!z) {
            while (i2 < k0Var.c) {
                uVar.j(i, k0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < k0Var.c; i6++) {
            k0Var.d(i6);
            boolean z4 = u.b;
            i5 += 4;
        }
        uVar.t(i5);
        while (i2 < k0Var.c) {
            uVar.k(k0Var.d(i2));
            i2++;
        }
    }

    public static void q(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof y0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.l(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3 += 8;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.m(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        y0 y0Var = (y0) list;
        if (!z) {
            while (i2 < y0Var.c) {
                uVar.l(i, y0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < y0Var.c; i6++) {
            y0Var.d(i6);
            boolean z4 = u.b;
            i5 += 8;
        }
        uVar.t(i5);
        while (i2 < y0Var.c) {
            uVar.m(y0Var.d(i2));
            i2++;
        }
    }

    public static void r(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof c0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    float fFloatValue = ((Float) list.get(i2)).floatValue();
                    uVar.getClass();
                    uVar.j(i, Float.floatToRawIntBits(fFloatValue));
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3 += 4;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.k(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        c0 c0Var = (c0) list;
        if (!z) {
            while (i2 < c0Var.c) {
                c0Var.c(i2);
                float f = c0Var.b[i2];
                uVar.getClass();
                uVar.j(i, Float.floatToRawIntBits(f));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c0Var.c; i6++) {
            c0Var.c(i6);
            float f2 = c0Var.b[i6];
            boolean z4 = u.b;
            i5 += 4;
        }
        uVar.t(i5);
        while (i2 < c0Var.c) {
            c0Var.c(i2);
            uVar.k(Float.floatToRawIntBits(c0Var.b[i2]));
            i2++;
        }
    }

    public static void s(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof k0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.n(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iF += u.f(((Integer) list.get(i3)).intValue());
            }
            uVar.t(iF);
            while (i2 < list.size()) {
                uVar.o(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        k0 k0Var = (k0) list;
        if (!z) {
            while (i2 < k0Var.c) {
                uVar.n(i, k0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iF2 = 0;
        for (int i4 = 0; i4 < k0Var.c; i4++) {
            iF2 += u.f(k0Var.d(i4));
        }
        uVar.t(iF2);
        while (i2 < k0Var.c) {
            uVar.o(k0Var.d(i2));
            i2++;
        }
    }

    public static void t(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof y0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.u(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iF += u.f(((Long) list.get(i3)).longValue());
            }
            uVar.t(iF);
            while (i2 < list.size()) {
                uVar.v(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        y0 y0Var = (y0) list;
        if (!z) {
            while (i2 < y0Var.c) {
                uVar.u(i, y0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iF2 = 0;
        for (int i4 = 0; i4 < y0Var.c; i4++) {
            iF2 += u.f(y0Var.d(i4));
        }
        uVar.t(iF2);
        while (i2 < y0Var.c) {
            uVar.v(y0Var.d(i2));
            i2++;
        }
    }

    public static void u(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof k0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.j(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3 += 4;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.k(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        k0 k0Var = (k0) list;
        if (!z) {
            while (i2 < k0Var.c) {
                uVar.j(i, k0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < k0Var.c; i6++) {
            k0Var.d(i6);
            boolean z4 = u.b;
            i5 += 4;
        }
        uVar.t(i5);
        while (i2 < k0Var.c) {
            uVar.k(k0Var.d(i2));
            i2++;
        }
    }

    public static void v(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof y0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.l(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                boolean z3 = u.b;
                i3 += 8;
            }
            uVar.t(i3);
            while (i2 < list.size()) {
                uVar.m(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        y0 y0Var = (y0) list;
        if (!z) {
            while (i2 < y0Var.c) {
                uVar.l(i, y0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < y0Var.c; i6++) {
            y0Var.d(i6);
            boolean z4 = u.b;
            i5 += 8;
        }
        uVar.t(i5);
        while (i2 < y0Var.c) {
            uVar.m(y0Var.d(i2));
            i2++;
        }
    }

    public static void w(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof k0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    uVar.s(i, (iIntValue >> 31) ^ (iIntValue << 1));
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iB += u.b(((Integer) list.get(i3)).intValue());
            }
            uVar.t(iB);
            while (i2 < list.size()) {
                int iIntValue2 = ((Integer) list.get(i2)).intValue();
                uVar.t((iIntValue2 >> 31) ^ (iIntValue2 << 1));
                i2++;
            }
            return;
        }
        k0 k0Var = (k0) list;
        if (!z) {
            while (i2 < k0Var.c) {
                int iD = k0Var.d(i2);
                uVar.s(i, (iD >> 31) ^ (iD << 1));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iB2 = 0;
        for (int i4 = 0; i4 < k0Var.c; i4++) {
            iB2 += u.b(k0Var.d(i4));
        }
        uVar.t(iB2);
        while (i2 < k0Var.c) {
            int iD2 = k0Var.d(i2);
            uVar.t((iD2 >> 31) ^ (iD2 << 1));
            i2++;
        }
    }

    public static void x(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof y0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    uVar.u(i, (jLongValue >> 63) ^ (jLongValue << 1));
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iC += u.c(((Long) list.get(i3)).longValue());
            }
            uVar.t(iC);
            while (i2 < list.size()) {
                long jLongValue2 = ((Long) list.get(i2)).longValue();
                uVar.v((jLongValue2 >> 63) ^ (jLongValue2 << 1));
                i2++;
            }
            return;
        }
        y0 y0Var = (y0) list;
        if (!z) {
            while (i2 < y0Var.c) {
                long jD = y0Var.d(i2);
                uVar.u(i, (jD >> 63) ^ (jD << 1));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iC2 = 0;
        for (int i4 = 0; i4 < y0Var.c; i4++) {
            iC2 += u.c(y0Var.d(i4));
        }
        uVar.t(iC2);
        while (i2 < y0Var.c) {
            long jD2 = y0Var.d(i2);
            uVar.v((jD2 >> 63) ^ (jD2 << 1));
            i2++;
        }
    }

    public static void y(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof k0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.s(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iE += u.e(((Integer) list.get(i3)).intValue());
            }
            uVar.t(iE);
            while (i2 < list.size()) {
                uVar.t(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        k0 k0Var = (k0) list;
        if (!z) {
            while (i2 < k0Var.c) {
                uVar.s(i, k0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iE2 = 0;
        for (int i4 = 0; i4 < k0Var.c; i4++) {
            iE2 += u.e(k0Var.d(i4));
        }
        uVar.t(iE2);
        while (i2 < k0Var.c) {
            uVar.t(k0Var.d(i2));
            i2++;
        }
    }

    public static void z(int i, List list, a1 a1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z2 = list instanceof y0;
        u uVar = (u) a1Var.a;
        int i2 = 0;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    uVar.u(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            uVar.r(i, 2);
            int iF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iF += u.f(((Long) list.get(i3)).longValue());
            }
            uVar.t(iF);
            while (i2 < list.size()) {
                uVar.v(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        y0 y0Var = (y0) list;
        if (!z) {
            while (i2 < y0Var.c) {
                uVar.u(i, y0Var.d(i2));
                i2++;
            }
            return;
        }
        uVar.r(i, 2);
        int iF2 = 0;
        for (int i4 = 0; i4 < y0Var.c; i4++) {
            iF2 += u.f(y0Var.d(i4));
        }
        uVar.t(iF2);
        while (i2 < y0Var.c) {
            uVar.v(y0Var.d(i2));
            i2++;
        }
    }
}
