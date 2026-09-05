package com.github.catvod.spider.jdollar.nio.file;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements java.nio.file.OpenOption {
    public final /* synthetic */ OpenOption a;

    public /* synthetic */ s(OpenOption openOption) {
        this.a = openOption;
    }

    public static /* synthetic */ java.nio.file.OpenOption a(OpenOption openOption) {
        if (openOption == null) {
            return null;
        }
        return openOption instanceof r ? ((r) openOption).a : openOption instanceof LinkOption ? java.nio.file.LinkOption.NOFOLLOW_LINKS : openOption instanceof StandardOpenOption ? com.github.catvod.spider.jdollar.com.android.tools.r8.a.m((StandardOpenOption) openOption) : new s(openOption);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        OpenOption openOption = this.a;
        if (obj instanceof s) {
            obj = ((s) obj).a;
        }
        return openOption.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
