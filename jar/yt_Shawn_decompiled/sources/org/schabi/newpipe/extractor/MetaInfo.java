package org.schabi.newpipe.extractor;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MetaInfo implements Serializable {
    private Description content;
    private String title;
    private List<String> urlTexts;
    private List<URL> urls;

    public MetaInfo(String str, Description description, List<URL> list, List<String> list2) {
        this.title = VideoStream.RESOLUTION_UNKNOWN;
        this.urls = new ArrayList();
        new ArrayList();
        this.title = str;
        this.content = description;
        this.urls = list;
        this.urlTexts = list2;
    }

    public void addUrl(URL url) {
        this.urls.add(url);
    }

    public void addUrlText(String str) {
        this.urlTexts.add(str);
    }

    public Description getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getUrlTexts() {
        return this.urlTexts;
    }

    public List<URL> getUrls() {
        return this.urls;
    }

    public void setContent(Description description) {
        this.content = description;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrlTexts(List<String> list) {
        this.urlTexts = list;
    }

    public void setUrls(List<URL> list) {
        this.urls = list;
    }

    public MetaInfo() {
        this.title = VideoStream.RESOLUTION_UNKNOWN;
        this.urls = new ArrayList();
        this.urlTexts = new ArrayList();
    }
}
