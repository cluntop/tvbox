package com.github.catvod.spider.merge.j1;

import java.security.PrivilegedAction;
import java.security.Security;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* loaded from: classes.dex */
public final class b implements PrivilegedAction {
    public final /* synthetic */ int a;

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return Security.getProperty("org.bouncycastle.dh.allow_unsafe_p_value");
            default:
                return System.getProperty("org.bouncycastle.dh.allow_unsafe_p_value");
        }
    }
}
