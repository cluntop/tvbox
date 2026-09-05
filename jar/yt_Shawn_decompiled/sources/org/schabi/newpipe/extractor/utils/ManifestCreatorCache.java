package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.github.catvod.spider.merge.q1.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ManifestCreatorCache<K extends Serializable, V extends Serializable> implements Serializable {
    public static final double DEFAULT_CLEAR_FACTOR = 0.75d;
    public static final int DEFAULT_MAXIMUM_SIZE = Integer.MAX_VALUE;
    private int maximumSize = DEFAULT_MAXIMUM_SIZE;
    private double clearFactor = 0.75d;
    private final ConcurrentHashMap<K, Pair<Integer, V>> concurrentHashMap = new ConcurrentHashMap<>();

    private void keepNewestEntries(int i) {
        final int size = this.concurrentHashMap.size() - i;
        final ArrayList arrayList = new ArrayList();
        Iterable.EL.forEach(this.concurrentHashMap.entrySet(), new Consumer() { // from class: org.schabi.newpipe.extractor.utils.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ManifestCreatorCache.lambda$keepNewestEntries$0(size, arrayList, (Map.Entry) obj);
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        Iterable.EL.forEach(arrayList, new w(5, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$keepNewestEntries$0(int i, ArrayList arrayList, Map.Entry entry) {
        Pair pair = (Pair) entry.getValue();
        if (((Integer) pair.getFirst()).intValue() < i) {
            arrayList.add(entry);
        } else {
            pair.setFirst(Integer.valueOf(((Integer) pair.getFirst()).intValue() - i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$keepNewestEntries$1(Map.Entry entry) {
        this.concurrentHashMap.remove(entry.getKey(), entry.getValue());
    }

    public void clear() {
        this.concurrentHashMap.clear();
    }

    public boolean containsKey(K k) {
        return this.concurrentHashMap.containsKey(k);
    }

    public Pair<Integer, V> get(K k) {
        return this.concurrentHashMap.get(k);
    }

    public double getClearFactor() {
        return this.clearFactor;
    }

    public long getMaximumSize() {
        return this.maximumSize;
    }

    public V put(K k, V v) {
        if (!this.concurrentHashMap.containsKey(k)) {
            int size = this.concurrentHashMap.size();
            int i = this.maximumSize;
            if (size == i) {
                int iRound = (int) Math.round(i * this.clearFactor);
                if (iRound == 0) {
                    iRound = 1;
                }
                keepNewestEntries(iRound);
            }
        }
        ConcurrentHashMap<K, Pair<Integer, V>> concurrentHashMap = this.concurrentHashMap;
        Pair<Integer, V> pairPut = concurrentHashMap.put(k, new Pair<>(Integer.valueOf(concurrentHashMap.size()), v));
        if (pairPut == null) {
            return null;
        }
        return (V) pairPut.getSecond();
    }

    public void reset() {
        clear();
        resetClearFactor();
        resetMaximumSize();
    }

    public void resetClearFactor() {
        this.clearFactor = 0.75d;
    }

    public void resetMaximumSize() {
        this.maximumSize = DEFAULT_MAXIMUM_SIZE;
    }

    public void setClearFactor(double d) {
        if (d <= 0.0d || d >= 1.0d) {
            com.github.catvod.spider.merge.s0.a.r("Invalid clear factor");
        } else {
            this.clearFactor = d;
        }
    }

    public void setMaximumSize(int i) {
        if (i <= 0) {
            com.github.catvod.spider.merge.s0.a.r("Invalid maximum size");
            return;
        }
        if (i < this.maximumSize && !this.concurrentHashMap.isEmpty()) {
            int iRound = (int) Math.round(i * this.clearFactor);
            if (iRound == 0) {
                iRound = 1;
            }
            keepNewestEntries(iRound);
        }
        this.maximumSize = i;
    }

    public int size() {
        return this.concurrentHashMap.size();
    }

    public String toString() {
        return "ManifestCreatorCache[clearFactor=" + this.clearFactor + ", maximumSize=" + this.maximumSize + ", concurrentHashMap=" + this.concurrentHashMap + "]";
    }
}
