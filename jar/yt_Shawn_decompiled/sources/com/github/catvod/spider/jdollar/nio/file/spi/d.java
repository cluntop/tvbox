package com.github.catvod.spider.jdollar.nio.file.spi;

import com.github.catvod.spider.jdollar.nio.file.CopyOption;
import com.github.catvod.spider.jdollar.nio.file.FileStore;
import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.jdollar.nio.file.Files;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.OpenOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.StandardOpenOption;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttributeView;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.DirectoryStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d {
    public static volatile List b;
    public static boolean c;
    public static final Object a = new Object();
    public static final Set d = com.github.catvod.spider.jdollar.com.android.tools.r8.a.D(new Object[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE});

    public d() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("fileSystemProvider"));
        }
    }

    public abstract void A(Path path, String str, Object obj, LinkOption... linkOptionArr);

    public abstract void a(Path path, com.github.catvod.spider.jdollar.nio.file.a... aVarArr);

    public abstract void b(Path path, Path path2, CopyOption... copyOptionArr);

    public abstract void c(Path path, FileAttribute... fileAttributeArr);

    public abstract void d(Path path, Path path2);

    public abstract void e(Path path, Path path2, FileAttribute... fileAttributeArr);

    public abstract void f(Path path);

    public abstract boolean g(Path path);

    public abstract FileAttributeView h(Path path, Class cls, LinkOption... linkOptionArr);

    public abstract FileStore i(Path path);

    public abstract FileSystem j(URI uri);

    public abstract Path k(URI uri);

    public abstract String l();

    public abstract boolean m(Path path);

    public abstract boolean n(Path path, Path path2);

    public abstract void o(Path path, Path path2, CopyOption... copyOptionArr);

    public abstract com.github.catvod.spider.jdollar.nio.channels.a p(Path path, Set set, ExecutorService executorService, FileAttribute... fileAttributeArr);

    public abstract SeekableByteChannel q(Path path, Set set, FileAttribute... fileAttributeArr);

    public abstract DirectoryStream r(Path path, DirectoryStream.Filter filter);

    public abstract FileChannel s(Path path, Set set, FileAttribute... fileAttributeArr);

    public FileSystem t(Path path, Map map) {
        throw new UnsupportedOperationException();
    }

    public abstract FileSystem u(URI uri, Map map);

    public InputStream v(Path path, OpenOption... openOptionArr) {
        Set set;
        if (openOptionArr.length > 0) {
            for (OpenOption openOption : openOptionArr) {
                if (openOption == StandardOpenOption.APPEND || openOption == StandardOpenOption.WRITE) {
                    com.github.catvod.spider.jdollar.nio.file.b.f("'", openOption, "' not allowed");
                    return null;
                }
            }
        }
        Set set2 = Files.a;
        if (openOptionArr.length == 0) {
            set = Collections.EMPTY_SET;
        } else {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, openOptionArr);
            set = hashSet;
        }
        return Channels.newInputStream(Files.b(path).q(path, set, new FileAttribute[0]));
    }

    public OutputStream w(Path path, OpenOption... openOptionArr) {
        Set set;
        if (openOptionArr.length == 0) {
            set = d;
        } else {
            HashSet hashSet = new HashSet();
            for (OpenOption openOption : openOptionArr) {
                if (openOption == StandardOpenOption.READ) {
                    com.github.catvod.spider.jdollar.nio.file.b.c("READ not allowed");
                    return null;
                }
                hashSet.add(openOption);
            }
            hashSet.add(StandardOpenOption.WRITE);
            set = hashSet;
        }
        return Channels.newOutputStream(q(path, set, new FileAttribute[0]));
    }

    public abstract BasicFileAttributes x(Path path, Class cls, LinkOption... linkOptionArr);

    public abstract Map y(Path path, String str, LinkOption... linkOptionArr);

    public abstract Path z(Path path);
}
