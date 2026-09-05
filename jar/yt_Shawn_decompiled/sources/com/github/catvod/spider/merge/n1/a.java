package com.github.catvod.spider.merge.n1;

import java.io.IOException;
import java.util.Locale;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public static final String[] c = {"input", "keygen", "object", "select", "textarea"};
    public final /* synthetic */ int a;
    public final Appendable b;

    public /* synthetic */ a(Appendable appendable, int i) {
        this.a = i;
        this.b = appendable;
    }

    public static String c(String str) {
        return str != null ? str.toLowerCase(Locale.ROOT) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public static String d(String str) {
        return c(str).trim();
    }

    public static a e(StringBuilder sb) {
        return sb != null ? new a(sb, 1) : new a(sb, 0);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    public final a a(char c2) throws androidx.startup.b, IOException {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                try {
                    this.b.append(c2);
                    return this;
                } catch (IOException e) {
                    throw new androidx.startup.b(e);
                }
            default:
                ((StringBuilder) this.b).append(c2);
                return this;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    public final a b(String str) throws androidx.startup.b, IOException {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                try {
                    this.b.append(str);
                    return this;
                } catch (IOException e) {
                    throw new androidx.startup.b(e);
                }
            default:
                ((StringBuilder) this.b).append((CharSequence) str);
                return this;
        }
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return ((StringBuilder) this.b).toString();
            default:
                return super.toString();
        }
    }
}
