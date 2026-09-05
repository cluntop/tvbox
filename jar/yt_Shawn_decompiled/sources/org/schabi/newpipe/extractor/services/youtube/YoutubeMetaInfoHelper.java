package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.q1.w;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeMetaInfoHelper {
    private YoutubeMetaInfoHelper() {
    }

    private static MetaInfo getClarificationRenderer(JsonObject jsonObject) throws ParsingException {
        String urlFromNavigationEndpoint;
        MetaInfo metaInfo = new MetaInfo();
        String textFromObject = YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("contentTitle"));
        String textFromObject2 = YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("text"));
        if (textFromObject == null || textFromObject2 == null) {
            org.schabi.newpipe.extractor.utils.c.a("Could not extract clarification renderer content");
            return null;
        }
        metaInfo.setTitle(textFromObject);
        metaInfo.setContent(new Description(textFromObject2, 3));
        if (jsonObject.has("actionButton")) {
            JsonObject object = jsonObject.getObject("actionButton").getObject("buttonRenderer");
            try {
                String strExtractCachedUrlIfNeeded = YoutubeParsingHelper.extractCachedUrlIfNeeded(YoutubeParsingHelper.getUrlFromNavigationEndpoint(object.getObject("command")));
                Objects.requireNonNull(strExtractCachedUrlIfNeeded);
                metaInfo.addUrl(new URL(strExtractCachedUrlIfNeeded));
                String textFromObject3 = YoutubeParsingHelper.getTextFromObject(object.getObject("text"));
                if (Utils.isNullOrEmpty(textFromObject3)) {
                    org.schabi.newpipe.extractor.utils.c.a("Could not get metadata info link text.");
                    return null;
                }
                metaInfo.addUrlText(textFromObject3);
            } catch (NullPointerException | MalformedURLException e) {
                com.github.catvod.spider.merge.s0.a.m("Could not get metadata info URL", e);
                return null;
            }
        }
        if (!jsonObject.has("secondaryEndpoint") || !jsonObject.has("secondarySource") || (urlFromNavigationEndpoint = YoutubeParsingHelper.getUrlFromNavigationEndpoint(jsonObject.getObject("secondaryEndpoint"))) == null || YoutubeParsingHelper.isGoogleURL(urlFromNavigationEndpoint)) {
            return metaInfo;
        }
        try {
            metaInfo.addUrl(new URL(urlFromNavigationEndpoint));
            String textFromObject4 = YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("secondarySource"));
            if (textFromObject4 != null) {
                urlFromNavigationEndpoint = textFromObject4;
            }
            metaInfo.addUrlText(urlFromNavigationEndpoint);
            return metaInfo;
        } catch (MalformedURLException e2) {
            com.github.catvod.spider.merge.s0.a.m("Could not get metadata info secondary URL", e2);
            return null;
        }
    }

    private static void getEmergencyOneboxRenderer(JsonObject jsonObject, Consumer<MetaInfo> consumer) throws ParsingException {
        String string;
        List<JsonObject> list = (List) Collection$EL.stream(jsonObject.values()).filter(new b(3)).map(new a(9)).collect(Collectors.toList());
        if (list.isEmpty()) {
            org.schabi.newpipe.extractor.utils.c.a("Could not extract any meta info from emergency renderer");
            return;
        }
        for (JsonObject jsonObject2 : list) {
            MetaInfo metaInfo = new MetaInfo();
            String textFromObjectOrThrow = YoutubeParsingHelper.getTextFromObjectOrThrow(jsonObject2.getObject("title"), "title");
            if (jsonObject2.has("actionText")) {
                string = com.github.catvod.spider.merge.b.b.n("\n", YoutubeParsingHelper.getTextFromObjectOrThrow(jsonObject2.getObject("actionText"), "action"));
            } else if (jsonObject2.has("contacts")) {
                JsonArray array = jsonObject2.getArray("contacts");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < array.size(); i++) {
                    sb.append("\n");
                    sb.append(YoutubeParsingHelper.getTextFromObjectOrThrow(array.getObject(i).getObject("actionText"), "contacts.actionText"));
                }
                string = sb.toString();
            } else {
                string = VideoStream.RESOLUTION_UNKNOWN;
            }
            String textFromObjectOrThrow2 = YoutubeParsingHelper.getTextFromObjectOrThrow(jsonObject2.getObject("detailsText"), "details");
            String textFromObjectOrThrow3 = YoutubeParsingHelper.getTextFromObjectOrThrow(jsonObject2.getObject("navigationText"), "urlText");
            metaInfo.setTitle(textFromObjectOrThrow);
            metaInfo.setContent(new Description(com.github.catvod.spider.merge.b.b.z(textFromObjectOrThrow2, string), 3));
            metaInfo.addUrlText(textFromObjectOrThrow3);
            String urlFromNavigationEndpoint = YoutubeParsingHelper.getUrlFromNavigationEndpoint(jsonObject2.getObject("navigationEndpoint"));
            if (urlFromNavigationEndpoint == null) {
                org.schabi.newpipe.extractor.utils.c.a("Could not extract emergency renderer url");
                return;
            }
            try {
                metaInfo.addUrl(new URL(Utils.replaceHttpWithHttps(urlFromNavigationEndpoint)));
                consumer.accept(metaInfo);
            } catch (MalformedURLException e) {
                com.github.catvod.spider.merge.s0.a.m("Could not parse emergency renderer url", e);
                return;
            }
        }
    }

    private static MetaInfo getInfoPanelContent(JsonObject jsonObject) throws ParsingException {
        MetaInfo metaInfo = new MetaInfo();
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = jsonObject.getArray("paragraphs").iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (sb.length() != 0) {
                sb.append("<br>");
            }
            sb.append(YoutubeParsingHelper.getTextFromObject((JsonObject) next));
        }
        metaInfo.setContent(new Description(sb.toString(), 1));
        if (!jsonObject.has("sourceEndpoint")) {
            return metaInfo;
        }
        try {
            String strExtractCachedUrlIfNeeded = YoutubeParsingHelper.extractCachedUrlIfNeeded(YoutubeParsingHelper.getUrlFromNavigationEndpoint(jsonObject.getObject("sourceEndpoint")));
            Objects.requireNonNull(strExtractCachedUrlIfNeeded);
            metaInfo.addUrl(new URL(strExtractCachedUrlIfNeeded));
            String textFromObject = jsonObject.has("inlineSource") ? YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("inlineSource")) : YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("disclaimer"));
            if (Utils.isNullOrEmpty(textFromObject)) {
                org.schabi.newpipe.extractor.utils.c.a("Could not get metadata info link text.");
                return null;
            }
            metaInfo.addUrlText(textFromObject);
            return metaInfo;
        } catch (NullPointerException | MalformedURLException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get metadata info URL", e);
            return null;
        }
    }

    public static List<MetaInfo> getMetaInfo(JsonArray jsonArray) throws ParsingException {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonObject jsonObject = (JsonObject) it.next();
            if (jsonObject.has("itemSectionRenderer")) {
                Iterator<Object> it2 = jsonObject.getObject("itemSectionRenderer").getArray("contents").iterator();
                while (it2.hasNext()) {
                    JsonObject jsonObject2 = (JsonObject) it2.next();
                    if (jsonObject2.has("infoPanelContentRenderer")) {
                        arrayList.add(getInfoPanelContent(jsonObject2.getObject("infoPanelContentRenderer")));
                    }
                    if (jsonObject2.has("clarificationRenderer")) {
                        arrayList.add(getClarificationRenderer(jsonObject2.getObject("clarificationRenderer")));
                    }
                    if (jsonObject2.has("emergencyOneboxRenderer")) {
                        getEmergencyOneboxRenderer(jsonObject2.getObject("emergencyOneboxRenderer"), new w(4, arrayList));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getEmergencyOneboxRenderer$0(Object obj) {
        return (obj instanceof JsonObject) && ((JsonObject) obj).has("singleActionEmergencySupportRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getEmergencyOneboxRenderer$1(Object obj) {
        return ((JsonObject) obj).getObject("singleActionEmergencySupportRenderer");
    }
}
