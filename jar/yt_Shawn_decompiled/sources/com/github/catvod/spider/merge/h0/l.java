package com.github.catvod.spider.merge.h0;

import java.io.FilterOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l extends FilterOutputStream {
    public final void j() throws IOException {
        ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        ((FilterOutputStream) this).out.write("\r\n".getBytes());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
