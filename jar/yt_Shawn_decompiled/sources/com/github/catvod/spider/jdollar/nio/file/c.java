package com.github.catvod.spider.jdollar.nio.file;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements CopyOption {
    public final /* synthetic */ java.nio.file.CopyOption a;

    public /* synthetic */ c(java.nio.file.CopyOption copyOption) {
        this.a = copyOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.catvod.spider.jdollar.nio.file.CopyOption, java.nio.file.StandardCopyOption] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.catvod.spider.jdollar.nio.file.CopyOption, java.nio.file.StandardCopyOption] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.github.catvod.spider.jdollar.nio.file.CopyOption, java.nio.file.StandardCopyOption] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.github.catvod.spider.jdollar.nio.file.CopyOption, java.nio.file.LinkOption] */
    public static /* synthetic */ CopyOption a(java.nio.file.CopyOption copyOption) {
        if (copyOption == 0) {
            return null;
        }
        if (copyOption instanceof d) {
            return ((d) copyOption).a;
        }
        if (copyOption instanceof LinkOption) {
            return java.nio.file.LinkOption.NOFOLLOW_LINKS;
        }
        if (!(copyOption instanceof StandardCopyOption)) {
            return new c(copyOption);
        }
        StandardCopyOption standardCopyOption = (StandardCopyOption) copyOption;
        return standardCopyOption == StandardCopyOption.REPLACE_EXISTING ? java.nio.file.StandardCopyOption.REPLACE_EXISTING : standardCopyOption == StandardCopyOption.COPY_ATTRIBUTES ? java.nio.file.StandardCopyOption.COPY_ATTRIBUTES : java.nio.file.StandardCopyOption.ATOMIC_MOVE;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.CopyOption copyOption = this.a;
        if (obj instanceof c) {
            obj = ((c) obj).a;
        }
        return copyOption.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
