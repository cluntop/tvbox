package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface FileVisitor<T> {
    FileVisitResult postVisitDirectory(Object obj, IOException iOException);

    FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes);

    FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes);

    FileVisitResult visitFileFailed(Object obj, IOException iOException);
}
