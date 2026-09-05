package org.schabi.newpipe.extractor.services.youtube;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.utils.JavaScript;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.jsextractor.JavaScriptExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
final class YoutubeThrottlingParameterUtils {
    private static final String ARRAY_ACCESS_REGEX = "\\[(\\d+)]";
    private static final String DEOBFUSCATION_FUNCTION_ARRAY_OBJECT_TYPE_DECLARATION_REGEX = "var ";
    private static final String DEOBFUSCATION_FUNCTION_BODY_REGEX = "=\\s*function([\\S\\s]*?\\}\\s*return [\\w$]+?\\.join\\(\"\"\\)\\s*\\};)";
    private static final String EARLY_RETURN_REGEX = ";\\s*if\\s*\\(\\s*typeof\\s+[a-zA-Z0-9$_]++\\s*===?\\s*([\"'])undefined\\1\\s*\\)\\s*return\\s+";
    private static final String FUNCTION_ARGUMENTS_REGEX = "=\\s*function\\s*\\(\\s*([^)]*)\\s*\\)";
    private static final String FUNCTION_NAMES_IN_DEOBFUSCATION_ARRAY_REGEX = "\\s*=\\s*\\[(.+?)][;,]";
    private static final String MULTIPLE_CHARS_REGEX = "[a-zA-Z0-9$_]+";
    private static final String SINGLE_CHAR_VARIABLE_REGEX = "[a-zA-Z0-9$_]";
    private static final Pattern THROTTLING_PARAM_PATTERN = Pattern.compile("[&?]n=([^&]+)");
    private static final Pattern[] DEOBFUSCATION_FUNCTION_NAME_REGEXES = {Pattern.compile("([A-Za-z0-9_\\$]{2,})=function.*return [A-Z]\\[\\d+\\]"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+\\([a-zA-Z0-9$_]+\\),[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+\\[[a-zA-Z0-9$_]+]\\|\\|null\\)&&\\([a-zA-Z0-9$_]+=([a-zA-Z0-9$_]+)\\[(\\d+)]"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+\\([a-zA-Z0-9$_]+\\),[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+\\[[a-zA-Z0-9$_]+]\\|\\|null\\).+\\|\\|([a-zA-Z0-9$_]+)\\(\"\"\\)"), Pattern.compile(",[a-zA-Z0-9$_]+\\([a-zA-Z0-9$_]+\\),[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+\\[[a-zA-Z0-9$_]+]\\|\\|null\\)&&\\(\\b[a-zA-Z0-9$_]+=([a-zA-Z0-9$_]+)\\[(\\d+)]\\([a-zA-Z0-9$_]\\),[a-zA-Z0-9$_]+\\.set\\((?:\"n+\"|[a-zA-Z0-9$_]+),[a-zA-Z0-9$_]+\\)"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.get\\([a-zA-Z0-9$_]+\\)\\).+\\|\\|([a-zA-Z0-9$_]+)\\(\"\"\\)"), Pattern.compile("[a-zA-Z0-9$_]=\"nn\"\\[\\+[a-zA-Z0-9$_]+\\.[a-zA-Z0-9$_]+],[a-zA-Z0-9$_]+=[a-zA-Z0-9$_]+\\.get\\([a-zA-Z0-9$_]+\\)\\)&&\\([a-zA-Z0-9$_]+=([a-zA-Z0-9$_]+)\\[(\\d+)]"), Pattern.compile("\\([a-zA-Z0-9$_]=String\\.fromCharCode\\(110\\),[a-zA-Z0-9$_]=[a-zA-Z0-9$_]\\.get\\([a-zA-Z0-9$_]\\)\\)&&\\([a-zA-Z0-9$_]=([a-zA-Z0-9$_]+)(?:\\[(\\d+)])?\\([a-zA-Z0-9$_]\\)"), Pattern.compile("\\.get\\(\"n\"\\)\\)&&\\([a-zA-Z0-9$_]=([a-zA-Z0-9$_]+)(?:\\[(\\d+)])?\\([a-zA-Z0-9$_]\\)")};

    private YoutubeThrottlingParameterUtils() {
    }

    private static String fixupFunction(String str) {
        return Pattern.compile(EARLY_RETURN_REGEX + Parser.matchGroup1(FUNCTION_ARGUMENTS_REGEX, str).split(",")[0].trim() + ";", 32).matcher(str).replaceFirst(";");
    }

    public static String getDeobfuscationFunction(String str, String str2) {
        String functionWithRegex;
        try {
            functionWithRegex = parseFunctionWithLexer(str, str2);
        } catch (Exception unused) {
            functionWithRegex = parseFunctionWithRegex(str, str2);
        }
        return fixupFunction(functionWithRegex);
    }

    public static String getDeobfuscationFunctionName(String str) throws NumberFormatException, ParsingException {
        try {
            Matcher matcherMatchMultiplePatterns = Parser.matchMultiplePatterns(DEOBFUSCATION_FUNCTION_NAME_REGEXES, str);
            String strGroup = matcherMatchMultiplePatterns.group(1);
            if (matcherMatchMultiplePatterns.groupCount() == 1) {
                return strGroup;
            }
            return Parser.matchGroup1(Pattern.compile(DEOBFUSCATION_FUNCTION_ARRAY_OBJECT_TYPE_DECLARATION_REGEX + Pattern.quote(strGroup) + FUNCTION_NAMES_IN_DEOBFUSCATION_ARRAY_REGEX), str).split(",")[Integer.parseInt(matcherMatchMultiplePatterns.group(2))];
        } catch (Parser.RegexException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not find deobfuscation function with any of the known patterns in the base JavaScript player code", e);
            return null;
        }
    }

    public static String getThrottlingParameterFromStreamingUrl(String str) {
        if (!str.contains("&n=") && !str.contains("?n=")) {
            return null;
        }
        try {
            return Parser.matchGroup1(THROTTLING_PARAM_PATTERN, str);
        } catch (Parser.RegexException unused) {
            return null;
        }
    }

    private static String parseFunctionWithLexer(String str, String str2) {
        String strZ = com.github.catvod.spider.merge.b.b.z(str2, "=function");
        return com.github.catvod.spider.merge.b.b.o(strZ, JavaScriptExtractor.matchToClosingBrace(str, strZ), ";");
    }

    private static String parseFunctionWithRegex(String str, String str2) {
        return validateFunction(com.github.catvod.spider.merge.b.b.A("function ", str2, Parser.matchGroup1(Pattern.compile(Pattern.quote(str2) + DEOBFUSCATION_FUNCTION_BODY_REGEX, 32), str)));
    }

    private static String validateFunction(String str) {
        JavaScript.compileOrThrow(str);
        return str;
    }
}
