package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.WatchEvent;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements j0 {
    public final /* synthetic */ WatchEvent.Kind a;

    public final /* synthetic */ boolean equals(Object obj) {
        WatchEvent.Kind kind = this.a;
        if (obj instanceof h0) {
            obj = ((h0) obj).a;
        }
        return kind.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.j0
    public final /* synthetic */ String name() {
        return this.a.name();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.j0
    public final /* synthetic */ Class type() {
        return this.a.type();
    }
}
