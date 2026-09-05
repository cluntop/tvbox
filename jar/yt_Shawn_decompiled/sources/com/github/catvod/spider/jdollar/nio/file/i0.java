package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.WatchEvent;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements WatchEvent.Kind {
    public final /* synthetic */ j0 a;

    public final /* synthetic */ boolean equals(Object obj) {
        j0 j0Var = this.a;
        if (obj instanceof i0) {
            obj = ((i0) obj).a;
        }
        return j0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.WatchEvent.Kind
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // java.nio.file.WatchEvent.Kind
    public final /* synthetic */ Class type() {
        return this.a.type();
    }
}
