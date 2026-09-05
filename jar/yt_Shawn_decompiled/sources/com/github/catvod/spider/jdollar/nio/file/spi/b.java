package com.github.catvod.spider.jdollar.nio.file.spi;

import com.github.catvod.spider.jdollar.nio.file.CopyOption;
import com.github.catvod.spider.jdollar.nio.file.FileStore;
import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.OpenOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.g;
import com.github.catvod.spider.jdollar.nio.file.attribute.l;
import com.github.catvod.spider.jdollar.nio.file.attribute.m;
import com.github.catvod.spider.jdollar.nio.file.attribute.n;
import com.github.catvod.spider.jdollar.nio.file.attribute.o;
import com.github.catvod.spider.jdollar.nio.file.attribute.t;
import com.github.catvod.spider.jdollar.nio.file.e;
import com.github.catvod.spider.jdollar.nio.file.f;
import com.github.catvod.spider.jdollar.nio.file.s;
import com.github.catvod.spider.jdollar.nio.file.u;
import com.github.catvod.spider.jdollar.nio.file.v;
import com.github.catvod.spider.jdollar.nio.file.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.DirectoryStream;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b extends d {
    public static final /* synthetic */ int f = 0;
    public final /* synthetic */ FileSystemProvider e;

    public /* synthetic */ b(FileSystemProvider fileSystemProvider) {
        this.e = fileSystemProvider;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void A(Path path, String str, Object obj, LinkOption[] linkOptionArr) throws IOException {
        this.e.setAttribute(v.h(path), str, com.github.catvod.spider.jdollar.com.android.tools.r8.a.t(obj), com.github.catvod.spider.jdollar.com.android.tools.r8.a.J(linkOptionArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void a(Path path, com.github.catvod.spider.jdollar.nio.file.a[] aVarArr) throws IOException {
        FileSystemProvider fileSystemProvider = this.e;
        java.nio.file.Path pathH = v.h(path);
        AccessMode[] accessModeArr = null;
        if (aVarArr != null) {
            int length = aVarArr.length;
            AccessMode[] accessModeArr2 = new AccessMode[length];
            for (int i = 0; i < length; i++) {
                com.github.catvod.spider.jdollar.nio.file.a aVar = aVarArr[i];
                accessModeArr2[i] = aVar == null ? null : aVar == com.github.catvod.spider.jdollar.nio.file.a.READ ? AccessMode.READ : aVar == com.github.catvod.spider.jdollar.nio.file.a.WRITE ? AccessMode.WRITE : AccessMode.EXECUTE;
            }
            accessModeArr = accessModeArr2;
        }
        fileSystemProvider.checkAccess(pathH, accessModeArr);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void b(Path path, Path path2, CopyOption[] copyOptionArr) throws IOException {
        this.e.copy(v.h(path), v.h(path2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.I(copyOptionArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void c(Path path, FileAttribute[] fileAttributeArr) throws IOException {
        this.e.createDirectory(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.L(fileAttributeArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void d(Path path, Path path2) throws IOException {
        this.e.createLink(v.h(path), v.h(path2));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void e(Path path, Path path2, FileAttribute[] fileAttributeArr) throws IOException {
        this.e.createSymbolicLink(v.h(path), v.h(path2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.L(fileAttributeArr));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        FileSystemProvider fileSystemProvider = this.e;
        if (obj instanceof b) {
            obj = ((b) obj).e;
        }
        return fileSystemProvider.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void f(Path path) throws IOException {
        this.e.delete(v.h(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ boolean g(Path path) {
        return this.e.deleteIfExists(v.h(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ FileAttributeView h(Path path, Class cls, LinkOption[] linkOptionArr) {
        java.nio.file.attribute.FileAttributeView fileAttributeView = this.e.getFileAttributeView(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.q(cls), com.github.catvod.spider.jdollar.com.android.tools.r8.a.J(linkOptionArr));
        if (fileAttributeView == null) {
            return null;
        }
        if (fileAttributeView instanceof m) {
            return ((m) fileAttributeView).a;
        }
        if (fileAttributeView instanceof BasicFileAttributeView) {
            BasicFileAttributeView basicFileAttributeView = (BasicFileAttributeView) fileAttributeView;
            return basicFileAttributeView instanceof com.github.catvod.spider.jdollar.nio.file.attribute.d ? ((com.github.catvod.spider.jdollar.nio.file.attribute.d) basicFileAttributeView).a : basicFileAttributeView instanceof DosFileAttributeView ? new g((DosFileAttributeView) basicFileAttributeView) : basicFileAttributeView instanceof PosixFileAttributeView ? new t((PosixFileAttributeView) basicFileAttributeView) : new com.github.catvod.spider.jdollar.nio.file.attribute.c(basicFileAttributeView);
        }
        if (!(fileAttributeView instanceof FileOwnerAttributeView)) {
            return fileAttributeView instanceof UserDefinedFileAttributeView ? new com.github.catvod.spider.jdollar.nio.file.attribute.v((UserDefinedFileAttributeView) fileAttributeView) : new l(fileAttributeView);
        }
        FileOwnerAttributeView fileOwnerAttributeView = (FileOwnerAttributeView) fileAttributeView;
        return fileOwnerAttributeView instanceof o ? ((o) fileOwnerAttributeView).a : fileOwnerAttributeView instanceof AclFileAttributeView ? new com.github.catvod.spider.jdollar.nio.file.attribute.a((AclFileAttributeView) fileOwnerAttributeView) : fileOwnerAttributeView instanceof PosixFileAttributeView ? new t((PosixFileAttributeView) fileOwnerAttributeView) : new n(fileOwnerAttributeView);
    }

    public final /* synthetic */ int hashCode() {
        return this.e.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ FileStore i(Path path) throws IOException {
        java.nio.file.FileStore fileStore = this.e.getFileStore(v.h(path));
        if (fileStore == null) {
            return null;
        }
        return fileStore instanceof f ? ((f) fileStore).a : new e(fileStore);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ FileSystem j(URI uri) {
        return com.github.catvod.spider.jdollar.nio.file.g.G(this.e.getFileSystem(uri));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ Path k(URI uri) {
        return u.h(this.e.getPath(uri));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ String l() {
        return this.e.getScheme();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ boolean m(Path path) {
        return this.e.isHidden(v.h(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ boolean n(Path path, Path path2) {
        return this.e.isSameFile(v.h(path), v.h(path2));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ void o(Path path, Path path2, CopyOption[] copyOptionArr) throws IOException {
        this.e.move(v.h(path), v.h(path2), com.github.catvod.spider.jdollar.com.android.tools.r8.a.I(copyOptionArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ com.github.catvod.spider.jdollar.nio.channels.a p(Path path, Set set, ExecutorService executorService, FileAttribute[] fileAttributeArr) throws IOException {
        AsynchronousFileChannel asynchronousFileChannelNewAsynchronousFileChannel = this.e.newAsynchronousFileChannel(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(set), executorService, com.github.catvod.spider.jdollar.com.android.tools.r8.a.L(fileAttributeArr));
        if (asynchronousFileChannelNewAsynchronousFileChannel == null) {
            return null;
        }
        return new com.github.catvod.spider.jdollar.nio.channels.a(asynchronousFileChannelNewAsynchronousFileChannel);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ SeekableByteChannel q(Path path, Set set, FileAttribute[] fileAttributeArr) {
        return this.e.newByteChannel(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(set), com.github.catvod.spider.jdollar.com.android.tools.r8.a.L(fileAttributeArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final DirectoryStream r(Path path, DirectoryStream.Filter filter) {
        return new x(this.e.newDirectoryStream(v.h(path), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(2, filter)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ FileChannel s(Path path, Set set, FileAttribute[] fileAttributeArr) {
        return this.e.newFileChannel(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(set), com.github.catvod.spider.jdollar.com.android.tools.r8.a.L(fileAttributeArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ FileSystem t(Path path, Map map) {
        return com.github.catvod.spider.jdollar.nio.file.g.G(this.e.newFileSystem(v.h(path), (Map<String, ?>) map));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ FileSystem u(URI uri, Map map) {
        return com.github.catvod.spider.jdollar.nio.file.g.G(this.e.newFileSystem(uri, (Map<String, ?>) map));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ InputStream v(Path path, OpenOption[] openOptionArr) {
        java.nio.file.OpenOption[] openOptionArr2;
        FileSystemProvider fileSystemProvider = this.e;
        java.nio.file.Path pathH = v.h(path);
        if (openOptionArr == null) {
            openOptionArr2 = null;
        } else {
            int length = openOptionArr.length;
            java.nio.file.OpenOption[] openOptionArr3 = new java.nio.file.OpenOption[length];
            for (int i = 0; i < length; i++) {
                openOptionArr3[i] = s.a(openOptionArr[i]);
            }
            openOptionArr2 = openOptionArr3;
        }
        return fileSystemProvider.newInputStream(pathH, openOptionArr2);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ OutputStream w(Path path, OpenOption[] openOptionArr) {
        java.nio.file.OpenOption[] openOptionArr2;
        FileSystemProvider fileSystemProvider = this.e;
        java.nio.file.Path pathH = v.h(path);
        if (openOptionArr == null) {
            openOptionArr2 = null;
        } else {
            int length = openOptionArr.length;
            java.nio.file.OpenOption[] openOptionArr3 = new java.nio.file.OpenOption[length];
            for (int i = 0; i < length; i++) {
                openOptionArr3[i] = s.a(openOptionArr[i]);
            }
            openOptionArr2 = openOptionArr3;
        }
        return fileSystemProvider.newOutputStream(pathH, openOptionArr2);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ BasicFileAttributes x(Path path, Class cls, LinkOption[] linkOptionArr) {
        return com.github.catvod.spider.jdollar.nio.file.attribute.e.a(this.e.readAttributes(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.r(cls), com.github.catvod.spider.jdollar.com.android.tools.r8.a.J(linkOptionArr)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ Map y(Path path, String str, LinkOption[] linkOptionArr) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.s(this.e.readAttributes(v.h(path), str, com.github.catvod.spider.jdollar.com.android.tools.r8.a.J(linkOptionArr)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final /* synthetic */ Path z(Path path) {
        return u.h(this.e.readSymbolicLink(v.h(path)));
    }
}
