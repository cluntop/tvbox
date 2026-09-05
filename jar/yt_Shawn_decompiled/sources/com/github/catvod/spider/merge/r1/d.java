package com.github.catvod.spider.merge.r1;

import com.github.catvod.spider.merge.u.c2;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d {
    public static final /* synthetic */ int a = 0;

    static {
        String[] strArr = {"org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk18.VMBridge_jdk18"};
        for (int i = 0; i != 2; i++) {
            Class clsH = c2.h(strArr[i]);
            if (clsH != null) {
                Object objNewInstance = null;
                try {
                    objNewInstance = clsH.getDeclaredConstructor(null).newInstance(null);
                } catch (IllegalAccessException | InstantiationException | LinkageError | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
                }
                if (objNewInstance != null) {
                    throw new ClassCastException();
                }
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }
}
