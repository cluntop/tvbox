package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a3 extends j2 implements y1 {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            com.github.catvod.spider.jdollar.nio.file.b.i("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(objArr.length)});
        } else {
            this.b = i + 1;
            objArr[i] = obj;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y1
    public final g2 build() {
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            return this;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length)});
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        Object[] objArr = this.a;
        if (j == objArr.length) {
            this.b = 0;
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.i("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(objArr.length)});
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            return;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length)});
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j2
    public final String toString() {
        Object[] objArr = this.a;
        return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(objArr.length - this.b), Arrays.toString(objArr));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }
}
