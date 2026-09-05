package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.io.IOException;
import java.nio.file.attribute.AclFileAttributeView;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p {
    public final /* synthetic */ AclFileAttributeView a;

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.p
    public final /* synthetic */ void b(UserPrincipal userPrincipal) throws IOException {
        this.a.setOwner(x.a(userPrincipal));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        AclFileAttributeView aclFileAttributeView = this.a;
        if (obj instanceof a) {
            obj = ((a) obj).a;
        }
        return aclFileAttributeView.equals(obj);
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
}
