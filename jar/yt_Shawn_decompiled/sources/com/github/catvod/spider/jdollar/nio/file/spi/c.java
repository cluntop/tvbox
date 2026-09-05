package com.github.catvod.spider.jdollar.nio.file.spi;

import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.g;
import com.github.catvod.spider.jdollar.nio.file.attribute.l;
import com.github.catvod.spider.jdollar.nio.file.attribute.m;
import com.github.catvod.spider.jdollar.nio.file.attribute.n;
import com.github.catvod.spider.jdollar.nio.file.attribute.o;
import com.github.catvod.spider.jdollar.nio.file.attribute.p;
import com.github.catvod.spider.jdollar.nio.file.attribute.t;
import com.github.catvod.spider.jdollar.nio.file.attribute.v;
import com.github.catvod.spider.jdollar.nio.file.e;
import com.github.catvod.spider.jdollar.nio.file.f;
import com.github.catvod.spider.jdollar.nio.file.h;
import com.github.catvod.spider.jdollar.nio.file.r;
import com.github.catvod.spider.jdollar.nio.file.u;
import com.github.catvod.spider.jdollar.nio.file.x;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c extends FileSystemProvider {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ d a;

    public /* synthetic */ c(d dVar) {
        this.a = dVar;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void checkAccess(Path path, AccessMode[] accessModeArr) {
        d dVar = this.a;
        com.github.catvod.spider.jdollar.nio.file.Path pathH = u.h(path);
        com.github.catvod.spider.jdollar.nio.file.a[] aVarArr = null;
        if (accessModeArr != null) {
            int length = accessModeArr.length;
            com.github.catvod.spider.jdollar.nio.file.a[] aVarArr2 = new com.github.catvod.spider.jdollar.nio.file.a[length];
            for (int i = 0; i < length; i++) {
                AccessMode accessMode = accessModeArr[i];
                aVarArr2[i] = accessMode == null ? null : accessMode == AccessMode.READ ? com.github.catvod.spider.jdollar.nio.file.a.READ : accessMode == AccessMode.WRITE ? com.github.catvod.spider.jdollar.nio.file.a.WRITE : com.github.catvod.spider.jdollar.nio.file.a.EXECUTE;
            }
            aVarArr = aVarArr2;
        }
        dVar.a(pathH, aVarArr);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void copy(Path path, Path path2, CopyOption[] copyOptionArr) {
        com.github.catvod.spider.jdollar.nio.file.CopyOption[] copyOptionArr2;
        d dVar = this.a;
        com.github.catvod.spider.jdollar.nio.file.Path pathH = u.h(path);
        com.github.catvod.spider.jdollar.nio.file.Path pathH2 = u.h(path2);
        if (copyOptionArr == null) {
            copyOptionArr2 = null;
        } else {
            int length = copyOptionArr.length;
            com.github.catvod.spider.jdollar.nio.file.CopyOption[] copyOptionArr3 = new com.github.catvod.spider.jdollar.nio.file.CopyOption[length];
            for (int i = 0; i < length; i++) {
                copyOptionArr3[i] = com.github.catvod.spider.jdollar.nio.file.c.a(copyOptionArr[i]);
            }
            copyOptionArr2 = copyOptionArr3;
        }
        dVar.b(pathH, pathH2, copyOptionArr2);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void createDirectory(Path path, FileAttribute[] fileAttributeArr) {
        this.a.c(u.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.H(fileAttributeArr));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void createLink(Path path, Path path2) {
        this.a.d(u.h(path), u.h(path2));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void createSymbolicLink(Path path, Path path2, FileAttribute[] fileAttributeArr) {
        this.a.e(u.h(path), u.h(path2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.H(fileAttributeArr));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void delete(Path path) {
        this.a.f(u.h(path));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ boolean deleteIfExists(Path path) {
        return this.a.g(u.h(path));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        d dVar = this.a;
        if (obj instanceof c) {
            obj = ((c) obj).a;
        }
        return dVar.equals(obj);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ FileAttributeView getFileAttributeView(Path path, Class cls, LinkOption[] linkOptionArr) {
        com.github.catvod.spider.jdollar.nio.file.attribute.FileAttributeView fileAttributeViewH = this.a.h(u.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.q(cls), com.github.catvod.spider.jdollar.com.android.tools.r8.a.F(linkOptionArr));
        if (fileAttributeViewH == null) {
            return null;
        }
        if (fileAttributeViewH instanceof l) {
            return ((l) fileAttributeViewH).a;
        }
        if (fileAttributeViewH instanceof BasicFileAttributeView) {
            BasicFileAttributeView basicFileAttributeView = (BasicFileAttributeView) fileAttributeViewH;
            return basicFileAttributeView instanceof com.github.catvod.spider.jdollar.nio.file.attribute.c ? ((com.github.catvod.spider.jdollar.nio.file.attribute.c) basicFileAttributeView).a : basicFileAttributeView instanceof g ? ((g) basicFileAttributeView).a : basicFileAttributeView instanceof t ? ((t) basicFileAttributeView).a : new com.github.catvod.spider.jdollar.nio.file.attribute.d(basicFileAttributeView);
        }
        if (!(fileAttributeViewH instanceof p)) {
            return fileAttributeViewH instanceof v ? ((v) fileAttributeViewH).a : new m(fileAttributeViewH);
        }
        p pVar = (p) fileAttributeViewH;
        return pVar instanceof n ? ((n) pVar).a : pVar instanceof com.github.catvod.spider.jdollar.nio.file.attribute.a ? ((com.github.catvod.spider.jdollar.nio.file.attribute.a) pVar).a : pVar instanceof t ? ((t) pVar).a : new o(pVar);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ FileStore getFileStore(Path path) {
        com.github.catvod.spider.jdollar.nio.file.FileStore fileStoreI = this.a.i(u.h(path));
        int i = f.b;
        if (fileStoreI == null) {
            return null;
        }
        return fileStoreI instanceof e ? ((e) fileStoreI).a : new f(fileStoreI);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ FileSystem getFileSystem(URI uri) {
        return h.g(this.a.j(uri));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ Path getPath(URI uri) {
        return com.github.catvod.spider.jdollar.nio.file.v.h(this.a.k(uri));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ String getScheme() {
        return this.a.l();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ boolean isHidden(Path path) {
        return this.a.m(u.h(path));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ boolean isSameFile(Path path, Path path2) {
        return this.a.n(u.h(path), u.h(path2));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void move(Path path, Path path2, CopyOption[] copyOptionArr) {
        com.github.catvod.spider.jdollar.nio.file.CopyOption[] copyOptionArr2;
        d dVar = this.a;
        com.github.catvod.spider.jdollar.nio.file.Path pathH = u.h(path);
        com.github.catvod.spider.jdollar.nio.file.Path pathH2 = u.h(path2);
        if (copyOptionArr == null) {
            copyOptionArr2 = null;
        } else {
            int length = copyOptionArr.length;
            com.github.catvod.spider.jdollar.nio.file.CopyOption[] copyOptionArr3 = new com.github.catvod.spider.jdollar.nio.file.CopyOption[length];
            for (int i = 0; i < length; i++) {
                copyOptionArr3[i] = com.github.catvod.spider.jdollar.nio.file.c.a(copyOptionArr[i]);
            }
            copyOptionArr2 = copyOptionArr3;
        }
        dVar.o(pathH, pathH2, copyOptionArr2);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ AsynchronousFileChannel newAsynchronousFileChannel(Path path, Set set, ExecutorService executorService, FileAttribute[] fileAttributeArr) {
        com.github.catvod.spider.jdollar.nio.channels.a aVarP = this.a.p(u.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(set), executorService, com.github.catvod.spider.jdollar.com.android.tools.r8.a.H(fileAttributeArr));
        int i = com.github.catvod.spider.jdollar.nio.channels.b.a;
        if (aVarP == null) {
            return null;
        }
        return aVarP.a;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ SeekableByteChannel newByteChannel(Path path, Set set, FileAttribute[] fileAttributeArr) {
        return this.a.q(u.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(set), com.github.catvod.spider.jdollar.com.android.tools.r8.a.H(fileAttributeArr));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final DirectoryStream newDirectoryStream(Path path, DirectoryStream.Filter filter) {
        return new x(this.a.r(u.h(path), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(2, filter)));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ FileChannel newFileChannel(Path path, Set set, FileAttribute[] fileAttributeArr) {
        return this.a.s(u.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(set), com.github.catvod.spider.jdollar.com.android.tools.r8.a.H(fileAttributeArr));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ FileSystem newFileSystem(Path path, Map map) {
        return h.g(this.a.t(u.h(path), map));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ InputStream newInputStream(Path path, OpenOption[] openOptionArr) {
        com.github.catvod.spider.jdollar.nio.file.OpenOption[] openOptionArr2;
        d dVar = this.a;
        com.github.catvod.spider.jdollar.nio.file.Path pathH = u.h(path);
        if (openOptionArr == null) {
            openOptionArr2 = null;
        } else {
            int length = openOptionArr.length;
            com.github.catvod.spider.jdollar.nio.file.OpenOption[] openOptionArr3 = new com.github.catvod.spider.jdollar.nio.file.OpenOption[length];
            for (int i = 0; i < length; i++) {
                openOptionArr3[i] = r.a(openOptionArr[i]);
            }
            openOptionArr2 = openOptionArr3;
        }
        return dVar.v(pathH, openOptionArr2);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ OutputStream newOutputStream(Path path, OpenOption[] openOptionArr) {
        com.github.catvod.spider.jdollar.nio.file.OpenOption[] openOptionArr2;
        d dVar = this.a;
        com.github.catvod.spider.jdollar.nio.file.Path pathH = u.h(path);
        if (openOptionArr == null) {
            openOptionArr2 = null;
        } else {
            int length = openOptionArr.length;
            com.github.catvod.spider.jdollar.nio.file.OpenOption[] openOptionArr3 = new com.github.catvod.spider.jdollar.nio.file.OpenOption[length];
            for (int i = 0; i < length; i++) {
                openOptionArr3[i] = r.a(openOptionArr[i]);
            }
            openOptionArr2 = openOptionArr3;
        }
        return dVar.w(pathH, openOptionArr2);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ BasicFileAttributes readAttributes(Path path, Class cls, LinkOption[] linkOptionArr) {
        return com.github.catvod.spider.jdollar.nio.file.attribute.f.a(this.a.x(u.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.r(cls), com.github.catvod.spider.jdollar.com.android.tools.r8.a.F(linkOptionArr)));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ Path readSymbolicLink(Path path) {
        return com.github.catvod.spider.jdollar.nio.file.v.h(this.a.z(u.h(path)));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ void setAttribute(Path path, String str, Object obj, LinkOption[] linkOptionArr) {
        this.a.A(u.h(path), str, com.github.catvod.spider.jdollar.com.android.tools.r8.a.t(obj), com.github.catvod.spider.jdollar.com.android.tools.r8.a.F(linkOptionArr));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ FileSystem newFileSystem(URI uri, Map map) {
        return h.g(this.a.u(uri, map));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final /* synthetic */ Map readAttributes(Path path, String str, LinkOption[] linkOptionArr) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.s(this.a.y(u.h(path), str, com.github.catvod.spider.jdollar.com.android.tools.r8.a.F(linkOptionArr)));
    }
}
