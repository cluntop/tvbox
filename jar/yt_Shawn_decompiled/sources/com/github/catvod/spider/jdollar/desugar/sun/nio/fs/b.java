package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileTime;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b implements BasicFileAttributeView {
    public static final Set b;
    public final Path a;

    static {
        String[] strArr = {"size", "creationTime", "lastAccessTime", "lastModifiedTime", "fileKey", "isDirectory", "isRegularFile", "isSymbolicLink", "isOther"};
        Charset charset = p.a;
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 9; i++) {
            hashSet.add(strArr[i]);
        }
        b = hashSet;
    }

    public b(Path path) {
        this.a = path;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView
    public final void a(FileTime fileTime, FileTime fileTime2, FileTime fileTime3) {
        long jConvert;
        if (fileTime == null && fileTime2 == null) {
            return;
        }
        Path path = this.a;
        path.getFileSystem().E().a(path, com.github.catvod.spider.jdollar.nio.file.a.WRITE);
        File file = path.toFile();
        fileTime.getClass();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Objects.requireNonNull(timeUnit, "unit");
        if (timeUnit != null) {
            jConvert = fileTime.a;
        } else {
            jConvert = timeUnit.convert(fileTime.b.getEpochSecond(), TimeUnit.SECONDS);
            if (jConvert != Long.MIN_VALUE && jConvert != Long.MAX_VALUE) {
                long nano = fileTime.b.getNano() / 1000000;
                long j = jConvert + nano;
                jConvert = ((nano ^ j) & (jConvert ^ j)) < 0 ? jConvert < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j;
            }
        }
        if (file.setLastModified(jConvert)) {
            return;
        }
        throw new IOException("File.setLastModified did not succeed on " + path);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.b
    public final String name() {
        return "basic";
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView
    public final BasicFileAttributes readAttributes() {
        boolean z;
        Path path = this.a;
        path.getFileSystem().E().a(path, new com.github.catvod.spider.jdollar.nio.file.a[0]);
        File file = path.toFile();
        long jLastModified = file.lastModified();
        Objects.requireNonNull(TimeUnit.MILLISECONDS, "unit");
        FileTime fileTime = new FileTime(jLastModified);
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        try {
            File file2 = file.getParent() == null ? file : new File(file.getParentFile().getCanonicalFile(), file.getName());
            z = !file2.getCanonicalFile().equals(file2.getAbsoluteFile());
        } catch (IOException unused) {
            z = false;
        }
        return new c(fileTime, fileTime, fileTime, zIsFile, zIsDirectory, z, (zIsFile || zIsDirectory || z) ? false : true, file.length(), Integer.valueOf(file.hashCode()));
    }
}
