package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class z {
    public static final ConcurrentHashMap a = new ConcurrentHashMap(16, 2);
    public static final x b = new x();
    public static final z c = new z();

    public static Object a(com.github.catvod.spider.jdollar.time.temporal.p pVar, Locale locale) {
        Object yVar;
        long j;
        String strSubstring;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(pVar, locale);
        ConcurrentHashMap concurrentHashMap = a;
        V v = concurrentHashMap.get(simpleImmutableEntry);
        if (v != 0) {
            return v;
        }
        HashMap map = new HashMap();
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            String[] eras = dateFormatSymbols.getEras();
            for (int i = 0; i < eras.length; i++) {
                if (!eras[i].isEmpty()) {
                    long j2 = i;
                    map2.put(Long.valueOf(j2), eras[i]);
                    Long lValueOf = Long.valueOf(j2);
                    String str = eras[i];
                    map3.put(lValueOf, str.substring(0, Character.charCount(str.codePointAt(0))));
                }
            }
            if (!map2.isEmpty()) {
                map.put(e0.FULL, map2);
                map.put(e0.SHORT, map2);
                map.put(e0.NARROW, map3);
            }
            yVar = new y(map);
        } else {
            long j3 = 1;
            if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR) {
                int length = DateFormatSymbols.getInstance(locale).getMonths().length;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (long j4 = 1; j4 <= length; j4++) {
                    String strR = com.github.catvod.spider.jdollar.time.chrono.m.r(j4, "LLLL", locale);
                    linkedHashMap.put(Long.valueOf(j4), strR);
                    linkedHashMap2.put(Long.valueOf(j4), strR.substring(0, Character.charCount(strR.codePointAt(0))));
                    linkedHashMap3.put(Long.valueOf(j4), com.github.catvod.spider.jdollar.time.chrono.m.r(j4, "LLL", locale));
                }
                if (length > 0) {
                    map.put(e0.FULL_STANDALONE, linkedHashMap);
                    map.put(e0.NARROW_STANDALONE, linkedHashMap2);
                    map.put(e0.SHORT_STANDALONE, linkedHashMap3);
                    map.put(e0.FULL, linkedHashMap);
                    map.put(e0.NARROW, linkedHashMap2);
                    map.put(e0.SHORT, linkedHashMap3);
                }
                yVar = new y(map);
            } else if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_WEEK) {
                int length2 = DateFormatSymbols.getInstance(locale).getWeekdays().length;
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                boolean z = locale == Locale.SIMPLIFIED_CHINESE || locale == Locale.TRADITIONAL_CHINESE;
                long j5 = 1;
                while (j5 <= length2) {
                    String strQ = com.github.catvod.spider.jdollar.time.chrono.m.q(j5, "cccc", locale);
                    linkedHashMap4.put(Long.valueOf(j5), strQ);
                    Long lValueOf2 = Long.valueOf(j5);
                    if (z) {
                        j = j3;
                        strSubstring = new StringBuilder().appendCodePoint(strQ.codePointBefore(strQ.length())).toString();
                    } else {
                        j = j3;
                        strSubstring = strQ.substring(0, Character.charCount(strQ.codePointAt(0)));
                    }
                    linkedHashMap5.put(lValueOf2, strSubstring);
                    linkedHashMap6.put(Long.valueOf(j5), com.github.catvod.spider.jdollar.time.chrono.m.q(j5, "ccc", locale));
                    j5 += j;
                    j3 = j;
                }
                if (length2 > 0) {
                    map.put(e0.FULL_STANDALONE, linkedHashMap4);
                    map.put(e0.NARROW_STANDALONE, linkedHashMap5);
                    map.put(e0.SHORT_STANDALONE, linkedHashMap6);
                    map.put(e0.FULL, linkedHashMap4);
                    map.put(e0.NARROW, linkedHashMap5);
                    map.put(e0.SHORT, linkedHashMap6);
                }
                yVar = new y(map);
            } else if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.AMPM_OF_DAY) {
                DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
                HashMap map4 = new HashMap();
                HashMap map5 = new HashMap();
                String[] amPmStrings = dateFormatSymbols2.getAmPmStrings();
                for (int i2 = 0; i2 < amPmStrings.length; i2++) {
                    if (!amPmStrings[i2].isEmpty()) {
                        long j6 = i2;
                        map4.put(Long.valueOf(j6), amPmStrings[i2]);
                        Long lValueOf3 = Long.valueOf(j6);
                        String str2 = amPmStrings[i2];
                        map5.put(lValueOf3, str2.substring(0, Character.charCount(str2.codePointAt(0))));
                    }
                }
                if (!map4.isEmpty()) {
                    map.put(e0.FULL, map4);
                    map.put(e0.SHORT, map4);
                    map.put(e0.NARROW, map5);
                }
                yVar = new y(map);
            } else {
                yVar = VideoStream.RESOLUTION_UNKNOWN;
            }
        }
        concurrentHashMap.putIfAbsent(simpleImmutableEntry, yVar);
        return concurrentHashMap.get(simpleImmutableEntry);
    }

    public String b(com.github.catvod.spider.jdollar.time.chrono.l lVar, com.github.catvod.spider.jdollar.time.temporal.p pVar, long j, e0 e0Var, Locale locale) {
        if (lVar == com.github.catvod.spider.jdollar.time.chrono.t.c || !(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return c(pVar, j, e0Var, locale);
        }
        return null;
    }

    public String c(com.github.catvod.spider.jdollar.time.temporal.p pVar, long j, e0 e0Var, Locale locale) {
        Object objA = a(pVar, locale);
        if (objA instanceof y) {
            return ((y) objA).a(j, e0Var);
        }
        return null;
    }

    public Iterator d(com.github.catvod.spider.jdollar.time.chrono.l lVar, com.github.catvod.spider.jdollar.time.temporal.p pVar, e0 e0Var, Locale locale) {
        if (lVar == com.github.catvod.spider.jdollar.time.chrono.t.c || !(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return e(pVar, e0Var, locale);
        }
        return null;
    }

    public Iterator e(com.github.catvod.spider.jdollar.time.temporal.p pVar, e0 e0Var, Locale locale) {
        List list;
        Object objA = a(pVar, locale);
        if (!(objA instanceof y) || (list = (List) ((HashMap) ((y) objA).b).get(e0Var)) == null) {
            return null;
        }
        return list.iterator();
    }
}
