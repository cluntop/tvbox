package com.github.catvod.spider.merge.h0;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q implements Runnable {
    public final int a;
    public IOException b;
    public boolean c = false;
    public final /* synthetic */ t d;

    public q(t tVar, int i) {
        this.d = tVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        try {
            this.d.b.bind(new InetSocketAddress(this.d.a));
            this.c = true;
            do {
                try {
                    Socket socketAccept = this.d.b.accept();
                    int i = this.a;
                    if (i > 0) {
                        socketAccept.setSoTimeout(i);
                    }
                    InputStream inputStream = socketAccept.getInputStream();
                    t tVar = this.d;
                    ((e) tVar.e).a(new b(tVar, inputStream, socketAccept));
                } catch (IOException e) {
                    t.j.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                }
            } while (!this.d.b.isClosed());
        } catch (IOException e2) {
            this.b = e2;
        }
    }
}
