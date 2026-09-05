package com.github.catvod.spider.merge.j;

import com.github.catvod.js.Function;
import com.whl.quickjs.wrapper.JSCallFunction;
import com.whl.quickjs.wrapper.QuickJSObject;
import java.lang.reflect.Method;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements JSCallFunction {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Method b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Function function, Method method) {
        this.c = function;
        this.b = method;
    }

    public final Object call(Object[] objArr) {
        int i = this.a;
        Object obj = this.c;
        Method method = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return ((Function) obj).lambda$setProperty$0(method, objArr);
            default:
                return QuickJSObject.a(method, obj, objArr);
        }
    }

    public /* synthetic */ a(Method method, Object obj) {
        this.b = method;
        this.c = obj;
    }
}
