package com.github.catvod.spider.merge.y0;

import java.io.Closeable;
import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h implements Closeable {
    public j a;
    public boolean b;
    public m0 c;
    public byte[] e;
    public long d = -1;
    public int f = -1;
    public int g = -1;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.a == null) {
            com.github.catvod.spider.merge.s0.a.h("not attached to a buffer");
            return;
        }
        this.a = null;
        this.c = null;
        this.d = -1L;
        this.e = null;
        this.f = -1;
        this.g = -1;
    }

    public final void j(long j) {
        j jVar = this.a;
        if (jVar == null) {
            com.github.catvod.spider.merge.s0.a.h("not attached to a buffer");
            return;
        }
        if (!this.b) {
            com.github.catvod.spider.merge.s0.a.h("resizeBuffer() only permitted for read/write buffers");
            return;
        }
        long j2 = jVar.b;
        if (j <= j2) {
            if (j < 0) {
                com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("newSize < 0: ", j));
                return;
            }
            long j3 = j2 - j;
            while (true) {
                if (j3 <= 0) {
                    break;
                }
                m0 m0Var = jVar.a;
                m0Var.getClass();
                m0 m0Var2 = m0Var.g;
                m0Var2.getClass();
                int i = m0Var2.c;
                long j4 = i - m0Var2.b;
                if (j4 > j3) {
                    m0Var2.c = i - ((int) j3);
                    break;
                } else {
                    jVar.a = m0Var2.a();
                    n0.a(m0Var2);
                    j3 -= j4;
                }
            }
            this.c = null;
            this.d = j;
            this.e = null;
            this.f = -1;
            this.g = -1;
        } else if (j > j2) {
            long j5 = j - j2;
            boolean z = true;
            for (long j6 = 0; j5 > j6; j6 = 0) {
                m0 m0VarL = jVar.L(1);
                int iMin = (int) Math.min(j5, 8192 - m0VarL.c);
                int i2 = m0VarL.c + iMin;
                m0VarL.c = i2;
                j5 -= iMin;
                if (z) {
                    this.c = m0VarL;
                    this.d = j2;
                    this.e = m0VarL.a;
                    this.f = i2 - iMin;
                    this.g = i2;
                    z = false;
                }
            }
        }
        jVar.b = j;
    }

    public final int z(long j) {
        j jVar = this.a;
        if (jVar == null) {
            com.github.catvod.spider.merge.s0.a.h("not attached to a buffer");
            return 0;
        }
        if (j >= -1) {
            long j2 = jVar.b;
            if (j <= j2) {
                if (j == -1 || j == j2) {
                    this.c = null;
                    this.d = j;
                    this.e = null;
                    this.f = -1;
                    this.g = -1;
                    return -1;
                }
                m0 m0Var = jVar.a;
                m0 m0Var2 = this.c;
                long j3 = 0;
                if (m0Var2 != null) {
                    long j4 = this.d - (this.f - m0Var2.b);
                    if (j4 > j) {
                        m0Var2 = m0Var;
                        m0Var = m0Var2;
                        j2 = j4;
                    } else {
                        j3 = j4;
                    }
                } else {
                    m0Var2 = m0Var;
                }
                if (j2 - j > j - j3) {
                    while (true) {
                        m0Var2.getClass();
                        long j5 = (m0Var2.c - m0Var2.b) + j3;
                        if (j < j5) {
                            break;
                        }
                        m0Var2 = m0Var2.f;
                        j3 = j5;
                    }
                } else {
                    while (j2 > j) {
                        m0Var.getClass();
                        m0Var = m0Var.g;
                        m0Var.getClass();
                        j2 -= m0Var.c - m0Var.b;
                    }
                    j3 = j2;
                    m0Var2 = m0Var;
                }
                if (this.b) {
                    m0Var2.getClass();
                    if (m0Var2.d) {
                        byte[] bArr = m0Var2.a;
                        m0 m0Var3 = new m0(Arrays.copyOf(bArr, bArr.length), m0Var2.b, m0Var2.c, false, true);
                        if (jVar.a == m0Var2) {
                            jVar.a = m0Var3;
                        }
                        m0Var2.b(m0Var3);
                        m0 m0Var4 = m0Var3.g;
                        m0Var4.getClass();
                        m0Var4.a();
                        m0Var2 = m0Var3;
                    }
                }
                this.c = m0Var2;
                this.d = j;
                m0Var2.getClass();
                this.e = m0Var2.a;
                int i = m0Var2.b + ((int) (j - j3));
                this.f = i;
                int i2 = m0Var2.c;
                this.g = i2;
                return i2 - i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + jVar.b);
    }
}
