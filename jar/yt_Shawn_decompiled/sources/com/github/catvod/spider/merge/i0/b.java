package com.github.catvod.spider.merge.i0;

import java.io.PrintStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b {
    public static final boolean a;
    public static /* synthetic */ Class b;

    static {
        try {
            a = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    public static void a(String str) {
        if (a) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer("STREAM: ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    public static Object b(String str, ClassLoader classLoader) {
        try {
            return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer = new StringBuffer("Provider ");
            stringBuffer.append(str);
            stringBuffer.append(" not found");
            throw new a(stringBuffer.toString(), e);
        } catch (Exception e2) {
            StringBuffer stringBuffer2 = new StringBuffer("Provider ");
            stringBuffer2.append(str);
            stringBuffer2.append(" could not be instantiated: ");
            stringBuffer2.append(e2);
            throw new a(stringBuffer2.toString(), e2);
        }
    }
}
