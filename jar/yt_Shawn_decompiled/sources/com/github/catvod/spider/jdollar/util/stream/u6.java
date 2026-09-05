package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class u6 extends w6 implements LongConsumer {
    @Override // java.util.function.LongConsumer
    public void accept(long j) {
        y();
        long[] jArr = (long[]) this.e;
        int i = this.b;
        this.b = i + 1;
        jArr[i] = j;
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            h((LongConsumer) consumer);
        } else {
            if (p8.a) {
                p8.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
            com.github.catvod.spider.jdollar.time.chrono.m.g((t6) spliterator(), consumer);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        com.github.catvod.spider.jdollar.util.x0 x0VarSpliterator = spliterator();
        Objects.requireNonNull(x0VarSpliterator);
        return new com.github.catvod.spider.jdollar.util.e1(x0VarSpliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final Object newArray(int i) {
        return new long[i];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final void t(Object obj, int i, int i2, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i < i2) {
            longConsumer.accept(jArr[i]);
            i++;
        }
    }

    public final String toString() {
        long[] jArr = (long[]) b();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(jArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final int u(Object obj) {
        return ((long[]) obj).length;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final Object[] x() {
        return new long[8][];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.github.catvod.spider.jdollar.util.x0 spliterator() {
        return new t6(this, 0, this.c, 0, this.b);
    }
}
