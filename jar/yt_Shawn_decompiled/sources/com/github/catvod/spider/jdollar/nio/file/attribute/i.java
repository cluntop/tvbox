package com.github.catvod.spider.jdollar.nio.file.attribute;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements FileAttribute {
    public final /* synthetic */ java.nio.file.attribute.FileAttribute a;

    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.attribute.FileAttribute fileAttribute = this.a;
        if (obj instanceof i) {
            obj = ((i) obj).a;
        }
        return fileAttribute.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute
    public final /* synthetic */ Object value() {
        return this.a.value();
    }
}
