package org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.b.b;
import java.util.Arrays;
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
public final class YoutubeOtfDashManifestCreator {
    private static final ManifestCreatorCache<String, String> OTF_STREAMS_CACHE = new ManifestCreatorCache<>();

    private YoutubeOtfDashManifestCreator() {
    }

    public static String fromOtfStreamingUrl(String str, ItagItem itagItem, long j) throws DOMException, NumberFormatException {
        long streamDuration;
        ManifestCreatorCache<String, String> manifestCreatorCache = OTF_STREAMS_CACHE;
        if (manifestCreatorCache.containsKey(str)) {
            Pair<Integer, V> pair = manifestCreatorCache.get(str);
            Objects.requireNonNull(pair);
            return (String) pair.getSecond();
        }
        Response initializationResponse = YoutubeDashManifestCreatorsUtils.getInitializationResponse(str, itagItem, DeliveryType.OTF);
        String strReplace = initializationResponse.latestUrl().replace(YoutubeDashManifestCreatorsUtils.SQ_0, VideoStream.RESOLUTION_UNKNOWN).replace(YoutubeDashManifestCreatorsUtils.RN_0, VideoStream.RESOLUTION_UNKNOWN).replace(YoutubeDashManifestCreatorsUtils.ALR_YES, VideoStream.RESOLUTION_UNKNOWN);
        int iResponseCode = initializationResponse.responseCode();
        if (iResponseCode != 200) {
            throw new CreationException(b.j(iResponseCode, "Could not get the initialization URL: response code "));
        }
        try {
            String[] strArrSplit = initializationResponse.responseBody().split("Segment-Durations-Ms: ")[1].split("\n")[0].split(",");
            int length = strArrSplit.length - 1;
            if (Utils.isBlank(strArrSplit[length])) {
                strArrSplit = (String[]) Arrays.copyOf(strArrSplit, length);
            }
            try {
                streamDuration = getStreamDuration(strArrSplit);
            } catch (CreationException unused) {
                streamDuration = j * 1000;
            }
            Document documentGenerateDocumentAndDoCommonElementsGeneration = YoutubeDashManifestCreatorsUtils.generateDocumentAndDoCommonElementsGeneration(itagItem, streamDuration);
            YoutubeDashManifestCreatorsUtils.generateSegmentTemplateElement(documentGenerateDocumentAndDoCommonElementsGeneration, strReplace, DeliveryType.OTF);
            YoutubeDashManifestCreatorsUtils.generateSegmentTimelineElement(documentGenerateDocumentAndDoCommonElementsGeneration);
            generateSegmentElementsForOtfStreams(strArrSplit, documentGenerateDocumentAndDoCommonElementsGeneration);
            return YoutubeDashManifestCreatorsUtils.buildAndCacheResult(str, documentGenerateDocumentAndDoCommonElementsGeneration, OTF_STREAMS_CACHE);
        } catch (Exception e) {
            throw new CreationException("Could not get segment durations", e);
        }
    }

    private static void generateSegmentElementsForOtfStreams(String[] strArr, Document document) throws DOMException, NumberFormatException {
        try {
            Element element = (Element) document.getElementsByTagName(YoutubeDashManifestCreatorsUtils.SEGMENT_TIMELINE).item(0);
            for (String str : strArr) {
                Element elementCreateElement = document.createElement("S");
                String[] strArrSplit = str.split("\\(r=");
                Integer.parseInt(strArrSplit[0]);
                if (strArrSplit.length > 1) {
                    YoutubeDashManifestCreatorsUtils.setAttribute(elementCreateElement, document, "r", String.valueOf(Integer.parseInt(Utils.removeNonDigitCharacters(strArrSplit[1]))));
                }
                YoutubeDashManifestCreatorsUtils.setAttribute(elementCreateElement, document, "d", strArrSplit[0]);
                element.appendChild(elementCreateElement);
            }
        } catch (IllegalStateException | IndexOutOfBoundsException | NumberFormatException | DOMException e) {
            throw CreationException.couldNotAddElement("segment (S)", e);
        }
    }

    public static ManifestCreatorCache<String, String> getCache() {
        return OTF_STREAMS_CACHE;
    }

    private static long getStreamDuration(String[] strArr) {
        try {
            long j = 0;
            for (String str : strArr) {
                String[] strArrSplit = str.split("\\(r=");
                long j2 = strArrSplit.length > 1 ? Long.parseLong(Utils.removeNonDigitCharacters(strArrSplit[1])) : 0L;
                long j3 = Integer.parseInt(strArrSplit[0]);
                j += (j2 * j3) + j3;
            }
            return j;
        } catch (NumberFormatException e) {
            throw new CreationException("Could not get stream length from sequences list", e);
        }
    }
}
