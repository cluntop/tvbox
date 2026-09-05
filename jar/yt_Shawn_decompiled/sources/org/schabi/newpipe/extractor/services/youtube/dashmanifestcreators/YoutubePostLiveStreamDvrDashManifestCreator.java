package org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.b.b;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.services.youtube.DeliveryType;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;
import org.schabi.newpipe.extractor.utils.Pair;
import org.schabi.newpipe.extractor.utils.Utils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubePostLiveStreamDvrDashManifestCreator {
    private static final ManifestCreatorCache<String, String> POST_LIVE_DVR_STREAMS_CACHE = new ManifestCreatorCache<>();

    private YoutubePostLiveStreamDvrDashManifestCreator() {
    }

    public static String fromPostLiveStreamDvrStreamingUrl(String str, ItagItem itagItem, int i, long j) throws DOMException, NumberFormatException {
        ManifestCreatorCache<String, String> manifestCreatorCache = POST_LIVE_DVR_STREAMS_CACHE;
        if (manifestCreatorCache.containsKey(str)) {
            Pair<Integer, V> pair = manifestCreatorCache.get(str);
            Objects.requireNonNull(pair);
            return (String) pair.getSecond();
        }
        if (i <= 0) {
            throw new CreationException(b.j(i, "targetDurationSec value is <= 0: "));
        }
        try {
            Response initializationResponse = YoutubeDashManifestCreatorsUtils.getInitializationResponse(str, itagItem, DeliveryType.LIVE);
            String strReplace = initializationResponse.latestUrl().replace(YoutubeDashManifestCreatorsUtils.SQ_0, VideoStream.RESOLUTION_UNKNOWN).replace(YoutubeDashManifestCreatorsUtils.RN_0, VideoStream.RESOLUTION_UNKNOWN).replace(YoutubeDashManifestCreatorsUtils.ALR_YES, VideoStream.RESOLUTION_UNKNOWN);
            int iResponseCode = initializationResponse.responseCode();
            if (iResponseCode != 200) {
                throw new CreationException("Could not get the initialization sequence: response code " + iResponseCode);
            }
            Map<String, List<String>> mapResponseHeaders = initializationResponse.responseHeaders();
            String str2 = mapResponseHeaders.get("X-Head-Time-Millis").get(0);
            String str3 = mapResponseHeaders.get("X-Head-Seqnum").get(0);
            if (Utils.isNullOrEmpty(str3)) {
                throw new CreationException("Could not get the number of segments");
            }
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException unused) {
            }
            Document documentGenerateDocumentAndDoCommonElementsGeneration = YoutubeDashManifestCreatorsUtils.generateDocumentAndDoCommonElementsGeneration(itagItem, j);
            YoutubeDashManifestCreatorsUtils.generateSegmentTemplateElement(documentGenerateDocumentAndDoCommonElementsGeneration, strReplace, DeliveryType.LIVE);
            YoutubeDashManifestCreatorsUtils.generateSegmentTimelineElement(documentGenerateDocumentAndDoCommonElementsGeneration);
            generateSegmentElementForPostLiveDvrStreams(documentGenerateDocumentAndDoCommonElementsGeneration, i, str3);
            return YoutubeDashManifestCreatorsUtils.buildAndCacheResult(str, documentGenerateDocumentAndDoCommonElementsGeneration, POST_LIVE_DVR_STREAMS_CACHE);
        } catch (IndexOutOfBoundsException e) {
            throw new CreationException("Could not get the value of the X-Head-Time-Millis or the X-Head-Seqnum header", e);
        }
    }

    private static void generateSegmentElementForPostLiveDvrStreams(Document document, int i, String str) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(YoutubeDashManifestCreatorsUtils.SEGMENT_TIMELINE).item(0);
            Element elementCreateElement = document.createElement("S");
            YoutubeDashManifestCreatorsUtils.setAttribute(elementCreateElement, document, "d", String.valueOf(i * 1000));
            YoutubeDashManifestCreatorsUtils.setAttribute(elementCreateElement, document, "r", str);
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement("segment (S)", e);
        }
    }

    public static ManifestCreatorCache<String, String> getCache() {
        return POST_LIVE_DVR_STREAMS_CACHE;
    }
}
