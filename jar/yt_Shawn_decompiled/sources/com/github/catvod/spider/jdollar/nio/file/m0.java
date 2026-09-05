package com.github.catvod.spider.jdollar.nio.file;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.WatchService;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class m0 implements Closeable {
    public final /* synthetic */ WatchService a;

    public /* synthetic */ m0(WatchService watchService) {
        this.a = watchService;
    }

    public static /* synthetic */ m0 g(WatchService watchService) {
        if (watchService == null) {
            return null;
        }
        return new m0(watchService);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() throws IOException {
        this.a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        WatchService watchService = this.a;
        if (obj instanceof m0) {
            obj = ((m0) obj).a;
        }
        return watchService.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
