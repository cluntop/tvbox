package com.github.catvod.spider.jdollar.nio.file.spi;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements PrivilegedAction {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                ArrayList arrayList = new ArrayList();
                Iterator it = ServiceLoader.load(d.class, ClassLoader.getSystemClassLoader()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    String strL = dVar.l();
                    if (!strL.equalsIgnoreCase("file")) {
                        int size = arrayList.size();
                        int i = 0;
                        while (true) {
                            if (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                if (((d) obj).l().equalsIgnoreCase(strL)) {
                                    break;
                                }
                            } else {
                                arrayList.add(dVar);
                            }
                        }
                    }
                }
                return arrayList;
            case 1:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
            case 2:
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            default:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    }
}
