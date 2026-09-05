package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.CopyOption;
import com.github.catvod.spider.jdollar.nio.file.FileStore;
import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.jdollar.nio.file.Files;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.StandardCopyOption;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileTime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l extends com.github.catvod.spider.jdollar.nio.file.spi.d {
    public final String e;
    public final String f = "/";
    public volatile h g;

    public l(String str) {
        this.e = str;
    }

    public static void B(URI uri) {
        if (!uri.getScheme().equalsIgnoreCase("file")) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI does not match this provider");
            return;
        }
        if (uri.getRawAuthority() != null) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Authority component present");
            return;
        }
        String path = uri.getPath();
        if (path == null) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Path component is undefined");
            return;
        }
        if (!path.equals("/")) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Path component should be '/'");
        } else if (uri.getRawQuery() != null) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Query component present");
        } else {
            if (uri.getRawFragment() == null) {
                return;
            }
            com.github.catvod.spider.jdollar.nio.file.b.c("Fragment component present");
        }
    }

    public static boolean C(CopyOption[] copyOptionArr, StandardCopyOption standardCopyOption) {
        for (CopyOption copyOption : copyOptionArr) {
            if (copyOption == standardCopyOption) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void A(Path path, String str, Object obj, LinkOption... linkOptionArr) {
        int iIndexOf = str.indexOf(":");
        if (iIndexOf != -1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!"basic".equals(strSubstring)) {
                com.github.catvod.spider.jdollar.nio.file.b.f("Requested attribute type for: ", strSubstring, " is not available.");
                return;
            }
            str = str.substring(iIndexOf + 1);
        }
        b bVar = new b(path);
        if (str.equals("lastModifiedTime")) {
            bVar.a((FileTime) obj, null, null);
            return;
        }
        if (str.equals("lastAccessTime")) {
            bVar.a(null, (FileTime) obj, null);
        } else {
            if (str.equals("creationTime")) {
                return;
            }
            throw new IllegalArgumentException("'basic:" + str + "' not recognized");
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void a(Path path, com.github.catvod.spider.jdollar.nio.file.a... aVarArr) throws IOException {
        boolean zCanRead;
        File file = path.toFile();
        if (!file.exists()) {
            throw new NoSuchFileException(path.toString());
        }
        boolean z = true;
        for (com.github.catvod.spider.jdollar.nio.file.a aVar : aVarArr) {
            int i = i.a[aVar.ordinal()];
            if (i == 1) {
                zCanRead = file.canRead();
            } else if (i == 2) {
                zCanRead = file.canWrite();
            } else if (i == 3) {
                zCanRead = file.canExecute();
            }
            z &= zCanRead;
        }
        if (!z) {
            throw new IOException(String.format("Unable to access file %s", path));
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void b(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        if (!C(copyOptionArr, StandardCopyOption.REPLACE_EXISTING) && Files.exists(path2, new LinkOption[0])) {
            throw new FileAlreadyExistsException(path2.toString());
        }
        if (C(copyOptionArr, StandardCopyOption.ATOMIC_MOVE)) {
            throw new UnsupportedOperationException("Unsupported copy option");
        }
        FileInputStream fileInputStream = new FileInputStream(path.toFile());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path2.toFile());
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = fileInputStream.read(bArr, 0, 8192);
                    if (i < 0) {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void c(Path path, FileAttribute... fileAttributeArr) throws NoSuchFileException, FileAlreadyExistsException {
        if (path.getParent() != null && !Files.exists(path.getParent(), new LinkOption[0])) {
            throw new NoSuchFileException(path.toString());
        }
        if (!path.toFile().mkdirs()) {
            throw new FileAlreadyExistsException(path.toString());
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void d(Path path, Path path2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void e(Path path, Path path2, FileAttribute... fileAttributeArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void f(Path path) throws NoSuchFileException {
        try {
            a(path, new com.github.catvod.spider.jdollar.nio.file.a[0]);
            g(path);
        } catch (IOException unused) {
            throw new NoSuchFileException(path.toString());
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final boolean g(Path path) {
        return path.toFile().delete();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final FileAttributeView h(Path path, Class cls, LinkOption... linkOptionArr) {
        cls.getClass();
        if (cls == BasicFileAttributeView.class) {
            return (FileAttributeView) cls.cast(new b(path));
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final FileStore i(Path path) {
        throw new SecurityException("getFileStore");
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final FileSystem j(URI uri) {
        h hVar;
        B(uri);
        h hVar2 = this.g;
        if (hVar2 != null) {
            return hVar2;
        }
        synchronized (this) {
            try {
                hVar = this.g;
                if (hVar == null) {
                    hVar = new h(this, this.e, this.f);
                    this.g = hVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final Path k(URI uri) {
        byte bA;
        h hVar = this.g;
        String str = this.e;
        String str2 = this.f;
        char[] cArr = o.c;
        if (!uri.isAbsolute()) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI is not absolute");
            return null;
        }
        if (uri.isOpaque()) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI is not hierarchical");
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("file")) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI scheme is not \"file\"");
            return null;
        }
        if (uri.getRawAuthority() != null) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI has an authority component");
            return null;
        }
        if (uri.getRawFragment() != null) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI has a fragment component");
            return null;
        }
        if (uri.getRawQuery() != null) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI has a query component");
            return null;
        }
        String rawPath = uri.getRawPath();
        int length = rawPath.length();
        if (length == 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("URI path component is empty");
            return null;
        }
        if (rawPath.endsWith("/") && length > 1) {
            length--;
        }
        byte[] bArrCopyOf = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = rawPath.charAt(i);
            if (cCharAt == '%') {
                int i4 = i + 2;
                i += 3;
                bA = (byte) ((o.a(rawPath.charAt(i3)) << 4) | o.a(rawPath.charAt(i4)));
                if (bA == 0) {
                    com.github.catvod.spider.jdollar.nio.file.b.c("Nul character not allowed");
                    return null;
                }
            } else {
                if (cCharAt == 0 || cCharAt >= 128) {
                    com.github.catvod.spider.jdollar.nio.file.b.c("Bad escape");
                    return null;
                }
                bA = (byte) cCharAt;
                i = i3;
            }
            bArrCopyOf[i2] = bA;
            i2++;
        }
        if (i2 != length) {
            bArrCopyOf = Arrays.copyOf(bArrCopyOf, i2);
        }
        return new n(hVar, new String(bArrCopyOf, p.a), str, str2);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final String l() {
        return "file";
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final boolean m(Path path) {
        return path.toFile().isHidden();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final boolean n(Path path, Path path2) throws IOException {
        if (path.equals(path2)) {
            return true;
        }
        a(path, new com.github.catvod.spider.jdollar.nio.file.a[0]);
        a(path2, new com.github.catvod.spider.jdollar.nio.file.a[0]);
        return path.toFile().equals(path2.toFile());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final void o(Path path, Path path2, CopyOption... copyOptionArr) throws FileAlreadyExistsException {
        if (!C(copyOptionArr, StandardCopyOption.REPLACE_EXISTING) && Files.exists(path2, new LinkOption[0])) {
            throw new FileAlreadyExistsException(path2.toString());
        }
        if (C(copyOptionArr, StandardCopyOption.COPY_ATTRIBUTES)) {
            throw new UnsupportedOperationException("Unsupported copy option");
        }
        path.toFile().renameTo(path2.toFile());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final com.github.catvod.spider.jdollar.nio.channels.a p(Path path, Set set, ExecutorService executorService, FileAttribute... fileAttributeArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final SeekableByteChannel q(Path path, Set set, FileAttribute... fileAttributeArr) {
        return s(path, set, fileAttributeArr);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final DirectoryStream r(Path path, DirectoryStream.Filter filter) {
        j jVar = new j();
        jVar.a = new k(this, path, filter);
        return jVar;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final FileChannel s(Path path, Set set, FileAttribute... fileAttributeArr) {
        if (!path.toFile().isDirectory()) {
            return com.github.catvod.spider.jdollar.com.android.tools.r8.a.S(path, set);
        }
        throw new UnsupportedOperationException("The desugar library does not support creating a file channel on a directory: " + path);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final FileSystem u(URI uri, Map map) {
        B(uri);
        throw new FileSystemAlreadyExistsException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final BasicFileAttributes x(Path path, Class cls, LinkOption... linkOptionArr) {
        if (cls == BasicFileAttributes.class) {
            return (BasicFileAttributes) cls.cast(((BasicFileAttributeView) h(path, BasicFileAttributeView.class, linkOptionArr)).readAttributes());
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final Map y(Path path, String str, LinkOption... linkOptionArr) {
        String[] strArrSplit;
        int iIndexOf = str.indexOf(":");
        if (iIndexOf == -1) {
            strArrSplit = str.split(",");
        } else {
            String strSubstring = str.substring(0, iIndexOf);
            if (!"basic".equals(strSubstring)) {
                com.github.catvod.spider.jdollar.nio.file.b.f("Requested attribute type for: ", strSubstring, " is not available.");
                return null;
            }
            strArrSplit = str.substring(iIndexOf + 1).split(",");
        }
        b bVar = new b(path);
        Set set = b.b;
        a aVar = new a();
        aVar.a = new HashSet();
        aVar.b = new HashMap();
        for (String str2 : strArrSplit) {
            if (str2.equals("*")) {
                aVar.c = true;
            } else {
                if (!((HashSet) set).contains(str2)) {
                    throw new IllegalArgumentException("'" + str2 + "' not recognized");
                }
                ((HashSet) aVar.a).add(str2);
            }
        }
        BasicFileAttributes attributes = bVar.readAttributes();
        if (aVar.b("size")) {
            aVar.a(Long.valueOf(((c) attributes).h), "size");
        }
        if (aVar.b("creationTime")) {
            aVar.a(((c) attributes).c, "creationTime");
        }
        if (aVar.b("lastAccessTime")) {
            aVar.a(((c) attributes).b, "lastAccessTime");
        }
        if (aVar.b("lastModifiedTime")) {
            aVar.a(((c) attributes).a, "lastModifiedTime");
        }
        if (aVar.b("fileKey")) {
            aVar.a(((c) attributes).i, "fileKey");
        }
        if (aVar.b("isDirectory")) {
            aVar.a(Boolean.valueOf(((c) attributes).e), "isDirectory");
        }
        if (aVar.b("isRegularFile")) {
            aVar.a(Boolean.valueOf(((c) attributes).d), "isRegularFile");
        }
        if (aVar.b("isSymbolicLink")) {
            aVar.a(Boolean.valueOf(((c) attributes).f), "isSymbolicLink");
        }
        if (aVar.b("isOther")) {
            aVar.a(Boolean.valueOf(((c) attributes).g), "isOther");
        }
        return Collections.unmodifiableMap(aVar.b);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.spi.d
    public final Path z(Path path) {
        return new n(this.g, path.toFile().getCanonicalPath(), this.e, this.f);
    }
}
