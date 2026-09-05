package com.github.catvod.spider.merge.d;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("urls")
    private List<String> a;

    @SerializedName("tvgName")
    private String b;

    @SerializedName("number")
    private String c;

    @SerializedName("logo")
    private String d;

    @SerializedName("name")
    private String e;

    @SerializedName("epg")
    private String f;

    @SerializedName("ua")
    private String g;

    @SerializedName("referer")
    private String h;

    public static a a(String str) {
        a aVar = new a();
        aVar.e = str;
        return aVar;
    }

    public final String b() {
        return TextUtils.isEmpty(this.c) ? VideoStream.RESOLUTION_UNKNOWN : this.c;
    }

    public final List c() {
        List<String> arrayList = this.a;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.a = arrayList;
        return arrayList;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final void e(int i) {
        this.c = String.format(Locale.getDefault(), "%03d", Integer.valueOf(i));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean zIsEmpty = TextUtils.isEmpty(this.e);
        String str = VideoStream.RESOLUTION_UNKNOWN;
        String str2 = zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.e;
        if (!TextUtils.isEmpty(aVar.e)) {
            str = aVar.e;
        }
        if (str2.equals(str)) {
            return true;
        }
        return !b().isEmpty() && b().equals(aVar.b());
    }

    public final void f(String str) {
        this.b = str;
    }
}
