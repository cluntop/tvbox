package com.github.catvod.spider.merge.u;

import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s extends IOException {
    public s(int i, int i2, int i3, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sb = new StringBuilder("Pos: ");
        sb.append(i);
        sb.append(", limit: ");
        sb.append(i2);
        sb.append(", len: ");
        sb.append(i3);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sb.toString()), indexOutOfBoundsException);
    }

    public s(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }
}
