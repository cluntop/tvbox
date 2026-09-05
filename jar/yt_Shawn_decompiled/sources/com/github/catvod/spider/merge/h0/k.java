package com.github.catvod.spider.merge.h0;

import java.util.HashMap;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k extends HashMap {
    public final /* synthetic */ o a;

    public k(o oVar) {
        this.a = oVar;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        this.a.f.put(str == null ? str : str.toLowerCase(), str2);
        return (String) super.put(str, str2);
    }
}
