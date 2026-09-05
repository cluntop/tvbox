package org.schabi.newpipe.extractor.services.youtube.extractors;

import java.util.function.Supplier;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Supplier {
    public final /* synthetic */ int a;

    public /* synthetic */ i(int i) {
        this.a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return YoutubeCommentsEUVMInfoItemExtractor.lambda$getReplies$2();
            case 1:
                return YoutubeChannelExtractor.lambda$getAvatars$0();
            case 2:
                return YoutubeChannelExtractor.lambda$getAvatars$2();
            case 3:
                return YoutubeCommentsExtractor.lambda$getMutationPayloadFromEntityKey$3();
            case 4:
                return YoutubeMixOrPlaylistLockupInfoItemExtractor.lambda$getStreamCount$1();
            case 5:
                return YoutubeMixOrPlaylistLockupInfoItemExtractor.lambda$getStreamCount$3();
            case 6:
                return YoutubePlaylistExtractor.lambda$getUploaderInfo$2();
            default:
                return YoutubePlaylistExtractor.lambda$getPlaylistInfo$5();
        }
    }
}
