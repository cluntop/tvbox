package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k implements Iterator {
    public final DirectoryStream.Filter a;
    public final File[] b;
    public int c = 0;
    public final /* synthetic */ l d;

    public k(l lVar, Path path, DirectoryStream.Filter filter) {
        this.d = lVar;
        File[] fileArrListFiles = path.toFile().listFiles();
        this.b = fileArrListFiles == null ? new File[0] : fileArrListFiles;
        this.a = filter;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final n next() {
        n nVar;
        do {
            int i = this.c;
            File[] fileArr = this.b;
            if (i >= fileArr.length) {
                return null;
            }
            this.c = i + 1;
            File file = fileArr[i];
            h hVar = this.d.g;
            String path = file.getPath();
            l lVar = this.d;
            nVar = new n(hVar, path, lVar.e, lVar.f);
            try {
            } catch (IOException e) {
                throw new DirectoryIteratorException(e);
            }
        } while (!this.a.accept(nVar));
        return nVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (next() == null) {
            return false;
        }
        this.c--;
        return true;
    }
}
