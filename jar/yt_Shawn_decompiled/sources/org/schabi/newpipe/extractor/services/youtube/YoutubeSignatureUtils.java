package org.schabi.newpipe.extractor.services.youtube;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JavaScript;
import org.schabi.newpipe.extractor.utils.Pair;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.jsextractor.JavaScriptExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
final class YoutubeSignatureUtils {
    static final String DEOBFUSCATION_FUNCTION_NAME = "deobfuscate";
    private static final String DEOBF_FUNC_REGEX_END = "=function\\([a-zA-Z0-9_]+\\)\\{.+?\\})";
    private static final String DEOBF_FUNC_REGEX_START = "(";
    private static final Pattern[] FUNCTION_REGEXES = {Pattern.compile("\\b(?:[a-zA-Z0-9_$]+)&&\\((?:[a-zA-Z0-9_$]+)=([a-zA-Z0-9_$]{2,})\\((\\d+,)decodeURIComponent\\((?:[a-zA-Z0-9_$]+)\\)\\)"), Pattern.compile("\\b(?:[a-zA-Z0-9_$]+)&&\\((?:[a-zA-Z0-9_$]+)=([a-zA-Z0-9_$]{2,})\\(decodeURIComponent\\((?:[a-zA-Z0-9_$]+)\\)\\)"), Pattern.compile("\\bm=([a-zA-Z0-9$]{2,})\\(decodeURIComponent\\(h\\.s\\)\\)"), Pattern.compile("\\bc&&\\(c=([a-zA-Z0-9$]{2,})\\(decodeURIComponent\\(c\\)\\)"), Pattern.compile("(?:\\b|[^a-zA-Z0-9$])([a-zA-Z0-9$]{2,})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)"), Pattern.compile("([\\w$]+)\\s*=\\s*function\\((\\w+)\\)\\{\\s*\\2=\\s*\\2\\.split\\(\"\"\\)\\s*;")};
    private static final Pattern SIG_DEOBF_GLOBAL_ARRAY_REGEX = Pattern.compile("(var [A-z]=['\"].*['\"].split\\(\"[;{]\"\\))");
    private static final Pattern SIG_DEOBF_HELPER_OBJ_NAME_REGEX = Pattern.compile("[;,]([A-Za-z0-9_$]{2,})\\[..");
    private static final String SIG_DEOBF_HELPER_OBJ_REGEX_END = "=\\{(?>.|\\n)+?\\}\\};)";
    private static final String SIG_DEOBF_HELPER_OBJ_REGEX_START = "(var ";
    private static final String STS_REGEX = "signatureTimestamp[=:](\\d+)";

    private YoutubeSignatureUtils() {
    }

    private static String getDeobfuscateFunctionWithLexer(String str, String str2) {
        String strZ = com.github.catvod.spider.merge.b.b.z(str2, "=function");
        return com.github.catvod.spider.merge.b.b.z(strZ, JavaScriptExtractor.matchToClosingBrace(str, strZ));
    }

    private static String getDeobfuscateFunctionWithRegex(String str, String str2) {
        return com.github.catvod.spider.merge.b.b.n("var ", Parser.matchGroup1(DEOBF_FUNC_REGEX_START + Pattern.quote(str2) + DEOBF_FUNC_REGEX_END, str));
    }

    public static String getDeobfuscationCode(String str) throws ParsingException {
        String deobfuscateFunctionWithRegex;
        try {
            Pair<String, String> deobfuscationFunctionNameAndParams = getDeobfuscationFunctionNameAndParams(str);
            String str2 = (String) deobfuscationFunctionNameAndParams.getFirst();
            String str3 = (String) deobfuscationFunctionNameAndParams.getSecond();
            try {
                deobfuscateFunctionWithRegex = getDeobfuscateFunctionWithLexer(str, str2);
            } catch (Exception unused) {
                deobfuscateFunctionWithRegex = getDeobfuscateFunctionWithRegex(str, str2);
            }
            JavaScript.compileOrThrow(deobfuscateFunctionWithRegex);
            return Parser.matchGroup1(SIG_DEOBF_GLOBAL_ARRAY_REGEX, str) + ";" + getHelperObject(str, Parser.matchGroup1(SIG_DEOBF_HELPER_OBJ_NAME_REGEX, deobfuscateFunctionWithRegex)) + deobfuscateFunctionWithRegex + ";" + ("function deobfuscate(a){return " + str2 + DEOBF_FUNC_REGEX_START + str3 + "a);}");
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse deobfuscation function", e);
            return null;
        }
    }

    private static Pair<String, String> getDeobfuscationFunctionNameAndParams(String str) throws ParsingException {
        try {
            Matcher matcherMatchMultiplePatterns = Parser.matchMultiplePatterns(FUNCTION_REGEXES, str);
            return new Pair<>(matcherMatchMultiplePatterns.group(1), matcherMatchMultiplePatterns.groupCount() > 1 ? matcherMatchMultiplePatterns.group(2) : VideoStream.RESOLUTION_UNKNOWN);
        } catch (Parser.RegexException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not find deobfuscation function with any of the known patterns", e);
            return null;
        }
    }

    private static String getHelperObject(String str, String str2) {
        return Parser.matchGroup1(SIG_DEOBF_HELPER_OBJ_REGEX_START + Pattern.quote(str2) + SIG_DEOBF_HELPER_OBJ_REGEX_END, str).replace("\n", VideoStream.RESOLUTION_UNKNOWN);
    }

    public static String getSignatureTimestamp(String str) throws ParsingException {
        try {
            return Parser.matchGroup1(STS_REGEX, str);
        } catch (ParsingException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not extract signature timestamp from JavaScript code", e);
            return null;
        }
    }
}
