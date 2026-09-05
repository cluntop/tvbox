package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public Set a;
    public Map b;
    public boolean c;

    public final void a(Object obj, String str) {
        ((HashMap) this.b).put(str, obj);
    }

    public final boolean b(String str) {
        return this.c || ((HashSet) this.a).contains(str);
    }
}
