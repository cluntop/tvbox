package org.schabi.newpipe.extractor.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Description implements Serializable {
    public static final Description EMPTY_DESCRIPTION = new Description(VideoStream.RESOLUTION_UNKNOWN, 3);
    public static final int HTML = 1;
    public static final int MARKDOWN = 2;
    public static final int PLAIN_TEXT = 3;
    private final String content;
    private final int type;

    public Description(String str, int i) {
        this.type = i;
        this.content = (String) Objects.requireNonNullElse(str, VideoStream.RESOLUTION_UNKNOWN);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Description description = (Description) obj;
            if (this.type == description.type && Objects.equals(this.content, description.content)) {
                return true;
            }
        }
        return false;
    }

    public String getContent() {
        return this.content;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.content, Integer.valueOf(this.type));
    }
}
