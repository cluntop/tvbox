package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import com.github.catvod.spider.jdollar.util.function.BiConsumer$CC;
import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.github.catvod.spider.jdollar.util.stream.b7;
import com.github.catvod.spider.jdollar.util.stream.c7;
import com.github.catvod.spider.jdollar.util.stream.n8;
import com.github.catvod.spider.jdollar.util.stream.o1;
import com.github.catvod.spider.jdollar.util.stream.p7;
import com.github.catvod.spider.jdollar.util.stream.s1;
import com.github.catvod.spider.jdollar.util.stream.t1;
import com.github.catvod.spider.jdollar.util.stream.u1;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d0 implements j0, BiConsumer, BiFunction, Consumer, Supplier, n8 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public d0(c7 c7Var, t1 t1Var, Supplier supplier) {
        this.a = 7;
        this.b = t1Var;
        this.c = supplier;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public Object a(com.github.catvod.spider.jdollar.util.stream.a aVar, Spliterator spliterator) {
        s1 s1Var = (s1) ((Supplier) this.c).get();
        aVar.R(spliterator, s1Var);
        return Boolean.valueOf(s1Var.b);
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 4:
                ((Consumer) obj3).accept(obj);
                ((Consumer) obj2).accept(obj);
                break;
            case 5:
                AtomicBoolean atomicBoolean = (AtomicBoolean) obj3;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj2;
                if (obj != null) {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    break;
                } else {
                    atomicBoolean.set(true);
                    break;
                }
            case 6:
            case 7:
            default:
                Consumer consumer = (Consumer) obj2;
                if (((p7) obj3).b.putIfAbsent(obj != null ? obj : p7.d, Boolean.TRUE) == null) {
                    consumer.accept(obj);
                    break;
                }
                break;
            case 8:
                ((BiConsumer) obj3).accept(obj2, obj);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        return ((Function) this.c).apply(((BiFunction) this.b).apply(obj, obj2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public Object b(com.github.catvod.spider.jdollar.util.stream.a aVar, Spliterator spliterator) {
        return (Boolean) new u1(this, aVar, spliterator).invoke();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public int f() {
        return b7.u | b7.r;
    }

    @Override // java.util.function.Supplier
    public Object get() {
        return new o1((t1) this.b, (Predicate) this.c);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.j0
    public String name() {
        return (String) this.b;
    }

    public String toString() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return (String) this.b;
            default:
                return super.toString();
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.j0
    public Class type() {
        return (Class) this.c;
    }

    public /* synthetic */ d0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
        }
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        int i = this.a;
        Object obj3 = this.c;
        Object obj4 = this.b;
        switch (i) {
            case 1:
                ConcurrentMap concurrentMap = (ConcurrentMap) obj4;
                BiFunction biFunction = (BiFunction) obj3;
                while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
                }
            default:
                ((BiConsumer) obj4).accept(obj, obj2);
                ((BiConsumer) obj3).accept(obj, obj2);
                break;
        }
    }
}
