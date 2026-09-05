package com.github.catvod.spider.merge.h0;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e implements a {
    public long a;
    public final List b = DesugarCollections.synchronizedList(new ArrayList());

    public final void a(b bVar) {
        this.a++;
        Thread thread = new Thread(bVar);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.a + ")");
        this.b.add(bVar);
        thread.start();
    }
}
