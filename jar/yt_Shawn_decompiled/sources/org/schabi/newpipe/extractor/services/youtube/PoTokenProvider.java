package org.schabi.newpipe.extractor.services.youtube;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface PoTokenProvider {
    PoTokenResult getAndroidClientPoToken(String str);

    PoTokenResult getIosClientPoToken(String str);

    PoTokenResult getWebClientPoToken(String str);

    PoTokenResult getWebEmbedClientPoToken(String str);
}
