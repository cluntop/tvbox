package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.WatchKey;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class l0 {
    public final /* synthetic */ WatchKey a;

    public /* synthetic */ l0(WatchKey watchKey) {
        this.a = watchKey;
    }

    public static /* synthetic */ l0 a(WatchKey watchKey) {
        if (watchKey == null) {
            return null;
        }
        return new l0(watchKey);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        WatchKey watchKey = this.a;
        if (obj instanceof l0) {
            obj = ((l0) obj).a;
        }
        return watchKey.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
