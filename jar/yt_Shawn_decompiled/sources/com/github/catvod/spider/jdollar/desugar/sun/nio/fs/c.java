package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileTime;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c implements BasicFileAttributes {
    public final FileTime a;
    public final FileTime b;
    public final FileTime c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final Object i;

    public c(FileTime fileTime, FileTime fileTime2, FileTime fileTime3, boolean z, boolean z2, boolean z3, boolean z4, long j, Object obj) {
        this.a = fileTime;
        this.b = fileTime2;
        this.c = fileTime3;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = j;
        this.i = obj;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final FileTime creationTime() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final Object fileKey() {
        return this.i;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final boolean isDirectory() {
        return this.e;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final boolean isOther() {
        return this.g;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final boolean isRegularFile() {
        return this.d;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final boolean isSymbolicLink() {
        return this.f;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final FileTime lastAccessTime() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final FileTime lastModifiedTime() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes
    public final long size() {
        return this.h;
    }
}
