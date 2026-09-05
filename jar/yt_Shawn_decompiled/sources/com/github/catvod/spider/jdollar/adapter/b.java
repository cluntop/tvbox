package com.github.catvod.spider.jdollar.adapter;

import android.os.StrictMode;
import com.github.catvod.spider.jdollar.nio.file.spi.c;
import com.github.catvod.spider.jdollar.nio.file.spi.d;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.spi.FileSystemProvider;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b {
    public static final d a;

    static {
        d bVar;
        if (a.b) {
            FileSystemProvider fileSystemProviderProvider = FileSystems.getDefault().provider();
            int i = com.github.catvod.spider.jdollar.nio.file.spi.b.f;
            bVar = fileSystemProviderProvider == null ? null : fileSystemProviderProvider instanceof c ? ((c) fileSystemProviderProvider).a : new com.github.catvod.spider.jdollar.nio.file.spi.b(fileSystemProviderProvider);
        } else {
            if (a.c) {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitDiskReads().build());
            }
            bVar = com.github.catvod.spider.jdollar.desugar.sun.nio.fs.d.a;
        }
        a = bVar;
        bVar.j(URI.create("file:///"));
    }
}
