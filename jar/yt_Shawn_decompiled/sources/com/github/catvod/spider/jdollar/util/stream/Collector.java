package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface Collector<T, A, R> {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: com.github.catvod.spider.jdollar.util.stream.Collector$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <T, A, R> Collector<T, A, R> of(Supplier<A> supplier, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator, Function<A, R> function, Characteristics... characteristicsArr) {
            Objects.requireNonNull(supplier);
            Objects.requireNonNull(biConsumer);
            Objects.requireNonNull(binaryOperator);
            Objects.requireNonNull(function);
            Objects.requireNonNull(characteristicsArr);
            Set setUnmodifiableSet = Collectors.b;
            if (characteristicsArr.length > 0) {
                EnumSet enumSetNoneOf = EnumSet.noneOf(Characteristics.class);
                Collections.addAll(enumSetNoneOf, characteristicsArr);
                setUnmodifiableSet = Collections.unmodifiableSet(enumSetNoneOf);
            }
            return new k(supplier, biConsumer, binaryOperator, function, setUnmodifiableSet);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public static final class Characteristics {
        public static final Characteristics CONCURRENT;
        public static final Characteristics IDENTITY_FINISH;
        public static final Characteristics UNORDERED;
        public static final /* synthetic */ Characteristics[] a;

        static {
            Characteristics characteristics = new Characteristics("CONCURRENT", 0);
            CONCURRENT = characteristics;
            Characteristics characteristics2 = new Characteristics("UNORDERED", 1);
            UNORDERED = characteristics2;
            Characteristics characteristics3 = new Characteristics("IDENTITY_FINISH", 2);
            IDENTITY_FINISH = characteristics3;
            a = new Characteristics[]{characteristics, characteristics2, characteristics3};
        }

        public static Characteristics valueOf(String str) {
            return (Characteristics) Enum.valueOf(Characteristics.class, str);
        }

        public static Characteristics[] values() {
            return (Characteristics[]) a.clone();
        }
    }

    BiConsumer accumulator();

    Set characteristics();

    BinaryOperator combiner();

    Function finisher();

    Supplier supplier();
}
