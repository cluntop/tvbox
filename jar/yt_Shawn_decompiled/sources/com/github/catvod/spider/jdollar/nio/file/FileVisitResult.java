package com.github.catvod.spider.jdollar.nio.file;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class FileVisitResult {
    public static final FileVisitResult CONTINUE;
    public static final FileVisitResult SKIP_SIBLINGS;
    public static final FileVisitResult SKIP_SUBTREE;
    public static final FileVisitResult TERMINATE;
    public static final /* synthetic */ FileVisitResult[] a;

    static {
        FileVisitResult fileVisitResult = new FileVisitResult("CONTINUE", 0);
        CONTINUE = fileVisitResult;
        FileVisitResult fileVisitResult2 = new FileVisitResult("TERMINATE", 1);
        TERMINATE = fileVisitResult2;
        FileVisitResult fileVisitResult3 = new FileVisitResult("SKIP_SUBTREE", 2);
        SKIP_SUBTREE = fileVisitResult3;
        FileVisitResult fileVisitResult4 = new FileVisitResult("SKIP_SIBLINGS", 3);
        SKIP_SIBLINGS = fileVisitResult4;
        a = new FileVisitResult[]{fileVisitResult, fileVisitResult2, fileVisitResult3, fileVisitResult4};
    }

    public static FileVisitResult valueOf(String str) {
        return (FileVisitResult) Enum.valueOf(FileVisitResult.class, str);
    }

    public static FileVisitResult[] values() {
        return (FileVisitResult[]) a.clone();
    }
}
