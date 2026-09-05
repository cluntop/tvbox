package com.github.catvod.spider.jdollar.nio.file;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class FileVisitOption {
    public static final FileVisitOption FOLLOW_LINKS;
    public static final /* synthetic */ FileVisitOption[] a;

    static {
        FileVisitOption fileVisitOption = new FileVisitOption("FOLLOW_LINKS", 0);
        FOLLOW_LINKS = fileVisitOption;
        a = new FileVisitOption[]{fileVisitOption};
    }

    public static FileVisitOption valueOf(String str) {
        return (FileVisitOption) Enum.valueOf(FileVisitOption.class, str);
    }

    public static FileVisitOption[] values() {
        return (FileVisitOption[]) a.clone();
    }
}
