package com.github.catvod.spider.merge.e;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("name")
    private String a;

    @SerializedName("list")
    private List<b> b;

    public final List a() {
        List<b> list = this.b;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final String b() {
        return TextUtils.isEmpty(this.a) ? VideoStream.RESOLUTION_UNKNOWN : this.a;
    }

    public final ArrayList c() {
        ArrayList arrayList = new ArrayList();
        Iterator it = a().iterator();
        while (it.hasNext()) {
            arrayList.add(((b) it.next()).b());
        }
        return arrayList;
    }
}
