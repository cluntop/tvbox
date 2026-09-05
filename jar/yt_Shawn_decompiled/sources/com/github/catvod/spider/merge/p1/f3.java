package com.github.catvod.spider.merge.p1;

import java.io.IOException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum f3 extends l3 {
    public f3() {
        super("DoctypeInternalSubset", 67);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        com.github.catvod.spider.merge.g1.b bVar = t0Var.l.h;
        while (true) {
            char c = 0;
            while (true) {
                char cB = aVar.B();
                if (cB == 0) {
                    t0Var.m(this);
                    bVar.a((char) 65533);
                } else if (cB == '\"') {
                    bVar.a(cB);
                    if (c == 0) {
                        c = 2;
                    } else if (c == 2) {
                        break;
                    }
                } else if (cB == '\'') {
                    bVar.a(cB);
                    if (c == 0) {
                        c = 1;
                    } else if (c == 1) {
                        break;
                    }
                } else if (cB == '-') {
                    bVar.a(cB);
                    if (c == 3 && aVar.M("->")) {
                        bVar.b("->");
                        break;
                    }
                } else if (cB == '<') {
                    bVar.a(cB);
                    if (c == 0) {
                        if (aVar.M("!--")) {
                            bVar.b("!--");
                            c = 3;
                        } else if (aVar.M("?")) {
                            bVar.a('?');
                            c = 4;
                        }
                    }
                } else if (cB == '?') {
                    bVar.a(cB);
                    if (c == 4 && aVar.O('>')) {
                        aVar.j();
                        bVar.a('>');
                        break;
                    }
                } else {
                    e1 e1Var = l3.a;
                    if (cB != ']') {
                        if (cB == 65535) {
                            t0Var.l(this);
                            t0Var.j();
                            t0Var.o(e1Var);
                            return;
                        }
                        bVar.a(cB);
                    } else if (c == 0) {
                        aVar.z();
                        int i = aVar.d;
                        int i2 = aVar.e;
                        char[] cArr = aVar.c;
                        int i3 = i;
                        while (i3 < i2 && com.github.catvod.spider.merge.n1.i.i(cArr[i3])) {
                            i3++;
                        }
                        aVar.d = i3;
                        String strA = i3 > i ? a.A(aVar.c, aVar.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
                        if (aVar.O('>')) {
                            aVar.j();
                            t0Var.j();
                            t0Var.o(e1Var);
                            return;
                        }
                        bVar.a(cB);
                        bVar.b(strA);
                    } else {
                        bVar.a(cB);
                    }
                }
            }
        }
    }
}
