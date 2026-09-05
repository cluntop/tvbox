package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.HashMap;
import java.util.Map;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JavaScript;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeJavaScriptPlayerManager {
    private static final Map<String, String> CACHED_THROTTLING_PARAMETERS = new HashMap();
    private static String cachedJavaScriptPlayerCode;
    private static String cachedSignatureDeobfuscationFunction;
    private static Integer cachedSignatureTimestamp;
    private static String cachedThrottlingDeobfuscationFunction;
    private static String cachedThrottlingDeobfuscationFunctionName;
    private static ParsingException sigDeobFuncExtractionEx;
    private static ParsingException sigTimestampExtractionEx;
    private static ParsingException throttlingDeobfFuncExtractionEx;

    private YoutubeJavaScriptPlayerManager() {
    }

    public static void clearAllCaches() {
        cachedJavaScriptPlayerCode = null;
        cachedSignatureDeobfuscationFunction = null;
        cachedThrottlingDeobfuscationFunctionName = null;
        cachedThrottlingDeobfuscationFunction = null;
        cachedSignatureTimestamp = null;
        clearThrottlingParametersCache();
        throttlingDeobfFuncExtractionEx = null;
        sigDeobFuncExtractionEx = null;
        sigTimestampExtractionEx = null;
    }

    public static void clearThrottlingParametersCache() {
        CACHED_THROTTLING_PARAMETERS.clear();
    }

    public static String deobfuscateSignature(String str, String str2) {
        ParsingException parsingException = sigDeobFuncExtractionEx;
        if (parsingException != null) {
            throw parsingException;
        }
        extractJavaScriptCodeIfNeeded(str);
        if (cachedSignatureDeobfuscationFunction == null) {
            try {
                cachedSignatureDeobfuscationFunction = YoutubeSignatureUtils.getDeobfuscationCode(cachedJavaScriptPlayerCode);
            } catch (ParsingException e) {
                sigDeobFuncExtractionEx = e;
                throw e;
            } catch (Exception e2) {
                sigDeobFuncExtractionEx = new ParsingException("Could not get signature parameter deobfuscation JavaScript function", e2);
                throw e2;
            }
        }
        try {
            return (String) Objects.requireNonNullElse(JavaScript.run(cachedSignatureDeobfuscationFunction, "deobfuscate", str2), VideoStream.RESOLUTION_UNKNOWN);
        } catch (Exception e3) {
            com.github.catvod.spider.merge.s0.a.m("Could not run signature parameter deobfuscation JavaScript function", e3);
            return null;
        }
    }

    private static void extractJavaScriptCodeIfNeeded(String str) {
        if (cachedJavaScriptPlayerCode == null) {
            cachedJavaScriptPlayerCode = YoutubeJavaScriptExtractor.extractJavaScriptPlayerCode(str);
        }
    }

    public static Integer getSignatureTimestamp(String str) throws Exception {
        Integer num = cachedSignatureTimestamp;
        if (num != null) {
            return num;
        }
        ParsingException parsingException = sigTimestampExtractionEx;
        if (parsingException != null) {
            throw parsingException;
        }
        extractJavaScriptCodeIfNeeded(str);
        try {
            cachedSignatureTimestamp = Integer.valueOf(YoutubeSignatureUtils.getSignatureTimestamp(cachedJavaScriptPlayerCode));
        } catch (NumberFormatException e) {
            sigTimestampExtractionEx = new ParsingException("Could not convert signature timestamp to a number", e);
        } catch (ParsingException e2) {
            sigTimestampExtractionEx = e2;
            throw e2;
        } catch (Exception e3) {
            sigTimestampExtractionEx = new ParsingException("Could not get signature timestamp", e3);
            throw e3;
        }
        return cachedSignatureTimestamp;
    }

    public static int getThrottlingParametersCacheSize() {
        return CACHED_THROTTLING_PARAMETERS.size();
    }

    public static String getUrlWithThrottlingParameterDeobfuscated(String str, String str2) throws Exception {
        String throttlingParameterFromStreamingUrl = YoutubeThrottlingParameterUtils.getThrottlingParameterFromStreamingUrl(str2);
        if (throttlingParameterFromStreamingUrl == null) {
            return str2;
        }
        Map<String, String> map = CACHED_THROTTLING_PARAMETERS;
        CharSequence charSequence = (String) map.get(throttlingParameterFromStreamingUrl);
        if (charSequence != null) {
            return str2.replace(throttlingParameterFromStreamingUrl, charSequence);
        }
        extractJavaScriptCodeIfNeeded(str);
        ParsingException parsingException = throttlingDeobfFuncExtractionEx;
        if (parsingException != null) {
            throw parsingException;
        }
        if (cachedThrottlingDeobfuscationFunction == null) {
            try {
                String deobfuscationFunctionName = YoutubeThrottlingParameterUtils.getDeobfuscationFunctionName(cachedJavaScriptPlayerCode);
                cachedThrottlingDeobfuscationFunctionName = deobfuscationFunctionName;
                cachedThrottlingDeobfuscationFunction = YoutubeThrottlingParameterUtils.getDeobfuscationFunction(cachedJavaScriptPlayerCode, deobfuscationFunctionName);
            } catch (ParsingException e) {
                throttlingDeobfFuncExtractionEx = e;
                throw e;
            } catch (Exception e2) {
                throttlingDeobfFuncExtractionEx = new ParsingException("Could not get throttling parameter deobfuscation JavaScript function", e2);
                throw e2;
            }
        }
        try {
            String strRun = JavaScript.run(cachedThrottlingDeobfuscationFunction, cachedThrottlingDeobfuscationFunctionName, throttlingParameterFromStreamingUrl);
            if (Utils.isNullOrEmpty(strRun)) {
                throw new IllegalStateException("Extracted n-parameter is empty");
            }
            map.put(throttlingParameterFromStreamingUrl, strRun);
            return str2.replace(throttlingParameterFromStreamingUrl, strRun);
        } catch (Exception e3) {
            com.github.catvod.spider.merge.s0.a.m("Could not run throttling parameter deobfuscation JavaScript function", e3);
            return null;
        }
    }
}
