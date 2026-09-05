package com.github.catvod.spider.merge.g;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("name")
    private String a;

    @SerializedName("server")
    private String b;
    public Connection c;
    public SMBClient d;
    public DiskShare e;
    public Session f;
    public String g;

    public a(String str) {
        this.a = str;
    }

    public final String a() {
        return TextUtils.isEmpty(this.a) ? VideoStream.RESOLUTION_UNKNOWN : this.a;
    }

    public final String b() {
        return TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return a().equals(((a) obj).a());
        }
        return false;
    }
}
