package com.github.catvod.spider.jdollar.nio.file;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class k {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[FileVisitOption.values().length];
        a = iArr;
        try {
            iArr[FileVisitOption.FOLLOW_LINKS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
    }
}
