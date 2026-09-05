package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.DesugarArrays;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class j2 implements g2 {
    public final Object[] a;
    public int b;

    public j2(long j, IntFunction intFunction) {
        if (j >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            throw null;
        }
        this.a = (Object[]) intFunction.apply((int) j);
        this.b = 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final g2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final long count() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void forEach(Consumer consumer) {
        for (int i = 0; i < this.b; i++) {
            consumer.accept(this.a[i]);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.w(this, j, j2, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void m(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, i, this.b);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Object[] q(IntFunction intFunction) {
        Object[] objArr = this.a;
        if (objArr.length == this.b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ int s() {
        return 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Spliterator spliterator() {
        return DesugarArrays.a(this.a, 0, this.b);
    }

    public String toString() {
        Object[] objArr = this.a;
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(objArr.length - this.b), Arrays.toString(objArr));
    }

    public j2(Object[] objArr) {
        this.a = objArr;
        this.b = objArr.length;
    }
}
