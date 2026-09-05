package com.github.catvod.spider.merge.z0;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l extends com.github.catvod.spider.merge.y0.f {
    public final Socket a;

    public l(Socket socket) {
        this.a = socket;
    }

    @Override // com.github.catvod.spider.merge.y0.f
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // com.github.catvod.spider.merge.y0.f
    public final void timedOut() throws IOException {
        Socket socket = this.a;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!q.a(e)) {
                throw e;
            }
            q.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e2) {
            q.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        }
    }
}
