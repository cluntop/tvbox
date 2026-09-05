package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.c0;
import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.github.catvod.spider.jdollar.util.p1;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.DoubleStream;
import com.github.catvod.spider.jdollar.util.stream.IntStream;
import com.github.catvod.spider.jdollar.util.stream.LongStream;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.a7;
import com.github.catvod.spider.jdollar.util.stream.b0;
import com.github.catvod.spider.jdollar.util.stream.b1;
import com.github.catvod.spider.jdollar.util.stream.c1;
import com.github.catvod.spider.jdollar.util.stream.k8;
import com.github.catvod.spider.jdollar.util.stream.l1;
import com.github.catvod.spider.jdollar.util.stream.m1;
import com.github.catvod.spider.jdollar.util.stream.m5;
import com.github.catvod.spider.jdollar.util.stream.r7;
import com.github.catvod.spider.jdollar.util.stream.t7;
import com.github.catvod.spider.jdollar.util.stream.v7;
import com.github.catvod.spider.jdollar.util.stream.y6;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements c0, DirectoryStream.Filter, FileAttribute, Predicate, Supplier, BinaryOperator, DoubleFunction, Function, LongFunction, Consumer, BooleanSupplier {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ g(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.c0
    public boolean a(Path path) {
        return ((Pattern) this.b).matcher(path.toString()).matches();
    }

    @Override // java.nio.file.DirectoryStream.Filter, java.util.function.Consumer
    public boolean accept(Object obj) {
        switch (this.a) {
            case 1:
                return ((c0) this.b).a(((Path) obj).getFileName());
            default:
                return ((DirectoryStream.Filter) this.b).accept(com.github.catvod.spider.jdollar.com.android.tools.r8.a.o(obj));
        }
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object objApply = ((Function) this.b).apply(obj);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof Stream) {
            return Stream.Wrapper.convert((Stream) objApply);
        }
        if (objApply instanceof java.util.stream.Stream) {
            return y6.g((java.util.stream.Stream) objApply);
        }
        if (objApply instanceof IntStream) {
            return c1.g((IntStream) objApply);
        }
        if (objApply instanceof java.util.stream.IntStream) {
            return b1.g((java.util.stream.IntStream) objApply);
        }
        if (objApply instanceof DoubleStream) {
            return com.github.catvod.spider.jdollar.util.stream.c0.g((DoubleStream) objApply);
        }
        if (objApply instanceof java.util.stream.DoubleStream) {
            return b0.g((java.util.stream.DoubleStream) objApply);
        }
        if (objApply instanceof LongStream) {
            return m1.g((LongStream) objApply);
        }
        if (objApply instanceof java.util.stream.LongStream) {
            return l1.g((java.util.stream.LongStream) objApply);
        }
        com.github.catvod.spider.jdollar.util.h.a(objApply.getClass(), "java.util.stream.*Stream");
        throw null;
    }

    public void b(a7 a7Var) {
        ((EnumMap) ((Map) this.b)).put((EnumMap) a7Var, (a7) 1);
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case 6:
                return ((com.github.catvod.spider.jdollar.util.stream.a) this.b).O(0);
            case 7:
                return (Spliterator) this.b;
            default:
                CharSequence charSequence = (CharSequence) this.b;
                Set set = Collectors.a;
                return new p1(charSequence);
        }
    }

    @Override // java.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        switch (this.a) {
            case 16:
                r7 r7Var = (r7) this.b;
                return r7Var.d.tryAdvance(r7Var.e);
            case 17:
                t7 t7Var = (t7) this.b;
                return t7Var.d.tryAdvance(t7Var.e);
            case 18:
                v7 v7Var = (v7) this.b;
                return v7Var.d.tryAdvance(v7Var.e);
            default:
                k8 k8Var = (k8) this.b;
                return k8Var.d.tryAdvance(k8Var.e);
        }
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute
    public String name() {
        switch (this.a) {
        }
        return "posix:permissions";
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        return !((Predicate) this.b).test(obj);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute
    public Object value() {
        switch (this.a) {
            case 3:
                return Collections.unmodifiableSet(com.github.catvod.spider.jdollar.com.android.tools.r8.a.v((Set) ((java.nio.file.attribute.FileAttribute) this.b).value()));
            default:
                return Collections.unmodifiableSet((Set) this.b);
        }
    }

    public /* synthetic */ g(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiFunction, java.util.function.Function
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction, java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.nio.file.DirectoryStream.Filter, java.util.function.Consumer
    public void accept(Object obj) {
        switch (this.a) {
            case 13:
                ((m5) this.b).accept((m5) obj);
                break;
            default:
                ((ArrayList) ((List) this.b)).add(obj);
                break;
        }
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d) {
        Object objApply = ((DoubleFunction) this.b).apply(d);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof DoubleStream) {
            return com.github.catvod.spider.jdollar.util.stream.c0.g((DoubleStream) objApply);
        }
        if (objApply instanceof java.util.stream.DoubleStream) {
            return b0.g((java.util.stream.DoubleStream) objApply);
        }
        com.github.catvod.spider.jdollar.util.h.a(objApply.getClass(), "java.util.stream.DoubleStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        Object objApply = ((LongFunction) this.b).apply(j);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof LongStream) {
            return m1.g((LongStream) objApply);
        }
        if (objApply instanceof java.util.stream.LongStream) {
            return l1.g((java.util.stream.LongStream) objApply);
        }
        com.github.catvod.spider.jdollar.util.h.a(objApply.getClass(), "java.util.stream.LongStream");
        throw null;
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        BinaryOperator binaryOperator = (BinaryOperator) this.b;
        Map map = (Map) obj;
        Set set = Collectors.a;
        for (Map.Entry entry : ((Map) obj2).entrySet()) {
            Map.EL.b(map, entry.getKey(), entry.getValue(), binaryOperator);
        }
        return map;
    }
}
