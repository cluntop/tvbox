package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u implements Serializable {
    public static final ConcurrentHashMap g = new ConcurrentHashMap(4, 2);
    public static final h h;
    private static final long serialVersionUID = -1177360819670808121L;
    public final com.github.catvod.spider.jdollar.time.c a;
    public final int b;
    public final transient t c;
    public final transient t d;
    public final transient t e;
    public final transient t f;

    static {
        new u(com.github.catvod.spider.jdollar.time.c.MONDAY, 4);
        a(com.github.catvod.spider.jdollar.time.c.SUNDAY, 1);
        h = i.d;
    }

    public u(com.github.catvod.spider.jdollar.time.c cVar, int i) {
        ChronoUnit chronoUnit = ChronoUnit.DAYS;
        ChronoUnit chronoUnit2 = ChronoUnit.WEEKS;
        this.c = new t("DayOfWeek", this, chronoUnit, chronoUnit2, t.f);
        this.d = new t("WeekOfMonth", this, chronoUnit2, ChronoUnit.MONTHS, t.g);
        h hVar = i.d;
        this.e = new t("WeekOfWeekBasedYear", this, chronoUnit2, hVar, t.i);
        this.f = new t("WeekBasedYear", this, hVar, ChronoUnit.FOREVER, a.YEAR.b);
        Objects.requireNonNull(cVar, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Minimal number of days is invalid");
            throw null;
        }
        this.a = cVar;
        this.b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static u a(com.github.catvod.spider.jdollar.time.c cVar, int i) {
        String str = cVar.toString() + i;
        ConcurrentHashMap concurrentHashMap = g;
        u uVar = (u) concurrentHashMap.get(str);
        if (uVar != null) {
            return uVar;
        }
        concurrentHashMap.putIfAbsent(str, new u(cVar, i));
        return (u) concurrentHashMap.get(str);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.a == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i = this.b;
        if (i < 1 || i > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return a(this.a, this.b);
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException("Invalid serialized WeekFields: " + e.getMessage());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && hashCode() == obj.hashCode();
    }

    public final int hashCode() {
        return (this.a.ordinal() * 7) + this.b;
    }

    public final String toString() {
        return "WeekFields[" + this.a + "," + this.b + "]";
    }
}
