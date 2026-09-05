package com.github.catvod.spider.merge.e;

import android.text.TextUtils;
import com.github.catvod.spider.merge.a.g;
import com.github.catvod.spider.merge.a.h;
import com.google.gson.annotations.SerializedName;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class b {

    @SerializedName("name")
    private String a;

    @SerializedName("url")
    private String b;

    @SerializedName("icon")
    private String c;

    @SerializedName("copy")
    private String d;

    @SerializedName("version")
    private String e;

    public b(String str) {
        this.b = str;
    }

    public final String a() {
        return TextUtils.isEmpty(this.d) ? VideoStream.RESOLUTION_UNKNOWN : this.d;
    }

    public final h b() {
        boolean zIsEmpty = TextUtils.isEmpty(this.a);
        String str = VideoStream.RESOLUTION_UNKNOWN;
        String str2 = zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.a;
        String str3 = TextUtils.isEmpty(this.c) ? VideoStream.RESOLUTION_UNKNOWN : this.c;
        String str4 = TextUtils.isEmpty(this.e) ? VideoStream.RESOLUTION_UNKNOWN : this.e;
        g gVarA = g.a();
        if (!TextUtils.isEmpty(this.b)) {
            str = this.b;
        }
        return new h(str2, str3, str4, gVarA, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        boolean zIsEmpty = TextUtils.isEmpty(this.b);
        String str = VideoStream.RESOLUTION_UNKNOWN;
        String str2 = zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.b;
        if (!TextUtils.isEmpty(bVar.b)) {
            str = bVar.b;
        }
        return str2.equals(str);
    }
}
