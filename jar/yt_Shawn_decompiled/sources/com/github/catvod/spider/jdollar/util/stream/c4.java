package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c4 extends v3 {
    public final /* synthetic */ int h;

    public /* synthetic */ c4(int i) {
        this.h = i;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3
    public final q4 Y() {
        switch (this.h) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new u4();
            case 1:
                return new s4();
            case 2:
                return new v4();
            default:
                return new t4();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3, com.github.catvod.spider.jdollar.util.stream.n8
    public final Object a(a aVar, Spliterator spliterator) {
        switch (this.h) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 1:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
            default:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
        }
        return (Long) super.a(aVar, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3, com.github.catvod.spider.jdollar.util.stream.n8
    public final Object b(a aVar, Spliterator spliterator) {
        switch (this.h) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 1:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
            default:
                if (!b7.SIZED.o(aVar.f)) {
                    break;
                } else {
                    break;
                }
        }
        return (Long) super.b(aVar, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3, com.github.catvod.spider.jdollar.util.stream.n8
    public final int f() {
        switch (this.h) {
        }
        return b7.r;
    }
}
