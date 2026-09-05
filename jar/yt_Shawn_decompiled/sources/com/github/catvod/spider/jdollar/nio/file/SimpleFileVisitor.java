package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SimpleFileVisitor<T> implements FileVisitor<T> {
    @Override // com.github.catvod.spider.jdollar.nio.file.FileVisitor
    public FileVisitResult postVisitDirectory(T t, IOException iOException) throws IOException {
        Objects.requireNonNull(t);
        if (iOException == null) {
            return FileVisitResult.CONTINUE;
        }
        throw iOException;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileVisitor
    public FileVisitResult preVisitDirectory(T t, BasicFileAttributes basicFileAttributes) {
        Objects.requireNonNull(t);
        Objects.requireNonNull(basicFileAttributes);
        return FileVisitResult.CONTINUE;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileVisitor
    public FileVisitResult visitFile(T t, BasicFileAttributes basicFileAttributes) {
        Objects.requireNonNull(t);
        Objects.requireNonNull(basicFileAttributes);
        return FileVisitResult.CONTINUE;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileVisitor
    public FileVisitResult visitFileFailed(T t, IOException iOException) throws IOException {
        Objects.requireNonNull(t);
        throw iOException;
    }
}
