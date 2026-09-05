package com.github.catvod.spider.merge.y0;

import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface k extends p0, WritableByteChannel {
    j a();

    k b(String str, int i, int i2);

    k c(long j);

    @Override // com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    void flush();

    k h(int i);

    k o(m mVar);

    long p(r0 r0Var);

    k q();

    k u(String str);

    k v(long j);

    k write(byte[] bArr);

    k write(byte[] bArr, int i, int i2);

    k writeByte(int i);

    k writeInt(int i);

    k writeShort(int i);
}
