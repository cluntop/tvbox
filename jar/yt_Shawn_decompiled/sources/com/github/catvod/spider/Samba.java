package com.github.catvod.spider;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.a.h;
import com.github.catvod.spider.merge.o.e;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Samba extends Spider {
    public List a;
    public String b;

    public static String b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return TextUtils.join("/", arrayList);
    }

    public static boolean c(FileIdBothDirectoryInformation fileIdBothDirectoryInformation) {
        return !EnumWithValue.EnumUtils.isSet(fileIdBothDirectoryInformation.getFileAttributes(), FileAttributes.FILE_ATTRIBUTE_DIRECTORY);
    }

    public final List a(com.github.catvod.spider.merge.g.a aVar, String str) {
        AuthenticationContext authenticationContext;
        DiskShare diskShare = aVar.e;
        String str2 = VideoStream.RESOLUTION_UNKNOWN;
        if (diskShare == null) {
            try {
                aVar.d = new SMBClient();
                Uri uri = Uri.parse(aVar.b());
                String[] strArrSplit = uri.getPath().substring(1).split("/", 2);
                Connection connectionConnect = aVar.d.connect(uri.getHost(), uri.getPort() != -1 ? uri.getPort() : 445);
                aVar.c = connectionConnect;
                String userInfo = uri.getUserInfo();
                if (userInfo == null) {
                    authenticationContext = AuthenticationContext.guest();
                } else {
                    String[] strArrSplit2 = userInfo.split(":", 2);
                    authenticationContext = new AuthenticationContext(strArrSplit2[0], strArrSplit2.length > 1 ? strArrSplit2[1].toCharArray() : new char[0], (String) null);
                }
                Session sessionAuthenticate = connectionConnect.authenticate(authenticationContext);
                aVar.f = sessionAuthenticate;
                aVar.e = sessionAuthenticate.connectShare(strArrSplit[0]);
                aVar.g = strArrSplit.length > 1 ? strArrSplit[1] : VideoStream.RESOLUTION_UNKNOWN;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DiskShare diskShare2 = aVar.e;
        if (!TextUtils.isEmpty(aVar.g)) {
            str2 = aVar.g;
        }
        List list = diskShare2.list(b(str2, str));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FileIdBothDirectoryInformation fileIdBothDirectoryInformation = (FileIdBothDirectoryInformation) it.next();
            if (EnumWithValue.EnumUtils.isSet(fileIdBothDirectoryInformation.getFileAttributes(), FileAttributes.FILE_ATTRIBUTE_DIRECTORY) && fileIdBothDirectoryInformation.getFileName().startsWith(".")) {
                it.remove();
            }
            if (c(fileIdBothDirectoryInformation)) {
                if (!e.b.contains(e.a(fileIdBothDirectoryInformation.getFileName()).toLowerCase())) {
                    it.remove();
                }
            }
        }
        Collections.sort(list, new com.github.catvod.spider.merge.n.b(this));
        return list;
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        String strSubstring = str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
        String strSubstring2 = str.contains("/") ? str.substring(str.indexOf("/") + 1) : VideoStream.RESOLUTION_UNKNOWN;
        List list = this.a;
        com.github.catvod.spider.merge.g.a aVar = (com.github.catvod.spider.merge.g.a) list.get(list.indexOf(new com.github.catvod.spider.merge.g.a(strSubstring)));
        ArrayList arrayList = new ArrayList();
        for (FileIdBothDirectoryInformation fileIdBothDirectoryInformation : a(aVar, strSubstring2)) {
            String strB = b(strSubstring, strSubstring2, fileIdBothDirectoryInformation.getFileName());
            if (EnumWithValue.EnumUtils.isSet(fileIdBothDirectoryInformation.getFileAttributes(), FileAttributes.FILE_ATTRIBUTE_DIRECTORY)) {
                arrayList.add(new h(strB, fileIdBothDirectoryInformation.getFileName(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAV4AAAFeCAYAAADNK3caAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAkoSURBVHhe7d1bjNxVHcDxc2Z2uy3KJdBaLhXRIChSIKEx6hs8GkwItCCGJ42XBNSYmGhCQlNJjA8aH6DqA8ZEGw3dcjGKvgGJD8a4JEKLXDQaQ6uQlGqKAtvuzPE/zCExMZrupb+d/38+n2Z7Lt2X3fb/3X/nzM4mAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABgLeQ6To1SdvdOPn3wg/1e77qS0o5S0uXNJ2Fr85k4q/njDeP36rQ3mrd/NR/7y83H/edmfLYZn+wP8q/yNfNHxu8CnE5TE97y1E3blnLvzpzT7c3yovEu/6n5IvRM6qWHZpb6+/I1D7xQt4E11vnwloXbNg/mTt7TTD/ZvE3DHe1aKM2vx5u74W/OXnXgl3UPWCOdDu/SwV23Ng3Z20zPG++wbCX9puT01dntB56oO8AqdTK8ZeEzs4O5Y/c208+Od1il0R3wD/vp9S/lqx79e90DVqhz4S0LN5wxmNs430w/Ot5hDR0uw/SJ2asP/KqugRXo1bETxne6onsabcu99Njg0M131DWwAp0Kb314QXRPr5lS8n0nn975jboGlqkzDzUsHbrltlSGP65LApSUvjW7/cCX6xI4RZ0Ib1m4YfNgbuNzzdSzF4I1/4Du6m8/8PW6BE5BJx5qaKI7ep6u6K6D5q73nqVDN99cl8ApaP0d7+g70ga93h+b6dx4h3Xwz8Fw8OG5qx8+VNfA/9H68I4OeXJOX6lL1svJxdQ/8oeUhoO6Af/lRPN2vPlv0kvN+PzoQcLU7z2WFl5YyHvS8M33mBKtDm/Zvbs32PnMX5rptvEO6ym/9mrqvfSnuoJT9mIq5Ucp9ffmG5//a93rtFaH98RTN32o1+v9ui6ZAPkfL6fesdENDSzbYnM7dX9afOPufMvhY3Wvk1p9uDZ6acc6ZUKUc7am8rZz6gqWZa750n1H2rDpufLTS3fVvU5qdXhLSjvqlAky3PLOVDZsrCtYppy2NL/tb+J7X3k8zdTdTml5eMtldcok6fXScOslzdivG7ASzd3v8fc+XPZv21Q3OqPV4c0pX1CnTJrZuTR8x7vqAlbshrRx0wNdu/Nt+zdQnFlHJlA548w0PPf8uoIVKulj6fil366rTmh7eP1EiQnnsI21ke/s0oFb28NLCzhsY02UvLfsv+Lcumo14eX0c9jGWhg922HuxJ66ajXhJYbDNtZE/nR55PIL66K1hJcwDttYA3MpDVr/E1CEl1AO21i1nG8vu9vdLuElnMM2VunidO1l19Z5Kwkv8Ry2sWr5+jppJeFlfThsYzXK0B0vrITDNlbh8jq2kvCyrhy2sSIltfp1WoSXdeewjWXL6aw6ayXhZf05bGP5Wv3DbYWXyeCwjSkivEwMh21MC+Florx52PZ2h210m/AycYZbLn7z7he6SniZPDmn4dZ3p+HZm+sGdIvwMpma+JbzLkrDC96TyobO/axDppzwMtHKpjPTcNtlaXjhpamcvSWVuTOaf7Wedka75Tq20tLBnaVOgSkzs/1Aa/vljhcgmPACBBNegGDCCxBMeAGCCS9AMOEFCCa8AMGEFyCY8AIEE16AYMILEEx4AYIJL0Aw4QUIJrwAwYQXIJjwAgQTXoBgwgsQTHgBggkvQDDhBQgmvADBhBcgmPACBBNegGDCCxBMeAGCCS9AMOEFCCa8AMGEFyCY8AIEE16AYMILEEx4AYIJL0Aw4QUIJrwAwYQXIJjwAgQTXoBgwgsQTHgBggkvQDDhBQgmvADBhBcgmPACBBNegGDCCxBMeAGCCS9AMOEFCCa8AMGEFyCY8AIEE16AYMILEEx4AYIJL0Aw4QUIJrwAwYQXIJjwAgQTXoBgwgsQTHgBggkvQDDhBQgmvADBhBcgmPACBBNegGDCCxBMeAGCCS9AMOEFCCa8AMGEFyCY8AIEE16AYMILEEx4AYIJL0Aw4QUIJrwAwYQXIJjwAgQTXoBgwgsQTHgBggkvQDDhBQgmvADBhBcgmPACBBNegGDCCxBMeAGCCS9AMOEFCCa8AMGEFyCY8AIEE16AYMILEEx4AYIJL0Aw4QUIJrwAwYQXIJjwAgQTXoBgwgsQTHgBggkvQDDhBQgmvADBhBcgmPACBBNegGDCCxBMeAGCCS9AMOEFCCa8AMGEFyCY8AIEE16AYMILEEx4AYIJL0Aw4QUIJrwAwYQXIJjwAgQTXoBgbQ/viToC02Wxjq3U9vC+WkdgmpR2X/utDm9J5W91CkyRklOrr/1Whzen/EKdAlMkl/J8nbZSy8ObFuoUmCLNTVerr/1Wh3fQK4/VKTBFBr1hq6/9Vod3dv+Vv22Gw+MVMB3Ki7Pz25+si1Zq90MNe/YMSy776hKYAiXlfaNrvy5bqdXhHZkZlL3N0Orn9AGnbHFmkEfXfKu1Prz56ocON18Df1CXQJeVdH++Zv5IXbVW68M70s+9u5q/kKN1CXRRc433Z5d211WrdSK8+cr5Y83fyh11CXRRznfm9z/ySl21WifCOzJz1YP7m+F74xXQKSV9Z2b7/AN11XqdCe9I/+jRzzfDz8YroCN+0X/l6BfrvBM6Fd583RNL/cU3Pt5MxRe64dH+q3nn6Nqu607oVHhH8o6fv9bc+d7U/Nek9U85gelWvttcyzfmj8y/Xjc6I9exk5YO7ro1lXJf81FurlvApBs9Q6lXvjBz5YM/qTud0+nwjpRnbzxvcHLma81H+qlmOTfeBSbQYhPd7/dnl+7uyrMX/pfOh/ct5Xe7Llrqlc/lVG5POV9St4H1d6SUtG9mmO/twjdHnIqpCe9bStndO/nU73f0e8PrS0rXlpzel0s+v/lMnNX88YbxewGnwYnmjvb46EXMR6+nO3ppx0EvPz77gSsWcm73ay8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADrIKV/A6RHmt7xjHWfAAAAAElFTkSuQmCC", VideoStream.RESOLUTION_UNKNOWN, true));
            }
            if (c(fileIdBothDirectoryInformation)) {
                arrayList.add(new h(strB, fileIdBothDirectoryInformation.getFileName(), "data:image/png;base64,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", VideoStream.RESOLUTION_UNKNOWN, false));
            }
        }
        com.github.catvod.spider.merge.a.e eVar = new com.github.catvod.spider.merge.a.e();
        eVar.s(arrayList);
        eVar.g(1, 1, 0, 1);
        return eVar.toString();
    }

    public void destroy() {
        for (com.github.catvod.spider.merge.g.a aVar : this.a) {
            aVar.getClass();
            try {
                try {
                    DiskShare diskShare = aVar.e;
                    if (diskShare != null) {
                        diskShare.close();
                    }
                    Session session = aVar.f;
                    if (session != null) {
                        session.close();
                    }
                    Connection connection = aVar.c;
                    if (connection != null) {
                        connection.close();
                    }
                    SMBClient sMBClient = aVar.d;
                    if (sMBClient != null) {
                        sMBClient.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                aVar.c = null;
                aVar.e = null;
                aVar.d = null;
                aVar.f = null;
            } catch (Throwable th) {
                aVar.c = null;
                aVar.e = null;
                aVar.d = null;
                aVar.f = null;
                throw th;
            }
        }
    }

    public String detailContent(List<String> list) {
        String str = list.get(0);
        String strSubstring = str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
        boolean zContains = str.contains("/");
        String strSubstring2 = VideoStream.RESOLUTION_UNKNOWN;
        String strSubstring3 = zContains ? str.substring(str.indexOf("/") + 1) : VideoStream.RESOLUTION_UNKNOWN;
        if (strSubstring3.contains("/")) {
            strSubstring2 = strSubstring3.substring(0, strSubstring3.lastIndexOf("/"));
        }
        String strSubstring4 = strSubstring2.contains("/") ? strSubstring2.substring(strSubstring2.lastIndexOf("/") + 1) : strSubstring;
        List list2 = this.a;
        com.github.catvod.spider.merge.g.a aVar = (com.github.catvod.spider.merge.g.a) list2.get(list2.indexOf(new com.github.catvod.spider.merge.g.a(strSubstring)));
        ArrayList arrayList = new ArrayList();
        for (FileIdBothDirectoryInformation fileIdBothDirectoryInformation : a(aVar, strSubstring2)) {
            if (c(fileIdBothDirectoryInformation)) {
                arrayList.add(fileIdBothDirectoryInformation.getFileName() + "$" + b(aVar.b(), strSubstring2, fileIdBothDirectoryInformation.getFileName()));
            }
        }
        h hVar = new h();
        hVar.f(strSubstring4);
        hVar.g(strSubstring4);
        hVar.i(strSubstring);
        hVar.j(TextUtils.join("#", arrayList));
        return com.github.catvod.spider.merge.a.e.j(hVar);
    }

    public String homeContent(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (com.github.catvod.spider.merge.g.a aVar : this.a) {
            arrayList.add(new com.github.catvod.spider.merge.a.a(aVar.a(), aVar.a(), "1"));
        }
        return com.github.catvod.spider.merge.a.e.o(arrayList);
    }

    public void init(Context context, String str) {
        this.b = str;
        List list = this.a;
        if (list == null || list.isEmpty()) {
            if (this.b.startsWith("http")) {
                this.b = com.github.catvod.spider.merge.g1.a.f(this.b, null);
            }
            this.a = (List) new Gson().fromJson(this.b, TypeToken.getParameterized(List.class, new Type[]{com.github.catvod.spider.merge.g.a.class}).getType());
        }
    }

    public String playerContent(String str, String str2, List<String> list) {
        com.github.catvod.spider.merge.a.e eVar = new com.github.catvod.spider.merge.a.e();
        eVar.q(str2);
        return eVar.toString();
    }
}
