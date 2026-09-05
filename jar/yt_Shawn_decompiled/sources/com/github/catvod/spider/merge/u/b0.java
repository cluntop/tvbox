package com.github.catvod.spider.merge.u;

import java.lang.reflect.Type;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b0 {
    public static final b0 b;
    public static final b0 c;
    public static final b0[] d;
    public static final Type[] e;
    public final int a;

    static {
        v0 v0Var = v0.f;
        b0 b0Var = new b0("DOUBLE", 0, 0, 1, v0Var);
        v0 v0Var2 = v0.e;
        b0 b0Var2 = new b0("FLOAT", 1, 1, 1, v0Var2);
        v0 v0Var3 = v0.d;
        b0 b0Var3 = new b0("INT64", 2, 2, 1, v0Var3);
        b0 b0Var4 = new b0("UINT64", 3, 3, 1, v0Var3);
        v0 v0Var4 = v0.c;
        b0 b0Var5 = new b0("INT32", 4, 4, 1, v0Var4);
        b0 b0Var6 = new b0("FIXED64", 5, 5, 1, v0Var3);
        b0 b0Var7 = new b0("FIXED32", 6, 6, 1, v0Var4);
        v0 v0Var5 = v0.g;
        b0 b0Var8 = new b0("BOOL", 7, 7, 1, v0Var5);
        v0 v0Var6 = v0.h;
        b0 b0Var9 = new b0("STRING", 8, 8, 1, v0Var6);
        v0 v0Var7 = v0.k;
        b0 b0Var10 = new b0("MESSAGE", 9, 9, 1, v0Var7);
        v0 v0Var8 = v0.i;
        b0 b0Var11 = new b0("BYTES", 10, 10, 1, v0Var8);
        b0 b0Var12 = new b0("UINT32", 11, 11, 1, v0Var4);
        v0 v0Var9 = v0.j;
        b0 b0Var13 = new b0("ENUM", 12, 12, 1, v0Var9);
        b0 b0Var14 = new b0("SFIXED32", 13, 13, 1, v0Var4);
        b0 b0Var15 = new b0("SFIXED64", 14, 14, 1, v0Var3);
        b0 b0Var16 = new b0("SINT32", 15, 15, 1, v0Var4);
        b0 b0Var17 = new b0("SINT64", 16, 16, 1, v0Var3);
        b0 b0Var18 = new b0("GROUP", 17, 17, 1, v0Var7);
        b0 b0Var19 = new b0("DOUBLE_LIST", 18, 18, 2, v0Var);
        b0 b0Var20 = new b0("FLOAT_LIST", 19, 19, 2, v0Var2);
        b0 b0Var21 = new b0("INT64_LIST", 20, 20, 2, v0Var3);
        b0 b0Var22 = new b0("UINT64_LIST", 21, 21, 2, v0Var3);
        b0 b0Var23 = new b0("INT32_LIST", 22, 22, 2, v0Var4);
        b0 b0Var24 = new b0("FIXED64_LIST", 23, 23, 2, v0Var3);
        b0 b0Var25 = new b0("FIXED32_LIST", 24, 24, 2, v0Var4);
        b0 b0Var26 = new b0("BOOL_LIST", 25, 25, 2, v0Var5);
        b0 b0Var27 = new b0("STRING_LIST", 26, 26, 2, v0Var6);
        b0 b0Var28 = new b0("MESSAGE_LIST", 27, 27, 2, v0Var7);
        b0 b0Var29 = new b0("BYTES_LIST", 28, 28, 2, v0Var8);
        b0 b0Var30 = new b0("UINT32_LIST", 29, 29, 2, v0Var4);
        b0 b0Var31 = new b0("ENUM_LIST", 30, 30, 2, v0Var9);
        b0 b0Var32 = new b0("SFIXED32_LIST", 31, 31, 2, v0Var4);
        b0 b0Var33 = new b0("SFIXED64_LIST", 32, 32, 2, v0Var3);
        b0 b0Var34 = new b0("SINT32_LIST", 33, 33, 2, v0Var4);
        b0 b0Var35 = new b0("SINT64_LIST", 34, 34, 2, v0Var3);
        b0 b0Var36 = new b0("DOUBLE_LIST_PACKED", 35, 35, 3, v0Var);
        b = b0Var36;
        b0 b0Var37 = new b0("FLOAT_LIST_PACKED", 36, 36, 3, v0Var2);
        b0 b0Var38 = new b0("INT64_LIST_PACKED", 37, 37, 3, v0Var3);
        b0 b0Var39 = new b0("UINT64_LIST_PACKED", 38, 38, 3, v0Var3);
        b0 b0Var40 = new b0("INT32_LIST_PACKED", 39, 39, 3, v0Var4);
        b0 b0Var41 = new b0("FIXED64_LIST_PACKED", 40, 40, 3, v0Var3);
        b0 b0Var42 = new b0("FIXED32_LIST_PACKED", 41, 41, 3, v0Var4);
        b0 b0Var43 = new b0("BOOL_LIST_PACKED", 42, 42, 3, v0Var5);
        b0 b0Var44 = new b0("UINT32_LIST_PACKED", 43, 43, 3, v0Var4);
        b0 b0Var45 = new b0("ENUM_LIST_PACKED", 44, 44, 3, v0Var9);
        b0 b0Var46 = new b0("SFIXED32_LIST_PACKED", 45, 45, 3, v0Var4);
        b0 b0Var47 = new b0("SFIXED64_LIST_PACKED", 46, 46, 3, v0Var3);
        b0 b0Var48 = new b0("SINT32_LIST_PACKED", 47, 47, 3, v0Var4);
        b0 b0Var49 = new b0("SINT64_LIST_PACKED", 48, 48, 3, v0Var3);
        c = b0Var49;
        b0[] b0VarArr = {b0Var, b0Var2, b0Var3, b0Var4, b0Var5, b0Var6, b0Var7, b0Var8, b0Var9, b0Var10, b0Var11, b0Var12, b0Var13, b0Var14, b0Var15, b0Var16, b0Var17, b0Var18, b0Var19, b0Var20, b0Var21, b0Var22, b0Var23, b0Var24, b0Var25, b0Var26, b0Var27, b0Var28, b0Var29, b0Var30, b0Var31, b0Var32, b0Var33, b0Var34, b0Var35, b0Var36, b0Var37, b0Var38, b0Var39, b0Var40, b0Var41, b0Var42, b0Var43, b0Var44, b0Var45, b0Var46, b0Var47, b0Var48, b0Var49, new b0("GROUP_LIST", 49, 49, 2, v0Var7), new b0("MAP", 50, 50, 4, v0.b)};
        e = new Type[0];
        b0[] b0VarArr2 = (b0[]) b0VarArr.clone();
        d = new b0[b0VarArr2.length];
        for (b0 b0Var50 : b0VarArr2) {
            d[b0Var50.a] = b0Var50;
        }
    }

    public b0(String str, int i, int i2, int i3, v0 v0Var) {
        this.a = i2;
        int iD = o.d(i3);
        if (iD == 1 || iD == 3) {
            v0Var.getClass();
        }
        if (i3 == 1) {
            v0Var.ordinal();
        }
    }
}
