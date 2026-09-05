package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.FoundAdException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.c;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeStreamLinkHandlerFactory extends LinkHandlerFactory {
    private static final List<String> SUBPATHS;
    private static final Pattern YOUTUBE_VIDEO_ID_REGEX_PATTERN = Pattern.compile("^([a-zA-Z0-9_-]{11})");
    private static final YoutubeStreamLinkHandlerFactory INSTANCE = new YoutubeStreamLinkHandlerFactory();

    static {
        Object[] objArr = {"embed/", "live/", "shorts/", "watch/", "v/", "w/"};
        ArrayList arrayList = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        SUBPATHS = DesugarCollections.unmodifiableList(arrayList);
    }

    private YoutubeStreamLinkHandlerFactory() {
    }

    private static String assertIsId(String str) throws ParsingException {
        String strExtractId = extractId(str);
        if (strExtractId != null) {
            return strExtractId;
        }
        c.a("The given string is not a YouTube video ID");
        return null;
    }

    private static String extractId(String str) {
        if (str != null) {
            Matcher matcher = YOUTUBE_VIDEO_ID_REGEX_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    private String getIdFromSubpathsInPath(String str) {
        for (String str2 : SUBPATHS) {
            if (str.startsWith(str2)) {
                return assertIsId(str.substring(str2.length()));
            }
        }
        return null;
    }

    public static YoutubeStreamLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getId(java.lang.String r11) throws org.schabi.newpipe.extractor.exceptions.ParsingException {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory.getId(java.lang.String):java.lang.String");
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str) {
        return b.n("https://www.youtube.com/watch?v=", str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) throws FoundAdException {
        try {
            getId(str);
            return true;
        } catch (FoundAdException e) {
            throw e;
        } catch (ParsingException unused) {
            return false;
        }
    }
}
