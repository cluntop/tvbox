package com.github.catvod.spider.merge.e1;

import com.github.catvod.spider.merge.a1.k;
import com.github.catvod.spider.merge.a1.m;
import com.github.catvod.spider.merge.h1.g;
import java.util.Hashtable;

/* loaded from: classes.dex */
public final class c implements m {
    public final com.github.catvod.spider.merge.b1.a a;
    public final int b;
    public final int c;
    public com.github.catvod.spider.merge.j1.a d;
    public com.github.catvod.spider.merge.j1.a e;
    public final byte[] f;
    public final byte[] g;

    static {
        Hashtable hashtable = new Hashtable();
        hashtable.put("GOST3411", 32);
        hashtable.put("MD2", 16);
        hashtable.put("MD4", 64);
        hashtable.put("MD5", 64);
        hashtable.put("RIPEMD128", 64);
        hashtable.put("RIPEMD160", 64);
        hashtable.put("SHA-1", 64);
        hashtable.put("SHA-224", 64);
        hashtable.put("SHA-256", 64);
        hashtable.put("SHA-384", 128);
        hashtable.put("SHA-512", 128);
        hashtable.put("Tiger", 64);
        hashtable.put("Whirlpool", 64);
    }

    public c(com.github.catvod.spider.merge.b1.a aVar) {
        this.a = aVar;
        int iC = aVar.c();
        this.b = iC;
        this.c = 64;
        this.f = new byte[64];
        this.g = new byte[64 + iC];
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final int a(byte[] bArr) {
        com.github.catvod.spider.merge.b1.a aVar = this.a;
        byte[] bArr2 = this.g;
        int i = this.c;
        aVar.doFinal(bArr2, i);
        com.github.catvod.spider.merge.j1.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar.b(aVar2);
            aVar.update(bArr2, i, aVar.c());
        } else {
            aVar.update(bArr2, 0, bArr2.length);
        }
        int iDoFinal = aVar.doFinal(bArr, 0);
        while (i < bArr2.length) {
            bArr2[i] = 0;
            i++;
        }
        com.github.catvod.spider.merge.j1.a aVar3 = this.d;
        if (aVar3 != null) {
            aVar.b(aVar3);
            return iDoFinal;
        }
        byte[] bArr3 = this.f;
        aVar.update(bArr3, 0, bArr3.length);
        return iDoFinal;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final int b() {
        return this.b;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void c(com.github.catvod.spider.merge.a1.c cVar) {
        com.github.catvod.spider.merge.b1.a aVar = this.a;
        aVar.reset();
        byte[] bArr = ((g) cVar).a;
        int length = bArr.length;
        byte[] bArr2 = this.f;
        int i = this.c;
        if (length > i) {
            aVar.update(bArr, 0, length);
            aVar.doFinal(bArr2, 0);
            length = this.b;
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, length);
        }
        while (length < bArr2.length) {
            bArr2[length] = 0;
            length++;
        }
        byte[] bArr3 = this.g;
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] ^ 54);
        }
        for (int i3 = 0; i3 < i; i3++) {
            bArr3[i3] = (byte) (bArr3[i3] ^ 92);
        }
        com.github.catvod.spider.merge.j1.a aVarA = aVar.a();
        this.e = aVarA;
        ((k) aVarA).update(bArr3, 0, i);
        aVar.update(bArr2, 0, bArr2.length);
        this.d = aVar.a();
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void reset() {
        com.github.catvod.spider.merge.j1.a aVar = this.d;
        com.github.catvod.spider.merge.b1.a aVar2 = this.a;
        if (aVar != null) {
            aVar2.b(aVar);
            return;
        }
        aVar2.reset();
        byte[] bArr = this.f;
        aVar2.update(bArr, 0, bArr.length);
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void update(byte b) {
        this.a.update(b);
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
