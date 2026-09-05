package com.github.catvod.spider.merge.u;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b2 {
    public static final Unsafe a;
    public static final Class b;
    public static final a2 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    static {
        Unsafe unsafeJ = j();
        a = unsafeJ;
        b = e.a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        char c2 = 1;
        int i = 0;
        a2 z1Var = null;
        if (unsafeJ != null) {
            if (!e.a()) {
                z1Var = new z1(unsafeJ);
            } else if (zF) {
                z1Var = new y1(unsafeJ, c2 == true ? 1 : 0);
            } else if (zF2) {
                z1Var = new y1(unsafeJ, i);
            }
        }
        c = z1Var;
        d = z1Var == null ? false : z1Var.s();
        e = z1Var == null ? false : z1Var.r();
        f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field fieldE = e();
        if (fieldE != null && z1Var != null) {
            z1Var.j(fieldE);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(b2.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int c(Class cls) {
        if (e) {
            return c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (e) {
            c.b(cls);
        }
    }

    public static Field e() {
        Field declaredField;
        Field declaredField2;
        if (e.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(Class cls) {
        if (!e.a()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte g(byte[] bArr, long j) {
        return c.d(bArr, f + j);
    }

    public static byte h(Object obj, long j) {
        return (byte) ((c.g(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static byte i(Object obj, long j) {
        return (byte) ((c.g(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new x1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(b2.class.getName()).log(Level.WARNING, "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    public static void k(byte[] bArr, long j, byte b2) {
        c.l(bArr, f + j, b2);
    }

    public static void l(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iG = c.g(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        n(((255 & b2) << i) | (iG & (~(255 << i))), j2, obj);
    }

    public static void m(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        n(((255 & b2) << i) | (c.g(obj, j2) & (~(255 << i))), j2, obj);
    }

    public static void n(int i, long j, Object obj) {
        c.o(i, j, obj);
    }

    public static void o(Object obj, long j, long j2) {
        c.p(obj, j, j2);
    }

    public static void p(Object obj, long j, Object obj2) {
        c.q(obj, j, obj2);
    }
}
