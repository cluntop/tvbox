package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.List;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.Spliterators;
import com.github.catvod.spider.jdollar.util.o0;
import java.io.File;
import java.net.URI;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements java.nio.file.Path {
    public final /* synthetic */ Path a;

    public /* synthetic */ v(Path path) {
        this.a = path;
    }

    public static /* synthetic */ java.nio.file.Path h(Path path) {
        if (path == null) {
            return null;
        }
        return path instanceof u ? ((u) path).a : new v(path);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.nio.file.Path path) {
        return this.a.compareTo(com.github.catvod.spider.jdollar.com.android.tools.r8.a.o(path));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ boolean endsWith(java.nio.file.Path path) {
        return this.a.n(u.h(path));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ boolean equals(Object obj) {
        Path path = this.a;
        if (obj instanceof v) {
            obj = ((v) obj).a;
        }
        return path.equals(obj);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(Consumer<? super java.nio.file.Path> consumer) {
        Iterable.EL.forEach(this.a, consumer);
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path getFileName() {
        return h(this.a.getFileName());
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.FileSystem getFileSystem() {
        return h.g(this.a.getFileSystem());
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path getName(int i) {
        return h(this.a.getName(i));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ int getNameCount() {
        return this.a.getNameCount();
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path getParent() {
        return h(this.a.getParent());
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path getRoot() {
        return h(this.a.getRoot());
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ boolean isAbsolute() {
        return this.a.isAbsolute();
    }

    @Override // java.nio.file.Path, java.lang.Iterable
    public final Iterator iterator() {
        return new z(this.a.iterator());
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path normalize() {
        return h(this.a.normalize());
    }

    @Override // java.nio.file.Path, java.nio.file.Watchable
    public final /* synthetic */ WatchKey register(WatchService watchService, WatchEvent.Kind[] kindArr, WatchEvent.Modifier[] modifierArr) {
        k0[] k0VarArr;
        Path path = this.a;
        m0 m0VarG = m0.g(watchService);
        j0[] j0VarArrG = com.github.catvod.spider.jdollar.com.android.tools.r8.a.G(kindArr);
        if (modifierArr == null) {
            k0VarArr = null;
        } else {
            int length = modifierArr.length;
            k0VarArr = new k0[length];
            for (int i = 0; i < length; i++) {
                WatchEvent.Modifier modifier = modifierArr[i];
                k0VarArr[i] = modifier == null ? null : new k0(modifier);
            }
        }
        l0 l0VarG = path.g(m0VarG, j0VarArrG, k0VarArr);
        if (l0VarG == null) {
            return null;
        }
        return l0VarG.a;
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path relativize(java.nio.file.Path path) {
        return h(this.a.relativize(u.h(path)));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path resolve(java.nio.file.Path path) {
        return h(this.a.resolve(u.h(path)));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path resolveSibling(java.nio.file.Path path) {
        return h(this.a.p(u.h(path)));
    }

    @Override // java.lang.Iterable
    public final Spliterator<java.nio.file.Path> spliterator() {
        com.github.catvod.spider.jdollar.util.Spliterator spliteratorB;
        Iterable iterable = this.a;
        if (iterable instanceof Iterable) {
            spliteratorB = ((Iterable) iterable).spliterator();
        } else if (iterable instanceof LinkedHashSet) {
            spliteratorB = Spliterators.b(17, (LinkedHashSet) iterable);
        } else if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            spliteratorB = new o0(sortedSet, sortedSet);
        } else {
            spliteratorB = iterable instanceof Set ? Spliterators.b(1, (Set) iterable) : iterable instanceof List ? List.CC.$default$spliterator((java.util.List) iterable) : iterable instanceof Collection ? Spliterators.b(0, (Collection) iterable) : Spliterators.spliteratorUnknownSize(iterable.iterator(), 0);
        }
        return Spliterator.Wrapper.convert(spliteratorB);
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ boolean startsWith(java.nio.file.Path path) {
        return this.a.startsWith(u.h(path));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path subpath(int i, int i2) {
        return h(this.a.subpath(i, i2));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path toAbsolutePath() {
        return h(this.a.toAbsolutePath());
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ File toFile() {
        return this.a.toFile();
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path toRealPath(java.nio.file.LinkOption[] linkOptionArr) {
        return h(this.a.toRealPath(com.github.catvod.spider.jdollar.com.android.tools.r8.a.F(linkOptionArr)));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ String toString() {
        return this.a.toString();
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ URI toUri() {
        return this.a.toUri();
    }

    @Override // java.nio.file.Path
    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public final /* synthetic */ int compareTo2(java.nio.file.Path path) {
        return this.a.compareTo(u.h(path));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ boolean endsWith(String str) {
        return this.a.endsWith(str);
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ boolean startsWith(String str) {
        return this.a.startsWith(str);
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path resolve(String str) {
        return h(this.a.resolve(str));
    }

    @Override // java.nio.file.Path
    public final /* synthetic */ java.nio.file.Path resolveSibling(String str) {
        return h(this.a.resolveSibling(str));
    }

    @Override // java.nio.file.Path, java.nio.file.Watchable
    public final /* synthetic */ WatchKey register(WatchService watchService, WatchEvent.Kind[] kindArr) {
        l0 l0VarI = this.a.I(m0.g(watchService), com.github.catvod.spider.jdollar.com.android.tools.r8.a.G(kindArr));
        if (l0VarI == null) {
            return null;
        }
        return l0VarI.a;
    }
}
