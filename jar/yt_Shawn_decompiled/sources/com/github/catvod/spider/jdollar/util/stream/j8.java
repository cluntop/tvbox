package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class j8 implements m5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ j8(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
    }

    private final /* synthetic */ void a(long j) {
    }

    private final /* synthetic */ void b(long j) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        Consumer consumer = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                ((x6) consumer).accept(obj);
                break;
            default:
                consumer.accept(obj);
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
}
