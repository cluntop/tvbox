package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.b1;
import java.io.File;
import java.net.URI;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.Iterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements Path, Iterable {
    public final /* synthetic */ java.nio.file.Path a;

    public /* synthetic */ u(java.nio.file.Path path) {
        this.a = path;
    }

    public static /* synthetic */ Path h(java.nio.file.Path path) {
        if (path == null) {
            return null;
        }
        return path instanceof v ? ((v) path).a : new u(path);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ l0 I(m0 m0Var, j0[] j0VarArr) {
        return l0.a(this.a.register(m0Var == null ? null : m0Var.a, com.github.catvod.spider.jdollar.com.android.tools.r8.a.K(j0VarArr)));
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Path path) {
        return this.a.compareTo((java.nio.file.Path) com.github.catvod.spider.jdollar.com.android.tools.r8.a.o(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ boolean endsWith(String str) {
        return this.a.endsWith(str);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.Path path = this.a;
        if (obj instanceof u) {
            obj = ((u) obj).a;
        }
        return path.equals(obj);
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final /* synthetic */ void forEach(Consumer consumer) {
        Iterable.EL.forEach(this.a, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ l0 g(m0 m0Var, j0[] j0VarArr, k0[] k0VarArr) {
        java.nio.file.Path path = this.a;
        WatchEvent.Modifier[] modifierArr = null;
        WatchService watchService = m0Var == null ? null : m0Var.a;
        WatchEvent.Kind<?>[] kindArrK = com.github.catvod.spider.jdollar.com.android.tools.r8.a.K(j0VarArr);
        if (k0VarArr != null) {
            int length = k0VarArr.length;
            WatchEvent.Modifier[] modifierArr2 = new WatchEvent.Modifier[length];
            for (int i = 0; i < length; i++) {
                k0 k0Var = k0VarArr[i];
                modifierArr2[i] = k0Var == null ? null : k0Var.a;
            }
            modifierArr = modifierArr2;
        }
        return l0.a(path.register(watchService, kindArrK, modifierArr));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path getFileName() {
        return h(this.a.getFileName());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ FileSystem getFileSystem() {
        return g.G(this.a.getFileSystem());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path getName(int i) {
        return h(this.a.getName(i));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ int getNameCount() {
        return this.a.getNameCount();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path getParent() {
        return h(this.a.getParent());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path getRoot() {
        return h(this.a.getRoot());
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ boolean isAbsolute() {
        return this.a.isAbsolute();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path, java.lang.Iterable
    public final Iterator iterator() {
        return new z(this.a.iterator());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    /* renamed from: k */
    public final /* synthetic */ int compareTo(Path path) {
        return this.a.compareTo(v.h(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ boolean n(Path path) {
        return this.a.endsWith(v.h(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path normalize() {
        return h(this.a.normalize());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path p(Path path) {
        return h(this.a.resolveSibling(v.h(path)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path relativize(Path path) {
        return h(this.a.relativize(v.h(path)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path resolve(Path path) {
        return h(this.a.resolve(v.h(path)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path resolveSibling(String str) {
        return h(this.a.resolveSibling(str));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return b1.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ boolean startsWith(Path path) {
        return this.a.startsWith(v.h(path));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path subpath(int i, int i2) {
        return h(this.a.subpath(i, i2));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path toAbsolutePath() {
        return h(this.a.toAbsolutePath());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ File toFile() {
        return this.a.toFile();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path toRealPath(LinkOption[] linkOptionArr) {
        return h(this.a.toRealPath(com.github.catvod.spider.jdollar.com.android.tools.r8.a.J(linkOptionArr)));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ String toString() {
        return this.a.toString();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ URI toUri() {
        return this.a.toUri();
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator<Path> spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ boolean startsWith(String str) {
        return this.a.startsWith(str);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final /* synthetic */ Path resolve(String str) {
        return h(this.a.resolve(str));
    }
}
