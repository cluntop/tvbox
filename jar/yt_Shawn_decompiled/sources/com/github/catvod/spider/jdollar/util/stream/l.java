package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l extends i5 {
    public final /* synthetic */ int b = 1;
    public boolean c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(q8 q8Var, m5 m5Var) {
        super(m5Var);
        this.d = q8Var;
        this.c = true;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws Exception {
        int i = this.b;
        m5 m5Var = this.a;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (obj == null) {
                    if (this.c) {
                        return;
                    }
                    this.c = true;
                    this.d = null;
                    m5Var.accept((m5) null);
                    return;
                }
                Object obj2 = this.d;
                if (obj2 == null || !obj.equals(obj2)) {
                    this.d = obj;
                    m5Var.accept((m5) obj);
                    return;
                }
                return;
            case 1:
                Stream stream = (Stream) ((a5) this.d).n.apply(obj);
                if (stream != null) {
                    try {
                        if (this.c) {
                            Spliterator spliterator = ((Stream) stream.sequential()).spliterator();
                            while (!m5Var.e() && spliterator.tryAdvance(m5Var)) {
                            }
                        } else {
                            ((Stream) stream.sequential()).forEach(m5Var);
                        }
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
            default:
                if (this.c) {
                    boolean zTest = ((q8) this.d).n.test(obj);
                    this.c = zTest;
                    if (zTest) {
                        m5Var.accept((m5) obj);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.c = false;
                this.d = null;
                this.a.c(-1L);
                break;
            case 1:
                this.a.c(-1L);
                break;
            default:
                this.a.c(-1L);
                break;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public boolean e() {
        switch (this.b) {
            case 1:
                this.c = true;
                return this.a.e();
            case 2:
                return !this.c || this.a.e();
            default:
                return super.e();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public void end() {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.c = false;
                this.d = null;
                this.a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    public /* synthetic */ l(m5 m5Var) {
        super(m5Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(a5 a5Var, m5 m5Var) {
        super(m5Var);
        this.d = a5Var;
    }
}
