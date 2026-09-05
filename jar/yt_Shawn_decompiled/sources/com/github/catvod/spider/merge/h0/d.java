package com.github.catvod.spider.merge.h0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d implements Iterable {
    public final HashMap a = new HashMap();
    public final ArrayList b = new ArrayList();

    public d(HashMap map) {
        String str = (String) map.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] strArrSplit = str2.trim().split("=");
                if (strArrSplit.length == 2) {
                    this.a.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    public final void a() {
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.a.keySet().iterator();
    }
}
