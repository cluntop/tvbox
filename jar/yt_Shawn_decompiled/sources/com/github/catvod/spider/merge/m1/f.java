package com.github.catvod.spider.merge.m1;

import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class f {
    public static final boolean b;
    public final Pattern a;

    static {
        boolean z = false;
        try {
            try {
                Class<?> cls = Class.forName("com.google.re2j.Pattern", false, f.class.getClassLoader());
                try {
                    Class<?> cls2 = Class.forName("java.lang.Module");
                    Method method = Class.class.getMethod("getModule", null);
                    Object objInvoke = method.invoke(f.class, null);
                    Object objInvoke2 = method.invoke(cls, null);
                    if (!((Boolean) cls2.getMethod("canRead", cls2).invoke(objInvoke, objInvoke2)).booleanValue()) {
                        cls2.getMethod("addReads", cls2).invoke(objInvoke, objInvoke2);
                    }
                } catch (ClassNotFoundException unused) {
                }
                z = true;
            } catch (ClassNotFoundException unused2) {
            }
        } catch (ReflectiveOperationException e) {
            System.err.println("Warning: (bug? please report) couldn't access re2j from jsoup due to modules: " + e);
        }
        b = z;
    }

    public f(Pattern pattern) {
        this.a = pattern;
    }

    public static f a(String str) {
        if (b && Boolean.parseBoolean(System.getProperty("jsoup.useRe2j", "true"))) {
            return c.c(str);
        }
        try {
            return new f(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            throw new g("Pattern syntax error: " + e.getMessage());
        }
    }

    public e b(String str) {
        return new d(this.a.matcher(str));
    }

    public String toString() {
        return this.a.toString();
    }
}
