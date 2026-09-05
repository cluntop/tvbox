package com.github.catvod.spider.jdollar.sun.security.action;

import com.github.catvod.spider.jdollar.time.zone.h;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements PrivilegedAction {
    public final /* synthetic */ int a = 0;
    public Object b;

    public a(List list) {
        this.b = list;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                String property = System.getProperty((String) this.b);
                if (property == null) {
                    return null;
                }
                return property;
            default:
                String property2 = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
                if (property2 != null) {
                    try {
                        h hVar = (h) h.class.cast(Class.forName(property2, true, h.class.getClassLoader()).newInstance());
                        h.b(hVar);
                        ((ArrayList) ((List) this.b)).add(hVar);
                    } catch (Exception e) {
                        throw new Error(e);
                    }
                } else {
                    h.b(new h());
                }
                return null;
        }
    }

    public /* synthetic */ a() {
    }
}
