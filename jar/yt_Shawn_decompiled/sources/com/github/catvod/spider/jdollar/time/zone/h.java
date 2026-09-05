package com.github.catvod.spider.jdollar.time.zone;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h {
    public static final CopyOnWriteArrayList b;
    public static final ConcurrentHashMap c;
    public static volatile Set d;
    public final Set a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        b = copyOnWriteArrayList;
        c = new ConcurrentHashMap(512, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new com.github.catvod.spider.jdollar.sun.security.action.a(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    public h() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(str);
        }
        this.a = Collections.unmodifiableSet(linkedHashSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f a(String str) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = c;
        h hVar = (h) concurrentHashMap.get(str);
        if (hVar == null) {
            if (concurrentHashMap.isEmpty()) {
                throw new g("No time-zone data files registered");
            }
            throw new g("Unknown time-zone ID: " + str);
        }
        if (hVar.a.contains(str)) {
            return new f(TimeZone.getTimeZone(str));
        }
        throw new g("Not a built-in time zone: " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(h hVar) {
        Objects.requireNonNull(hVar, "provider");
        synchronized (h.class) {
            try {
                for (String str : hVar.a) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((h) c.putIfAbsent(str, hVar)) != null) {
                        throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + hVar);
                    }
                }
                d = Collections.unmodifiableSet(new HashSet(c.keySet()));
            } catch (Throwable th) {
                throw th;
            }
        }
        b.add(hVar);
    }
}
