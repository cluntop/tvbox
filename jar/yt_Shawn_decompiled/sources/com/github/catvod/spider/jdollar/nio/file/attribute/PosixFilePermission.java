package com.github.catvod.spider.jdollar.nio.file.attribute;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PosixFilePermission {
    public static final PosixFilePermission GROUP_EXECUTE;
    public static final PosixFilePermission GROUP_READ;
    public static final PosixFilePermission GROUP_WRITE;
    public static final PosixFilePermission OTHERS_EXECUTE;
    public static final PosixFilePermission OTHERS_READ;
    public static final PosixFilePermission OTHERS_WRITE;
    public static final PosixFilePermission OWNER_EXECUTE;
    public static final PosixFilePermission OWNER_READ;
    public static final PosixFilePermission OWNER_WRITE;
    public static final /* synthetic */ PosixFilePermission[] a;

    static {
        PosixFilePermission posixFilePermission = new PosixFilePermission("OWNER_READ", 0);
        OWNER_READ = posixFilePermission;
        PosixFilePermission posixFilePermission2 = new PosixFilePermission("OWNER_WRITE", 1);
        OWNER_WRITE = posixFilePermission2;
        PosixFilePermission posixFilePermission3 = new PosixFilePermission("OWNER_EXECUTE", 2);
        OWNER_EXECUTE = posixFilePermission3;
        PosixFilePermission posixFilePermission4 = new PosixFilePermission("GROUP_READ", 3);
        GROUP_READ = posixFilePermission4;
        PosixFilePermission posixFilePermission5 = new PosixFilePermission("GROUP_WRITE", 4);
        GROUP_WRITE = posixFilePermission5;
        PosixFilePermission posixFilePermission6 = new PosixFilePermission("GROUP_EXECUTE", 5);
        GROUP_EXECUTE = posixFilePermission6;
        PosixFilePermission posixFilePermission7 = new PosixFilePermission("OTHERS_READ", 6);
        OTHERS_READ = posixFilePermission7;
        PosixFilePermission posixFilePermission8 = new PosixFilePermission("OTHERS_WRITE", 7);
        OTHERS_WRITE = posixFilePermission8;
        PosixFilePermission posixFilePermission9 = new PosixFilePermission("OTHERS_EXECUTE", 8);
        OTHERS_EXECUTE = posixFilePermission9;
        a = new PosixFilePermission[]{posixFilePermission, posixFilePermission2, posixFilePermission3, posixFilePermission4, posixFilePermission5, posixFilePermission6, posixFilePermission7, posixFilePermission8, posixFilePermission9};
    }

    public static PosixFilePermission valueOf(String str) {
        return (PosixFilePermission) Enum.valueOf(PosixFilePermission.class, str);
    }

    public static PosixFilePermission[] values() {
        return (PosixFilePermission[]) a.clone();
    }
}
