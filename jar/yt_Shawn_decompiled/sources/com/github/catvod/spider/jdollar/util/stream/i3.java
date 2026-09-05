package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Deque;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i3 extends j3 {
    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.a == null) {
            return;
        }
        if (this.d != null) {
            while (tryAdvance(consumer)) {
            }
            return;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            spliterator.forEachRemaining(consumer);
            return;
        }
        Deque dequeB = b();
        while (true) {
            g2 g2VarA = j3.a(dequeB);
            if (g2VarA == null) {
                this.a = null;
                return;
            }
            g2VarA.forEach(consumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        g2 g2VarA;
        if (!c()) {
            return false;
        }
        boolean zTryAdvance = this.d.tryAdvance(consumer);
        if (!zTryAdvance) {
            if (this.c == null && (g2VarA = j3.a(this.e)) != null) {
                Spliterator spliterator = g2VarA.spliterator();
                this.d = spliterator;
                return spliterator.tryAdvance(consumer);
            }
            this.a = null;
        }
        return zTryAdvance;
    }
}
