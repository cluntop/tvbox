package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ChronoUnit.values().length];
        a = iArr;
        try {
            iArr[ChronoUnit.NANOS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[ChronoUnit.MICROS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[ChronoUnit.MILLIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[ChronoUnit.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[ChronoUnit.MINUTES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[ChronoUnit.HOURS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
