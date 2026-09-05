package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.Iterator;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h extends p {
    public final /* synthetic */ int a;
    public final String b;

    public h(String str, int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.b = com.github.catvod.spider.merge.n1.a.c(str);
                break;
            case 4:
                StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
                com.github.catvod.spider.merge.n1.i.a(sbB, str, false);
                this.b = com.github.catvod.spider.merge.n1.a.c(com.github.catvod.spider.merge.n1.i.l(sbB));
                break;
            case 5:
                StringBuilder sbB2 = com.github.catvod.spider.merge.n1.i.b();
                com.github.catvod.spider.merge.n1.i.a(sbB2, str, false);
                this.b = com.github.catvod.spider.merge.n1.a.c(com.github.catvod.spider.merge.n1.i.l(sbB2));
                break;
            default:
                this.b = com.github.catvod.spider.merge.n1.a.c(str);
                break;
        }
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public int a() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return 2;
            case 1:
                return 6;
            case 2:
                return 8;
            case 3:
            case 4:
            case 6:
            default:
                return super.a();
            case 5:
                return 10;
            case 7:
                return 10;
            case 8:
                return 2;
            case 9:
                return 1;
        }
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        int i = this.a;
        String strF = VideoStream.RESOLUTION_UNKNOWN;
        int i2 = 1;
        String str = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return nVar2.m(str);
            case 1:
                com.github.catvod.spider.merge.o1.c cVarD = nVar2.d();
                cVarD.getClass();
                ArrayList arrayList = new ArrayList(cVarD.a);
                for (int i3 = 0; i3 < cVarD.a; i3++) {
                    String str2 = cVarD.b[i3];
                    if (!com.github.catvod.spider.merge.o1.c.l(str2)) {
                        arrayList.add(new com.github.catvod.spider.merge.o1.a(str2, (String) cVarD.c[i3], cVarD));
                    }
                }
                Iterator it = DesugarCollections.unmodifiableList(arrayList).iterator();
                while (it.hasNext()) {
                    if (com.github.catvod.spider.merge.n1.a.c(((com.github.catvod.spider.merge.o1.a) it.next()).a).startsWith(str)) {
                        return true;
                    }
                }
                return false;
            case 2:
                com.github.catvod.spider.merge.o1.c cVar = nVar2.f;
                if (cVar == null) {
                    return false;
                }
                String strF2 = cVar.f("class");
                int length = strF2.length();
                String str3 = this.b;
                int length2 = str3.length();
                if (length == 0 || length < length2) {
                    return false;
                }
                if (length == length2) {
                    return str3.equalsIgnoreCase(strF2);
                }
                boolean z = false;
                int i4 = 0;
                for (int i5 = 0; i5 < length; i5++) {
                    if (Character.isWhitespace(strF2.charAt(i5))) {
                        if (!z) {
                            continue;
                        } else {
                            if (i5 - i4 == length2 && strF2.regionMatches(true, i4, str3, 0, length2)) {
                                return true;
                            }
                            z = false;
                        }
                    } else if (!z) {
                        i4 = i5;
                        z = true;
                    }
                }
                if (z && length - i4 == length2) {
                    return strF2.regionMatches(true, i4, str3, 0, length2);
                }
                return false;
            case 3:
                nVar2.getClass();
                StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
                com.github.catvod.spider.merge.b.b.a(new com.github.catvod.spider.merge.o1.l(0, sbB), nVar2);
                return com.github.catvod.spider.merge.n1.a.c(com.github.catvod.spider.merge.n1.i.l(sbB)).contains(str);
            case 4:
                return com.github.catvod.spider.merge.n1.a.c(nVar2.S()).contains(str);
            case 5:
                return com.github.catvod.spider.merge.n1.a.c(nVar2.U()).contains(str);
            case 6:
                return nVar2.V().contains(str);
            case 7:
                nVar2.getClass();
                return ((String) c2.W(nVar2, com.github.catvod.spider.merge.o1.s.class).map(new com.github.catvod.spider.merge.n1.g(i2)).collect(com.github.catvod.spider.merge.n1.i.k(VideoStream.RESOLUTION_UNKNOWN))).contains(str);
            case 8:
                com.github.catvod.spider.merge.o1.c cVar2 = nVar2.f;
                if (cVar2 != null) {
                    strF = cVar2.f("id");
                }
                return str.equals(strF);
            case 9:
                return nVar2.o(str);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return nVar2.d.c.endsWith(str);
            default:
                return nVar2.d.c.startsWith(str);
        }
    }

    public final String toString() {
        int i = this.a;
        String str = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return com.github.catvod.spider.merge.b.b.A("[", str, "]");
            case 1:
                return com.github.catvod.spider.merge.b.b.A("[^", str, "]");
            case 2:
                return com.github.catvod.spider.merge.b.b.n(".", str);
            case 3:
                return com.github.catvod.spider.merge.b.b.A(":containsData(", str, ")");
            case 4:
                return com.github.catvod.spider.merge.b.b.A(":containsOwn(", str, ")");
            case 5:
                return com.github.catvod.spider.merge.b.b.A(":contains(", str, ")");
            case 6:
                return com.github.catvod.spider.merge.b.b.A(":containsWholeOwnText(", str, ")");
            case 7:
                return com.github.catvod.spider.merge.b.b.A(":containsWholeText(", str, ")");
            case 8:
                return "#".concat(str);
            case 9:
                return str;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return "*|".concat(str);
            default:
                return str.concat("|*");
        }
    }

    public /* synthetic */ h(String str, int i, boolean z) {
        this.a = i;
        this.b = str;
    }
}
