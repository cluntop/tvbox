package org.schabi.newpipe.extractor.channel;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Info;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ChannelInfo extends Info {
    private List<Image> avatars;
    private List<Image> banners;
    private String description;
    private String[] donationLinks;
    private String feedUrl;
    private List<Image> parentChannelAvatars;
    private String parentChannelName;
    private String parentChannelUrl;
    private long subscriberCount;
    private List<ListLinkHandler> tabs;
    private List<String> tags;
    private boolean verified;

    public ChannelInfo(int i, String str, String str2, String str3, String str4) {
        super(i, str, str2, str3, str4);
        this.subscriberCount = -1L;
        List list = Collections.EMPTY_LIST;
        this.avatars = list;
        this.banners = list;
        this.parentChannelAvatars = list;
        this.tabs = list;
        this.tags = list;
    }

    public static ChannelInfo getInfo(ChannelExtractor channelExtractor) {
        ChannelInfo channelInfo = new ChannelInfo(channelExtractor.getServiceId(), channelExtractor.getId(), channelExtractor.getUrl(), channelExtractor.getOriginalUrl(), channelExtractor.getName());
        try {
            channelInfo.setAvatars(channelExtractor.getAvatars());
        } catch (Exception e) {
            channelInfo.addError(e);
        }
        try {
            channelInfo.setBanners(channelExtractor.getBanners());
        } catch (Exception e2) {
            channelInfo.addError(e2);
        }
        try {
            channelInfo.setFeedUrl(channelExtractor.getFeedUrl());
        } catch (Exception e3) {
            channelInfo.addError(e3);
        }
        try {
            channelInfo.setSubscriberCount(channelExtractor.getSubscriberCount());
        } catch (Exception e4) {
            channelInfo.addError(e4);
        }
        try {
            channelInfo.setDescription(channelExtractor.getDescription());
        } catch (Exception e5) {
            channelInfo.addError(e5);
        }
        try {
            channelInfo.setParentChannelName(channelExtractor.getParentChannelName());
        } catch (Exception e6) {
            channelInfo.addError(e6);
        }
        try {
            channelInfo.setParentChannelUrl(channelExtractor.getParentChannelUrl());
        } catch (Exception e7) {
            channelInfo.addError(e7);
        }
        try {
            channelInfo.setParentChannelAvatars(channelExtractor.getParentChannelAvatars());
        } catch (Exception e8) {
            channelInfo.addError(e8);
        }
        try {
            channelInfo.setVerified(channelExtractor.isVerified());
        } catch (Exception e9) {
            channelInfo.addError(e9);
        }
        try {
            channelInfo.setTabs(channelExtractor.getTabs());
        } catch (Exception e10) {
            channelInfo.addError(e10);
        }
        try {
            channelInfo.setTags(channelExtractor.getTags());
        } catch (Exception e11) {
            channelInfo.addError(e11);
        }
        return channelInfo;
    }

    public List<Image> getAvatars() {
        return this.avatars;
    }

    public List<Image> getBanners() {
        return this.banners;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getDonationLinks() {
        return this.donationLinks;
    }

    public String getFeedUrl() {
        return this.feedUrl;
    }

    public List<Image> getParentChannelAvatars() {
        return this.parentChannelAvatars;
    }

    public String getParentChannelName() {
        return this.parentChannelName;
    }

    public String getParentChannelUrl() {
        return this.parentChannelUrl;
    }

    public long getSubscriberCount() {
        return this.subscriberCount;
    }

    public List<ListLinkHandler> getTabs() {
        return this.tabs;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setAvatars(List<Image> list) {
        this.avatars = list;
    }

    public void setBanners(List<Image> list) {
        this.banners = list;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDonationLinks(String[] strArr) {
        this.donationLinks = strArr;
    }

    public void setFeedUrl(String str) {
        this.feedUrl = str;
    }

    public void setParentChannelAvatars(List<Image> list) {
        this.parentChannelAvatars = list;
    }

    public void setParentChannelName(String str) {
        this.parentChannelName = str;
    }

    public void setParentChannelUrl(String str) {
        this.parentChannelUrl = str;
    }

    public void setSubscriberCount(long j) {
        this.subscriberCount = j;
    }

    public void setTabs(List<ListLinkHandler> list) {
        this.tabs = list;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }

    public static ChannelInfo getInfo(StreamingService streamingService, String str) {
        ChannelExtractor channelExtractor = streamingService.getChannelExtractor(str);
        channelExtractor.fetchPage();
        return getInfo(channelExtractor);
    }

    public static ChannelInfo getInfo(String str) {
        return getInfo(NewPipe.getServiceByUrl(str), str);
    }
}
