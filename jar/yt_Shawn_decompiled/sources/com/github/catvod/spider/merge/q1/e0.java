package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class e0 extends p {
    public final p a;
    public boolean b;
    public final com.github.catvod.spider.merge.n1.c c = new com.github.catvod.spider.merge.n1.c(new com.github.catvod.spider.merge.n1.b(6), 2);

    public e0(p pVar) {
        this.a = pVar;
        this.b = pVar.f();
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        return g(nVar, nVar2);
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean c(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.r rVar) {
        return g(nVar, rVar);
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public void e() {
        this.c.remove();
        this.a.e();
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean f() {
        return this.b;
    }

    public abstract boolean g(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar);

    public final boolean h(final com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        return ((Boolean) Map.EL.computeIfAbsent((java.util.Map) Map.EL.computeIfAbsent((java.util.Map) this.c.get(), nVar, new com.github.catvod.spider.merge.n1.g(7)), sVar, new Function() { // from class: com.github.catvod.spider.merge.q1.y
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(this.a.a.d(nVar, (com.github.catvod.spider.merge.o1.s) obj));
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        })).booleanValue();
    }
}
