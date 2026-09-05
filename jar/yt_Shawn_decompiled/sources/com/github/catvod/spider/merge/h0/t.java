package com.github.catvod.spider.merge.h0;

import com.github.catvod.spider.jdollar.net.URLDecoder;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class t {
    public static final Pattern g = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
    public static final Pattern h = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
    public static final Pattern i = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
    public static final Logger j = Logger.getLogger(t.class.getName());
    public static HashMap k;
    public final int a;
    public volatile ServerSocket b;
    public r c = new f();
    public Thread d;
    public a e;
    public s f;

    public t(int i2) {
        this.a = i2;
        setTempFileManagerFactory(new f());
        setAsyncRunner(new e());
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            j.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    public static void c(String str, Map map) throws IOException {
        Logger logger = j;
        try {
            Enumeration<URL> resources = t.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                Properties properties = new Properties();
                InputStream inputStreamOpenStream = null;
                try {
                    try {
                        inputStreamOpenStream = urlNextElement.openStream();
                        properties.load(inputStreamOpenStream);
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "could not load mimetypes from " + urlNextElement, (Throwable) e);
                    }
                    d(inputStreamOpenStream);
                    map.putAll(properties);
                } catch (Throwable th) {
                    d(inputStreamOpenStream);
                    throw th;
                }
            }
        } catch (IOException unused) {
            logger.log(Level.INFO, "no mime types available at ".concat(str));
        }
    }

    public static final void d(Object obj) throws IOException {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e) {
                j.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    public static boolean e(o oVar) {
        String str = oVar.b;
        if (str != null) {
            return str.toLowerCase().contains("text/") || str.toLowerCase().contains("/json");
        }
        return false;
    }

    public static String getMimeTypeForFile(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        String str2 = iLastIndexOf >= 0 ? mimeTypes().get(str.substring(iLastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = t.class.getResourceAsStream(str);
            if (resourceAsStream == null) {
                throw new IOException("Unable to load keystore from classpath: " + str);
            }
            keyStore.load(resourceAsStream, cArr);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, cArr);
            return makeSSLSocketFactory(keyStore, keyManagerFactory);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.w(e.getMessage());
            return null;
        }
    }

    public static Map<String, String> mimeTypes() throws IOException {
        if (k == null) {
            HashMap map = new HashMap();
            k = map;
            c("META-INF/nanohttpd/default-mimetypes.properties", map);
            c("META-INF/nanohttpd/mimetypes.properties", k);
            if (k.isEmpty()) {
                j.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return k;
    }

    public static o newChunkedResponse(m mVar, String str, InputStream inputStream) {
        return new o(mVar, str, inputStream, -1L);
    }

    public static o newFixedLengthResponse(m mVar, String str, String str2) throws UnsupportedEncodingException {
        byte[] bytes;
        c cVar = new c(str);
        if (str2 == null) {
            return newFixedLengthResponse(mVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(cVar.a()).newEncoder().canEncode(str2) && cVar.c == null) {
                cVar = new c(str + "; charset=UTF-8");
            }
            bytes = str2.getBytes(cVar.a());
        } catch (UnsupportedEncodingException e) {
            j.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bytes = new byte[0];
        }
        return newFixedLengthResponse(mVar, cVar.a, new ByteArrayInputStream(bytes), bytes.length);
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    public String getHostname() {
        return null;
    }

    public final int getListeningPort() {
        if (this.b == null) {
            return -1;
        }
        return this.b.getLocalPort();
    }

    public r getServerSocketFactory() {
        return this.c;
    }

    public s getTempFileManagerFactory() {
        return this.f;
    }

    public final boolean isAlive() {
        return wasStarted() && !this.b.isClosed() && this.d.isAlive();
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        com.github.catvod.spider.merge.g1.b bVar = new com.github.catvod.spider.merge.g1.b(2, false);
        bVar.b = sSLServerSocketFactory;
        bVar.c = strArr;
        this.c = bVar;
    }

    public abstract o serve(i iVar);

    @Deprecated
    public o serve(String str, j jVar, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return newFixedLengthResponse(n.e, "text/plain", "Not Found");
    }

    public void setAsyncRunner(a aVar) {
        this.e = aVar;
    }

    public void setServerSocketFactory(r rVar) {
        this.c = rVar;
    }

    public void setTempFileManagerFactory(s sVar) {
        this.f = sVar;
    }

    public void start(int i2, boolean z) throws IOException {
        this.b = getServerSocketFactory().create();
        this.b.setReuseAddress(true);
        q qVar = new q(this, i2);
        Thread thread = new Thread(qVar);
        this.d = thread;
        thread.setDaemon(z);
        this.d.setName("NanoHttpd Main Listener");
        this.d.start();
        while (!qVar.c && qVar.b == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = qVar.b;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void stop() throws InterruptedException {
        try {
            d(this.b);
            e eVar = (e) this.e;
            eVar.getClass();
            Iterator it = new ArrayList(eVar.b).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                d(bVar.a);
                d(bVar.b);
            }
            Thread thread = this.d;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e) {
            j.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
        }
    }

    public final boolean wasStarted() {
        return (this.b == null || this.d == null) ? false : true;
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.w(e.getMessage());
            return null;
        }
    }

    public void start(int i2) throws IOException {
        start(i2, true);
    }

    public void start() throws IOException {
        start(5000);
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) throws NoSuchAlgorithmException, IOException, KeyStoreException, KeyManagementException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(keyManagerArr, trustManagerFactory.getTrustManagers(), null);
            return sSLContext.getServerSocketFactory();
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.w(e.getMessage());
            return null;
        }
    }

    public static o newFixedLengthResponse(m mVar, String str, InputStream inputStream, long j2) {
        return new o(mVar, str, inputStream, j2);
    }

    public static o newFixedLengthResponse(String str) {
        return newFixedLengthResponse(n.c, "text/html", str);
    }
}
