package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class s7 implements k5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ IntConsumer b;

    public /* synthetic */ s7(IntConsumer intConsumer, int i) {
        this.a = i;
        this.b = intConsumer;
    }

    private final /* synthetic */ void a(long j) {
    }

    private final /* synthetic */ void b(long j) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        int i2 = this.a;
        IntConsumer intConsumer = this.b;
        switch (i2) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                intConsumer.accept(i);
                break;
            default:
                ((s6) intConsumer).accept(i);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void c(long j) {
        int i = this.a;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                v3.g(this, num);
                break;
            default:
                v3.g(this, num);
                break;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.a) {
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void end() {
        int i = this.a;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                v3.c();
                throw null;
            default:
                v3.c();
                throw null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                v3.l();
                throw null;
            default:
                v3.l();
                throw null;
        }
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                d((Integer) obj);
                break;
            default:
                d((Integer) obj);
                break;
        }
    }
}
