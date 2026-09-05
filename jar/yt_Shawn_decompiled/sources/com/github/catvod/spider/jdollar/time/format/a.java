package com.github.catvod.spider.jdollar.time.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a extends z {
    public final /* synthetic */ y d;

    public a(y yVar) {
        this.d = yVar;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.z
    public final String b(com.github.catvod.spider.jdollar.time.chrono.l lVar, com.github.catvod.spider.jdollar.time.temporal.p pVar, long j, e0 e0Var, Locale locale) {
        return this.d.a(j, e0Var);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.z
    public final String c(com.github.catvod.spider.jdollar.time.temporal.p pVar, long j, e0 e0Var, Locale locale) {
        return this.d.a(j, e0Var);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.z
    public final Iterator d(com.github.catvod.spider.jdollar.time.chrono.l lVar, com.github.catvod.spider.jdollar.time.temporal.p pVar, e0 e0Var, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(e0Var);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.z
    public final Iterator e(com.github.catvod.spider.jdollar.time.temporal.p pVar, e0 e0Var, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(e0Var);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
