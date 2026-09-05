package com.github.catvod.spider.jdollar.util.stream;

import java.util.concurrent.CountedCompleter;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class u3 extends CountedCompleter {
    public final g2 a;
    public final int b;
    public final /* synthetic */ int c;
    public final Object d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u3(u3 u3Var, g2 g2Var, int i) {
        this(u3Var, g2Var, i, (byte) 0);
        this.c = 1;
        this.d = (Object[]) u3Var.d;
    }

    public final u3 a(int i, int i2) {
        switch (this.c) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new u3(this, ((f2) this.a).a(i), i2);
            default:
                return new u3(this, this.a.a(i), i2);
        }
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        int i;
        u3 u3VarA = this;
        while (u3VarA.a.s() != 0) {
            u3VarA.setPendingCount(u3VarA.a.s() - 1);
            int i2 = 0;
            int iCount = 0;
            while (true) {
                int iS = u3VarA.a.s() - 1;
                i = u3VarA.b;
                if (i2 < iS) {
                    u3 u3VarA2 = u3VarA.a(i2, i + iCount);
                    iCount = (int) (u3VarA2.a.count() + iCount);
                    u3VarA2.fork();
                    i2++;
                }
            }
            u3VarA = u3VarA.a(i2, i + iCount);
        }
        switch (u3VarA.c) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                ((f2) u3VarA.a).f(u3VarA.b, u3VarA.d);
                break;
            default:
                u3VarA.a.m((Object[]) u3VarA.d, u3VarA.b);
                break;
        }
        u3VarA.propagateCompletion();
    }

    public u3(u3 u3Var, g2 g2Var, int i, byte b) {
        super(u3Var);
        this.a = g2Var;
        this.b = i;
    }

    public u3(g2 g2Var, Object obj, int i) {
        this.c = i;
        this.a = g2Var;
        this.b = 0;
        this.d = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u3(u3 u3Var, f2 f2Var, int i) {
        this(u3Var, f2Var, i, (byte) 0);
        this.c = 0;
        this.d = u3Var.d;
    }
}
