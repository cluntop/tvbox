package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class s6 extends w6 implements IntConsumer {
    @Override // java.util.function.IntConsumer
    public void accept(int i) {
        y();
        int[] iArr = (int[]) this.e;
        int i2 = this.b;
        this.b = i2 + 1;
        iArr[i2] = i;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            h((IntConsumer) consumer);
        } else {
            if (p8.a) {
                p8.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            }
            com.github.catvod.spider.jdollar.time.chrono.m.f((r6) spliterator(), consumer);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        com.github.catvod.spider.jdollar.util.u0 u0VarSpliterator = spliterator();
        Objects.requireNonNull(u0VarSpliterator);
        return new com.github.catvod.spider.jdollar.util.d1(u0VarSpliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final Object newArray(int i) {
        return new int[i];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final void t(Object obj, int i, int i2, Object obj2) {
        int[] iArr = (int[]) obj;
        IntConsumer intConsumer = (IntConsumer) obj2;
        while (i < i2) {
            intConsumer.accept(iArr[i]);
            i++;
        }
    }

    public final String toString() {
        int[] iArr = (int[]) b();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(iArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(iArr, 200)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final int u(Object obj) {
        return ((int[]) obj).length;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final Object[] x() {
        return new int[8][];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.github.catvod.spider.jdollar.util.u0 spliterator() {
        return new r6(this, 0, this.c, 0, this.b);
    }
}
