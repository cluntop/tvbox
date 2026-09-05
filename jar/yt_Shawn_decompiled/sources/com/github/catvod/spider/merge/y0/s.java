package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.merge.u.c2;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class s implements Closeable {
    public static final r Companion = new r();
    public static final s RESOURCES;
    public static final s SYSTEM;
    public static final g0 SYSTEM_TEMPORARY_DIRECTORY;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m26write$default(s sVar, g0 g0Var, boolean z, Function1 function1, int i, Object obj) {
        ?? r4;
        Object th = null;
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: write");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        g0Var.getClass();
        function1.getClass();
        j0 j0VarD = c2.d(sVar.sink(g0Var, z));
        try {
            Object objInvoke = function1.invoke(j0VarD);
            InlineMarker.finallyStart(1);
            try {
                j0VarD.close();
            } catch (Throwable th2) {
                th = th2;
            }
            InlineMarker.finallyEnd(1);
            Object obj2 = th;
            th = objInvoke;
            r4 = obj2;
        } catch (Throwable th3) {
            InlineMarker.finallyStart(1);
            try {
                j0VarD.close();
            } catch (Throwable th4) {
                ExceptionsKt.addSuppressed(th3, th4);
            }
            InlineMarker.finallyEnd(1);
            r4 = th3;
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    static {
        s c0Var;
        try {
            Class.forName("j$.nio.file.Files");
            c0Var = new e0();
        } catch (ClassNotFoundException unused) {
            c0Var = new c0();
        }
        SYSTEM = c0Var;
        String str = g0.b;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        SYSTEM_TEMPORARY_DIRECTORY = com.github.catvod.spider.merge.h0.f.e(property);
        ClassLoader classLoader = com.github.catvod.spider.merge.z0.k.class.getClassLoader();
        classLoader.getClass();
        RESOURCES = new com.github.catvod.spider.merge.z0.k(classLoader);
    }

    public static /* synthetic */ p0 appendingSink$default(s sVar, g0 g0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: appendingSink");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return sVar.appendingSink(g0Var, z);
    }

    public static /* synthetic */ void createDirectories$default(s sVar, g0 g0Var, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: createDirectories");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sVar.createDirectories(g0Var, z);
    }

    public static /* synthetic */ void createDirectory$default(s sVar, g0 g0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: createDirectory");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sVar.createDirectory(g0Var, z);
    }

    public static /* synthetic */ void delete$default(s sVar, g0 g0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: delete");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sVar.delete(g0Var, z);
    }

    public static /* synthetic */ void deleteRecursively$default(s sVar, g0 g0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: deleteRecursively");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sVar.deleteRecursively(g0Var, z);
    }

    @JvmStatic
    public static final s get(FileSystem fileSystem) {
        Companion.getClass();
        fileSystem.getClass();
        return new d0(fileSystem);
    }

    public static /* synthetic */ Sequence listRecursively$default(s sVar, g0 g0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: listRecursively");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return sVar.listRecursively(g0Var, z);
    }

    public static /* synthetic */ p openReadWrite$default(s sVar, g0 g0Var, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: openReadWrite");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return sVar.openReadWrite(g0Var, z, z2);
    }

    public static /* synthetic */ p0 sink$default(s sVar, g0 g0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            com.github.catvod.spider.merge.s0.a.v("Super calls with default arguments not supported in this target, function: sink");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return sVar.sink(g0Var, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m27read(g0 g0Var, Function1<? super l, ? extends T> function1) {
        ?? r5;
        g0Var.getClass();
        function1.getClass();
        l0 l0VarE = c2.e(source(g0Var));
        T th = null;
        try {
            ?? Invoke = function1.invoke(l0VarE);
            InlineMarker.finallyStart(1);
            try {
                l0VarE.close();
            } catch (Throwable th2) {
                th = th2;
            }
            InlineMarker.finallyEnd(1);
            T t = th;
            th = Invoke;
            r5 = t;
        } catch (Throwable th3) {
            InlineMarker.finallyStart(1);
            try {
                l0VarE.close();
            } catch (Throwable th4) {
                ExceptionsKt.addSuppressed(th3, th4);
            }
            InlineMarker.finallyEnd(1);
            r5 = th3;
        }
        if (r5 == 0) {
            return th;
        }
        throw r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m28write(g0 g0Var, boolean z, Function1<? super k, ? extends T> function1) {
        ?? r5;
        g0Var.getClass();
        function1.getClass();
        j0 j0VarD = c2.d(sink(g0Var, z));
        T th = null;
        try {
            ?? Invoke = function1.invoke(j0VarD);
            InlineMarker.finallyStart(1);
            try {
                j0VarD.close();
            } catch (Throwable th2) {
                th = th2;
            }
            InlineMarker.finallyEnd(1);
            T t = th;
            th = Invoke;
            r5 = t;
        } catch (Throwable th3) {
            InlineMarker.finallyStart(1);
            try {
                j0VarD.close();
            } catch (Throwable th4) {
                ExceptionsKt.addSuppressed(th3, th4);
            }
            InlineMarker.finallyEnd(1);
            r5 = th3;
        }
        if (r5 == 0) {
            return th;
        }
        throw r5;
    }

    public final p0 appendingSink(g0 g0Var) {
        g0Var.getClass();
        return appendingSink(g0Var, false);
    }

    public abstract p0 appendingSink(g0 g0Var, boolean z);

    public abstract void atomicMove(g0 g0Var, g0 g0Var2);

    public abstract g0 canonicalize(g0 g0Var);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copy(g0 g0Var, g0 g0Var2) throws Throwable {
        Throwable th;
        Long lValueOf;
        g0Var.getClass();
        g0Var2.getClass();
        r0 r0VarSource = source(g0Var);
        Throwable th2 = null;
        try {
            j0 j0VarD = c2.d(sink$default(this, g0Var2, false, 2, null));
            try {
                lValueOf = Long.valueOf(j0VarD.p(r0VarSource));
                try {
                    j0VarD.close();
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                try {
                    j0VarD.close();
                } catch (Throwable th5) {
                    ExceptionsKt.addSuppressed(th4, th5);
                }
                th = th4;
                lValueOf = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            if (r0VarSource != null) {
                try {
                    r0VarSource.close();
                } catch (Throwable th7) {
                    ExceptionsKt.addSuppressed(th2, th7);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        lValueOf.getClass();
        if (r0VarSource != null) {
            try {
                r0VarSource.close();
            } catch (Throwable th8) {
                th2 = th8;
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }

    public final void createDirectories(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        g0Var.getClass();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (g0 g0VarB = g0Var; g0VarB != null && !exists(g0VarB); g0VarB = g0VarB.b()) {
            arrayDeque.addFirst(g0VarB);
        }
        if (z && arrayDeque.isEmpty()) {
            com.github.catvod.spider.merge.s0.a.g(g0Var, " already exists.");
            return;
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            createDirectory$default(this, (g0) it.next(), false, 2, null);
        }
    }

    public final void createDirectory(g0 g0Var) {
        g0Var.getClass();
        createDirectory(g0Var, false);
    }

    public abstract void createDirectory(g0 g0Var, boolean z);

    public abstract void createSymlink(g0 g0Var, g0 g0Var2);

    public final void delete(g0 g0Var) {
        g0Var.getClass();
        delete(g0Var, false);
    }

    public abstract void delete(g0 g0Var, boolean z);

    public void deleteRecursively(g0 g0Var, boolean z) {
        g0Var.getClass();
        Iterator it = SequencesKt.sequence(new com.github.catvod.spider.merge.z0.d(this, g0Var, null)).iterator();
        while (it.hasNext()) {
            delete((g0) it.next(), z && !it.hasNext());
        }
    }

    public final boolean exists(g0 g0Var) {
        g0Var.getClass();
        g0Var.getClass();
        return metadataOrNull(g0Var) != null;
    }

    public abstract List list(g0 g0Var);

    public abstract List listOrNull(g0 g0Var);

    public Sequence listRecursively(g0 g0Var, boolean z) {
        g0Var.getClass();
        return SequencesKt.sequence(new com.github.catvod.spider.merge.z0.e(g0Var, this, z, null));
    }

    public final q metadata(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        g0Var.getClass();
        q qVarMetadataOrNull = metadataOrNull(g0Var);
        if (qVarMetadataOrNull != null) {
            return qVarMetadataOrNull;
        }
        throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
    }

    public abstract q metadataOrNull(g0 g0Var);

    public abstract p openReadOnly(g0 g0Var);

    public final p openReadWrite(g0 g0Var) {
        g0Var.getClass();
        return openReadWrite(g0Var, false, false);
    }

    public abstract p openReadWrite(g0 g0Var, boolean z, boolean z2);

    public final p0 sink(g0 g0Var) {
        g0Var.getClass();
        return sink(g0Var, false);
    }

    public abstract p0 sink(g0 g0Var, boolean z);

    public abstract r0 source(g0 g0Var);

    public final Sequence<g0> listRecursively(g0 g0Var) {
        g0Var.getClass();
        return listRecursively(g0Var, false);
    }

    public final void deleteRecursively(g0 g0Var) {
        g0Var.getClass();
        deleteRecursively(g0Var, false);
    }

    public final void createDirectories(g0 g0Var) throws IOException {
        g0Var.getClass();
        createDirectories(g0Var, false);
    }
}
