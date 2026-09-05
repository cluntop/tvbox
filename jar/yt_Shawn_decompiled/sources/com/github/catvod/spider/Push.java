package com.github.catvod.spider;

import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.a.f;
import com.github.catvod.spider.merge.a.h;
import com.github.catvod.spider.merge.o.d;
import com.github.catvod.spider.merge.o.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Push extends Spider {
    public String detailContent(List<String> list) {
        String strReplace = list.get(0);
        h hVar = new h();
        hVar.f(strReplace);
        hVar.h("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAMCAgMCAgMDAwMEAwMEBQgFBQQEBQoHBwYIDAoMDAsKCwsNDhIQDQ4RDgsLEBYQERMUFRUVDA8XGBYUGBIUFRT/2wBDAQMEBAUEBQkFBQkUDQsNFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBT/wAARCADwAPADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD9U6KKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACvN7bxhffFCaRPB+oWZ8KSQX1h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g74M+K1mbfxR4fs9UYLtS5ZNlxH/ALkq4dfoDitbp7mFmtjGvNNudPbbcQtH6NjIP41518fo5NY8G+FfAFsxS88da3DaTbSQy2ULCWdwRzwFX8GNTyfBX4nfCdd/w38bf8JHoqf8yx4w/ertzkrFcDkdwAQoHcml+F9n4v8AiP8AHCLxZ4w8H3Xg6Hwxop020sZ3WSF7yaQmWWGQcOvlhVyOOcZOKaVtbkt30seofFbVo/C/gCS2s9Y07w3dXTRabp9xqUBmt/NcgLEYwDuDKGXFdhptmun6fa2qrGiwRLEFhQRoAoAwqjhRxwB0p11ZW98ipcwRXCK6yKsqBgGByGGe4PQ1PUFhRRRSGFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVhePP+RH8Rf9g64/9FNW7WD483HwN4i2RvK/9nXOI413Mx8puAO5NNbgfB/jX4kWV58A/hN8NZdQaw0u40+PVvEl1Dy0NjHI2yMdi7sPlU9XEQ/ir6Q+DPw1vPGOt6f8RfGGljTBZ262/hTwww/d6LZgAK7L/wA92ULk/wAIAHYBfFf2N/2XJtelsfiN47tWeKIRjR9LuoyN4jUIk8in+EBRsB643dMZ+6K1m0tEYwTerCiiisTYKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP/Z");
        hVar.c("FongMi");
        hVar.g(strReplace.startsWith("file://") ? new File(strReplace).getName() : VideoStream.RESOLUTION_UNKNOWN);
        if (strReplace.contains("://") && strReplace.contains("#")) {
            strReplace = strReplace.replace("#", "***");
        }
        if (e.a.matcher(strReplace).find() || (!strReplace.startsWith("magnet") && strReplace.split(";")[0].endsWith(".torrent"))) {
            hVar.j(strReplace);
            hVar.i("迅雷");
        } else if (strReplace.contains("youtube.com")) {
            hVar.j(strReplace);
            hVar.i("YouTube");
        } else if (strReplace.contains("$")) {
            hVar.i("直連");
            hVar.j(TextUtils.join("#", strReplace.split("\n")));
        } else {
            hVar.j(TextUtils.join("$$$", Arrays.asList(strReplace, strReplace, strReplace)));
            hVar.i(TextUtils.join("$$$", Arrays.asList("直連", "嗅探", "解析")));
        }
        return com.github.catvod.spider.merge.a.e.j(hVar);
    }

    public String playerContent(String str, String str2, List<String> list) {
        if (str2.contains("://") && str2.contains("***")) {
            str2 = str2.replace("***", "#");
        }
        str.getClass();
        switch (str) {
            case "嗅探":
                com.github.catvod.spider.merge.a.e eVar = new com.github.catvod.spider.merge.a.e();
                eVar.h();
                eVar.q(str2);
                return eVar.toString();
            case "直連":
                com.github.catvod.spider.merge.a.e eVar2 = new com.github.catvod.spider.merge.a.e();
                eVar2.q(str2);
                ArrayList arrayList = new ArrayList();
                if (str2.startsWith("file://")) {
                    for (File file : d.c(new File(str2.replace("file://", VideoStream.RESOLUTION_UNKNOWN)).getParentFile())) {
                        String strA = e.a(file.getName());
                        if (e.c.contains(e.a(strA).toLowerCase())) {
                            f fVar = new f();
                            fVar.b(e.c(file.getName()));
                            fVar.a(strA);
                            fVar.c("file://" + file.getAbsolutePath());
                            arrayList.add(fVar);
                        }
                    }
                }
                if (str2.startsWith(Utils.HTTP)) {
                    List listAsList = Arrays.asList("mp4", "mkv");
                    List<String> listAsList2 = Arrays.asList("srt", "ass");
                    if (listAsList.contains(e.a(str2))) {
                        for (String str3 : listAsList2) {
                            String strConcat = e.c(str2).concat(".").concat(str3);
                            if (com.github.catvod.spider.merge.g1.a.f(strConcat, null).length() >= 100) {
                                String lastPathSegment = Uri.parse(strConcat).getLastPathSegment();
                                f fVar2 = new f();
                                fVar2.b(lastPathSegment);
                                fVar2.a(str3);
                                fVar2.c(strConcat);
                                arrayList.add(fVar2);
                            }
                        }
                    }
                }
                eVar2.p(arrayList);
                return eVar2.toString();
            case "解析":
                com.github.catvod.spider.merge.a.e eVar3 = new com.github.catvod.spider.merge.a.e();
                eVar3.h();
                eVar3.e();
                eVar3.q(str2);
                return eVar3.toString();
            default:
                com.github.catvod.spider.merge.a.e eVar4 = new com.github.catvod.spider.merge.a.e();
                eVar4.q(str2);
                return eVar4.toString();
        }
    }
}
