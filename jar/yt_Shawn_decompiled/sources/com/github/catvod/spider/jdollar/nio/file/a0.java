package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.PathMatcher;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements c0 {
    public final /* synthetic */ PathMatcher a;

    public /* synthetic */ a0(PathMatcher pathMatcher) {
        this.a = pathMatcher;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.c0
    public final /* synthetic */ boolean a(Path path) {
        return this.a.matches(v.h(path));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PathMatcher pathMatcher = this.a;
        if (obj instanceof a0) {
            obj = ((a0) obj).a;
        }
        return pathMatcher.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
