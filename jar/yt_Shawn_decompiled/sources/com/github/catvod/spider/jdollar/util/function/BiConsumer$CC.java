package com.github.catvod.spider.jdollar.util.function;

import com.github.catvod.spider.jdollar.nio.file.d0;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* renamed from: com.github.catvod.spider.jdollar.util.function.BiConsumer$-CC, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class BiConsumer$CC {
    public static BiConsumer $default$andThen(BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(biConsumer2);
        return new d0(2, biConsumer, biConsumer2);
    }
}
