package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k8 extends d7 {
    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final void d() {
        x6 x6Var = new x6();
        this.h = x6Var;
        Objects.requireNonNull(x6Var);
        this.e = this.b.S(new j8(x6Var, 0));
        this.f = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(19, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final d7 e(Spliterator spliterator) {
        return new k8(this.b, spliterator, this.a);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(consumer)) {
            }
            return;
        }
        Objects.requireNonNull(consumer);
        c();
        Objects.requireNonNull(consumer);
        j8 j8Var = new j8(consumer, 1);
        this.b.R(this.d, j8Var);
        this.i = true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean zA = a();
        if (!zA) {
            return zA;
        }
        x6 x6Var = (x6) this.h;
        long j = this.g;
        if (x6Var.c != 0) {
            if (j >= x6Var.count()) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            for (int i = 0; i <= x6Var.c; i++) {
                long j2 = x6Var.d[i];
                Object[] objArr = x6Var.f[i];
                if (j < objArr.length + j2) {
                    obj = objArr[(int) (j - j2)];
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        if (j >= x6Var.b) {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        obj = x6Var.e[(int) j];
        consumer.accept(obj);
        return zA;
    }
}
