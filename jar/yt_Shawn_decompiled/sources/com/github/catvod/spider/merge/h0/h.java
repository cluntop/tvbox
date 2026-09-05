package com.github.catvod.spider.merge.h0;

import com.github.catvod.spider.jdollar.nio.channels.DesugarChannels;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import javax.net.ssl.SSLException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h implements i {
    public final com.github.catvod.spider.merge.g1.b a;
    public final OutputStream b;
    public final BufferedInputStream c;
    public int d;
    public int e;
    public String f;
    public j g;
    public HashMap h;
    public HashMap i;
    public d j;
    public final String k;
    public String l;
    public final /* synthetic */ t m;

    public h(t tVar, com.github.catvod.spider.merge.g1.b bVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.m = tVar;
        this.a = bVar;
        this.c = new BufferedInputStream(inputStream, 8192);
        this.b = outputStream;
        this.k = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
            inetAddress.getHostName().getClass();
        }
        this.i = new HashMap();
    }

    public static void c(String str, Map map) {
        String strTrim;
        String strB;
        if (str == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(61);
            if (iIndexOf >= 0) {
                strTrim = t.b(strNextToken.substring(0, iIndexOf)).trim();
                strB = t.b(strNextToken.substring(iIndexOf + 1));
            } else {
                strTrim = t.b(strNextToken).trim();
                strB = VideoStream.RESOLUTION_UNKNOWN;
            }
            List arrayList = (List) map.get(strTrim);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(strTrim, arrayList);
            }
            arrayList.add(strB);
        }
    }

    public static int e(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i) {
                return 0;
            }
            byte b = bArr[i3];
            if (b == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                return i3 + 4;
            }
            if (b == 10 && bArr[i4] == 10) {
                return i3 + 2;
            }
            i3 = i4;
        }
    }

    public static int[] f(ByteBuffer byteBuffer, byte[] bArr) {
        int[] iArr = new int[0];
        if (byteBuffer.remaining() < bArr.length) {
            return iArr;
        }
        int length = bArr.length + 4096;
        byte[] bArr2 = new byte[length];
        int iRemaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
        byteBuffer.get(bArr2, 0, iRemaining);
        int length2 = iRemaining - bArr.length;
        int i = 0;
        do {
            for (int i2 = 0; i2 < length2; i2++) {
                for (int i3 = 0; i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]; i3++) {
                    if (i3 == bArr.length - 1) {
                        int[] iArr2 = new int[iArr.length + 1];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        iArr2[iArr.length] = i + i2;
                        iArr = iArr2;
                    }
                }
            }
            i += length2;
            System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
            length2 = length - bArr.length;
            if (byteBuffer.remaining() < length2) {
                length2 = byteBuffer.remaining();
            }
            byteBuffer.get(bArr2, bArr.length, length2);
        } while (length2 > 0);
        return iArr;
    }

    public final void a(BufferedReader bufferedReader, HashMap map, HashMap map2, HashMap map3) throws p, IOException {
        String strB;
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            boolean zHasMoreTokens = stringTokenizer.hasMoreTokens();
            n nVar = n.d;
            if (!zHasMoreTokens) {
                throw new p(nVar, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put("method", stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new p(nVar, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(63);
            if (iIndexOf >= 0) {
                c(strNextToken.substring(iIndexOf + 1), map2);
                strB = t.b(strNextToken.substring(0, iIndexOf));
            } else {
                strB = t.b(strNextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.l = stringTokenizer.nextToken();
            } else {
                this.l = "HTTP/1.1";
                t.j.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            String line2 = bufferedReader.readLine();
            while (line2 != null && !line2.trim().isEmpty()) {
                int iIndexOf2 = line2.indexOf(58);
                if (iIndexOf2 >= 0) {
                    map3.put(line2.substring(0, iIndexOf2).trim().toLowerCase(Locale.US), line2.substring(iIndexOf2 + 1).trim());
                }
                line2 = bufferedReader.readLine();
            }
            map.put("uri", strB);
        } catch (IOException e) {
            throw new p("SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    public final void b(c cVar, ByteBuffer byteBuffer, HashMap map, HashMap map2) throws Throwable {
        int[] iArrF;
        int length;
        n nVar;
        String str;
        c cVar2 = cVar;
        String str2 = cVar2.d;
        n nVar2 = n.f;
        try {
            iArrF = f(byteBuffer, str2.getBytes());
            length = iArrF.length;
            nVar = n.d;
        } catch (p e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (length < 2) {
                throw new p(nVar, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            }
            int i = 1024;
            byte[] bArr = new byte[1024];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < iArrF.length - 1) {
                byteBuffer.position(iArrF[i3]);
                int iRemaining = byteBuffer.remaining() < i ? byteBuffer.remaining() : 1024;
                byteBuffer.get(bArr, i2, iRemaining);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i2, iRemaining), Charset.forName(cVar2.a())), iRemaining);
                String line = bufferedReader.readLine();
                if (line == null || !line.contains(str2)) {
                    throw new p(nVar, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                String line2 = bufferedReader.readLine();
                String strGroup = null;
                String strTrim = null;
                int i5 = i4;
                int i6 = 2;
                String str3 = null;
                while (line2 != null && line2.trim().length() > 0) {
                    Matcher matcher = t.g.matcher(line2);
                    if (matcher.matches()) {
                        str = str2;
                        Matcher matcher2 = t.i.matcher(matcher.group(2));
                        while (matcher2.find()) {
                            int[] iArr = iArrF;
                            String strGroup2 = matcher2.group(1);
                            if ("name".equalsIgnoreCase(strGroup2)) {
                                strGroup = matcher2.group(2);
                            } else if ("filename".equalsIgnoreCase(strGroup2)) {
                                String strGroup3 = matcher2.group(2);
                                if (strGroup3.isEmpty()) {
                                    str3 = strGroup3;
                                } else if (i5 > 0) {
                                    str3 = strGroup3;
                                    i5++;
                                    strGroup = strGroup + String.valueOf(i5);
                                } else {
                                    i5++;
                                    str3 = strGroup3;
                                }
                            }
                            iArrF = iArr;
                        }
                    } else {
                        str = str2;
                    }
                    int[] iArr2 = iArrF;
                    Matcher matcher3 = t.h.matcher(line2);
                    if (matcher3.matches()) {
                        strTrim = matcher3.group(2).trim();
                    }
                    line2 = bufferedReader.readLine();
                    i6++;
                    iArrF = iArr2;
                    str2 = str;
                }
                String str4 = str2;
                int[] iArr3 = iArrF;
                int i7 = 0;
                while (true) {
                    int i8 = i6 - 1;
                    if (i6 <= 0) {
                        break;
                    }
                    while (bArr[i7] != 10) {
                        i7++;
                    }
                    i7++;
                    i6 = i8;
                }
                if (i7 >= iRemaining - 4) {
                    throw new p(nVar2, "Multipart header size exceeds MAX_HEADER_SIZE.");
                }
                int i9 = iArr3[i3] + i7;
                i3++;
                int i10 = iArr3[i3] - 4;
                byteBuffer.position(i9);
                List arrayList = (List) map.get(strGroup);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(strGroup, arrayList);
                }
                if (strTrim == null) {
                    byte[] bArr2 = new byte[i10 - i9];
                    byteBuffer.get(bArr2);
                    arrayList.add(new String(bArr2, cVar.a()));
                } else {
                    String strH = h(byteBuffer, i9, i10 - i9);
                    if (map2.containsKey(strGroup)) {
                        int i11 = 2;
                        while (true) {
                            if (!map2.containsKey(strGroup + i11)) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        map2.put(strGroup + i11, strH);
                    } else {
                        map2.put(strGroup, strH);
                    }
                    arrayList.add(str3);
                }
                cVar2 = cVar;
                iArrF = iArr3;
                i4 = i5;
                str2 = str4;
                i = 1024;
                i2 = 0;
            }
        } catch (p e3) {
            throw e3;
        } catch (Exception e4) {
            e = e4;
            throw new p(nVar2, e.toString());
        }
    }

    public final void d() throws Exception {
        n nVar = n.f;
        t tVar = this.m;
        com.github.catvod.spider.merge.g1.b bVar = this.a;
        BufferedInputStream bufferedInputStream = this.c;
        OutputStream outputStream = this.b;
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        boolean z = false;
                        this.d = 0;
                        this.e = 0;
                        bufferedInputStream.mark(8192);
                        try {
                            int i = bufferedInputStream.read(bArr, 0, 8192);
                            if (i == -1) {
                                t.d(bufferedInputStream);
                                t.d(outputStream);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            while (i > 0) {
                                int i2 = this.e + i;
                                this.e = i2;
                                int iE = e(bArr, i2);
                                this.d = iE;
                                if (iE > 0) {
                                    break;
                                }
                                int i3 = this.e;
                                i = bufferedInputStream.read(bArr, i3, 8192 - i3);
                            }
                            if (this.d < this.e) {
                                bufferedInputStream.reset();
                                bufferedInputStream.skip(this.d);
                            }
                            this.h = new HashMap();
                            HashMap map = this.i;
                            if (map == null) {
                                this.i = new HashMap();
                            } else {
                                map.clear();
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.e)));
                            HashMap map2 = new HashMap();
                            a(bufferedReader, map2, this.h, this.i);
                            String str = this.k;
                            if (str != null) {
                                this.i.put("remote-addr", str);
                                this.i.put("http-client-ip", str);
                            }
                            j jVarA = j.a((String) map2.get("method"));
                            this.g = jVarA;
                            if (jVarA == null) {
                                throw new p(n.d, "BAD REQUEST: Syntax error. HTTP verb " + ((String) map2.get("method")) + " unhandled.");
                            }
                            this.f = (String) map2.get("uri");
                            this.j = new d(this.i);
                            String str2 = (String) this.i.get("connection");
                            boolean z2 = "HTTP/1.1".equals(this.l) && (str2 == null || !str2.matches("(?i).*close.*"));
                            o oVarServe = tVar.serve(this);
                            if (oVarServe == null) {
                                throw new p(nVar, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                            }
                            String str3 = (String) this.i.get("accept-encoding");
                            this.j.a();
                            oVarServe.H(this.g);
                            if (t.e(oVarServe) && str3 != null && str3.contains("gzip")) {
                                z = true;
                            }
                            oVarServe.F(z);
                            oVarServe.G(z2);
                            oVarServe.C(outputStream);
                            if (!z2 || oVarServe.A()) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            t.d(oVarServe);
                            bVar.d();
                        } catch (SSLException e) {
                            throw e;
                        } catch (IOException unused) {
                            t.d(bufferedInputStream);
                            t.d(outputStream);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                    } catch (p e2) {
                        t.newFixedLengthResponse(e2.a(), "text/plain", e2.getMessage()).C(outputStream);
                        t.d(outputStream);
                        t.d(null);
                        bVar.d();
                    }
                } catch (SSLException e3) {
                    t.newFixedLengthResponse(nVar, "text/plain", "SSL PROTOCOL FAILURE: " + e3.getMessage()).C(outputStream);
                    t.d(outputStream);
                    t.d(null);
                    bVar.d();
                } catch (IOException e4) {
                    t.newFixedLengthResponse(nVar, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e4.getMessage()).C(outputStream);
                    t.d(outputStream);
                    t.d(null);
                    bVar.d();
                }
            } catch (SocketException e5) {
                throw e5;
            } catch (SocketTimeoutException e6) {
                throw e6;
            }
        } catch (Throwable th) {
            t.d(null);
            bVar.d();
            throw th;
        }
    }

    public final void g(HashMap map) throws IOException {
        long j;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutput dataOutputStream;
        ByteBuffer map2;
        RandomAccessFile randomAccessFile = null;
        try {
            if (this.i.containsKey("content-length")) {
                j = Long.parseLong((String) this.i.get("content-length"));
            } else {
                j = this.d < this.e ? r4 - r3 : 0L;
            }
            if (j < 1024) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } else {
                try {
                    com.github.catvod.spider.merge.g1.b bVar = this.a;
                    g gVar = new g((File) bVar.b);
                    ((ArrayList) bVar.c).add(gVar);
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(gVar.a.getAbsolutePath(), "rw");
                    byteArrayOutputStream = null;
                    randomAccessFile = randomAccessFile2;
                    dataOutputStream = randomAccessFile2;
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
            byte[] bArr = new byte[512];
            while (this.e >= 0 && j > 0) {
                int i = this.c.read(bArr, 0, (int) Math.min(j, 512L));
                this.e = i;
                j -= i;
                if (i > 0) {
                    dataOutputStream.write(bArr, 0, i);
                }
            }
            if (byteArrayOutputStream != null) {
                map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            } else {
                map2 = DesugarChannels.convertMaybeLegacyFileChannelFromLibrary(randomAccessFile.getChannel()).map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                randomAccessFile.seek(0L);
            }
            if (j.b.equals(this.g)) {
                c cVar = new c((String) this.i.get("content-type"));
                String str = cVar.b;
                if (!"multipart/form-data".equalsIgnoreCase(str)) {
                    byte[] bArr2 = new byte[map2.remaining()];
                    map2.get(bArr2);
                    String strTrim = new String(bArr2, cVar.a()).trim();
                    if ("application/x-www-form-urlencoded".equalsIgnoreCase(str)) {
                        c(strTrim, this.h);
                    } else if (strTrim.length() != 0) {
                        map.put("postData", strTrim);
                    }
                } else {
                    if (cVar.d == null) {
                        throw new p(n.d, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                    b(cVar, map2, this.h, map);
                }
            } else if (j.a.equals(this.g)) {
                map.put("content", h(map2, 0, map2.limit()));
            }
        } finally {
            t.d(null);
        }
    }

    public final String h(ByteBuffer byteBuffer, int i, int i2) throws Throwable {
        File file;
        ByteBuffer byteBufferDuplicate;
        FileOutputStream fileOutputStream;
        if (i2 <= 0) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                com.github.catvod.spider.merge.g1.b bVar = this.a;
                g gVar = new g((File) bVar.b);
                ((ArrayList) bVar.c).add(gVar);
                file = gVar.a;
                byteBufferDuplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            FileChannel fileChannelConvertMaybeLegacyFileChannelFromLibrary = DesugarChannels.convertMaybeLegacyFileChannelFromLibrary(fileOutputStream.getChannel());
            byteBufferDuplicate.position(i).limit(i + i2);
            fileChannelConvertMaybeLegacyFileChannelFromLibrary.write(byteBufferDuplicate.slice());
            String absolutePath = file.getAbsolutePath();
            t.d(fileOutputStream);
            return absolutePath;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            throw new Error(e);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            t.d(fileOutputStream2);
            throw th;
        }
    }
}
