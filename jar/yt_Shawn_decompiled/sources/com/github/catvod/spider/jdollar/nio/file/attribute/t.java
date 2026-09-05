package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.io.IOException;
import java.nio.file.attribute.PosixFileAttributeView;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements BasicFileAttributeView, p {
    public final /* synthetic */ PosixFileAttributeView a;

    public /* synthetic */ t(PosixFileAttributeView posixFileAttributeView) {
        this.a = posixFileAttributeView;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView
    public final /* synthetic */ void a(FileTime fileTime, FileTime fileTime2, FileTime fileTime3) throws IOException {
        this.a.setTimes(com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(fileTime), com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(fileTime2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.n(fileTime3));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.p
    public final /* synthetic */ void b(UserPrincipal userPrincipal) throws IOException {
        this.a.setOwner(x.a(userPrincipal));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PosixFileAttributeView posixFileAttributeView = this.a;
        if (obj instanceof t) {
            obj = ((t) obj).a;
        }
        return posixFileAttributeView.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.p
    public final /* synthetic */ UserPrincipal getOwner() {
        return w.a(this.a.getOwner());
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
