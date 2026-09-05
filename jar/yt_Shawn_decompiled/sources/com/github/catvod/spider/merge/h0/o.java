package com.github.catvod.spider.merge.h0;

import com.github.catvod.spider.jdollar.util.DesugarTimeZone;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o implements Closeable {
    public final m a;
    public final String b;
    public final InputStream c;
    public final long d;
    public final k e = new k(this);
    public final HashMap f = new HashMap();
    public j g;
    public boolean h;
    public boolean i;
    public boolean j;

    public o(m mVar, String str, InputStream inputStream, long j) {
        this.a = mVar;
        this.b = str;
        if (inputStream == null) {
            this.c = new ByteArrayInputStream(new byte[0]);
            this.d = 0L;
        } else {
            this.c = inputStream;
            this.d = j;
        }
        this.h = this.d < 0;
        this.j = true;
    }

    public static void B(PrintWriter printWriter, String str, String str2) {
        printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
    }

    public final boolean A() {
        return "close".equals(z("connection"));
    }

    public final void C(OutputStream outputStream) throws IOException, NumberFormatException {
        String str = this.b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        m mVar = this.a;
        try {
            if (mVar == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new c(str).a())), false);
            n nVar = (n) mVar;
            printWriter.append("HTTP/1.1 ").append(VideoStream.RESOLUTION_UNKNOWN + nVar.a + Stream.ID_UNKNOWN + nVar.b).append(" \r\n");
            if (str != null) {
                B(printWriter, "Content-Type", str);
            }
            if (z("date") == null) {
                B(printWriter, "Date", simpleDateFormat.format(new Date()));
            }
            for (Map.Entry entry : this.e.entrySet()) {
                B(printWriter, (String) entry.getKey(), (String) entry.getValue());
            }
            if (z("connection") == null) {
                B(printWriter, "Connection", this.j ? "keep-alive" : "close");
            }
            if (z("content-length") != null) {
                this.i = false;
            }
            if (this.i) {
                B(printWriter, "Content-Encoding", "gzip");
                this.h = true;
            }
            InputStream inputStream = this.c;
            long jE = inputStream != null ? this.d : 0L;
            j jVar = this.g;
            j jVar2 = j.c;
            if (jVar != jVar2 && this.h) {
                B(printWriter, "Transfer-Encoding", "chunked");
            } else if (!this.i) {
                jE = E(printWriter, jE);
            }
            printWriter.append("\r\n");
            printWriter.flush();
            if (this.g != jVar2 && this.h) {
                l lVar = new l(outputStream);
                if (this.i) {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(lVar);
                    D(gZIPOutputStream, -1L);
                    gZIPOutputStream.finish();
                } else {
                    D(lVar, -1L);
                }
                lVar.j();
            } else if (this.i) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                D(gZIPOutputStream2, -1L);
                gZIPOutputStream2.finish();
            } else {
                D(outputStream, jE);
            }
            outputStream.flush();
            t.d(inputStream);
        } catch (IOException e) {
            t.j.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
        }
    }

    public final void D(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[16384];
        boolean z = j == -1;
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            int i = this.c.read(bArr, 0, (int) (z ? 16384L : Math.min(j, 16384L)));
            if (i <= 0) {
                return;
            }
            outputStream.write(bArr, 0, i);
            if (!z) {
                j -= i;
            }
        }
    }

    public final long E(PrintWriter printWriter, long j) throws NumberFormatException {
        String strZ = z("content-length");
        if (strZ != null) {
            try {
                j = Long.parseLong(strZ);
            } catch (NumberFormatException unused) {
                t.j.severe("content-length was no number ".concat(strZ));
            }
        }
        printWriter.print("Content-Length: " + j + "\r\n");
        return j;
    }

    public final void F(boolean z) {
        this.i = z;
    }

    public final void G(boolean z) {
        this.j = z;
    }

    public final void H(j jVar) {
        this.g = jVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final void j(String str, String str2) {
        this.e.put(str, str2);
    }

    public final String z(String str) {
        return (String) this.f.get(str.toLowerCase());
    }
}
