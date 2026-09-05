package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class s implements e {
    public static volatile Map.Entry c;
    public static volatile Map.Entry d;
    public final com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m a;
    public final String b;

    public s(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar, String str) {
        this.a = mVar;
        this.b = str;
    }

    public static int b(v vVar, CharSequence charSequence, int i, int i2, j jVar) {
        String upperCase = charSequence.subSequence(i, i2).toString().toUpperCase();
        if (i2 >= charSequence.length()) {
            vVar.e(ZoneId.of(upperCase));
            return i2;
        }
        if (charSequence.charAt(i2) == '0' || vVar.a(charSequence.charAt(i2), 'Z')) {
            vVar.e(ZoneId.of(upperCase));
            return i2;
        }
        v vVar2 = new v(vVar.a);
        vVar2.b = vVar.b;
        vVar2.c = vVar.c;
        int i3 = jVar.i(vVar2, charSequence, i2);
        try {
            if (i3 >= 0) {
                vVar.e(ZoneId.V(upperCase, ZoneOffset.ofTotalSeconds((int) vVar2.d(com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS).longValue())));
                return i3;
            }
            if (jVar == j.e) {
                return ~i;
            }
            vVar.e(ZoneId.of(upperCase));
            return i2;
        } catch (DateTimeException unused) {
            return ~i;
        }
    }

    public m a(v vVar) {
        Set<String> set = com.github.catvod.spider.jdollar.time.zone.h.d;
        int size = set.size();
        Map.Entry simpleImmutableEntry = vVar.b ? c : d;
        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
            synchronized (this) {
                try {
                    simpleImmutableEntry = vVar.b ? c : d;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        Integer numValueOf = Integer.valueOf(size);
                        m mVar = vVar.b ? new m(VideoStream.RESOLUTION_UNKNOWN, null, null) : new l(VideoStream.RESOLUTION_UNKNOWN, null, null);
                        for (String str : set) {
                            mVar.a(str, str);
                        }
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(numValueOf, mVar);
                        if (vVar.b) {
                            c = simpleImmutableEntry;
                        } else {
                            d = simpleImmutableEntry;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (m) simpleImmutableEntry.getValue();
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public boolean h(w wVar, StringBuilder sb) {
        ZoneId zoneId = (ZoneId) wVar.b(this.a);
        if (zoneId == null) {
            return false;
        }
        sb.append(zoneId.getId());
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        if (i > length) {
            throw new IndexOutOfBoundsException();
        }
        if (i == length) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == '+' || cCharAt == '-') {
            return b(vVar, charSequence, i, i, j.e);
        }
        int i3 = i + 2;
        if (length >= i3) {
            char cCharAt2 = charSequence.charAt(i + 1);
            if (vVar.a(cCharAt, 'U') && vVar.a(cCharAt2, 'T')) {
                int i4 = i + 3;
                return (length < i4 || !vVar.a(charSequence.charAt(i3), 'C')) ? b(vVar, charSequence, i, i3, j.f) : b(vVar, charSequence, i, i4, j.f);
            }
            if (vVar.a(cCharAt, 'G') && length >= (i2 = i + 3) && vVar.a(cCharAt2, 'M') && vVar.a(charSequence.charAt(i3), 'T')) {
                int i5 = i + 4;
                if (length < i5 || !vVar.a(charSequence.charAt(i2), '0')) {
                    return b(vVar, charSequence, i, i2, j.f);
                }
                vVar.e(ZoneId.of("GMT0"));
                return i5;
            }
        }
        m mVarA = a(vVar);
        ParsePosition parsePosition = new ParsePosition(i);
        String strC = mVarA.c(charSequence, parsePosition);
        if (strC != null) {
            vVar.e(ZoneId.of(strC));
            return parsePosition.getIndex();
        }
        if (!vVar.a(cCharAt, 'Z')) {
            return ~i;
        }
        vVar.e(ZoneOffset.UTC);
        return i + 1;
    }

    public final String toString() {
        return this.b;
    }
}
