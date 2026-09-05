package com.github.catvod.spider.jdollar.nio.file;

import java.io.File;
import java.net.URI;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface Path extends Comparable<Path>, Iterable<Path> {
    l0 I(m0 m0Var, j0... j0VarArr);

    boolean endsWith(String str);

    boolean equals(Object obj);

    l0 g(m0 m0Var, j0[] j0VarArr, k0... k0VarArr);

    Path getFileName();

    FileSystem getFileSystem();

    Path getName(int i);

    int getNameCount();

    Path getParent();

    Path getRoot();

    boolean isAbsolute();

    Iterator iterator();

    /* renamed from: k */
    int compareTo(Path path);

    boolean n(Path path);

    Path normalize();

    Path p(Path path);

    Path relativize(Path path);

    Path resolve(Path path);

    Path resolve(String str);

    Path resolveSibling(String str);

    boolean startsWith(Path path);

    boolean startsWith(String str);

    Path subpath(int i, int i2);

    Path toAbsolutePath();

    File toFile();

    Path toRealPath(LinkOption... linkOptionArr);

    String toString();

    URI toUri();
}
