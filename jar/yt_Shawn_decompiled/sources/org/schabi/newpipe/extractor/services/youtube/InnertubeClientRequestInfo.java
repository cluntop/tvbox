package org.schabi.newpipe.extractor.services.youtube;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class InnertubeClientRequestInfo {
    public ClientInfo clientInfo;
    public DeviceInfo deviceInfo;

    private InnertubeClientRequestInfo(ClientInfo clientInfo, DeviceInfo deviceInfo) {
        this.clientInfo = clientInfo;
        this.deviceInfo = deviceInfo;
    }

    public static InnertubeClientRequestInfo ofAndroidClient() {
        return new InnertubeClientRequestInfo(new ClientInfo("ANDROID", "21.03.36", "3", "WATCH"), new DeviceInfo("MOBILE", null, null, "Android", "16", 36, 0));
    }

    public static InnertubeClientRequestInfo ofIosClient() {
        return new InnertubeClientRequestInfo(new ClientInfo("IOS", "21.03.2", "5", "WATCH"), new DeviceInfo("MOBILE", "Apple", "iPhone16,2", "iOS", "18.7.2.22H124", -1, 0));
    }

    public static InnertubeClientRequestInfo ofVisionOsClient() {
        return new InnertubeClientRequestInfo(new ClientInfo("VISIONOS", "1.02", "101", "WATCH"), new DeviceInfo("MOBILE", "Apple", "RealityDevice14,1", "visionOS", "25.6.0.23O471", -1, 0));
    }

    public static InnertubeClientRequestInfo ofWebClient() {
        return new InnertubeClientRequestInfo(new ClientInfo("WEB", "2.20260120.01.00", "1", "WATCH"), new DeviceInfo("DESKTOP", null, null, null, null, -1, 0));
    }

    public static InnertubeClientRequestInfo ofWebEmbeddedPlayerClient() {
        return new InnertubeClientRequestInfo(new ClientInfo("WEB_EMBEDDED_PLAYER", "1.20260122.01.00", "56", "EMBED"), new DeviceInfo("DESKTOP", null, null, null, null, -1, 0));
    }

    public static InnertubeClientRequestInfo ofWebMusicAnalyticsChartsClient() {
        return new InnertubeClientRequestInfo(new ClientInfo("WEB_MUSIC_ANALYTICS", "2.0", "31", null), new DeviceInfo(null, null, null, null, null, -1, 0));
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class ClientInfo {
        public String clientId;
        public String clientName;
        public String clientScreen;
        public String clientVersion;
        public String visitorData;

        private ClientInfo(String str, String str2, String str3, String str4, String str5) {
            this.clientName = str;
            this.clientVersion = str2;
            this.clientId = str3;
            this.clientScreen = str4;
            this.visitorData = str5;
        }

        public /* synthetic */ ClientInfo(String str, String str2, String str3, String str4) {
            this(str, str2, str3, str4, null);
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class DeviceInfo {
        public int androidSdkVersion;
        public String deviceMake;
        public String deviceModel;
        public String osName;
        public String osVersion;
        public String platform;

        private DeviceInfo(String str, String str2, String str3, String str4, String str5, int i) {
            this.platform = str;
            this.deviceMake = str2;
            this.deviceModel = str3;
            this.osName = str4;
            this.osVersion = str5;
            this.androidSdkVersion = i;
        }

        public /* synthetic */ DeviceInfo(String str, String str2, String str3, String str4, String str5, int i, int i2) {
            this(str, str2, str3, str4, str5, i);
        }
    }
}
