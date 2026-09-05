package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.stream.Collector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class z6 {
    public static Set a(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof Collector.Characteristics) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    Collector.Characteristics characteristics = (Collector.Characteristics) it.next();
                    hashSet.add(characteristics == null ? null : characteristics == Collector.Characteristics.CONCURRENT ? Collector.Characteristics.CONCURRENT : characteristics == Collector.Characteristics.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                } catch (ClassCastException e) {
                    com.github.catvod.spider.jdollar.util.h.a(e, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        } else {
            if (!(next instanceof Collector.Characteristics)) {
                com.github.catvod.spider.jdollar.util.h.a(next.getClass(), "java.util.stream.Collector.Characteristics");
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    Collector.Characteristics characteristics2 = (Collector.Characteristics) it2.next();
                    hashSet.add(characteristics2 == null ? null : characteristics2 == Collector.Characteristics.CONCURRENT ? Collector.Characteristics.CONCURRENT : characteristics2 == Collector.Characteristics.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                } catch (ClassCastException e2) {
                    com.github.catvod.spider.jdollar.util.h.a(e2, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        }
        return hashSet;
    }
}
