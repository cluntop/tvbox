package com.github.catvod.spider.jdollar.nio.file.attribute;

import javax.security.auth.Subject;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements java.nio.file.attribute.UserPrincipal {
    public final /* synthetic */ UserPrincipal a;

    public /* synthetic */ x(UserPrincipal userPrincipal) {
        this.a = userPrincipal;
    }

    public static /* synthetic */ java.nio.file.attribute.UserPrincipal a(UserPrincipal userPrincipal) {
        if (userPrincipal == null) {
            return null;
        }
        return userPrincipal instanceof w ? ((w) userPrincipal).a : userPrincipal instanceof s ? ((s) userPrincipal).a : new x(userPrincipal);
    }

    @Override // java.security.Principal
    public final /* synthetic */ boolean equals(Object obj) {
        UserPrincipal userPrincipal = this.a;
        if (obj instanceof x) {
            obj = ((x) obj).a;
        }
        return userPrincipal.equals(obj);
    }

    @Override // java.security.Principal
    public final /* synthetic */ String getName() {
        return this.a.getName();
    }

    @Override // java.security.Principal
    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.security.Principal
    public final /* synthetic */ boolean implies(Subject subject) {
        return this.a.implies(subject);
    }

    @Override // java.security.Principal
    public final /* synthetic */ String toString() {
        return this.a.toString();
    }
}
