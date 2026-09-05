package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.PathMatcher;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements PathMatcher {
    public final /* synthetic */ c0 a;

    public /* synthetic */ b0(c0 c0Var) {
        this.a = c0Var;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        c0 c0Var = this.a;
        if (obj instanceof b0) {
            obj = ((b0) obj).a;
        }
        return c0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.PathMatcher
    public final /* synthetic */ boolean matches(java.nio.file.Path path) {
        return this.a.a(u.h(path));
    }
}
