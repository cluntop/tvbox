package com.github.catvod.spider.merge.b;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class e {

    @SerializedName("path")
    private String a;

    @SerializedName("pass")
    private String b;

    public final String a() {
        return TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b;
    }

    public final String b() {
        return TextUtils.isEmpty(this.a) ? VideoStream.RESOLUTION_UNKNOWN : this.a;
    }
}
