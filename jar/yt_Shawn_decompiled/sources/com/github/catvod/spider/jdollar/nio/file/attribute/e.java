package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements BasicFileAttributes {
    public final /* synthetic */ java.nio.file.attribute.BasicFileAttributes a;

    public /* synthetic */ e(java.nio.file.attribute.BasicFileAttributes basicFileAttributes) {
        this.a = basicFileAttributes;
    }

    public static /* synthetic */ BasicFileAttributes a(java.nio.file.attribute.BasicFileAttributes basicFileAttributes) {
        if (basicFileAttributes == null) {
            return null;
        }
        return basicFileAttributes instanceof f ? ((f) basicFileAttributes).a : basicFileAttributes instanceof DosFileAttributes ? new h((DosFileAttributes) basicFileAttributes) : basicFileAttributes instanceof PosixFileAttributes ? new u((PosixFileAttributes) basicFileAttributes) : new e(basicFileAttributes);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ FileTime creationTime() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.l(this.a.creationTime());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.attribute.BasicFileAttributes basicFileAttributes = this.a;
        if (obj instanceof e) {
            obj = ((e) obj).a;
        }
        return basicFileAttributes.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ Object fileKey() {
        return this.a.fileKey();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isDirectory() {
        return this.a.isDirectory();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isOther() {
        return this.a.isOther();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isRegularFile() {
        return this.a.isRegularFile();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ boolean isSymbolicLink() {
        return this.a.isSymbolicLink();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ FileTime lastAccessTime() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.l(this.a.lastAccessTime());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ FileTime lastModifiedTime() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.l(this.a.lastModifiedTime());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final /* synthetic */ long size() {
        return this.a.size();
    }
}
