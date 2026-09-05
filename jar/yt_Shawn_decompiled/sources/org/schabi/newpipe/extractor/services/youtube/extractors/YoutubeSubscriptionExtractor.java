package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.io.BufferedReaderRetargetClass;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.services.youtube.YoutubeService;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionItem;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeSubscriptionExtractor extends SubscriptionExtractor {
    private static final String BASE_CHANNEL_URL = "https://www.youtube.com/channel/";

    public YoutubeSubscriptionExtractor(YoutubeService youtubeService) {
        super(youtubeService, Collections.singletonList(SubscriptionExtractor.ContentSource.INPUT_STREAM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$fromCsvInputStream$0(String str) {
        return str.split(",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$fromCsvInputStream$1(String[] strArr) {
        return strArr.length >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SubscriptionItem lambda$fromCsvInputStream$2(String[] strArr) {
        String strReplace = strArr[1].replace(Utils.HTTP, Utils.HTTPS);
        if (strReplace.startsWith(BASE_CHANNEL_URL)) {
            return new SubscriptionItem(this.service.getServiceId(), strReplace, strArr[2]);
        }
        return null;
    }

    public List<SubscriptionItem> fromCsvInputStream(InputStream inputStream) throws SubscriptionExtractor.InvalidSourceException, IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                List<SubscriptionItem> list = (List) BufferedReaderRetargetClass.lines(bufferedReader).skip(1L).map(new s(6)).filter(new t(1)).map(new r(1, this)).filter(new t(2)).collect(Collectors.toUnmodifiableList());
                bufferedReader.close();
                return list;
            } finally {
            }
        } catch (IOException | UncheckedIOException e) {
            throw new SubscriptionExtractor.InvalidSourceException("Error reading CSV file", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.subscription.SubscriptionExtractor
    public List<SubscriptionItem> fromInputStream(InputStream inputStream, String str) throws SubscriptionExtractor.InvalidSourceException {
        str.getClass();
        switch (str) {
            case "text/comma-separated-values":
            case "text/csv":
            case "csv":
                return fromCsvInputStream(inputStream);
            case "application/zip":
            case "zip":
                return fromZipInputStream(inputStream);
            case "application/json":
            case "json":
                return fromJsonInputStream(inputStream);
            default:
                throw new SubscriptionExtractor.InvalidSourceException("Unsupported content type: ".concat(str));
        }
    }

    public List<SubscriptionItem> fromJsonInputStream(InputStream inputStream) throws SubscriptionExtractor.InvalidSourceException {
        try {
            JsonArray jsonArrayFrom = JsonParser.array().from(inputStream);
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = jsonArrayFrom.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    JsonObject object = ((JsonObject) next).getObject("snippet");
                    String string = object.getObject("resourceId").getString("channelId", VideoStream.RESOLUTION_UNKNOWN);
                    if (string.length() == 24) {
                        arrayList.add(new SubscriptionItem(this.service.getServiceId(), BASE_CHANNEL_URL.concat(string), object.getString("title", VideoStream.RESOLUTION_UNKNOWN)));
                    }
                }
                z = true;
            }
            if (z && arrayList.isEmpty()) {
                throw new SubscriptionExtractor.InvalidSourceException("Found only invalid channel ids");
            }
            return arrayList;
        } catch (JsonParserException e) {
            throw new SubscriptionExtractor.InvalidSourceException("Invalid json input stream", e);
        }
    }

    public List<SubscriptionItem> fromZipInputStream(InputStream inputStream) throws SubscriptionExtractor.InvalidSourceException, IOException {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        throw new SubscriptionExtractor.InvalidSourceException("Unable to find a valid subscriptions.csv file (try extracting and selecting the csv file)");
                    }
                    if (nextEntry.getName().toLowerCase().endsWith(".csv")) {
                        try {
                            List<SubscriptionItem> listFromCsvInputStream = fromCsvInputStream(zipInputStream);
                            if (!listFromCsvInputStream.isEmpty()) {
                                zipInputStream.close();
                                return listFromCsvInputStream;
                            }
                        } catch (ExtractionException unused) {
                            continue;
                        }
                    }
                } finally {
                }
            }
        } catch (IOException e) {
            throw new SubscriptionExtractor.InvalidSourceException("Error reading contents of zip file", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.subscription.SubscriptionExtractor
    public String getRelatedUrl() {
        return "https://takeout.google.com/takeout/custom/youtube";
    }

    @Override // org.schabi.newpipe.extractor.subscription.SubscriptionExtractor
    public List<SubscriptionItem> fromInputStream(InputStream inputStream) {
        return fromJsonInputStream(inputStream);
    }
}
