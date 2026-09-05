package com.github.catvod.spider.merge.o1;

import java.util.ArrayList;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m extends ArrayList {
    public boolean a;

    public m(int i) {
        super(i);
        this.a = true;
    }

    public final void a() {
        ((ArrayList) this).modCount++;
    }

    public final int b() {
        return ((ArrayList) this).modCount;
    }
}
