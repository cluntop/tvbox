package com.github.catvod.spider.merge.y0;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface l extends r0, ReadableByteChannel {
    j a();

    m d();

    m e(long j);

    boolean f(long j, m mVar);

    void g(j jVar, long j);

    int i(f0 f0Var);

    long k(long j, m mVar);

    String l();

    byte[] m();

    boolean n();

    l0 peek();

    long r();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    boolean request(long j);

    String s(long j);

    void skip(long j);

    void t(long j);

    long w();

    String x(Charset charset);

    InputStream y();
}
