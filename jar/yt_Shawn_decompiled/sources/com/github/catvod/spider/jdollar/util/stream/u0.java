package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.BiConsumer$CC;
import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class u0 implements IntBinaryOperator, Supplier, ObjIntConsumer, BiConsumer, ToIntFunction, IntFunction, ObjLongConsumer, LongFunction, LongBinaryOperator, ToLongFunction, Consumer, BinaryOperator {
    public final /* synthetic */ int a;

    public /* synthetic */ u0(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.a) {
            case 4:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                break;
            case 8:
                ((com.github.catvod.spider.jdollar.util.a0) obj).a((com.github.catvod.spider.jdollar.util.a0) obj2);
                break;
            default:
                long[] jArr3 = (long[]) obj;
                long[] jArr4 = (long[]) obj2;
                jArr3[0] = jArr3[0] + jArr4[0];
                jArr3[1] = jArr3[1] + jArr4[1];
                break;
        }
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
        }
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 21:
                return new n2((a2) obj, (a2) obj2);
            case 22:
            case 24:
            default:
                return new r2((g2) obj, (g2) obj2);
            case 23:
                return new o2((c2) obj, (c2) obj2);
            case 25:
                return new p2((e2) obj, (e2) obj2);
        }
    }

    @Override // java.util.function.IntBinaryOperator
    public int applyAsInt(int i, int i2) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return i + i2;
            default:
                return Math.max(i, i2);
        }
    }

    @Override // java.util.function.LongBinaryOperator
    public long applyAsLong(long j, long j2) {
        switch (this.a) {
            case 14:
                return Math.max(j, j2);
            case 15:
                return j + j2;
            default:
                return Math.min(j, j2);
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case 2:
                return new long[2];
            default:
                return new long[2];
        }
    }

    @Override // java.util.function.ToIntFunction
    public int applyAsInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    @Override // java.util.function.ToLongFunction
    public long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
            case 4:
                break;
            case 8:
                break;
        }
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        switch (this.a) {
            case 6:
                return Integer.valueOf(i);
            case 9:
                return new Long[i];
            case 19:
                return new Object[i];
            case 27:
                return new Object[i];
            case 28:
                return new Integer[i];
            default:
                return new Long[i];
        }
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        switch (this.a) {
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return Long.valueOf(j);
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                return v3.G(j);
            case 22:
                return v3.O(j);
            default:
                return v3.P(j);
        }
    }

    @Override // java.util.function.ObjLongConsumer
    public void accept(Object obj, long j) {
        switch (this.a) {
            case 7:
                ((com.github.catvod.spider.jdollar.util.a0) obj).accept(j);
                break;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + j;
                break;
        }
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
    }

    @Override // java.util.function.ObjIntConsumer
    public void accept(Object obj, int i) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + i;
    }
}
