package com.github.catvod.spider.merge.e0;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.github.catvod.spider.merge.o1.n;
import com.hierynomus.ntlm.messages.NtlmChallenge;
import com.hierynomus.ntlm.messages.NtlmNegotiateFlag;
import com.hierynomus.smbj.auth.NtlmAuthenticator;
import java.net.URL;
import java.util.HashSet;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeStreamExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.SubtitlesStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(int i, Object obj) {
        this.a = i;
        this.b = obj;
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
        Object obj2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return NtlmAuthenticator.a((NtlmChallenge) obj2, (NtlmNegotiateFlag) obj);
            case 1:
                return ((HashSet) obj2).add((n) obj);
            case 2:
                return PeertubeStreamExtractor.lambda$getSubtitles$0((MediaFormat) obj2, (SubtitlesStream) obj);
            default:
                return YoutubeParsingHelper.lambda$isGoogleURL$0((URL) obj2, (String) obj);
        }
    }
}
