package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.WatchEvent;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class k0 {
    public final /* synthetic */ WatchEvent.Modifier a;

    public final /* synthetic */ boolean equals(Object obj) {
        WatchEvent.Modifier modifier = this.a;
        if (obj instanceof k0) {
            obj = ((k0) obj).a;
        }
        return modifier.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
