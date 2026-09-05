package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.FileSystemLoopException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o implements Closeable {
    public final boolean a;
    public final LinkOption[] b;
    public final int c;
    public final ArrayDeque d = new ArrayDeque();
    public boolean e;

    public o(int i, Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (k.a[((FileVisitOption) it.next()).ordinal()] != 1) {
                throw new AssertionError("Should not get here");
            }
            z = true;
        }
        if (i < 0) {
            b.c("'maxDepth' is negative");
            throw null;
        }
        this.a = z;
        this.b = z ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        this.c = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.e) {
            return;
        }
        while (!this.d.isEmpty()) {
            if (!this.d.isEmpty()) {
                try {
                    ((l) this.d.pop()).c.close();
                } catch (IOException unused) {
                }
            }
        }
        this.e = true;
    }

    public final BasicFileAttributes g(Path path) throws IOException {
        try {
            return Files.readAttributes(path, BasicFileAttributes.class, this.b);
        } catch (IOException e) {
            if (this.a) {
                return Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            }
            throw e;
        }
    }

    public final m k() throws IOException {
        Path path;
        IOException cause;
        m mVarN;
        l lVar = (l) this.d.peek();
        if (lVar == null) {
            return null;
        }
        do {
            if (lVar.e) {
                path = null;
                cause = null;
            } else {
                Iterator it = lVar.d;
                try {
                    path = it.hasNext() ? (Path) it.next() : null;
                    cause = null;
                } catch (DirectoryIteratorException e) {
                    cause = e.getCause();
                    path = null;
                }
            }
            if (path == null) {
                try {
                    lVar.c.close();
                } catch (IOException e2) {
                    if (cause == null) {
                        cause = e2;
                    } else {
                        cause.addSuppressed(e2);
                    }
                }
                this.d.pop();
                return new m(n.END_DIRECTORY, lVar.a, (BasicFileAttributes) null, cause);
            }
            mVarN = n(path, true);
        } while (mVarN == null);
        return mVarN;
    }

    public final m n(Path path, boolean z) {
        try {
            BasicFileAttributes basicFileAttributesG = g(path);
            if (this.d.size() >= this.c || !basicFileAttributesG.isDirectory()) {
                return new m(n.ENTRY, path, basicFileAttributesG, (IOException) null);
            }
            if (this.a) {
                Object objFileKey = basicFileAttributesG.fileKey();
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    Object obj = lVar.b;
                    if (objFileKey == null || obj == null) {
                        if (Files.isSameFile(path, lVar.a)) {
                            return new m(n.ENTRY, path, (BasicFileAttributes) null, new FileSystemLoopException(path.toString()));
                        }
                    } else if (objFileKey.equals(obj)) {
                        return new m(n.ENTRY, path, (BasicFileAttributes) null, new FileSystemLoopException(path.toString()));
                    }
                }
            }
            try {
                this.d.push(new l(path, basicFileAttributesG.fileKey(), Files.newDirectoryStream(path)));
                return new m(n.START_DIRECTORY, path, basicFileAttributesG, (IOException) null);
            } catch (IOException e) {
                return new m(n.ENTRY, path, (BasicFileAttributes) null, e);
            } catch (SecurityException e2) {
                if (!z) {
                    throw e2;
                }
                return null;
            }
        } catch (IOException e3) {
            return new m(n.ENTRY, path, (BasicFileAttributes) null, e3);
        } catch (SecurityException e4) {
            if (!z) {
                throw e4;
            }
        }
    }
}
