package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.PosixFilePermission;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class f0 {
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g a;
    public static final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g b;

    static {
        PosixFilePermission posixFilePermission = PosixFilePermission.OWNER_READ;
        PosixFilePermission posixFilePermission2 = PosixFilePermission.OWNER_WRITE;
        HashSet hashSet = new HashSet(EnumSet.of(posixFilePermission, posixFilePermission2));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((PosixFilePermission) it.next()).getClass();
        }
        a = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(4, hashSet);
        HashSet hashSet2 = new HashSet(EnumSet.of(posixFilePermission, posixFilePermission2, PosixFilePermission.OWNER_EXECUTE));
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            ((PosixFilePermission) it2.next()).getClass();
        }
        b = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(4, hashSet2);
    }
}
