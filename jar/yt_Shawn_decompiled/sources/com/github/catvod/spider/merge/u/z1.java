package com.github.catvod.spider.merge.u;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class z1 extends a2 {
    @Override // com.github.catvod.spider.merge.u.a2
    public final boolean c(Object obj, long j) {
        return this.a.getBoolean(obj, j);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final byte d(Object obj, long j) {
        return this.a.getByte(obj, j);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final double e(Object obj, long j) {
        return this.a.getDouble(obj, j);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final float f(Object obj, long j) {
        return this.a.getFloat(obj, j);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void k(Object obj, long j, boolean z) {
        this.a.putBoolean(obj, j, z);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void l(Object obj, long j, byte b) {
        this.a.putByte(obj, j, b);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void m(Object obj, long j, double d) {
        this.a.putDouble(obj, j, d);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final void n(Object obj, long j, float f) {
        this.a.putFloat(obj, j, f);
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final boolean r() {
        if (!super.r()) {
            return false;
        }
        try {
            Class<?> cls = this.a.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            b2.a(th);
            return false;
        }
    }

    @Override // com.github.catvod.spider.merge.u.a2
    public final boolean s() {
        Unsafe unsafe = this.a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (b2.e() != null) {
                    try {
                        Class<?> cls3 = this.a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        b2.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                b2.a(th2);
            }
        }
        return false;
    }
}
