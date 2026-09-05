package org.schabi.newpipe.extractor.localization;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import java.util.Map;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ TimeAgoParser b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(TimeAgoParser timeAgoParser, String str, int i) {
        this.a = i;
        this.b = timeAgoParser;
        this.c = str;
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$and(this, predicate);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.a;
        String str = this.c;
        TimeAgoParser timeAgoParser = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return timeAgoParser.lambda$parseChronoUnit$0(str, (String) obj);
            default:
                return timeAgoParser.lambda$parseChronoUnit$1(str, (Map.Entry) obj);
        }
    }
}
