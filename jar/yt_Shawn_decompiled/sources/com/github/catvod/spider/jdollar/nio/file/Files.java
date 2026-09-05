package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.io.DesugarInputStream;
import com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileTime;
import com.github.catvod.spider.jdollar.nio.file.attribute.PosixFilePermission;
import com.github.catvod.spider.jdollar.nio.file.attribute.UserPrincipal;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Files {
    public static final Set a = com.github.catvod.spider.jdollar.com.android.tools.r8.a.D(new Object[]{StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE});

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(InputStream inputStream, Path path, CopyOption... copyOptionArr) throws IOException {
        Objects.requireNonNull(inputStream);
        int length = copyOptionArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            CopyOption copyOption = copyOptionArr[i];
            if (copyOption != StandardCopyOption.REPLACE_EXISTING) {
                if (copyOption == null) {
                    throw new NullPointerException("options contains 'null'");
                }
                throw new UnsupportedOperationException(copyOption + " not supported");
            }
            i++;
            z = true;
        }
        if (z) {
            try {
                deleteIfExists(path);
                e = null;
            } catch (SecurityException e) {
                e = e;
            }
        } else {
            e = null;
        }
        try {
            OutputStream outputStreamNewOutputStream = newOutputStream(path, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
            try {
                if (inputStream instanceof InputStreamRetargetInterface) {
                    ((InputStreamRetargetInterface) inputStream).transferTo(outputStreamNewOutputStream);
                } else {
                    DesugarInputStream.transferTo(inputStream, outputStreamNewOutputStream);
                }
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                }
            } catch (Throwable th) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileAlreadyExistsException e2) {
            if (e == null) {
                throw e2;
            }
            throw e;
        }
    }

    public static com.github.catvod.spider.jdollar.nio.file.spi.d b(Path path) {
        return path.getFileSystem().E();
    }

    public static Path copy(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        com.github.catvod.spider.jdollar.nio.file.spi.d dVarB = b(path);
        if (b(path2).equals(dVarB)) {
            dVarB.b(path, path2, copyOptionArr);
            return path2;
        }
        com.github.catvod.spider.jdollar.com.android.tools.r8.a.p(path, path2, copyOptionArr);
        return path2;
    }

    public static Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws FileSystemException {
        try {
            try {
                createDirectory(path, fileAttributeArr);
            } catch (IOException unused) {
                try {
                    path = path.toAbsolutePath();
                    e = null;
                } catch (SecurityException e) {
                    e = e;
                }
                Path parent = path.getParent();
                while (parent != null) {
                    try {
                        parent.getFileSystem().E().a(parent, new a[0]);
                        break;
                    } catch (NoSuchFileException unused2) {
                        parent = parent.getParent();
                    }
                }
                if (parent == null) {
                    if (e == null) {
                        throw new FileSystemException(path.toString(), null, "Unable to determine if root directory exists");
                    }
                    throw e;
                }
                Iterator it = parent.relativize(path).iterator();
                while (it.hasNext()) {
                    parent = parent.resolve((Path) it.next());
                    try {
                        createDirectory(parent, fileAttributeArr);
                    } catch (FileAlreadyExistsException e2) {
                        if (!isDirectory(parent, LinkOption.NOFOLLOW_LINKS)) {
                            throw e2;
                        }
                    }
                }
                return path;
            }
        } catch (FileAlreadyExistsException e3) {
            try {
                if (!isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    throw e3;
                }
            } catch (FileAlreadyExistsException e4) {
                throw e4;
            }
        }
        return path;
    }

    public static Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) {
        b(path).c(path, fileAttributeArr);
        return path;
    }

    public static Path createFile(Path path, FileAttribute<?>... fileAttributeArr) {
        b(path).q(path, a, fileAttributeArr).close();
        return path;
    }

    public static Path createLink(Path path, Path path2) {
        b(path).d(path, path2);
        return path;
    }

    public static Path createSymbolicLink(Path path, Path path2, FileAttribute<?>... fileAttributeArr) {
        b(path).e(path, path2, fileAttributeArr);
        return path;
    }

    public static Path createTempDirectory(Path path, String str, FileAttribute<?>... fileAttributeArr) {
        return g0.a((Path) Objects.requireNonNull(path), str, null, true, fileAttributeArr);
    }

    public static Path createTempFile(Path path, String str, String str2, FileAttribute<?>... fileAttributeArr) {
        return g0.a((Path) Objects.requireNonNull(path), str, str2, false, fileAttributeArr);
    }

    public static void delete(Path path) {
        b(path).f(path);
    }

    public static boolean deleteIfExists(Path path) {
        return b(path).g(path);
    }

    public static boolean exists(Path path, LinkOption... linkOptionArr) {
        if (linkOptionArr.length == 0) {
            b(path);
        }
        try {
            int length = linkOptionArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                LinkOption linkOption = linkOptionArr[i];
                if (linkOption != LinkOption.NOFOLLOW_LINKS) {
                    linkOption.getClass();
                    throw new AssertionError("Should not get here");
                }
                i++;
                z = false;
            }
            if (z) {
                b(path).a(path, new a[0]);
            } else {
                readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Object getAttribute(Path path, String str, LinkOption... linkOptionArr) {
        if (str.indexOf(42) >= 0 || str.indexOf(44) >= 0) {
            b.c(str);
            return null;
        }
        Map<String, Object> attributes = readAttributes(path, str, linkOptionArr);
        int iIndexOf = str.indexOf(58);
        if (iIndexOf != -1) {
            str = iIndexOf == str.length() ? VideoStream.RESOLUTION_UNKNOWN : str.substring(iIndexOf + 1);
        }
        return attributes.get(str);
    }

    public static <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> cls, LinkOption... linkOptionArr) {
        return (V) b(path).h(path, cls, linkOptionArr);
    }

    public static FileStore getFileStore(Path path) {
        return b(path).i(path);
    }

    public static FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) {
        return readAttributes(path, BasicFileAttributes.class, linkOptionArr).lastModifiedTime();
    }

    public static UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) {
        com.github.catvod.spider.jdollar.nio.file.attribute.p pVar = (com.github.catvod.spider.jdollar.nio.file.attribute.p) getFileAttributeView(path, com.github.catvod.spider.jdollar.nio.file.attribute.p.class, linkOptionArr);
        if (pVar != null) {
            return pVar.getOwner();
        }
        throw new UnsupportedOperationException();
    }

    public static Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.v(((com.github.catvod.spider.jdollar.nio.file.attribute.u) readAttributes(path, com.github.catvod.spider.jdollar.nio.file.attribute.u.class, linkOptionArr)).a.permissions());
    }

    public static boolean isDirectory(Path path, LinkOption... linkOptionArr) {
        if (linkOptionArr.length == 0) {
            b(path);
        }
        try {
            return readAttributes(path, BasicFileAttributes.class, linkOptionArr).isDirectory();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isExecutable(Path path) {
        try {
            b(path).a(path, a.EXECUTE);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isHidden(Path path) {
        return b(path).m(path);
    }

    public static boolean isReadable(Path path) {
        try {
            b(path).a(path, a.READ);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isRegularFile(Path path, LinkOption... linkOptionArr) {
        if (linkOptionArr.length == 0) {
            b(path);
        }
        try {
            return readAttributes(path, BasicFileAttributes.class, linkOptionArr).isRegularFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isSameFile(Path path, Path path2) {
        return b(path).n(path, path2);
    }

    public static boolean isSymbolicLink(Path path) {
        try {
            return readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS).isSymbolicLink();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isWritable(Path path) {
        try {
            b(path).a(path, a.WRITE);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Path move(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        com.github.catvod.spider.jdollar.nio.file.spi.d dVarB = b(path);
        if (b(path2).equals(dVarB)) {
            dVarB.o(path, path2, copyOptionArr);
            return path2;
        }
        int length = copyOptionArr.length;
        CopyOption[] copyOptionArr2 = new CopyOption[length + 2];
        for (int i = 0; i < length; i++) {
            CopyOption copyOption = copyOptionArr[i];
            if (copyOption == StandardCopyOption.ATOMIC_MOVE) {
                throw new AtomicMoveNotSupportedException(null, null, "Atomic move between providers is not supported");
            }
            copyOptionArr2[i] = copyOption;
        }
        copyOptionArr2[length] = LinkOption.NOFOLLOW_LINKS;
        copyOptionArr2[length + 1] = StandardCopyOption.COPY_ATTRIBUTES;
        com.github.catvod.spider.jdollar.com.android.tools.r8.a.p(path, path2, copyOptionArr2);
        delete(path);
        return path2;
    }

    public static BufferedReader newBufferedReader(Path path, Charset charset) {
        return new BufferedReader(new InputStreamReader(newInputStream(path, new OpenOption[0]), charset.newDecoder()));
    }

    public static DirectoryStream<Path> newDirectoryStream(Path path, String str) {
        if (str.equals("*")) {
            return newDirectoryStream(path);
        }
        FileSystem fileSystem = path.getFileSystem();
        return fileSystem.E().r(path, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(1, fileSystem.k("glob:".concat(str))));
    }

    public static InputStream newInputStream(Path path, OpenOption... openOptionArr) {
        return b(path).v(path, openOptionArr);
    }

    public static OutputStream newOutputStream(Path path, OpenOption... openOptionArr) {
        return b(path).w(path, openOptionArr);
    }

    public static boolean notExists(Path path, LinkOption... linkOptionArr) {
        boolean z;
        try {
            int length = linkOptionArr.length;
            int i = 0;
            z = true;
            while (i < length) {
                LinkOption linkOption = linkOptionArr[i];
                if (linkOption != LinkOption.NOFOLLOW_LINKS) {
                    linkOption.getClass();
                    throw new AssertionError("Should not get here");
                }
                i++;
                z = false;
            }
        } catch (NoSuchFileException unused) {
            return true;
        } catch (IOException unused2) {
        }
        if (z) {
            b(path).a(path, new a[0]);
            return false;
        }
        readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r3 != r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r2 = java.util.Arrays.copyOf(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] readAllBytes(com.github.catvod.spider.jdollar.nio.file.Path r8) {
        /*
            java.util.Set r0 = java.util.Collections.EMPTY_SET
            r1 = 0
            com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute[] r2 = new com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute[r1]
            com.github.catvod.spider.jdollar.nio.file.spi.d r3 = b(r8)
            java.nio.channels.SeekableByteChannel r8 = r3.q(r8, r0, r2)
            java.io.InputStream r0 = java.nio.channels.Channels.newInputStream(r8)     // Catch: java.lang.Throwable -> L68
            long r2 = r8.size()     // Catch: java.lang.Throwable -> L70
            r4 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            java.lang.String r6 = "Required array size too large"
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L6a
            int r3 = (int) r2
            byte[] r2 = new byte[r3]     // Catch: java.lang.Throwable -> L70
        L21:
            int r4 = r3 - r1
            int r4 = r0.read(r2, r1, r4)     // Catch: java.lang.Throwable -> L70
            if (r4 <= 0) goto L2b
            int r1 = r1 + r4
            goto L21
        L2b:
            if (r4 < 0) goto L5a
            int r4 = r0.read()     // Catch: java.lang.Throwable -> L70
            if (r4 >= 0) goto L34
            goto L5a
        L34:
            r5 = 2147483639(0x7ffffff7, float:NaN)
            int r7 = r5 - r3
            if (r3 > r7) goto L44
            int r3 = r3 << 1
            r5 = 8192(0x2000, float:1.148E-41)
            int r3 = java.lang.Math.max(r3, r5)     // Catch: java.lang.Throwable -> L70
            goto L49
        L44:
            if (r3 == r5) goto L54
            r3 = 2147483639(0x7ffffff7, float:NaN)
        L49:
            byte[] r2 = java.util.Arrays.copyOf(r2, r3)     // Catch: java.lang.Throwable -> L70
            int r5 = r1 + 1
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L70
            r2[r1] = r4     // Catch: java.lang.Throwable -> L70
            r1 = r5
            goto L21
        L54:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch: java.lang.Throwable -> L70
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L70
            throw r1     // Catch: java.lang.Throwable -> L70
        L5a:
            if (r3 != r1) goto L5d
            goto L61
        L5d:
            byte[] r2 = java.util.Arrays.copyOf(r2, r1)     // Catch: java.lang.Throwable -> L70
        L61:
            r0.close()     // Catch: java.lang.Throwable -> L68
            r8.close()
            return r2
        L68:
            r0 = move-exception
            goto L7c
        L6a:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch: java.lang.Throwable -> L70
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L70
            throw r1     // Catch: java.lang.Throwable -> L70
        L70:
            r1 = move-exception
            if (r0 == 0) goto L7b
            r0.close()     // Catch: java.lang.Throwable -> L77
            goto L7b
        L77:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L68
        L7b:
            throw r1     // Catch: java.lang.Throwable -> L68
        L7c:
            if (r8 == 0) goto L86
            r8.close()     // Catch: java.lang.Throwable -> L82
            goto L86
        L82:
            r8 = move-exception
            r0.addSuppressed(r8)
        L86:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.nio.file.Files.readAllBytes(com.github.catvod.spider.jdollar.nio.file.Path):byte[]");
    }

    public static List<String> readAllLines(Path path, Charset charset) throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = newBufferedReader(path, charset);
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    bufferedReaderNewBufferedReader.close();
                    return arrayList;
                }
                arrayList.add(line);
            }
        } catch (Throwable th) {
            if (bufferedReaderNewBufferedReader != null) {
                try {
                    bufferedReaderNewBufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) {
        return (A) b(path).x(path, cls, linkOptionArr);
    }

    public static Path readSymbolicLink(Path path) {
        return b(path).z(path);
    }

    public static Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) {
        b(path).A(path, str, obj, linkOptionArr);
        return path;
    }

    public static Path setLastModifiedTime(Path path, FileTime fileTime) {
        ((BasicFileAttributeView) getFileAttributeView(path, BasicFileAttributeView.class, new LinkOption[0])).a((FileTime) Objects.requireNonNull(fileTime), null, null);
        return path;
    }

    public static Path setOwner(Path path, UserPrincipal userPrincipal) {
        com.github.catvod.spider.jdollar.nio.file.attribute.p pVar = (com.github.catvod.spider.jdollar.nio.file.attribute.p) getFileAttributeView(path, com.github.catvod.spider.jdollar.nio.file.attribute.p.class, new LinkOption[0]);
        if (pVar == null) {
            throw new UnsupportedOperationException();
        }
        pVar.b(userPrincipal);
        return path;
    }

    public static Path setPosixFilePermissions(Path path, Set<PosixFilePermission> set) throws IOException {
        com.github.catvod.spider.jdollar.nio.file.attribute.t tVar = (com.github.catvod.spider.jdollar.nio.file.attribute.t) getFileAttributeView(path, com.github.catvod.spider.jdollar.nio.file.attribute.t.class, new LinkOption[0]);
        if (tVar == null) {
            throw new UnsupportedOperationException();
        }
        tVar.a.setPermissions(com.github.catvod.spider.jdollar.com.android.tools.r8.a.v(set));
        return path;
    }

    public static long size(Path path) {
        return readAttributes(path, BasicFileAttributes.class, new LinkOption[0]).size();
    }

    public static Path walkFileTree(Path path, Set<FileVisitOption> set, int i, FileVisitor<? super Path> fileVisitor) {
        FileVisitResult fileVisitResultVisitFile;
        o oVar = new o(i, set);
        try {
            if (oVar.e) {
                throw new IllegalStateException("Closed");
            }
            m mVarN = oVar.n(path, false);
            do {
                int[] iArr = p.a;
                n nVar = (n) mVarN.b;
                BasicFileAttributes basicFileAttributes = (BasicFileAttributes) mVarN.d;
                IOException iOException = (IOException) mVarN.e;
                Path path2 = (Path) mVarN.c;
                int i2 = iArr[nVar.ordinal()];
                if (i2 == 1) {
                    fileVisitResultVisitFile = iOException == null ? fileVisitor.visitFile(path2, basicFileAttributes) : fileVisitor.visitFileFailed(path2, iOException);
                } else if (i2 == 2) {
                    fileVisitResultVisitFile = fileVisitor.preVisitDirectory(path2, basicFileAttributes);
                    if ((fileVisitResultVisitFile == FileVisitResult.SKIP_SUBTREE || fileVisitResultVisitFile == FileVisitResult.SKIP_SIBLINGS) && !oVar.d.isEmpty()) {
                        try {
                            ((l) oVar.d.pop()).c.close();
                        } catch (IOException unused) {
                        }
                    }
                } else {
                    if (i2 != 3) {
                        throw new AssertionError("Should not get here");
                    }
                    fileVisitResultVisitFile = fileVisitor.postVisitDirectory(path2, iOException);
                    if (fileVisitResultVisitFile == FileVisitResult.SKIP_SIBLINGS) {
                        fileVisitResultVisitFile = FileVisitResult.CONTINUE;
                    }
                }
                if (Objects.requireNonNull(fileVisitResultVisitFile) != FileVisitResult.CONTINUE) {
                    if (fileVisitResultVisitFile == FileVisitResult.TERMINATE) {
                        break;
                    }
                    if (fileVisitResultVisitFile == FileVisitResult.SKIP_SIBLINGS && !oVar.d.isEmpty()) {
                        ((l) oVar.d.peek()).e = true;
                    }
                    mVarN = oVar.k();
                } else {
                    mVarN = oVar.k();
                }
            } while (mVarN != null);
            oVar.close();
            return path;
        } catch (Throwable th) {
            try {
                oVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static Path write(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        Objects.requireNonNull(iterable);
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        OutputStream outputStreamNewOutputStream = newOutputStream(path, openOptionArr);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStreamNewOutputStream, charsetEncoderNewEncoder));
            try {
                Iterator<? extends CharSequence> it = iterable.iterator();
                while (it.hasNext()) {
                    bufferedWriter.append(it.next());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                }
                return path;
            } finally {
            }
        } catch (Throwable th) {
            if (outputStreamNewOutputStream != null) {
                try {
                    outputStreamNewOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) {
        return b(path).y(path, str, linkOptionArr);
    }

    public static Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) {
        return g0.a(null, str, str2, false, fileAttributeArr);
    }

    public static Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) {
        return g0.a(null, str, null, true, fileAttributeArr);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path path) {
        return b(path).r(path, q.a);
    }

    public static Path write(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Objects.requireNonNull(bArr);
        OutputStream outputStreamNewOutputStream = newOutputStream(path, openOptionArr);
        try {
            int length = bArr.length;
            int i = length;
            while (i > 0) {
                int iMin = Math.min(i, 8192);
                outputStreamNewOutputStream.write(bArr, length - i, iMin);
                i -= iMin;
            }
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
            return path;
        } catch (Throwable th) {
            if (outputStreamNewOutputStream != null) {
                try {
                    outputStreamNewOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
