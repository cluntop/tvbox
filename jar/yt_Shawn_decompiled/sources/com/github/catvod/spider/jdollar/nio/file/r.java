package com.github.catvod.spider.jdollar.nio.file;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements OpenOption {
    public final /* synthetic */ java.nio.file.OpenOption a;

    public /* synthetic */ r(java.nio.file.OpenOption openOption) {
        this.a = openOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.catvod.spider.jdollar.nio.file.OpenOption, java.nio.file.StandardOpenOption] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.github.catvod.spider.jdollar.nio.file.OpenOption, java.nio.file.LinkOption] */
    public static /* synthetic */ OpenOption a(java.nio.file.OpenOption openOption) {
        if (openOption == 0) {
            return null;
        }
        if (openOption instanceof s) {
            return ((s) openOption).a;
        }
        if (!(openOption instanceof LinkOption)) {
            return openOption instanceof StandardOpenOption ? com.github.catvod.spider.jdollar.com.android.tools.r8.a.m((StandardOpenOption) openOption) : new r(openOption);
        }
        return java.nio.file.LinkOption.NOFOLLOW_LINKS;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.OpenOption openOption = this.a;
        if (obj instanceof r) {
            obj = ((r) obj).a;
        }
        return openOption.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
