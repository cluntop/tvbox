package com.github.catvod.spider.merge.y0;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q {
    public final boolean a;
    public final boolean b;
    public final g0 c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final Long g;
    public final Map h;

    public q(boolean z, boolean z2, g0 g0Var, Long l, Long l2, Long l3, Long l4, Map map) {
        map.getClass();
        this.a = z;
        this.b = z2;
        this.c = g0Var;
        this.d = l;
        this.e = l2;
        this.f = l3;
        this.g = l4;
        this.h = MapsKt.toMap(map);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.a) {
            arrayList.add("isRegularFile");
        }
        if (this.b) {
            arrayList.add("isDirectory");
        }
        Long l = this.d;
        if (l != null) {
            arrayList.add("byteCount=" + l.longValue());
        }
        Long l2 = this.e;
        if (l2 != null) {
            arrayList.add("createdAt=" + l2.longValue());
        }
        Long l3 = this.f;
        if (l3 != null) {
            arrayList.add("lastModifiedAt=" + l3.longValue());
        }
        Long l4 = this.g;
        if (l4 != null) {
            arrayList.add("lastAccessedAt=" + l4.longValue());
        }
        Map map = this.h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return CollectionsKt.l(arrayList, ", ", "FileMetadata(", ")", (Function1) null, 56);
    }

    public /* synthetic */ q(boolean z, boolean z2, g0 g0Var, Long l, Long l2, Long l3, Long l4) {
        this(z, z2, g0Var, l, l2, l3, l4, MapsKt.emptyMap());
    }
}
