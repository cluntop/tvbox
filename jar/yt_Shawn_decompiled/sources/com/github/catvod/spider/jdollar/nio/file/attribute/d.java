package com.github.catvod.spider.jdollar.nio.file.attribute;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements java.nio.file.attribute.BasicFileAttributeView {
    public final /* synthetic */ BasicFileAttributeView a;

    public /* synthetic */ d(BasicFileAttributeView basicFileAttributeView) {
        this.a = basicFileAttributeView;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BasicFileAttributeView basicFileAttributeView = this.a;
        if (obj instanceof d) {
            obj = ((d) obj).a;
        }
        return basicFileAttributeView.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // java.nio.file.attribute.BasicFileAttributeView
    public final /* synthetic */ java.nio.file.attribute.BasicFileAttributes readAttributes() {
        return f.a(this.a.readAttributes());
    }

    @Override // java.nio.file.attribute.BasicFileAttributeView
    public final /* synthetic */ void setTimes(java.nio.file.attribute.FileTime fileTime, java.nio.file.attribute.FileTime fileTime2, java.nio.file.attribute.FileTime fileTime3) {
        this.a.a(com.github.catvod.spider.jdollar.com.android.tools.r8.a.l(fileTime), com.github.catvod.spider.jdollar.com.android.tools.r8.a.l(fileTime2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.l(fileTime3));
    }
}
