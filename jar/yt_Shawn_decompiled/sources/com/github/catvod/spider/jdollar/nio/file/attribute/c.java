package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements BasicFileAttributeView {
    public final /* synthetic */ java.nio.file.attribute.BasicFileAttributeView a;

    public /* synthetic */ c(java.nio.file.attribute.BasicFileAttributeView basicFileAttributeView) {
        this.a = basicFileAttributeView;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView
    public final /* synthetic */ void a(FileTime fileTime, FileTime fileTime2, FileTime fileTime3) throws IOException {
        this.a.setTimes(com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(fileTime), com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(fileTime2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(fileTime3));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.attribute.BasicFileAttributeView basicFileAttributeView = this.a;
        if (obj instanceof c) {
            obj = ((c) obj).a;
        }
        return basicFileAttributeView.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.b
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView
    public final /* synthetic */ BasicFileAttributes readAttributes() {
        return e.a(this.a.readAttributes());
    }
}
