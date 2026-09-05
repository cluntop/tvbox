package com.github.catvod.spider.jdollar.sun.misc;

import com.github.catvod.spider.jdollar.util.concurrent.l;
import com.github.catvod.spider.jdollar.util.concurrent.q;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public static final a b;
    public final Unsafe a;

    static {
        Field fieldG = g();
        fieldG.setAccessible(true);
        try {
            b = new a((Unsafe) fieldG.get(null));
        } catch (IllegalAccessException e) {
            throw new AssertionError("Couldn't get the Unsafe", e);
        }
    }

    public a(Unsafe unsafe) {
        this.a = unsafe;
    }

    public static Field g() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e);
        }
    }

    public final int a(Class cls) {
        return this.a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.a.arrayIndexScale(cls);
    }

    public final boolean c(Object obj, long j, int i, int i2) {
        return this.a.compareAndSwapInt(obj, j, i, i2);
    }

    public final boolean d(Object obj, long j, long j2, long j3) {
        return this.a.compareAndSwapLong(obj, j, j2, j3);
    }

    public final int e(q qVar, long j) {
        while (true) {
            int intVolatile = this.a.getIntVolatile(qVar, j);
            q qVar2 = qVar;
            long j2 = j;
            if (this.a.compareAndSwapInt(qVar2, j2, intVolatile, intVolatile - 4)) {
                return intVolatile;
            }
            qVar = qVar2;
            j = j2;
        }
    }

    public final Object f(Object obj, long j) {
        return this.a.getObjectVolatile(obj, j);
    }

    public final long h(Class cls, String str) {
        try {
            return i(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError("Cannot find field:", e);
        }
    }

    public final long i(Field field) {
        return this.a.objectFieldOffset(field);
    }

    public final void j(Object obj, long j, l lVar) {
        this.a.putObjectVolatile(obj, j, lVar);
    }
}
