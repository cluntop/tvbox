package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.j0;
import com.github.catvod.spider.jdollar.nio.file.k0;
import com.github.catvod.spider.jdollar.nio.file.l0;
import com.github.catvod.spider.jdollar.nio.file.m0;
import com.github.catvod.spider.jdollar.nio.file.t;
import com.github.catvod.spider.jdollar.util.DesugarArrays;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n implements Path {
    public static final Pattern h = Pattern.compile("/+");
    public final FileSystem a;
    public final String b;
    public final List c;
    public final boolean d;
    public final String e;
    public final String f;
    public volatile byte[] g;

    public n(FileSystem fileSystem, String str, String str2, String str3) {
        this(fileSystem, str.startsWith("/"), str.isEmpty() ? Collections.singletonList(VideoStream.RESOLUTION_UNKNOWN) : (List) DesugarArrays.stream(h.split(str)).filter(new m(0)).collect(Collectors.toUnmodifiableList()), str2, str3);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final l0 I(m0 m0Var, j0... j0VarArr) {
        g(m0Var, j0VarArr, new k0[0]);
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final boolean endsWith(String str) {
        return n(new n(this.a, str, this.e, this.f));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final boolean equals(Object obj) {
        return (obj instanceof n) && compareTo((n) obj) == 0;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final l0 g(m0 m0Var, j0[] j0VarArr, k0... k0VarArr) {
        throw new UnsupportedOperationException("Watch Service is not supported");
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path getFileName() {
        if (this.c.isEmpty()) {
            if (this.d) {
                return null;
            }
            return this;
        }
        return new n(this.a, (String) this.c.get(r2.size() - 1), this.e, this.f);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final FileSystem getFileSystem() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final int getNameCount() {
        return this.c.size();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path getRoot() {
        if (!this.d) {
            return null;
        }
        FileSystem fileSystem = this.a;
        String str = this.f;
        return new n(fileSystem, str, this.e, str);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final n getName(int i) {
        if (i < 0 || i >= this.c.size()) {
            throw new IllegalArgumentException(String.format("Requested name for index (%d) is out of bound in \n%s.", Integer.valueOf(i), this));
        }
        return new n(this.a, (String) this.c.get(i), this.e, this.f);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final n getParent() {
        int size = this.c.size();
        if (size == 0) {
            return null;
        }
        if (size == 1 && !this.d) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("/");
        }
        sb.append(com.github.catvod.spider.jdollar.com.android.tools.r8.a.A(this.c.subList(0, size - 1)));
        return new n(this.a, sb.toString(), this.e, this.f);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final boolean isAbsolute() {
        return this.d;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path, java.lang.Iterable
    public final Iterator iterator() {
        return new t(this);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final n resolve(Path path) {
        if (!(path instanceof n)) {
            throw new IllegalArgumentException(String.format("Expected to resolve paths on the same file system as DesugarUnixPath, but gets %s (%s).", path, path.getFileSystem()));
        }
        if (((n) path).d) {
            return (n) path;
        }
        return new n(this.a, this.b + "/" + path, this.e, this.f);
    }

    @Override // java.lang.Comparable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final int compareTo(Path path) {
        return this.b.compareTo(((n) path).b);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final boolean n(Path path) {
        Objects.requireNonNull(path);
        if (!(path instanceof n)) {
            return false;
        }
        n nVar = (n) path;
        if (nVar.d) {
            return equals(path);
        }
        int size = nVar.c.size();
        if (this.c.size() < size) {
            return false;
        }
        int size2 = this.c.size();
        for (int i = size - 1; i >= 0; i--) {
            if (!getName((i - size) + size2).equals(nVar.getName(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path normalize() {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (String str : this.c) {
            str.getClass();
            if (!str.equals(".")) {
                if (str.equals("..")) {
                    arrayDeque.removeLast();
                } else {
                    arrayDeque.add(str);
                }
            }
        }
        return new n(this.a, (this.d ? "/" : VideoStream.RESOLUTION_UNKNOWN).concat(com.github.catvod.spider.jdollar.com.android.tools.r8.a.A(arrayDeque)), this.e, this.f);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final n p(Path path) {
        if (!(Objects.requireNonNull(path) instanceof n)) {
            throw new IllegalArgumentException(String.format("Expected to resolve paths on the same file system as DesugarUnixPath, but gets %s (%s).", path, path.getFileSystem()));
        }
        n parent = getParent();
        return parent == null ? (n) path : parent.resolve(path);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path relativize(Path path) {
        int i = 0;
        if (!(path instanceof n)) {
            throw new IllegalArgumentException(String.format("Expected to resolve paths on the same file system as DesugarUnixPath, but gets %s (%s).", path, path.getFileSystem()));
        }
        if (this.d != ((n) path).d) {
            com.github.catvod.spider.jdollar.nio.file.b.c("'other' is different type of Path in absolute property.");
            return null;
        }
        List list = ((n) path).c;
        int size = this.c.size();
        int size2 = list.size();
        while (i < size && i < size2 && ((String) this.c.get(i)).equals(list.get(i))) {
            i++;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = i; i2 < size; i2++) {
            arrayList.add("..");
        }
        while (i < size2) {
            arrayList.add((String) list.get(i));
            i++;
        }
        return new n(this.a, false, arrayList, this.e, this.f);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path resolve(String str) {
        return resolve(getFileSystem().getPath(str, new String[0]));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path resolveSibling(String str) {
        return p(new n(this.a, str, this.e, this.f));
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final boolean startsWith(Path path) {
        int size;
        Objects.requireNonNull(path);
        if (!(path instanceof n)) {
            return false;
        }
        n nVar = (n) path;
        if (this.d != nVar.d || this.c.size() < (size = nVar.c.size())) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!getName(i).equals(nVar.getName(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path subpath(int i, int i2) {
        return new n(this.a, com.github.catvod.spider.jdollar.com.android.tools.r8.a.A(this.c.subList(i, i2)), this.e, this.f);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final File toFile() {
        return new File(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final Path toRealPath(LinkOption[] linkOptionArr) {
        this.a.E().a(this, com.github.catvod.spider.jdollar.nio.file.a.READ);
        return Arrays.asList(linkOptionArr).contains(LinkOption.NOFOLLOW_LINKS) ? toAbsolutePath() : new n(this.a, toFile().getCanonicalPath(), this.e, this.f);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final String toString() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final URI toUri() {
        char[] cArr = o.c;
        n absolutePath = toAbsolutePath();
        if (absolutePath.g == null) {
            absolutePath.g = absolutePath.b.getBytes(p.a);
        }
        byte[] bArr = absolutePath.g;
        StringBuilder sb = new StringBuilder("file:///");
        for (int i = 1; i < bArr.length; i++) {
            char c = (char) (bArr[i] & 255);
            long j = o.a;
            long j2 = o.b;
            if (c >= '@' ? c >= 128 || ((1 << (c - '@')) & j2) == 0 : (j & (1 << c)) == 0) {
                sb.append('%');
                char[] cArr2 = o.c;
                sb.append(cArr2[(c >> 4) & 15]);
                sb.append(cArr2[c & 15]);
            } else {
                sb.append(c);
            }
        }
        if (sb.charAt(sb.length() - 1) != '/' && toFile().isDirectory()) {
            sb.append('/');
        }
        try {
            return new URI(sb.toString());
        } catch (URISyntaxException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final n toAbsolutePath() {
        if (this.d) {
            return this;
        }
        FileSystem fileSystem = this.a;
        String str = this.e;
        return new n(fileSystem, str, str, this.f).resolve(this);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.Path
    public final boolean startsWith(String str) {
        return startsWith(new n(this.a, str, this.e, this.f));
    }

    public n(FileSystem fileSystem, boolean z, List list, String str, String str2) {
        this.a = fileSystem;
        this.d = z;
        this.c = list;
        this.b = (z ? "/" : VideoStream.RESOLUTION_UNKNOWN).concat(com.github.catvod.spider.jdollar.com.android.tools.r8.a.A(list));
        this.e = str;
        this.f = str2;
    }
}
