package com.github.catvod.spider.merge.o1;

import java.io.IOException;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i extends r {
    public static final String e = "/".concat("doctypeInternalSubset");

    public final boolean F(String str) {
        return !com.github.catvod.spider.merge.n1.i.f(b(str));
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String r() {
        return "#doctype";
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final void v(com.github.catvod.spider.merge.n1.a aVar, g gVar) throws androidx.startup.b, IOException {
        if (gVar.f != 1 || F("publicId") || F("systemId")) {
            aVar.b("<!DOCTYPE");
        } else {
            aVar.b("<!doctype");
        }
        if (F("name")) {
            aVar.b(Stream.ID_UNKNOWN).b(b("name"));
        }
        if (F("pubSysKey")) {
            aVar.b(Stream.ID_UNKNOWN).b(b("pubSysKey"));
        }
        if (F("publicId")) {
            aVar.b(" \"").b(b("publicId")).a('\"');
        }
        if (F("systemId")) {
            aVar.b(" \"").b(b("systemId")).a('\"');
        }
        c cVarD = d();
        String str = e;
        if (cVarD.g(str)) {
            aVar.b(" [").b(b(str)).a(']');
        }
        aVar.a('>');
    }
}
