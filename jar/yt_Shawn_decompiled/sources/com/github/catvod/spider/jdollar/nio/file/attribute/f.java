package com.github.catvod.spider.jdollar.nio.file.attribute;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements java.nio.file.attribute.BasicFileAttributes {
    public final /* synthetic */ BasicFileAttributes a;

    public /* synthetic */ f(BasicFileAttributes basicFileAttributes) {
        this.a = basicFileAttributes;
    }

    public static /* synthetic */ java.nio.file.attribute.BasicFileAttributes a(BasicFileAttributes basicFileAttributes) {
        if (basicFileAttributes == null) {
            return null;
        }
        return basicFileAttributes instanceof e ? ((e) basicFileAttributes).a : basicFileAttributes instanceof h ? ((h) basicFileAttributes).a : basicFileAttributes instanceof u ? ((u) basicFileAttributes).a : new f(basicFileAttributes);
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ java.nio.file.attribute.FileTime creationTime() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(this.a.creationTime());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BasicFileAttributes basicFileAttributes = this.a;
        if (obj instanceof f) {
            obj = ((f) obj).a;
        }
        return basicFileAttributes.equals(obj);
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ Object fileKey() {
        return this.a.fileKey();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isDirectory() {
        return this.a.isDirectory();
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isOther() {
        return this.a.isOther();
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isRegularFile() {
        return this.a.isRegularFile();
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isSymbolicLink() {
        return this.a.isSymbolicLink();
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ java.nio.file.attribute.FileTime lastAccessTime() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(this.a.lastAccessTime());
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ java.nio.file.attribute.FileTime lastModifiedTime() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(this.a.lastModifiedTime());
    }

    @Override // java.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ long size() {
        return this.a.size();
    }
}
