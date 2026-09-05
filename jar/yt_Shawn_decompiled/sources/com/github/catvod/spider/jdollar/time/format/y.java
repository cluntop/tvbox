package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y {
    public final Map a;
    public final Map b;

    public y(Map map) {
        this.a = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l = (Long) entry2.getKey();
                ConcurrentHashMap concurrentHashMap = z.a;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, z.b);
            map2.put((e0) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, z.b);
        this.b = map2;
    }

    public final String a(long j, e0 e0Var) {
        Map map = (Map) this.a.get(e0Var);
        if (map != null) {
            return (String) map.get(Long.valueOf(j));
        }
        return null;
    }
}
