package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import java.nio.file.DirectoryStream;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j implements DirectoryStream {
    public k a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.nio.file.DirectoryStream, java.lang.Iterable
    public final Iterator iterator() {
        return this.a;
    }
}
