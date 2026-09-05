package com.github.catvod.spider.jdollar.util.concurrent;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new ThreadLocalRandom(0);
    }
}
