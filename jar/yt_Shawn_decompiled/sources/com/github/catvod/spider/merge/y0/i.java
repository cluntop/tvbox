package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.jdollar.io.DesugarInputStream;
import com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i extends InputStream implements InputStreamRetargetInterface {
    public final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        return (int) Math.min(this.a.b, 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.InputStream
    public final int read() {
        j jVar = this.a;
        if (jVar.b > 0) {
            return jVar.readByte() & 255;
        }
        return -1;
    }

    public final String toString() {
        return this.a + ".inputStream()";
    }

    @Override // java.io.InputStream, com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        return this.a.read(bArr, i, i2);
    }
}
