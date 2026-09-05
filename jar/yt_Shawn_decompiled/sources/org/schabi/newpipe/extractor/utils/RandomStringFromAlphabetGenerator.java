package org.schabi.newpipe.extractor.utils;

import java.util.Random;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class RandomStringFromAlphabetGenerator {
    private RandomStringFromAlphabetGenerator() {
    }

    public static String generate(String str, int i, Random random) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }
}
