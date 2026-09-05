package com.github.catvod.spider.merge.q;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Type;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ObjectConstructor {
    public final /* synthetic */ int a;
    public final /* synthetic */ Type b;

    public /* synthetic */ a(Type type, int i) {
        this.a = i;
        this.b = type;
    }

    public final Object construct() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return ConstructorConstructor.d(this.b);
            default:
                return ConstructorConstructor.b(this.b);
        }
    }
}
