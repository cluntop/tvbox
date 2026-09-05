package com.github.catvod.js;

import com.github.catvod.spider.merge.l.a;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.e;
import com.github.catvod.spider.merge.u.c2;
import com.whl.quickjs.wrapper.JSArray;
import com.whl.quickjs.wrapper.JSMethod;
import com.whl.quickjs.wrapper.QuickJSContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Function {
    private final QuickJSContext ctx;
    private final a parser = new a();

    public Function(QuickJSContext quickJSContext) throws SecurityException {
        this.ctx = quickJSContext;
        setProperty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setProperty$0(Method method, Object[] objArr) {
        try {
            return method.invoke(this, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private void setProperty() throws SecurityException {
        for (Method method : getClass().getMethods()) {
            if (method.isAnnotationPresent(JSMethod.class)) {
                this.ctx.getGlobalObject().setProperty(method.getName(), new com.github.catvod.spider.merge.j.a(this, method));
            }
        }
    }

    @JSMethod
    public String pd(String str, String str2, String str3) {
        return this.parser.a(str, str2, str3);
    }

    @JSMethod
    public JSArray pdfa(String str, String str2) {
        ArrayList arrayList;
        QuickJSContext quickJSContext = this.ctx;
        a aVar = this.parser;
        com.github.catvod.spider.merge.k.a aVar2 = aVar.e;
        if (!str.equals((String) aVar2.c)) {
            aVar2.c = str;
            aVar2.e = c2.T(str);
        }
        h hVar = (h) aVar2.e;
        int i = 0;
        String[] strArrSplit = aVar.b(str2, false).split(Stream.ID_UNKNOWN);
        e eVar = new e();
        int length = strArrSplit.length;
        while (true) {
            if (i < length) {
                eVar = a.c(hVar, strArrSplit[i], eVar);
                if (eVar.isEmpty()) {
                    arrayList = new ArrayList();
                    break;
                }
                i++;
            } else {
                arrayList = new ArrayList();
                Iterator<E> it = eVar.iterator();
                while (it.hasNext()) {
                    arrayList.add(((n) it.next()).u());
                }
            }
        }
        return c2.Y(quickJSContext, arrayList);
    }

    @JSMethod
    public String pdfh(String str, String str2) {
        return this.parser.a(str, str2, VideoStream.RESOLUTION_UNKNOWN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    @JSMethod
    public JSArray pdfl(String str, String str2, String str3, String str4, String str5) {
        ?? arrayList;
        QuickJSContext quickJSContext = this.ctx;
        a aVar = this.parser;
        int i = 0;
        String[] strArrSplit = aVar.b(str2, false).split(Stream.ID_UNKNOWN);
        e eVar = new e();
        int length = strArrSplit.length;
        while (true) {
            if (i < length) {
                String str6 = strArrSplit[i];
                com.github.catvod.spider.merge.k.a aVar2 = aVar.e;
                if (!str.equals((String) aVar2.c)) {
                    aVar2.c = str;
                    aVar2.e = c2.T(str);
                }
                eVar = a.c((h) aVar2.e, str6, eVar);
                if (eVar.isEmpty()) {
                    arrayList = Collections.EMPTY_LIST;
                    break;
                }
                i++;
            } else {
                arrayList = new ArrayList();
                Iterator it = eVar.iterator();
                while (it.hasNext()) {
                    String strU = ((n) it.next()).u();
                    arrayList.add(aVar.a(strU, str3, VideoStream.RESOLUTION_UNKNOWN).trim() + '$' + aVar.a(strU, str4, str5));
                }
            }
        }
        return c2.Y(quickJSContext, arrayList);
    }
}
