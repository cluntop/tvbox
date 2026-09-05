package com.github.catvod.spider.merge.c;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class d {

    @SerializedName("mid")
    private String a;

    @SerializedName("name")
    private String b;

    public final String a() {
        StringBuilder sb = new StringBuilder();
        boolean zIsEmpty = TextUtils.isEmpty(this.a);
        String str = VideoStream.RESOLUTION_UNKNOWN;
        String strQ = com.github.catvod.spider.merge.b.b.q(sb, zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.a, "/{pg}");
        String str2 = TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b;
        if (!TextUtils.isEmpty(this.b)) {
            str = this.b;
        }
        StringBuilder sb2 = new StringBuilder("[a=cr:{\"id\":\"");
        sb2.append(strQ);
        sb2.append("\",\"name\":\"");
        sb2.append(str2);
        sb2.append("\"}/]");
        return com.github.catvod.spider.merge.b.b.q(sb2, str, "[/a]");
    }
}
