package org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators;

import com.github.catvod.spider.jdollar.util.Objects;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;
import org.schabi.newpipe.extractor.utils.Pair;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeProgressiveDashManifestCreator {
    private static final ManifestCreatorCache<String, String> PROGRESSIVE_STREAMS_CACHE = new ManifestCreatorCache<>();

    private YoutubeProgressiveDashManifestCreator() {
    }

    public static String fromProgressiveStreamingUrl(String str, ItagItem itagItem, long j) throws DOMException {
        ManifestCreatorCache<String, String> manifestCreatorCache = PROGRESSIVE_STREAMS_CACHE;
        if (manifestCreatorCache.containsKey(str)) {
            Pair<Integer, V> pair = manifestCreatorCache.get(str);
            Objects.requireNonNull(pair);
            return (String) pair.getSecond();
        }
        long approxDurationMs = itagItem.getApproxDurationMs();
        if (approxDurationMs == -1) {
            if (j <= 0) {
                throw CreationException.couldNotAddElement(YoutubeDashManifestCreatorsUtils.MPD, "the duration of the stream could not be determined and durationSecondsFallback is <= 0");
            }
            approxDurationMs = 1000 * j;
        }
        Document documentGenerateDocumentAndDoCommonElementsGeneration = YoutubeDashManifestCreatorsUtils.generateDocumentAndDoCommonElementsGeneration(itagItem, approxDurationMs);
        generateBaseUrlElement(documentGenerateDocumentAndDoCommonElementsGeneration, str);
        generateSegmentBaseElement(documentGenerateDocumentAndDoCommonElementsGeneration, itagItem);
        generateInitializationElement(documentGenerateDocumentAndDoCommonElementsGeneration, itagItem);
        return YoutubeDashManifestCreatorsUtils.buildAndCacheResult(str, documentGenerateDocumentAndDoCommonElementsGeneration, manifestCreatorCache);
    }

    private static void generateBaseUrlElement(Document document, String str) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(YoutubeDashManifestCreatorsUtils.REPRESENTATION).item(0);
            Element elementCreateElement = document.createElement(YoutubeDashManifestCreatorsUtils.BASE_URL);
            elementCreateElement.setTextContent(str);
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(YoutubeDashManifestCreatorsUtils.BASE_URL, e);
        }
    }

    private static void generateInitializationElement(Document document, ItagItem itagItem) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(YoutubeDashManifestCreatorsUtils.SEGMENT_BASE).item(0);
            Element elementCreateElement = document.createElement(YoutubeDashManifestCreatorsUtils.INITIALIZATION);
            String str = itagItem.getInitStart() + "-" + itagItem.getInitEnd();
            if (itagItem.getInitStart() < 0 || itagItem.getInitEnd() < 0) {
                throw CreationException.couldNotAddElement(YoutubeDashManifestCreatorsUtils.INITIALIZATION, "ItagItem's initStart and/or initEnd are/is < 0: ".concat(str));
            }
            YoutubeDashManifestCreatorsUtils.setAttribute(elementCreateElement, document, "range", str);
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(YoutubeDashManifestCreatorsUtils.INITIALIZATION, e);
        }
    }

    private static void generateSegmentBaseElement(Document document, ItagItem itagItem) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(YoutubeDashManifestCreatorsUtils.REPRESENTATION).item(0);
            Element elementCreateElement = document.createElement(YoutubeDashManifestCreatorsUtils.SEGMENT_BASE);
            String str = itagItem.getIndexStart() + "-" + itagItem.getIndexEnd();
            if (itagItem.getIndexStart() < 0 || itagItem.getIndexEnd() < 0) {
                throw CreationException.couldNotAddElement(YoutubeDashManifestCreatorsUtils.SEGMENT_BASE, "ItagItem's indexStart or indexEnd are < 0: ".concat(str));
            }
            YoutubeDashManifestCreatorsUtils.setAttribute(elementCreateElement, document, "indexRange", str);
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(YoutubeDashManifestCreatorsUtils.SEGMENT_BASE, e);
        }
    }

    public static ManifestCreatorCache<String, String> getCache() {
        return PROGRESSIVE_STREAMS_CACHE;
    }
}
