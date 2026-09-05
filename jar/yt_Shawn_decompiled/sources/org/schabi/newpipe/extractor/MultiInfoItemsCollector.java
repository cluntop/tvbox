package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemsCollector;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MultiInfoItemsCollector extends InfoItemsCollector<InfoItem, InfoItemExtractor> {
    private final PlaylistInfoItemsCollector playlistCollector;
    private final StreamInfoItemsCollector streamCollector;
    private final ChannelInfoItemsCollector userCollector;

    public MultiInfoItemsCollector(int i) {
        super(i);
        this.streamCollector = new StreamInfoItemsCollector(i);
        this.userCollector = new ChannelInfoItemsCollector(i);
        this.playlistCollector = new PlaylistInfoItemsCollector(i);
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public InfoItem extract(InfoItemExtractor infoItemExtractor) {
        if (infoItemExtractor instanceof StreamInfoItemExtractor) {
            return this.streamCollector.extract((StreamInfoItemExtractor) infoItemExtractor);
        }
        if (infoItemExtractor instanceof ChannelInfoItemExtractor) {
            return this.userCollector.extract((ChannelInfoItemExtractor) infoItemExtractor);
        }
        if (infoItemExtractor instanceof PlaylistInfoItemExtractor) {
            return this.playlistCollector.extract((PlaylistInfoItemExtractor) infoItemExtractor);
        }
        com.github.catvod.spider.merge.b0.a.j("Invalid extractor type: ", infoItemExtractor);
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemsCollector, org.schabi.newpipe.extractor.Collector
    public List<Throwable> getErrors() {
        ArrayList arrayList = new ArrayList(super.getErrors());
        arrayList.addAll(this.streamCollector.getErrors());
        arrayList.addAll(this.userCollector.getErrors());
        arrayList.addAll(this.playlistCollector.getErrors());
        return DesugarCollections.unmodifiableList(arrayList);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemsCollector, org.schabi.newpipe.extractor.Collector
    public void reset() {
        super.reset();
        this.streamCollector.reset();
        this.userCollector.reset();
        this.playlistCollector.reset();
    }
}
