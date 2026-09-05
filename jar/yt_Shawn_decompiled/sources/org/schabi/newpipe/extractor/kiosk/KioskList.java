package org.schabi.newpipe.extractor.kiosk;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.merge.b.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class KioskList {
    private ContentCountry forcedContentCountry;
    private Localization forcedLocalization;
    private final StreamingService service;
    private final HashMap<String, KioskEntry> kioskList = new HashMap<>();
    private String defaultKiosk = null;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class KioskEntry {
        final KioskExtractorFactory extractorFactory;
        final ListLinkHandlerFactory handlerFactory;

        public KioskEntry(KioskExtractorFactory kioskExtractorFactory, ListLinkHandlerFactory listLinkHandlerFactory) {
            this.extractorFactory = kioskExtractorFactory;
            this.handlerFactory = listLinkHandlerFactory;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface KioskExtractorFactory {
        KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2);
    }

    public KioskList(StreamingService streamingService) {
        this.service = streamingService;
    }

    public void addKioskEntry(KioskExtractorFactory kioskExtractorFactory, ListLinkHandlerFactory listLinkHandlerFactory, String str) {
        if (this.kioskList.get(str) != null) {
            throw new Exception(b.A("Kiosk with type ", str, " already exists."));
        }
        this.kioskList.put(str, new KioskEntry(kioskExtractorFactory, listLinkHandlerFactory));
    }

    public void forceContentCountry(ContentCountry contentCountry) {
        this.forcedContentCountry = contentCountry;
    }

    public void forceLocalization(Localization localization) {
        this.forcedLocalization = localization;
    }

    public Set<String> getAvailableKiosks() {
        return this.kioskList.keySet();
    }

    public KioskExtractor getDefaultKioskExtractor(Page page, Localization localization) {
        if (!Utils.isNullOrEmpty(this.defaultKiosk)) {
            return getExtractorById(this.defaultKiosk, page, localization);
        }
        String str = (String) Collection$EL.stream(this.kioskList.keySet()).findAny().orElse(null);
        if (str != null) {
            return getExtractorById(str, page, localization);
        }
        return null;
    }

    public String getDefaultKioskId() {
        return this.defaultKiosk;
    }

    public KioskExtractor getExtractorById(String str, Page page, Localization localization) throws ExtractionException {
        KioskEntry kioskEntry = this.kioskList.get(str);
        if (kioskEntry == null) {
            throw new ExtractionException(b.n("No kiosk found with the type: ", str));
        }
        KioskExtractor kioskExtractorCreateNewKiosk = kioskEntry.extractorFactory.createNewKiosk(this.service, kioskEntry.handlerFactory.fromId(str).getUrl(), str);
        Localization localization2 = this.forcedLocalization;
        if (localization2 != null) {
            kioskExtractorCreateNewKiosk.forceLocalization(localization2);
        }
        ContentCountry contentCountry = this.forcedContentCountry;
        if (contentCountry != null) {
            kioskExtractorCreateNewKiosk.forceContentCountry(contentCountry);
        }
        return kioskExtractorCreateNewKiosk;
    }

    public KioskExtractor getExtractorByUrl(String str, Page page, Localization localization) throws ExtractionException {
        Iterator<Map.Entry<String, KioskEntry>> it = this.kioskList.entrySet().iterator();
        while (it.hasNext()) {
            KioskEntry value = it.next().getValue();
            if (value.handlerFactory.acceptUrl(str)) {
                return getExtractorById(value.handlerFactory.getId(str), page, localization);
            }
        }
        throw new ExtractionException(b.n("Could not find a kiosk that fits to the url: ", str));
    }

    public ListLinkHandlerFactory getListLinkHandlerFactoryByType(String str) {
        return this.kioskList.get(str).handlerFactory;
    }

    public void setDefaultKiosk(String str) {
        this.defaultKiosk = str;
    }

    public KioskExtractor getDefaultKioskExtractor(Page page) {
        return getDefaultKioskExtractor(page, NewPipe.getPreferredLocalization());
    }

    public KioskExtractor getDefaultKioskExtractor() {
        return getDefaultKioskExtractor(null);
    }

    public KioskExtractor getExtractorById(String str, Page page) {
        return getExtractorById(str, page, NewPipe.getPreferredLocalization());
    }

    public KioskExtractor getExtractorByUrl(String str, Page page) {
        return getExtractorByUrl(str, page, NewPipe.getPreferredLocalization());
    }
}
