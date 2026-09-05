package com.github.catvod.spider.merge.s0;

import com.whl.quickjs.wrapper.MapCreator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements MapCreator {
    public static /* synthetic */ void a() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void b(int i, int i2) {
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i + ((Object) " is less than minimum ") + i2 + '.');
    }

    public static /* synthetic */ void c(int i, long j) throws IOException {
        throw new IOException("Content-Length (" + j + ((Object) ") and stream length (") + i + ((Object) ") disagree"));
    }

    public static /* synthetic */ void d(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    public static /* synthetic */ void e(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(Object obj, int i, String str) {
        throw new IllegalArgumentException(str + obj + ((char) i));
    }

    public static /* synthetic */ void g(Object obj, Object obj2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        throw new IOException(sb.toString());
    }

    public static /* synthetic */ void h(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void i(String str, int i, int i2, Object obj) {
        throw new IndexOutOfBoundsException(str + i + obj + i2 + ((Object) ")."));
    }

    public static /* synthetic */ void j(String str, Object obj) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void k(String str, Object obj, Object obj2, int i) {
        throw new IllegalArgumentException((str + obj + obj2 + i).toString());
    }

    public static /* synthetic */ void l(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m(String str, Throwable th) throws ParsingException {
        throw new ParsingException(str, th);
    }

    public static /* synthetic */ void n(StringBuilder sb, int i) {
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void o(StringBuilder sb, Object obj) {
        sb.append(" is less than minimum ");
        sb.append(obj);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void p(int i, String str) throws IOException {
        throw new IOException(str + i);
    }

    public static /* synthetic */ void q(Object obj, Object obj2) {
        throw new IllegalStateException(("network interceptor " + obj + obj2).toString());
    }

    public static /* synthetic */ void r(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void s(String str, int i, int i2, Object obj) {
        throw new IllegalArgumentException((str + i + obj + i2).toString());
    }

    public static /* synthetic */ void t(String str, Object obj) {
        throw new IllegalArgumentException((str + obj + '\"').toString());
    }

    public static /* synthetic */ void u(StringBuilder sb, int i) {
        sb.append(i);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ void v(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void w(String str) throws IOException {
        throw new IOException(str);
    }

    public Map get() {
        return new HashMap();
    }
}
