package com.github.catvod.spider.merge.v0;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;
import okhttp3.internal.http2.Http2Connection;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(Regex regex, CharSequence charSequence, int i) {
        this.c = regex;
        this.d = charSequence;
        this.b = i;
    }

    public final Object invoke() {
        int i = this.a;
        Object obj = this.d;
        int i2 = this.b;
        Object obj2 = this.c;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return Regex.a((Regex) obj2, (CharSequence) obj, i2);
            default:
                return Http2Connection.j((Http2Connection) obj2, i2, (List) obj);
        }
    }

    public /* synthetic */ b(Http2Connection http2Connection, int i, List list) {
        this.c = http2Connection;
        this.b = i;
        this.d = list;
    }
}
