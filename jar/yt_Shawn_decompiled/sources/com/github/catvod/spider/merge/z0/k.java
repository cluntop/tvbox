package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.u.c2;
import com.github.catvod.spider.merge.y0.g0;
import com.github.catvod.spider.merge.y0.p0;
import com.github.catvod.spider.merge.y0.r0;
import com.github.catvod.spider.merge.y0.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k extends s {
    public static final g0 d;
    public final ClassLoader a;
    public final s b;
    public final Lazy c;

    static {
        String str = g0.b;
        d = com.github.catvod.spider.merge.h0.f.e("/");
    }

    public k(ClassLoader classLoader) {
        s sVar = s.SYSTEM;
        classLoader.getClass();
        sVar.getClass();
        this.a = classLoader;
        this.b = sVar;
        final int i = 1;
        this.c = LazyKt.lazy(new Function0() { // from class: com.github.catvod.spider.merge.w0.a
            /* JADX WARN: Removed duplicated region for block: B:175:0x02a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:202:0x0315 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:221:0x0217 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:224:0x02c8 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:235:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x0216  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invoke() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 834
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.w0.a.invoke():java.lang.Object");
            }
        });
    }

    public static String j(g0 g0Var) {
        g0 g0Var2 = d;
        g0Var2.getClass();
        g0Var.getClass();
        return f.b(g0Var2, g0Var, true).c(g0Var2).a.r();
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final p0 appendingSink(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void atomicMove(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final g0 canonicalize(g0 g0Var) {
        g0Var.getClass();
        g0 g0Var2 = d;
        g0Var2.getClass();
        return f.b(g0Var2, g0Var, true);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void createDirectory(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void createSymlink(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void delete(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final List list(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        String strJ = j(g0Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair pair : (List) this.c.getValue()) {
            s sVar = (s) pair.component1();
            g0 g0Var2 = (g0) pair.component2();
            try {
                List list = sVar.list(g0Var2.d(strJ));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (com.github.catvod.spider.merge.h0.f.a((g0) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.g(arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(com.github.catvod.spider.merge.h0.f.i((g0) it.next(), g0Var2));
                }
                CollectionsKt.c(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "file not found: "));
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final List listOrNull(g0 g0Var) {
        g0Var.getClass();
        String strJ = j(g0Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = ((List) this.c.getValue()).iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            s sVar = (s) pair.component1();
            g0 g0Var2 = (g0) pair.component2();
            List listListOrNull = sVar.listOrNull(g0Var2.d(strJ));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (com.github.catvod.spider.merge.h0.f.a((g0) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.g(arrayList2));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(com.github.catvod.spider.merge.h0.f.i((g0) it2.next(), g0Var2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                CollectionsKt.c(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (z) {
            return CollectionsKt.toList(linkedHashSet);
        }
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final com.github.catvod.spider.merge.y0.q metadataOrNull(g0 g0Var) {
        g0Var.getClass();
        if (!com.github.catvod.spider.merge.h0.f.a(g0Var)) {
            return null;
        }
        String strJ = j(g0Var);
        for (Pair pair : (List) this.c.getValue()) {
            com.github.catvod.spider.merge.y0.q qVarMetadataOrNull = ((s) pair.component1()).metadataOrNull(((g0) pair.component2()).d(strJ));
            if (qVarMetadataOrNull != null) {
                return qVarMetadataOrNull;
            }
        }
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final com.github.catvod.spider.merge.y0.p openReadOnly(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        if (!com.github.catvod.spider.merge.h0.f.a(g0Var)) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "file not found: "));
        }
        String strJ = j(g0Var);
        for (Pair pair : (List) this.c.getValue()) {
            try {
                return ((s) pair.component1()).openReadOnly(((g0) pair.component2()).d(strJ));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "file not found: "));
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final com.github.catvod.spider.merge.y0.p openReadWrite(g0 g0Var, boolean z, boolean z2) throws IOException {
        g0Var.getClass();
        throw new IOException("resources are not writable");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final p0 sink(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final r0 source(g0 g0Var) throws IOException {
        g0Var.getClass();
        if (!com.github.catvod.spider.merge.h0.f.a(g0Var)) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "file not found: "));
        }
        g0 g0Var2 = d;
        g0Var2.getClass();
        URL resource = this.a.getResource(f.b(g0Var2, g0Var, false).c(g0Var2).a.r());
        if (resource == null) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "file not found: "));
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        inputStream.getClass();
        return c2.V(inputStream);
    }
}
