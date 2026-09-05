package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.merge.u.c2;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i extends p {
    public final String a;
    public final String b;
    public final /* synthetic */ int c;

    public i(String str, String str2, int i) {
        this.c = i;
        c2.P(str);
        this.a = com.github.catvod.spider.merge.n1.a.d(str);
        if ((str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""))) {
            c2.H("Quoted value must have content", str2.length() > 1);
            str2 = str2.substring(1, str2.length() - 1);
        }
        this.b = com.github.catvod.spider.merge.n1.a.c(str2);
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        switch (this.c) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return 3;
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        int i = this.c;
        String str = this.b;
        String str2 = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return nVar2.m(str2) && str.equalsIgnoreCase(nVar2.b(str2));
            case 1:
                return nVar2.m(str2) && com.github.catvod.spider.merge.n1.a.c(nVar2.b(str2)).contains(str);
            case 2:
                return nVar2.m(str2) && com.github.catvod.spider.merge.n1.a.c(nVar2.b(str2)).endsWith(str);
            case 3:
                return !str.equalsIgnoreCase(nVar2.b(str2));
            default:
                return nVar2.m(str2) && com.github.catvod.spider.merge.n1.a.c(nVar2.b(str2)).startsWith(str);
        }
    }

    public final String toString() {
        int i = this.c;
        String str = this.b;
        String str2 = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return "[" + str2 + "=" + str + "]";
            case 1:
                return "[" + str2 + "*=" + str + "]";
            case 2:
                return "[" + str2 + "$=" + str + "]";
            case 3:
                return "[" + str2 + "!=" + str + "]";
            default:
                return "[" + str2 + "^=" + str + "]";
        }
    }
}
