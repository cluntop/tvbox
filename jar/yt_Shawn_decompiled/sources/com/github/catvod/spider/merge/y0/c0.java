package com.github.catvod.spider.merge.y0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class c0 extends s {
    public static ArrayList j(g0 g0Var, boolean z) throws IOException {
        File file = g0Var.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z) {
                return null;
            }
            if (!file.exists()) {
                throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
            }
            com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.t0.a.e(g0Var, "failed to list "));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.getClass();
            arrayList.add(g0Var.d(str));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p0 appendingSink(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        if (!z || exists(g0Var)) {
            return new d(new FileOutputStream(g0Var.toFile(), true), new u0());
        }
        com.github.catvod.spider.merge.s0.a.g(g0Var, " doesn't exist.");
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void atomicMove(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        if (g0Var.toFile().renameTo(g0Var2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + g0Var + " to " + g0Var2);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public g0 canonicalize(g0 g0Var) throws IOException {
        g0Var.getClass();
        File canonicalFile = g0Var.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        String str = g0.b;
        return com.github.catvod.spider.merge.h0.f.f(canonicalFile);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void createDirectory(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        if (g0Var.toFile().mkdir()) {
            return;
        }
        q qVarMetadataOrNull = metadataOrNull(g0Var);
        if (qVarMetadataOrNull == null || !qVarMetadataOrNull.b) {
            com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.t0.a.e(g0Var, "failed to create directory: "));
        } else if (z) {
            com.github.catvod.spider.merge.s0.a.g(g0Var, " already exists.");
        }
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void createSymlink(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        throw new IOException("unsupported");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void delete(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = g0Var.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.t0.a.e(g0Var, "failed to delete "));
        } else if (z) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public List list(g0 g0Var) throws IOException {
        g0Var.getClass();
        ArrayList arrayListJ = j(g0Var, true);
        arrayListJ.getClass();
        return arrayListJ;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public List listOrNull(g0 g0Var) {
        g0Var.getClass();
        return j(g0Var, false);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public q metadataOrNull(g0 g0Var) {
        g0Var.getClass();
        File file = g0Var.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new q(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p openReadOnly(g0 g0Var) {
        g0Var.getClass();
        return new b0(new RandomAccessFile(g0Var.toFile(), "r"));
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p openReadWrite(g0 g0Var, boolean z, boolean z2) throws IOException {
        g0Var.getClass();
        if (z && z2) {
            com.github.catvod.spider.merge.s0.a.r("Cannot require mustCreate and mustExist at the same time.");
            return null;
        }
        if (z && exists(g0Var)) {
            com.github.catvod.spider.merge.s0.a.g(g0Var, " already exists.");
            return null;
        }
        if (!z2 || exists(g0Var)) {
            return new b0(new RandomAccessFile(g0Var.toFile(), "rw"));
        }
        com.github.catvod.spider.merge.s0.a.g(g0Var, " doesn't exist.");
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p0 sink(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        if (!z || !exists(g0Var)) {
            return new d(new FileOutputStream(g0Var.toFile(), false), new u0());
        }
        com.github.catvod.spider.merge.s0.a.g(g0Var, " already exists.");
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public r0 source(g0 g0Var) {
        g0Var.getClass();
        return new e(new FileInputStream(g0Var.toFile()), u0.NONE);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
