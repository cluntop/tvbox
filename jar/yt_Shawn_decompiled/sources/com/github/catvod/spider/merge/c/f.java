package com.github.catvod.spider.merge.c;

import android.text.TextUtils;
import com.github.catvod.spider.merge.u.c2;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class f {

    @SerializedName("bvid")
    private String a;

    @SerializedName("aid")
    private String b;

    @SerializedName("title")
    private String c;

    @SerializedName("pic")
    private String d;

    @SerializedName("duration")
    private String e;

    @SerializedName("length")
    private String f;

    public static List a(JsonElement jsonElement) {
        return (List) new Gson().fromJson(jsonElement, TypeToken.getParameterized(List.class, new Type[]{f.class}).getType());
    }

    public final com.github.catvod.spider.merge.a.h b() throws NumberFormatException {
        String string;
        com.github.catvod.spider.merge.a.h hVar = new com.github.catvod.spider.merge.a.h();
        StringBuilder sb = new StringBuilder();
        boolean zIsEmpty = TextUtils.isEmpty(this.a);
        String strZ = VideoStream.RESOLUTION_UNKNOWN;
        sb.append(zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.a);
        sb.append("@");
        sb.append(TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b);
        hVar.f(sb.toString());
        hVar.g(c2.T(TextUtils.isEmpty(this.c) ? VideoStream.RESOLUTION_UNKNOWN : this.c).U());
        boolean zStartsWith = (TextUtils.isEmpty(this.d) ? VideoStream.RESOLUTION_UNKNOWN : this.d).startsWith("//");
        String str = this.d;
        if (zStartsWith) {
            StringBuilder sb2 = new StringBuilder("https:");
            sb2.append(TextUtils.isEmpty(str) ? VideoStream.RESOLUTION_UNKNOWN : this.d);
            string = sb2.toString();
        } else {
            string = TextUtils.isEmpty(str) ? VideoStream.RESOLUTION_UNKNOWN : this.d;
        }
        hVar.h(string);
        if (!TextUtils.isEmpty(this.e)) {
            boolean zContains = this.e.contains(":");
            String str2 = this.e;
            if (zContains) {
                strZ = com.github.catvod.spider.merge.b.b.q(new StringBuilder(), str2.split(":")[0], "分鐘");
            } else {
                int i = Integer.parseInt(str2);
                String str3 = this.e;
                if (i < 60) {
                    strZ = com.github.catvod.spider.merge.b.b.z(str3, "秒");
                } else {
                    strZ = (Integer.parseInt(str3) / 60) + "分鐘";
                }
            }
        } else if (!TextUtils.isEmpty(this.f)) {
            strZ = this.f;
        }
        hVar.k(strZ);
        return hVar;
    }
}
