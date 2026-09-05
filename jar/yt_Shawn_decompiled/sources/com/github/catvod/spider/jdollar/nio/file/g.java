package com.github.catvod.spider.jdollar.nio.file;

import java.io.IOException;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g extends FileSystem {
    public final /* synthetic */ java.nio.file.FileSystem a;

    public g(java.nio.file.FileSystem fileSystem) {
        this.a = fileSystem;
    }

    public static /* synthetic */ FileSystem G(java.nio.file.FileSystem fileSystem) {
        if (fileSystem == null) {
            return null;
        }
        return fileSystem instanceof h ? ((h) fileSystem).a : new g(fileSystem);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ boolean C() {
        return this.a.isReadOnly();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ m0 D() {
        return m0.g(this.a.newWatchService());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ com.github.catvod.spider.jdollar.nio.file.spi.d E() {
        FileSystemProvider fileSystemProviderProvider = this.a.provider();
        int i = com.github.catvod.spider.jdollar.nio.file.spi.b.f;
        if (fileSystemProviderProvider == null) {
            return null;
        }
        return fileSystemProviderProvider instanceof com.github.catvod.spider.jdollar.nio.file.spi.c ? ((com.github.catvod.spider.jdollar.nio.file.spi.c) fileSystemProviderProvider).a : new com.github.catvod.spider.jdollar.nio.file.spi.b(fileSystemProviderProvider);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ Set F() {
        return this.a.supportedFileAttributeViews();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() throws IOException {
        this.a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.FileSystem fileSystem = this.a;
        if (obj instanceof g) {
            obj = ((g) obj).a;
        }
        return fileSystem.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ Iterable g() {
        return this.a.getFileStores();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ Path getPath(String str, String[] strArr) {
        return u.h(this.a.getPath(str, strArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ String getSeparator() {
        return this.a.getSeparator();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ c0 k(String str) {
        PathMatcher pathMatcher = this.a.getPathMatcher(str);
        if (pathMatcher == null) {
            return null;
        }
        return pathMatcher instanceof b0 ? ((b0) pathMatcher).a : new a0(pathMatcher);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final Iterable n() {
        return new y(this.a.getRootDirectories());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final /* synthetic */ com.github.catvod.spider.jdollar.nio.file.attribute.y p() {
        UserPrincipalLookupService userPrincipalLookupService = this.a.getUserPrincipalLookupService();
        if (userPrincipalLookupService == null) {
            return null;
        }
        return new com.github.catvod.spider.jdollar.nio.file.attribute.y(userPrincipalLookupService);
    }
}
