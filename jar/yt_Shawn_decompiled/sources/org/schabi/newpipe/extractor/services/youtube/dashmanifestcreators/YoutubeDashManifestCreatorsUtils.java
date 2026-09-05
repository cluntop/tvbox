package org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.t0.a;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.services.youtube.DeliveryType;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.AudioTrackType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;
import org.schabi.newpipe.extractor.utils.Utils;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeDashManifestCreatorsUtils {
    public static final String ADAPTATION_SET = "AdaptationSet";
    public static final String ALR_YES = "&alr=yes";
    public static final String AUDIO_CHANNEL_CONFIGURATION = "AudioChannelConfiguration";
    public static final String BASE_URL = "BaseURL";
    public static final String INITIALIZATION = "Initialization";
    public static final int MAXIMUM_REDIRECT_COUNT = 20;
    public static final String MPD = "MPD";
    public static final String PERIOD = "Period";
    public static final String REPRESENTATION = "Representation";
    public static final String RN_0 = "&rn=0";
    public static final String ROLE = "Role";
    public static final String SEGMENT_BASE = "SegmentBase";
    public static final String SEGMENT_TEMPLATE = "SegmentTemplate";
    public static final String SEGMENT_TIMELINE = "SegmentTimeline";
    public static final String SQ_0 = "&sq=0";

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$schabi$newpipe$extractor$stream$AudioTrackType;

        static {
            int[] iArr = new int[AudioTrackType.values().length];
            $SwitchMap$org$schabi$newpipe$extractor$stream$AudioTrackType = iArr;
            try {
                iArr[AudioTrackType.ORIGINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$stream$AudioTrackType[AudioTrackType.DUBBED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$stream$AudioTrackType[AudioTrackType.DESCRIPTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private YoutubeDashManifestCreatorsUtils() {
    }

    private static String appendRnSqParamsIfNeeded(String str, DeliveryType deliveryType) {
        return b.o(str, deliveryType == DeliveryType.PROGRESSIVE ? VideoStream.RESOLUTION_UNKNOWN : SQ_0, RN_0);
    }

    public static String buildAndCacheResult(String str, Document document, ManifestCreatorCache<String, String> manifestCreatorCache) throws TransformerFactoryConfigurationError {
        try {
            String strDocumentToXml = documentToXml(document);
            manifestCreatorCache.put(str, strDocumentToXml);
            return strDocumentToXml;
        } catch (Exception e) {
            throw new CreationException("Could not convert the DASH manifest generated to a string", e);
        }
    }

    private static String documentToXml(Document document) throws TransformerException, TransformerFactoryConfigurationError, IllegalArgumentException {
        TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
        try {
            transformerFactoryNewInstance.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", VideoStream.RESOLUTION_UNKNOWN);
            transformerFactoryNewInstance.setAttribute("http://javax.xml.XMLConstants/property/accessExternalSchema", VideoStream.RESOLUTION_UNKNOWN);
        } catch (Exception unused) {
        }
        Transformer transformerNewTransformer = transformerFactoryNewInstance.newTransformer();
        transformerNewTransformer.setOutputProperty("version", "1.0");
        transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
        transformerNewTransformer.setOutputProperty("standalone", "no");
        StringWriter stringWriter = new StringWriter();
        transformerNewTransformer.transform(new DOMSource(document), new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    public static void generateAdaptationSetElement(Document document, ItagItem itagItem) throws DOMException {
        Locale audioLocale;
        try {
            Element element = (Element) document.getElementsByTagName(PERIOD).item(0);
            Element elementCreateElement = document.createElement(ADAPTATION_SET);
            setAttribute(elementCreateElement, document, "id", "0");
            MediaFormat mediaFormat = itagItem.getMediaFormat();
            if (mediaFormat == null || Utils.isNullOrEmpty(mediaFormat.getMimeType())) {
                throw CreationException.couldNotAddElement(ADAPTATION_SET, "the MediaFormat or its mime type is null or empty");
            }
            if (itagItem.itagType == ItagItem.ItagType.AUDIO && (audioLocale = itagItem.getAudioLocale()) != null) {
                String language = audioLocale.getLanguage();
                if (!language.isEmpty()) {
                    setAttribute(elementCreateElement, document, "lang", language);
                }
            }
            setAttribute(elementCreateElement, document, "mimeType", mediaFormat.getMimeType());
            setAttribute(elementCreateElement, document, "subsegmentAlignment", "true");
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(ADAPTATION_SET, e);
        }
    }

    public static void generateAudioChannelConfigurationElement(Document document, ItagItem itagItem) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(REPRESENTATION).item(0);
            Element elementCreateElement = document.createElement(AUDIO_CHANNEL_CONFIGURATION);
            setAttribute(elementCreateElement, document, "schemeIdUri", "urn:mpeg:dash:23003:3:audio_channel_configuration:2011");
            if (itagItem.getAudioChannels() > 0) {
                setAttribute(elementCreateElement, document, "value", String.valueOf(itagItem.getAudioChannels()));
                element.appendChild(elementCreateElement);
            } else {
                throw new CreationException("the number of audioChannels in the ItagItem is <= 0: " + itagItem.getAudioChannels());
            }
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(AUDIO_CHANNEL_CONFIGURATION, e);
        }
    }

    public static Document generateDocumentAndDoCommonElementsGeneration(ItagItem itagItem, long j) throws DOMException {
        Document documentGenerateDocumentAndMpdElement = generateDocumentAndMpdElement(j);
        generatePeriodElement(documentGenerateDocumentAndMpdElement);
        generateAdaptationSetElement(documentGenerateDocumentAndMpdElement, itagItem);
        generateRoleElement(documentGenerateDocumentAndMpdElement, itagItem);
        generateRepresentationElement(documentGenerateDocumentAndMpdElement, itagItem);
        if (itagItem.itagType == ItagItem.ItagType.AUDIO) {
            generateAudioChannelConfigurationElement(documentGenerateDocumentAndMpdElement, itagItem);
        }
        return documentGenerateDocumentAndMpdElement;
    }

    public static Document generateDocumentAndMpdElement(long j) throws DOMException {
        try {
            Document documentNewDocument = newDocument();
            Element elementCreateElement = documentNewDocument.createElement(MPD);
            documentNewDocument.appendChild(elementCreateElement);
            setAttribute(elementCreateElement, documentNewDocument, "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            setAttribute(elementCreateElement, documentNewDocument, "xmlns", "urn:mpeg:DASH:schema:MPD:2011");
            setAttribute(elementCreateElement, documentNewDocument, "xsi:schemaLocation", "urn:mpeg:DASH:schema:MPD:2011 DASH-MPD.xsd");
            setAttribute(elementCreateElement, documentNewDocument, "minBufferTime", "PT1.500S");
            setAttribute(elementCreateElement, documentNewDocument, "profiles", "urn:mpeg:dash:profile:full:2011");
            setAttribute(elementCreateElement, documentNewDocument, "type", "static");
            setAttribute(elementCreateElement, documentNewDocument, "mediaPresentationDuration", String.format(Locale.ENGLISH, "PT%.3fS", Double.valueOf(j / 1000.0d)));
            return documentNewDocument;
        } catch (Exception e) {
            throw new CreationException("Could not generate the DASH manifest or append the MPD doc to it", e);
        }
    }

    public static void generatePeriodElement(Document document) throws DOMException {
        try {
            ((Element) document.getElementsByTagName(MPD).item(0)).appendChild(document.createElement(PERIOD));
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(PERIOD, e);
        }
    }

    public static void generateRepresentationElement(Document document, ItagItem itagItem) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(ADAPTATION_SET).item(0);
            Element elementCreateElement = document.createElement(REPRESENTATION);
            int i = itagItem.id;
            if (i <= 0) {
                throw CreationException.couldNotAddElement(REPRESENTATION, "the id of the ItagItem is <= 0");
            }
            setAttribute(elementCreateElement, document, "id", String.valueOf(i));
            String codec = itagItem.getCodec();
            if (Utils.isNullOrEmpty(codec)) {
                throw CreationException.couldNotAddElement(ADAPTATION_SET, "the codec value of the ItagItem is null or empty");
            }
            setAttribute(elementCreateElement, document, "codecs", codec);
            setAttribute(elementCreateElement, document, "startWithSAP", "1");
            setAttribute(elementCreateElement, document, "maxPlayoutRate", "1");
            int bitrate = itagItem.getBitrate();
            if (bitrate <= 0) {
                throw CreationException.couldNotAddElement(REPRESENTATION, "the bitrate of the ItagItem is <= 0");
            }
            setAttribute(elementCreateElement, document, "bandwidth", String.valueOf(bitrate));
            ItagItem.ItagType itagType = itagItem.itagType;
            if (itagType == ItagItem.ItagType.VIDEO || itagType == ItagItem.ItagType.VIDEO_ONLY) {
                int height = itagItem.getHeight();
                int width = itagItem.getWidth();
                if (height <= 0 && width <= 0) {
                    throw CreationException.couldNotAddElement(REPRESENTATION, "both width and height of the ItagItem are <= 0");
                }
                if (width > 0) {
                    setAttribute(elementCreateElement, document, "width", String.valueOf(width));
                }
                setAttribute(elementCreateElement, document, "height", String.valueOf(itagItem.getHeight()));
                int fps = itagItem.getFps();
                if (fps > 0) {
                    setAttribute(elementCreateElement, document, "frameRate", String.valueOf(fps));
                }
            }
            if (itagItem.itagType == ItagItem.ItagType.AUDIO && itagItem.getSampleRate() > 0) {
                document.createAttribute("audioSamplingRate").setValue(String.valueOf(itagItem.getSampleRate()));
            }
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(REPRESENTATION, e);
        }
    }

    public static void generateRoleElement(Document document, ItagItem itagItem) throws DOMException {
        try {
            Element element = (Element) document.getElementsByTagName(ADAPTATION_SET).item(0);
            Element elementCreateElement = document.createElement(ROLE);
            setAttribute(elementCreateElement, document, "schemeIdUri", "urn:mpeg:DASH:role:2011");
            setAttribute(elementCreateElement, document, "value", getRoleValue(itagItem.getAudioTrackType()));
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(ROLE, e);
        }
    }

    public static void generateSegmentTemplateElement(Document document, String str, DeliveryType deliveryType) throws DOMException {
        if (deliveryType != DeliveryType.OTF && deliveryType != DeliveryType.LIVE) {
            throw CreationException.couldNotAddElement(SEGMENT_TEMPLATE, "invalid delivery type: " + deliveryType);
        }
        try {
            Element element = (Element) document.getElementsByTagName(REPRESENTATION).item(0);
            Element elementCreateElement = document.createElement(SEGMENT_TEMPLATE);
            DeliveryType deliveryType2 = DeliveryType.LIVE;
            setAttribute(elementCreateElement, document, "startNumber", deliveryType == deliveryType2 ? "0" : "1");
            setAttribute(elementCreateElement, document, "timescale", "1000");
            if (deliveryType != deliveryType2) {
                setAttribute(elementCreateElement, document, "initialization", str + SQ_0);
            }
            setAttribute(elementCreateElement, document, "media", str + "&sq=$Number$");
            element.appendChild(elementCreateElement);
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(SEGMENT_TEMPLATE, e);
        }
    }

    public static void generateSegmentTimelineElement(Document document) throws DOMException {
        try {
            ((Element) document.getElementsByTagName(SEGMENT_TEMPLATE).item(0)).appendChild(document.createElement(SEGMENT_TIMELINE));
        } catch (DOMException e) {
            throw CreationException.couldNotAddElement(SEGMENT_TIMELINE, e);
        }
    }

    public static Response getInitializationResponse(String str, ItagItem itagItem, DeliveryType deliveryType) {
        boolean z = YoutubeParsingHelper.isWebStreamingUrl(str) || YoutubeParsingHelper.isWebEmbeddedPlayerStreamingUrl(str);
        if (z) {
            str = b.z(str, ALR_YES);
        }
        String strAppendRnSqParamsIfNeeded = appendRnSqParamsIfNeeded(str, deliveryType);
        Downloader downloader = NewPipe.getDownloader();
        if (z) {
            String mimeType = itagItem.getMediaFormat().getMimeType();
            if (!Utils.isNullOrEmpty(mimeType)) {
                return getStreamingWebUrlWithoutRedirects(downloader, strAppendRnSqParamsIfNeeded, mimeType);
            }
        } else {
            if (YoutubeParsingHelper.isAndroidStreamingUrl(strAppendRnSqParamsIfNeeded)) {
                try {
                } catch (IOException | ExtractionException e) {
                    e = e;
                }
                try {
                    Object[] objArr = {YoutubeParsingHelper.getAndroidUserAgent(null)};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj = objArr[0];
                    Objects.requireNonNull(obj);
                    arrayList.add(obj);
                    return downloader.post(strAppendRnSqParamsIfNeeded, a.i(DesugarCollections.unmodifiableList(arrayList)), VideoStream.RESOLUTION_UNKNOWN.getBytes(StandardCharsets.UTF_8));
                } catch (ExtractionException e2) {
                    e = e2;
                    throw new CreationException("Could not get the ANDROID streaming URL response", e);
                }
            }
            if (YoutubeParsingHelper.isIosStreamingUrl(strAppendRnSqParamsIfNeeded)) {
                try {
                } catch (IOException | ExtractionException e3) {
                    e = e3;
                }
                try {
                    Object[] objArr2 = {YoutubeParsingHelper.getIosUserAgent(null)};
                    ArrayList arrayList2 = new ArrayList(1);
                    Object obj2 = objArr2[0];
                    Objects.requireNonNull(obj2);
                    arrayList2.add(obj2);
                    return downloader.post(strAppendRnSqParamsIfNeeded, a.i(DesugarCollections.unmodifiableList(arrayList2)), VideoStream.RESOLUTION_UNKNOWN.getBytes(StandardCharsets.UTF_8));
                } catch (ExtractionException e4) {
                    e = e4;
                    throw new CreationException("Could not get the IOS streaming URL response", e);
                }
            }
            if (YoutubeParsingHelper.isVisionOsStreamingUrl(strAppendRnSqParamsIfNeeded)) {
                try {
                } catch (IOException | ExtractionException e5) {
                    e = e5;
                }
                try {
                    Object[] objArr3 = {YoutubeParsingHelper.getVisionOsUserAgent(null)};
                    ArrayList arrayList3 = new ArrayList(1);
                    Object obj3 = objArr3[0];
                    Objects.requireNonNull(obj3);
                    arrayList3.add(obj3);
                    return downloader.post(strAppendRnSqParamsIfNeeded, a.i(DesugarCollections.unmodifiableList(arrayList3)), VideoStream.RESOLUTION_UNKNOWN.getBytes(StandardCharsets.UTF_8));
                } catch (ExtractionException e6) {
                    e = e6;
                    throw new CreationException("Could not get the VISIONOS streaming URL response", e);
                }
            }
        }
        try {
            return downloader.get(strAppendRnSqParamsIfNeeded);
        } catch (IOException | ExtractionException e7) {
            throw new CreationException("Could not get the streaming URL response", e7);
        }
    }

    private static String getRoleValue(AudioTrackType audioTrackType) {
        int i;
        return (audioTrackType == null || (i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$stream$AudioTrackType[audioTrackType.ordinal()]) == 1) ? "main" : i != 2 ? i != 3 ? "alternate" : "description" : "dub";
    }

    private static Response getStreamingWebUrlWithoutRedirects(Downloader downloader, String str, String str2) {
        try {
            HashMap map = new HashMap(YoutubeParsingHelper.getOriginReferrerHeaders("https://www.youtube.com"));
            String header = VideoStream.RESOLUTION_UNKNOWN;
            int i = 0;
            while (!header.equals(str2) && i < 20) {
                try {
                    Response responsePost = downloader.post(str, map, new byte[]{120, 0});
                    int iResponseCode = responsePost.responseCode();
                    if (iResponseCode != 200) {
                        throw new CreationException("Could not get the initialization URL: HTTP response code " + iResponseCode);
                    }
                    header = responsePost.getHeader("Content-Type");
                    Objects.requireNonNull(header, "Could not get the Content-Type header from the response headers");
                    if (!header.equals("text/plain")) {
                        return responsePost;
                    }
                    str = responsePost.responseBody();
                    i++;
                } catch (ExtractionException e) {
                    e = e;
                    throw new CreationException("Could not get the streaming URL response of a HTML5 client", e);
                }
            }
            if (i >= 20) {
                throw new CreationException("Too many redirects when trying to get the the streaming URL response of a HTML5 client");
            }
            throw new CreationException("Could not get the streaming URL response of a HTML5 client: unreachable code reached!");
        } catch (IOException | ExtractionException e2) {
            e = e2;
        }
    }

    private static Document newDocument() throws IllegalArgumentException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        try {
            documentBuilderFactoryNewInstance.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", VideoStream.RESOLUTION_UNKNOWN);
            documentBuilderFactoryNewInstance.setAttribute("http://javax.xml.XMLConstants/property/accessExternalSchema", VideoStream.RESOLUTION_UNKNOWN);
        } catch (Exception unused) {
        }
        return documentBuilderFactoryNewInstance.newDocumentBuilder().newDocument();
    }

    public static void setAttribute(Element element, Document document, String str, String str2) throws DOMException {
        Attr attrCreateAttribute = document.createAttribute(str);
        attrCreateAttribute.setValue(str2);
        element.setAttributeNode(attrCreateAttribute);
    }
}
