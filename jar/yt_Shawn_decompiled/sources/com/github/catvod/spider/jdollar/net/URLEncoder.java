package com.github.catvod.spider.jdollar.net;

import com.github.catvod.spider.jdollar.sun.security.action.a;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class URLEncoder {
    public static final BitSet a = new BitSet(256);
    public static final String b;

    static {
        String property;
        for (int i = 97; i <= 122; i++) {
            a.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            a.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            a.set(i3);
        }
        BitSet bitSet = a;
        bitSet.set(32);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        bitSet.set(42);
        if (System.getSecurityManager() == null) {
            property = System.getProperty("file.encoding");
        } else {
            a aVar = new a();
            aVar.b = "file.encoding";
            property = (String) AccessController.doPrivileged(aVar);
        }
        b = property;
    }

    public static String encode(String str, Charset charset) {
        BitSet bitSet;
        int i;
        char cCharAt;
        Objects.requireNonNull(charset, "charset");
        StringBuilder sb = new StringBuilder(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int i2 = 0;
        boolean z = false;
        while (i2 < str.length()) {
            char cCharAt2 = str.charAt(i2);
            if (a.get(cCharAt2)) {
                if (cCharAt2 == ' ') {
                    cCharAt2 = '+';
                    z = true;
                }
                sb.append(cCharAt2);
                i2++;
            } else {
                do {
                    charArrayWriter.write(cCharAt2);
                    if (cCharAt2 >= 55296 && cCharAt2 <= 56319 && (i = i2 + 1) < str.length() && (cCharAt = str.charAt(i)) >= 56320 && cCharAt <= 57343) {
                        charArrayWriter.write(cCharAt);
                        i2 = i;
                    }
                    i2++;
                    if (i2 >= str.length()) {
                        break;
                    }
                    bitSet = a;
                    cCharAt2 = str.charAt(i2);
                } while (!bitSet.get(cCharAt2));
                charArrayWriter.flush();
                byte[] bytes = new String(charArrayWriter.toCharArray()).getBytes(charset);
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    sb.append('%');
                    char cForDigit = Character.forDigit((bytes[i3] >> 4) & 15, 16);
                    if (Character.isLetter(cForDigit)) {
                        cForDigit = (char) (cForDigit - ' ');
                    }
                    sb.append(cForDigit);
                    char cForDigit2 = Character.forDigit(bytes[i3] & 15, 16);
                    if (Character.isLetter(cForDigit2)) {
                        cForDigit2 = (char) (cForDigit2 - ' ');
                    }
                    sb.append(cForDigit2);
                }
                charArrayWriter.reset();
                z = true;
            }
        }
        return z ? sb.toString() : str;
    }

    public static String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str2 != null) {
            try {
                return encode(str, Charset.forName(str2));
            } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
                throw new UnsupportedEncodingException(str2);
            }
        }
        throw new NullPointerException("charsetName");
    }

    public static String encode(String str) {
        try {
            return encode(str, b);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
