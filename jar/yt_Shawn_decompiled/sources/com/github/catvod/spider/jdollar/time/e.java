package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ChronoUnit.values().length];
        b = iArr;
        try {
            iArr[ChronoUnit.DAYS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[ChronoUnit.WEEKS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[ChronoUnit.MONTHS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[ChronoUnit.YEARS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[ChronoUnit.DECADES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[ChronoUnit.CENTURIES.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            b[ChronoUnit.MILLENNIA.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            b[ChronoUnit.ERAS.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr2 = new int[com.github.catvod.spider.jdollar.time.temporal.a.values().length];
        a = iArr2;
        try {
            iArr2[com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_WEEK.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY.ordinal()] = 8;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR.ordinal()] = 10;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH.ordinal()] = 11;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.YEAR.ordinal()] = 12;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.ERA.ordinal()] = 13;
        } catch (NoSuchFieldError unused21) {
        }
    }
}
