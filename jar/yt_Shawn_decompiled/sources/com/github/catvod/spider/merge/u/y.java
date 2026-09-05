package com.github.catvod.spider.merge.u;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y {
    public static volatile y b;
    public static final y c = new y();
    public final Map a = Collections.EMPTY_MAP;

    public static y a() {
        y yVar;
        Class cls = e.a;
        y yVar2 = b;
        if (yVar2 != null) {
            return yVar2;
        }
        synchronized (y.class) {
            try {
                yVar = b;
                if (yVar == null) {
                    Class cls2 = x.a;
                    y yVar3 = null;
                    if (cls2 != null) {
                        try {
                            yVar3 = (y) cls2.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    yVar = yVar3 != null ? yVar3 : c;
                    b = yVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }
}
