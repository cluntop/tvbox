package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class m {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ChronoUnit.values().length];
        b = iArr;
        try {
            iArr[ChronoUnit.YEARS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[ChronoUnit.DECADES.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[ChronoUnit.CENTURIES.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[ChronoUnit.MILLENNIA.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[ChronoUnit.ERAS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr2 = new int[com.github.catvod.spider.jdollar.time.temporal.a.values().length];
        a = iArr2;
        try {
            iArr2[com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[com.github.catvod.spider.jdollar.time.temporal.a.ERA.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
