package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.merge.n1.d;
import java.util.List;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.utils.ExtractorLogger;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class NewPipe {
    private static final String TAG = "NewPipe";
    private static Downloader downloader;
    private static ContentCountry preferredContentCountry;
    private static Localization preferredLocalization;

    private NewPipe() {
    }

    public static Downloader getDownloader() {
        return downloader;
    }

    public static ContentCountry getPreferredContentCountry() {
        ContentCountry contentCountry = preferredContentCountry;
        return contentCountry == null ? ContentCountry.DEFAULT : contentCountry;
    }

    public static Localization getPreferredLocalization() {
        Localization localization = preferredLocalization;
        return localization == null ? Localization.DEFAULT : localization;
    }

    public static StreamingService getService(String str) {
        return (StreamingService) Collection$EL.stream(ServiceList.all()).filter(new a(str, 3)).findFirst().orElseThrow(new d(str, 1));
    }

    public static StreamingService getServiceByUrl(String str) throws ExtractionException {
        for (StreamingService streamingService : ServiceList.all()) {
            if (streamingService.getLinkTypeByUrl(str) != StreamingService.LinkType.NONE) {
                return streamingService;
            }
        }
        throw new ExtractionException(com.github.catvod.spider.merge.b.b.A("No service can handle the url = \"", str, "\""));
    }

    public static List<StreamingService> getServices() {
        return ServiceList.all();
    }

    public static void init(Downloader downloader2, Localization localization) {
        ExtractorLogger.d(TAG, "Default init called with localization={}");
        init(downloader2, localization, localization.getCountryCode().isEmpty() ? ContentCountry.DEFAULT : new ContentCountry(localization.getCountryCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getService$0(int i, StreamingService streamingService) {
        return streamingService.getServiceId() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExtractionException lambda$getService$1(int i) {
        return new ExtractionException(com.github.catvod.spider.merge.b.b.k(i, "There's no service with the id = \"", "\""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getService$2(String str, StreamingService streamingService) {
        return streamingService.getServiceInfo().getName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExtractionException lambda$getService$3(String str) {
        return new ExtractionException(com.github.catvod.spider.merge.b.b.A("There's no service with the name = \"", str, "\""));
    }

    public static void setPreferredContentCountry(ContentCountry contentCountry) {
        preferredContentCountry = contentCountry;
    }

    public static void setPreferredLocalization(Localization localization) {
        preferredLocalization = localization;
    }

    public static void setupLocalization(Localization localization, ContentCountry contentCountry) {
        preferredLocalization = localization;
        if (contentCountry != null) {
            preferredContentCountry = contentCountry;
        } else {
            preferredContentCountry = localization.getCountryCode().isEmpty() ? ContentCountry.DEFAULT : new ContentCountry(localization.getCountryCode());
        }
    }

    public static void init(Downloader downloader2) {
        ExtractorLogger.d(TAG, "Default init called");
        init(downloader2, Localization.DEFAULT);
    }

    public static void setupLocalization(Localization localization) {
        setupLocalization(localization, null);
    }

    public static StreamingService getService(final int i) {
        return (StreamingService) Collection$EL.stream(ServiceList.all()).filter(new b(i, 1)).findFirst().orElseThrow(new Supplier() { // from class: org.schabi.newpipe.extractor.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return NewPipe.lambda$getService$1(i);
            }
        });
    }

    public static void init(Downloader downloader2, Localization localization, ContentCountry contentCountry) {
        ExtractorLogger.d(TAG, "Initializing with downloader={}, localization={}, country={}", downloader2, localization, contentCountry);
        downloader = downloader2;
        preferredLocalization = localization;
        preferredContentCountry = contentCountry;
    }
}
