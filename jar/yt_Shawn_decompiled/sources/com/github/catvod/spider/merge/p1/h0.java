package com.github.catvod.spider.merge.p1;

import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h0 {
    public static final h0 d;
    public final HashMap a = new HashMap();
    public final h0 b;
    public final ArrayList c;

    static {
        h0 h0Var = new h0(null, null);
        final int i = 5;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "dialog", "search", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "details", "menu", "plaintext", "template", "article", "main", "center", "dir", "applet", "marquee", "listing", "#root"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i2 = i;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i2 = 10;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "rtc", "a", "img", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "audio", "video", "canvas", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "basefont", "bgsound", "menuitem", "data", "bdi", "s", "strike", "nobr", "ins", "del", "button", "picture", "slot", "rb"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i2) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i2;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i3 = 11;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"title", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i3) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i3;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i4 = 12;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i4) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i4;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i5 = 13;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"pre", "plaintext", "title", "textarea", "script"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i5) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i5;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i6 = 0;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"title", "textarea"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i6) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i6;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i7 = 1;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"iframe", "noembed", "noframes", "script", "style", "xmp"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i7) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i7;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i8 = 2;
        h0Var.c("http://www.w3.org/1999/xhtml", com.github.catvod.spider.merge.n1.a.c, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i8) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i8;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i9 = 3;
        h0Var.c("http://www.w3.org/1999/xhtml", new String[]{"button", "input", "select", "textarea", "option", "output", "progress", "meter", "img", "picture", "audio", "video", "canvas", "object", "embed", "iframe"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i9) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i9;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i10 = 4;
        h0Var.c("http://www.w3.org/1998/Math/MathML", new String[]{"math"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i10) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i10;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i11 = 6;
        h0Var.c("http://www.w3.org/1998/Math/MathML", new String[]{"mi", "mo", "msup", "mn", "mtext"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i11) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i11;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i12 = 7;
        h0Var.c("http://www.w3.org/2000/svg", new String[]{"svg", "femerge", "femergenode"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i12) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i12;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i13 = 8;
        h0Var.c("http://www.w3.org/2000/svg", new String[]{"text"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i13) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i13;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        final int i14 = 9;
        h0Var.c("http://www.w3.org/2000/svg", new String[]{"script"}, new Consumer() { // from class: com.github.catvod.spider.merge.p1.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                f0 f0Var = (f0) obj;
                switch (i14) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        f0Var.e(128);
                        break;
                    case 1:
                        f0Var.e(256);
                        break;
                    case 2:
                        f0Var.e(512);
                        break;
                    case 3:
                        f0Var.e(1024);
                        break;
                    case 4:
                        f0Var.e(4);
                        break;
                    case 5:
                        f0Var.e(4);
                        break;
                    case 6:
                        f0Var.e(0);
                        break;
                    case 7:
                        f0Var.e(4);
                        break;
                    case 8:
                        f0Var.e(0);
                        break;
                    case 9:
                        f0Var.e(256);
                        break;
                    case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                        f0Var.e(0);
                        break;
                    case 11:
                        f0Var.e(8);
                        break;
                    case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                        f0Var.e(2);
                        break;
                    default:
                        f0Var.e(64);
                        break;
                }
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                int i22 = i14;
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        d = h0Var;
    }

    public h0(h0 h0Var, ArrayList arrayList) {
        this.b = h0Var;
        this.c = arrayList;
    }

    public final void a(f0 f0Var) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(f0Var);
            }
        }
        ((Map) Map.EL.computeIfAbsent(this.a, f0Var.a, new com.github.catvod.spider.merge.n1.g(3))).put(f0Var.b, f0Var);
    }

    public final f0 b(String str, String str2) {
        f0 f0VarB;
        f0 f0Var;
        com.github.catvod.spider.merge.u.c2.R(str);
        com.github.catvod.spider.merge.u.c2.R(str2);
        java.util.Map map = (java.util.Map) this.a.get(str2);
        if (map != null && (f0Var = (f0) map.get(str)) != null) {
            return f0Var;
        }
        h0 h0Var = this.b;
        if (h0Var == null || (f0VarB = h0Var.b(str, str2)) == null) {
            return null;
        }
        f0 f0VarClone = f0VarB.clone();
        a(f0VarClone);
        return f0VarClone;
    }

    public final void c(String str, String[] strArr, Consumer consumer) {
        for (String str2 : strArr) {
            f0 f0VarB = b(str2, str);
            if (f0VarB == null) {
                f0VarB = new f0(str2, str2, str);
                f0VarB.d = 0;
                f0VarB.e(1);
                a(f0VarB);
            }
            consumer.accept(f0VarB);
        }
    }

    public final f0 d(String str, String str2, String str3, boolean z) {
        com.github.catvod.spider.merge.u.c2.R(str);
        com.github.catvod.spider.merge.u.c2.R(str3);
        String strTrim = str.trim();
        com.github.catvod.spider.merge.u.c2.P(strTrim);
        f0 f0VarB = b(strTrim, str3);
        if (f0VarB != null) {
            return f0VarB;
        }
        if (str2 == null) {
            str2 = com.github.catvod.spider.merge.n1.a.d(strTrim);
        }
        if (!z) {
            strTrim = str2;
        }
        f0 f0VarB2 = b(str2, str3);
        if (f0VarB2 == null) {
            f0 f0Var = new f0(strTrim, str2, str3);
            a(f0Var);
            return f0Var;
        }
        if (!z || strTrim.equals(str2)) {
            return f0VarB2;
        }
        f0 f0VarClone = f0VarB2.clone();
        f0VarClone.b = strTrim;
        a(f0VarClone);
        return f0VarClone;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h0) {
            return Objects.equals(this.a, ((h0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }
}
