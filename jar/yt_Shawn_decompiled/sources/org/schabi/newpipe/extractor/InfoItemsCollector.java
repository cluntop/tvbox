package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.FoundAdException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class InfoItemsCollector<I extends InfoItem, E extends InfoItemExtractor> implements Collector<I, E> {
    private final Comparator<I> comparator;
    private final List<Throwable> errors;
    private final List<I> itemList;
    private final int serviceId;

    public InfoItemsCollector(int i, Comparator<I> comparator) {
        this.itemList = new ArrayList();
        this.errors = new ArrayList();
        this.serviceId = i;
        this.comparator = comparator;
    }

    public void addError(Exception exc) {
        this.errors.add(exc);
    }

    public void addItem(I i) {
        this.itemList.add(i);
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public void commit(E e) {
        try {
            addItem(extract(e));
        } catch (FoundAdException unused) {
        } catch (ParsingException e2) {
            addError(e2);
        }
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public List<Throwable> getErrors() {
        return DesugarCollections.unmodifiableList(this.errors);
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public List<I> getItems() {
        Comparator<I> comparator = this.comparator;
        if (comparator != null) {
            List.EL.sort(this.itemList, comparator);
        }
        return DesugarCollections.unmodifiableList(this.itemList);
    }

    public int getServiceId() {
        return this.serviceId;
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public void reset() {
        this.itemList.clear();
        this.errors.clear();
    }

    public InfoItemsCollector(int i) {
        this(i, null);
    }
}
