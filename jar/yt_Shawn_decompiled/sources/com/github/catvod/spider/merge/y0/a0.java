package com.github.catvod.spider.merge.y0;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a0 implements r0 {
    public final l0 a;
    public final Inflater b;
    public int c;
    public boolean d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(r0 r0Var, Inflater inflater) {
        this(new l0(r0Var), inflater);
        r0Var.getClass();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    public final long j(j jVar, long j) throws DataFormatException, IOException {
        Inflater inflater = this.b;
        jVar.getClass();
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
            return 0L;
        }
        if (this.d) {
            com.github.catvod.spider.merge.s0.a.h("closed");
            return 0L;
        }
        if (j != 0) {
            try {
                m0 m0VarL = jVar.L(1);
                int iMin = (int) Math.min(j, 8192 - m0VarL.c);
                boolean zNeedsInput = inflater.needsInput();
                l0 l0Var = this.a;
                if (zNeedsInput && !l0Var.n()) {
                    m0 m0Var = l0Var.b.a;
                    m0Var.getClass();
                    int i = m0Var.c;
                    int i2 = m0Var.b;
                    int i3 = i - i2;
                    this.c = i3;
                    inflater.setInput(m0Var.a, i2, i3);
                }
                int iInflate = inflater.inflate(m0VarL.a, m0VarL.c, iMin);
                int i4 = this.c;
                if (i4 != 0) {
                    int remaining = i4 - inflater.getRemaining();
                    this.c -= remaining;
                    l0Var.skip(remaining);
                }
                if (iInflate > 0) {
                    m0VarL.c += iInflate;
                    long j2 = iInflate;
                    jVar.b += j2;
                    return j2;
                }
                if (m0VarL.b == m0VarL.c) {
                    jVar.a = m0VarL.a();
                    n0.a(m0VarL);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(j jVar, long j) throws DataFormatException, IOException {
        jVar.getClass();
        do {
            long j2 = j(jVar, j);
            if (j2 > 0) {
                return j2;
            }
            Inflater inflater = this.b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.a.n());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return this.a.a.timeout();
    }

    public a0(l0 l0Var, Inflater inflater) {
        this.a = l0Var;
        this.b = inflater;
    }
}
