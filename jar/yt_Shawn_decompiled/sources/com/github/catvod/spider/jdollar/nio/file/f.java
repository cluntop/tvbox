package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.attribute.FileStoreAttributeView;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class f extends java.nio.file.FileStore {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ FileStore a;

    public /* synthetic */ f(FileStore fileStore) {
        this.a = fileStore;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        FileStore fileStore = this.a;
        if (obj instanceof f) {
            obj = ((f) obj).a;
        }
        return fileStore.equals(obj);
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ Object getAttribute(String str) {
        return this.a.a(str);
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ long getBlockSize() {
        return this.a.b();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ FileStoreAttributeView getFileStoreAttributeView(Class cls) {
        com.github.catvod.spider.jdollar.nio.file.attribute.q qVarC = this.a.c(cls);
        if (qVarC == null) {
            return null;
        }
        return qVarC.a;
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ long getTotalSpace() {
        return this.a.d();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ long getUnallocatedSpace() {
        return this.a.e();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ long getUsableSpace() {
        return this.a.f();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ boolean isReadOnly() {
        return this.a.g();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ String name() {
        return this.a.h();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ boolean supportsFileAttributeView(Class cls) {
        return this.a.i(com.github.catvod.spider.jdollar.com.android.tools.r8.a.q(cls));
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ String type() {
        return this.a.k();
    }

    @Override // java.nio.file.FileStore
    public final /* synthetic */ boolean supportsFileAttributeView(String str) {
        return this.a.j(str);
    }
}
