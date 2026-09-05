package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k implements java.util.Map, Serializable, Map {
    private static final long serialVersionUID = 1978198479659022715L;
    public final java.util.Map a;
    public final k b = this;
    public transient m c;
    public transient m d;
    public transient i e;

    public k(java.util.Map map) {
        this.a = (java.util.Map) Objects.requireNonNull(map);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.b) {
            objectOutputStream.defaultWriteObject();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r5 = r3;
     */
    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object compute(java.lang.Object r5, java.util.function.BiFunction r6) {
        /*
            r4 = this;
            com.github.catvod.spider.jdollar.util.k r0 = r4.b
            monitor-enter(r0)
            java.util.Map r1 = r4.a     // Catch: java.lang.Throwable -> L41
            boolean r2 = r1 instanceof com.github.catvod.spider.jdollar.util.Map     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L10
            com.github.catvod.spider.jdollar.util.Map r1 = (com.github.catvod.spider.jdollar.util.Map) r1     // Catch: java.lang.Throwable -> L41
            java.lang.Object r5 = r1.compute(r5, r6)     // Catch: java.lang.Throwable -> L41
            goto L3f
        L10:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L3b
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L41
        L16:
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L41
        L1a:
            java.lang.Object r3 = r6.apply(r5, r2)     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L31
            if (r2 == 0) goto L29
            boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L16
            goto L2f
        L29:
            java.lang.Object r2 = r1.putIfAbsent(r5, r3)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L1a
        L2f:
            r5 = r3
            goto L3f
        L31:
            if (r2 == 0) goto L39
            boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L16
        L39:
            r5 = 0
            goto L3f
        L3b:
            java.lang.Object r5 = com.github.catvod.spider.jdollar.util.Map.CC.$default$compute(r1, r5, r6)     // Catch: java.lang.Throwable -> L41
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L41
            return r5
        L41:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L41
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.k.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object computeIfAbsent(Object obj, Function function) {
        Object objComputeIfAbsent;
        synchronized (this.b) {
            objComputeIfAbsent = Map.EL.computeIfAbsent(this.a, obj, function);
        }
        return objComputeIfAbsent;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        Object obj$default$computeIfPresent;
        Object objApply;
        synchronized (this.b) {
            java.util.Map map = this.a;
            if (map instanceof Map) {
                obj$default$computeIfPresent = ((Map) map).computeIfPresent(obj, biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                while (true) {
                    Object obj2 = concurrentMap.get(obj);
                    if (obj2 == null) {
                        obj$default$computeIfPresent = null;
                        break;
                    }
                    objApply = biFunction.apply(obj, obj2);
                    if (objApply == null) {
                        if (concurrentMap.remove(obj, obj2)) {
                            break;
                        }
                    } else if (concurrentMap.replace(obj, obj2, objApply)) {
                        break;
                    }
                }
                obj$default$computeIfPresent = objApply;
            } else {
                obj$default$computeIfPresent = Map.CC.$default$computeIfPresent(map, obj, biFunction);
            }
        }
        return obj$default$computeIfPresent;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        boolean zContainsKey;
        synchronized (this.b) {
            zContainsKey = this.a.containsKey(obj);
        }
        return zContainsKey;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        boolean zContainsValue;
        synchronized (this.b) {
            zContainsValue = this.a.containsValue(obj);
        }
        return zContainsValue;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        m mVar;
        synchronized (this.b) {
            try {
                if (this.d == null) {
                    this.d = new m(this.a.entrySet(), this.b);
                }
                mVar = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        synchronized (this.b) {
            zEquals = this.a.equals(obj);
        }
        return zEquals;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final void forEach(BiConsumer biConsumer) {
        synchronized (this.b) {
            Map.EL.a(this.a, biConsumer);
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        synchronized (this.b) {
            obj2 = this.a.get(obj);
        }
        return obj2;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        Object orDefault;
        synchronized (this.b) {
            orDefault = Map.EL.getOrDefault(this.a, obj, obj2);
        }
        return orDefault;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int iHashCode;
        synchronized (this.b) {
            iHashCode = this.a.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.b) {
            zIsEmpty = this.a.isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Map
    public final Set keySet() {
        m mVar;
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    this.c = new m(this.a.keySet(), this.b);
                }
                mVar = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        Object objB;
        synchronized (this.b) {
            objB = Map.EL.b(this.a, obj, obj2, biFunction);
        }
        return objB;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        Object objPut;
        synchronized (this.b) {
            objPut = this.a.put(obj, obj2);
        }
        return objPut;
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        synchronized (this.b) {
            this.a.putAll(map);
        }
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        Object objC;
        synchronized (this.b) {
            objC = Map.EL.c(this.a, obj, obj2);
        }
        return objC;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        Object objRemove;
        synchronized (this.b) {
            objRemove = this.a.remove(obj);
        }
        return objRemove;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        boolean zReplace;
        synchronized (this.b) {
            java.util.Map map = this.a;
            zReplace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
        }
        return zReplace;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final void replaceAll(BiFunction biFunction) {
        synchronized (this.b) {
            java.util.Map map = this.a;
            if (map instanceof Map) {
                ((Map) map).replaceAll(biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                com.github.catvod.spider.jdollar.nio.file.d0 d0Var = new com.github.catvod.spider.jdollar.nio.file.d0(1, concurrentMap, biFunction);
                if (concurrentMap instanceof ConcurrentHashMap) {
                    ((ConcurrentHashMap) concurrentMap).forEach(d0Var);
                } else {
                    com.github.catvod.spider.jdollar.time.chrono.m.d(concurrentMap, d0Var);
                }
            } else {
                Map.CC.$default$replaceAll(map, biFunction);
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        int size;
        synchronized (this.b) {
            size = this.a.size();
        }
        return size;
    }

    public final String toString() {
        String string;
        synchronized (this.b) {
            string = this.a.toString();
        }
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        i iVar;
        synchronized (this.b) {
            try {
                if (this.e == null) {
                    this.e = new i(this.a.values(), this.b);
                }
                iVar = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        boolean zRemove;
        synchronized (this.b) {
            zRemove = Map.EL.remove(this.a, obj, obj2);
        }
        return zRemove;
    }

    @Override // java.util.Map, com.github.catvod.spider.jdollar.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        Object objReplace;
        synchronized (this.b) {
            java.util.Map map = this.a;
            objReplace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
        }
        return objReplace;
    }
}
