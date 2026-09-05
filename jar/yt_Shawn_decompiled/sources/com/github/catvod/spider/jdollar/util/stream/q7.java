package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class q7 implements j5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ DoubleConsumer b;

    public /* synthetic */ q7(DoubleConsumer doubleConsumer, int i) {
        this.a = i;
        this.b = doubleConsumer;
    }

    private final /* synthetic */ void a(long j) {
    }

    private final /* synthetic */ void b(long j) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        int i = this.a;
        DoubleConsumer doubleConsumer = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                doubleConsumer.accept(d);
                break;
            default:
                ((q6) doubleConsumer).accept(d);
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

    @Override // com.github.catvod.spider.jdollar.util.stream.j5
    public final /* synthetic */ void r(Double d) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                v3.d(this, d);
                break;
            default:
                v3.d(this, d);
                break;
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                v3.k();
                throw null;
            default:
                v3.k();
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
                r((Double) obj);
                break;
            default:
                r((Double) obj);
                break;
        }
    }
}
