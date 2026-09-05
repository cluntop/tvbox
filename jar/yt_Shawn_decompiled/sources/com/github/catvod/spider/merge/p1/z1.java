package com.github.catvod.spider.merge.p1;

import java.io.IOException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum z1 extends l3 {
    public z1() {
        super("AttributeValue_singleQuoted", 38);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        char c;
        aVar.T();
        aVar.z();
        int i = aVar.d;
        int i2 = aVar.e;
        char[] cArr = aVar.c;
        int i3 = i;
        while (i3 < i2 && (c = cArr[i3]) != 0 && c != '&' && c != '\'') {
            i3++;
        }
        aVar.d = i3;
        String strA = i3 > i ? a.A(aVar.c, aVar.a, i, i3 - i) : VideoStream.RESOLUTION_UNKNOWN;
        if (strA.length() > 0) {
            t0Var.j.i.b(strA);
        } else {
            t0Var.j.j = true;
        }
        int iT = aVar.T();
        char cB = aVar.B();
        if (cB == 0) {
            t0Var.m(this);
            t0Var.j.g(iT, aVar.T(), (char) 65533);
            return;
        }
        if (cB == 65535) {
            t0Var.l(this);
            t0Var.o(l3.a);
            return;
        }
        if (cB != '&') {
            if (cB != '\'') {
                t0Var.j.g(iT, aVar.T(), cB);
                return;
            } else {
                t0Var.o(l3.O);
                return;
            }
        }
        int[] iArrC = t0Var.c('\'', true);
        p0 p0Var = t0Var.j;
        if (iArrC != null) {
            p0Var.h(iArrC, iT, aVar.T());
        } else {
            p0Var.g(iT, aVar.T(), '&');
        }
    }
}
