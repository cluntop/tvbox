package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.nio.file.attribute.GroupPrincipal;
import javax.security.auth.Subject;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements UserPrincipal {
    public final /* synthetic */ java.nio.file.attribute.UserPrincipal a;

    public /* synthetic */ w(java.nio.file.attribute.UserPrincipal userPrincipal) {
        this.a = userPrincipal;
    }

    public static /* synthetic */ UserPrincipal a(java.nio.file.attribute.UserPrincipal userPrincipal) {
        if (userPrincipal == null) {
            return null;
        }
        return userPrincipal instanceof x ? ((x) userPrincipal).a : userPrincipal instanceof GroupPrincipal ? new s((GroupPrincipal) userPrincipal) : new w(userPrincipal);
    }

    @Override // java.security.Principal
    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.attribute.UserPrincipal userPrincipal = this.a;
        if (obj instanceof w) {
            obj = ((w) obj).a;
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
