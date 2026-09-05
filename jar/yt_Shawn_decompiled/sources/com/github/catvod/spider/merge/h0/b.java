package com.github.catvod.spider.merge.h0;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b implements Runnable {
    public final InputStream a;
    public final Socket b;
    public final /* synthetic */ t c;

    public b(t tVar, InputStream inputStream, Socket socket) {
        this.c = tVar;
        this.a = inputStream;
        this.b = socket;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        OutputStream outputStream;
        InputStream inputStream = this.a;
        t tVar = this.c;
        Socket socket = this.b;
        OutputStream outputStream2 = null;
        try {
            try {
                outputStream = socket.getOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            ((f) tVar.f).getClass();
            h hVar = new h(tVar, new com.github.catvod.spider.merge.g1.b(1), this.a, outputStream, socket.getInetAddress());
            while (!socket.isClosed()) {
                hVar.d();
            }
            t.d(outputStream);
        } catch (Exception e2) {
            e = e2;
            outputStream2 = outputStream;
            if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                t.j.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e);
            }
            t.d(outputStream2);
            t.d(inputStream);
            t.d(socket);
            ((e) tVar.e).b.remove(this);
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            t.d(outputStream2);
            t.d(inputStream);
            t.d(socket);
            ((e) tVar.e).b.remove(this);
            throw th;
        }
        t.d(inputStream);
        t.d(socket);
        ((e) tVar.e).b.remove(this);
    }
}
