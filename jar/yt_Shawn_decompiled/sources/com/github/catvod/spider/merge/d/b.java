package com.github.catvod.spider.merge.d;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class b {

    @SerializedName("channel")
    private List<a> a;

    @SerializedName("name")
    private String b;

    public static b a(String str) {
        b bVar = new b();
        bVar.b = str;
        if (str.contains("_")) {
            bVar.b = str.split("_")[0];
        }
        return bVar;
    }

    public final List b() {
        List<a> arrayList = this.a;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.a = arrayList;
        return arrayList;
    }

    public final String c() {
        return TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return c().equals(bVar.c()) && b().size() == bVar.b().size();
    }
}
