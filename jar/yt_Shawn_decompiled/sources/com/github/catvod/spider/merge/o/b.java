package com.github.catvod.spider.merge.o;

import android.app.Application;
import android.content.ContentProvider;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b extends ContentProvider {
    public static final HashMap a = new HashMap();

    public static a a(Application application, String str) {
        a aVar = new a(str);
        ProviderInfo providerInfoResolveContentProvider = application.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            com.github.catvod.spider.merge.s0.a.r("Couldn't find meta-data for provider with authority ".concat(str));
            return null;
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(application.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            com.github.catvod.spider.merge.s0.a.r("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            return null;
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return aVar;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                File cacheDir = "cache-path".equals(name) ? application.getCacheDir() : "external-path".equals(name) ? Environment.getExternalStorageDirectory() : null;
                if (cacheDir == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        cacheDir = new File(cacheDir, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        com.github.catvod.spider.merge.s0.a.r("Name must not be empty");
                        return null;
                    }
                    try {
                        aVar.b.put(attributeValue, cacheDir.getCanonicalFile());
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + cacheDir, e);
                    }
                }
            }
        }
    }
}
