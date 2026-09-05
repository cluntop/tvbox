package com.github.catvod.spider.jdollar.nio.file;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public static final a EXECUTE;
    public static final a READ;
    public static final a WRITE;
    public static final /* synthetic */ a[] a;

    static {
        a aVar = new a("READ", 0);
        READ = aVar;
        a aVar2 = new a("WRITE", 1);
        WRITE = aVar2;
        a aVar3 = new a("EXECUTE", 2);
        EXECUTE = aVar3;
        a = new a[]{aVar, aVar2, aVar3};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) a.clone();
    }
}
