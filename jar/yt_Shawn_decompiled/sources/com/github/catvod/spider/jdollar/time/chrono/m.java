package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.chrono.m;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.q1;
import com.github.catvod.spider.jdollar.util.r0;
import com.github.catvod.spider.jdollar.util.u0;
import com.github.catvod.spider.jdollar.util.x0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class m {
    public static void A(Iterator it, Consumer consumer) {
        if (it instanceof com.github.catvod.spider.jdollar.util.z) {
            ((com.github.catvod.spider.jdollar.util.z) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static String B(Object obj, Object obj2) {
        String string;
        String string2;
        String str = "null";
        if (obj == null || (string = obj.toString()) == null) {
            string = "null";
        }
        int length = string.length();
        if (obj2 != null && (string2 = obj2.toString()) != null) {
            str = string2;
        }
        int length2 = str.length();
        char[] cArr = new char[length + length2 + 1];
        string.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        str.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.catvod.spider.jdollar.util.function.b] */
    public static com.github.catvod.spider.jdollar.util.function.b a(final DoubleConsumer doubleConsumer, final DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new DoubleConsumer() { // from class: com.github.catvod.spider.jdollar.util.function.b
            @Override // java.util.function.DoubleConsumer
            public final void accept(double d) {
                doubleConsumer.accept(d);
                doubleConsumer2.accept(d);
            }

            @Override // java.util.function.DoubleConsumer
            public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer3) {
                return m.a(this, doubleConsumer3);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.catvod.spider.jdollar.util.function.d] */
    public static com.github.catvod.spider.jdollar.util.function.d b(final IntConsumer intConsumer, final IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new IntConsumer() { // from class: com.github.catvod.spider.jdollar.util.function.d
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                intConsumer.accept(i);
                intConsumer2.accept(i);
            }

            @Override // java.util.function.IntConsumer
            public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer3) {
                return m.b(this, intConsumer3);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.catvod.spider.jdollar.util.function.f] */
    public static com.github.catvod.spider.jdollar.util.function.f c(final LongConsumer longConsumer, final LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new LongConsumer() { // from class: com.github.catvod.spider.jdollar.util.function.f
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                longConsumer.accept(j);
                longConsumer2.accept(j);
            }

            @Override // java.util.function.LongConsumer
            public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer3) {
                return m.c(this, longConsumer3);
            }
        };
    }

    public static void d(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static void e(r0 r0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            r0Var.forEachRemaining((DoubleConsumer) consumer);
        } else {
            if (q1.a) {
                q1.a(r0Var.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            r0Var.forEachRemaining((DoubleConsumer) new com.github.catvod.spider.jdollar.util.e0(consumer, 0));
        }
    }

    public static void f(u0 u0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            u0Var.forEachRemaining((IntConsumer) consumer);
        } else {
            if (q1.a) {
                q1.a(u0Var.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            u0Var.forEachRemaining((IntConsumer) new com.github.catvod.spider.jdollar.util.h0(consumer, 0));
        }
    }

    public static void g(x0 x0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            x0Var.forEachRemaining((LongConsumer) consumer);
        } else {
            if (q1.a) {
                q1.a(x0Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            x0Var.forEachRemaining((LongConsumer) new com.github.catvod.spider.jdollar.util.k0(consumer, 0));
        }
    }

    public static int h(n nVar, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA ? nVar.getValue() : com.github.catvod.spider.jdollar.time.temporal.q.a(nVar, pVar);
    }

    public static long i(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static long j(n nVar, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA) {
            return nVar.getValue();
        }
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
        return pVar.y(nVar);
    }

    public static boolean k(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static boolean l(n nVar, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA : pVar != null && pVar.h(nVar);
    }

    public static Object m(n nVar, com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == com.github.catvod.spider.jdollar.time.temporal.q.c ? ChronoUnit.ERAS : com.github.catvod.spider.jdollar.time.temporal.q.c(nVar, mVar);
    }

    public static boolean n(r0 r0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return r0Var.tryAdvance((DoubleConsumer) consumer);
        }
        if (q1.a) {
            q1.a(r0Var.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return r0Var.tryAdvance((DoubleConsumer) new com.github.catvod.spider.jdollar.util.e0(consumer, 0));
    }

    public static boolean o(u0 u0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return u0Var.tryAdvance((IntConsumer) consumer);
        }
        if (q1.a) {
            q1.a(u0Var.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return u0Var.tryAdvance((IntConsumer) new com.github.catvod.spider.jdollar.util.h0(consumer, 0));
    }

    public static boolean p(x0 x0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return x0Var.tryAdvance((LongConsumer) consumer);
        }
        if (q1.a) {
            q1.a(x0Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return x0Var.tryAdvance((LongConsumer) new com.github.catvod.spider.jdollar.util.k0(consumer, 0));
    }

    public static String q(long j, String str, Locale locale) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(2016, 1, (int) j, 0, 0, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String r(long j, String str, Locale locale) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(0, (int) j, 0, 0, 0, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static Optional s(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static com.github.catvod.spider.jdollar.util.b0 t(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? new com.github.catvod.spider.jdollar.util.b0(optionalDouble.getAsDouble()) : com.github.catvod.spider.jdollar.util.b0.c;
    }

    public static com.github.catvod.spider.jdollar.util.c0 u(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? new com.github.catvod.spider.jdollar.util.c0(optionalInt.getAsInt()) : com.github.catvod.spider.jdollar.util.c0.c;
    }

    public static com.github.catvod.spider.jdollar.util.d0 v(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? new com.github.catvod.spider.jdollar.util.d0(optionalLong.getAsLong()) : com.github.catvod.spider.jdollar.util.d0.c;
    }

    public static java.util.Optional w(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? java.util.Optional.of(optional.get()) : java.util.Optional.empty();
    }

    public static OptionalDouble x(com.github.catvod.spider.jdollar.util.b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        boolean z = b0Var.a;
        if (!z) {
            return OptionalDouble.empty();
        }
        if (z) {
            return OptionalDouble.of(b0Var.b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalInt y(com.github.catvod.spider.jdollar.util.c0 c0Var) {
        if (c0Var == null) {
            return null;
        }
        boolean z = c0Var.a;
        if (!z) {
            return OptionalInt.empty();
        }
        if (z) {
            return OptionalInt.of(c0Var.b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalLong z(com.github.catvod.spider.jdollar.util.d0 d0Var) {
        if (d0Var == null) {
            return null;
        }
        boolean z = d0Var.a;
        if (!z) {
            return OptionalLong.empty();
        }
        if (z) {
            return OptionalLong.of(d0Var.b);
        }
        throw new NoSuchElementException("No value present");
    }

    public int characteristics() {
        return 16448;
    }

    public long estimateSize() {
        return 0L;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public Spliterator trySplit() {
        return null;
    }
}
