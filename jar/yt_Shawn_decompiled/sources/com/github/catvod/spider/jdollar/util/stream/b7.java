package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DISTINCT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b7 {
    public static final b7 DISTINCT;
    public static final b7 ORDERED;
    public static final b7 SHORT_CIRCUIT;
    public static final b7 SIZED;
    public static final b7 SORTED;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final /* synthetic */ b7[] v;
    public final Map a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    static {
        a7 a7Var = a7.SPLITERATOR;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVarY = y(a7Var);
        a7 a7Var2 = a7.STREAM;
        gVarY.b(a7Var2);
        a7 a7Var3 = a7.OP;
        ((EnumMap) ((Map) gVarY.b)).put((EnumMap) a7Var3, (a7) 3);
        b7 b7Var = new b7("DISTINCT", 0, 0, gVarY);
        DISTINCT = b7Var;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVarY2 = y(a7Var);
        gVarY2.b(a7Var2);
        ((EnumMap) ((Map) gVarY2.b)).put((EnumMap) a7Var3, (a7) 3);
        b7 b7Var2 = new b7("SORTED", 1, 1, gVarY2);
        SORTED = b7Var2;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVarY3 = y(a7Var);
        gVarY3.b(a7Var2);
        ((EnumMap) ((Map) gVarY3.b)).put((EnumMap) a7Var3, (a7) 3);
        a7 a7Var4 = a7.TERMINAL_OP;
        ((EnumMap) ((Map) gVarY3.b)).put((EnumMap) a7Var4, (a7) 2);
        a7 a7Var5 = a7.UPSTREAM_TERMINAL_OP;
        ((EnumMap) ((Map) gVarY3.b)).put((EnumMap) a7Var5, (a7) 2);
        b7 b7Var3 = new b7("ORDERED", 2, 2, gVarY3);
        ORDERED = b7Var3;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVarY4 = y(a7Var);
        gVarY4.b(a7Var2);
        ((EnumMap) ((Map) gVarY4.b)).put((EnumMap) a7Var3, (a7) 2);
        b7 b7Var4 = new b7("SIZED", 3, 3, gVarY4);
        SIZED = b7Var4;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVarY5 = y(a7Var3);
        gVarY5.b(a7Var4);
        int i2 = 0;
        b7 b7Var5 = new b7("SHORT_CIRCUIT", 4, 12, gVarY5);
        SHORT_CIRCUIT = b7Var5;
        v = new b7[]{b7Var, b7Var2, b7Var3, b7Var4, b7Var5};
        f = i(a7Var);
        g = i(a7Var2);
        h = i(a7Var3);
        i(a7Var4);
        i(a7Var5);
        for (b7 b7Var6 : values()) {
            i2 |= b7Var6.e;
        }
        i = i2;
        int i3 = g;
        j = i3;
        int i4 = i3 << 1;
        k = i4;
        l = i3 | i4;
        b7 b7Var7 = DISTINCT;
        m = b7Var7.c;
        n = b7Var7.d;
        b7 b7Var8 = SORTED;
        o = b7Var8.c;
        p = b7Var8.d;
        b7 b7Var9 = ORDERED;
        q = b7Var9.c;
        r = b7Var9.d;
        b7 b7Var10 = SIZED;
        s = b7Var10.c;
        t = b7Var10.d;
        u = SHORT_CIRCUIT.c;
    }

    public b7(String str, int i2, int i3, com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        for (a7 a7Var : a7.values()) {
            Map.EL.c((java.util.Map) gVar.b, a7Var, 0);
        }
        this.a = (java.util.Map) gVar.b;
        int i4 = i3 * 2;
        this.b = i4;
        this.c = 1 << i4;
        this.d = 2 << i4;
        this.e = 3 << i4;
    }

    public static int h(int i2, int i3) {
        return i2 | (i3 & (i2 == 0 ? i : ~(((j & i2) << 1) | i2 | ((k & i2) >> 1))));
    }

    public static int i(a7 a7Var) {
        int iIntValue = 0;
        for (b7 b7Var : values()) {
            iIntValue |= ((Integer) b7Var.a.get(a7Var)).intValue() << b7Var.b;
        }
        return iIntValue;
    }

    public static int j(Spliterator spliterator) {
        int iCharacteristics = spliterator.characteristics();
        int i2 = iCharacteristics & 4;
        int i3 = f;
        return (i2 == 0 || spliterator.getComparator() == null) ? iCharacteristics & i3 : iCharacteristics & i3 & (-5);
    }

    public static b7 valueOf(String str) {
        return (b7) Enum.valueOf(b7.class, str);
    }

    public static b7[] values() {
        return (b7[]) v.clone();
    }

    public static com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g y(a7 a7Var) {
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(15, new EnumMap(a7.class));
        gVar.b(a7Var);
        return gVar;
    }

    public final boolean o(int i2) {
        return (i2 & this.e) == this.c;
    }
}
