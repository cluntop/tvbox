package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.Spliterators;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.p1.d0;
import com.github.catvod.spider.merge.p1.e0;
import com.github.catvod.spider.merge.p1.f0;
import com.github.catvod.spider.merge.p1.h0;
import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class n extends s implements Iterable, Iterable {
    public static final List g = Collections.EMPTY_LIST;
    public static final m h = new m(0);
    public static final String i;
    public final f0 d;
    public m e;
    public c f;

    static {
        Pattern.compile("\\s+");
        i = "/".concat("baseUri");
    }

    public n(f0 f0Var, String str, c cVar) {
        c2.R(f0Var);
        this.e = h;
        this.f = cVar;
        this.d = f0Var;
        if (com.github.catvod.spider.merge.n1.i.f(str)) {
            return;
        }
        c2.R(str);
        J(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void F(java.lang.StringBuilder r4, com.github.catvod.spider.merge.o1.z r5) {
        /*
            java.lang.String r0 = r5.D()
            com.github.catvod.spider.merge.o1.n r1 = r5.a
            if (r1 == 0) goto L1b
            r2 = 0
        L9:
            com.github.catvod.spider.merge.p1.f0 r3 = r1.d
            int r3 = r3.d
            r3 = r3 & 64
            if (r3 == 0) goto L12
            goto L1f
        L12:
            com.github.catvod.spider.merge.o1.n r1 = r1.a
            int r2 = r2 + 1
            r3 = 6
            if (r2 >= r3) goto L1b
            if (r1 != 0) goto L9
        L1b:
            boolean r5 = r5 instanceof com.github.catvod.spider.merge.o1.d
            if (r5 == 0) goto L23
        L1f:
            r4.append(r0)
            return
        L23:
            boolean r5 = com.github.catvod.spider.merge.o1.z.G(r4)
            com.github.catvod.spider.merge.n1.i.a(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.o1.n.F(java.lang.StringBuilder, com.github.catvod.spider.merge.o1.z):void");
    }

    public final void D(s sVar) {
        c2.R(sVar);
        n nVar = sVar.a;
        if (nVar != null) {
            nVar.A(sVar);
        }
        sVar.a = this;
        k();
        this.e.add(sVar);
        sVar.b = this.e.size() - 1;
    }

    public final n E(String str) {
        String str2 = this.d.a;
        h hVarW = w();
        e0 e0Var = hVarW != null ? hVarW.k : new e0(new com.github.catvod.spider.merge.p1.b());
        h0 h0VarA = e0Var.a();
        d0 d0Var = e0Var.c;
        h0VarA.getClass();
        n nVar = new n(h0VarA.d(str, null, str2, d0Var.a), e(), null);
        D(nVar);
        return nVar;
    }

    public final List G() {
        List list;
        Integer num;
        c cVar = this.f;
        if (cVar != null && cVar.g("/jsoup.userdata")) {
            Map mapO = this.f.o();
            WeakReference weakReference = (WeakReference) mapO.get("jsoup.childEls");
            if (weakReference != null && (list = (List) weakReference.get()) != null && (num = (Integer) mapO.get("jsoup.childElsMod")) != null && num.intValue() == this.e.b()) {
                return list;
            }
        }
        return null;
    }

    public final List H() {
        List listG;
        if (this.e.size() == 0) {
            return g;
        }
        synchronized (this.e) {
            try {
                listG = G();
                if (listG == null) {
                    listG = L(n.class);
                    Map mapO = d().o();
                    mapO.put("jsoup.childEls", new WeakReference(listG));
                    mapO.put("jsoup.childElsMod", Integer.valueOf(this.e.b()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listG;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    /* renamed from: I, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public n h() {
        return (n) super.h();
    }

    public final void J(String str) {
        d().m(i, str);
    }

    public final int K() {
        n nVar = this.a;
        if (nVar == null) {
            return 0;
        }
        List listH = nVar.H();
        int size = listH.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listH.get(i2) == this) {
                return i2;
            }
        }
        return 0;
    }

    public final List L(Class cls) {
        int i2 = 0;
        return (List) Collection$EL.stream(this.e).filter(new j(cls, i2)).map(new k(cls, i2)).collect(Collectors.collectingAndThen(Collectors.toList(), new com.github.catvod.spider.merge.n1.g(2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n M() {
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) this.e.get(i2);
            if (sVar instanceof n) {
                return (n) sVar;
            }
        }
        return null;
    }

    public final com.github.catvod.spider.merge.q1.e N(String str) {
        c2.P(str);
        return c2.k(new com.github.catvod.spider.merge.q1.h(str, 2, false), this);
    }

    public final com.github.catvod.spider.merge.q1.e O(String str) {
        c2.P(str);
        return c2.k(new com.github.catvod.spider.merge.q1.h(com.github.catvod.spider.merge.n1.a.d(str), 9, false), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.github.catvod.spider.merge.m.d] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.github.catvod.spider.merge.q1.u] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.github.catvod.spider.merge.m.d, com.github.catvod.spider.merge.o1.u] */
    public final String P() {
        ?? dVar;
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        s sVarL = l();
        if (sVarL != null) {
            com.github.catvod.spider.merge.n1.a aVarE = com.github.catvod.spider.merge.n1.a.e(sbB);
            h hVarW = sVarL.w();
            if (hVarW == null) {
                hVarW = new h();
            }
            g gVar = hVarW.j;
            gVar.getClass();
            if (gVar.c) {
                dVar = new u(sVarL, aVarE, gVar);
                dVar.d = false;
                s sVar = sVarL;
                while (true) {
                    if (sVar != null) {
                        if ((sVar instanceof n) && ((n) sVar).d.b(64)) {
                            dVar.d = true;
                            break;
                        }
                        sVar = sVar.a;
                    } else {
                        break;
                    }
                }
            } else {
                dVar = new com.github.catvod.spider.merge.m.d(sVarL, aVarE, gVar);
            }
            while (sVarL != null) {
                com.github.catvod.spider.merge.b.b.a(dVar, sVarL);
                sVarL = sVarL.q();
            }
        }
        String strL = com.github.catvod.spider.merge.n1.i.l(sbB);
        h hVarW2 = w();
        if (hVarW2 == null) {
            hVarW2 = new h();
        }
        return hVarW2.j.c ? strL.trim() : strL;
    }

    public final boolean Q() {
        return (this.d.d & 4) != 0;
    }

    public void R(com.github.catvod.spider.merge.n1.a aVar, g gVar) throws androidx.startup.b, IOException {
        if (this.e.isEmpty()) {
            return;
        }
        com.github.catvod.spider.merge.n1.a aVarB = aVar.b("</");
        int i2 = gVar.f;
        f0 f0Var = this.d;
        aVarB.b(i2 == 2 ? a.a(2, f0Var.b) : f0Var.b).a('>');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String S() {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            s sVar = (s) this.e.get(i2);
            if (sVar instanceof z) {
                F(sbB, (z) sVar);
            } else if (sVar.o("br") && !z.G(sbB)) {
                sbB.append(Stream.ID_UNKNOWN);
            }
        }
        return com.github.catvod.spider.merge.n1.i.l(sbB).trim();
    }

    public final com.github.catvod.spider.merge.q1.e T(String str) {
        c2.P(str);
        return c2.k(com.github.catvod.spider.merge.q1.v.H(str), this);
    }

    public final String U() {
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        com.github.catvod.spider.merge.g1.a aVar = new com.github.catvod.spider.merge.g1.a();
        aVar.a = sbB;
        com.github.catvod.spider.merge.b.b.a(aVar, this);
        return com.github.catvod.spider.merge.n1.i.l(sbB).trim();
    }

    public final String V() {
        return (String) Collection$EL.stream(this.e).map(new com.github.catvod.spider.merge.n1.g(1)).collect(com.github.catvod.spider.merge.n1.i.k(VideoStream.RESOLUTION_UNKNOWN));
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final c d() {
        if (this.f == null) {
            this.f = new c();
        }
        return this.f;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String e() {
        String strE;
        n nVar = this;
        while (true) {
            if (nVar == null) {
                strE = null;
                break;
            }
            c cVar = nVar.f;
            if (cVar != null) {
                String str = i;
                if (cVar.g(str)) {
                    strE = nVar.f.e(str);
                    break;
                }
            }
            nVar = nVar.a;
        }
        return strE != null ? strE : VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        c2.W(this, n.class).forEach(consumer);
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final int g() {
        return this.e.size();
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final s i(s sVar) {
        n nVar = (n) super.i(sVar);
        m mVar = new m(this.e.size());
        nVar.e = mVar;
        mVar.addAll(this.e);
        c cVar = this.f;
        if (cVar != null) {
            c cVarD = cVar.clone();
            nVar.f = cVarD;
            if (cVarD.g("/jsoup.userdata")) {
                cVarD.o().remove("jsoup.childEls");
            }
        }
        return nVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new t(this, n.class);
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final List k() {
        if (this.e == h) {
            this.e = new m(4);
        }
        return this.e;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final boolean n() {
        return this.f != null;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public String r() {
        return this.d.b;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String s() {
        return V();
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String t() {
        return this.d.c;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public void v(com.github.catvod.spider.merge.n1.a aVar, g gVar) throws androidx.startup.b, IOException {
        int i2 = gVar.f;
        f0 f0Var = this.d;
        String strA = i2 == 2 ? a.a(2, f0Var.b) : f0Var.b;
        aVar.a('<').b(strA);
        c cVar = this.f;
        if (cVar != null) {
            cVar.h(aVar, gVar);
        }
        if (!this.e.isEmpty()) {
            aVar.a('>');
            return;
        }
        boolean z = i2 == 2 || !f0Var.a.equals("http://www.w3.org/1999/xhtml");
        if (z && (f0Var.b(32) || ((1 & f0Var.d) != 0 && (f0Var.c() || f0Var.d())))) {
            aVar.b(" />");
        } else if (z || !f0Var.c()) {
            aVar.b("></").b(strA).a('>');
        } else {
            aVar.a('>');
        }
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final n x() {
        return this.a;
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public /* synthetic */ com.github.catvod.spider.jdollar.util.Spliterator spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
