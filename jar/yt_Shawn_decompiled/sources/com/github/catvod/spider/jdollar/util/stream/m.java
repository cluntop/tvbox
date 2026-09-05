package com.github.catvod.spider.jdollar.util.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m extends i5 {
    public final /* synthetic */ int b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.b;
        m5 m5Var = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!((Set) this.c).contains(obj)) {
                    ((Set) this.c).add(obj);
                    m5Var.accept((m5) obj);
                    break;
                }
                break;
            case 1:
                ((Consumer) ((q) this.c).n).accept(obj);
                m5Var.accept((m5) obj);
                break;
            case 2:
                if (((Predicate) ((q) this.c).n).test(obj)) {
                    m5Var.accept((m5) obj);
                    break;
                }
                break;
            case 3:
                m5Var.accept((m5) ((a5) this.c).n.apply(obj));
                break;
            case 4:
                m5Var.accept(((ToIntFunction) ((t0) this.c).n).applyAsInt(obj));
                break;
            case 5:
                m5Var.accept(((ToLongFunction) ((g1) this.c).n).applyAsLong(obj));
                break;
            default:
                m5Var.accept(((ToDoubleFunction) ((w) this.c).n).applyAsDouble(obj));
                break;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public void c(long j) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.c = new HashSet();
                this.a.c(-1L);
                break;
            case 1:
            default:
                super.c(j);
                break;
            case 2:
                this.a.c(-1L);
                break;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public void end() {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.c = null;
                this.a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(m5 m5Var) {
        super(m5Var);
        this.b = 0;
    }
}
