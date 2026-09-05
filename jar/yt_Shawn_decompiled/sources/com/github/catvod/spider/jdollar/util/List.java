package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface List<E> extends c {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: com.github.catvod.spider.jdollar.util.List$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$sort(java.util.List list, java.util.Comparator comparator) {
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator<E> listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }

        public static Spliterator $default$spliterator(java.util.List list) {
            return list instanceof RandomAccess ? new a(list) : Spliterators.b(16, list);
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: com.github.catvod.spider.jdollar.util.List$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void sort(java.util.List list, java.util.Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
            } else {
                CC.$default$sort(list, comparator);
            }
        }
    }

    @Override // com.github.catvod.spider.jdollar.lang.Iterable
    /* synthetic */ void forEach(Consumer consumer);

    @Override // com.github.catvod.spider.jdollar.util.c
    /* synthetic */ Stream parallelStream();

    @Override // com.github.catvod.spider.jdollar.util.c
    /* synthetic */ boolean removeIf(Predicate predicate);

    void replaceAll(UnaryOperator<E> unaryOperator);

    void sort(java.util.Comparator<? super E> comparator);

    @Override // com.github.catvod.spider.jdollar.lang.Iterable
    Spliterator<E> spliterator();

    @Override // com.github.catvod.spider.jdollar.util.c
    /* synthetic */ Stream stream();

    /* synthetic */ Object[] toArray(IntFunction intFunction);
}
