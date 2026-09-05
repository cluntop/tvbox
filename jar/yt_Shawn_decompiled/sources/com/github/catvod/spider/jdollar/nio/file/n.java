package com.github.catvod.spider.jdollar.nio.file;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n {
    public static final n END_DIRECTORY;
    public static final n ENTRY;
    public static final n START_DIRECTORY;
    public static final /* synthetic */ n[] a;

    static {
        n nVar = new n("START_DIRECTORY", 0);
        START_DIRECTORY = nVar;
        n nVar2 = new n("END_DIRECTORY", 1);
        END_DIRECTORY = nVar2;
        n nVar3 = new n("ENTRY", 2);
        ENTRY = nVar3;
        a = new n[]{nVar, nVar2, nVar3};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) a.clone();
    }
}
