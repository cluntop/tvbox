package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t extends s {
    public static final ConcurrentHashMap i = new ConcurrentHashMap();
    public final e0 e;
    public final boolean f;
    public final Map g;
    public final Map h;

    public t(e0 e0Var, boolean z) {
        super(com.github.catvod.spider.jdollar.time.temporal.q.e, "ZoneText(" + e0Var + ")");
        this.g = new HashMap();
        this.h = new HashMap();
        this.e = (e0) Objects.requireNonNull(e0Var, "textStyle");
        this.f = z;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.s
    public final m a(v vVar) {
        m mVar;
        if (this.e == e0.NARROW) {
            return super.a(vVar);
        }
        Locale locale = vVar.a.b;
        boolean z = vVar.b;
        Set set = com.github.catvod.spider.jdollar.time.zone.h.d;
        int size = set.size();
        Map map = z ? this.g : this.h;
        Map.Entry entry = (Map.Entry) map.get(locale);
        if (entry != null && ((Integer) entry.getKey()).intValue() == size && (mVar = (m) ((SoftReference) entry.getValue()).get()) != null) {
            return mVar;
        }
        m mVar2 = vVar.b ? new m(VideoStream.RESOLUTION_UNKNOWN, null, null) : new l(VideoStream.RESOLUTION_UNKNOWN, null, null);
        for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
            String str = strArr[0];
            if (set.contains(str)) {
                mVar2.a(str, str);
                HashMap map2 = (HashMap) f0.d;
                String str2 = (String) map2.get(str);
                if (str2 == null) {
                    HashMap map3 = (HashMap) f0.g;
                    if (map3.containsKey(str)) {
                        str = (String) map3.get(str);
                        str2 = (String) map2.get(str);
                    }
                }
                if (str2 != null) {
                    Map map4 = (Map) ((HashMap) f0.f).get(str2);
                    str = (map4 == null || !map4.containsKey(locale.getCountry())) ? (String) ((HashMap) f0.e).get(str2) : (String) map4.get(locale.getCountry());
                }
                HashMap map5 = (HashMap) f0.g;
                if (map5.containsKey(str)) {
                    str = (String) map5.get(str);
                }
                for (int i2 = this.e == e0.FULL ? 1 : 2; i2 < strArr.length; i2 += 2) {
                    mVar2.a(strArr[i2], str);
                }
            }
        }
        map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(mVar2)));
        return mVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // com.github.catvod.spider.jdollar.time.format.s, com.github.catvod.spider.jdollar.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(com.github.catvod.spider.jdollar.time.format.w r14, java.lang.StringBuilder r15) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.format.t.h(com.github.catvod.spider.jdollar.time.format.w, java.lang.StringBuilder):boolean");
    }
}
