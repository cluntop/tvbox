package com.github.catvod.spider.merge.u;

import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d0 implements e1 {
    public static final d0 b = new d0(0);
    public final /* synthetic */ int a;

    public /* synthetic */ d0(int i) {
        this.a = i;
    }

    @Override // com.github.catvod.spider.merge.u.e1
    public final r1 a(Class cls) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!j0.class.isAssignableFrom(cls)) {
                    com.github.catvod.spider.merge.s0.a.r("Unsupported message type: ".concat(cls.getName()));
                    return null;
                }
                try {
                    return (r1) j0.getDefaultInstance(cls.asSubclass(j0.class)).buildMessageInfo();
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.github.catvod.spider.merge.u.e1
    public final boolean b(Class cls) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return j0.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
