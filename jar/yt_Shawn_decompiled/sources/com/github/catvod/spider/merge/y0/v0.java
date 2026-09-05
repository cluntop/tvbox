package com.github.catvod.spider.merge.y0;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v0 extends s {
    public static final g0 d;
    public final g0 a;
    public final s b;
    public final Map c;

    static {
        String str = g0.b;
        d = com.github.catvod.spider.merge.h0.f.e("/");
    }

    public v0(g0 g0Var, s sVar, Map map) {
        map.getClass();
        this.a = g0Var;
        this.b = sVar;
        this.c = map;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final p0 appendingSink(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void atomicMove(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final g0 canonicalize(g0 g0Var) throws FileNotFoundException {
        g0Var.getClass();
        g0 g0Var2 = d;
        g0Var2.getClass();
        g0 g0VarB = com.github.catvod.spider.merge.z0.f.b(g0Var2, g0Var, true);
        if (this.c.containsKey(g0VarB)) {
            return g0VarB;
        }
        throw new FileNotFoundException(String.valueOf(g0Var));
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void createDirectory(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void createSymlink(g0 g0Var, g0 g0Var2) throws IOException {
        g0Var.getClass();
        g0Var2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final void delete(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    public final List j(g0 g0Var, boolean z) throws IOException {
        g0 g0Var2 = d;
        g0Var2.getClass();
        g0Var.getClass();
        com.github.catvod.spider.merge.z0.m mVar = (com.github.catvod.spider.merge.z0.m) this.c.get(com.github.catvod.spider.merge.z0.f.b(g0Var2, g0Var, true));
        if (mVar != null) {
            return CollectionsKt.toList(mVar.q);
        }
        if (!z) {
            return null;
        }
        com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.t0.a.e(g0Var, "not a directory: "));
        return null;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final List list(g0 g0Var) throws IOException {
        g0Var.getClass();
        List listJ = j(g0Var, true);
        listJ.getClass();
        return listJ;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final List listOrNull(g0 g0Var) {
        g0Var.getClass();
        return j(g0Var, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0131  */
    @Override // com.github.catvod.spider.merge.y0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.merge.y0.q metadataOrNull(com.github.catvod.spider.merge.y0.g0 r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.y0.v0.metadataOrNull(com.github.catvod.spider.merge.y0.g0):com.github.catvod.spider.merge.y0.q");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final p openReadOnly(g0 g0Var) {
        g0Var.getClass();
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final p openReadWrite(g0 g0Var, boolean z, boolean z2) throws IOException {
        g0Var.getClass();
        throw new IOException("zip entries are not writable");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final p0 sink(g0 g0Var, boolean z) throws IOException {
        g0Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public final r0 source(g0 g0Var) throws Throwable {
        l0 l0Var;
        Throwable th;
        g0Var.getClass();
        g0 g0Var2 = d;
        g0Var2.getClass();
        com.github.catvod.spider.merge.z0.m mVar = (com.github.catvod.spider.merge.z0.m) this.c.get(com.github.catvod.spider.merge.z0.f.b(g0Var2, g0Var, true));
        if (mVar == null) {
            throw new FileNotFoundException(com.github.catvod.spider.merge.t0.a.e(g0Var, "no such file: "));
        }
        long j = mVar.f;
        p pVarOpenReadOnly = this.b.openReadOnly(this.a);
        try {
            l0Var = new l0(pVarOpenReadOnly.B(mVar.h));
            try {
                pVarOpenReadOnly.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (pVarOpenReadOnly != null) {
                try {
                    pVarOpenReadOnly.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            l0Var = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        l0Var.getClass();
        com.github.catvod.spider.merge.z0.b.h(l0Var, null);
        return mVar.g == 0 ? new com.github.catvod.spider.merge.z0.j(l0Var, j, true) : new com.github.catvod.spider.merge.z0.j(new a0(new com.github.catvod.spider.merge.z0.j(l0Var, mVar.e, true), new Inflater(true)), j, false);
    }
}
