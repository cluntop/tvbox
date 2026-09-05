package com.github.catvod.spider.jdollar.nio.file;

import java.nio.file.DirectoryStream;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l {
    public final Path a;
    public final Object b;
    public final DirectoryStream c;
    public final Iterator d;
    public boolean e;

    public l(Path path, Object obj, DirectoryStream directoryStream) {
        this.a = path;
        this.b = obj;
        this.c = directoryStream;
        this.d = directoryStream.iterator();
    }
}
