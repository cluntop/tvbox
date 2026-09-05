package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.nio.file.attribute.FileOwnerAttributeView;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements FileOwnerAttributeView {
    public final /* synthetic */ p a;

    public final /* synthetic */ boolean equals(Object obj) {
        p pVar = this.a;
        if (obj instanceof o) {
            obj = ((o) obj).a;
        }
        return pVar.equals(obj);
    }

    @Override // java.nio.file.attribute.FileOwnerAttributeView
    public final /* synthetic */ java.nio.file.attribute.UserPrincipal getOwner() {
        return x.a(this.a.getOwner());
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.attribute.FileOwnerAttributeView, java.nio.file.attribute.AttributeView
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // java.nio.file.attribute.FileOwnerAttributeView
    public final /* synthetic */ void setOwner(java.nio.file.attribute.UserPrincipal userPrincipal) {
        this.a.b(w.a(userPrincipal));
    }
}
