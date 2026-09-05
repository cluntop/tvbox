package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.function.BiConsumer$CC;
import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Supplier, BiConsumer, DoubleFunction, ToDoubleFunction, IntFunction, DoubleBinaryOperator, ObjDoubleConsumer, Predicate, IntBinaryOperator, ObjIntConsumer {
    public final /* synthetic */ int a;

    public /* synthetic */ j(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.a) {
            case 2:
                ((LinkedHashSet) obj).add(obj2);
                break;
            case 3:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                break;
            case 4:
                ((com.github.catvod.spider.jdollar.util.x) obj).a((com.github.catvod.spider.jdollar.util.x) obj2);
                break;
            case 11:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                Collectors.a(dArr, dArr2[0]);
                Collectors.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                break;
            case 15:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                Collectors.a(dArr3, dArr4[0]);
                Collectors.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                break;
            default:
                ((com.github.catvod.spider.jdollar.util.y) obj).a((com.github.catvod.spider.jdollar.util.y) obj2);
                break;
        }
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.a) {
        }
        return Predicate$CC.$default$and(this, predicate);
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 11:
                break;
            case 15:
                break;
        }
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        switch (this.a) {
            case 7:
                return new Double[i];
            case 25:
                return new Object[i];
            default:
                return new Integer[i];
        }
    }

    @Override // java.util.function.DoubleBinaryOperator
    public double applyAsDouble(double d, double d2) {
        switch (this.a) {
            case 8:
                return Math.max(d, d2);
            default:
                return Math.min(d, d2);
        }
    }

    @Override // java.util.function.IntBinaryOperator
    public int applyAsInt(int i, int i2) {
        return Math.min(i, i2);
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new HashMap();
            case 1:
                return new LinkedHashSet();
            case 9:
                return new double[3];
            case 13:
                return new double[4];
            case 18:
                return new e0();
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                return new f0();
            case 22:
                return new g0();
            default:
                return new h0();
        }
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.a) {
        }
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        switch (this.a) {
            case 17:
                return ((com.github.catvod.spider.jdollar.util.b0) obj).a;
            case 18:
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
            default:
                return ((Optional) obj).isPresent();
            case 19:
                return ((com.github.catvod.spider.jdollar.util.c0) obj).a;
            case 21:
                return ((com.github.catvod.spider.jdollar.util.d0) obj).a;
        }
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d) {
        return Double.valueOf(d);
    }

    @Override // java.util.function.ToDoubleFunction
    public double applyAsDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    @Override // java.util.function.ObjIntConsumer
    public void accept(Object obj, int i) {
        ((com.github.catvod.spider.jdollar.util.y) obj).accept(i);
    }

    @Override // java.util.function.ObjDoubleConsumer
    public void accept(Object obj, double d) {
        switch (this.a) {
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                double[] dArr = (double[]) obj;
                Collectors.a(dArr, d);
                dArr[2] = dArr[2] + d;
                break;
            case 14:
                double[] dArr2 = (double[]) obj;
                dArr2[2] = dArr2[2] + 1.0d;
                Collectors.a(dArr2, d);
                dArr2[3] = dArr2[3] + d;
                break;
            default:
                ((com.github.catvod.spider.jdollar.util.x) obj).accept(d);
                break;
        }
    }
}
