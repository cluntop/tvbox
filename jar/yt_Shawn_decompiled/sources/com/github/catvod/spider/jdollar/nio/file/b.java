package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.time.DateTimeException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ void a(long j) {
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static /* synthetic */ void b(Object obj, String str) {
        throw new com.github.catvod.spider.jdollar.time.temporal.r(str + obj);
    }

    public static /* synthetic */ void c(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void d(String str, int i) {
        throw new DateTimeException(str + i);
    }

    public static /* synthetic */ void e(String str, int i, Object obj) {
        throw new DateTimeException(str + i + obj);
    }

    public static /* synthetic */ void f(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException(str + obj + obj2);
    }

    public static /* synthetic */ void g(String str, Object obj, Object obj2, Object obj3) {
        throw new DateTimeException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void h(String str, Object obj, Object obj2, Throwable th) {
        throw new DateTimeException(str + obj + ((Object) " of type ") + obj2, th);
    }

    public static /* synthetic */ void i(String str, Object[] objArr) {
        throw new IllegalStateException(String.format(str, objArr));
    }

    public static /* synthetic */ void j(Object obj, String str) {
        throw new DateTimeException(str + obj);
    }

    public static /* synthetic */ void k(String str) {
        throw new DateTimeException(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(String str, int i) {
        throw new IllegalArgumentException(str + ((char) i));
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new ClassCastException(str + obj + ((Object) ", actual: ") + obj2);
    }

    public static /* synthetic */ void n(String str, int i) {
        throw new IllegalArgumentException(str + i);
    }
}
