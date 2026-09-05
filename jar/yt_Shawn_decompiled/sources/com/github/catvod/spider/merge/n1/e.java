package com.github.catvod.spider.merge.n1;

import com.github.catvod.spider.jdollar.util.function.BiConsumer$CC;
import com.github.catvod.spider.merge.u.c2;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        h hVar = (h) obj;
        CharSequence charSequence = (CharSequence) obj2;
        c2.R(hVar.a);
        if (!hVar.c) {
            hVar.a.append(hVar.b);
        }
        hVar.a.append((Object) charSequence);
        hVar.c = false;
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }
}
