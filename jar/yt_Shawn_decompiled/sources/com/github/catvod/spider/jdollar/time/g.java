package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class g {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ChronoUnit.values().length];
        b = iArr;
        try {
            iArr[ChronoUnit.NANOS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[ChronoUnit.MICROS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[ChronoUnit.MILLIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[ChronoUnit.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[ChronoUnit.MINUTES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[ChronoUnit.HOURS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            b[ChronoUnit.HALF_DAYS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr2 = new int[com.github.catvod.spider.jdollar.time.temporal.a.values().length];
        a = iArr2;
        try {
            iArr2[com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_SECOND.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MICRO_OF_DAY.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_SECOND.ordinal()] = 5;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MILLI_OF_DAY.ordinal()] = 6;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_MINUTE.ordinal()] = 7;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.SECOND_OF_DAY.ordinal()] = 8;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_HOUR.ordinal()] = 9;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MINUTE_OF_DAY.ordinal()] = 10;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_AMPM.ordinal()] = 11;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.HOUR_OF_DAY.ordinal()] = 13;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.CLOCK_HOUR_OF_DAY.ordinal()] = 14;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.AMPM_OF_DAY.ordinal()] = 15;
        } catch (NoSuchFieldError unused22) {
        }
    }
}
