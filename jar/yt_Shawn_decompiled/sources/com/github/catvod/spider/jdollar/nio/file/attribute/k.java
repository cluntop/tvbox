package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k implements java.nio.file.attribute.FileAttribute {
    public final /* synthetic */ FileAttribute a;

    public k(FileAttribute fileAttribute) {
        this.a = fileAttribute;
    }

    @Override // java.nio.file.attribute.FileAttribute
    public final String name() {
        return "posix:permissions";
    }

    @Override // java.nio.file.attribute.FileAttribute
    public final Object value() {
        return Collections.unmodifiableSet(com.github.catvod.spider.jdollar.com.android.tools.r8.a.v((Set) this.a.value()));
    }
}
