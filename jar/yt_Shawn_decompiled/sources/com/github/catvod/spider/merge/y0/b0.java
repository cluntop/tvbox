package com.github.catvod.spider.merge.y0;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b0 extends p {
    public final /* synthetic */ int d = 0;
    public final Closeable e;

    public b0(FileChannel fileChannel) {
        fileChannel.getClass();
        this.e = fileChannel;
    }

    private final synchronized void C() {
        ((RandomAccessFile) this.e).close();
    }

    private final synchronized void D() {
        ((FileChannel) this.e).close();
    }

    private final synchronized int E(byte[] bArr, int i, int i2, long j) {
        bArr.getClass();
        ((RandomAccessFile) this.e).seek(j);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = ((RandomAccessFile) this.e).read(bArr, i, i2 - i3);
            if (i4 != -1) {
                i3 += i4;
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    private final synchronized int F(byte[] bArr, int i, int i2, long j) {
        bArr.getClass();
        ((FileChannel) this.e).position(j);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, i2);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = ((FileChannel) this.e).read(byteBufferWrap);
            if (i4 != -1) {
                i3 += i4;
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    private final synchronized long G() {
        return ((RandomAccessFile) this.e).length();
    }

    private final synchronized long H() {
        return ((FileChannel) this.e).size();
    }

    @Override // com.github.catvod.spider.merge.y0.p
    public final synchronized long A() {
        switch (this.d) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return G();
            default:
                return H();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p
    public final synchronized void j() {
        switch (this.d) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                C();
                break;
            default:
                D();
                break;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.p
    public final synchronized int z(byte[] bArr, int i, int i2, long j) {
        switch (this.d) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return E(bArr, i, i2, j);
            default:
                return F(bArr, i, i2, j);
        }
    }

    public b0(RandomAccessFile randomAccessFile) {
        this.e = randomAccessFile;
    }
}
