package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.merge.u.c2;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class r extends s {
    public Object d;

    public r(String str) {
        c2.R(str);
        this.d = str;
    }

    public final String D() {
        return b(r());
    }

    public final void E() {
        Object obj = this.d;
        if (obj instanceof c) {
            return;
        }
        c cVar = new c();
        this.d = cVar;
        cVar.m(r(), (String) obj);
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String a(String str) {
        E();
        return super.a(str);
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String b(String str) {
        return !(this.d instanceof c) ? r().equals(str) ? (String) this.d : VideoStream.RESOLUTION_UNKNOWN : super.b(str);
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final void c(String str, String str2) {
        E();
        super.c("pubSysKey", str2);
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final c d() {
        E();
        return (c) this.d;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String e() {
        n nVar = this.a;
        return nVar != null ? nVar.e() : VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final int g() {
        return 0;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final s i(s sVar) {
        r rVar = (r) super.i(sVar);
        Object obj = this.d;
        if (obj instanceof c) {
            rVar.d = ((c) obj).clone();
        }
        return rVar;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final List k() {
        return s.c;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final boolean n() {
        return this.d instanceof c;
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final String s() {
        return D();
    }

    @Override // com.github.catvod.spider.merge.o1.s
    public final n x() {
        return this.a;
    }
}
