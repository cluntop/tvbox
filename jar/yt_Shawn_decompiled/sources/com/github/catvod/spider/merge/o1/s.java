package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.merge.p1.d0;
import com.github.catvod.spider.merge.u.c2;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class s implements Cloneable {
    public static final List c = Collections.EMPTY_LIST;
    public n a;
    public int b;

    public void A(s sVar) {
        c2.I(sVar.a == this);
        n nVar = (n) this;
        if (nVar.e.a) {
            ((ArrayList) k()).remove(sVar.b);
        } else {
            ((ArrayList) k()).remove(sVar);
        }
        nVar.e.a = false;
        sVar.a = null;
    }

    public final void B(n nVar) {
        c2.R(nVar);
        if (this.a == null) {
            this.a = nVar.a;
        }
        c2.R(this.a);
        n nVar2 = this.a;
        nVar2.getClass();
        c2.I(this.a == nVar2);
        if (this == nVar) {
            return;
        }
        n nVar3 = nVar.a;
        if (nVar3 != null) {
            nVar3.A(nVar);
        }
        int iC = C();
        ((ArrayList) nVar2.k()).set(iC, nVar);
        nVar.a = nVar2;
        nVar.b = iC;
        this.a = null;
        nVar2.e.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int C() {
        m mVar;
        n nVar = this.a;
        if (nVar != null) {
            m mVar2 = nVar.e;
            if (!mVar2.a) {
                int size = mVar2.size();
                int i = 0;
                while (true) {
                    mVar = nVar.e;
                    if (i >= size) {
                        break;
                    }
                    ((s) mVar.get(i)).b = i;
                    i++;
                }
                mVar.a = true;
            }
        }
        return this.b;
    }

    public String a(String str) {
        c2.P(str);
        boolean zN = n();
        String str2 = VideoStream.RESOLUTION_UNKNOWN;
        if (!zN || d().k(str) == -1) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        String strE = e();
        String strF = d().f(str);
        Pattern pattern = com.github.catvod.spider.merge.n1.i.d;
        String strReplaceAll = pattern.matcher(strE).replaceAll(VideoStream.RESOLUTION_UNKNOWN);
        String strReplaceAll2 = pattern.matcher(strF).replaceAll(VideoStream.RESOLUTION_UNKNOWN);
        try {
            try {
                return com.github.catvod.spider.merge.n1.i.m(new URL(strReplaceAll), strReplaceAll2).toExternalForm();
            } catch (MalformedURLException unused) {
                return new URL(strReplaceAll2).toExternalForm();
            }
        } catch (MalformedURLException unused2) {
            if (com.github.catvod.spider.merge.n1.i.c.matcher(strReplaceAll2).find()) {
                str2 = strReplaceAll2;
            }
            return str2;
        }
    }

    public String b(String str) {
        c2.R(str);
        if (!n()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        String strF = d().f(str);
        return strF.length() > 0 ? strF : str.startsWith("abs:") ? a(str.substring(4)) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public void c(String str, String str2) {
        h hVarW = w();
        d0 d0Var = hVarW != null ? hVarW.k.c : d0.c;
        d0Var.getClass();
        String strTrim = str.trim();
        if (!d0Var.b) {
            strTrim = com.github.catvod.spider.merge.n1.a.c(strTrim);
        }
        c cVarD = d();
        int iK = cVarD.k(strTrim);
        if (iK == -1) {
            cVarD.a(strTrim, str2);
            return;
        }
        cVarD.c[iK] = str2;
        if (cVarD.b[iK].equals(strTrim)) {
            return;
        }
        cVarD.b[iK] = strTrim;
    }

    public abstract c d();

    public abstract String e();

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final s f(int i) {
        return (s) k().get(i);
    }

    public abstract int g();

    @Override // 
    public s h() {
        s sVarI = i(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(sVarI);
        while (!linkedList.isEmpty()) {
            s sVar = (s) linkedList.remove();
            int iG = sVar.g();
            for (int i = 0; i < iG; i++) {
                List listK = sVar.k();
                s sVarI2 = ((s) listK.get(i)).i(sVar);
                listK.set(i, sVarI2);
                linkedList.add(sVarI2);
            }
        }
        return sVarI;
    }

    public s i(s sVar) {
        h hVarW;
        try {
            s sVar2 = (s) super.clone();
            sVar2.a = (n) sVar;
            sVar2.b = sVar == null ? 0 : C();
            if (sVar == null && !(this instanceof h) && (hVarW = w()) != null) {
                h hVar = new h(hVarW.d.a, hVarW.e(), hVarW.k);
                c cVar = hVarW.f;
                if (cVar != null) {
                    hVar.f = cVar.clone();
                }
                hVar.j = hVarW.j.clone();
                sVar2.a = hVar;
                ((ArrayList) hVar.k()).add(sVar2);
            }
            return sVar2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract List k();

    public final s l() {
        if (g() == 0) {
            return null;
        }
        return (s) k().get(0);
    }

    public final boolean m(String str) {
        c2.R(str);
        if (!n()) {
            return false;
        }
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring(4);
            if (d().k(strSubstring) != -1 && !a(strSubstring).isEmpty()) {
                return true;
            }
        }
        return d().k(str) != -1;
    }

    public abstract boolean n();

    public final boolean o(String str) {
        return t().equals(str);
    }

    public final n p() {
        s sVarQ = this;
        do {
            sVarQ = sVarQ.q();
            if (sVarQ == null) {
                return null;
            }
        } while (!(sVarQ instanceof n));
        return (n) sVarQ;
    }

    public final s q() {
        n nVar = this.a;
        if (nVar == null) {
            return null;
        }
        List listK = nVar.k();
        int iC = C() + 1;
        ArrayList arrayList = (ArrayList) listK;
        if (arrayList.size() > iC) {
            return (s) arrayList.get(iC);
        }
        return null;
    }

    public abstract String r();

    public abstract String s();

    public String t() {
        return r();
    }

    public String toString() {
        return u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.github.catvod.spider.merge.m.d] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.github.catvod.spider.merge.q1.u] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.github.catvod.spider.merge.m.d, com.github.catvod.spider.merge.o1.u] */
    public String u() {
        ?? dVar;
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        com.github.catvod.spider.merge.n1.a aVarE = com.github.catvod.spider.merge.n1.a.e(sbB);
        h hVarW = w();
        if (hVarW == null) {
            hVarW = new h();
        }
        g gVar = hVarW.j;
        gVar.getClass();
        if (gVar.c) {
            dVar = new u(this, aVarE, gVar);
            dVar.d = false;
            s sVar = this;
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
            dVar = new com.github.catvod.spider.merge.m.d(this, aVarE, gVar);
        }
        com.github.catvod.spider.merge.b.b.a(dVar, this);
        return com.github.catvod.spider.merge.n1.i.l(sbB);
    }

    public abstract void v(com.github.catvod.spider.merge.n1.a aVar, g gVar);

    public final h w() {
        for (s sVar = this; sVar != null; sVar = sVar.a) {
            if (sVar instanceof h) {
                return (h) sVar;
            }
        }
        return null;
    }

    public abstract n x();

    public final s y() {
        if (this.a == null || C() <= 0) {
            return null;
        }
        return (s) ((ArrayList) this.a.k()).get(this.b - 1);
    }

    public final void z() {
        n nVar = this.a;
        if (nVar != null) {
            nVar.A(this);
        }
    }
}
