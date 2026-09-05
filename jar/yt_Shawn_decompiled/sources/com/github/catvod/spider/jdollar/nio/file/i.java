package com.github.catvod.spider.jdollar.nio.file;

import java.security.PrivilegedAction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i implements PrivilegedAction {
    @Override // java.security.PrivilegedAction
    public final Object run() {
        com.github.catvod.spider.jdollar.nio.file.spi.d dVar = com.github.catvod.spider.jdollar.adapter.b.a;
        String property = System.getProperty("java.nio.file.spi.DefaultFileSystemProvider");
        if (property != null) {
            for (String str : property.split(",")) {
                try {
                    dVar = (com.github.catvod.spider.jdollar.nio.file.spi.d) Class.forName(str, true, ClassLoader.getSystemClassLoader()).getDeclaredConstructor(com.github.catvod.spider.jdollar.nio.file.spi.d.class).newInstance(dVar);
                    if (!dVar.l().equals("file")) {
                        throw new Error("Default provider must use scheme 'file'");
                    }
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
        }
        return dVar;
    }
}
