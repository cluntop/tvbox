package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.jdollar.nio.channels.DesugarChannels;
import com.github.catvod.spider.jdollar.nio.file.CopyOption;
import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.jdollar.nio.file.Files;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.OpenOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.StandardCopyOption;
import com.github.catvod.spider.jdollar.nio.file.StandardOpenOption;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.merge.u.c2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.internal.Reflection;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d0 extends e0 {
    public final FileSystem a;

    public d0(FileSystem fileSystem) {
        this.a = fileSystem;
    }

    public final ArrayList B(g0 g0Var, boolean z) throws IOException {
        Path pathC = C(g0Var);
        try {
            List<Path> listF = PathsKt.f(pathC);
            ArrayList arrayList = new ArrayList();
            for (Path path : listF) {
                String str = g0.b;
                arrayList.add(com.github.catvod.spider.merge.h0.f.g(path));
            }
            CollectionsKt.sort(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (!z) {
                return null;
            }
            if (!Files.exists(pathC, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
            }
            com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.t0.a.e(g0Var, "failed to list "));
            return null;
        }
    }

    public final Path C(g0 g0Var) {
        Path path = this.a.getPath(g0Var.a.r(), new String[0]);
        path.getClass();
        return path;
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final p0 appendingSink(g0 g0Var, boolean z) {
        g0Var.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(StandardOpenOption.APPEND);
        if (!z) {
            listCreateListBuilder.add(StandardOpenOption.CREATE);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        Path pathC = C(g0Var);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathC, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        outputStreamNewOutputStream.getClass();
        return new d(outputStreamNewOutputStream, new u0());
    }

    @Override // com.github.catvod.spider.merge.y0.e0, com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final void atomicMove(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        try {
            Files.move(C(g0Var), C(g0Var2), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)).getClass();
        } catch (UnsupportedOperationException unused) {
            com.github.catvod.spider.merge.s0.a.w("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final g0 canonicalize(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        try {
            String str = g0.b;
            Path realPath = C(g0Var).toRealPath(new LinkOption[0]);
            realPath.getClass();
            return com.github.catvod.spider.merge.h0.f.g(realPath);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
    }

    @Override // com.github.catvod.spider.merge.y0.s, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void createDirectory(com.github.catvod.spider.merge.y0.g0 r4, boolean r5) throws java.io.IOException {
        /*
            r3 = this;
            r4.getClass()
            com.github.catvod.spider.jdollar.nio.file.Path r0 = r3.C(r4)
            com.github.catvod.spider.merge.y0.q r0 = com.github.catvod.spider.merge.y0.e0.z(r0)
            r1 = 0
            if (r0 == 0) goto L14
            boolean r0 = r0.b
            r2 = 1
            if (r0 != r2) goto L14
            goto L15
        L14:
            r2 = 0
        L15:
            if (r2 == 0) goto L20
            if (r5 != 0) goto L1a
            goto L20
        L1a:
            java.lang.String r5 = " already exists."
            com.github.catvod.spider.merge.s0.a.g(r4, r5)
            return
        L20:
            com.github.catvod.spider.jdollar.nio.file.Path r5 = r3.C(r4)     // Catch: java.io.IOException -> L34
            com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute[] r0 = new com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L34
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L34
            com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute[] r0 = (com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L34
            com.github.catvod.spider.jdollar.nio.file.Path r5 = com.github.catvod.spider.jdollar.nio.file.Files.createDirectory(r5, r0)     // Catch: java.io.IOException -> L34
            r5.getClass()     // Catch: java.io.IOException -> L34
            return
        L34:
            r5 = move-exception
            if (r2 == 0) goto L38
            return
        L38:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "failed to create directory: "
            java.lang.String r4 = com.github.catvod.spider.merge.t0.a.e(r4, r1)
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.y0.d0.createDirectory(com.github.catvod.spider.merge.y0.g0, boolean):void");
    }

    @Override // com.github.catvod.spider.merge.y0.e0, com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final void createSymlink(g0 g0Var, g0 g0Var2) {
        g0Var.getClass();
        g0Var2.getClass();
        Files.createSymbolicLink(C(g0Var), C(g0Var2), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)).getClass();
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final void delete(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        Path pathC = C(g0Var);
        try {
            Files.delete(pathC);
        } catch (NoSuchFileException unused) {
            if (z) {
                throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
            }
        } catch (IOException unused2) {
            if (Files.exists(pathC, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.t0.a.e(g0Var, "failed to delete "));
            }
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final List list(g0 g0Var) throws IOException {
        g0Var.getClass();
        ArrayList arrayListB = B(g0Var, true);
        arrayListB.getClass();
        return arrayListB;
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final List listOrNull(g0 g0Var) {
        g0Var.getClass();
        return B(g0Var, false);
    }

    @Override // com.github.catvod.spider.merge.y0.e0, com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final q metadataOrNull(g0 g0Var) {
        g0Var.getClass();
        return e0.z(C(g0Var));
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final p openReadOnly(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        try {
            FileChannel fileChannelOpen = DesugarChannels.open(C(g0Var), StandardOpenOption.READ);
            fileChannelOpen.getClass();
            return new b0(fileChannelOpen);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final p openReadWrite(g0 g0Var, boolean z, boolean z2) throws FileNotFoundException {
        g0Var.getClass();
        if (z && z2) {
            com.github.catvod.spider.merge.s0.a.r("Cannot require mustCreate and mustExist at the same time.");
            return null;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(StandardOpenOption.READ);
        listCreateListBuilder.add(StandardOpenOption.WRITE);
        if (z) {
            listCreateListBuilder.add(StandardOpenOption.CREATE_NEW);
        } else if (!z2) {
            listCreateListBuilder.add(StandardOpenOption.CREATE);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        try {
            Path pathC = C(g0Var);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
            FileChannel fileChannelOpen = DesugarChannels.open(pathC, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            fileChannelOpen.getClass();
            return new b0(fileChannelOpen);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final p0 sink(g0 g0Var, boolean z) throws FileNotFoundException {
        g0Var.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (z) {
            listCreateListBuilder.add(StandardOpenOption.CREATE_NEW);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        try {
            Path pathC = C(g0Var);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathC, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            outputStreamNewOutputStream.getClass();
            return new d(outputStreamNewOutputStream, new u0());
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
    }

    @Override // com.github.catvod.spider.merge.y0.c0, com.github.catvod.spider.merge.y0.s
    public final r0 source(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(C(g0Var), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            inputStreamNewInputStream.getClass();
            return c2.V(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
    }

    @Override // com.github.catvod.spider.merge.y0.e0, com.github.catvod.spider.merge.y0.c0
    public final String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(this.a.getClass()).getSimpleName();
        simpleName.getClass();
        return simpleName;
    }
}
