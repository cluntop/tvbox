package com.github.catvod.spider.merge.b0;

import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import com.google.gson.JsonIOException;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.hierynomus.spnego.SpnegoException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements SettingsUI.Callback, SettingsUI.SearchCallback, ObjectConstructor {
    public final /* synthetic */ int a;

    public static /* synthetic */ void a(String str) {
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ void b(String str, int i, int i2, Object obj) {
        throw new IllegalArgumentException(str + i + obj + i2);
    }

    public static /* synthetic */ void c(String str, int i, Object obj, int i2, Object obj2, int i3) {
        throw new IndexOutOfBoundsException(str + i + obj + i2 + obj2 + i3);
    }

    public static /* synthetic */ void d(String str, Object obj) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void e(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void g(String str, int i, int i2, Object obj) {
        throw new IndexOutOfBoundsException(str + i + obj + i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.hierynomus.spnego.SpnegoException */
    public static /* synthetic */ void h(String str, Object obj) throws SpnegoException {
        throw new SpnegoException(str + obj);
    }

    public static /* synthetic */ void j(String str, Object obj) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void k(String str, Object obj) {
        throw new IllegalStateException(str + obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonIOException */
    public static /* synthetic */ void l(String str, Object obj) throws JsonIOException {
        throw new JsonIOException(str + obj);
    }

    public Object construct() {
        switch (this.a) {
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                return new TreeMap();
            case 21:
                return new ConcurrentHashMap();
            case 22:
                return new ConcurrentSkipListMap();
            case 23:
                return new ArrayList();
            case 24:
                return new LinkedHashSet();
            case 25:
                return new TreeSet();
            case 26:
                return new ArrayDeque();
            case 27:
                return ConstructorConstructor.c();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // com.github.catvod.spider.SettingsUI.Callback
    public void onResult(String str) {
        String str2;
        int i = this.a;
        String strTrim = VideoStream.RESOLUTION_UNKNOWN;
        switch (i) {
            case 7:
                boolean z = Youtube.e;
                if (str != null) {
                    strTrim = str.trim();
                }
                Youtube.E = strTrim;
                Youtube.Y0();
                Youtube.i();
                if (Youtube.E.isEmpty()) {
                    str2 = "已关闭 proxy";
                } else {
                    str2 = "已设置 proxy：" + Youtube.E;
                }
                com.github.catvod.spider.merge.g1.a.e(str2);
                SettingsUI.refreshCategory();
                break;
            case 8:
                boolean z2 = Youtube.e;
                if (str != null) {
                    strTrim = str.trim();
                }
                ClashCore.setSubscribeUrl(strTrim);
                Youtube.Y0();
                if (ClashCore.isRunning()) {
                    ClashCore.stop();
                }
                ClashCore.clearCachedNodes();
                com.github.catvod.spider.merge.g1.a.e("已保存订阅，点「更新节点」拉取");
                SettingsUI.refreshCategory();
                break;
            case 9:
                boolean z3 = Youtube.e;
                if (str != null) {
                    strTrim = str.trim();
                }
                ClashCore.setLocalFile(strTrim);
                Youtube.Y0();
                if (ClashCore.isRunning()) {
                    ClashCore.stop();
                }
                ClashCore.clearCachedNodes();
                com.github.catvod.spider.merge.g1.a.e("已保存本地档案".concat((str == null || str.trim().isEmpty()) ? "（已清空，将使用订阅地址）" : "，点「更新节点」加载"));
                SettingsUI.refreshCategory();
                break;
            default:
                boolean z4 = Youtube.e;
                if (str != null) {
                    strTrim = str.trim();
                }
                ClashCore.setLocalFile(strTrim);
                Youtube.Y0();
                if (ClashCore.isRunning()) {
                    ClashCore.stop();
                }
                ClashCore.clearCachedNodes();
                StringBuilder sb = new StringBuilder("已选择本地档案：");
                if (str == null || str.trim().isEmpty()) {
                    str = "（未选择）";
                }
                sb.append(str);
                sb.append("，点「更新节点」加载");
                com.github.catvod.spider.merge.g1.a.e(sb.toString());
                SettingsUI.refreshCategory();
                break;
        }
    }

    @Override // com.github.catvod.spider.SettingsUI.SearchCallback
    public void onSearch(String str, int i) {
        boolean z = Youtube.e;
        if (str == null || str.isEmpty()) {
            return;
        }
        Youtube.I = str;
        Youtube.N = i;
        SettingsUI.refreshCategory();
    }
}
