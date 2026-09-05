package com.github.catvod.spider.merge.w;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class c {
    public static final Charset a = Charset.defaultCharset();
    public static final Charset b;

    static {
        Charset charsetForName;
        Charset charsetForName2 = null;
        try {
            charsetForName = Charset.forName("SJIS");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        b = charsetForName;
        try {
            Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused2) {
        }
        try {
            charsetForName2 = Charset.forName("EUC_JP");
        } catch (UnsupportedCharsetException unused3) {
        }
        Charset charset = b;
        if ((charset == null || !charset.equals(a)) && charsetForName2 != null) {
            charsetForName2.equals(a);
        }
    }
}
