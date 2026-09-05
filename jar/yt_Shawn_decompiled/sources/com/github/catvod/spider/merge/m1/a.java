package com.github.catvod.spider.merge.m1;

import com.github.catvod.spider.merge.q1.v;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class a {
    public static final Charset a;

    static {
        Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
        Charset charsetForName = Charset.forName("UTF-8");
        a = charsetForName;
        charsetForName.name();
        v.H("meta[http-equiv=content-type], meta[charset]");
    }
}
