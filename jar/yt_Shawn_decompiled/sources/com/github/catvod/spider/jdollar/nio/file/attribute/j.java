package com.github.catvod.spider.jdollar.nio.file.attribute;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements java.nio.file.attribute.FileAttribute {
    public final /* synthetic */ FileAttribute a;

    public final /* synthetic */ boolean equals(Object obj) {
        FileAttribute fileAttribute = this.a;
        if (obj instanceof j) {
            obj = ((j) obj).a;
        }
        return fileAttribute.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.attribute.FileAttribute
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // java.nio.file.attribute.FileAttribute
    public final /* synthetic */ Object value() {
        return this.a.value();
    }
}
