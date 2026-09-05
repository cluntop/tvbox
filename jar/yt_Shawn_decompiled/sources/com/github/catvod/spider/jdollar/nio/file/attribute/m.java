package com.github.catvod.spider.jdollar.nio.file.attribute;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements java.nio.file.attribute.FileAttributeView {
    public final /* synthetic */ FileAttributeView a;

    public final /* synthetic */ boolean equals(Object obj) {
        FileAttributeView fileAttributeView = this.a;
        if (obj instanceof m) {
            obj = ((m) obj).a;
        }
        return fileAttributeView.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.attribute.AttributeView
    public final /* synthetic */ String name() {
        return this.a.name();
    }
}
