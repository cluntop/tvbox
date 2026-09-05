package com.github.catvod.spider.jdollar.time.format;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[d0.values().length];
        a = iArr;
        try {
            iArr[d0.EXCEEDS_PAD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[d0.ALWAYS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[d0.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[d0.NOT_NEGATIVE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
