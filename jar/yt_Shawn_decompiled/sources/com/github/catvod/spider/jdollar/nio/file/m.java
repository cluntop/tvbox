package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import java.io.IOException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m implements TemporalAccessor {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public m(n nVar, Path path, BasicFileAttributes basicFileAttributes, IOException iOException) {
        this.b = nVar;
        this.c = path;
        this.d = basicFileAttributes;
        this.e = iOException;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        com.github.catvod.spider.jdollar.time.chrono.b bVar = (com.github.catvod.spider.jdollar.time.chrono.b) this.b;
        return (bVar == null || !pVar.isDateBased()) ? ((TemporalAccessor) this.c).E(pVar) : bVar.E(pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        com.github.catvod.spider.jdollar.time.chrono.b bVar = (com.github.catvod.spider.jdollar.time.chrono.b) this.b;
        return (bVar == null || !pVar.isDateBased()) ? ((TemporalAccessor) this.c).d(pVar) : bVar.d(pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.time.temporal.q.a(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        com.github.catvod.spider.jdollar.time.chrono.b bVar = (com.github.catvod.spider.jdollar.time.chrono.b) this.b;
        return (bVar == null || !pVar.isDateBased()) ? ((TemporalAccessor) this.c).j(pVar) : bVar.j(pVar);
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 1:
                TemporalAccessor temporalAccessor = (TemporalAccessor) this.c;
                com.github.catvod.spider.jdollar.time.chrono.l lVar = (com.github.catvod.spider.jdollar.time.chrono.l) this.d;
                String str2 = VideoStream.RESOLUTION_UNKNOWN;
                if (lVar != null) {
                    str = " with chronology " + lVar;
                } else {
                    str = VideoStream.RESOLUTION_UNKNOWN;
                }
                ZoneId zoneId = (ZoneId) this.e;
                if (zoneId != null) {
                    str2 = " with zone " + zoneId;
                }
                return temporalAccessor + str + str2;
            default:
                return super.toString();
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == com.github.catvod.spider.jdollar.time.temporal.q.b ? (com.github.catvod.spider.jdollar.time.chrono.l) this.d : mVar == com.github.catvod.spider.jdollar.time.temporal.q.a ? (ZoneId) this.e : mVar == com.github.catvod.spider.jdollar.time.temporal.q.c ? ((TemporalAccessor) this.c).y(mVar) : mVar.f(this);
    }

    public m(com.github.catvod.spider.jdollar.time.chrono.b bVar, TemporalAccessor temporalAccessor, com.github.catvod.spider.jdollar.time.chrono.l lVar, ZoneId zoneId) {
        this.b = bVar;
        this.c = temporalAccessor;
        this.d = lVar;
        this.e = zoneId;
    }
}
