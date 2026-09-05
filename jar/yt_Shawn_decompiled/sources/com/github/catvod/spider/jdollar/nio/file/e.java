package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.attribute.FileStoreAttributeView;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e extends FileStore {
    public final /* synthetic */ java.nio.file.FileStore a;

    public e(java.nio.file.FileStore fileStore) {
        this.a = fileStore;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ Object a(String str) {
        return this.a.getAttribute(str);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ long b() {
        return this.a.getBlockSize();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ com.github.catvod.spider.jdollar.nio.file.attribute.q c(Class cls) {
        FileStoreAttributeView fileStoreAttributeView = this.a.getFileStoreAttributeView(cls);
        if (fileStoreAttributeView == null) {
            return null;
        }
        return new com.github.catvod.spider.jdollar.nio.file.attribute.q(fileStoreAttributeView);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ long d() {
        return this.a.getTotalSpace();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ long e() {
        return this.a.getUnallocatedSpace();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.FileStore fileStore = this.a;
        if (obj instanceof e) {
            obj = ((e) obj).a;
        }
        return fileStore.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ long f() {
        return this.a.getUsableSpace();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ boolean g() {
        return this.a.isReadOnly();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ String h() {
        return this.a.name();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ boolean i(Class cls) {
        return this.a.supportsFileAttributeView(com.github.catvod.spider.jdollar.com.android.tools.r8.a.q(cls));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ boolean j(String str) {
        return this.a.supportsFileAttributeView(str);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileStore
    public final /* synthetic */ String k() {
        return this.a.type();
    }
}
