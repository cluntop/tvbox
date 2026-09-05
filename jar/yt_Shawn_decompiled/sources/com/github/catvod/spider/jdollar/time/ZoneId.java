package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class ZoneId implements Serializable {
    public static final Map a;
    private static final long serialVersionUID = 8352817235686L;

    static {
        Map.Entry[] entryArr = {com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("ACT", "Australia/Darwin"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("AET", "Australia/Sydney"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("AGT", "America/Argentina/Buenos_Aires"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("ART", "Africa/Cairo"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("AST", "America/Anchorage"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("BET", "America/Sao_Paulo"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("BST", "Asia/Dhaka"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("CAT", "Africa/Harare"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("CNT", "America/St_Johns"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("CST", "America/Chicago"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("CTT", "Asia/Shanghai"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("EAT", "Africa/Addis_Ababa"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("ECT", "Europe/Paris"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("IET", "America/Indiana/Indianapolis"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("IST", "Asia/Kolkata"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("JST", "Asia/Tokyo"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("MIT", "Pacific/Apia"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("NET", "Asia/Yerevan"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("NST", "Pacific/Auckland"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("PLT", "Asia/Karachi"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("PNT", "America/Phoenix"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("PRT", "America/Puerto_Rico"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("PST", "America/Los_Angeles"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("SST", "Pacific/Guadalcanal"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("VST", "Asia/Ho_Chi_Minh"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("EST", "-05:00"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("MST", "-07:00"), com.github.catvod.spider.jdollar.com.android.tools.r8.a.C("HST", "-10:00")};
        HashMap map = new HashMap(28);
        for (int i = 0; i < 28; i++) {
            Map.Entry entry = entryArr[i];
            Object objRequireNonNull = Objects.requireNonNull(entry.getKey());
            if (map.put(objRequireNonNull, Objects.requireNonNull(entry.getValue())) != null) {
                throw new IllegalArgumentException("duplicate key: " + objRequireNonNull);
            }
        }
        a = Collections.unmodifiableMap(map);
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != o.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId S(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.y(q.e);
        if (zoneId != null) {
            return zoneId;
        }
        com.github.catvod.spider.jdollar.nio.file.b.g("Unable to obtain ZoneId from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static ZoneId U(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        return (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) ? ZoneOffset.Z(str) : (str.startsWith("UTC") || str.startsWith("GMT")) ? W(str, 3, z) : str.startsWith("UT") ? W(str, 2, z) : o.Y(str, z);
    }

    public static ZoneId V(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, "offset");
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            com.github.catvod.spider.jdollar.nio.file.b.c("prefix should be GMT, UTC or UT, is: ".concat(str));
            return null;
        }
        if (zoneOffset.getTotalSeconds() != 0) {
            str = str.concat(zoneOffset.c);
        }
        return new o(str, zoneOffset.T());
    }

    public static ZoneId W(String str, int i, boolean z) {
        String strSubstring = str.substring(0, i);
        if (str.length() == i) {
            return V(strSubstring, ZoneOffset.UTC);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return o.Y(str, z);
        }
        try {
            ZoneOffset zoneOffsetZ = ZoneOffset.Z(str.substring(i));
            return zoneOffsetZ == ZoneOffset.UTC ? V(strSubstring, zoneOffsetZ) : V(strSubstring, zoneOffsetZ);
        } catch (DateTimeException e) {
            throw new DateTimeException("Invalid ID for offset-based ZoneId: ".concat(str), e);
        }
    }

    public static ZoneId of(String str) {
        return U(str, true);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static ZoneId systemDefault() {
        String id = TimeZone.getDefault().getID();
        Map map = a;
        Objects.requireNonNull(id, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        return of((String) Objects.requireNonNullElse((String) map.get(id), id));
    }

    private Object writeReplace() {
        return new l((byte) 7, this);
    }

    public abstract com.github.catvod.spider.jdollar.time.zone.f T();

    public abstract void X(DataOutput dataOutput);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public abstract String getId();

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return getId();
    }
}
