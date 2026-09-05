package com.github.catvod.spider.jdollar.nio.file.attribute;

import java.nio.file.attribute.FileStoreAttributeView;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements b {
    public final /* synthetic */ FileStoreAttributeView a;

    public final /* synthetic */ boolean equals(Object obj) {
        FileStoreAttributeView fileStoreAttributeView = this.a;
        if (obj instanceof q) {
            obj = ((q) obj).a;
        }
        return fileStoreAttributeView.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.attribute.b
    public final /* synthetic */ String name() {
        throw null;
    }
}
