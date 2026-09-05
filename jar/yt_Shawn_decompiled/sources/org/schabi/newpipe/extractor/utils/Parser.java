package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.util.DesugarArrays;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.n1.f;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Parser {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class RegexException extends ParsingException {
        public RegexException(String str) {
            super(str);
        }
    }

    private Parser() {
    }

    public static Map<String, String> compatParseMap(String str) {
        return (Map) DesugarArrays.stream(str.split("&")).map(new b(0)).filter(new org.schabi.newpipe.extractor.services.bandcamp.extractors.a(4)).collect(Collectors.toMap(new b(1), new b(2), new f(2)));
    }

    public static boolean isMatch(String str, String str2) {
        return isMatch(Pattern.compile(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$compatParseMap$0(String str) {
        return str.split("=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$compatParseMap$1(String[] strArr) {
        return strArr.length > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$compatParseMap$2(String[] strArr) {
        return strArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$compatParseMap$3(String[] strArr) {
        return Utils.decodeUrlUtf8(strArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$compatParseMap$4(String str, String str2) {
        return str2;
    }

    public static String matchGroup(String str, String str2, int i) {
        return matchGroup(Pattern.compile(str), str2, i);
    }

    public static String matchGroup1(String str, String str2) {
        return matchGroup(str, str2, 1);
    }

    public static String matchGroup1MultiplePatterns(Pattern[] patternArr, String str) {
        return matchMultiplePatterns(patternArr, str).group(1);
    }

    public static Matcher matchMultiplePatterns(Pattern[] patternArr, String str) throws RegexException {
        RegexException regexException = null;
        for (Pattern pattern : patternArr) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher;
            }
            if (regexException == null) {
                regexException = new RegexException(com.github.catvod.spider.merge.b.b.p("Failed to find pattern \"", pattern.pattern(), "\"", str.length() <= 1000 ? com.github.catvod.spider.merge.b.b.A("inside of \"", str, "\"") : VideoStream.RESOLUTION_UNKNOWN));
            }
        }
        if (regexException != null) {
            throw regexException;
        }
        throw new RegexException("Empty patterns array passed to matchMultiplePatterns");
    }

    public static Matcher matchOrThrow(Pattern pattern, String str) throws RegexException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher;
        }
        String strA = com.github.catvod.spider.merge.b.b.A("Failed to find pattern \"", pattern.pattern(), "\"");
        if (str.length() <= 1024) {
            strA = strA + " inside of \"" + str + "\"";
        }
        throw new RegexException(strA);
    }

    public static String matchGroup1(Pattern pattern, String str) {
        return matchGroup(pattern, str, 1);
    }

    public static boolean isMatch(Pattern pattern, String str) {
        return pattern.matcher(str).find();
    }

    public static String matchGroup(Pattern pattern, String str, int i) {
        return matchOrThrow(pattern, str).group(i);
    }
}
