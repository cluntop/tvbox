package com.github.catvod.spider.merge.k;

import com.github.catvod.spider.merge.y0.p0;
import com.github.catvod.spider.merge.y0.q0;
import com.github.catvod.spider.merge.y0.r0;
import com.github.catvod.spider.merge.z0.g;
import com.github.catvod.spider.merge.z0.h;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements q0 {
    public final /* synthetic */ int a;
    public Object b;
    public Serializable c;
    public Object d;
    public Object e;

    public a(Socket socket) {
        this.a = 1;
        this.b = socket;
        this.c = new AtomicInteger();
        this.d = new h(this);
        this.e = new g(this);
    }

    @Override // com.github.catvod.spider.merge.y0.q0
    public void cancel() throws IOException {
        ((Socket) this.b).close();
    }

    @Override // com.github.catvod.spider.merge.y0.q0
    public p0 getSink() {
        return (g) this.e;
    }

    @Override // com.github.catvod.spider.merge.y0.q0
    public r0 getSource() {
        return (h) this.d;
    }

    public String toString() {
        switch (this.a) {
            case 1:
                String string = ((Socket) this.b).toString();
                string.getClass();
                return string;
            default:
                return super.toString();
        }
    }
}
