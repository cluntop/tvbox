package com.github.catvod.spider.jdollar.nio.file;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class LinkOption implements OpenOption, CopyOption {
    public static final LinkOption NOFOLLOW_LINKS;
    public static final /* synthetic */ LinkOption[] a;

    static {
        LinkOption linkOption = new LinkOption("NOFOLLOW_LINKS", 0);
        NOFOLLOW_LINKS = linkOption;
        a = new LinkOption[]{linkOption};
    }

    public static LinkOption valueOf(String str) {
        return (LinkOption) Enum.valueOf(LinkOption.class, str);
    }

    public static LinkOption[] values() {
        return (LinkOption[]) a.clone();
    }
}
