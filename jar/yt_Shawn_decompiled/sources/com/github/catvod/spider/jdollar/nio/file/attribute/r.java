package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class r {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[TimeUnit.values().length];
        a = iArr;
        try {
            iArr[TimeUnit.DAYS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[TimeUnit.HOURS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[TimeUnit.MINUTES.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[TimeUnit.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[TimeUnit.MILLISECONDS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[TimeUnit.MICROSECONDS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[TimeUnit.NANOSECONDS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
