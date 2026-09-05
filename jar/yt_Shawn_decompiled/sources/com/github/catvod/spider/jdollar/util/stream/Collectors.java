package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.function.BiConsumer$CC;
import com.github.catvod.spider.jdollar.util.stream.Collector;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Collectors {
    public static final Set a;
    public static final Set b;

    static {
        Collector.Characteristics characteristics = Collector.Characteristics.CONCURRENT;
        Collector.Characteristics characteristics2 = Collector.Characteristics.UNORDERED;
        Collector.Characteristics characteristics3 = Collector.Characteristics.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2, characteristics3));
        Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2));
        a = Collections.unmodifiableSet(EnumSet.of(characteristics3));
        Collections.unmodifiableSet(EnumSet.of(characteristics2, characteristics3));
        b = Collections.EMPTY_SET;
        Collections.unmodifiableSet(EnumSet.of(characteristics2));
    }

    public static void a(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
    }

    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> collector, Function<R, RR> function) {
        Set setCharacteristics = collector.characteristics();
        Collector.Characteristics characteristics = Collector.Characteristics.IDENTITY_FINISH;
        if (setCharacteristics.contains(characteristics)) {
            if (setCharacteristics.size() == 1) {
                setCharacteristics = b;
            } else {
                EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) setCharacteristics);
                enumSetCopyOf.remove(characteristics);
                setCharacteristics = Collections.unmodifiableSet(enumSetCopyOf);
            }
        }
        return new k(collector.supplier(), collector.accumulator(), collector.combiner(), collector.finisher().andThen(function), setCharacteristics);
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return new k(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(8, charSequence), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(27), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(28), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(29), b);
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> supplier) {
        return new k(supplier, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(17), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(18), a);
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new k(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(19), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(20), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(25), a);
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2, final BinaryOperator<U> binaryOperator) {
        return new k(new j(0), new BiConsumer() { // from class: com.github.catvod.spider.jdollar.util.stream.i
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Set set = Collectors.a;
                Map.EL.b((java.util.Map) obj, function.apply(obj2), function2.apply(obj2), binaryOperator);
            }

            @Override // java.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(9, binaryOperator), a);
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return new k(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(19), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(20), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(21), new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(22), b);
    }
}
