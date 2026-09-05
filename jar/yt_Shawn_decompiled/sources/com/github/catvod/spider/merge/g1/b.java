package com.github.catvod.spider.merge.g1;

import com.github.catvod.spider.merge.h0.g;
import com.github.catvod.spider.merge.h0.r;
import com.github.catvod.spider.merge.h0.t;
import com.github.catvod.spider.merge.n1.c;
import com.github.catvod.spider.merge.n1.i;
import com.github.catvod.spider.merge.u.c2;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.ServerSocket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* loaded from: classes.dex */
public final class b implements r {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public b(int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.b = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
                byte[] bArr = new byte[128];
                this.c = bArr;
                int i2 = 0;
                for (int i3 = 0; i3 < 128; i3++) {
                    bArr[i3] = -1;
                }
                while (true) {
                    byte[] bArr2 = (byte[]) this.b;
                    if (i2 >= bArr2.length) {
                        bArr[65] = bArr[97];
                        bArr[66] = bArr[98];
                        bArr[67] = bArr[99];
                        bArr[68] = bArr[100];
                        bArr[69] = bArr[101];
                        bArr[70] = bArr[102];
                        break;
                    } else {
                        bArr[bArr2[i2]] = (byte) i2;
                        i2++;
                    }
                }
            case 4:
                this.b = VideoStream.RESOLUTION_UNKNOWN;
                new HashMap();
                break;
            default:
                File file = new File(System.getProperty("java.io.tmpdir"));
                this.b = file;
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.c = new ArrayList();
                break;
        }
    }

    public void a(char c) {
        StringBuilder sb = (StringBuilder) this.c;
        if (sb != null) {
            sb.append(c);
            return;
        }
        if (((String) this.b) == null) {
            this.b = String.valueOf(c);
            return;
        }
        StringBuilder sbB = i.b();
        this.c = sbB;
        sbB.append((String) this.b);
        this.b = null;
        ((StringBuilder) this.c).append(c);
    }

    public void b(String str) {
        StringBuilder sb = (StringBuilder) this.c;
        if (sb != null) {
            sb.append(str);
            return;
        }
        if (((String) this.b) == null) {
            this.b = str;
            return;
        }
        StringBuilder sbB = i.b();
        this.c = sbB;
        sbB.append((String) this.b);
        this.b = null;
        ((StringBuilder) this.c).append(str);
    }

    public Object c() {
        c cVar = (c) this.b;
        ArrayDeque arrayDeque = (ArrayDeque) ((SoftReference) cVar.get()).get();
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            cVar.set(new SoftReference(arrayDeque));
        }
        return !arrayDeque.isEmpty() ? arrayDeque.pop() : ((Supplier) this.c).get();
    }

    @Override // com.github.catvod.spider.merge.h0.r
    public ServerSocket create() {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) ((SSLServerSocketFactory) this.b).createServerSocket();
        String[] strArr = (String[]) this.c;
        if (strArr != null) {
            sSLServerSocket.setEnabledProtocols(strArr);
        } else {
            sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
        }
        sSLServerSocket.setUseClientMode(false);
        sSLServerSocket.setWantClientAuth(false);
        sSLServerSocket.setNeedClientAuth(false);
        return sSLServerSocket;
    }

    public void d() throws Exception {
        File file;
        ArrayList arrayList = (ArrayList) this.c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            try {
                t.d(gVar.b);
                file = gVar.a;
            } catch (Exception e) {
                t.j.log(Level.WARNING, "could not delete file ", (Throwable) e);
            }
            if (!file.delete()) {
                throw new Exception("could not delete temporary file: " + file.getAbsolutePath());
            }
        }
        arrayList.clear();
    }

    public byte[] e(int i, String str) throws IOException {
        String str2;
        byte[] bArr = (byte[]) this.c;
        if (i < 0 || str.length() - i < 0) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i & 1) == 0) {
            int i2 = i >>> 1;
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i3 + 1;
                byte b = bArr[str.charAt(i3)];
                i3 += 2;
                int i6 = bArr[str.charAt(i5)] | (b << 4);
                if (i6 >= 0) {
                    bArr2[i4] = (byte) i6;
                } else {
                    str2 = "invalid characters encountered in Hex string";
                }
            }
            return bArr2;
        }
        str2 = "a hexadecimal encoding must have an even number of characters";
        com.github.catvod.spider.merge.s0.a.w(str2);
        return null;
    }

    public boolean f() {
        return (((StringBuilder) this.c) == null && ((String) this.b) == null) ? false : true;
    }

    public void g(byte[] bArr) {
        long[] jArr = ((long[][]) this.c)[bArr[15] & 255];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = ((long[][]) this.c)[bArr[i] & 255];
            long j3 = j2 << 56;
            j2 = ((j2 >>> 8) | (j << 56)) ^ jArr2[1];
            j = (((((j >>> 8) ^ jArr2[0]) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
        }
        c2.L(bArr, 0, j);
        c2.L(bArr, 8, j2);
    }

    public void h(Object obj) {
        c cVar = (c) this.b;
        ArrayDeque arrayDeque = (ArrayDeque) ((SoftReference) cVar.get()).get();
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            cVar.set(new SoftReference(arrayDeque));
        }
        if (arrayDeque.size() < 12) {
            arrayDeque.push(obj);
        }
    }

    public void i() {
        StringBuilder sb = (StringBuilder) this.c;
        if (sb != null) {
            String[] strArr = i.a;
            if (sb.length() <= 8192) {
                sb.delete(0, sb.length());
                i.e.h(sb);
            }
            this.c = null;
        }
        this.b = null;
    }

    public String j() {
        StringBuilder sb = (StringBuilder) this.c;
        if (sb == null) {
            String str = (String) this.b;
            return str != null ? str : VideoStream.RESOLUTION_UNKNOWN;
        }
        this.b = sb.toString();
        i.l((StringBuilder) this.c);
        this.c = null;
        return (String) this.b;
    }

    public String toString() {
        switch (this.a) {
            case 6:
                return "<" + ((String) this.b) + ">: " + ((String) this.c);
            case 7:
                StringBuilder sb = (StringBuilder) this.c;
                if (sb != null) {
                    return sb.toString();
                }
                String str = (String) this.b;
                return str != null ? str : VideoStream.RESOLUTION_UNKNOWN;
            default:
                return super.toString();
        }
    }

    public b(com.github.catvod.spider.merge.p1.a aVar, String str) {
        this.a = 6;
        aVar.getClass();
        this.b = aVar.U();
        this.c = str;
    }

    public b(com.github.catvod.spider.merge.p1.a aVar, String str, Object[] objArr) {
        this.a = 6;
        aVar.getClass();
        this.b = aVar.U();
        this.c = String.format(str, objArr);
    }

    public b(String str, Map map) {
        this.a = 4;
        this.b = str;
        this.c = map;
    }

    public b(Supplier supplier) {
        this.a = 5;
        this.c = supplier;
        int i = 0;
        this.b = new c(new com.github.catvod.spider.merge.n1.b(i), i);
    }

    public /* synthetic */ b(int i, boolean z) {
        this.a = i;
    }
}
