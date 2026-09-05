package com.github.catvod.spider.merge.k1;

/* loaded from: classes.dex */
public abstract class b {
    public static final com.github.catvod.spider.merge.g1.b a = new com.github.catvod.spider.merge.g1.b(3);

    public static byte[] a(String str) {
        try {
            return a.e(str.length(), str);
        } catch (Exception e) {
            a aVar = new a("exception decoding Hex string: " + e.getMessage());
            aVar.a = e;
            throw aVar;
        }
    }
}
