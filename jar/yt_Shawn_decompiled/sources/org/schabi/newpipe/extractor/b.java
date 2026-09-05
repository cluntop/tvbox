package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(int i, int i2) {
        this.a = i2;
        this.b = i;
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
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return MediaFormat.lambda$getById$0(this.b, (MediaFormat) obj);
            default:
                return NewPipe.lambda$getService$0(this.b, (StreamingService) obj);
        }
    }
}
