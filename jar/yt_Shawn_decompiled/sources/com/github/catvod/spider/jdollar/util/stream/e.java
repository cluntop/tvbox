package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements BaseStream {
    public final /* synthetic */ java.util.stream.BaseStream a;

    public /* synthetic */ e(java.util.stream.BaseStream baseStream) {
        this.a = baseStream;
    }

    public static /* synthetic */ BaseStream g(java.util.stream.BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof f ? ((f) baseStream).a : baseStream instanceof java.util.stream.DoubleStream ? b0.g((java.util.stream.DoubleStream) baseStream) : baseStream instanceof java.util.stream.IntStream ? b1.g((java.util.stream.IntStream) baseStream) : baseStream instanceof java.util.stream.LongStream ? l1.g((java.util.stream.LongStream) baseStream) : baseStream instanceof java.util.stream.Stream ? y6.g((java.util.stream.Stream) baseStream) : new e(baseStream);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.BaseStream baseStream = this.a;
        if (obj instanceof e) {
            obj = ((e) obj).a;
        }
        return baseStream.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return g(this.a.onClose(runnable));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return com.github.catvod.spider.jdollar.util.b1.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return g(this.a.unordered());
    }
}
