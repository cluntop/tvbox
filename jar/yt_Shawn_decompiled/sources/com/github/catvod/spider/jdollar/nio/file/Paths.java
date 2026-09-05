package com.github.catvod.spider.jdollar.nio.file;

import java.net.URI;
import java.nio.file.FileSystemNotFoundException;
import java.security.AccessController;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Paths {
    public static Path get(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            b.c("Missing scheme");
            return null;
        }
        if (scheme.equalsIgnoreCase("file")) {
            return j.a.E().k(uri);
        }
        if (com.github.catvod.spider.jdollar.nio.file.spi.d.b == null) {
            com.github.catvod.spider.jdollar.nio.file.spi.d dVarE = j.a.E();
            synchronized (com.github.catvod.spider.jdollar.nio.file.spi.d.a) {
                try {
                    if (com.github.catvod.spider.jdollar.nio.file.spi.d.b == null) {
                        if (com.github.catvod.spider.jdollar.nio.file.spi.d.c) {
                            throw new Error("Circular loading of installed providers detected");
                        }
                        com.github.catvod.spider.jdollar.nio.file.spi.d.c = true;
                        List list = (List) AccessController.doPrivileged(new com.github.catvod.spider.jdollar.nio.file.spi.a(0));
                        list.add(0, dVarE);
                        com.github.catvod.spider.jdollar.nio.file.spi.d.b = Collections.unmodifiableList(list);
                    }
                } finally {
                }
            }
        }
        for (com.github.catvod.spider.jdollar.nio.file.spi.d dVar : com.github.catvod.spider.jdollar.nio.file.spi.d.b) {
            if (dVar.l().equalsIgnoreCase(scheme)) {
                return dVar.k(uri);
            }
        }
        throw new FileSystemNotFoundException("Provider \"" + scheme + "\" not installed");
    }

    public static Path get(String str, String... strArr) {
        return j.a.getPath(str, strArr);
    }
}
