package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.jdollar.nio.file.Files;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.StandardCopyOption;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileTime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class e0 extends c0 {
    public static Long A(FileTime fileTime) {
        long millis = fileTime.toMillis();
        Long lValueOf = Long.valueOf(millis);
        if (millis != 0) {
            return lValueOf;
        }
        return null;
    }

    public static q z(Path path) {
        g0 g0VarG;
        path.getClass();
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            if (symbolicLink != null) {
                String str = g0.b;
                g0VarG = com.github.catvod.spider.merge.h0.f.g(symbolicLink);
            } else {
                g0VarG = null;
            }
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lA = fileTimeCreationTime != null ? A(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lA2 = fileTimeLastModifiedTime != null ? A(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new q(zIsRegularFile, zIsDirectory, g0VarG, lValueOf, lA, lA2, fileTimeLastAccessTime != null ? A(fileTimeLastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public void atomicMove(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        try {
            Files.move(g0Var.e(), g0Var2.e(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            com.github.catvod.spider.merge.s0.a.w("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public void createSymlink(g0 g0Var, g0 g0Var2) {
        g0Var.getClass();
        g0Var2.getClass();
        Files.createSymbolicLink(g0Var.e(), g0Var2.e(), new FileAttribute[0]);
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public q metadataOrNull(g0 g0Var) {
        g0Var.getClass();
        return z(g0Var.e());
    }

    @Override // com.github.catvod.spider.merge.y0.c0
    public String toString() {
        return "NioSystemFileSystem";
    }
}
