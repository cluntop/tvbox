package com.github.catvod.spider.jdollar.nio.file;

import java.io.Closeable;
import java.util.Set;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class FileSystem implements Closeable {
    public abstract boolean C();

    public abstract m0 D();

    public abstract com.github.catvod.spider.jdollar.nio.file.spi.d E();

    public abstract Set F();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract Iterable g();

    public abstract Path getPath(String str, String... strArr);

    public abstract String getSeparator();

    public abstract boolean isOpen();

    public abstract c0 k(String str);

    public abstract Iterable n();

    public abstract com.github.catvod.spider.jdollar.nio.file.attribute.y p();
}
