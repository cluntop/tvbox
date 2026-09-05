package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class h extends java.nio.file.FileSystem {
    public final /* synthetic */ FileSystem a;

    public /* synthetic */ h(FileSystem fileSystem) {
        this.a = fileSystem;
    }

    public static /* synthetic */ java.nio.file.FileSystem g(FileSystem fileSystem) {
        if (fileSystem == null) {
            return null;
        }
        return fileSystem instanceof g ? ((g) fileSystem).a : new h(fileSystem);
    }

    @Override // java.nio.file.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        FileSystem fileSystem = this.a;
        if (obj instanceof h) {
            obj = ((h) obj).a;
        }
        return fileSystem.equals(obj);
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ Iterable getFileStores() {
        return this.a.g();
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ java.nio.file.Path getPath(String str, String[] strArr) {
        return v.h(this.a.getPath(str, strArr));
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ PathMatcher getPathMatcher(String str) {
        c0 c0VarK = this.a.k(str);
        if (c0VarK == null) {
            return null;
        }
        return c0VarK instanceof a0 ? ((a0) c0VarK).a : new b0(c0VarK);
    }

    @Override // java.nio.file.FileSystem
    public final Iterable getRootDirectories() {
        return new y(this.a.n());
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ String getSeparator() {
        return this.a.getSeparator();
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ UserPrincipalLookupService getUserPrincipalLookupService() {
        com.github.catvod.spider.jdollar.nio.file.attribute.y yVarP = this.a.p();
        int i = com.github.catvod.spider.jdollar.nio.file.attribute.z.a;
        if (yVarP == null) {
            return null;
        }
        return yVarP.a;
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ boolean isReadOnly() {
        return this.a.C();
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ WatchService newWatchService() {
        m0 m0VarD = this.a.D();
        if (m0VarD == null) {
            return null;
        }
        return m0VarD.a;
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ FileSystemProvider provider() {
        com.github.catvod.spider.jdollar.nio.file.spi.d dVarE = this.a.E();
        int i = com.github.catvod.spider.jdollar.nio.file.spi.c.b;
        if (dVarE == null) {
            return null;
        }
        return dVarE instanceof com.github.catvod.spider.jdollar.nio.file.spi.b ? ((com.github.catvod.spider.jdollar.nio.file.spi.b) dVarE).e : new com.github.catvod.spider.jdollar.nio.file.spi.c(dVarE);
    }

    @Override // java.nio.file.FileSystem
    public final /* synthetic */ Set supportedFileAttributeViews() {
        return this.a.F();
    }
}
