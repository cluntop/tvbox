package com.github.catvod.spider.merge.u;

import com.github.catvod.spider.jdollar.io.DesugarInputStream;
import com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a extends FilterInputStream implements InputStreamRetargetInterface {
    public int a;

    public a(int i, InputStream inputStream) {
        super(inputStream);
        this.a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return Math.min(super.available(), this.a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a;
        if (i3 <= 0) {
            return -1;
        }
        int i4 = super.read(bArr, i, Math.min(i2, i3));
        if (i4 >= 0) {
            this.a -= i4;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        int iSkip = (int) super.skip(Math.min(j, this.a));
        if (iSkip >= 0) {
            this.a -= iSkip;
        }
        return iSkip;
    }

    @Override // java.io.InputStream, com.github.catvod.spider.jdollar.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.a <= 0) {
            return -1;
        }
        int i = super.read();
        if (i >= 0) {
            this.a--;
        }
        return i;
    }
}
