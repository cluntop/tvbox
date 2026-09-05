package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.y0.g0;
import com.github.catvod.spider.merge.y0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.MatcherMatchResult;
import okhttp3.internal.cache.DiskLruCache;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class t extends s {
    private final s delegate;

    public t(s sVar) {
        sVar.getClass();
        this.delegate = sVar;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p0 appendingSink(g0 g0Var, boolean z) {
        g0Var.getClass();
        return this.delegate.appendingSink(onPathParameter(g0Var, "appendingSink", "file"), z);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void atomicMove(g0 g0Var, g0 g0Var2) {
        g0Var.getClass();
        g0Var2.getClass();
        this.delegate.atomicMove(onPathParameter(g0Var, "atomicMove", "source"), onPathParameter(g0Var2, "atomicMove", "target"));
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public g0 canonicalize(g0 g0Var) {
        g0Var.getClass();
        return onPathResult(this.delegate.canonicalize(onPathParameter(g0Var, "canonicalize", "path")), "canonicalize");
    }

    @Override // com.github.catvod.spider.merge.y0.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void createDirectory(g0 g0Var, boolean z) {
        g0Var.getClass();
        this.delegate.createDirectory(onPathParameter(g0Var, "createDirectory", "dir"), z);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void createSymlink(g0 g0Var, g0 g0Var2) {
        g0Var.getClass();
        g0Var2.getClass();
        this.delegate.createSymlink(onPathParameter(g0Var, "createSymlink", "source"), onPathParameter(g0Var2, "createSymlink", "target"));
    }

    public final s delegate() {
        return this.delegate;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public void delete(g0 g0Var, boolean z) {
        g0Var.getClass();
        this.delegate.delete(onPathParameter(g0Var, "delete", "path"), z);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public List<g0> list(g0 g0Var) {
        g0Var.getClass();
        List list = this.delegate.list(onPathParameter(g0Var, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((g0) it.next(), "list"));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public List<g0> listOrNull(g0 g0Var) {
        g0Var.getClass();
        List listListOrNull = this.delegate.listOrNull(onPathParameter(g0Var, "listOrNull", "dir"));
        if (listListOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listListOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((g0) it.next(), "listOrNull"));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public Sequence<g0> listRecursively(g0 g0Var, boolean z) {
        g0Var.getClass();
        final int i = 8;
        return SequencesKt.map(this.delegate.listRecursively(onPathParameter(g0Var, "listRecursively", "dir"), z), new Function1() { // from class: com.github.catvod.spider.merge.l0.a
            public final Object invoke(Object obj) {
                int i2 = i;
                Object obj2 = this;
                switch (i2) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        return AbstractCollection.a((AbstractCollection) obj2, obj);
                    case 1:
                        return AbstractMap.a((AbstractMap) obj2, (Map.Entry) obj);
                    case 2:
                        return TextStreamsKt.a((ArrayList) obj2, (String) obj);
                    case 3:
                        return TypeReference.a((TypeReference) obj2, (KTypeProjection) obj);
                    case 4:
                        return Boolean.valueOf(SequencesKt___SequencesKt.minus.2.a((Object[]) obj2, obj));
                    case 5:
                        return Boolean.valueOf(SequencesKt___SequencesKt.minus.3.a((Collection) obj2, obj));
                    case 6:
                        return Boolean.valueOf(SequencesKt___SequencesKt.minus.4.a((List) obj2, obj));
                    case 7:
                        return MatcherMatchResult.groups.1.b((MatcherMatchResult.groups.1) obj2, ((Integer) obj).intValue());
                    case 8:
                        g0 g0Var2 = (g0) obj;
                        g0Var2.getClass();
                        return ((t) obj2).onPathResult(g0Var2, "listRecursively");
                    default:
                        return DiskLruCache.j((DiskLruCache) obj2, (IOException) obj);
                }
            }
        });
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public q metadataOrNull(g0 g0Var) {
        g0Var.getClass();
        q qVarMetadataOrNull = this.delegate.metadataOrNull(onPathParameter(g0Var, "metadataOrNull", "path"));
        if (qVarMetadataOrNull == null) {
            return null;
        }
        g0 g0Var2 = qVarMetadataOrNull.c;
        if (g0Var2 == null) {
            return qVarMetadataOrNull;
        }
        g0 g0VarOnPathResult = onPathResult(g0Var2, "metadataOrNull");
        boolean z = qVarMetadataOrNull.a;
        boolean z2 = qVarMetadataOrNull.b;
        Long l = qVarMetadataOrNull.d;
        Long l2 = qVarMetadataOrNull.e;
        Long l3 = qVarMetadataOrNull.f;
        Long l4 = qVarMetadataOrNull.g;
        Map map = qVarMetadataOrNull.h;
        map.getClass();
        return new q(z, z2, g0VarOnPathResult, l, l2, l3, l4, map);
    }

    public g0 onPathParameter(g0 g0Var, String str, String str2) {
        g0Var.getClass();
        str.getClass();
        str2.getClass();
        return g0Var;
    }

    public g0 onPathResult(g0 g0Var, String str) {
        g0Var.getClass();
        str.getClass();
        return g0Var;
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p openReadOnly(g0 g0Var) {
        g0Var.getClass();
        return this.delegate.openReadOnly(onPathParameter(g0Var, "openReadOnly", "file"));
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p openReadWrite(g0 g0Var, boolean z, boolean z2) {
        g0Var.getClass();
        return this.delegate.openReadWrite(onPathParameter(g0Var, "openReadWrite", "file"), z, z2);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public p0 sink(g0 g0Var, boolean z) {
        g0Var.getClass();
        return this.delegate.sink(onPathParameter(g0Var, "sink", "file"), z);
    }

    @Override // com.github.catvod.spider.merge.y0.s
    public r0 source(g0 g0Var) {
        g0Var.getClass();
        return this.delegate.source(onPathParameter(g0Var, "source", "file"));
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
